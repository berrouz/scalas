import { Question } from '@/types/question';

const questions: Question[] = [
  {
    id: 'scala-patterns-l1-001',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'type classes',
    question: 'What is a type class in Scala?',
    options: [
      'A class that extends a trait to gain new behavior',
      'A pattern that adds behavior to existing types without modifying them',
      'A class defined inside another class',
      'A class with only abstract members',
    ],
    correctAnswer: 1,
    explanation: 'A type class is a pattern that allows you to add new behavior (methods) to existing types without modifying their source code. It is typically implemented using traits and implicit instances in Scala.',
    tags: ['type classes', 'implicits', 'ad-hoc polymorphism'],
  },
  {
    id: 'scala-patterns-l1-002',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'type classes',
    question: 'Which keyword is most commonly used to provide a type class instance in Scala 2?',
    options: ['given', 'implicit', 'override', 'extends'],
    correctAnswer: 1,
    explanation: 'In Scala 2, type class instances are provided using the `implicit` keyword. In Scala 3, the `given` keyword replaced `implicit` for this purpose.',
    codeSnippet: `trait Show[A] {
  def show(a: A): String
}

implicit val intShow: Show[Int] = new Show[Int] {
  def show(a: Int): String = a.toString
}`,
    tags: ['type classes', 'implicits'],
  },
  {
    id: 'scala-patterns-l1-003',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'type classes',
    question: 'What does this code define?',
    options: [
      'A concrete class named Eq',
      'A type class for equality comparison',
      'An abstract class for ordering',
      'A sealed trait hierarchy',
    ],
    correctAnswer: 1,
    explanation: 'This code defines a type class `Eq[A]` with a single abstract method `eqv`. Any type can get an instance of `Eq` by providing an implicit value that implements `eqv`.',
    codeSnippet: `trait Eq[A] {
  def eqv(a: A, b: A): Boolean
}`,
    tags: ['type classes', 'traits'],
  },
  {
    id: 'scala-patterns-l1-004',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'type classes',
    question: 'What is "context bound" syntax in Scala?',
    options: [
      'A way to declare a variable in a for-comprehension',
      'Shorthand for an implicit parameter of a type class',
      'A constraint on class inheritance',
      'A method to bind values to names',
    ],
    correctAnswer: 1,
    explanation: '`[A: Show]` is context bound syntax. It is shorthand for `[A](implicit ev: Show[A])`, meaning the function requires an implicit instance of `Show[A]` to be in scope.',
    codeSnippet: `def print[A: Show](a: A): Unit =
  println(implicitly[Show[A]].show(a))`,
    tags: ['type classes', 'context bounds', 'implicits'],
  },
  {
    id: 'scala-patterns-l1-005',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'type classes',
    question: 'What does `implicitly[T]` do?',
    options: [
      'Creates a new implicit value of type T',
      'Removes an implicit from scope',
      'Summons an implicit value of type T from the current scope',
      'Converts T to an explicit parameter',
    ],
    correctAnswer: 2,
    explanation: '`implicitly[T]` summons (retrieves) an implicit value of type T from the current implicit scope. It is equivalent to `def implicitly[T](implicit ev: T): T = ev`.',
    codeSnippet: `trait Show[A] {
  def show(a: A): String
}

def printIt[A: Show](a: A): Unit = {
  val showInstance = implicitly[Show[A]]
  println(showInstance.show(a))
}`,
    tags: ['type classes', 'implicits', 'implicitly'],
  },
  {
    id: 'scala-patterns-l1-006',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'cake pattern',
    question: 'What is the Cake Pattern primarily used for in Scala?',
    options: [
      'Implementing recursive data structures',
      'Dependency injection using traits and self-type annotations',
      'Creating immutable data classes',
      'Optimizing tail-recursive functions',
    ],
    correctAnswer: 1,
    explanation: 'The Cake Pattern is a Scala-specific approach to dependency injection. It uses traits (called "components") with self-type annotations to declare dependencies between modules without using a DI framework.',
    tags: ['cake pattern', 'dependency injection', 'self-types'],
  },
  {
    id: 'scala-patterns-l1-007',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'cake pattern',
    question: 'What does the `this: SomeTrait =>` syntax inside a trait mean?',
    options: [
      'The trait extends SomeTrait',
      'The trait overrides methods from SomeTrait',
      'The trait declares a self-type, requiring the mixing class to also mix in SomeTrait',
      'The trait renames itself to SomeTrait',
    ],
    correctAnswer: 2,
    explanation: 'The `this: SomeTrait =>` is a self-type annotation. It declares that any class mixing in this trait must also mix in SomeTrait, making SomeTrait\'s members available without inheritance.',
    codeSnippet: `trait UserRepositoryComponent {
  val userRepository: UserRepository
}

trait UserServiceComponent {
  this: UserRepositoryComponent =>  // self-type annotation
  val userService: UserService = new UserService(userRepository)
}`,
    tags: ['cake pattern', 'self-types'],
  },
  {
    id: 'scala-patterns-l1-008',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'cake pattern',
    question: 'In the Cake Pattern, what is a "component"?',
    options: [
      'A concrete class implementing a service',
      'A trait that groups a service interface, its implementation, and declares its own dependencies',
      'A companion object with factory methods',
      'A type alias for a tuple of dependencies',
    ],
    correctAnswer: 1,
    explanation: 'In the Cake Pattern, a "component" is a trait that bundles a service trait (interface), its implementation(s), and declares its dependencies via self-type annotations. Components are combined by mixing them into an object.',
    tags: ['cake pattern', 'components', 'dependency injection'],
  },
  {
    id: 'scala-patterns-l1-009',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'cake pattern',
    question: 'How are Cake Pattern components typically assembled?',
    options: [
      'By calling a build() method on each component',
      'By mixing multiple component traits into an object or class',
      'By using a dependency injection framework like Guice',
      'By passing components as constructor parameters',
    ],
    correctAnswer: 1,
    explanation: 'Cake Pattern components are assembled by mixing multiple component traits together into a single object, typically called the "application" or "registry" object. The compiler enforces that all self-type dependencies are satisfied.',
    codeSnippet: `object Application
  extends UserRepositoryComponent
  with UserServiceComponent
  with ConfigComponent`,
    tags: ['cake pattern', 'trait mixing', 'dependency injection'],
  },
  {
    id: 'scala-patterns-l1-010',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'strategy with FP',
    question: 'How is the Strategy pattern typically expressed in functional Scala?',
    options: [
      'By creating a hierarchy of Strategy classes with an execute() method',
      'By passing a function (or lambda) as a parameter to represent the varying algorithm',
      'By using the cake pattern with interchangeable components',
      'By using abstract classes with template methods',
    ],
    correctAnswer: 1,
    explanation: 'In functional Scala, the Strategy pattern is naturally expressed by passing functions as parameters. A function value IS the strategy — no class hierarchy needed. This is simpler and more composable than the OO approach.',
    codeSnippet: `def sort[A](list: List[A], strategy: (A, A) => Boolean): List[A] =
  list.sortWith(strategy)

val ascending = sort(List(3, 1, 2), _ < _)
val descending = sort(List(3, 1, 2), _ > _)`,
    tags: ['strategy pattern', 'higher-order functions', 'FP patterns'],
  },
  {
    id: 'scala-patterns-l1-011',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'strategy with FP',
    question: 'What does a higher-order function have in common with the Strategy pattern?',
    options: [
      'Both require explicit class instantiation',
      'Both allow swapping the algorithm at runtime by accepting a function or object',
      'Both rely on inheritance to vary behavior',
      'Both are only applicable to sorting algorithms',
    ],
    correctAnswer: 1,
    explanation: 'Higher-order functions and the Strategy pattern both allow the algorithm (behavior) to be swapped at call time. A HOF accepts the strategy as a function argument, avoiding the need for a class hierarchy entirely.',
    tags: ['strategy pattern', 'higher-order functions'],
  },
  {
    id: 'scala-patterns-l1-012',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'reader/writer/state',
    question: 'What does the Reader monad represent?',
    options: [
      'A computation that can fail with an error',
      'A computation that reads from a shared environment and produces a value',
      'A computation that accumulates log messages',
      'A computation that maintains mutable state',
    ],
    correctAnswer: 1,
    explanation: 'The Reader monad (also called the Environment monad) represents a computation that depends on some shared read-only environment (config, dependencies). It defers execution until the environment is provided.',
    codeSnippet: `case class Config(host: String, port: Int)

// Reader[Config, String] reads a Config and produces a String
val getHost: Reader[Config, String] = Reader(_.host)`,
    tags: ['reader monad', 'dependency injection', 'FP patterns'],
  },
  {
    id: 'scala-patterns-l1-013',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'reader/writer/state',
    question: 'What does the Writer monad represent?',
    options: [
      'A computation that writes to a file',
      'A computation that produces a value paired with an accumulated log',
      'A computation that modifies shared state',
      'A computation that reads from multiple environments',
    ],
    correctAnswer: 1,
    explanation: 'The Writer monad represents a computation that produces a value along with an accumulated "log" (any monoid, such as a List of strings). It is used for pure logging without side effects.',
    codeSnippet: `import cats.data.Writer

type Logged[A] = Writer[List[String], A]

def addItem(x: Int): Logged[Int] =
  Writer(List(s"Adding $x"), x)`,
    tags: ['writer monad', 'logging', 'FP patterns'],
  },
  {
    id: 'scala-patterns-l1-014',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'reader/writer/state',
    question: 'What does the State monad represent?',
    options: [
      'A computation that reads from an immutable config',
      'A computation that accumulates a log',
      'A computation that threads mutable state through a pure function',
      'A computation that handles errors',
    ],
    correctAnswer: 2,
    explanation: 'The State monad represents a computation that takes an input state, produces a value, and returns an updated state. It threads state through computations purely, without actual mutation.',
    codeSnippet: `import cats.data.State

val increment: State[Int, Unit] = State.modify(_ + 1)
val getCount: State[Int, Int] = State.get

val program = for {
  _ <- increment
  _ <- increment
  n <- getCount
} yield n
// program.run(0).value == (2, 2)`,
    tags: ['state monad', 'FP patterns', 'stateful computation'],
  },
  {
    id: 'scala-patterns-l1-015',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'lens/optics',
    question: 'What is a Lens in Scala optics?',
    options: [
      'A type alias for a pair of get and set functions on a nested data structure',
      'A class for rendering UI components',
      'A way to focus on and modify a field in a deeply nested immutable structure',
      'A pattern for logging nested data',
    ],
    correctAnswer: 2,
    explanation: 'A Lens is an optic that lets you focus on a specific field within an immutable data structure. It provides `get` (to read the field) and `set`/`modify` (to produce an updated copy) operations, making deeply nested updates concise.',
    tags: ['lens', 'optics', 'immutability'],
  },
  {
    id: 'scala-patterns-l1-016',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'lens/optics',
    question: 'What library is most commonly used for optics in Scala?',
    options: ['Shapeless', 'Monocle', 'Scalaz', 'Akka'],
    correctAnswer: 1,
    explanation: 'Monocle is the most widely used optics library for Scala. It provides Lens, Prism, Optional, Traversal, and other optic types. It integrates well with Cats.',
    codeSnippet: `import monocle.Lens
import monocle.macros.GenLens

case class Address(street: String, city: String)
case class Person(name: String, address: Address)

val cityLens: Lens[Person, String] = GenLens[Person](_.address.city)`,
    tags: ['monocle', 'optics', 'lens'],
  },
  {
    id: 'scala-patterns-l1-017',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'lens/optics',
    question: 'What two operations does every Lens provide?',
    options: [
      'read and write (to a database)',
      'get (to read a field) and set (to produce an updated copy)',
      'map and flatMap',
      'encode and decode',
    ],
    correctAnswer: 1,
    explanation: 'Every Lens provides `get` (extracts the focused value) and `set` (returns a new copy of the whole structure with the focused value replaced). `modify` is derived from these two.',
    codeSnippet: `val lens: Lens[Person, String] = GenLens[Person](_.name)

val person = Person("Alice", Address("Main St", "NYC"))
lens.get(person)         // "Alice"
lens.set("Bob")(person) // Person("Bob", ...)`,
    tags: ['lens', 'optics', 'get', 'set'],
  },
  {
    id: 'scala-patterns-l1-018',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'builder pattern (Scala-style)',
    question: 'What is the idiomatic Scala alternative to the Java Builder pattern for creating complex objects?',
    options: [
      'Using a mutable Builder class with setter methods',
      'Using case classes with named parameters and default values',
      'Using a singleton object with an apply method',
      'Using XML configuration files',
    ],
    correctAnswer: 1,
    explanation: 'In Scala, case classes with named parameters and default values provide a clean, concise alternative to the Java Builder pattern. The `copy` method allows creating modified versions. No separate Builder class is needed.',
    codeSnippet: `case class HttpConfig(
  host: String = "localhost",
  port: Int = 8080,
  timeout: Int = 30,
  ssl: Boolean = false
)

val config = HttpConfig(port = 9090, ssl = true)`,
    tags: ['builder pattern', 'case classes', 'named parameters'],
  },
  {
    id: 'scala-patterns-l1-019',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'builder pattern (Scala-style)',
    question: 'What does the `copy` method on a case class do?',
    options: [
      'Creates a deep clone of the object including all referenced objects',
      'Creates a new instance with some fields changed and others kept the same',
      'Copies the object to a collection',
      'Serializes the object to a byte array',
    ],
    correctAnswer: 1,
    explanation: '`copy` creates a new instance of the case class with specified fields changed while keeping all other fields the same. It enables an immutable builder-like workflow.',
    codeSnippet: `case class Config(host: String, port: Int, ssl: Boolean)

val base = Config("localhost", 8080, false)
val prod = base.copy(host = "example.com", ssl = true)
// prod == Config("example.com", 8080, true)`,
    tags: ['builder pattern', 'case classes', 'copy method'],
  },
  {
    id: 'scala-patterns-l1-020',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'phantom types',
    question: 'What is a phantom type in Scala?',
    options: [
      'A type that exists only at compile time and carries no runtime information',
      'A type used in reflection to find hidden fields',
      'A type that cannot be instantiated',
      'A type that exists only in pattern matching branches',
    ],
    correctAnswer: 0,
    explanation: 'A phantom type is a type parameter that appears in the type signature but is never used in the runtime representation of the value. It carries information only at compile time, enabling compile-time state machines and safety guarantees.',
    codeSnippet: `// Sealed traits as phantom types
sealed trait Open
sealed trait Closed

case class Door[State](label: String)

def open(door: Door[Closed]): Door[Open] = Door(door.label)
def close(door: Door[Open]): Door[Closed] = Door(door.label)
// Cannot call open(door) if door is already Open`,
    tags: ['phantom types', 'compile-time safety', 'type-level programming'],
  },
  {
    id: 'scala-patterns-l1-021',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'phantom types',
    question: 'What is the main benefit of using phantom types?',
    options: [
      'They improve runtime performance by avoiding boxing',
      'They enforce invariants and state machines at compile time without runtime overhead',
      'They make code easier to serialize to JSON',
      'They allow multiple inheritance of implementation',
    ],
    correctAnswer: 1,
    explanation: 'Phantom types enforce constraints at compile time. Illegal state transitions become type errors, caught by the compiler before the program runs. There is zero runtime overhead since the phantom type carries no data.',
    tags: ['phantom types', 'compile-time safety'],
  },
  {
    id: 'scala-patterns-l1-022',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'refined types',
    question: 'What is the purpose of the Refined library in Scala?',
    options: [
      'To refactor code automatically',
      'To attach compile-time or runtime predicates to types to express constraints',
      'To generate type class instances automatically',
      'To provide a type-safe DSL for SQL queries',
    ],
    correctAnswer: 1,
    explanation: 'The Refined library lets you express constraints (predicates) at the type level. For example, `Refined[Int, Positive]` is a type that can only hold positive integers. Violations are caught at compile time (for literals) or at parse time.',
    codeSnippet: `import eu.timepit.refined._
import eu.timepit.refined.api.Refined
import eu.timepit.refined.numeric.Positive

type PosInt = Int Refined Positive

val x: PosInt = refineMV(5)   // OK at compile time
// val y: PosInt = refineMV(-1) // Compile error!`,
    tags: ['refined types', 'type safety', 'predicates'],
  },
  {
    id: 'scala-patterns-l1-023',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'refined types',
    question: 'What does `refineMV` do in the Refined library?',
    options: [
      'Refines a value at runtime, throwing an exception if the predicate fails',
      'Refines a literal value at compile time, failing compilation if the predicate is not met',
      'Removes a refinement predicate from a type',
      'Maps a function over a refined value',
    ],
    correctAnswer: 1,
    explanation: '`refineMV` (refine macro value) is a macro that checks the predicate at compile time for literal values. If the literal does not satisfy the predicate, the code will not compile. For runtime values, use `refineV` instead.',
    tags: ['refined types', 'macros', 'compile-time'],
  },
  {
    id: 'scala-patterns-l1-024',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'interpreter pattern',
    question: 'What is the Interpreter pattern?',
    options: [
      'A pattern for running Scala code at runtime via reflection',
      'A pattern that separates a program description (AST) from its execution (interpreter)',
      'A pattern for parsing XML documents',
      'A pattern for implementing scripting languages',
    ],
    correctAnswer: 1,
    explanation: 'The Interpreter pattern separates WHAT a program does (the description, often an AST or algebra) from HOW it does it (the interpreter/executor). This allows multiple interpreters (e.g., real, test, logging) for the same description.',
    tags: ['interpreter pattern', 'AST', 'FP patterns'],
  },
  {
    id: 'scala-patterns-l1-025',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'interpreter pattern',
    question: 'In a simple interpreter pattern using sealed traits, what role does pattern matching play?',
    options: [
      'It generates bytecode for each instruction',
      'It dispatches to the correct interpretation logic for each instruction type',
      'It checks the predicate on refined types',
      'It resolves implicit type class instances',
    ],
    correctAnswer: 1,
    explanation: 'Pattern matching on the sealed trait (ADT) allows the interpreter to dispatch to the correct logic for each instruction or expression type. The sealed nature ensures exhaustive matching.',
    codeSnippet: `sealed trait Expr
case class Num(n: Int) extends Expr
case class Add(a: Expr, b: Expr) extends Expr

def eval(expr: Expr): Int = expr match {
  case Num(n)    => n
  case Add(a, b) => eval(a) + eval(b)
}`,
    tags: ['interpreter pattern', 'pattern matching', 'ADT'],
  },
  {
    id: 'scala-patterns-l1-026',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'free monads',
    question: 'What problem do Free monads solve?',
    options: [
      'They solve the N+1 query problem in databases',
      'They let you define a DSL as an ADT and choose the interpretation (effect) separately',
      'They provide stack-safe recursion for all recursive functions',
      'They automatically derive JSON codecs for case classes',
    ],
    correctAnswer: 1,
    explanation: 'Free monads allow you to describe computations as a data structure (ADT), separating the description from the execution. You can then write multiple interpreters (production, test, logging) without changing the program description.',
    tags: ['free monads', 'DSL', 'interpreter pattern'],
  },
  {
    id: 'scala-patterns-l1-027',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'free monads',
    question: 'What does `Free.liftF` do when building a Free monad DSL?',
    options: [
      'It lifts a value into the Free monad as a pure value',
      'It lifts a functor instruction into the Free monad, wrapping it for sequencing',
      'It runs the Free monad with a given interpreter',
      'It folds the Free monad into a value',
    ],
    correctAnswer: 1,
    explanation: '`Free.liftF` wraps a single instruction (an algebra operation) into the Free monad, making it a monadic value that can be composed with other operations via `flatMap` in for-comprehensions.',
    codeSnippet: `import cats.free.Free

sealed trait ConsoleOp[A]
case class Print(msg: String) extends ConsoleOp[Unit]
case object ReadLine extends ConsoleOp[String]

type Console[A] = Free[ConsoleOp, A]

def print(msg: String): Console[Unit] = Free.liftF(Print(msg))
def readLine: Console[String] = Free.liftF(ReadLine)`,
    tags: ['free monads', 'liftF', 'DSL'],
  },
  {
    id: 'scala-patterns-l1-028',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'tagless final',
    question: 'What is the tagless final pattern?',
    options: [
      'A pattern for defining interfaces using abstract type members instead of type parameters',
      'A pattern for defining algebras as type-parameterized traits (with a higher-kinded type F[_]) that can be interpreted in different effect types',
      'A pattern for removing type tags from a union type',
      'A pattern for finalizing sealed trait hierarchies',
    ],
    correctAnswer: 1,
    explanation: 'Tagless final defines your algebra as a trait parameterized by a higher-kinded type `F[_]`. Interpreters provide concrete implementations (e.g., `F = IO`, `F = Id` for tests). This avoids the overhead of Free monads while keeping the same separation of concerns.',
    codeSnippet: `trait Console[F[_]] {
  def print(msg: String): F[Unit]
  def readLine: F[String]
}`,
    tags: ['tagless final', 'higher-kinded types', 'algebras'],
  },
  {
    id: 'scala-patterns-l1-029',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'tagless final',
    question: 'In tagless final, what does `F[_]` represent?',
    options: [
      'A function that takes no arguments',
      'A type constructor (effect type) that wraps the result of each operation',
      'A phantom type for compile-time checks',
      'A factory for creating type class instances',
    ],
    correctAnswer: 1,
    explanation: '`F[_]` is a type constructor (higher-kinded type) representing the effect. Callers can substitute `IO`, `Future`, `Option`, or `Id` for `F`. The algebra is written once and interpreted differently depending on the context.',
    tags: ['tagless final', 'higher-kinded types', 'effects'],
  },
  {
    id: 'scala-patterns-l1-030',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'tagless final',
    question: 'What is a common advantage of tagless final over Free monads?',
    options: [
      'Tagless final requires no type class constraints at all',
      'Tagless final avoids the overhead of building and folding an AST at runtime',
      'Tagless final is easier to implement in Java',
      'Tagless final does not require higher-kinded types',
    ],
    correctAnswer: 1,
    explanation: 'Free monads build an in-memory AST and then fold over it, incurring allocation overhead. Tagless final uses regular method dispatch, so there is no intermediate structure — it is more direct and typically faster.',
    tags: ['tagless final', 'free monads', 'performance'],
  },
  {
    id: 'scala-patterns-l1-031',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'type classes',
    question: 'What is "ad-hoc polymorphism" as enabled by type classes?',
    options: [
      'Polymorphism achieved through class inheritance',
      'Polymorphism that works for types defined after the fact, without modifying them',
      'Polymorphism limited to sealed trait hierarchies',
      'Polymorphism that requires all types to share a common base class',
    ],
    correctAnswer: 1,
    explanation: 'Ad-hoc polymorphism (via type classes) allows you to define behavior for a type retroactively — you can add an instance for a type you did not write and do not own. This is different from subtype polymorphism which requires a shared base class.',
    tags: ['type classes', 'ad-hoc polymorphism'],
  },
  {
    id: 'scala-patterns-l1-032',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'type classes',
    question: 'What is an "instance" of a type class?',
    options: [
      'A runtime object that holds the state for a type class computation',
      'An implicit value that provides the type class implementation for a specific type',
      'A subclass of the type class trait',
      'A type alias for the type class trait',
    ],
    correctAnswer: 1,
    explanation: 'A type class instance is an implicit value (or given in Scala 3) that provides the concrete implementation of the type class for a specific type. For example, `implicit val intShow: Show[Int]` is the instance of `Show` for `Int`.',
    tags: ['type classes', 'instances', 'implicits'],
  },
  {
    id: 'scala-patterns-l1-033',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'reader/writer/state',
    question: 'What is the signature of the Reader monad\'s `run` method?',
    options: [
      'run: A',
      'run(env: R): A',
      'run(state: S): (S, A)',
      'run(): (W, A)',
    ],
    correctAnswer: 1,
    explanation: 'The Reader monad wraps a function `R => A`. Its `run` method (or equivalent) takes the environment `R` and produces the result `A`. This deferred execution is the essence of the Reader monad.',
    codeSnippet: `case class Reader[R, A](run: R => A) {
  def map[B](f: A => B): Reader[R, B] = Reader(r => f(run(r)))
  def flatMap[B](f: A => Reader[R, B]): Reader[R, B] =
    Reader(r => f(run(r)).run(r))
}`,
    tags: ['reader monad', 'environment'],
  },
  {
    id: 'scala-patterns-l1-034',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'lens/optics',
    question: 'What is a Prism in optics?',
    options: [
      'A lens that focuses on a single field in a product type',
      'An optic that focuses on one branch of a sum type (like a sealed trait)',
      'An optic that focuses on all elements of a collection',
      'A lens that composes two lenses together',
    ],
    correctAnswer: 1,
    explanation: 'A Prism is an optic for sum types (sealed traits / ADTs). It lets you optionally focus on one constructor of the ADT. `getOption` returns `Some` if the value matches the branch, `None` otherwise. `reverseGet` constructs the sum type value.',
    codeSnippet: `import monocle.Prism

sealed trait Shape
case class Circle(r: Double) extends Shape
case class Rect(w: Double, h: Double) extends Shape

val circleP = Prism.partial[Shape, Double] {
  case Circle(r) => r
}(Circle.apply)`,
    tags: ['prism', 'optics', 'sum types'],
  },
  {
    id: 'scala-patterns-l1-035',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'lens/optics',
    question: 'How do you compose two lenses in Monocle?',
    options: [
      'Using the `++` operator',
      'Using the `andThen` or `compose` method (or `>>>`)',
      'Using the `flatMap` method',
      'Using the `zip` method',
    ],
    correctAnswer: 1,
    explanation: 'Lenses compose using `andThen` (or `>>>` or `compose`). If you have a lens from A to B and a lens from B to C, composing them gives a lens from A to C, allowing you to focus on deeply nested fields.',
    codeSnippet: `val personToAddress: Lens[Person, Address] = GenLens[Person](_.address)
val addressToCity: Lens[Address, String] = GenLens[Address](_.city)

val personToCity: Lens[Person, String] = personToAddress andThen addressToCity`,
    tags: ['lens', 'optics', 'composition'],
  },
  {
    id: 'scala-patterns-l1-036',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'builder pattern (Scala-style)',
    question: 'What is a fluent builder in Scala?',
    options: [
      'A builder that returns a new copy of itself after each setter call, enabling method chaining',
      'A builder that reads configuration from a YAML file',
      'A builder that uses macros to generate all setter methods',
      'A builder that is implemented using the cake pattern',
    ],
    correctAnswer: 0,
    explanation: 'A fluent builder returns `this` (or a new copy of itself) after each configuration step, enabling method chaining. In Scala, this is often done immutably by returning a new case class instance from each step.',
    codeSnippet: `case class QueryBuilder(
  table: String = "",
  limit: Int = 100,
  offset: Int = 0
) {
  def withTable(t: String): QueryBuilder = copy(table = t)
  def withLimit(l: Int): QueryBuilder = copy(limit = l)
  def withOffset(o: Int): QueryBuilder = copy(offset = o)
}

val q = QueryBuilder()
  .withTable("users")
  .withLimit(50)
  .withOffset(10)`,
    tags: ['builder pattern', 'fluent interface', 'method chaining'],
  },
  {
    id: 'scala-patterns-l1-037',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'type classes',
    question: 'What is the difference between a type class and a regular trait?',
    options: [
      'Type classes can have concrete methods; regular traits cannot',
      'Type class instances are provided implicitly for specific types; a regular trait is implemented via inheritance',
      'Type classes are only available in Scala 3',
      'Regular traits cannot have type parameters; type classes can',
    ],
    correctAnswer: 1,
    explanation: 'A regular trait is extended by a class (inheritance/subtyping). A type class instance is an implicit value provided for a specific type, without requiring that type to extend anything. This enables retroactive extension.',
    tags: ['type classes', 'traits', 'implicits'],
  },
  {
    id: 'scala-patterns-l1-038',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'cake pattern',
    question: 'What is a key limitation of the Cake Pattern?',
    options: [
      'It cannot be used with abstract types',
      'It leads to tight coupling between components because everything is mixed at compile time',
      'It does not support dependency injection',
      'It requires a runtime container like Spring',
    ],
    correctAnswer: 1,
    explanation: 'A key limitation of the Cake Pattern is that all dependencies must be known at compile time, and the assembled object becomes a complex mix of traits. This can lead to a "God object" and makes dynamic reconfiguration impossible.',
    tags: ['cake pattern', 'limitations'],
  },
  {
    id: 'scala-patterns-l1-039',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'interpreter pattern',
    question: 'What Scala feature is most natural for implementing interpreters for ADTs?',
    options: ['Reflection', 'Pattern matching', 'Implicit conversions', 'Macros'],
    correctAnswer: 1,
    explanation: 'Pattern matching on sealed trait hierarchies (ADTs) is the most natural way to implement an interpreter in Scala. The compiler ensures all cases are covered, and each case branch contains the interpretation logic for that instruction.',
    tags: ['interpreter pattern', 'pattern matching', 'ADT'],
  },
  {
    id: 'scala-patterns-l1-040',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'free monads',
    question: 'What is a Natural Transformation (FunctionK) used for with Free monads?',
    options: [
      'To convert a List to a Vector',
      'To define the interpreter that maps each algebra operation to a target effect',
      'To lift a value into a monad',
      'To compose two Free monads together',
    ],
    correctAnswer: 1,
    explanation: 'A Natural Transformation `F ~> G` (FunctionK) converts any `F[A]` to `G[A]` for all A. For Free monads, you provide a `ConsoleOp ~> IO` interpreter and then call `freeProgram.foldMap(interpreter)` to execute it.',
    codeSnippet: `import cats.~>
import cats.effect.IO

val interpreter: ConsoleOp ~> IO = new (ConsoleOp ~> IO) {
  def apply[A](op: ConsoleOp[A]): IO[A] = op match {
    case Print(msg) => IO(println(msg))
    case ReadLine   => IO(scala.io.StdIn.readLine())
  }
}`,
    tags: ['free monads', 'natural transformation', 'FunctionK'],
  },
  {
    id: 'scala-patterns-l1-041',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'tagless final',
    question: 'How is a tagless final program typically executed?',
    options: [
      'By calling .foldMap() with an interpreter',
      'By providing a concrete type class instance for F[_] and calling the methods',
      'By compiling the algebra to bytecode',
      'By running a recursive eval function on the AST',
    ],
    correctAnswer: 1,
    explanation: 'In tagless final, you provide a concrete instance of the algebra trait for a specific `F[_]` (e.g., `IO`). Since the algebra uses regular method dispatch, execution happens naturally when you call `run` on the resulting `IO` value.',
    codeSnippet: `class IOConsole extends Console[IO] {
  def print(msg: String): IO[Unit] = IO(println(msg))
  def readLine: IO[String] = IO(scala.io.StdIn.readLine())
}

def program[F[_]](implicit C: Console[F]): F[Unit] =
  C.print("Hello!")

// Execute by providing concrete implementation:
program[IO](new IOConsole).unsafeRunSync()`,
    tags: ['tagless final', 'execution', 'IO'],
  },
  {
    id: 'scala-patterns-l1-042',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'type classes',
    question: 'Where does Scala look for implicit instances when resolving a type class?',
    options: [
      'Only in the current file',
      'Only in the companion object of the type class trait',
      'In the current scope, then imported scopes, then the companion objects of the type and type class',
      'Only in the object named Implicits',
    ],
    correctAnswer: 2,
    explanation: 'Scala searches for implicits in: 1) local scope, 2) imported scope, 3) the companion object of the type class trait, 4) the companion object of the type argument. This is why instances are often placed in companion objects.',
    tags: ['type classes', 'implicit resolution', 'companion objects'],
  },
  {
    id: 'scala-patterns-l1-043',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'phantom types',
    question: 'Which of the following is a classic use case for phantom types?',
    options: [
      'Implementing recursive data structures',
      'Encoding a state machine where invalid transitions are compile errors',
      'Providing default values for case class fields',
      'Optimizing tail-recursive loops',
    ],
    correctAnswer: 1,
    explanation: 'A classic use case for phantom types is encoding state machines (like a connection that must be Opened before being Queried, and Closed before being discarded). The compiler rejects invalid state transitions at compile time.',
    codeSnippet: `sealed trait Connected
sealed trait Disconnected

class Connection[State] private (url: String)

object Connection {
  def create(url: String): Connection[Disconnected] = new Connection(url)
  def connect(c: Connection[Disconnected]): Connection[Connected] = new Connection(c.toString)
  def query(c: Connection[Connected], sql: String): String = s"Result of $sql"
}`,
    tags: ['phantom types', 'state machine', 'compile-time safety'],
  },
  {
    id: 'scala-patterns-l1-044',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'refined types',
    question: 'What is the difference between `refineMV` and `refineV` in the Refined library?',
    options: [
      'refineMV works on mutable values; refineV works on immutable values',
      'refineMV checks literals at compile time; refineV checks arbitrary values at runtime, returning Either',
      'refineMV is for numeric types; refineV is for string types',
      'refineMV is for Scala 2; refineV is for Scala 3',
    ],
    correctAnswer: 1,
    explanation: '`refineMV` (macro value) checks the predicate at compile time for literals. `refineV` checks at runtime, returning `Either[String, Refined[T, P]]` — `Right` if the predicate holds, `Left` with an error message otherwise.',
    codeSnippet: `import eu.timepit.refined._
import eu.timepit.refined.numeric.Positive

val good: Either[String, Int Refined Positive] = refineV(42)  // Right(42)
val bad: Either[String, Int Refined Positive] = refineV(-1)   // Left("...")`,
    tags: ['refined types', 'refineMV', 'refineV', 'runtime validation'],
  },
  {
    id: 'scala-patterns-l1-045',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'reader/writer/state',
    question: 'What Cats type provides a combination of Reader (environment) and Writer (log) functionality?',
    options: ['StateT', 'ReaderWriterState', 'IorT', 'EitherT'],
    correctAnswer: 1,
    explanation: 'Cats provides `ReaderWriterState[R, W, S, A]` (often aliased as `RWS`) which combines Reader (environment R), Writer (log W), and State (state S) into a single monad.',
    tags: ['reader monad', 'writer monad', 'state monad', 'cats'],
  },
  {
    id: 'scala-patterns-l1-046',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'type classes',
    question: 'What is "implicit evidence" in the context of type classes?',
    options: [
      'A runtime proof that a class implements an interface',
      'A compile-time proof (as an implicit value) that a type satisfies a type class constraint',
      'Documentation generated from implicit values',
      'An annotation on implicit parameters',
    ],
    correctAnswer: 1,
    explanation: 'Implicit evidence is a compile-time proof provided as an implicit value. When a function requires `implicit ev: Show[A]`, the compiler must find this evidence, ensuring at compile time that `A` has a `Show` instance.',
    tags: ['type classes', 'implicit evidence', 'compile-time'],
  },
  {
    id: 'scala-patterns-l1-047',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'cake pattern',
    question: 'What happens at compile time if a self-type dependency is not satisfied in the Cake Pattern?',
    options: [
      'A runtime NullPointerException is thrown',
      'The compiler produces a type error',
      'The missing component is replaced with a default implementation',
      'The program compiles but throws an exception at startup',
    ],
    correctAnswer: 1,
    explanation: 'If a self-type annotation is not satisfied when mixing traits together, the Scala compiler produces a type error. This is one of the main advantages of the Cake Pattern — missing dependencies are caught at compile time.',
    tags: ['cake pattern', 'self-types', 'compile-time safety'],
  },
  {
    id: 'scala-patterns-l1-048',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'lens/optics',
    question: 'What is the `modify` operation on a Lens?',
    options: [
      'It mutates the focused field in place',
      'It applies a function to the focused value and returns an updated copy of the whole structure',
      'It removes the focused field from the structure',
      'It converts the lens to a prism',
    ],
    correctAnswer: 1,
    explanation: '`modify` takes a function `A => A` and applies it to the focused value, returning a new copy of the outer structure with the updated value. It is defined as `def modify(f: A => A)(s: S): S = set(f(get(s)))(s)`.',
    codeSnippet: `val nameLens: Lens[Person, String] = GenLens[Person](_.name)
val upperName: Person => Person = nameLens.modify(_.toUpperCase)
upperName(Person("alice", ...)) // Person("ALICE", ...)`,
    tags: ['lens', 'optics', 'modify'],
  },
  {
    id: 'scala-patterns-l1-049',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'interpreter pattern',
    question: 'What Scala feature makes sealed trait-based interpreters safe with respect to missing cases?',
    options: [
      'The final modifier on sealed traits',
      'The Scala compiler warns or errors on non-exhaustive pattern matches of sealed traits',
      'Sealed traits automatically throw exceptions for unmatched cases',
      'Sealed traits use default cases in pattern matching',
    ],
    correctAnswer: 1,
    explanation: 'When you pattern match on a sealed trait, the Scala compiler checks that all cases are covered. If any subtype is missing from the match, the compiler emits a warning (or error with -Xfatal-warnings), preventing silently unhandled cases.',
    tags: ['interpreter pattern', 'sealed traits', 'exhaustive matching'],
  },
  {
    id: 'scala-patterns-l1-050',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'tagless final',
    question: 'What type class constraint do you often add to `F[_]` in tagless final programs that need sequencing?',
    options: ['Functor[F]', 'Monad[F]', 'Foldable[F]', 'Traverse[F]'],
    correctAnswer: 1,
    explanation: 'Most tagless final programs require `Monad[F]` (or at minimum `Applicative[F]`) to sequence operations with `flatMap` in for-comprehensions. `Functor[F]` only provides `map`, which is not enough for sequential effects.',
    codeSnippet: `def program[F[_]: Monad](console: Console[F]): F[Unit] =
  for {
    _    <- console.print("Enter name: ")
    name <- console.readLine
    _    <- console.print(s"Hello, $name!")
  } yield ()`,
    tags: ['tagless final', 'monad', 'higher-kinded types'],
  },
  {
    id: 'scala-patterns-l1-051',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'type classes',
    question: 'What is "type class derivation"?',
    options: [
      'Manually writing type class instances for every type',
      'Automatically generating type class instances for composite types from instances of their components',
      'Deriving new types from existing types using subclassing',
      'Using reflection to generate type class instances at runtime',
    ],
    correctAnswer: 1,
    explanation: 'Type class derivation automatically creates instances for composed types (like case classes, sealed traits) from instances of their component types. Libraries like Shapeless, Magnolia, or Scala 3\'s `derives` clause support this.',
    codeSnippet: `// Scala 3 automatic derivation
case class Person(name: String, age: Int) derives Show, Eq`,
    tags: ['type classes', 'derivation', 'shapeless'],
  },
  {
    id: 'scala-patterns-l1-052',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'strategy with FP',
    question: 'In Scala, how can you make a Strategy configurable at runtime using type classes?',
    options: [
      'By creating abstract classes with virtual methods',
      'By passing an implicit type class instance that provides the algorithm',
      'By using XML configuration to select the strategy',
      'By using the cake pattern to inject the strategy at compile time only',
    ],
    correctAnswer: 1,
    explanation: 'Type class instances can be selected based on the runtime context by explicitly passing them. While implicit resolution is compile-time, you can have multiple instances and select one dynamically to implement runtime strategy selection.',
    tags: ['strategy pattern', 'type classes', 'FP patterns'],
  },
  {
    id: 'scala-patterns-l1-053',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'refined types',
    question: 'Which refined predicate would you use to ensure a String is non-empty?',
    options: [
      'MinSize[W.`0`.T]',
      'NonEmpty',
      'Size[Greater[W.`0`.T]]',
      'Positive',
    ],
    correctAnswer: 1,
    explanation: 'The `NonEmpty` predicate (from `eu.timepit.refined.collection`) checks that a collection or String is non-empty. `type NonEmptyString = String Refined NonEmpty` is a common type alias.',
    codeSnippet: `import eu.timepit.refined.collection.NonEmpty
import eu.timepit.refined.api.Refined

type NonEmptyString = String Refined NonEmpty

val name: NonEmptyString = refineMV("Alice")
// refineMV("") would be a compile error`,
    tags: ['refined types', 'NonEmpty', 'string constraints'],
  },
  {
    id: 'scala-patterns-l1-054',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'free monads',
    question: 'What is `foldMap` on a Free monad?',
    options: [
      'A method that folds the Free monad into a List',
      'A method that interprets the Free monad by mapping each instruction to a target effect using a natural transformation',
      'A method that combines two Free monad programs',
      'A method that optimizes the Free monad by removing duplicate instructions',
    ],
    correctAnswer: 1,
    explanation: '`foldMap` takes a natural transformation `F ~> G` (where G is a monad) and interprets the Free program by replacing each `F` instruction with its `G` equivalent, then sequencing all the effects.',
    codeSnippet: `val result: IO[Unit] = myFreeProgram.foldMap(interpreter)
result.unsafeRunSync()`,
    tags: ['free monads', 'foldMap', 'interpretation'],
  },
  {
    id: 'scala-patterns-l1-055',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'reader/writer/state',
    question: 'What constraint must the log type W satisfy in the Writer monad?',
    options: [
      'W must be a Functor',
      'W must be a Monoid (have an empty element and a combine operation)',
      'W must be an Eq',
      'W must be a Traversable',
    ],
    correctAnswer: 1,
    explanation: 'The Writer monad needs to combine logs from sequential operations. This requires W to be a Monoid — `empty` provides the initial log, and `combine` (++) appends logs together when sequencing with `flatMap`.',
    tags: ['writer monad', 'monoid', 'FP patterns'],
  },
  {
    id: 'scala-patterns-l1-056',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'lens/optics',
    question: 'What is an Optional optic?',
    options: [
      'A lens that wraps its result in Option',
      'An optic that may or may not focus on a value (like a Lens + Prism combined)',
      'An alias for a Prism on sealed traits',
      'A lens that works only on Option[A] types',
    ],
    correctAnswer: 1,
    explanation: 'An Optional is an optic that may or may not focus on a value — it is the composition of a Lens and a Prism. `getOption` returns `Option[A]`, and `set`/`modify` only change the value if it is present.',
    tags: ['optional', 'optics', 'lens', 'prism'],
  },
  {
    id: 'scala-patterns-l1-057',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'tagless final',
    question: 'What is the `Id` monad used for in tagless final testing?',
    options: [
      'It represents an asynchronous computation',
      'It represents a computation with no effects — just a plain value — enabling synchronous testing',
      'It is a monad that accumulates errors',
      'It is a monad that wraps a mutable state',
    ],
    correctAnswer: 1,
    explanation: '`type Id[A] = A` is the identity monad. Using `Id` for `F` in tagless final lets you run programs synchronously without any effect type, making unit testing straightforward without needing IO or Future.',
    codeSnippet: `import cats.Id

class TestConsole extends Console[Id] {
  def print(msg: String): Id[Unit] = println(msg)
  def readLine: Id[String] = "test-input"
}

program[Id](new TestConsole) // runs synchronously, no IO`,
    tags: ['tagless final', 'Id monad', 'testing'],
  },
  {
    id: 'scala-patterns-l1-058',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'phantom types',
    question: 'Can a value of a phantom type be created directly with `new`?',
    options: [
      'Yes, phantom types are just regular case classes',
      'Typically no — phantom type constructors are usually private, and factory methods control which phantom type is assigned',
      'Yes, but only in Scala 3',
      'No, phantom types are abstract and cannot be instantiated at all',
    ],
    correctAnswer: 1,
    explanation: 'Phantom types are usually implemented with a private constructor so that only controlled factory methods can create values with specific phantom type parameters. This enforces the state machine invariants.',
    tags: ['phantom types', 'constructors', 'encapsulation'],
  },
  {
    id: 'scala-patterns-l1-059',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'builder pattern (Scala-style)',
    question: 'What advantage does the immutable Scala builder (via case class copy) have over the mutable Java builder?',
    options: [
      'The immutable builder is always faster',
      'The immutable builder is thread-safe and each intermediate step is an independent value',
      'The immutable builder requires less code to write',
      'The immutable builder works without any case classes',
    ],
    correctAnswer: 1,
    explanation: 'Because each `copy` creates a new case class instance, intermediate builder states are independent values. They can be shared safely across threads, stored as named configurations, and reused — none of which is safe with a mutable builder.',
    tags: ['builder pattern', 'immutability', 'thread safety'],
  },
  {
    id: 'scala-patterns-l1-060',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'type classes',
    question: 'What is a "orphan instance" in type class terminology?',
    options: [
      'An instance defined in the companion object of the type',
      'An instance defined in neither the companion of the type class nor the companion of the type',
      'An instance that has no implicit parameters',
      'An instance defined for a sealed trait',
    ],
    correctAnswer: 1,
    explanation: 'An orphan instance is a type class instance defined outside both the companion object of the type class and the companion object of the type. Orphan instances can cause implicit ambiguity and are generally discouraged.',
    tags: ['type classes', 'orphan instances', 'implicit resolution'],
  },
  {
    id: 'scala-patterns-l1-061',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'cake pattern',
    question: 'What is the difference between a self-type annotation and extending a trait?',
    options: [
      'There is no difference — they are equivalent',
      'Self-type declares a requirement without inheriting; extending inherits all members',
      'Self-type is for classes; extending is for traits',
      'Self-type allows multiple inheritance; extending does not',
    ],
    correctAnswer: 1,
    explanation: 'Self-type (`this: T =>`) says "this trait can only be mixed into something that also mixes in T" without actually inheriting from T. Extending (`extends T`) does inherit all members. Self-type allows decoupled modular composition.',
    tags: ['cake pattern', 'self-types', 'inheritance'],
  },
  {
    id: 'scala-patterns-l1-062',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'interpreter pattern',
    question: 'What is the relationship between the Interpreter pattern and the Composite pattern?',
    options: [
      'They are the same pattern',
      'The Interpreter pattern often uses a Composite structure (AST) to represent nested expressions',
      'The Composite pattern is a specialization of the Interpreter pattern',
      'They are unrelated patterns',
    ],
    correctAnswer: 1,
    explanation: 'The Interpreter pattern defines an interpreter for a grammar, and the grammar is often represented as a Composite (tree) structure — an AST. Each node in the tree can be a leaf (terminal) or a branch (non-terminal) containing other nodes.',
    tags: ['interpreter pattern', 'composite pattern', 'AST'],
  },
  {
    id: 'scala-patterns-l1-063',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'refined types',
    question: 'How does the Refined library integrate with JSON libraries like Circe?',
    options: [
      'It does not integrate with JSON libraries',
      'Through integration modules that provide codecs that validate the refined predicate during decoding',
      'By serializing refined types as plain JSON numbers',
      'By converting all refined types to strings before encoding',
    ],
    correctAnswer: 1,
    explanation: 'Refined provides integration modules (e.g., `refined-circe`) that give you `Encoder`/`Decoder` instances for refined types. During decoding, the predicate is automatically checked, returning an error if the JSON value does not satisfy it.',
    tags: ['refined types', 'circe', 'JSON', 'integration'],
  },
  {
    id: 'scala-patterns-l1-064',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'free monads',
    question: 'What is the key structural difference between a Free monad program and a tagless final program?',
    options: [
      'Free monad programs use traits; tagless final programs use classes',
      'Free monad programs build an explicit data structure (AST); tagless final programs use direct method dispatch',
      'Free monad programs are faster at runtime',
      'Tagless final programs require a Free monad internally',
    ],
    correctAnswer: 1,
    explanation: 'A Free monad program builds an explicit tree (AST) in memory that is later interpreted by `foldMap`. A tagless final program calls methods on a trait directly — there is no intermediate data structure, just method calls that return F[A] values.',
    tags: ['free monads', 'tagless final', 'AST', 'comparison'],
  },
  {
    id: 'scala-patterns-l1-065',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'reader/writer/state',
    question: 'What method do you call on a State monad to run it with an initial state?',
    options: ['execute', 'run', 'interpret', 'fold'],
    correctAnswer: 1,
    explanation: 'You call `run(initialState)` (or `runS`, `runA`, `eval`, `exec` depending on the library) to execute a State computation with an initial state. It returns a tuple `(finalState, result)` or just one of those components.',
    codeSnippet: `val program: State[Int, Int] = for {
  _ <- State.modify[Int](_ + 1)
  n <- State.get[Int]
} yield n

val (finalState, result) = program.run(0).value
// finalState == 1, result == 1`,
    tags: ['state monad', 'run', 'execution'],
  },
  {
    id: 'scala-patterns-l1-066',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'type classes',
    question: 'What is the Show type class used for?',
    options: [
      'Displaying a UI component',
      'Converting a value to a human-readable String representation',
      'Comparing two values for equality',
      'Serializing a value to JSON',
    ],
    correctAnswer: 1,
    explanation: '`Show[A]` provides a method `show(a: A): String` that converts a value to its human-readable String representation. It is an alternative to `toString` that is controlled by the type class instance rather than the class itself.',
    tags: ['type classes', 'show', 'cats'],
  },
  {
    id: 'scala-patterns-l1-067',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'lens/optics',
    question: 'What is a Traversal optic?',
    options: [
      'An optic that focuses on a single required field',
      'An optic that can focus on zero or more elements within a structure',
      'An optic that traverses the type hierarchy',
      'An optic used only with List types',
    ],
    correctAnswer: 1,
    explanation: 'A Traversal focuses on zero or more elements within a data structure. It is the most general optic, generalizing Lens (one element) and Optional (zero or one). It allows getting all focused values and modifying all of them.',
    codeSnippet: `import monocle.Traversal

val listTraversal: Traversal[List[Int], Int] =
  Traversal.fromTraverse[List, Int]

listTraversal.modify(_ * 2)(List(1, 2, 3)) // List(2, 4, 6)`,
    tags: ['traversal', 'optics', 'monocle'],
  },
  {
    id: 'scala-patterns-l1-068',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'tagless final',
    question: 'What does it mean to "interpret" a tagless final algebra?',
    options: [
      'To parse the algebra\'s source code',
      'To provide a concrete implementation of the algebra trait for a specific F[_]',
      'To fold over the algebra\'s AST with a function',
      'To convert the algebra to a Free monad',
    ],
    correctAnswer: 1,
    explanation: 'Interpreting a tagless final algebra means providing a class that extends the algebra trait with a specific `F[_]` (e.g., `IO`, `Id`, `State`). Each method\'s implementation defines what actually happens when that operation is performed.',
    tags: ['tagless final', 'interpretation', 'algebras'],
  },
  {
    id: 'scala-patterns-l1-069',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'phantom types',
    question: 'What is the runtime cost of phantom type parameters?',
    options: [
      'High — they add a virtual dispatch per operation',
      'Medium — they require a hidden type tag field',
      'Zero — phantom types are erased at runtime',
      'Low — they add one pointer per object',
    ],
    correctAnswer: 2,
    explanation: 'Phantom types have zero runtime cost. Scala (and the JVM) erases generic type parameters at runtime. The phantom type parameter exists only in the source code and type checker, providing compile-time safety with no runtime overhead.',
    tags: ['phantom types', 'type erasure', 'performance'],
  },
  {
    id: 'scala-patterns-l1-070',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'cake pattern',
    question: 'In which situation is the Cake Pattern most appropriate?',
    options: [
      'When you need runtime reconfiguration of dependencies',
      'When you have a relatively fixed set of compile-time dependencies in a single module',
      'When you need to integrate with Java dependency injection frameworks',
      'When you have hundreds of microservices',
    ],
    correctAnswer: 1,
    explanation: 'The Cake Pattern works best for smaller, stable applications where all dependencies are known at compile time. It becomes unwieldy for large numbers of components or when runtime reconfiguration is needed.',
    tags: ['cake pattern', 'use cases', 'dependency injection'],
  },
  {
    id: 'scala-patterns-l1-071',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'interpreter pattern',
    question: 'What is the role of the "algebra" in the context of interpreters?',
    options: [
      'The mathematical operations used in the interpreter',
      'The set of operations (instructions) that the interpreter can execute, usually defined as an ADT',
      'The runtime environment where the interpreter executes',
      'The optimization pass that simplifies the AST',
    ],
    correctAnswer: 1,
    explanation: 'The "algebra" defines WHAT operations are available — the vocabulary of the DSL. It is usually an ADT (sealed trait with case classes). The interpreter defines HOW each operation is executed.',
    tags: ['interpreter pattern', 'algebra', 'ADT'],
  },
  {
    id: 'scala-patterns-l1-072',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'strategy with FP',
    question: 'What is the functional equivalent of the Template Method pattern in Scala?',
    options: [
      'Abstract classes with overridable methods',
      'Higher-order functions where the fixed algorithm calls the varying step passed as a function argument',
      'Sealed traits with different implementations',
      'The cake pattern with self-types',
    ],
    correctAnswer: 1,
    explanation: 'The Template Method pattern defines a fixed algorithm that calls customizable steps. Functionally, this is a higher-order function that has the fixed structure and takes a function argument for each varying step — no inheritance needed.',
    codeSnippet: `def processItems[A, B](
  items: List[A],
  transform: A => B,   // customizable step
  filter: B => Boolean // customizable step
): List[B] =
  items.map(transform).filter(filter) // fixed template`,
    tags: ['strategy pattern', 'template method', 'higher-order functions'],
  },
  {
    id: 'scala-patterns-l1-073',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'free monads',
    question: 'What does it mean for the Free monad to be "stack-safe" with Cats?',
    options: [
      'It prevents stack overflows by using a trampoline to make recursion heap-allocated',
      'It uses a Stack data structure internally',
      'It is safe to use in multi-threaded environments',
      'It prevents stack corruption by using bounds checking',
    ],
    correctAnswer: 0,
    explanation: 'The Cats Free monad implementation uses a trampoline (continuation-passing style internally) so that deeply nested `flatMap` chains do not overflow the call stack. The recursion is converted to a heap-allocated loop.',
    tags: ['free monads', 'stack safety', 'trampoline'],
  },
  {
    id: 'scala-patterns-l1-074',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'type classes',
    question: 'What is the Functor type class?',
    options: [
      'A type class for types that can be compared for equality',
      'A type class for types F[_] that provide a map operation: (F[A], A => B) => F[B]',
      'A type class for types that can be serialized',
      'A type class for types that have a zero element',
    ],
    correctAnswer: 1,
    explanation: '`Functor[F[_]]` provides a `map` method that transforms the value inside a context `F` using a function `A => B`, producing `F[B]`. It must satisfy the identity and composition laws.',
    codeSnippet: `trait Functor[F[_]] {
  def map[A, B](fa: F[A])(f: A => B): F[B]
}`,
    tags: ['type classes', 'functor', 'cats'],
  },
  {
    id: 'scala-patterns-l1-075',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'refined types',
    question: 'Which of the following is a valid refined type for an email address?',
    options: [
      'String Refined Email',
      'String Refined MatchesRegex[W.`"[^@]+@[^@]+"`.T]',
      'Refined[String, ValidEmail]',
      'Email Refined String',
    ],
    correctAnswer: 1,
    explanation: 'You can use the `MatchesRegex` predicate with a Witness-encoded regex string to validate email addresses. The Refined library also has a `uri.Uri` predicate and some string predicates, but a regex match is a common approach.',
    tags: ['refined types', 'regex', 'string validation'],
  },
  {
    id: 'scala-patterns-l1-076',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'lens/optics',
    question: 'What is the difference between a Lens and a Prism?',
    options: [
      'A Lens works on mutable data; a Prism works on immutable data',
      'A Lens focuses on a field in a product type (always present); a Prism focuses on a branch of a sum type (may be absent)',
      'A Lens is for reading only; a Prism supports both reading and writing',
      'They are the same optic with different names',
    ],
    correctAnswer: 1,
    explanation: 'A Lens focuses on a field that is always present in a product type (like a field in a case class). A Prism focuses on a branch of a sum type (sealed trait) that may or may not be present. `lens.get` always returns A; `prism.getOption` returns Option[A].',
    tags: ['lens', 'prism', 'optics', 'product types', 'sum types'],
  },
  {
    id: 'scala-patterns-l1-077',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'cake pattern',
    question: 'What is "abstract type member" and how does it relate to the Cake Pattern?',
    options: [
      'It is a type alias that must be defined in subclasses; Cake Pattern uses them to allow components to refine service types',
      'It is a type parameter on a method; unrelated to Cake Pattern',
      'It is a class defined inside a trait; Cake Pattern components contain one',
      'It is a phantom type; Cake Pattern uses them for state machines',
    ],
    correctAnswer: 0,
    explanation: 'Abstract type members (`type Service`) declared in a trait can be refined (concretized) in mixing classes. In the Cake Pattern, components often declare the service as an abstract type, allowing different layers to provide different implementations.',
    codeSnippet: `trait UserRepositoryComponent {
  type UserRepository <: UserRepositoryLike
  val userRepository: UserRepository

  trait UserRepositoryLike {
    def findById(id: Long): Option[User]
  }
}`,
    tags: ['cake pattern', 'abstract type members'],
  },
  {
    id: 'scala-patterns-l1-078',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'reader/writer/state',
    question: 'How does the Reader monad relate to dependency injection?',
    options: [
      'The Reader monad is a runtime DI framework',
      'The Reader monad represents computations that depend on an environment, providing a pure FP alternative to DI',
      'The Reader monad generates DI configuration files',
      'The Reader monad injects implicit values into scope',
    ],
    correctAnswer: 1,
    explanation: 'The Reader monad is often described as "functional dependency injection". Instead of injecting dependencies via constructors or frameworks, you define computations as `Reader[Config, A]` that are given their dependencies when executed.',
    tags: ['reader monad', 'dependency injection', 'FP patterns'],
  },
  {
    id: 'scala-patterns-l1-079',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'type classes',
    question: 'What is the Monoid type class?',
    options: [
      'A type class for types with a single element',
      'A type class for types A that have an empty (identity) element and a combine (append) operation that is associative',
      'A type class for types that can be iterated',
      'A type class for types that wrap a single value',
    ],
    correctAnswer: 1,
    explanation: 'A Monoid provides `empty: A` (identity element) and `combine(a: A, b: A): A` (associative binary operation). Laws: `combine(empty, a) == a`, `combine(a, empty) == a`, and associativity. Examples: String with "", List with Nil, Int with 0.',
    tags: ['type classes', 'monoid', 'cats'],
  },
  {
    id: 'scala-patterns-l1-080',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'interpreter pattern',
    question: 'What is the advantage of having multiple interpreters for the same ADT?',
    options: [
      'Multiple interpreters make the code faster by parallelizing execution',
      'You can use a production interpreter normally, a logging interpreter for debugging, and an in-memory interpreter for tests',
      'Multiple interpreters allow the ADT to have more operations',
      'Multiple interpreters reduce memory usage',
    ],
    correctAnswer: 1,
    explanation: 'Separating description (ADT) from execution (interpreter) means you can have multiple interpreters: a real database interpreter, an in-memory test interpreter, and a logging interpreter — all for the same program description.',
    tags: ['interpreter pattern', 'testability', 'multiple interpreters'],
  },
  {
    id: 'scala-patterns-l1-081',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'builder pattern (Scala-style)',
    question: 'What is a "step builder" (type-safe builder) pattern?',
    options: [
      'A builder that validates each step with a regex',
      'A builder where each step returns a different type, ensuring required fields are set before the build() call compiles',
      'A builder that automatically generates logging for each step',
      'A builder that uses macros to enforce required fields',
    ],
    correctAnswer: 1,
    explanation: 'A step builder uses distinct types for each builder state, so the compiler enforces the order and presence of required fields. If you skip a required step, the `build()` call becomes a type error.',
    codeSnippet: `class NeedsName; class NeedsAge; class Ready

class StepBuilder[State] private {
  private var name: String = _
  private var age: Int = _

  def setName(n: String)(implicit ev: State =:= NeedsName): StepBuilder[NeedsAge] = ???
  def setAge(a: Int)(implicit ev: State =:= NeedsAge): StepBuilder[Ready] = ???
  def build()(implicit ev: State =:= Ready): Person = ???
}`,
    tags: ['builder pattern', 'type-safe builder', 'phantom types'],
  },
  {
    id: 'scala-patterns-l1-082',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'tagless final',
    question: 'What is an "algebra" in the tagless final sense?',
    options: [
      'A mathematical algebra structure like a ring or field',
      'A trait parameterized by F[_] that declares the operations of a capability or service',
      'A type alias for a function from F[A] to G[A]',
      'A sealed trait hierarchy representing operations as data',
    ],
    correctAnswer: 1,
    explanation: 'In tagless final, an "algebra" is a trait (or abstract class) with type parameter `F[_]` that declares the operations (methods) your program can perform. Programs are written against the algebra; interpreters implement it.',
    tags: ['tagless final', 'algebra', 'traits'],
  },
  {
    id: 'scala-patterns-l1-083',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'type classes',
    question: 'What is the Monad type class?',
    options: [
      'A type class that extends Functor with a flatMap operation for sequencing computations',
      'A type class for types that can be combined with a binary operation',
      'A type class for types that can be iterated over',
      'A type class for types that have exactly one value',
    ],
    correctAnswer: 0,
    explanation: 'A Monad extends Applicative (and thus Functor) with `flatMap` (bind) and `pure`. `flatMap` enables sequencing of computations where each step can depend on the result of the previous step.',
    codeSnippet: `trait Monad[F[_]] extends Applicative[F] {
  def flatMap[A, B](fa: F[A])(f: A => F[B]): F[B]
}`,
    tags: ['type classes', 'monad', 'flatMap'],
  },
  {
    id: 'scala-patterns-l1-084',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'refined types',
    question: 'What is the `And` predicate combinator in Refined?',
    options: [
      'It checks that a value satisfies at least one of two predicates',
      'It checks that a value satisfies both predicates simultaneously',
      'It combines two refined values into a tuple',
      'It applies a predicate to both elements of a pair',
    ],
    correctAnswer: 1,
    explanation: '`And[P, Q]` (written as `P And Q`) requires a value to satisfy BOTH predicate P and predicate Q. Similarly, `Or[P, Q]` requires satisfying at least one.',
    codeSnippet: `import eu.timepit.refined.numeric.{Greater, Less}
import eu.timepit.refined.boolean.And

type BoundedInt = Int Refined (Greater[W.\`0\`.T] And Less[W.\`100\`.T])`,
    tags: ['refined types', 'And', 'predicate combinators'],
  },
  {
    id: 'scala-patterns-l1-085',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'cake pattern',
    question: 'What is a common alternative to the Cake Pattern in modern Scala applications?',
    options: [
      'Manual constructor injection (plain classes with constructor parameters)',
      'The Singleton pattern',
      'Reflection-based injection',
      'XML-based Spring configuration',
    ],
    correctAnswer: 0,
    explanation: 'Modern Scala applications often use simple constructor injection (plain Scala classes that take their dependencies as constructor parameters). This is simpler, more testable, and works well with libraries like ZIO\'s ZLayer or Cats Effect\'s IOLocal.',
    tags: ['cake pattern', 'constructor injection', 'alternatives'],
  },
  {
    id: 'scala-patterns-l1-086',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'free monads',
    question: 'What is the "Coyoneda trick" related to Free monads?',
    options: [
      'A way to make any type class work as a Monad',
      'A way to lift any type constructor F into a Free-like structure without requiring F to be a Functor',
      'A way to optimize Free monad interpretation',
      'A way to combine two Free monads',
    ],
    correctAnswer: 1,
    explanation: 'The Coyoneda trick wraps any type constructor F in `Coyoneda[F, A]`, which IS a Functor regardless of whether F is. This allows building a Free monad (`FreeC`) over any type constructor, not just Functors.',
    tags: ['free monads', 'coyoneda', 'functor'],
  },
  {
    id: 'scala-patterns-l1-087',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'strategy with FP',
    question: 'How does `Ordering[A]` in Scala\'s standard library exemplify the Strategy pattern?',
    options: [
      'It does not exemplify the Strategy pattern',
      'It provides a pluggable comparison strategy that can be passed to sorting methods without changing the sort algorithm',
      'It uses inheritance to provide different sorting strategies',
      'It uses the cake pattern to inject sorting logic',
    ],
    correctAnswer: 1,
    explanation: '`Ordering[A]` is a type class that encapsulates the comparison strategy. Methods like `List.sorted` accept an implicit `Ordering[A]` to determine the sort order. You can provide custom `Ordering` instances to change the sort strategy without modifying the sort algorithm.',
    tags: ['strategy pattern', 'Ordering', 'type classes'],
  },
  {
    id: 'scala-patterns-l1-088',
    language: 'scala',
    level: 'level1',
    category: 'Design Patterns',
    subcategory: 'lens/optics',
    question: 'What is the `Iso` optic?',
    options: [
      'An optic that is isolated from the rest of the optic hierarchy',
      'An optic representing an isomorphism — a lossless two-way conversion between two types',
      'An optic for focusing on a single optional field',
      'An optic for non-destructive updates',
    ],
    correctAnswer: 1,
    explanation: 'An Iso represents a reversible transformation between two types S and A with no information loss. It has `get: S => A` and `reverseGet: A => S`. Composing an Iso with a Lens gives another Lens, making Iso the most general optic.',
    codeSnippet: `import monocle.Iso

val listToVector: Iso[List[Int], Vector[Int]] =
  Iso[List[Int], Vector[Int]](_.toVector)(_.toList)`,
    tags: ['iso', 'optics', 'isomorphism'],
  },
];

export default questions;
