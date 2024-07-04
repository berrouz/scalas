package org.shev4ik.advanced.scala2.macros

import scala.reflect.macros.blackbox
import scala.language.experimental.macros


object MacrosApp {

  def printType[T](x: T): Unit = macro printTypeImpl[T]


  def printTypeImpl[T: c.WeakTypeTag](c: blackbox.Context)(x: c.Expr[T]): c.Expr[Unit] = {
    import c.universe._

    val tpe = weakTypeOf[T]

    val fields = tpe.decls.collect {
      case m: MethodSymbol if m.isCaseAccessor => m
    }

    c.Expr[Unit](q"println(${tpe.toString})")

  }


}
