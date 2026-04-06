package org.shev4ik.interview.system_design.level3_advanced

object SysDes010_DistributedLock {

  // ---- Domain types ----

  case class LockEntry(
    resource: String,
    owner: String,
    fencingToken: Long = 0L,
    expiresAt: Long = Long.MaxValue,
    reentrantCount: Int = 1
  )

  // ---- Exercise 1 ----
  // TODO: Implement a simple lock.
  // - `acquire(locks, resource, owner)`: if resource is not locked, add lock entry.
  //   Return (updatedLocks, acquired: Boolean)
  // - `release(locks, resource, owner)`: if resource is locked by this owner, remove it.
  //   Return (updatedLocks, released: Boolean)
  // - `isLocked(locks, resource)`: check if resource is currently locked
  def acquire(
    locks: Map[String, LockEntry],
    resource: String,
    owner: String
  ): (Map[String, LockEntry], Boolean) = ???

  def release(
    locks: Map[String, LockEntry],
    resource: String,
    owner: String
  ): (Map[String, LockEntry], Boolean) = ???

  def isLocked(locks: Map[String, LockEntry], resource: String): Boolean = ???

  // ---- Exercise 2 ----
  // TODO: Implement a reentrant lock.
  // The same owner can acquire the same lock multiple times (incrementing reentrantCount).
  // Release decrements the count; lock is freed when count reaches 0.
  // Different owners are still blocked.
  def acquireReentrant(
    locks: Map[String, LockEntry],
    resource: String,
    owner: String
  ): (Map[String, LockEntry], Boolean) = ???

  def releaseReentrant(
    locks: Map[String, LockEntry],
    resource: String,
    owner: String
  ): (Map[String, LockEntry], Boolean) = ???

  // ---- Exercise 3 ----
  // TODO: Implement a distributed lock concept.
  // Simulate N lock nodes. A lock is considered acquired if a majority (> N/2) of nodes grant it.
  // `tryAcquireDistributed(nodes, resource, owner)`:
  //   - For each node (Map[String, LockEntry]), try to acquire.
  //   - If majority acquired, keep those locks. Otherwise release all acquired locks.
  //   - Return (updatedNodes, acquired: Boolean)
  def tryAcquireDistributed(
    nodes: List[Map[String, LockEntry]],
    resource: String,
    owner: String
  ): (List[Map[String, LockEntry]], Boolean) = ???

  // ---- Exercise 4 ----
  // TODO: Implement lock with TTL (time-to-live).
  // Locks expire after a given duration. An expired lock can be acquired by anyone.
  // `acquireWithTTL(locks, resource, owner, currentTime, ttlMs)`:
  //   - If lock exists and not expired, block.
  //   - If lock exists but expired, override it.
  //   - Return (updatedLocks, acquired)
  // `cleanupExpired(locks, currentTime)`: remove all expired locks.
  def acquireWithTTL(
    locks: Map[String, LockEntry],
    resource: String,
    owner: String,
    currentTime: Long,
    ttlMs: Long
  ): (Map[String, LockEntry], Boolean) = ???

  def cleanupExpired(locks: Map[String, LockEntry], currentTime: Long): Map[String, LockEntry] = ???

  // ---- Exercise 5 ----
  // TODO: Implement fencing tokens.
  // Each lock acquisition gets a monotonically increasing fencing token.
  // The token prevents stale lock holders from performing operations.
  // `acquireWithFencing(locks, tokenCounter, resource, owner)`:
  //   - Acquire the lock with a new fencing token (tokenCounter + 1)
  //   - Return (updatedLocks, newTokenCounter, Option[fencingToken])
  // `validateFencing(locks, resource, token)`: check if the given token
  //   matches the current lock's fencing token. Returns Boolean.
  def acquireWithFencing(
    locks: Map[String, LockEntry],
    tokenCounter: Long,
    resource: String,
    owner: String
  ): (Map[String, LockEntry], Long, Option[Long]) = ???

  def validateFencing(locks: Map[String, LockEntry], resource: String, token: Long): Boolean = ???

  // ---- Exercise 6 ----
  // TODO: Implement lock renewal (extend TTL).
  // `renewLock(locks, resource, owner, currentTime, extensionMs)`:
  //   - If resource is locked by this owner and not expired, extend expiresAt.
  //   - Return (updatedLocks, renewed: Boolean)
  def renewLock(
    locks: Map[String, LockEntry],
    resource: String,
    owner: String,
    currentTime: Long,
    extensionMs: Long
  ): (Map[String, LockEntry], Boolean) = ???

  // ---- Exercise 7 ----
  // TODO: Implement try-lock with timeout.
  // Simulate attempting to acquire a lock with a timeout.
  // Given a list of (attemptTime, lockAvailable) representing check attempts,
  // determine if the lock was acquired within the timeout.
  // `tryLockWithTimeout(attempts, timeoutMs)`:
  //   - Process attempts in order. If lockAvailable is true, return (true, attemptTime).
  //   - If attemptTime > timeoutMs and no success yet, return (false, timeoutMs).
  def tryLockWithTimeout(
    attempts: List[(Long, Boolean)],
    timeoutMs: Long
  ): (Boolean, Long) = ???

