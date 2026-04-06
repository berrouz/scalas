package org.shev4ik.interview.doobie.level3_advanced

/**
 * Doobie 015 - Patterns (Repository, DAO, typeclass-based persistence)
 *
 * Common patterns for structuring database access in Scala:
 * - Repository pattern: abstraction over data access, often generic
 * - DAO pattern: Data Access Object, table-specific operations
 * - Typeclass-based persistence: generic CRUD via type classes
 *
 * Here we implement these patterns with simplified in-memory storage
 * to understand the design principles behind production doobie code.
 */
object Doob015_Patterns {

  type Row = Map[String, Any]

  // Simplified in-memory store
  class InMemoryStore {
    private var tables: Map[String, List[Row]] = Map.empty

    def getTable(name: String): List[Row] = tables.getOrElse(name, Nil)
    def setTable(name: String, rows: List[Row]): Unit = { tables = tables + (name -> rows) }

    def insert(table: String, row: Row): Unit = {
      tables = tables + (table -> (getTable(table) :+ row))
    }

    def update(table: String, predicate: Row => Boolean, transform: Row => Row): Int = {
      val current = getTable(table)
      val (matching, rest) = current.partition(predicate)
      tables = tables + (table -> (rest ++ matching.map(transform)))
      matching.size
    }

    def delete(table: String, predicate: Row => Boolean): Int = {
      val current = getTable(table)
      val (matching, rest) = current.partition(predicate)
      tables = tables + (table -> rest)
      matching.size
    }

    def reset(): Unit = { tables = Map.empty }
  }

  // Domain types
  case class User(id: Int, name: String, email: String)
  case class Product(id: Int, name: String, price: Double)
  case class Order(id: Int, userId: Int, productId: Int, quantity: Int)

  // -------------------------------------------------------------------------
  // Exercise 1: Define a generic Repository trait with CRUD operations.
  // TODO: Create trait Repository[A, ID] with methods:
  //   findById(id: ID): Option[A]
  //   findAll: List[A]
  //   insert(entity: A): Unit
  //   update(entity: A): Boolean
  //   delete(id: ID): Boolean
  // -------------------------------------------------------------------------
  trait Repository[A, ID] {
    def findById(id: ID): Option[A] = ???
    def findAll: List[A] = ???
    def insert(entity: A): Unit = ???
    def update(entity: A): Boolean = ???
    def delete(id: ID): Boolean = ???
  }

  // -------------------------------------------------------------------------
  // Exercise 2: Implement UserRepository extending Repository[User, Int].
  // TODO: Use InMemoryStore with "users" table. Map User to/from Row.
  // -------------------------------------------------------------------------
  class UserRepository(store: InMemoryStore) extends Repository[User, Int] {
    private val tableName = "users"

    override def findById(id: Int): Option[User] = ???
    override def findAll: List[User] = ???
    override def insert(entity: User): Unit = ???
    override def update(entity: User): Boolean = ???
    override def delete(id: Int): Boolean = ???
  }

  // -------------------------------------------------------------------------
  // Exercise 3: Define a typeclass for entity-to-row conversion.
  // TODO: Create trait Persistable[A] with:
  //   tableName: String
  //   toRow(a: A): Row
  //   fromRow(row: Row): A
  //   idColumn: String
  //   getId(a: A): Any
  // -------------------------------------------------------------------------
  trait Persistable[A] {
    def tableName: String = ???
    def toRow(a: A): Row = ???
    def fromRow(row: Row): A = ???
    def idColumn: String = ???
    def getId(a: A): Any = ???
  }

  // -------------------------------------------------------------------------
  // Exercise 4: Create Persistable instances for User and Product.
  // TODO: Implement Persistable[User] and Persistable[Product].
  // -------------------------------------------------------------------------
  implicit val userPersistable: Persistable[User] = ???
  implicit val productPersistable: Persistable[Product] = ???

  // -------------------------------------------------------------------------
  // Exercise 5: Implement a generic DAO using the Persistable typeclass.
  // TODO: Create GenericDAO[A] that uses Persistable[A] and InMemoryStore
  // to provide CRUD operations generically.
  // -------------------------------------------------------------------------
  class GenericDAO[A](store: InMemoryStore)(implicit P: Persistable[A]) {
    def findById(id: Any): Option[A] = ???
    def findAll: List[A] = ???
    def insert(entity: A): Unit = ???
    def update(entity: A): Boolean = ???
    def delete(id: Any): Boolean = ???
  }

  // -------------------------------------------------------------------------
  // Exercise 6: Implement a query builder pattern for the repository.
  // TODO: Create a fluent QueryBuilder that supports:
  //   .from(table) .where(column, value) .orderBy(column) .limit(n) .execute()
  // It should filter, sort, and limit results from InMemoryStore.
  // -------------------------------------------------------------------------
  class QueryBuilder(store: InMemoryStore) {
    private var tableName: String = ""
    private var filters: List[(String, Any)] = Nil
    private var sortColumn: Option[String] = None
    private var limitN: Option[Int] = None

    def from(table: String): QueryBuilder = ???
    def where(column: String, value: Any): QueryBuilder = ???
    def orderBy(column: String): QueryBuilder = ???
    def limit(n: Int): QueryBuilder = ???
    def execute(): List[Row] = ???
  }

