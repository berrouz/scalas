import { Question } from '@/types/question';

const questions: Question[] = [
  {
    id: 'scala-patterns-l2-001',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'type classes',
    question: 'What does this code do when called with `printAll(List(1, 2, 3))`?',
    options: [
      'It fails to compile because List has no Show instance',
      'It prints each element using the Show instance for Int, one per line',
      'It prints the List as a single string',
      'It prints the List using toString',
    ],
    correctAnswer: 1,
    explanation: 'The function requires `Show[A]` in scope. For `List[Int]`, A is Int, and there is an implicit `Show[Int]` available. The function maps each element to its Show representation and prints it.',
    codeSnippet: `def printAll[A: Show](items: List[A]): Unit =
  items.foreach(a => println(Show[A].show(a)))`,
    tags: ['type classes', 'show', 'context bounds'],
  },
  {
    id: 'scala-patterns-l2-002',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'type classes',
    question: 'How do you provide a type class instance for a type you own?',
    options: [
      'Extend the type class trait directly in the class definition',
      'Place the implicit instance in the companion object of your type',
      'Define the instance inside a special Instances object',
      'Use the @derive annotation on your class',
    ],
    correctAnswer: 1,
    explanation: 'The canonical placement for a type class instance for a type you own is in the companion object of that type. Scala\'s implicit resolution automatically looks there, so no import is required.',
    codeSnippet: `case class Money(amount: BigDecimal, currency: String)

object Money {
  implicit val moneyShow: Show[Money] =
    Show.show(m => s"\${m.amount} \${m.currency}")
}`,
    tags: ['type classes', 'companion objects', 'implicit resolution'],
  },
  {
    id: 'scala-patterns-l2-003',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'type classes',
    question: 'What is the purpose of the "ops" or "syntax" pattern for type classes?',
    options: [
      'It generates the type class trait automatically',
      'It provides extension methods so you can call type class methods with dot-notation on values',
      'It provides a way to list all type class instances in scope',
      'It provides operators for combining type class instances',
    ],
    correctAnswer: 1,
    explanation: 'The "ops" pattern wraps a value in an implicit class to provide extension methods, enabling `myValue.show` instead of `Show[MyType].show(myValue)`. This makes code more readable.',
    codeSnippet: `implicit class ShowOps[A](val a: A) extends AnyVal {
  def show(implicit S: Show[A]): String = S.show(a)
}

// Now you can write:
42.show  // instead of Show[Int].show(42)`,
    tags: ['type classes', 'syntax', 'extension methods', 'implicit class'],
  },
  {
    id: 'scala-patterns-l2-004',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'type classes',
    question: 'What is the Contravariant functor type class and when is it used?',
    options: [
      'A type class for F[A] where A appears in a contravariant position (as function input)',
      'A type class for types that go backwards through a collection',
      'A type class for types that reverse the order of their elements',
      'A type class that is the opposite of Monad',
    ],
    correctAnswer: 0,
    explanation: 'Contravariant[F[_]] provides `contramap[A, B](fa: F[A])(f: B => A): F[B]`. It is used for types where A is in input position, like `Ordering`, `Encoder`, `Predicate`. If you can compare A, and you can convert B to A, you can compare B.',
    codeSnippet: `// Contravariant Ordering example
val stringOrd: Ordering[String] = Ordering[String]
val lengthOrd: Ordering[String] = stringOrd.on(_.length)
// or with Cats:
// Contravariant[Ordering].contramap(stringOrd)(_.length)`,
    tags: ['type classes', 'contravariant', 'functor'],
  },
  {
    id: 'scala-patterns-l2-005',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'cake pattern',
    question: 'What compilation error do you get when you forget a self-type dependency?',
    options: [
      'NullPointerException at runtime',
      '"illegal inheritance" or "does not conform to... self-type" error',
      '"value not found" for the missing dependency',
      '"ambiguous implicit values" error',
    ],
    correctAnswer: 1,
    explanation: 'If a trait has `this: SomeTrait =>` and you mix the trait into an object that does not include SomeTrait, Scala emits: "error: ... does not conform to ... self-type ...".',
    codeSnippet: `trait A { this: B => }
trait B

// OK:
object Good extends A with B

// Error: "object Bad does not conform to trait A's self-type"
// object Bad extends A`,
    tags: ['cake pattern', 'self-types', 'compile errors'],
  },
  {
    id: 'scala-patterns-l2-006',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'cake pattern',
    question: 'How can you support multiple implementations (e.g., test vs production) with the Cake Pattern?',
    options: [
      'By using runtime reflection to swap implementations',
      'By creating multiple "environment" objects that mix in different component implementations',
      'By passing a flag to the component at instantiation time',
      'By overriding the entire application object at startup',
    ],
    correctAnswer: 1,
    explanation: 'You define multiple implementation traits for the same component and create different "environment" objects (e.g., TestApp, ProdApp) that mix in different implementations. The compiler verifies both are complete.',
    codeSnippet: `object ProductionApp
  extends UserRepositoryComponent
  with PostgresUserRepository  // production impl
  with UserServiceComponent

object TestApp
  extends UserRepositoryComponent
  with InMemoryUserRepository  // test impl
  with UserServiceComponent`,
    tags: ['cake pattern', 'testing', 'multiple implementations'],
  },
  {
    id: 'scala-patterns-l2-007',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'tagless final',
    question: 'What is "capability-based design" in tagless final?',
    options: [
      'Using capabilities from the OS kernel directly',
      'Structuring programs around fine-grained algebras so each function only receives the capabilities it needs',
      'Using capability lists to authorize database operations',
      'A pattern for designing authentication systems',
    ],
    correctAnswer: 1,
    explanation: 'Capability-based design means each function only takes the algebra instances it actually uses, not a god-object of all capabilities. This makes dependencies explicit and code easier to test and reason about.',
    codeSnippet: `// Good: only needs Console, not the full app environment
def greet[F[_]: Monad](name: String)(implicit C: Console[F]): F[Unit] =
  C.print(s"Hello, $name!")

// Not ideal: takes everything
def greet2[F[_]: Monad](name: String)(implicit env: FullAppEnv[F]): F[Unit] = ???`,
    tags: ['tagless final', 'capability-based design', 'algebras'],
  },
  {
    id: 'scala-patterns-l2-008',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'tagless final',
    question: 'What is "MTL style" in the context of tagless final?',
    options: [
      'A style of naming variables using short acronyms',
      'Monad Transformer Library style — using type class constraints on F[_] instead of concrete monad transformers',
      'A style of using multiple type class bounds simultaneously',
      'A style borrowed from Haskell\'s MTL library for parsing',
    ],
    correctAnswer: 1,
    explanation: 'MTL (Monad Transformer Library) style uses type class constraints like `MonadState[F, S]`, `MonadError[F, E]`, `MonadReader[F, R]` on `F[_]` instead of concrete transformer stacks like `StateT[EitherT[IO, E, *], S, A]`. This keeps the algebra polymorphic.',
    codeSnippet: `import cats.mtl.{Stateful, Raise}

def transfer[F[_]](
  amount: BigDecimal
)(implicit
  S: Stateful[F, Balance],
  R: Raise[F, InsufficientFunds]
): F[Unit] = ???`,
    tags: ['tagless final', 'MTL', 'monad transformers'],
  },
  {
    id: 'scala-patterns-l2-009',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'tagless final',
    question: 'What is the "smart constructor" pattern as used in tagless final services?',
    options: [
      'Using a macro to generate constructors automatically',
      'Providing a companion object `make` method that returns an instance of the algebra wrapped in F[_]',
      'Using refined types to validate constructor arguments',
      'Using the `new` keyword inside a lazy val',
    ],
    correctAnswer: 1,
    explanation: 'A smart constructor for a tagless final service is typically `def make[F[_]: Sync](dep: Dep[F]): F[Service[F]]`, wrapping initialization effects. This ensures the service is only created inside the effect type.',
    codeSnippet: `class UserService[F[_]: Monad] private (repo: UserRepo[F]) {
  def findUser(id: UUID): F[Option[User]] = repo.find(id)
}

object UserService {
  def make[F[_]: Monad](repo: UserRepo[F]): UserService[F] =
    new UserService[F](repo)
}`,
    tags: ['tagless final', 'smart constructors', 'algebras'],
  },
  {
    id: 'scala-patterns-l2-010',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'lens/optics',
    question: 'What does the `@Lenses` annotation from Monocle do?',
    options: [
      'It generates Lens instances for all fields of the annotated case class',
      'It marks a class as immutable',
      'It generates JSON codecs for the annotated case class',
      'It creates a Prism for each constructor of a sealed trait',
    ],
    correctAnswer: 0,
    explanation: 'The `@Lenses` macro annotation generates `Lens` instances for every field of the annotated case class and places them in the companion object. This saves boilerplate compared to writing each lens manually.',
    codeSnippet: `import monocle.macros.Lenses

@Lenses
case class Person(name: String, age: Int)

// Generated automatically:
// Person.name: Lens[Person, String]
// Person.age: Lens[Person, Int]

Person.name.get(Person("Alice", 30)) // "Alice"`,
    tags: ['lens', 'monocle', 'macros', 'code generation'],
  },
  {
    id: 'scala-patterns-l2-011',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'lens/optics',
    question: 'How do you update a deeply nested field in an immutable case class hierarchy without optics?',
    options: [
      'Using mutable vars',
      'Using nested copy calls — verbose but correct',
      'You cannot update immutable structures at all',
      'Using reflection to access private fields',
    ],
    correctAnswer: 1,
    explanation: 'Without optics, updating a nested field requires nested `copy` calls. This is correct but becomes very verbose with deep nesting. Optics (Lens composition) solve exactly this boilerplate problem.',
    codeSnippet: `case class Street(name: String)
case class Address(street: Street)
case class Person(name: String, address: Address)

val alice = Person("Alice", Address(Street("Oak Ave")))

// Without optics — verbose:
val updated = alice.copy(
  address = alice.address.copy(
    street = alice.address.street.copy(name = "Elm St")
  )
)`,
    tags: ['lens', 'optics', 'immutable updates', 'case classes'],
  },
  {
    id: 'scala-patterns-l2-012',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'lens/optics',
    question: 'What is the type of a composed Lens[A, B] andThen Prism[B, C]?',
    options: ['Lens[A, C]', 'Optional[A, C]', 'Prism[A, C]', 'Traversal[A, C]'],
    correctAnswer: 1,
    explanation: 'Composing a Lens (always present) with a Prism (optionally present) gives an Optional — something that may or may not be present. The composition hierarchy in Monocle follows: Iso > Lens > Optional > Traversal.',
    tags: ['lens', 'prism', 'optional', 'optics composition'],
  },
  {
    id: 'scala-patterns-l2-013',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'phantom types',
    question: 'How do phantom types combine with type class instances to enforce constraints?',
    options: [
      'Type classes provide runtime checking; phantom types are not used with type classes',
      'You can define type class instances only for specific phantom type parameters, preventing invalid operations',
      'Type class instances eliminate the need for phantom types',
      'Phantom types require special type classes called phantom type classes',
    ],
    correctAnswer: 1,
    explanation: 'You can make type class instances (or implicit evidence) available only for specific phantom type parameters. For example, only allowing serialization of `Request[Validated]` but not `Request[Unvalidated]`.',
    codeSnippet: `sealed trait Validated
sealed trait Unvalidated

case class Request[S](body: String)

trait Serializable[A]
implicit val validatedSerializer: Serializable[Request[Validated]] =
  new Serializable[Request[Validated]] {}
// No instance for Request[Unvalidated] — prevents serializing unvalidated requests`,
    tags: ['phantom types', 'type classes', 'compile-time safety'],
  },
  {
    id: 'scala-patterns-l2-014',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'phantom types',
    question: 'What is the "newtype" pattern and how does it relate to phantom types?',
    options: [
      'A pattern for creating new type class instances from old ones',
      'Wrapping a type in a case class or value class to create a distinct type with no runtime overhead, often using phantom type parameters',
      'Using the newtype compiler plugin to generate types',
      'A pattern for naming new case class fields',
    ],
    correctAnswer: 1,
    explanation: 'A newtype wraps a value in a class to create a type-distinct wrapper (UserId vs OrderId vs Long). Combined with phantom types or value classes, you get type safety with minimal overhead. Libraries like `newtype` for Scala automate this.',
    codeSnippet: `// Value class newtype
class UserId(val value: Long) extends AnyVal
class OrderId(val value: Long) extends AnyVal

// These are now distinct types — can't mix them up
def findUser(id: UserId): Option[User] = ???
// findUser(OrderId(1L)) // compile error!`,
    tags: ['phantom types', 'newtype', 'value classes'],
  },
  {
    id: 'scala-patterns-l2-015',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'refined types',
    question: 'How can refined types be used with case class fields?',
    options: [
      'Refined types cannot be used as case class fields',
      'Directly as field types, providing automatic validation for all instances of the case class',
      'Only via a validate() method added to the case class',
      'Only via the companion object apply method',
    ],
    correctAnswer: 1,
    explanation: 'Refined types can be used directly as case class field types. This means the constraint is part of the type and enforced whenever a value is created. The constructor can be made private with a smart constructor using `refineV`.',
    codeSnippet: `import eu.timepit.refined.api.Refined
import eu.timepit.refined.numeric.Positive
import eu.timepit.refined.collection.NonEmpty

case class User private (
  name: String Refined NonEmpty,
  age: Int Refined Positive
)

object User {
  def apply(name: String, age: Int): Either[String, User] =
    for {
      n <- refineV[NonEmpty](name)
      a <- refineV[Positive](age)
    } yield new User(n, a)
}`,
    tags: ['refined types', 'case classes', 'smart constructors'],
  },
  {
    id: 'scala-patterns-l2-016',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'refined types',
    question: 'What is the `Interval.Closed` predicate in Refined?',
    options: [
      'A predicate that checks a value is within a closed interval [L, U] (inclusive on both ends)',
      'A predicate that checks a connection is closed',
      'A predicate for closed (sealed) algebraic data types',
      'A predicate that checks an interval list is non-empty',
    ],
    correctAnswer: 0,
    explanation: '`Interval.Closed[L, U]` checks that a numeric value is within the closed interval [L, U], inclusive on both ends. `Interval.Open[L, U]` checks (L, U) exclusive.',
    codeSnippet: `import eu.timepit.refined.numeric.Interval

type Percentage = Int Refined Interval.Closed[W.\`0\`.T, W.\`100\`.T]

val p1: Percentage = refineMV(50)   // OK
// val p2: Percentage = refineMV(101) // Compile error`,
    tags: ['refined types', 'interval', 'numeric predicates'],
  },
  {
    id: 'scala-patterns-l2-017',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'reader/writer/state',
    question: 'What is `Kleisli[F, A, B]` and how does it relate to the Reader monad?',
    options: [
      'Kleisli is a completely different concept, unrelated to Reader',
      'Kleisli[F, A, B] wraps A => F[B]; Reader[A, B] is Kleisli[Id, A, B]',
      'Kleisli is a monad transformer that adds Reader functionality to any monad',
      'Kleisli is a type alias for ReaderT',
    ],
    correctAnswer: 1,
    explanation: '`Kleisli[F, A, B]` wraps the function `A => F[B]`, generalizing function composition into effectful context. `Reader[A, B]` is `Kleisli[Id, A, B]`. `ReaderT[F, A, B]` (Reader transformer) is `Kleisli[F, A, B]`.',
    codeSnippet: `import cats.data.Kleisli
import cats.Id

// Reader[Config, String] is Kleisli[Id, Config, String]
val getHost: Kleisli[Id, Config, String] = Kleisli(_.host)

// ReaderT[IO, Config, String] is Kleisli[IO, Config, String]
val getHostIO: Kleisli[IO, Config, String] = Kleisli(c => IO(c.host))`,
    tags: ['reader monad', 'Kleisli', 'ReaderT', 'monad transformers'],
  },
  {
    id: 'scala-patterns-l2-018',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'reader/writer/state',
    question: 'How do you extract only the final state from a State monad computation?',
    options: [
      'Use .value after running',
      'Use .runS(initialState).value',
      'Use .runA(initialState).value',
      'Use .exec(initialState)',
    ],
    correctAnswer: 1,
    explanation: '`runS` runs the State computation and returns only the final state (discarding the result). `runA` returns only the result (discarding the final state). `run` returns both as a tuple.',
    codeSnippet: `val program: State[Int, String] = for {
  _ <- State.modify[Int](_ + 10)
  n <- State.get[Int]
} yield s"count: $n"

val finalState: Int = program.runS(0).value   // 10
val result: String  = program.runA(0).value   // "count: 10"
val both: (Int, String) = program.run(0).value // (10, "count: 10")`,
    tags: ['state monad', 'runS', 'runA', 'execution'],
  },
  {
    id: 'scala-patterns-l2-019',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'reader/writer/state',
    question: 'What is WriterT and when would you use it?',
    options: [
      'A monad transformer that adds Writer functionality to any monad F',
      'A type class for types that can write to a file',
      'A utility for writing JSON to a stream',
      'A transformer that converts Writer to State',
    ],
    correctAnswer: 0,
    explanation: '`WriterT[F[_], W, A]` is the Writer monad transformer. It adds logging (accumulation) to any monad F. Use it when you need both Writer-like log accumulation AND another effect (like IO or EitherT) in the same computation.',
    codeSnippet: `import cats.data.WriterT
import cats.effect.IO

type LoggedIO[A] = WriterT[IO, List[String], A]

def doWork: LoggedIO[Int] =
  WriterT(IO.pure((List("did work"), 42)))`,
    tags: ['writer monad', 'WriterT', 'monad transformers'],
  },
  {
    id: 'scala-patterns-l2-020',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'free monads',
    question: 'How do you combine two different Free monad algebras into one program?',
    options: [
      'By extending one sealed trait from the other',
      'Using the Coproduct (EitherK) type and injecting each algebra into the coproduct',
      'By converting both algebras to the same base type',
      'Free monads cannot be combined — you must choose one algebra per program',
    ],
    correctAnswer: 1,
    explanation: 'To combine two Free monad algebras, you create a Coproduct (EitherK in Cats) of both functors. Each algebra is injected (via InjectK) into the coproduct, allowing both algebras to be used in the same for-comprehension.',
    codeSnippet: `import cats.data.EitherK
import cats.InjectK

type App[A] = EitherK[ConsoleOp, FileOp, A]

class ConsoleDSL[F[_]](implicit I: InjectK[ConsoleOp, F]) {
  def print(msg: String): Free[F, Unit] = Free.liftInject(Print(msg))
}

class FileDSL[F[_]](implicit I: InjectK[FileOp, F]) {
  def read(path: String): Free[F, String] = Free.liftInject(Read(path))
}`,
    tags: ['free monads', 'coproduct', 'EitherK', 'InjectK'],
  },
  {
    id: 'scala-patterns-l2-021',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'free monads',
    question: 'What is the difference between `Free.pure` and `Free.liftF`?',
    options: [
      'Free.pure builds an AST node; Free.liftF returns an immediate value',
      'Free.pure lifts a plain value (no effect); Free.liftF lifts a functor instruction into the monad',
      'They are identical — both lift values into the Free monad',
      'Free.pure is for Cats; Free.liftF is for Scalaz',
    ],
    correctAnswer: 1,
    explanation: '`Free.pure(a)` creates a `Pure(a)` node — a computation that immediately returns a value with no effects. `Free.liftF(instruction)` creates a `Suspend(instruction)` node — a computation that represents one instruction in the algebra.',
    codeSnippet: `val noOp: Free[ConsoleOp, Int] = Free.pure(42)       // immediate value
val ask: Free[ConsoleOp, String] = Free.liftF(ReadLine) // one instruction`,
    tags: ['free monads', 'pure', 'liftF'],
  },
  {
    id: 'scala-patterns-l2-022',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'interpreter pattern',
    question: 'What is the "initial algebra" vs "final encoding" distinction?',
    options: [
      'Initial algebra encodes a program as data (ADT/Free); final encoding uses direct method calls (tagless final)',
      'Initial algebra uses sealed traits; final encoding uses open traits',
      'Initial algebra is the first version of the algebra; final encoding is the optimized version',
      'They are different names for the same concept',
    ],
    correctAnswer: 0,
    explanation: '"Initial" (or "first") encoding represents programs as an explicit data structure that can be inspected and optimized before execution. "Final" encoding (tagless final) represents programs directly as function values — they cannot be inspected but are simpler.',
    tags: ['interpreter pattern', 'initial algebra', 'final encoding', 'tagless final'],
  },
  {
    id: 'scala-patterns-l2-023',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'interpreter pattern',
    question: 'What is the "Visitor pattern" and how does it relate to the Interpreter pattern in Scala?',
    options: [
      'The Visitor pattern is an OO version of the Interpreter pattern for type-safe double dispatch',
      'They are the same pattern',
      'The Visitor pattern is for building ASTs; the Interpreter pattern is for executing them',
      'The Visitor pattern is deprecated in Scala in favor of pattern matching',
    ],
    correctAnswer: 0,
    explanation: 'The Visitor pattern enables adding operations to a class hierarchy without modifying the classes. In Scala, pattern matching on sealed traits achieves the same goal more elegantly and is the idiomatic alternative to OO Visitor.',
    codeSnippet: `// OO Visitor approach (verbose in Scala)
trait ShapeVisitor[A] { def circle(r: Double): A; def rect(w: Double, h: Double): A }

// Scala idiomatic approach (pattern matching as Visitor)
sealed trait Shape
def area(s: Shape): Double = s match {
  case Circle(r)    => Math.PI * r * r
  case Rect(w, h)   => w * h
}`,
    tags: ['interpreter pattern', 'visitor pattern', 'pattern matching'],
  },
  {
    id: 'scala-patterns-l2-024',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'strategy with FP',
    question: 'How can you implement the Chain of Responsibility pattern functionally in Scala?',
    options: [
      'Using a linked list of handler objects',
      'By composing handler functions with `orElse` or `andThen`, short-circuiting on success',
      'Using abstract classes with a nextHandler field',
      'Using the cake pattern with multiple handler components',
    ],
    correctAnswer: 1,
    explanation: 'Functional Chain of Responsibility uses partial functions composed with `orElse`, or `Option`-returning functions composed with `orElse`. The chain short-circuits when a handler returns `Some`.',
    codeSnippet: `type Handler[A, B] = A => Option[B]

def chain[A, B](handlers: List[Handler[A, B]]): Handler[A, B] =
  input => handlers.foldLeft(Option.empty[B]) {
    (acc, handler) => acc.orElse(handler(input))
  }`,
    tags: ['strategy pattern', 'chain of responsibility', 'partial functions'],
  },
  {
    id: 'scala-patterns-l2-025',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'strategy with FP',
    question: 'What is the "Function object" pattern and how does it relate to Strategy in Scala?',
    options: [
      'A pattern where objects behave like functions by implementing apply()',
      'A pattern for converting functions to objects for Java interoperability',
      'A pattern where functions are stored in case classes to add metadata',
      'A pattern using companion objects with multiple apply overloads',
    ],
    correctAnswer: 0,
    explanation: 'A function object implements `apply()` so it can be called like a function but can also carry state and be extended. In Scala, objects with `apply` or classes extending `Function1` are natural function objects — the Strategy pattern collapsed to a function value.',
    codeSnippet: `trait Validator[-A] extends (A => Boolean) {
  def and(other: Validator[A]): Validator[A] =
    (a: A) => this(a) && other(a)
}

val nonEmpty: Validator[String] = _.nonEmpty
val noSpaces: Validator[String] = !_.contains(" ")
val usernameValidator = nonEmpty and noSpaces`,
    tags: ['strategy pattern', 'function objects', 'apply method'],
  },
  {
    id: 'scala-patterns-l2-026',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'builder pattern (Scala-style)',
    question: 'What is the "type-safe DSL" builder pattern using implicit conversions?',
    options: [
      'A pattern that uses implicits to automatically build the final object',
      'A pattern where each builder step is typed to prevent invalid configurations, using implicits to provide "proof" values',
      'A pattern where implicit conversions convert strings to builder steps',
      'A pattern exclusively for building SQL queries',
    ],
    correctAnswer: 1,
    explanation: 'A type-safe DSL builder uses the type system to prevent invalid configurations. Implicit evidence values (like `=:=` or custom evidence types) are used as "proof" that certain steps have been taken before calling `build()`.',
    codeSnippet: `sealed trait MissingName
sealed trait HasName

case class PersonBuilder[S](name: Option[String] = None) {
  def withName(n: String): PersonBuilder[HasName] =
    copy(name = Some(n)).asInstanceOf[PersonBuilder[HasName]]
  def build(implicit ev: S =:= HasName): Person =
    Person(name.get)
}`,
    tags: ['builder pattern', 'type-safe DSL', 'phantom types'],
  },
  {
    id: 'scala-patterns-l2-027',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'cake pattern',
    question: 'What is the "thin cake" pattern?',
    options: [
      'A simplified version of the Cake Pattern with fewer layers',
      'A variation where components only declare their direct dependencies and implementations are simple objects',
      'The same as constructor injection',
      'A pattern that uses ZIO layers instead of trait mixing',
    ],
    correctAnswer: 1,
    explanation: 'The "thin cake" simplifies the Cake Pattern by making components straightforward: a trait declares the interface and its deps via self-type; a companion object or inner class provides the implementation. Less boilerplate than the full cake.',
    tags: ['cake pattern', 'thin cake', 'dependency injection'],
  },
  {
    id: 'scala-patterns-l2-028',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'type classes',
    question: 'What is the "implicit scope" and how does it relate to the "package object"?',
    options: [
      'Implicit scope is the same as lexical scope',
      'The package object is one of the places in implicit scope — any implicits defined there are available without explicit import',
      'Package objects have lower priority than companion objects in implicit resolution',
      'Implicit scope only covers the current file',
    ],
    correctAnswer: 1,
    explanation: 'Implicits defined in a package object are automatically in scope for any code in that package, without needing an explicit import. This is a common pattern for making type class instances available across a package.',
    tags: ['type classes', 'implicit scope', 'package objects'],
  },
  {
    id: 'scala-patterns-l2-029',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'lens/optics',
    question: 'What is the `each` combinator in Monocle and what does it return?',
    options: [
      'A Lens that focuses on the head element of a List',
      'A Traversal that focuses on every element of a traversable container',
      'A Prism for Option that focuses on the Some value',
      'An Iso that converts between List and Vector',
    ],
    correctAnswer: 1,
    explanation: '`each` (from `monocle.function.each._`) provides a Traversal that focuses on every element of a traversable container (List, Vector, etc.). It lets you `get`, `set`, or `modify` all elements in the container.',
    codeSnippet: `import monocle.function.all._

val doubled: List[Int] = each[List[Int], Int].modify(_ * 2)(List(1, 2, 3))
// List(2, 4, 6)`,
    tags: ['monocle', 'traversal', 'each'],
  },
  {
    id: 'scala-patterns-l2-030',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'refined types',
    question: 'How does `Validate.fromPredicate` work in the Refined library?',
    options: [
      'It creates a new predicate type from a Boolean function for use with refineV',
      'It validates a list of refined values in parallel',
      'It converts a refined type to a validated Cats type',
      'It generates a Prism for a refined type',
    ],
    correctAnswer: 0,
    explanation: '`Validate.fromPredicate` creates a new `Validate[T, P]` instance from a predicate function `T => Boolean` and an error message function. This is how you define custom predicates for the Refined library.',
    codeSnippet: `import eu.timepit.refined.api.Validate

case class EvenPredicate()

implicit val evenValidate: Validate.Plain[Int, EvenPredicate] =
  Validate.fromPredicate(
    n => n % 2 == 0,
    n => s"$n is not even",
    EvenPredicate()
  )

type EvenInt = Int Refined EvenPredicate`,
    tags: ['refined types', 'custom predicates', 'Validate'],
  },
  {
    id: 'scala-patterns-l2-031',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'free monads',
    question: 'What is the purpose of the `resume` method on Free monads?',
    options: [
      'It resumes a suspended computation after it was paused',
      'It performs one step of interpretation, peeling off one layer of the Free structure',
      'It converts a Free monad to a State monad',
      'It re-runs the interpreter from the beginning',
    ],
    correctAnswer: 1,
    explanation: '`resume` (or `step`) on a Free monad performs one step of unfolding, returning either `Right(a)` if the computation is `Pure(a)`, or `Left(instruction)` if the next step is a `Suspend`. It enables custom step-by-step interpreters.',
    tags: ['free monads', 'resume', 'step-by-step interpretation'],
  },
  {
    id: 'scala-patterns-l2-032',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'tagless final',
    question: 'How do you combine multiple tagless final algebras in a single program?',
    options: [
      'By using a coproduct of all algebras',
      'By requiring multiple implicit algebra instances as separate context bounds or implicit parameters',
      'By creating a God-trait that extends all algebras',
      'By converting all algebras to Free monads and combining them',
    ],
    correctAnswer: 1,
    explanation: 'In tagless final, you combine algebras by requiring all needed algebra instances in the function signature. Each algebra is a separate type class constraint on `F[_]`. The function receives whichever algebras it needs.',
    codeSnippet: `def createUser[F[_]: Monad](
  name: String
)(implicit
  users: UserAlgebra[F],
  emails: EmailAlgebra[F],
  log: LogAlgebra[F]
): F[UserId] =
  for {
    id <- users.create(name)
    _  <- emails.sendWelcome(name)
    _  <- log.info(s"Created user $id")
  } yield id`,
    tags: ['tagless final', 'multiple algebras', 'composition'],
  },
  {
    id: 'scala-patterns-l2-033',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'reader/writer/state',
    question: 'What is the difference between `StateT` and `State`?',
    options: [
      'StateT is deprecated; State is the current way to use state',
      'State[S, A] is StateT[Eval, S, A] — StateT is the transformer version that adds state to any monad F',
      'StateT is a monad transformer that converts State to IO',
      'State is lazy; StateT is strict',
    ],
    correctAnswer: 1,
    explanation: '`State[S, A]` is defined as `StateT[Eval, S, A]`. `StateT[F[_], S, A]` is the transformer that adds stateful computation to any monad F. Use `StateT[IO, S, A]` when you need both state and IO effects.',
    tags: ['state monad', 'StateT', 'monad transformers'],
  },
  {
    id: 'scala-patterns-l2-034',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'cake pattern',
    question: 'What is the "Registry" or "Wiring" object in the Cake Pattern and what is its role?',
    options: [
      'An object that registers all type class instances for automatic resolution',
      'The top-level object that mixes all component traits together, assembling the full application',
      'A factory class that creates components on demand',
      'A configuration file that lists all dependencies',
    ],
    correctAnswer: 1,
    explanation: 'The Registry (or Application, Wiring) object is the root of the Cake Pattern composition. It mixes in all component traits, thereby satisfying all self-type requirements and providing all services. It is the "assembled application".',
    codeSnippet: `object ApplicationRegistry
  extends ConfigComponent
  with DatabaseComponent
  with UserRepositoryComponent
  with UserServiceComponent
  with HttpApiComponent`,
    tags: ['cake pattern', 'registry', 'wiring', 'assembly'],
  },
  {
    id: 'scala-patterns-l2-035',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'type classes',
    question: 'How do you implement a "conditional" type class instance?',
    options: [
      'By using an if-else in the implicit def',
      'By defining an implicit def with type class constraints that derives one instance from others',
      'By using a runtime check inside the instance',
      'Conditional instances are not possible in Scala',
    ],
    correctAnswer: 1,
    explanation: 'Conditional (derived) instances use implicit `def` instead of implicit `val`. If you have `Show[A]` and `Show[B]`, you can derive `Show[(A, B)]` by providing an implicit def that requires both.',
    codeSnippet: `implicit def tupleShow[A, B](
  implicit sa: Show[A], sb: Show[B]
): Show[(A, B)] = Show.show {
  case (a, b) => s"(\${sa.show(a)}, \${sb.show(b)})"
}

// Now (1, "hello").show works if Show[Int] and Show[String] are in scope`,
    tags: ['type classes', 'derived instances', 'implicit def'],
  },
  {
    id: 'scala-patterns-l2-036',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'phantom types',
    question: 'What is the difference between phantom types and value classes?',
    options: [
      'They are the same technique',
      'Value classes avoid boxing overhead for a single-field wrapper; phantom types add compile-time type information with zero runtime representation',
      'Value classes are for primitives; phantom types are for reference types',
      'Phantom types avoid boxing; value classes add compile-time tags',
    ],
    correctAnswer: 1,
    explanation: 'Value classes (`extends AnyVal`) avoid heap allocation for wrapper types. Phantom types add a type parameter that carries compile-time information with no runtime cost. They are orthogonal and often combined: a value class with a phantom type parameter.',
    codeSnippet: `class Tagged[+T, +Tag](val value: T) extends AnyVal
// Zero runtime overhead (value class) + compile-time tag (phantom)

type Meters = Tagged[Double, MetersTag]
type Kilograms = Tagged[Double, KilogramsTag]`,
    tags: ['phantom types', 'value classes', 'AnyVal'],
  },
  {
    id: 'scala-patterns-l2-037',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'interpreter pattern',
    question: 'What is a "recursive ADT" and what pattern is used to evaluate it?',
    options: [
      'An ADT that contains itself; evaluated by recursive pattern matching (catamorphism)',
      'An ADT that uses recursion to generate instances',
      'An ADT defined in terms of type parameters that appear in recursive positions',
      'An ADT that can refer to values of the same ADT type via lazy evaluation',
    ],
    correctAnswer: 0,
    explanation: 'A recursive ADT has cases that contain themselves (e.g., `Add(Expr, Expr)`). Evaluation uses recursive pattern matching — structurally recursing into sub-expressions. This pattern is a catamorphism (fold over the ADT structure).',
    codeSnippet: `sealed trait Expr
case class Lit(n: Int) extends Expr
case class Add(l: Expr, r: Expr) extends Expr
case class Mul(l: Expr, r: Expr) extends Expr

def eval(e: Expr): Int = e match {
  case Lit(n)    => n
  case Add(l, r) => eval(l) + eval(r)
  case Mul(l, r) => eval(l) * eval(r)
}`,
    tags: ['interpreter pattern', 'recursive ADT', 'catamorphism'],
  },
  {
    id: 'scala-patterns-l2-038',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'lens/optics',
    question: 'What is the `at` combinator in Monocle?',
    options: [
      'A Lens that focuses on the element at a given index in a List',
      'A Lens that focuses on the value at a given key in a Map',
      'A Traversal that focuses on elements at odd indices',
      'A Prism for accessing elements at specific positions in a tree',
    ],
    correctAnswer: 1,
    explanation: '`at(key)` provides a `Lens[Map[K, V], Option[V]]` that focuses on the value at the given key. `get` returns `Some(v)` if the key exists, `None` otherwise. `set(Some(v))` inserts, `set(None)` removes.',
    codeSnippet: `import monocle.function.all._
import monocle.std.map._

val m = Map("a" -> 1, "b" -> 2)

at("a").get(m)          // Some(1)
at("c").get(m)          // None
at("b").set(None)(m)    // Map("a" -> 1)
at("c").set(Some(3))(m) // Map("a" -> 1, "b" -> 2, "c" -> 3)`,
    tags: ['monocle', 'at', 'lens', 'Map'],
  },
  {
    id: 'scala-patterns-l2-039',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'refined types',
    question: 'What does it mean for a refined type to support `Coerce`?',
    options: [
      'It means the refined type can be widened to its base type without any validation',
      'It means the base type can be coerced to the refined type without validation (unsafe)',
      'It means the refined type can be compared with its base type',
      'It means the refined type supports JSON coercion',
    ],
    correctAnswer: 0,
    explanation: 'A refined type can always be safely widened (coerced) to its underlying base type because the refined value has already passed validation. `Refined[Int, Positive]` can always be used as `Int` because it IS an Int that is positive.',
    codeSnippet: `val posInt: Int Refined Positive = refineMV(5)
val i: Int = posInt.value // Safe widening — no validation needed`,
    tags: ['refined types', 'coerce', 'widening'],
  },
  {
    id: 'scala-patterns-l2-040',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'free monads',
    question: 'What is a "DSL" in the context of Free monads?',
    options: [
      'A Dynamic Shared Library for the JVM',
      'A Domain-Specific Language — a set of operations defined as ADT cases that form a vocabulary for describing programs',
      'A type-safe alternative to XML configuration',
      'A debugging tool for Free monad programs',
    ],
    correctAnswer: 1,
    explanation: 'In the Free monad context, a DSL is the set of operations (ADT cases) you define for your domain. Users write programs using the DSL operations; the interpreter maps those operations to real effects.',
    codeSnippet: `// The DSL: an ADT of operations
sealed trait DatabaseOp[A]
case class Insert[A](table: String, value: A) extends DatabaseOp[Unit]
case class Select[A](table: String, id: Long) extends DatabaseOp[Option[A]]
case class Delete(table: String, id: Long) extends DatabaseOp[Boolean]

type Database[A] = Free[DatabaseOp, A]`,
    tags: ['free monads', 'DSL', 'ADT'],
  },
  {
    id: 'scala-patterns-l2-041',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'tagless final',
    question: 'What is the "implicit summoner" pattern for tagless final algebras?',
    options: [
      'Using `implicitly` directly in every function that needs an algebra',
      'Defining an `apply[F[_]]` method in the algebra companion object that summons the implicit instance',
      'Automatically generating algebra instances from ADTs',
      'Using macro annotations to inject algebra instances',
    ],
    correctAnswer: 1,
    explanation: 'The implicit summoner (or "apply" summoner) is a companion object method that retrieves the implicit instance: `def apply[F[_]](implicit ev: MyAlgebra[F]): MyAlgebra[F] = ev`. It enables `MyAlgebra[F].method()` syntax.',
    codeSnippet: `trait Console[F[_]] {
  def print(msg: String): F[Unit]
}

object Console {
  def apply[F[_]](implicit ev: Console[F]): Console[F] = ev
  // Usage: Console[IO].print("hello")
}`,
    tags: ['tagless final', 'summoner', 'companion objects'],
  },
  {
    id: 'scala-patterns-l2-042',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'reader/writer/state',
    question: 'What is `StateT.liftF` used for?',
    options: [
      'It lifts a value into StateT without touching the state',
      'It lifts an F[A] computation into StateT[F, S, A], threading the state through unchanged',
      'It converts a State to StateT',
      'It folds the StateT into an F value',
    ],
    correctAnswer: 1,
    explanation: '`StateT.liftF(fa)` lifts an `F[A]` into `StateT[F, S, A]`, running the `F[A]` effect but leaving the state unchanged. This allows mixing non-stateful effects into a StateT computation.',
    codeSnippet: `type AppState[A] = StateT[IO, Config, A]

def readConfig: AppState[Config] = StateT.get
def logMessage(msg: String): AppState[Unit] =
  StateT.liftF(IO(println(msg)))  // IO effect, doesn't touch state`,
    tags: ['state monad', 'StateT', 'liftF'],
  },
  {
    id: 'scala-patterns-l2-043',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'type classes',
    question: 'What is "implicit ambiguity" and how do you resolve it?',
    options: [
      'When two implicits of the same type are in scope and the compiler cannot choose between them — resolve by removing one or making one more specific',
      'When an implicit parameter name shadows a local variable',
      'When an implicit conversion is applied unexpectedly',
      'When two type classes have the same methods',
    ],
    correctAnswer: 0,
    explanation: 'Implicit ambiguity occurs when two implicits of the same type are in scope. Scala\'s implicit priority rules (local > imported > companion) help, but explicit tie-breaking requires making one implicit more specific or moving it to a lower-priority scope.',
    tags: ['type classes', 'implicit ambiguity', 'implicit resolution'],
  },
  {
    id: 'scala-patterns-l2-044',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'cake pattern',
    question: 'How does the Cake Pattern handle circular dependencies?',
    options: [
      'Circular dependencies are resolved automatically by the Scala compiler',
      'Circular dependencies cause a compilation error and must be broken using lazy vals or abstraction',
      'Circular dependencies are allowed via self-type annotations',
      'Circular dependencies are resolved at runtime by lazy initialization',
    ],
    correctAnswer: 1,
    explanation: 'Circular dependencies in the Cake Pattern cause initialization-order issues. If component A requires B and B requires A, you need to break the cycle using `lazy val` for the service members, which delays initialization until first access.',
    codeSnippet: `trait ServiceAComponent { this: ServiceBComponent =>
  lazy val serviceA: ServiceA = new ServiceA(serviceB) // lazy to break cycle
}

trait ServiceBComponent { this: ServiceAComponent =>
  lazy val serviceB: ServiceB = new ServiceB(serviceA) // lazy to break cycle
}`,
    tags: ['cake pattern', 'circular dependencies', 'lazy val'],
  },
  {
    id: 'scala-patterns-l2-045',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'lens/optics',
    question: 'What is `index` in Monocle and what type does it provide?',
    options: [
      'A Lens[List[A], A] for accessing elements by index',
      'An Optional[S, A] for accessing an element at a given index, returning None if out of bounds',
      'A Prism for the index case of a sealed trait',
      'A Traversal over all elements at even indices',
    ],
    correctAnswer: 1,
    explanation: '`index(i)` provides an `Optional[List[A], A]` (or for Map, `Optional[Map[K, V], V]`) that focuses on the element at the given index. It returns `None` if the index is out of bounds, making it safe.',
    codeSnippet: `import monocle.function.all._

val xs = List(1, 2, 3)
index(1).get(xs)             // Some(2)
index(5).get(xs)             // None
index(0).set(99)(xs)         // List(99, 2, 3)
index(0).modify(_ * 10)(xs)  // List(10, 2, 3)`,
    tags: ['monocle', 'index', 'optional', 'List'],
  },
  {
    id: 'scala-patterns-l2-046',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'phantom types',
    question: 'What is "tagging" and how does it compare to phantom types?',
    options: [
      'Tagging and phantom types are identical techniques',
      'Tagging (using @@ or Tag[A, T]) adds a type tag to an existing type without wrapping; phantom types wrap in a container',
      'Tagging is for collections; phantom types are for scalars',
      'Tagging is a runtime concept; phantom types are compile-time only',
    ],
    correctAnswer: 1,
    explanation: 'Scalaz/Shapeless-style "tagging" (A @@ Tag) annotates an existing type with a tag without boxing. Phantom types wrap in a separate type constructor. Both are compile-time only, but tagging has no wrapper class — `A @@ T` is still just A at runtime.',
    codeSnippet: `import shapeless.tag
import shapeless.tag.@@

trait Meters
trait Kilograms

val distance: Double @@ Meters = tag[Meters](5.0)
val weight: Double @@ Kilograms = tag[Kilograms](70.0)
// distance + weight // won't compile — different tags`,
    tags: ['phantom types', 'tagging', 'shapeless'],
  },
  {
    id: 'scala-patterns-l2-047',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'free monads',
    question: 'What is the difference between Free and Freer monads?',
    options: [
      'Free requires the functor to be defined; Freer does not require a Functor instance',
      'Freer is more expensive than Free at runtime',
      'Free is for Cats; Freer is for Scalaz',
      'They are identical — "Freer" is just an older name for Free',
    ],
    correctAnswer: 0,
    explanation: 'Free[F, A] requires F to be a Functor. The Freer monad (using Coyoneda internally, sometimes called Free[F, A] in Cats which handles the Functor via Coyoneda) lifts any type constructor F into a Free structure without requiring F to have a Functor instance.',
    tags: ['free monads', 'Freer', 'Functor', 'coyoneda'],
  },
  {
    id: 'scala-patterns-l2-048',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'refined types',
    question: 'How do you use refined types with Doobie (Scala JDBC library)?',
    options: [
      'Refined types cannot be used with Doobie',
      'Via the doobie-refined integration module that provides Put/Get/Meta instances for refined types',
      'By converting refined types to strings before inserting',
      'By using a custom TypeClass macro',
    ],
    correctAnswer: 1,
    explanation: 'The `doobie-refined` module provides `Get`, `Put`, and `Meta` instances for refined types, allowing them to be used directly in Doobie queries. The refinement predicate is checked when reading from the database.',
    tags: ['refined types', 'doobie', 'database', 'integration'],
  },
  {
    id: 'scala-patterns-l2-049',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'tagless final',
    question: 'What is the "logging interpreter" pattern in tagless final?',
    options: [
      'An interpreter that replaces all operations with logging',
      'A wrapping interpreter that logs before/after each algebra operation while delegating to the real interpreter',
      'An interpreter that only runs when logging is enabled',
      'A macro that generates log statements for each algebra operation',
    ],
    correctAnswer: 1,
    explanation: 'A logging interpreter wraps the real algebra instance and adds logging around each method call. It delegates to the actual implementation but also logs calls. This is the Decorator pattern applied to tagless final algebras.',
    codeSnippet: `class LoggingUserAlgebra[F[_]: Monad](
  delegate: UserAlgebra[F],
  logger: Logger[F]
) extends UserAlgebra[F] {
  def findUser(id: UUID): F[Option[User]] =
    for {
      _      <- logger.debug(s"Finding user $id")
      result <- delegate.findUser(id)
      _      <- logger.debug(s"Found: $result")
    } yield result
}`,
    tags: ['tagless final', 'logging', 'decorator pattern'],
  },
  {
    id: 'scala-patterns-l2-050',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'strategy with FP',
    question: 'How do you implement the Observer pattern functionally using Scala streams?',
    options: [
      'Using mutable observer lists and notifyObservers methods',
      'Using fs2 Streams or ZIO Streams where observers are downstream transformations',
      'Using Akka actors as observers',
      'Using callbacks stored in a mutable map',
    ],
    correctAnswer: 1,
    explanation: 'Functional streams (fs2, ZIO Stream, Monix Observable) model the Observer pattern purely. Publishers produce streams; observers subscribe by chaining stream operators. Push-based reactive programming replaces the mutable observer list.',
    codeSnippet: `import fs2.Stream

// Publisher
val events: Stream[IO, Event] = Stream.eval(IO(Event("click")))

// Observers as stream transformations
val logged = events.evalMap(e => IO(println(s"Log: $e")))
val filtered = events.filter(_.name == "click")`,
    tags: ['strategy pattern', 'observer pattern', 'fs2', 'streams'],
  },
  {
    id: 'scala-patterns-l2-051',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'type classes',
    question: 'What is the "implicit not found" annotation?',
    options: [
      '@implicitNotFound provides a custom error message when an implicit cannot be found',
      '@implicitNotFound prevents implicit resolution for that type',
      '@implicitNotFound marks a type class that has no instances',
      '@implicitNotFound is used to suppress implicit ambiguity warnings',
    ],
    correctAnswer: 0,
    explanation: '`@implicitNotFound("Your custom message for \${A}")` on a type class trait provides a helpful compile-time error message when no implicit instance is found. This greatly improves the developer experience.',
    codeSnippet: `@scala.annotation.implicitNotFound(
  "No Show instance found for type \${A}. " +
  "Define one in the companion object of \${A} or import it."
)
trait Show[A] {
  def show(a: A): String
}`,
    tags: ['type classes', 'implicitNotFound', 'error messages'],
  },
  {
    id: 'scala-patterns-l2-052',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'interpreter pattern',
    question: 'What is "defunctionalization" and how does it relate to the interpreter pattern?',
    options: [
      'Removing function calls from the interpreter for performance',
      'Replacing higher-order functions with first-order data (ADT cases), which is then interpreted',
      'Converting a recursive interpreter to an iterative one',
      'A technique for making interpreters stack-safe',
    ],
    correctAnswer: 1,
    explanation: 'Defunctionalization converts higher-order functions to first-order data. Instead of passing a lambda, you pass an ADT case that describes the function. The interpreter "applies" each case. This is the essence of the interpreter/Free monad pattern.',
    tags: ['interpreter pattern', 'defunctionalization', 'ADT'],
  },
  {
    id: 'scala-patterns-l2-053',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'builder pattern (Scala-style)',
    question: 'What is the "magnet pattern" in Scala?',
    options: [
      'A pattern that attracts implicit conversions to avoid overloading issues',
      'A pattern where all variants of an overloaded method are encoded as a single method taking a "magnet" type that has implicit conversions for each variant',
      'A pattern for building configuration objects from multiple sources',
      'A pattern using shapeless HLists to build typed records',
    ],
    correctAnswer: 1,
    explanation: 'The magnet pattern encodes method overloading by taking a single `Magnet` type that has implicit conversions from each argument type. It solves erasure ambiguity issues but is generally considered over-engineered.',
    codeSnippet: `sealed trait CompletionMagnet { type Result; def apply(): Result }
object CompletionMagnet {
  implicit def fromString(s: String): CompletionMagnet = ???
  implicit def fromInt(n: Int): CompletionMagnet = ???
}

def complete(magnet: CompletionMagnet): magnet.Result = magnet()`,
    tags: ['builder pattern', 'magnet pattern', 'overloading'],
  },
  {
    id: 'scala-patterns-l2-054',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'lens/optics',
    question: 'How do you use a Lens to update a field inside an `Option`?',
    options: [
      'Lenses cannot be used with Option fields',
      'Compose the Lens with `some` (a Prism for Option\'s Some case) to get an Optional',
      'Use the `optional` method on the Lens directly',
      'Use a Traversal over the Option',
    ],
    correctAnswer: 1,
    explanation: 'To focus on a field inside an `Option[A]`, compose a Prism for the `Some` case with a Lens on `A`. Monocle provides `monocle.std.option.some` as a Prism that focuses on the `Some` value.',
    codeSnippet: `import monocle.std.option.some

val nameLens = GenLens[Person](_.name)
val optNameLens = some[Person] andThen nameLens
// optNameLens: Optional[Option[Person], String]

optNameLens.set("Bob")(Some(Person("Alice", 30))) // Some(Person("Bob", 30))
optNameLens.set("Bob")(None)                       // None`,
    tags: ['lens', 'prism', 'option', 'monocle'],
  },
  {
    id: 'scala-patterns-l2-055',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'free monads',
    question: 'What is "trampolining" and why is it relevant to Free monads?',
    options: [
      'A technique to make algorithms run in parallel',
      'A technique to convert deep recursion to a heap-allocated loop, preventing stack overflow',
      'A technique to optimize Free monad interpretation by memoizing results',
      'A technique to convert a Free monad to a tail-recursive function',
    ],
    correctAnswer: 1,
    explanation: 'Trampolining converts recursive calls to a loop by returning "thunks" (suspended computations) instead of recursing. The Free monad in Cats uses trampolining via `Eval` to make programs with deeply nested `flatMap` chains stack-safe.',
    tags: ['free monads', 'trampolining', 'stack safety'],
  },
  {
    id: 'scala-patterns-l2-056',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'tagless final',
    question: 'What is the "Resource" pattern in tagless final and why is it important?',
    options: [
      'A pattern for managing classpath resources',
      'Using `Resource[F, A]` to manage resource acquisition and release, ensuring cleanup even on errors',
      'A type alias for `F[A]` when A is a shared resource',
      'A pattern for caching computation results',
    ],
    correctAnswer: 1,
    explanation: '`Resource[F, A]` (from Cats Effect) models resource lifecycle. It pairs acquire with a guaranteed release (even on error/cancellation). Services in tagless final often return `Resource[F, Service[F]]` to manage their lifecycle.',
    codeSnippet: `def makeDatabase[F[_]: Sync]: Resource[F, Database[F]] =
  Resource.make(
    Sync[F].delay(Database.connect())   // acquire
  )(db =>
    Sync[F].delay(db.close())           // release
  )`,
    tags: ['tagless final', 'Resource', 'resource management', 'cats effect'],
  },
  {
    id: 'scala-patterns-l2-057',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'type classes',
    question: 'What is the Foldable type class?',
    options: [
      'A type class for collections that can be reduced to a summary value',
      'A type class for types that can be folded into origami shapes',
      'A type class for types that can be converted to a List',
      'A type class for types that can be compared for structural equality',
    ],
    correctAnswer: 0,
    explanation: '`Foldable[F[_]]` provides `foldLeft`, `foldRight`, and derived operations like `size`, `toList`, `find`, `forall`, etc. It generalizes folding over any container-like type, not just List.',
    codeSnippet: `import cats.Foldable
import cats.instances.list._

Foldable[List].fold(List("a", "b", "c"))       // "abc"
Foldable[List].foldLeft(List(1,2,3), 0)(_ + _) // 6`,
    tags: ['type classes', 'foldable', 'cats'],
  },
  {
    id: 'scala-patterns-l2-058',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'cake pattern',
    question: 'What problem does lazy initialization solve in the Cake Pattern and what is the risk?',
    options: [
      'It solves circular dependencies but risks throwing exceptions if initialization fails silently',
      'It solves circular dependencies and circular state initialization but risks NullPointerException if the lazy val accessor is called before initialization completes in multi-threaded code',
      'It makes component initialization faster but risks memory leaks',
      'It allows runtime reconfiguration but risks incorrect ordering',
    ],
    correctAnswer: 1,
    explanation: 'Lazy vals in the Cake Pattern break initialization cycles but introduce a threading risk: if two threads simultaneously access a lazy val before it is initialized, synchronization is needed. Scala lazy vals are synchronized, but deadlocks are possible with circular lazy vals.',
    tags: ['cake pattern', 'lazy val', 'threading', 'initialization'],
  },
  {
    id: 'scala-patterns-l2-059',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'refined types',
    question: 'What is the `Size` predicate family in Refined?',
    options: [
      'Predicates that check the byte size of a serialized value',
      'Predicates that check the size (length) of a collection or string against a numeric constraint',
      'Predicates that check the memory size of an object',
      'Predicates for checking the size of file uploads',
    ],
    correctAnswer: 1,
    explanation: '`Size[P]` checks that the size (length) of a collection or string satisfies the numeric predicate P. For example, `Size[Greater[W.\\`5\\`.T]]` requires a string/collection with more than 5 elements.',
    codeSnippet: `import eu.timepit.refined.collection.Size
import eu.timepit.refined.numeric.Greater

type LongString = String Refined Size[Greater[W.\`10\`.T]]

val s: LongString = refineMV("Hello, World!")  // 13 chars — OK
// refineMV("Short") // Compile error — only 5 chars`,
    tags: ['refined types', 'Size', 'collection predicates'],
  },
  {
    id: 'scala-patterns-l2-060',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'interpreter pattern',
    question: 'What is the "expression problem" and how do Scala sealed traits + type classes partially solve it?',
    options: [
      'Adding new expressions to an OO hierarchy is easy; adding new operations requires modifying all classes. Sealed traits + type classes let you add new operations without modifying the ADT.',
      'Adding new expressions causes stack overflow; sealed traits prevent deep nesting.',
      'The expression problem is about parsing expressions; sealed traits provide the parser.',
      'Sealed traits and type classes do not help with the expression problem.',
    ],
    correctAnswer: 0,
    explanation: 'The expression problem: OO makes adding new types easy but adding operations hard; FP (sealed ADTs) makes adding operations easy but adding new types hard. Type classes allow adding new operations to sealed ADTs without modification, partially solving the problem.',
    tags: ['interpreter pattern', 'expression problem', 'type classes', 'sealed traits'],
  },
  {
    id: 'scala-patterns-l2-061',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'reader/writer/state',
    question: 'How do you use the Reader monad for dependency injection in a service layer?',
    options: [
      'By passing the Reader monad as a constructor parameter',
      'By defining service functions as `Reader[Dependencies, A]` and composing them with `flatMap`',
      'By using the Reader monad as a type alias for Function1',
      'By injecting the Reader monad with a DI framework',
    ],
    correctAnswer: 1,
    explanation: 'Service functions are defined as `Reader[Env, A]` where `Env` holds all dependencies. Functions compose via `flatMap`, and the environment is provided once when running the program with `run(env)` or `provide(env)`.',
    codeSnippet: `case class AppEnv(userRepo: UserRepo, emailSvc: EmailService)

val getUser: Reader[AppEnv, User] =
  Reader(env => env.userRepo.findById(1L).get)

val sendWelcome: Reader[AppEnv, Unit] =
  Reader(env => env.emailSvc.send("welcome@email.com"))

val program: Reader[AppEnv, Unit] =
  for {
    user <- getUser
    _    <- sendWelcome
  } yield ()`,
    tags: ['reader monad', 'dependency injection', 'composition'],
  },
  {
    id: 'scala-patterns-l2-062',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'phantom types',
    question: 'How can you use phantom types to enforce units of measure?',
    options: [
      'By wrapping numeric values in case classes with unit type parameters',
      'By using refined types with unit predicates',
      'By using the Squants library which uses phantom types internally',
      'Both A and C are valid approaches',
    ],
    correctAnswer: 3,
    explanation: 'Both wrapping in a typed value class with phantom type parameter AND using the Squants library (which implements units of measure using phantom types/tagged types) are valid. Squants provides pre-built dimensional quantities.',
    codeSnippet: `// Manual phantom type approach
class Measure[+T, +Unit](val value: T) extends AnyVal
type Meters = Measure[Double, MetersTag]
type Seconds = Measure[Double, SecondsTag]

// Squants library approach
import squants.mass.Kilograms
import squants.space.Meters
val speed = Meters(100) / Seconds(9.58)`,
    tags: ['phantom types', 'units of measure', 'squants'],
  },
  {
    id: 'scala-patterns-l2-063',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'builder pattern (Scala-style)',
    question: 'What is the advantage of using `shapeless.HList` for builder patterns?',
    options: [
      'HLists are faster than case classes',
      'HLists allow type-level tracking of which fields have been set, enabling compile-time "required field" checks without phantom types',
      'HLists serialize to JSON automatically',
      'HLists are the only way to implement builder patterns in Scala',
    ],
    correctAnswer: 1,
    explanation: 'Shapeless HLists are heterogeneous lists with types at the type level. A builder using HList can track exactly which fields have been set in its type, so `build()` is only callable when all required fields are in the HList — enforced at compile time.',
    tags: ['builder pattern', 'shapeless', 'HList', 'type-level programming'],
  },
  {
    id: 'scala-patterns-l2-064',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'type classes',
    question: 'What is the `Traverse` type class?',
    options: [
      'A type class for types that can be traversed in order',
      'A type class combining Functor and Foldable that allows sequencing effects while transforming elements',
      'A type class for tree-like data structures',
      'A type class for converting between different collection types',
    ],
    correctAnswer: 1,
    explanation: '`Traverse[F[_]]` provides `traverse[G[_]: Applicative, A, B](fa: F[A])(f: A => G[B]): G[F[B]]`. It runs an effectful function on each element and collects the results. For example, `List[Future[A]] -> Future[List[A]]`.',
    codeSnippet: `import cats.Traverse
import cats.instances.list._
import scala.concurrent.Future

val futures: List[Future[Int]] = List(Future(1), Future(2), Future(3))
val future: Future[List[Int]] = Traverse[List].sequence(futures)`,
    tags: ['type classes', 'traverse', 'cats', 'applicative'],
  },
  {
    id: 'scala-patterns-l2-065',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'free monads',
    question: 'What is the "optimization" advantage of Free monads over tagless final?',
    options: [
      'Free monads are always faster than tagless final',
      'Since Free programs are data structures, you can inspect and transform the AST before interpretation, enabling query fusion or batching',
      'Free monads avoid allocations entirely',
      'Free monads automatically parallelize independent operations',
    ],
    correctAnswer: 1,
    explanation: 'Because Free programs are explicit data structures (ASTs), you can write transformations (optimizers) that inspect and rewrite the program before running it — e.g., merging adjacent database reads into a single batch query.',
    tags: ['free monads', 'optimization', 'AST transformation'],
  },
  {
    id: 'scala-patterns-l2-066',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'tagless final',
    question: 'What is the "effect row" approach (like Eff monad) as an alternative to tagless final?',
    options: [
      'A pattern using Scala\'s row types for effects',
      'A pattern where effects are tracked in a type-level list (extensible effect row), combining multiple effects without monad transformer stacks',
      'A pattern for defining effects as database rows',
      'A pattern that uses implicits to inject effects into functions',
    ],
    correctAnswer: 1,
    explanation: 'Extensible effects (Eff monad, as in the `eff` library) represent programs as computations in a "row" of effects (a type-level list). This is an alternative to both tagless final and monad transformers, avoiding the transformer composition overhead.',
    tags: ['tagless final', 'extensible effects', 'Eff monad', 'alternatives'],
  },
  {
    id: 'scala-patterns-l2-067',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'lens/optics',
    question: 'What is the `_1` and `_2` optic in Monocle?',
    options: [
      'Prisms for the first and second case of a sealed trait',
      'Lenses that focus on the first and second element of a tuple',
      'Traversals over the first and second half of a List',
      'Isos between a case class and its first/second field',
    ],
    correctAnswer: 1,
    explanation: '`_1` and `_2` are Lenses provided by Monocle for focusing on the first and second element of a tuple (2-tuple). Composing them with other optics lets you navigate into nested tuple structures.',
    codeSnippet: `import monocle.function.all._

val pair = (("Alice", 30), "NYC")

_1[((String, Int), String), (String, Int)].get(pair) // ("Alice", 30)
(_1 andThen _2).get(pair)                            // 30`,
    tags: ['monocle', 'lens', 'tuples', '_1', '_2'],
  },
  {
    id: 'scala-patterns-l2-068',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'refined types',
    question: 'What does the `Not` predicate in Refined do?',
    options: [
      'It negates the entire refined type',
      'It checks that a value does NOT satisfy the given predicate',
      'It marks a type as not refineable',
      'It creates a complementary predicate type',
    ],
    correctAnswer: 1,
    explanation: '`Not[P]` inverts predicate P: the value must NOT satisfy P. For example, `Not[Positive]` allows zero or negative integers. Combined with `And`/`Or`, you can build complex predicates.',
    codeSnippet: `import eu.timepit.refined.boolean.Not
import eu.timepit.refined.numeric.Positive

type NonPositive = Int Refined Not[Positive]
// Allows 0 and negative numbers`,
    tags: ['refined types', 'Not', 'predicate combinators'],
  },
  {
    id: 'scala-patterns-l2-069',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'strategy with FP',
    question: 'What is the "semi-group" strategy pattern?',
    options: [
      'Combining partial results using Semigroup instances as a configurable combination strategy',
      'Using a semigroup to pick between competing strategies',
      'A pattern where strategies are combined using multiplication',
      'A strategy pattern that only works on half the input',
    ],
    correctAnswer: 0,
    explanation: 'Using `Semigroup[A]` as the combination strategy allows callers to inject different combination behaviors (Last, First, Sum, etc.) without changing the algorithm. The semigroup IS the strategy.',
    codeSnippet: `import cats.Semigroup

def mergeAll[A: Semigroup](items: List[A]): Option[A] =
  items.reduceOption(Semigroup[A].combine)

// Different strategies via different Semigroup instances:
mergeAll(List(1, 2, 3))(Semigroup[Int])      // Some(6) — sum
mergeAll(List("a", "b", "c"))                // Some("abc") — concat`,
    tags: ['strategy pattern', 'semigroup', 'type classes'],
  },
  {
    id: 'scala-patterns-l2-070',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'reader/writer/state',
    question: 'What is the difference between `Writer.tell` and `Writer.value`?',
    options: [
      'tell adds to the log without a value; value produces a value without adding to the log',
      'tell is for Scala 2; value is for Scala 3',
      'tell writes to a file; value reads from it',
      'They are identical operations',
    ],
    correctAnswer: 0,
    explanation: '`Writer.tell(log)` produces `(log, ())` — it contributes to the log but has no meaningful result value. `Writer.value(a)` produces `(empty, a)` — it has a result but adds nothing to the log. `Writer.apply(log, a)` does both.',
    codeSnippet: `import cats.data.Writer

val logged: Writer[List[String], Int] =
  for {
    _ <- Writer.tell(List("Starting computation"))
    x <- Writer.value(42)
    _ <- Writer.tell(List(s"Result is $x"))
  } yield x

val (log, result) = logged.run
// log: List("Starting computation", "Result is 42")
// result: 42`,
    tags: ['writer monad', 'tell', 'value', 'cats'],
  },
  {
    id: 'scala-patterns-l2-071',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'type classes',
    question: 'What is the `Applicative` type class and how does it differ from Monad?',
    options: [
      'Applicative provides map and flatMap; Monad provides only map',
      'Applicative provides pure and ap (independent effects); Monad adds flatMap (sequential, dependent effects)',
      'Applicative is for optional effects; Monad is for required effects',
      'They are the same — Applicative is just an alias for Monad',
    ],
    correctAnswer: 1,
    explanation: '`Applicative` provides `pure` and `ap` (or `map2`), enabling combining independent effects. `Monad` adds `flatMap`, enabling sequential effects where each step depends on the previous. Applicative operations can run in parallel; monadic ones cannot.',
    codeSnippet: `// Applicative: independent validations (can run in parallel)
(validateName(name), validateAge(age)).mapN(Person.apply)

// Monad: sequential (each step depends on previous result)
for {
  user <- findUser(id)
  _    <- sendEmail(user.email)
} yield user`,
    tags: ['type classes', 'applicative', 'monad', 'cats'],
  },
  {
    id: 'scala-patterns-l2-072',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'cake pattern',
    question: 'How do you test a component in isolation using the Cake Pattern?',
    options: [
      'You cannot test Cake Pattern components in isolation',
      'By creating a minimal test object that only mixes in the component under test and stub implementations of its dependencies',
      'By using Mockito to mock all components',
      'By extracting the component to a separate module',
    ],
    correctAnswer: 1,
    explanation: 'To unit test a Cake Pattern component, create a test object mixing in the component under test with hand-written stub or mock implementations of its declared dependencies. Only the required self-type components need to be provided.',
    codeSnippet: `object TestSetup extends UserServiceComponent with UserRepositoryComponent {
  val userRepository = new UserRepositoryLike {
    def findById(id: Long) = Some(User(id, "TestUser"))
  }
  val userService = new UserService(userRepository)
}`,
    tags: ['cake pattern', 'testing', 'isolation'],
  },
  {
    id: 'scala-patterns-l2-073',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'interpreter pattern',
    question: 'What is a "tree-walking interpreter" and what Scala pattern implements it?',
    options: [
      'An interpreter that walks through files in a directory tree',
      'An interpreter that recursively traverses an AST and evaluates each node by pattern matching',
      'An interpreter that processes a binary search tree',
      'An interpreter implemented using Scala\'s tree-shaking optimization',
    ],
    correctAnswer: 1,
    explanation: 'A tree-walking interpreter recursively traverses the AST (built from a sealed trait hierarchy) and evaluates each node. Pattern matching on the sealed trait dispatches to the correct evaluation logic for each node type.',
    tags: ['interpreter pattern', 'tree-walking', 'AST', 'recursion'],
  },
  {
    id: 'scala-patterns-l2-074',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'tagless final',
    question: 'What is the `Sync` type class in Cats Effect and when is it used in tagless final?',
    options: [
      'It synchronizes concurrent effects',
      'It provides the ability to suspend synchronous side effects (like wrapping arbitrary code in F) — required for interpreters that interact with side-effectful APIs',
      'It ensures all F[A] computations complete before moving to the next step',
      'It provides synchronous alternatives to async operations',
    ],
    correctAnswer: 1,
    explanation: '`Sync[F]` provides `delay(a: => A): F[A]` which suspends a side-effectful computation. Interpreters for tagless final algebras often require `Sync[F]` to wrap existing side-effectful Java APIs or mutations in the effect type F.',
    codeSnippet: `import cats.effect.Sync

class IOUserRepo[F[_]: Sync] extends UserRepo[F] {
  def findById(id: Long): F[Option[User]] =
    Sync[F].delay {
      // Wrapping a side-effectful DB call
      database.query(s"SELECT * FROM users WHERE id = $id")
    }
}`,
    tags: ['tagless final', 'Sync', 'cats effect', 'side effects'],
  },
  {
    id: 'scala-patterns-l2-075',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'refined types',
    question: 'How do you apply a refined type predicate to the elements of a List?',
    options: [
      'List cannot hold refined types',
      'By using `forall` predicate: `List[A] Refined Forall[P]`',
      'By defining a custom Traverse instance for refined types',
      'By using the `each` optic from Monocle',
    ],
    correctAnswer: 1,
    explanation: 'The `Forall[P]` predicate from `eu.timepit.refined.collection` checks that ALL elements of a collection satisfy predicate P. `Exists[P]` checks that AT LEAST ONE element satisfies P.',
    codeSnippet: `import eu.timepit.refined.collection.Forall
import eu.timepit.refined.numeric.Positive

type AllPositive = List[Int] Refined Forall[Positive]

val xs: AllPositive = refineMV(List(1, 2, 3))
// refineMV(List(1, -2, 3)) // Compile error`,
    tags: ['refined types', 'Forall', 'collection predicates'],
  },
  {
    id: 'scala-patterns-l2-076',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'free monads',
    question: 'What is "program as value" and how do Free monads exemplify it?',
    options: [
      'Storing program source code as a string value',
      'Representing computations as first-class data structures that can be passed, stored, inspected, and transformed before execution',
      'Converting programs to numeric values for optimization',
      'Using value classes to represent program states',
    ],
    correctAnswer: 1,
    explanation: '"Program as value" means the description of a computation is a plain data structure — a first-class value. Free monads make this explicit: a `Free[F, A]` is a tree data structure you can pass around, inspect, transform, and eventually run.',
    tags: ['free monads', 'program as value', 'first-class functions'],
  },
  {
    id: 'scala-patterns-l2-077',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'type classes',
    question: 'What is the Semi-ring type class hierarchy and how does it relate to common Scala patterns?',
    options: [
      'Semigroup → Monoid → Group → Semiring → Ring forms a hierarchy for algebraic structures with two operations',
      'Semigroup → Monoid forms the hierarchy; Semiring is unrelated to Scala patterns',
      'Ring and Semiring types are specific to Spark and DataFrame operations',
      'The hierarchy is Functor → Applicative → Monad, not related to semigroup',
    ],
    correctAnswer: 0,
    explanation: 'The algebraic hierarchy (Semigroup, Monoid, Group, Semiring, Ring) appears in Cats/Spire. These type classes enable generic algorithms for summation, aggregation, and computation across many types without specific implementation knowledge.',
    tags: ['type classes', 'algebraic hierarchy', 'semigroup', 'monoid'],
  },
  {
    id: 'scala-patterns-l2-078',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'lens/optics',
    question: 'How does Monocle\'s `^|-?` operator work in optic composition?',
    options: [
      'It is the operator for composing a Lens with another Lens',
      'It is the symbol for composing a Lens with a Prism, resulting in an Optional',
      'It is the operator for composing two Traversals',
      'It is the operator for the `get` method on an Optional',
    ],
    correctAnswer: 1,
    explanation: 'In Monocle, various operators represent optic composition with different result types. `^|-?` and `andThen` on Lens+Prism compositions yield Optional. Monocle provides symbolic operators for concise composition chains.',
    tags: ['monocle', 'optics', 'composition', 'operators'],
  },
  {
    id: 'scala-patterns-l2-079',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'strategy with FP',
    question: 'How is the Decorator pattern implemented functionally in Scala?',
    options: [
      'By using implicit wrappers that add behavior to existing classes',
      'By composing functions: wrap a function f with another function g that calls f before/after its own logic',
      'By extending a class and overriding methods',
      'By using the cake pattern to add behavior layers',
    ],
    correctAnswer: 1,
    explanation: 'Functional Decorator pattern composes functions. Instead of wrapping an object, you wrap a function `A => B` with another function that calls it and adds behavior. For higher-kinded types, you wrap `A => F[B]` with `Kleisli` composition.',
    codeSnippet: `type Handler = Request => IO[Response]

def withLogging(handler: Handler): Handler = req =>
  for {
    _    <- IO(println(s"Handling $req"))
    resp <- handler(req)
    _    <- IO(println(s"Responded with $resp"))
  } yield resp

def withAuth(handler: Handler): Handler = req =>
  if (req.hasToken) handler(req) else IO.pure(Unauthorized)`,
    tags: ['strategy pattern', 'decorator pattern', 'function composition'],
  },
  {
    id: 'scala-patterns-l2-080',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'phantom types',
    question: 'What is "type-level computation" and how do phantom types enable it?',
    options: [
      'Computing values at compile time using macros',
      'Using phantom type parameters to represent and manipulate information (like state or capabilities) at the type level rather than the value level',
      'Using Scala\'s type system to compute mathematical proofs',
      'Performing JIT compilation at the type level',
    ],
    correctAnswer: 1,
    explanation: 'Type-level computation uses types to encode information that would otherwise be runtime values. Phantom types carry state (Open/Closed, Validated/Raw) at the type level. Type class instances then provide operations only for valid states.',
    tags: ['phantom types', 'type-level programming', 'compile-time'],
  },
  {
    id: 'scala-patterns-l2-081',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'reader/writer/state',
    question: 'What is `Local` (from `cats.mtl`) and how does it relate to ReaderT?',
    options: [
      'Local is a thread-local variable; unrelated to ReaderT',
      'Local[F, R] provides ask and local operations — ask gets the environment, local runs a computation with a modified environment',
      'Local is the Cats Effect equivalent of ReaderT for fiber-local state',
      'Local is a type alias for Reader in cats.mtl',
    ],
    correctAnswer: 1,
    explanation: '`Ask[F, R]` (cats-mtl) provides `ask: F[R]` to read the environment. `Local[F, R]` extends this with `local(f: R => R)(fa: F[A]): F[A]` — running a computation with a locally modified environment, like `withReader` in Haskell.',
    tags: ['reader monad', 'cats-mtl', 'Local', 'Ask'],
  },
  {
    id: 'scala-patterns-l2-082',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'interpreter pattern',
    question: 'What is a "bytecode compiler" as an example of the Interpreter pattern?',
    options: [
      'A compiler that interprets bytecode instead of compiling it',
      'An interpreter that translates the AST to bytecode (another representation) rather than directly evaluating it, enabling multiple execution targets',
      'A tool for inspecting JVM bytecode',
      'A pattern for generating Scala bytecode at runtime',
    ],
    correctAnswer: 1,
    explanation: 'A bytecode compiler is an interpreter that translates an AST to bytecode (a different representation). Instead of evaluating directly, it "interprets" the AST into instructions for a VM. This is the same Interpreter pattern applied to code generation.',
    tags: ['interpreter pattern', 'compilation', 'code generation'],
  },
  {
    id: 'scala-patterns-l2-083',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'tagless final',
    question: 'What is "effect abstraction" in the context of tagless final?',
    options: [
      'Abstracting over the specific effect type so programs can run with IO, Future, or test effects',
      'Abstracting over side effects using pure functions',
      'A pattern for defining abstract effects in Akka',
      'Abstracting over thread pool implementations',
    ],
    correctAnswer: 0,
    explanation: 'Effect abstraction means your programs are written against `F[_]` with type class constraints (Monad, Sync, Async, etc.) instead of a concrete effect like `IO`. The same program can run with `IO` in production and `Id` or `Writer` in tests.',
    tags: ['tagless final', 'effect abstraction', 'polymorphism'],
  },
  {
    id: 'scala-patterns-l2-084',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'refined types',
    question: 'What is the `Url` predicate in Refined?',
    options: [
      'A predicate that checks a String is a valid URL',
      'A predicate that checks a String is a valid URI reference',
      'A predicate for validating HTTP endpoints',
      'A predicate that checks for URL-safe characters',
    ],
    correctAnswer: 0,
    explanation: '`eu.timepit.refined.string.Url` is a predicate that checks whether a String is a syntactically valid URL (using Java\'s `java.net.URL` parser). Similarly, `Uri` checks for valid URIs.',
    codeSnippet: `import eu.timepit.refined.string.Url

type ValidUrl = String Refined Url

val url: ValidUrl = refineMV("https://example.com")
// refineMV("not a url") // Error`,
    tags: ['refined types', 'string predicates', 'Url'],
  },
  {
    id: 'scala-patterns-l2-085',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'type classes',
    question: 'What is "coherence" in the context of type classes?',
    options: [
      'All instances of a type class must have coherent method names',
      'There should be at most one type class instance for a given type, ensuring consistent behavior everywhere',
      'Type class laws must be consistent across all implementations',
      'Type class instances must be coherent with the type\'s equality implementation',
    ],
    correctAnswer: 1,
    explanation: 'Type class coherence means there is exactly one canonical instance for a given type. If multiple conflicting instances exist (orphan instances), behavior depends on which import is in scope — breaking type safety and predictability.',
    tags: ['type classes', 'coherence', 'orphan instances'],
  },
  {
    id: 'scala-patterns-l2-086',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'cake pattern',
    question: 'How does the Cake Pattern compare to ZIO\'s ZLayer approach?',
    options: [
      'ZLayer is exactly the same as the Cake Pattern but with different syntax',
      'ZLayer is an effect-based, compositional approach to DI where layers can have effects during construction and are expressed as values rather than traits',
      'ZLayer uses the cake pattern internally',
      'ZLayer is only useful for ZIO programs; the cake pattern works with all effect types',
    ],
    correctAnswer: 1,
    explanation: 'ZLayer represents service dependencies as composable values with effect-aware construction/teardown. Unlike the Cake Pattern (compile-time trait mixing), ZLayer is runtime-composable, supports scoped resources, and integrates with ZIO\'s fiber and error handling.',
    tags: ['cake pattern', 'ZLayer', 'ZIO', 'dependency injection', 'comparison'],
  },
  {
    id: 'scala-patterns-l2-087',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'free monads',
    question: 'What is a "smart constructor" in the context of a Free monad DSL?',
    options: [
      'A constructor that validates its arguments before building the ADT',
      'A helper function that wraps an ADT case in `Free.liftF`, providing a clean user-facing API for the DSL',
      'A constructor that automatically derives instances for Free monad operations',
      'A macro-generated constructor for Free monad algebras',
    ],
    correctAnswer: 1,
    explanation: 'Smart constructors in Free monad DSLs wrap ADT cases in `Free.liftF` so users call e.g. `readLine` instead of `Free.liftF(ReadLine)`. They hide the implementation details and provide the DSL\'s public API.',
    codeSnippet: `sealed trait ConsoleOp[A]
case class Print(msg: String) extends ConsoleOp[Unit]
case object ReadLine extends ConsoleOp[String]

// Smart constructors:
def print(msg: String): Free[ConsoleOp, Unit] = Free.liftF(Print(msg))
def readLine: Free[ConsoleOp, String] = Free.liftF(ReadLine)`,
    tags: ['free monads', 'smart constructors', 'DSL'],
  },
  {
    id: 'scala-patterns-l2-088',
    language: 'scala',
    level: 'level2',
    category: 'Design Patterns',
    subcategory: 'lens/optics',
    question: 'What is the `filtered` combinator in Monocle?',
    options: [
      'A Traversal that focuses on elements of a collection satisfying a predicate',
      'A Lens that throws an exception if the value does not match a predicate',
      'A Prism that only succeeds if a predicate is satisfied',
      'An Iso that filters elements during conversion',
    ],
    correctAnswer: 0,
    explanation: '`filtered(predicate)` creates a Traversal that focuses only on elements satisfying the predicate. When used with `each`, it allows targeted modification of elements matching a condition.',
    codeSnippet: `import monocle.function.all._
import monocle.Traversal

val evenNumbers: Traversal[List[Int], Int] =
  each[List[Int], Int].filter(_ % 2 == 0)

evenNumbers.modify(_ * 10)(List(1, 2, 3, 4, 5))
// List(1, 20, 3, 40, 5)`,
    tags: ['monocle', 'traversal', 'filtered'],
  },
];

export default questions;