  // ---- Exercise 8 ----
  // TODO: Implement a read-write lock.
  // Multiple readers can hold the lock simultaneously, but writers need exclusive access.
  // State: (readers: Set[String], writer: Option[String])
  // `acquireRead(state, owner)`: succeed if no writer holds the lock
  // `acquireWrite(state, owner)`: succeed if no readers and no other writer
  // `releaseRead(state, owner)`: remove from readers
  // `releaseWrite(state, owner)`: clear writer
  case class RWLockState(readers: Set[String] = Set.empty, writer: Option[String] = None)

  def acquireRead(state: RWLockState, owner: String): (RWLockState, Boolean) = ???

  def acquireWrite(state: RWLockState, owner: String): (RWLockState, Boolean) = ???

  def releaseRead(state: RWLockState, owner: String): (RWLockState, Boolean) = ???

  def releaseWrite(state: RWLockState, owner: String): (RWLockState, Boolean) = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: Simple Lock
    val (l1, a1) = acquire(Map.empty, "res1", "owner1")
    assert(a1)
    assert(isLocked(l1, "res1"))
    val (_, a2) = acquire(l1, "res1", "owner2")
    assert(!a2) // already locked
    val (l3, r3) = release(l1, "res1", "owner1")
    assert(r3)
    assert(!isLocked(l3, "res1"))
    println("Exercise 1 passed: Simple Lock")

    // Exercise 2: Reentrant Lock
    val (rl1, ra1) = acquireReentrant(Map.empty, "res1", "owner1")
    assert(ra1)
    val (rl2, ra2) = acquireReentrant(rl1, "res1", "owner1") // same owner
    assert(ra2)
    assert(rl2("res1").reentrantCount == 2)
    val (rl3, _) = releaseReentrant(rl2, "res1", "owner1")
    assert(isLocked(rl3, "res1")) // still locked (count=1)
    val (rl4, _) = releaseReentrant(rl3, "res1", "owner1")
    assert(!isLocked(rl4, "res1")) // now freed
    println("Exercise 2 passed: Reentrant Lock")

    // Exercise 3: Distributed Lock
    val nodes3 = List(Map.empty[String, LockEntry], Map.empty[String, LockEntry], Map.empty[String, LockEntry])
    val (dn1, da1) = tryAcquireDistributed(nodes3, "res1", "owner1")
    assert(da1) // majority acquired (3/3)
    println("Exercise 3 passed: Distributed Lock")

    // Exercise 4: Lock with TTL
    val (tl1, ta1) = acquireWithTTL(Map.empty, "res1", "owner1", 100, 500)
    assert(ta1)
    val (_, ta2) = acquireWithTTL(tl1, "res1", "owner2", 200, 500)
    assert(!ta2) // not expired
    val (tl3, ta3) = acquireWithTTL(tl1, "res1", "owner2", 700, 500)
    assert(ta3) // expired, owner2 can take it
    val cleaned = cleanupExpired(tl1, 700)
    assert(cleaned.isEmpty)
    println("Exercise 4 passed: Lock with TTL")

    // Exercise 5: Fencing Tokens
    val (fl1, fc1, ft1) = acquireWithFencing(Map.empty, 0, "res1", "owner1")
    assert(ft1.contains(1L))
    assert(validateFencing(fl1, "res1", 1L))
    assert(!validateFencing(fl1, "res1", 0L)) // stale token
    println("Exercise 5 passed: Fencing Tokens")

    // Exercise 6: Lock Renewal
    val ttlLock = Map("res1" -> LockEntry("res1", "owner1", expiresAt = 500))
    val (ren1, renewed1) = renewLock(ttlLock, "res1", "owner1", 300, 400)
    assert(renewed1)
    assert(ren1("res1").expiresAt == 700) // 300 + 400
    val (_, renewed2) = renewLock(ttlLock, "res1", "owner2", 300, 400)
    assert(!renewed2) // wrong owner
    println("Exercise 6 passed: Lock Renewal")

    // Exercise 7: Try-lock with timeout
    val (success1, time1) = tryLockWithTimeout(List((100, false), (200, false), (300, true)), 500)
    assert(success1 && time1 == 300)
    val (success2, time2) = tryLockWithTimeout(List((100, false), (200, false), (600, false)), 500)
    assert(!success2 && time2 == 500)
    println("Exercise 7 passed: Try-lock with timeout")

    // Exercise 8: Read-Write Lock
    val rw0 = RWLockState()
    val (rw1, ra) = acquireRead(rw0, "r1")
    assert(ra)
    val (rw2, rb) = acquireRead(rw1, "r2")
    assert(rb) // multiple readers OK
    val (_, wa) = acquireWrite(rw2, "w1")
    assert(!wa) // readers present, can't write
    val (rw3, _) = releaseRead(rw2, "r1")
    val (rw4, _) = releaseRead(rw3, "r2")
    val (rw5, wb) = acquireWrite(rw4, "w1")
    assert(wb) // no readers, can write
    val (_, rc) = acquireRead(rw5, "r3")
    assert(!rc) // writer present, can't read
    println("Exercise 8 passed: Read-Write Lock")

    println("All SysDes010_DistributedLock exercises passed!")
  }
}
