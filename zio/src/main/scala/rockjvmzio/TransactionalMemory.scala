package rockjvmzio

import main.scala.rockjvmzio.utils.ZioThreadUtils.ThreadUtils
import main.scala.rockjvmzio.utils.ZioThreadUtils.ThreadUtilsUSTM
import zio.stm.{STM, TRef, USTM, ZSTM}
import zio.{Ref, Scope, ZIO, ZIOAppArgs, ZIOAppDefault}

object TransactionalMemory extends ZIOAppDefault {

  val anZSTM: ZSTM[Any, Nothing, Int] = ZSTM.succeed(2)

  val aFailed                              = ZSTM.fail("something error")
  val anAttempt: ZSTM[Any, Throwable, Int] = ZSTM.attempt(42 / 0)

  val ustm: USTM[Int] = ZSTM.succeed(42)

  val atomicEffect: ZIO[Any, Throwable, Int] = anAttempt.commit

  def transferMoney(sender: Ref[Long], receiver: Ref[Long], amount: Long): ZIO[Any, String, Long] =
    for {
      senderBalance <- sender.get
      _             <- ZIO.fail("Transfer failed. Insufficient funds").when(senderBalance < amount)
      _             <- sender.update(_ - amount)
      _             <- receiver.update(_ + amount)
      newBalance    <- sender.get
    } yield newBalance


  def transferMoneyCorrect(sender: TRef[Long], receiver: TRef[Long], amount: Long): STM[String, Long] =
    for {
      senderBalance <- sender.get
      _             <- ZSTM.fail("Transfer failed. Insufficient funds").when(senderBalance < amount)
      _             <- sender.update(_ - amount)
      _             <- receiver.update(_ + amount)
      newBalance    <- sender.get
    } yield newBalance

  def exploitBuggyBank() = for {
    sender   <- Ref.make(1000L)
    receiver <- Ref.make(0L)
    fib1     <- transferMoney(sender, receiver, 1000).fork
    fib2     <- transferMoney(sender, receiver, 1000).fork
    _        <- (fib1 zip fib2).join
    _        <- receiver.get.debugT
    _        <- sender.get.debugT
  } yield ()

  def correctBank(): ZIO[Any, String, Unit] = for {
    sender   <- TRef.make(1000L).commit
    receiver <- TRef.make(0L).commit
    fib1     <- transferMoneyCorrect(sender, receiver, 1000).commit.fork
    fib2     <- transferMoneyCorrect(sender, receiver, 1000).commit.fork
    _        <- (fib1 zip fib2).join
    _        <- receiver.get.debugT.commit
    _        <- sender.get.debugT.commit
  } yield ()

  override def run: ZIO[Any with ZIOAppArgs with Scope, Any, Any] = {
    correctBank
  }

}