  // -------------------------------------------------------------------------
  // Exercise 7: Implement a Unit-of-Work pattern.
  // TODO: Create UnitOfWork that batches operations and applies them
  // atomically. Support: registerInsert, registerUpdate, registerDelete.
  // commit() applies all registered operations. rollback() clears them.
  // Return the number of operations applied on commit.
  // -------------------------------------------------------------------------
  class UnitOfWork(store: InMemoryStore) {
    private var operations: List[() => Unit] = Nil

    def registerInsert(table: String, row: Row): Unit = ???
    def registerUpdate(table: String, predicate: Row => Boolean, transform: Row => Row): Unit = ???
    def registerDelete(table: String, predicate: Row => Boolean): Unit = ???
    def commit(): Int = ???
    def rollback(): Unit = ???
  }

  // -------------------------------------------------------------------------
  // Exercise 8: Implement a specification pattern for complex queries.
  // TODO: Create trait Specification[A] with isSatisfiedBy(a: A): Boolean.
  // Implement And, Or, Not combinators. Use with repository filtering.
  // -------------------------------------------------------------------------
  trait Specification[A] {
    def isSatisfiedBy(a: A): Boolean
    def and(other: Specification[A]): Specification[A] = ???
    def or(other: Specification[A]): Specification[A] = ???
    def not: Specification[A] = ???
  }

  // Concrete specifications for User
  def exercise8_nameEquals(name: String): Specification[User] = ???
  def exercise8_emailContains(domain: String): Specification[User] = ???

  def main(args: Array[String]): Unit = {
    val store = new InMemoryStore

    // Exercise 2
    val userRepo = new UserRepository(store)
    userRepo.insert(User(1, "Alice", "alice@example.com"))
    userRepo.insert(User(2, "Bob", "bob@example.com"))
    assert(userRepo.findAll.size == 2)
    assert(userRepo.findById(1) == Some(User(1, "Alice", "alice@example.com")))
    assert(userRepo.findById(99) == None)
    assert(userRepo.update(User(1, "Alice Updated", "alice@new.com")))
    assert(userRepo.findById(1).exists(_.name == "Alice Updated"))
    assert(userRepo.delete(2))
    assert(userRepo.findAll.size == 1)
    println("Exercise 2 passed: UserRepository")

    // Exercise 4 & 5
    store.reset()
    val userDao = new GenericDAO[User](store)
    userDao.insert(User(1, "Alice", "alice@example.com"))
    userDao.insert(User(2, "Bob", "bob@example.com"))
    assert(userDao.findAll.size == 2)
    assert(userDao.findById(1) == Some(User(1, "Alice", "alice@example.com")))
    assert(userDao.delete(2))
    assert(userDao.findAll.size == 1)
    println("Exercise 4 & 5 passed: GenericDAO with Persistable")

    val productDao = new GenericDAO[Product](store)
    productDao.insert(Product(1, "Widget", 9.99))
    productDao.insert(Product(2, "Gadget", 19.99))
    assert(productDao.findAll.size == 2)
    assert(productDao.findById(1).exists(_.name == "Widget"))
    println("Exercise 4 & 5 passed: GenericDAO[Product]")

    // Exercise 6
    store.reset()
    store.insert("items", Map("id" -> 1, "name" -> "Apple", "price" -> 1.0))
    store.insert("items", Map("id" -> 2, "name" -> "Banana", "price" -> 0.5))
    store.insert("items", Map("id" -> 3, "name" -> "Apple", "price" -> 1.5))
    val qb = new QueryBuilder(store)
    val results = qb.from("items").where("name", "Apple").execute()
    assert(results.size == 2)
    val limited = new QueryBuilder(store).from("items").limit(2).execute()
    assert(limited.size == 2)
    println("Exercise 6 passed: QueryBuilder")

    // Exercise 7
    store.reset()
    store.setTable("data", Nil)
    val uow = new UnitOfWork(store)
    uow.registerInsert("data", Map("id" -> 1, "value" -> "a"))
    uow.registerInsert("data", Map("id" -> 2, "value" -> "b"))
    uow.registerInsert("data", Map("id" -> 3, "value" -> "c"))
    assert(store.getTable("data").isEmpty) // not committed yet
    val applied = uow.commit()
    assert(applied == 3)
    assert(store.getTable("data").size == 3)
    println("Exercise 7 passed: Unit of Work")

    // Exercise 8
    val spec1 = exercise8_nameEquals("Alice")
    val spec2 = exercise8_emailContains("example.com")
    assert(spec1.isSatisfiedBy(User(1, "Alice", "alice@example.com")))
    assert(!spec1.isSatisfiedBy(User(2, "Bob", "bob@example.com")))
    assert(spec2.isSatisfiedBy(User(1, "Alice", "alice@example.com")))

    val combined = spec1.and(spec2)
    assert(combined.isSatisfiedBy(User(1, "Alice", "alice@example.com")))
    assert(!combined.isSatisfiedBy(User(2, "Alice", "alice@other.org")))

    val negated = spec1.not
    assert(!negated.isSatisfiedBy(User(1, "Alice", "alice@example.com")))
    assert(negated.isSatisfiedBy(User(2, "Bob", "bob@example.com")))

    val either = spec1.or(exercise8_nameEquals("Bob"))
    assert(either.isSatisfiedBy(User(1, "Alice", "a@b.com")))
    assert(either.isSatisfiedBy(User(2, "Bob", "b@b.com")))
    assert(!either.isSatisfiedBy(User(3, "Charlie", "c@c.com")))
    println("Exercise 8 passed: Specification pattern")

    println("\nAll Doob015_Patterns exercises passed!")
  }
}
