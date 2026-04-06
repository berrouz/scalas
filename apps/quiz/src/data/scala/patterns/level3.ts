import { Question } from '@/types/question';

const questions: Question[] = [
  {
    id: 'scala-patterns-l3-001',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'type classes',
    question: 'What is the "implicit priority" technique and why is it needed?',
    options: [
      'A way to set the priority of implicit conversion chains',
      'A technique using trait inheritance to give lower priority to fallback instances, avoiding ambiguity when a more specific instance exists',
      'A runtime priority queue for resolving implicit conflicts',
      'A compiler flag that sets which implicits take precedence',
    ],
    correctAnswer: 1,
    explanation: 'Implicit priority uses trait inheritance: a high-priority instance is defined in a trait, a low-priority fallback in a parent trait. If the high-priority instance compiles, it wins. If not (type mismatch), Scala falls back to the parent trait. Used to avoid "ambiguous implicit" errors with derived instances.',
    codeSnippet: `trait LowPriorityInstances {
  implicit def genericShow[A]: Show[A] = Show.show(_.toString)
}

object Show extends LowPriorityInstances {
  // Higher priority — preferred when available
  implicit val intShow: Show[Int] = Show.show(n => s"Int($n)")
}`,
    tags: ['type classes', 'implicit priority', 'derived instances'],
  },
  {
    id: 'scala-patterns-l3-002',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'type classes',
    question: 'What is "instance deduplication" in Shapeless-based type class derivation?',
    options: [
      'Removing duplicate type class instances from the implicit scope',
      'A technique where Shapeless ensures only one derived instance is generated even if a type appears multiple times in a generic representation',
      'Caching derived instances to avoid recomputation at runtime',
      'A macro optimization that merges duplicate method calls',
    ],
    correctAnswer: 1,
    explanation: 'When deriving type class instances for recursive or shared types using Shapeless, the same type might appear multiple times in the HList/Coproduct representation. Shapeless uses lazy implicit resolution and memoization to avoid infinite loops and duplicate derivation.',
    tags: ['type classes', 'shapeless', 'derivation', 'deduplication'],
  },
  {
    id: 'scala-patterns-l3-003',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'type classes',
    question: 'What is the problem with using implicit defs for type class derivation in deeply recursive types?',
    options: [
      'Implicit defs are not allowed in companion objects',
      'Implicit defs for recursive types can cause the compiler to diverge (infinite loop) during implicit search',
      'Implicit defs allocate more memory than implicit vals',
      'Implicit defs cannot have type class constraints',
    ],
    correctAnswer: 1,
    explanation: 'When Scala resolves implicits for recursive types (e.g., deriving Show for a tree), the implicit def for a recursive type can trigger itself recursively, causing an "implicit not found" or compiler divergence. The fix is using `Lazy[T]` (Shapeless) or `implicit def` with `by-name` evidence.',
    codeSnippet: `// Problematic: infinite implicit search loop
sealed trait Tree[A]
case class Leaf[A](value: A) extends Tree[A]
case class Branch[A](l: Tree[A], r: Tree[A]) extends Tree[A]

// Fix: use Lazy to break the cycle
implicit def treeShow[A](implicit ev: Show[A], ts: Lazy[Show[Tree[A]]]): Show[Tree[A]] = ???`,
    tags: ['type classes', 'recursive types', 'implicit search', 'Lazy'],
  },
  {
    id: 'scala-patterns-l3-004',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'tagless final',
    question: 'What is "effect lifting" in tagless final and when is it necessary?',
    options: [
      'Converting an IO to a Future by lifting the effect',
      'Using `LiftIO[F]` or similar to embed a concrete effect (IO) into a polymorphic F[_]',
      'Lifting a function from A => B into F[A] => F[B]',
      'Wrapping side effects in a lazy block before placing them in F[_]',
    ],
    correctAnswer: 1,
    explanation: 'Effect lifting allows embedding a concrete effect type (like IO) into a polymorphic `F[_]`. `LiftIO[F]` provides `liftIO[A](ioa: IO[A]): F[A]`. This is needed when you have an IO-based library but your program is polymorphic in `F`.',
    codeSnippet: `import cats.effect.LiftIO

def withMetrics[F[_]: LiftIO: Monad](program: F[Int]): F[Int] =
  for {
    _   <- LiftIO[F].liftIO(IO(println("Starting")))
    res <- program
    _   <- LiftIO[F].liftIO(IO(println(s"Done: $res")))
  } yield res`,
    tags: ['tagless final', 'effect lifting', 'LiftIO', 'cats effect'],
  },
  {
    id: 'scala-patterns-l3-005',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'tagless final',
    question: 'What is the "Onion Architecture" with tagless final?',
    options: [
      'An architecture where each layer wraps the previous one in a monad transformer',
      'An architecture where the domain algebra sits in the center with no dependencies, and outer layers (HTTP, DB) implement the algebras',
      'An architecture named after the concentric layers of an onion because it makes developers cry',
      'An architecture where services are defined as layers in ZIO',
    ],
    correctAnswer: 1,
    explanation: 'Onion Architecture with tagless final places the pure domain algebra at the center. Outer layers (infrastructure, HTTP adapters, database implementations) depend inward. The domain algebra has no knowledge of IO, HTTP, or databases — all defined by abstract algebras.',
    tags: ['tagless final', 'onion architecture', 'clean architecture'],
  },
  {
    id: 'scala-patterns-l3-006',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'tagless final',
    question: 'What is the "n+1 query problem" in tagless final programs and how is it addressed?',
    options: [
      'When a program makes N+1 database calls due to sequential flatMap chains; solved with DataLoader/Fetch patterns or batching interpreters',
      'When a program requires N+1 algebra instances; solved by combining algebras',
      'When stack depth exceeds N+1 levels; solved with trampolining',
      'When N+1 concurrent requests hit the same endpoint; solved with rate limiting',
    ],
    correctAnswer: 0,
    explanation: 'Sequential `flatMap` chains in tagless final can cause N+1 queries (fetch a list, then for each item fetch details). Solutions include: Fetch library (automatic batching/caching), Applicative parallel composition, or a batching interpreter layer.',
    codeSnippet: `// N+1 problem:
def getUsers: F[List[User]] = ???
def getPostsFor(user: User): F[List[Post]] = ???

// Bad: N+1 queries
users.flatMap(us => us.traverse(u => getPostsFor(u)))

// Better: batch query
def getPostsForUsers(ids: Set[UserId]): F[Map[UserId, List[Post]]] = ???`,
    tags: ['tagless final', 'n+1 queries', 'batching', 'fetch'],
  },
  {
    id: 'scala-patterns-l3-007',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'free monads',
    question: 'What is "applicative optimization" with Free monads?',
    options: [
      'Using Applicative instead of Monad to sequence Free monad operations, enabling parallel execution of independent operations',
      'Optimizing the Free monad by replacing Applicative with Monad',
      'Using applicative syntax to build the AST more concisely',
      'An optimization pass that removes pure/flatMap pairs',
    ],
    correctAnswer: 0,
    explanation: 'When sequencing Free monad operations with `Applicative` (via `mapN`, `*>`, `<*`) rather than `flatMap`, an optimizer can detect independent operations and execute them in parallel. Monadic chains are inherently sequential.',
    codeSnippet: `// Sequential (monadic) — cannot parallelize:
for {
  a <- fetchUser(1)
  b <- fetchUser(2)   // waits for a
} yield (a, b)

// Parallel (applicative) — optimizer can batch:
(fetchUser(1), fetchUser(2)).mapN((a, b) => (a, b))`,
    tags: ['free monads', 'applicative', 'optimization', 'parallelism'],
  },
  {
    id: 'scala-patterns-l3-008',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'free monads',
    question: 'What is the "freer monad" (Oleg Kiselyov) and how does it differ from the standard Free monad?',
    options: [
      'The freer monad is the same as Free but without the Functor constraint, using continuation-passing style internally',
      'The freer monad uses Free.apply instead of Free.liftF',
      'The freer monad adds memoization to the standard Free monad',
      'The freer monad is a version of Free monad for parallel execution',
    ],
    correctAnswer: 0,
    explanation: 'The Freer monad (from Oleg Kiselyov\'s paper) represents Free programs using a Coyoneda-like continuation: `Freer[F, A] = Pure[A] | Impure[F[X], X => Freer[F, A]]`. It does not require F to be a Functor and is computationally more efficient for left-associated binds.',
    tags: ['free monads', 'freer monad', 'continuation', 'coyoneda'],
  },
  {
    id: 'scala-patterns-l3-009',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'lens/optics',
    question: 'What is "optic laws" and why do they matter?',
    options: [
      'Rules that optics must follow for composition to work correctly and predictably',
      'Copyright laws governing the use of optics libraries',
      'Runtime checks performed by optics libraries on each operation',
      'Documentation standards for optics',
    ],
    correctAnswer: 0,
    explanation: 'Optic laws ensure predictable behavior. For a Lens: get(set(a)(s)) == a, set(get(s))(s) == s, set(b)(set(a)(s)) == set(b)(s). Violating laws leads to unexpected behavior when composing optics.',
    codeSnippet: `// Lens laws:
val lens: Lens[S, A] = ???
val s: S = ???
val a: A = ???

// 1. GetSet: set(get(s))(s) == s
lens.set(lens.get(s))(s) == s

// 2. SetGet: get(set(a)(s)) == a
lens.get(lens.set(a)(s)) == a

// 3. SetSet: set(b)(set(a)(s)) == set(b)(s)`,
    tags: ['optics', 'lens laws', 'correctness'],
  },
  {
    id: 'scala-patterns-l3-010',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'lens/optics',
    question: 'What is a "van Laarhoven lens" and how does Monocle implement it?',
    options: [
      'A lens that focuses on van-style tuple fields',
      'The encoding of a Lens as a polymorphic function using Functor: `type Lens[S, A] = forall F[_]: Functor. (A => F[A]) => S => F[S]`',
      'A lens that works on lazy data structures',
      'A lens encoding that uses continuations for composition',
    ],
    correctAnswer: 1,
    explanation: 'Van Laarhoven lenses encode optics as higher-ranked polymorphic functions. A Lens[S, A] is `forall F: Functor. (A => F[A]) => S => F[S]`. This encoding makes composition via function composition (.) automatic. Haskell\'s lens library uses this; Monocle also supports it via `PLens`.',
    tags: ['lens', 'van laarhoven', 'higher-rank polymorphism', 'monocle'],
  },
  {
    id: 'scala-patterns-l3-011',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'lens/optics',
    question: 'What is the difference between `Lens[S, A]` and `PLens[S, T, A, B]` in Monocle?',
    options: [
      'PLens supports partial focusing; Lens always has a value',
      'PLens is a polymorphic lens that can change the type of the focused value (S with field A can become T with field B)',
      'PLens is for primitive types; Lens is for reference types',
      'PLens uses Profunctors; Lens uses Functors',
    ],
    correctAnswer: 1,
    explanation: 'A `PLens[S, T, A, B]` (polymorphic lens) can modify a field of type A in an S to produce a B, giving T as the result. This allows type-changing updates. `Lens[S, A]` is `PLens[S, S, A, A]` — a monomorphic (type-preserving) lens.',
    codeSnippet: `// PLens[S, T, A, B]: focus A in S, replace with B, get T
// Example: Lens[Option[A], Option[B]] from Lens[A, B]

val pLen: PLens[Some[Int], Some[String], Int, String] = ???
pLen.set("hello")(Some(42)) // Some("hello")`,
    tags: ['lens', 'PLens', 'polymorphic optics', 'monocle'],
  },
  {
    id: 'scala-patterns-l3-012',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'phantom types',
    question: 'How do you implement a "type-safe heterogeneous container" using phantom types?',
    options: [
      'Using a Map[String, Any] with phantom type wrappers',
      'Using a type-indexed record (HMap) where keys are typed as Key[V] and values are typed as V, enforced by phantom types at the key level',
      'Using a case class with all possible field types as Options',
      'Using Scala union types (A | B) to hold heterogeneous values',
    ],
    correctAnswer: 1,
    explanation: 'A type-safe heterogeneous container uses phantom-typed keys (`class Key[V]`) so that `get(key: Key[V])` returns `V`, not Any. The phantom type on the key encodes the value type, providing type safety without casts.',
    codeSnippet: `class TypedKey[V](val name: String)

class TypedMap private (private val m: Map[TypedKey[_], Any]) {
  def get[V](key: TypedKey[V]): Option[V] =
    m.get(key).asInstanceOf[Option[V]]  // safe: phantom type guarantees

  def put[V](key: TypedKey[V], value: V): TypedMap =
    new TypedMap(m + (key -> value))
}`,
    tags: ['phantom types', 'heterogeneous container', 'type safety'],
  },
  {
    id: 'scala-patterns-l3-013',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'phantom types',
    question: 'What is "existential type" in the context of phantom types, and when does it appear?',
    options: [
      'A type that may or may not exist at runtime, like a phantom',
      'A type `T[_]` where the phantom type parameter is hidden (existential), e.g., `List[Box[_]]` holds Boxes of unknown inner type',
      'A type defined using the `exists` keyword in Scala 3',
      'A type that exists only in abstract type members',
    ],
    correctAnswer: 1,
    explanation: 'When you store phantom-typed values in a collection, you need existential types (`Box[_]`) because the phantom type is different for each element. Accessing such values requires a type-safe approach (casting or type class dispatch with evidence).',
    codeSnippet: `// You have Box[Tag1] and Box[Tag2] — can't put in List[Box[?]]
// Use existential:
type AnyBox = Box[_]
val boxes: List[AnyBox] = List(box1, box2)
// To recover type, need an extractor with evidence`,
    tags: ['phantom types', 'existential types', 'type erasure'],
  },
  {
    id: 'scala-patterns-l3-014',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'refined types',
    question: 'How does Refined integrate with Shapeless for automatic derivation of refined compound types?',
    options: [
      'It uses Shapeless to automatically generate Validate instances for compound types built from HLists',
      'It uses Shapeless for compile-time computation of predicate witnesses',
      'It uses Shapeless\'s Auto-Typeclass macro to generate refined instances',
      'Refined does not integrate with Shapeless',
    ],
    correctAnswer: 1,
    explanation: 'Refined uses Shapeless for certain compile-time operations, particularly for generating `Validate` instances for complex predicate types (And, Or, Not, etc.) through Shapeless\'s type-level computation capabilities.',
    tags: ['refined types', 'shapeless', 'derivation', 'integration'],
  },
  {
    id: 'scala-patterns-l3-015',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'refined types',
    question: 'What is the difference between `Refined.unsafeApply` and `refineV` in terms of safety?',
    options: [
      'They are the same — both are runtime-safe',
      'unsafeApply skips the predicate check entirely (trust the caller); refineV checks at runtime returning Either',
      'unsafeApply throws an exception on failure; refineV returns None on failure',
      'unsafeApply is for Scala 2; refineV is for Scala 3',
    ],
    correctAnswer: 1,
    explanation: '`Refined.unsafeApply(value)` wraps a value in a Refined type WITHOUT checking the predicate. It is unsafe — only use when you are certain the invariant holds (e.g., after external validation). `refineV` always checks. Misuse of `unsafeApply` is a safety hole.',
    codeSnippet: `// Safe: checks at runtime
val safe: Either[String, Int Refined Positive] = refineV(42)

// Unsafe: skips the check — use only when invariant is guaranteed
val unsafe: Int Refined Positive = Refined.unsafeApply(42)
// Dangerous:
val lie: Int Refined Positive = Refined.unsafeApply(-1)  // runtime lie!`,
    tags: ['refined types', 'unsafeApply', 'safety', 'refineV'],
  },
  {
    id: 'scala-patterns-l3-016',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'cake pattern',
    question: 'What is the "self-type vs. dependency injection" trade-off in large Scala projects?',
    options: [
      'Self-type gives slightly better performance; DI frameworks are easier to use',
      'Self-type provides compile-time dependency checking but creates a monolithic assembly; DI frameworks allow runtime reconfiguration and are more modular but lose compile-time guarantees',
      'They are equivalent in all respects',
      'DI frameworks are more performant; self-types are only for small projects',
    ],
    correctAnswer: 1,
    explanation: 'The Cake Pattern with self-types catches missing dependencies at compile time but makes the entire application a single compile unit. DI frameworks (Guice, MacWire) provide runtime flexibility and modular compilation but lose compile-time wiring safety.',
    tags: ['cake pattern', 'dependency injection', 'trade-offs'],
  },
  {
    id: 'scala-patterns-l3-017',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'cake pattern',
    question: 'How does MacWire compare to the Cake Pattern?',
    options: [
      'MacWire is a macro-based DI framework that auto-wires constructor parameters, generating the wiring code at compile time without self-types',
      'MacWire is a version of the Cake Pattern for microservices',
      'MacWire uses runtime reflection for dependency injection',
      'MacWire is a ZIO-specific dependency injection framework',
    ],
    correctAnswer: 0,
    explanation: 'MacWire uses macros to auto-wire constructor-injected dependencies at compile time. You define your services with constructor parameters, and `wire[MyService]` generates the wiring. It provides compile-time safety without the trait-mixing ceremony of the Cake Pattern.',
    codeSnippet: `import com.softwaremill.macwire._

class UserRepo(db: Database) { ... }
class UserService(repo: UserRepo) { ... }

object Module {
  val db: Database = new Database
  val userRepo: UserRepo = wire[UserRepo]   // auto-wires db
  val userService: UserService = wire[UserService]  // auto-wires userRepo
}`,
    tags: ['cake pattern', 'macwire', 'macro DI', 'alternatives'],
  },
  {
    id: 'scala-patterns-l3-018',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'interpreter pattern',
    question: 'What is a "catamorphism" (fold) over an ADT?',
    options: [
      'A function that builds (unfolds) an ADT from a seed value',
      'A recursion scheme that replaces each constructor of an ADT with a provided function, folding the structure into a single value',
      'A function that maps over an ADT while preserving its structure',
      'A pattern for matching all cases of an ADT in one statement',
    ],
    correctAnswer: 1,
    explanation: 'A catamorphism (cata) is a systematic way to fold an ADT: you provide one function per constructor, and the catamorphism recursively replaces each constructor application with the corresponding function application. The evaluator for an expression ADT is a catamorphism.',
    codeSnippet: `sealed trait ExprF[+A]
case class LitF(n: Int) extends ExprF[Nothing]
case class AddF[A](l: A, r: A) extends ExprF[A]

// The catamorphism:
def cata[A](alg: ExprF[A] => A)(expr: Fix[ExprF]): A =
  alg(expr.unfix.map(cata(alg)))`,
    tags: ['interpreter pattern', 'catamorphism', 'recursion schemes', 'fold'],
  },
  {
    id: 'scala-patterns-l3-019',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'interpreter pattern',
    question: 'What is a "Fix point" type and why is it used in recursion schemes?',
    options: [
      'A type that fixes a bug in Scala\'s type system',
      'A type `Fix[F[_]] = F[Fix[F]]` that ties the recursive knot, allowing ADTs to be defined in terms of their own pattern functor F',
      'A type that represents a fixed-size collection',
      'A type that prevents further modification (immutability)',
    ],
    correctAnswer: 1,
    explanation: '`Fix[F[_]]` is `case class Fix[F[_]](unfix: F[Fix[F]])`. It separates the recursive structure (Fix) from the shape (F). ADTs like Expr can be written as non-recursive ExprF[A] (pattern functor), with `Fix[ExprF]` being the recursive type. This enables generic recursion schemes like cata, ana, hylo.',
    codeSnippet: `case class Fix[F[_]](unfix: F[Fix[F]])

// ExprF is non-recursive pattern functor:
sealed trait ExprF[+A]
case class LitF(n: Int) extends ExprF[Nothing]
case class AddF[A](l: A, r: A) extends ExprF[A]

// Recursive Expr = Fix[ExprF]:
type Expr = Fix[ExprF]

val expr: Expr = Fix(AddF(Fix(LitF(1)), Fix(LitF(2))))`,
    tags: ['interpreter pattern', 'Fix point', 'recursion schemes', 'pattern functor'],
  },
  {
    id: 'scala-patterns-l3-020',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'reader/writer/state',
    question: 'What is the "indexed state monad" (IxState) and when is it useful?',
    options: [
      'A state monad indexed by an integer count',
      'A state monad that can change the type of the state from input I to output O, enabling type-safe state machine transitions',
      'A state monad for arrays indexed by position',
      'A state monad that tracks both current and previous state',
    ],
    correctAnswer: 1,
    explanation: 'The Indexed State monad `IxState[I, O, A]` models a computation that starts with state of type I and produces a value A while leaving the state of type O. This enables type-safe state machines where each transition changes the type of the state.',
    codeSnippet: `// IxState[I, O, A]: takes I, returns (O, A)
// Type-safe state machine:
def open(door: Door[Closed]): IxState[Door[Closed], Door[Open], Unit] = ???
def walk(door: Door[Open]): IxState[Door[Open], Door[Open], Unit] = ???
def close(door: Door[Open]): IxState[Door[Open], Door[Closed], Unit] = ???`,
    tags: ['state monad', 'indexed state', 'state machines', 'type safety'],
  },
  {
    id: 'scala-patterns-l3-021',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'reader/writer/state',
    question: 'What is the "Env comonad" and how does it relate to the Reader monad?',
    options: [
      'The Env comonad is the right adjoint to the Reader monad in the adjunction between Reader and Env',
      'The Env comonad is a dual to the Reader monad — it carries a fixed environment alongside a value',
      'The Env comonad is just another name for the Reader monad',
      'The Env comonad reads from a mutable environment',
    ],
    correctAnswer: 1,
    explanation: 'The Env comonad (or Product comonad) `Env[E, A] = (E, A)` carries an environment alongside the value. It is the "co-reader" — while Reader is `E => A` (a function producing A given E), Env is `(E, A)` (a pair). They form an adjunction.',
    codeSnippet: `import cats.data.Env
// Env[E, A] = (E, A)
// extract gives you A
// ask gives you E
// duplicate gives Env[E, Env[E, A]]`,
    tags: ['reader monad', 'comonad', 'Env comonad', 'adjunction'],
  },
  {
    id: 'scala-patterns-l3-022',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'strategy with FP',
    question: 'How is the "Command pattern" implemented using sealed traits and functional style in Scala?',
    options: [
      'By creating a Command interface with execute() and undo() methods',
      'By encoding commands as ADT cases and maintaining a command history as an immutable list, with an interpreter that processes each command',
      'By using the Reader monad to inject command implementations',
      'By using actors to queue and process commands asynchronously',
    ],
    correctAnswer: 1,
    explanation: 'The functional Command pattern encodes commands as ADT cases (first-class data). An interpreter executes them, and a command history (List[Command]) enables undo/redo by replaying or reversing the command log.',
    codeSnippet: `sealed trait Command
case class Insert(pos: Int, text: String) extends Command
case class Delete(pos: Int, len: Int) extends Command

def apply(doc: String, cmd: Command): String = cmd match {
  case Insert(pos, text) => doc.patch(pos, text, 0)
  case Delete(pos, len)  => doc.patch(pos, "", len)
}

def undo(doc: String, cmd: Command): String = cmd match {
  case Insert(pos, text) => apply(doc, Delete(pos, text.length))
  case Delete(pos, len)  => ??? // needs original text
}`,
    tags: ['strategy pattern', 'command pattern', 'ADT', 'FP patterns'],
  },
  {
    id: 'scala-patterns-l3-023',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'strategy with FP',
    question: 'What is the "Kleisli composition" pattern and how does it compare to the OO Chain of Responsibility?',
    options: [
      'Kleisli composition chains functions A => F[B] together, where each step can fail/skip (via Option/Either), modeling Chain of Responsibility functionally',
      'Kleisli composition is only for Reader monads and is unrelated to Chain of Responsibility',
      'Kleisli composition requires all functions to have the same type',
      'Kleisli composition is an OO pattern, not a functional one',
    ],
    correctAnswer: 0,
    explanation: 'Kleisli composition (using `andThen` or `>=>`) chains functions `A => F[B]` where F can be Option (to skip) or Either (to fail early). This models Chain of Responsibility: each handler either processes (returns Some/Right) or passes on (returns None/Left).',
    codeSnippet: `import cats.data.Kleisli

type Handler[A] = Kleisli[Option, A, A]

val authHandler: Handler[Request] = Kleisli(r => if (r.hasToken) Some(r) else None)
val rateLimitHandler: Handler[Request] = Kleisli(r => if (!r.isThrottled) Some(r) else None)

val pipeline: Handler[Request] = authHandler andThen rateLimitHandler`,
    tags: ['strategy pattern', 'Kleisli', 'chain of responsibility', 'composition'],
  },
  {
    id: 'scala-patterns-l3-024',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'builder pattern (Scala-style)',
    question: 'What is the "phantom type step builder" that prevents calling build() before required steps, without runtime overhead?',
    options: [
      'A builder that uses Option for each field and throws at build() if None',
      'A builder parameterized by a phantom type that starts empty and accumulates "done" types as steps complete; build() only compiles when the phantom type is "AllDone"',
      'A builder that uses refined types to enforce step ordering',
      'A builder that uses the cake pattern to inject required steps',
    ],
    correctAnswer: 1,
    explanation: 'A phantom type step builder uses a type-level accumulator (often via HList or bitfield of sealed traits) to track which required fields have been set. The `build()` method has a type constraint that only compiles when all required fields are present in the phantom type.',
    codeSnippet: `sealed trait HNil
sealed trait HCons[H, T]

class Builder[Have](private val m: Map[String, Any]) {
  def withName(n: String): Builder[HCons[NameSet, Have]] = new Builder(m + ("name" -> n))
  def withAge(a: Int): Builder[HCons[AgeSet, Have]] = new Builder(m + ("age" -> a))
  def build()(implicit
    ev1: Have <:< HCons[NameSet, _],
    ev2: Have <:< HCons[AgeSet, _]
  ): Person = Person(m("name").asInstanceOf[String], m("age").asInstanceOf[Int])
}`,
    tags: ['builder pattern', 'phantom types', 'type-level programming', 'HList'],
  },
  {
    id: 'scala-patterns-l3-025',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'type classes',
    question: 'What is "instance selection" and how does the implicit priority chain solve it?',
    options: [
      'Choosing between multiple available instances by selecting the most specific one via implicit priority',
      'A runtime mechanism for selecting type class instances based on values',
      'A compiler flag for controlling which instances are available',
      'A macro that selects the fastest available instance',
    ],
    correctAnswer: 0,
    explanation: 'When multiple instances could apply (e.g., a generic instance and a specific one for Int), the compiler must select one without ambiguity. The implicit priority technique (lower-priority trait for generic, higher-priority for specific) ensures the specific instance is always chosen.',
    tags: ['type classes', 'implicit priority', 'instance selection'],
  },
  {
    id: 'scala-patterns-l3-026',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'tagless final',
    question: 'What is "higher-kinded data" (HKD) and how does it relate to tagless final?',
    options: [
      'Data parameterized by a higher-kinded type F[_], so each field is wrapped in F — enabling the same structure to represent raw data, validated data, partial data, etc.',
      'A data type with more than one type parameter',
      'Data that can only be used with higher-kinded types like IO or Future',
      'A pattern for defining nested data structures',
    ],
    correctAnswer: 0,
    explanation: 'HKD uses `F[_]` as a parameter for each field: `case class UserF[F[_]](name: F[String], age: F[Int])`. With `F = Id` you get the concrete user; with `F = Option` you get partial data; with `F = IO` you get effectful fields.',
    codeSnippet: `case class UserF[F[_]](name: F[String], age: F[Int])

type User        = UserF[Id]         // concrete
type PartialUser  = UserF[Option]    // partial
type UserIO       = UserF[IO]        // effectful`,
    tags: ['tagless final', 'HKD', 'higher-kinded data', 'polymorphism'],
  },
  {
    id: 'scala-patterns-l3-027',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'free monads',
    question: 'What is the "operational monad" and how does it differ from Free?',
    options: [
      'The operational monad uses a GADT-based representation that gives better asymptotic complexity for left-associated binds',
      'The operational monad is the same as Free but with a different constructor name',
      'The operational monad is the Free monad with a built-in interpreter',
      'The operational monad requires all effects to be pure',
    ],
    correctAnswer: 0,
    explanation: 'The operational monad (by Heinrich Apfelmus) uses a GADT encoding: `data Program instr a = Return a | instr a :>>= (a -> Program instr b)`. This avoids the O(n²) left-bind problem of naive Free monad by using a right-associated representation internally.',
    tags: ['free monads', 'operational monad', 'GADT', 'performance'],
  },
  {
    id: 'scala-patterns-l3-028',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'refined types',
    question: 'What is the `Regex` predicate in Refined and what are its compile-time limitations?',
    options: [
      'It validates a String against a regex at compile time with zero overhead',
      'It checks that a String matches the given regex, but the regex itself must be a literal string known at compile time for compile-time checking; runtime values use refineV',
      'It validates regex syntax itself, not string values',
      'It only works with simple patterns without capture groups',
    ],
    correctAnswer: 1,
    explanation: '`MatchesRegex[W.\\`"pattern"\\`.T]` checks a String against a compile-time literal regex using macros for literal values. For runtime strings, `refineV` is used. The regex pattern must be a compile-time literal for macro-based checking.',
    codeSnippet: `import eu.timepit.refined.string.MatchesRegex
import shapeless.Witness

type Phone = String Refined MatchesRegex[W.\`"\\\\d{10}"\`.T]

val p: Phone = refineMV("1234567890")   // OK
// refineMV("not-a-phone") // Compile error`,
    tags: ['refined types', 'MatchesRegex', 'compile-time', 'regex'],
  },
  {
    id: 'scala-patterns-l3-029',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'lens/optics',
    question: 'What is "Profunctor optics" and how does it unify the optic hierarchy?',
    options: [
      'A way to define optics using profunctors, allowing all optic types to be represented uniformly as instances of specific profunctor type classes',
      'A performance optimization for optic composition using profunctors',
      'A way to define optics that work on both input and output of functions',
      'A Monocle-specific pattern for composing optics with profunctors',
    ],
    correctAnswer: 0,
    explanation: 'Profunctor optics encode all optic types (Lens, Prism, Traversal, etc.) as instances of a specific Profunctor subclass. `Optic p s t a b = p a b -> p s t`. This unifies the entire optic hierarchy and makes composition automatic via Profunctor composition.',
    tags: ['optics', 'profunctor optics', 'type class hierarchy', 'van laarhoven'],
  },
  {
    id: 'scala-patterns-l3-030',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'tagless final',
    question: 'What is the "bracket" pattern in tagless final programs?',
    options: [
      'Using square brackets to denote type parameters in algebra traits',
      'A pattern for safely acquiring, using, and releasing a resource, guaranteed even on errors, using `bracket` or `Resource`',
      'A syntactic pattern for wrapping algebra methods in parentheses',
      'A pattern for grouping related operations in a transaction bracket',
    ],
    correctAnswer: 1,
    explanation: '`bracket(acquire)(use)(release)` is a function that runs `acquire`, then `use(resource)`, then `release(resource)` — guaranteed even if `use` throws or the fiber is cancelled. It is the foundation of safe resource management in Cats Effect.',
    codeSnippet: `import cats.effect.Sync

def withFile[F[_]: Sync, A](path: String)(use: File => F[A]): F[A] =
  Sync[F].bracket(
    Sync[F].delay(new File(path)) // acquire
  )(use)                          // use
  (f => Sync[F].delay(f.close())) // release`,
    tags: ['tagless final', 'bracket', 'resource management', 'cats effect'],
  },
  {
    id: 'scala-patterns-l3-031',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'type classes',
    question: 'What is "type class algebra" and the "lawful" vs "unlawful" instance distinction?',
    options: [
      'Lawful instances satisfy the type class laws (e.g., Monad laws); unlawful ones provide the methods but violate the laws, potentially breaking generic algorithms',
      'Lawful instances are those defined in the companion object; unlawful ones are orphan instances',
      'Lawful instances use implicit vals; unlawful ones use implicit defs',
      'Unlawful instances are defined with the @unsafe annotation',
    ],
    correctAnswer: 0,
    explanation: 'Type class laws ensure generic code relying on the type class behaves correctly. An unlawful instance (implements the interface but violates laws) can cause subtle bugs in generic code that assumes the laws hold — e.g., a Monad that violates associativity would break for-comprehensions.',
    tags: ['type classes', 'laws', 'correctness', 'Monad'],
  },
  {
    id: 'scala-patterns-l3-032',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'free monads',
    question: 'What is "Church encoding" and how is it related to Free monads?',
    options: [
      'Encoding church numbers as type-level Peano numerals for type-level arithmetic',
      'Representing data types as functions (their eliminator/fold), which gives a "final" encoding — the Church encoding of a Free monad is essentially the tagless final approach',
      'A way to encode Free monad programs as XML for serialization',
      'A way to avoid using case classes in Free monad DSLs',
    ],
    correctAnswer: 1,
    explanation: 'Church encoding represents an ADT as its fold function. The Church encoding of a Free monad (representing the program as its own fold/catamorphism) is the CPS/continuation representation, which is the basis of tagless final — programs are represented as their own evaluation.',
    tags: ['free monads', 'church encoding', 'tagless final', 'duality'],
  },
  {
    id: 'scala-patterns-l3-033',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'cake pattern',
    question: 'What is the "diamond problem" in the Cake Pattern and how does Scala\'s linearization resolve it?',
    options: [
      'When two components have the same method name; resolved by the compiler choosing the first definition alphabetically',
      'When two parent traits provide the same member; resolved by Scala\'s trait linearization — the last mixed-in trait\'s definition wins (C3 linearization)',
      'When a component has a circular dependency with itself; resolved by lazy vals',
      'When a component implements two interfaces with the same method signature; resolved by explicit override',
    ],
    correctAnswer: 1,
    explanation: 'When two mixed traits provide the same member, Scala uses C3 linearization to determine which one wins. The "last wins" rule (the rightmost in the mixins, plus reverse depth-first traversal) determines the method resolution order.',
    codeSnippet: `trait A { def greet: String = "A" }
trait B extends A { override def greet: String = "B" }
trait C extends A { override def greet: String = "C" }

object D extends B with C  // linearization: D → C → B → A
D.greet  // "C" (C is later in the mixin order)`,
    tags: ['cake pattern', 'diamond problem', 'linearization', 'trait mixing'],
  },
  {
    id: 'scala-patterns-l3-034',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'phantom types',
    question: 'How do you implement a type-safe HTTP client using phantom types for request/response encoding?',
    options: [
      'By using refined types for URL validation',
      'By parameterizing the Request type with phantom types for method (GET/POST), authentication state, and body type to prevent misuse at compile time',
      'By using sealed traits for HTTP methods',
      'By using macros to validate HTTP requests at compile time',
    ],
    correctAnswer: 1,
    explanation: 'A type-safe HTTP client uses phantom types to encode request properties: `Request[GET, Unauthenticated, NoBody]` vs `Request[POST, Authenticated, JsonBody]`. Methods like `withAuth` and `withBody` transition the phantom type parameters, preventing invalid combinations.',
    codeSnippet: `sealed trait GET; sealed trait POST
sealed trait Authenticated; sealed trait Unauthenticated

class Request[Method, Auth, Body] private (val url: String)
object Request {
  def get(url: String): Request[GET, Unauthenticated, Unit] = new Request(url)
  def post(url: String): Request[POST, Unauthenticated, Unit] = new Request(url)
}

def withAuth[M, B](r: Request[M, Unauthenticated, B], token: String): Request[M, Authenticated, B] = ???
def send[B](r: Request[GET, Authenticated, B]): Response = ???`,
    tags: ['phantom types', 'type-safe API', 'HTTP client'],
  },
  {
    id: 'scala-patterns-l3-035',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'reader/writer/state',
    question: 'What is the "monad transformer stack" and what are its main drawbacks?',
    options: [
      'Stacking multiple monad transformers (e.g., EitherT[StateT[IO, S, *], E, *]) to combine effects; drawbacks are complex types, poor performance, and difficult reasoning',
      'A stack data structure implemented using monads',
      'A pattern for stacking multiple Reader monads',
      'A way to compose Writer and State monads automatically',
    ],
    correctAnswer: 0,
    explanation: 'Monad transformer stacks combine multiple effects by stacking transformers. `EitherT[StateT[IO, S, *], E, A]` adds error handling and state to IO. Drawbacks: complex type signatures, each `flatMap` requires multiple levels of lifting, and performance degrades with stack depth.',
    codeSnippet: `type App[A] = EitherT[StateT[IO, AppState, *], AppError, A]
// Complex: every operation requires liftF, liftEither, etc.
// Alternative: tagless final with MTL type classes (no explicit transformer stack)`,
    tags: ['monad transformers', 'EitherT', 'StateT', 'stack', 'drawbacks'],
  },
  {
    id: 'scala-patterns-l3-036',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'lens/optics',
    question: 'What is "anamorphism" (unfold) and how does it complement catamorphism?',
    options: [
      'An anamorphism builds (unfolds) a data structure from a seed value, while a catamorphism folds (destroys) it',
      'An anamorphism is a catamorphism that runs in reverse',
      'An anamorphism is used for traversal while catamorphism is used for transformation',
      'Anamorphism applies to optics; catamorphism applies to interpreters',
    ],
    correctAnswer: 0,
    explanation: 'An anamorphism (ana) unfolds a data structure from a seed: given `A`, it produces `F[A]` repeatedly until termination. Combined with catamorphism, you get a "hylomorphism" (ana then cata) — unfold a structure then fold it — without building the intermediate structure in some cases.',
    tags: ['recursion schemes', 'anamorphism', 'catamorphism', 'unfold'],
  },
  {
    id: 'scala-patterns-l3-037',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'type classes',
    question: 'What is the "functional dependency" injection pattern using type class evidence?',
    options: [
      'Using implicits to provide evidence that a given computation satisfies a type-level predicate',
      'Using `=:=` or `<:<` as implicit evidence types to prove type relationships at compile time',
      'Both A and B describe the same concept from different angles',
      'Neither — functional dependency injection is a DI framework pattern, not type class related',
    ],
    correctAnswer: 2,
    explanation: 'Type class evidence (`implicit ev: A =:= B`) serves as compile-time proof that certain type relationships hold. This is used in the builder pattern, type-safe APIs, and phantom type state machines — providing "proof objects" that enforce invariants.',
    tags: ['type classes', 'implicit evidence', '=:=', '<:<'],
  },
  {
    id: 'scala-patterns-l3-038',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'tagless final',
    question: 'What is "suspension" in `F[_]` and why does `Sync[F]` provide it?',
    options: [
      'Pausing a fiber in Cats Effect',
      'Wrapping a by-name (lazy, side-effectful) expression in F so it is not executed immediately but only when the F value is interpreted',
      'Suspending the type class resolution until runtime',
      'Delaying the implicit search for F until the program is run',
    ],
    correctAnswer: 1,
    explanation: '`Sync[F].delay(expr)` creates an `F[A]` that, when run, evaluates `expr` (a by-name expression that may have side effects). This is how you wrap side-effectful code (like calling a database) in a purely functional effect type without executing it at definition time.',
    tags: ['tagless final', 'suspension', 'Sync', 'side effects'],
  },
  {
    id: 'scala-patterns-l3-039',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'refined types',
    question: 'How do you make a refined type "transparent" in a library API so users don\'t need to know about it?',
    options: [
      'By using type aliases that hide the Refined wrapper',
      'By exposing only the value type in the public API while using refined types internally, with smart constructors that validate and return Either',
      'By using AnyVal to erase the Refined wrapper at runtime',
      'Refined types cannot be made transparent — they always appear in the public API',
    ],
    correctAnswer: 1,
    explanation: 'To hide refinement from public APIs, expose smart constructors that accept raw types, validate internally with `refineV`, and return `Either[ValidationError, YourType]`. Inside, use refined types freely. The external caller only sees familiar types.',
    codeSnippet: `// Public API — no mention of Refined:
case class UserId private (value: Long)

object UserId {
  def fromLong(n: Long): Either[String, UserId] =
    if (n > 0) Right(new UserId(n))
    else Left(s"UserId must be positive, got $n")
}`,
    tags: ['refined types', 'API design', 'smart constructors', 'encapsulation'],
  },
  {
    id: 'scala-patterns-l3-040',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'free monads',
    question: 'What is "algebraic effect" and how does it compare to Free monads?',
    options: [
      'Algebraic effects are a programming language feature (like in Koka or OCaml 5) that provides effect handlers; Free monads simulate this in Scala via library-level encodings',
      'Algebraic effects are the same as Free monads with a different name',
      'Algebraic effects are only possible with continuations, not available in Scala',
      'Algebraic effects are Free monads that satisfy algebraic laws',
    ],
    correctAnswer: 0,
    explanation: 'Algebraic effects (in Koka, OCaml 5, etc.) are a language feature for effect handling with first-class continuations. Scala simulates them via Free monads (effects as data) or tagless final. They are conceptually related but the language-level version has native support.',
    tags: ['free monads', 'algebraic effects', 'continuations', 'comparison'],
  },
  {
    id: 'scala-patterns-l3-041',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'cake pattern',
    question: 'What is "path-dependent types" and how do they feature in the Cake Pattern?',
    options: [
      'Types that depend on a file path for configuration',
      'Types that are members of a specific object instance; in Cake Pattern, a type declared in a component trait is unique to each component instance',
      'Types in a dependency path (A depends on B depends on C)',
      'Types that depend on the evaluation path through pattern matching',
    ],
    correctAnswer: 1,
    explanation: 'Path-dependent types are inner types unique to a specific outer object. In the Cake Pattern, `type UserService` declared inside a trait has a different type for each different object instance that mixes the trait. This is subtle but allows very precise type-level component tracking.',
    codeSnippet: `trait Component {
  type Service  // path-dependent type
  val service: Service
}

object CompA extends Component {
  type Service = UserService  // CompA.Service
  val service = new UserService
}

object CompB extends Component {
  type Service = OrderService  // CompB.Service — different type!
  val service = new OrderService
}`,
    tags: ['cake pattern', 'path-dependent types', 'abstract type members'],
  },
  {
    id: 'scala-patterns-l3-042',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'interpreter pattern',
    question: 'What is a "reification" and how does it relate to the interpreter pattern?',
    options: [
      'Converting a computation from runtime representation to compile-time representation',
      'Turning operations/computations into first-class values (data) that can be stored, passed, and later interpreted — the essence of the interpreter/Free monad pattern',
      'A JVM optimization that converts objects to primitive types',
      'A pattern for generating bytecode from Scala ASTs',
    ],
    correctAnswer: 1,
    explanation: 'Reification means making something concrete — turning an operation into a data value. In the interpreter pattern, we reify computations: instead of running them immediately, we create data structures (ADT nodes) representing them. The interpreter later gives them meaning.',
    tags: ['interpreter pattern', 'reification', 'first-class computations'],
  },
  {
    id: 'scala-patterns-l3-043',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'lens/optics',
    question: 'What is the `Setter` optic and how is it more general than Lens?',
    options: [
      'A Setter is a special Lens for setting enum values',
      'A Setter[S, A] only provides modify (no get), making it more general — Lens extends Setter with get',
      'A Setter provides batch updates while Lens provides single-field updates',
      'A Setter is the same as a Lens but for mutable data',
    ],
    correctAnswer: 1,
    explanation: '`Setter[S, A]` provides only the `modify: (A => A) => S => S` operation, without a `get`. This is more general than a Lens (which requires both get and set). Traversals are Setters. The full optic hierarchy from most to least general is: Iso < Lens < Prism < Optional < Traversal < Setter.',
    tags: ['optics', 'setter', 'lens', 'optic hierarchy'],
  },
  {
    id: 'scala-patterns-l3-044',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'type classes',
    question: 'What is "supertype class" or "type class inheritance" and what are its pitfalls?',
    options: [
      'When a type class extends another type class, inheriting its methods; pitfall is that instances of the superclass are not automatically instances of the subclass',
      'When a regular class extends a type class trait; pitfall is that it defeats the purpose of type classes',
      'When type class instances form an inheritance hierarchy; pitfall is method conflicts',
      'Type classes cannot be extended — they have no inheritance',
    ],
    correctAnswer: 0,
    explanation: 'Type classes can form hierarchies (Monad extends Applicative extends Functor). Pitfall: if you provide a Monad instance, you still need to explicitly provide Applicative and Functor instances (or use inheritance in the instance). In Cats, Monad extends Applicative, so one definition is enough.',
    tags: ['type classes', 'type class hierarchy', 'inheritance', 'Monad'],
  },
  {
    id: 'scala-patterns-l3-045',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'phantom types',
    question: 'What is "phantom type variance" and when does it matter?',
    options: [
      'Whether the phantom type parameter is covariant (+T), contravariant (-T), or invariant (T), affecting subtyping relationships',
      'How much variance is introduced by phantom types at runtime',
      'The variance of the actual type, ignoring phantom parameters',
      'A special mode in Scala that makes phantom types variance-agnostic',
    ],
    correctAnswer: 0,
    explanation: 'Phantom type variance matters for subtyping. `Box[+T]` means `Box[Dog]` is a subtype of `Box[Animal]`. In phantom type state machines, invariance (T) is usually desired to prevent accidental widening of the state type. Wrong variance can create security holes.',
    codeSnippet: `// Invariant (safest for phantom state machines):
class Connection[S](url: String)  // invariant S

// Covariant (allows widening):
class Token[+P](value: String)  // Token[Validated] <: Token[AnyState]

// Wrong: Token[Unvalidated] could be widened to Token[Validated] via variance!`,
    tags: ['phantom types', 'variance', 'covariance', 'invariance'],
  },
  {
    id: 'scala-patterns-l3-046',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'reader/writer/state',
    question: 'How does `ReaderT[F, R, A]` interact with `Kleisli[F, R, A]` in Cats?',
    options: [
      'They are completely separate types with different interfaces',
      'ReaderT is a type alias for Kleisli: type ReaderT[F[_], R, A] = Kleisli[F, R, A]',
      'Kleisli is a type alias for ReaderT',
      'They have the same operations but different performance characteristics',
    ],
    correctAnswer: 1,
    explanation: 'In Cats, `ReaderT[F[_], R, A]` IS `Kleisli[F, R, A]` — they are the same type (ReaderT is typically defined as a type alias or the same class). Both represent `R => F[A]`. Using one or the other is a matter of naming convention.',
    tags: ['reader monad', 'ReaderT', 'Kleisli', 'type aliases'],
  },
  {
    id: 'scala-patterns-l3-047',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'tagless final',
    question: 'What is "effect isolation" in a tagless final architecture?',
    options: [
      'Isolating effects to specific thread pools',
      'Using type class constraints to precisely specify which effects a function needs, so functions cannot use effects they haven\'t declared',
      'Running effects in isolated processes',
      'Using sandboxes to prevent effects from propagating',
    ],
    correctAnswer: 1,
    explanation: 'Effect isolation means each function declares only the F[_] type class capabilities it needs. A pure computation uses `Functor[F]`; one that only needs to sequence uses `Monad[F]`; one that can fail uses `MonadError[F, E]`. This documents and enforces what each function can do.',
    tags: ['tagless final', 'effect isolation', 'capability-based design'],
  },
  {
    id: 'scala-patterns-l3-048',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'refined types',
    question: 'What is the `Trimmed` predicate in Refined and when is it useful?',
    options: [
      'A predicate checking that a String has no leading or trailing whitespace',
      'A predicate that trims whitespace from a String before validation',
      'A predicate checking that a collection has been sorted and deduped',
      'A predicate for checking file sizes',
    ],
    correctAnswer: 0,
    explanation: '`Trimmed` from `eu.timepit.refined.string` checks that a String has no leading or trailing whitespace (i.e., `s == s.trim`). It is useful for validating names, tokens, or identifiers where whitespace should not be present.',
    codeSnippet: `import eu.timepit.refined.string.Trimmed

type TrimmedString = String Refined Trimmed

val name: TrimmedString = refineMV("Alice")
// refineMV(" Alice ") // Compile error — has spaces`,
    tags: ['refined types', 'Trimmed', 'string predicates'],
  },
  {
    id: 'scala-patterns-l3-049',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'cake pattern',
    question: 'What is the "component lifecycle" problem in the Cake Pattern and how is it typically addressed?',
    options: [
      'Components cannot be stopped once started; addressed by JVM shutdown hooks',
      'The Cake Pattern has no built-in support for resource initialization/teardown; often addressed using Cats Effect Resource, ZIO ZLayer, or explicit lifecycle management',
      'Components have circular lifecycle dependencies; addressed by lazy vals',
      'Components cannot be restarted; addressed by creating new application objects',
    ],
    correctAnswer: 1,
    explanation: 'The Cake Pattern assembles components but has no lifecycle semantics. Connecting to a database or starting a server needs careful ordering and teardown. Solutions: use Cats Effect `Resource` in each component, use ZIO\'s `ZLayer` with scoped resources, or implement explicit start/stop methods.',
    tags: ['cake pattern', 'lifecycle', 'resource management', 'cats effect'],
  },
  {
    id: 'scala-patterns-l3-050',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'builder pattern (Scala-style)',
    question: 'What is the "type-level record" approach to building complex structures?',
    options: [
      'Using case classes as records',
      'Using Shapeless HList as a type-level record where field names and types are tracked at the type level',
      'Using a Map[String, Any] as a type-erased record',
      'Using named tuples (available in Scala 3) as records',
    ],
    correctAnswer: 1,
    explanation: 'Shapeless\'s LabelledGeneric and FieldType allow using HLists where each position is tagged with a field name as a singleton type. This enables generic programming over record types with field-level type safety.',
    codeSnippet: `import shapeless._
import shapeless.record._

val rec = ("name" ->> "Alice") :: ("age" ->> 30) :: HNil

rec("name")  // "Alice" at compile time, type String
rec("age")   // 30 at compile time, type Int`,
    tags: ['builder pattern', 'shapeless', 'LabelledGeneric', 'records'],
  },
  {
    id: 'scala-patterns-l3-051',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'free monads',
    question: 'What is the complexity of left-associated `flatMap` in a naive Free monad and how is it solved?',
    options: [
      'O(log n); solved by balanced tree representation',
      'O(n²) in the depth; solved by using a Queue (right-associated representation) or the Reflection Without Remorse technique',
      'O(n) in the number of operations; acceptable for most use cases',
      'There is no complexity issue with Free monad flatMap',
    ],
    correctAnswer: 1,
    explanation: 'Naive Free monad re-traverses the left spine of `flatMap` chains, giving O(n²) for left-associated binds. Solutions include: representing the continuation as a queue (the "Reflection Without Remorse" paper), using the operational monad encoding, or the Trampoline with accumulated continuations.',
    tags: ['free monads', 'flatMap complexity', 'performance', 'Reflection Without Remorse'],
  },
  {
    id: 'scala-patterns-l3-052',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'type classes',
    question: 'What is the "implicit scope pollution" problem and how do you avoid it?',
    options: [
      'When too many implicits slow down compilation; avoided by using explicit imports',
      'When importing a wildcard import brings too many implicits into scope, causing ambiguity or unexpected resolution; avoided by explicit imports',
      'When implicits from different modules conflict; avoided by using modules',
      'All of the above describe different aspects of the same problem',
    ],
    correctAnswer: 3,
    explanation: 'Wildcard imports (import cats.implicits._) can bring many instances into scope, slowing compilation and risking ambiguity. Best practices: prefer explicit imports (import cats.instances.list._), use companion object placement (requires no import), or use explicit parameters for clarity.',
    tags: ['type classes', 'implicit scope', 'imports', 'compilation'],
  },
  {
    id: 'scala-patterns-l3-053',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'lens/optics',
    question: 'What is the `Fold` optic and how is it different from Traversal?',
    options: [
      'A Fold can focus on multiple elements like Traversal, but only supports reading (getting all values) — not setting or modifying',
      'A Fold focuses on a single element that may be absent',
      'A Fold is a Traversal optimized for fold operations',
      'A Fold and Traversal are identical — fold is just another name',
    ],
    correctAnswer: 0,
    explanation: 'A `Fold[S, A]` provides `getAll(s: S): List[A]` and supports folding operations, but unlike Traversal, it has no `set` or `modify`. A Traversal is a Fold, but not vice versa. Folds are useful for read-only access to multiple elements.',
    tags: ['optics', 'fold', 'traversal', 'monocle'],
  },
  {
    id: 'scala-patterns-l3-054',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'strategy with FP',
    question: 'How do you implement "policy-based design" using Scala type classes?',
    options: [
      'By encoding policies as ADT cases and using the interpreter pattern',
      'By encoding each "policy" (retry, timeout, caching, etc.) as a type class and composing them via type class instances',
      'By using the cake pattern to inject policies as components',
      'By using sealed traits for policies and pattern matching to select them',
    ],
    correctAnswer: 1,
    explanation: 'Policy-based design (from C++ templates) encodes each policy as a type class. A function accepts type class instances for each policy: `RetryPolicy[F]`, `TimeoutPolicy[F]`, `CachePolicy[F]`. Swapping behavior means swapping the implicit instance.',
    codeSnippet: `trait RetryPolicy[F[_]] {
  def retry[A](fa: F[A], maxAttempts: Int): F[A]
}

trait CachePolicy[F[_]] {
  def cached[A](key: String, fa: F[A]): F[A]
}

def fetchData[F[_]: Monad](url: String)(
  implicit retry: RetryPolicy[F], cache: CachePolicy[F]
): F[String] = cache.cached(url, retry.retry(fetchRaw(url), 3))`,
    tags: ['strategy pattern', 'policy-based design', 'type classes'],
  },
  {
    id: 'scala-patterns-l3-055',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'reader/writer/state',
    question: 'What is "global state" pattern vs "Reader monad" pattern for configuration?',
    options: [
      'Global state uses a mutable var; Reader monad passes the config as an argument explicitly',
      'Global state uses thread-local storage; Reader monad uses the call stack',
      'Global state uses a static object; Reader monad is a monad wrapping a function from config to result, making dependencies explicit',
      'Both A and C describe the same distinction from different angles',
    ],
    correctAnswer: 3,
    explanation: 'Global state (a global var or a JVM static) is implicit and mutable — hard to test, thread-unsafe, and opaque. Reader monad passes configuration explicitly as a function parameter, making dependencies visible, thread-safe (each run gets its own config), and testable.',
    tags: ['reader monad', 'global state', 'dependency injection', 'testing'],
  },
  {
    id: 'scala-patterns-l3-056',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'tagless final',
    question: 'What is the "tagless final with ADT" antipattern?',
    options: [
      'Using ADTs inside tagless final algebras for return types',
      'Putting the ADT definition inside the algebra trait instead of outside it',
      'Defining a tagless final algebra as a sealed trait (ADT) instead of a parameterized trait, recreating Free monad overhead without the benefits',
      'Using too many ADT cases in a single algebra',
    ],
    correctAnswer: 2,
    explanation: 'If you encode operations as an ADT inside a trait parameterized by F, you end up with both the overhead of Free monads (building a data structure) and the complexity of tagless final (F[_] parameter). Choose one: ADT + interpreter (Free-style) OR trait F[_] (tagless final).',
    tags: ['tagless final', 'antipatterns', 'ADT', 'free monads'],
  },
  {
    id: 'scala-patterns-l3-057',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'refined types',
    question: 'What is the trade-off between using refined types everywhere vs smart constructors?',
    options: [
      'Refined types add no overhead; smart constructors are always slower',
      'Refined types propagate constraints through the type system (more powerful) but add Refined wrapper complexity and require the refined library; smart constructors are simpler but require manual discipline',
      'Smart constructors are more type-safe; refined types only work for primitives',
      'There is no trade-off — use both always',
    ],
    correctAnswer: 1,
    explanation: 'Refined types make constraints part of the type signature — impossible to forget. But they add the `Refined` wrapper, library dependency, and can be verbose. Smart constructors are simpler (just return Either) but constraints are only checked at the boundary — not propagated in the type.',
    tags: ['refined types', 'smart constructors', 'trade-offs', 'API design'],
  },
  {
    id: 'scala-patterns-l3-058',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'interpreter pattern',
    question: 'What is the "Scott encoding" of an ADT and how is it used in interpreters?',
    options: [
      'Encoding an ADT as a record of functions (one per constructor), where the value is represented as a function that accepts the elimination functions',
      'Encoding an ADT as a sum of products using Scott\'s theorem',
      'A way to serialize ADTs for network transmission',
      'A pattern named after the musician Scott who invented functional programming',
    ],
    correctAnswer: 0,
    explanation: 'Scott encoding represents `data T = A | B x` as `type T = forall r. (() -> r) -> (x -> r) -> r` — a function that takes a handler for each case. It is related to continuation-passing style and is equivalent to the Church encoding but more direct for ADTs with multiple constructors.',
    tags: ['interpreter pattern', 'Scott encoding', 'Church encoding', 'CPS'],
  },
  {
    id: 'scala-patterns-l3-059',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'type classes',
    question: 'What is the "Yoneda lemma" and how is it applied in Scala type class programming?',
    options: [
      'A mathematical theorem that says every functor is isomorphic to its Yoneda representation, enabling optimization by deferring map applications',
      'A theorem about the uniqueness of type class instances',
      'A lemma about natural transformations between type classes',
      'A theorem used in Shapeless for HList manipulation',
    ],
    correctAnswer: 0,
    explanation: 'The Yoneda lemma states that `F[A]` is isomorphic to `forall B. (A => B) => F[B]`. In Scala, this means you can defer/fuse multiple `map` operations without intermediate allocations — the basis of Coyoneda optimization for Free monads.',
    codeSnippet: `import cats.free.Yoneda

// Yoneda[F, A] = forall B. (A => B) => F[B]
// Yoneda.apply fuses multiple map calls:
val y: Yoneda[List, String] = Yoneda(List(1, 2, 3))
val result = y.map(_.toString).map(s => s + "!").run
// Only one traversal, not two`,
    tags: ['type classes', 'Yoneda lemma', 'Coyoneda', 'optimization'],
  },
  {
    id: 'scala-patterns-l3-060',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'phantom types',
    question: 'How do you implement a "capabilities" pattern using phantom types for authorization?',
    options: [
      'Using sealed traits as capability markers in phantom type parameters; functions only accept types parameterized with the correct capability phantom',
      'Using role-based access control with sealed traits',
      'Using refined types to validate permissions',
      'Using the cake pattern to inject authorization services',
    ],
    correctAnswer: 0,
    explanation: 'The capabilities pattern represents permissions as phantom types: `sealed trait Admin`, `sealed trait ReadOnly`. A `Session[+Cap]` has a phantom capability. Functions requiring admin access only accept `Session[Admin]`, preventing unauthorized calls at compile time.',
    codeSnippet: `sealed trait Admin
sealed trait ReadOnly
sealed trait SuperAdmin extends Admin

class Session[+Cap] private (val userId: Long)

object Session {
  def readOnly(userId: Long): Session[ReadOnly] = new Session(userId)
  def admin(userId: Long): Session[Admin] = new Session(userId)
}

def deleteUser(id: Long)(implicit s: Session[Admin]): Unit = ???
// deleteUser(1)(readOnlySession) // Compile error!`,
    tags: ['phantom types', 'capabilities', 'authorization', 'compile-time safety'],
  },
  {
    id: 'scala-patterns-l3-061',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'free monads',
    question: 'What is "monadic reflection" (shift/reset) and how does it relate to Free monads?',
    options: [
      'A runtime optimization technique for Free monads',
      'A way to use delimited continuations to run monadic code as if it were direct-style, related to algebraic effects and Free monads via CPS transformation',
      'A technique for inspecting Free monad structure via reflection',
      'A JVM bytecode transformation for optimizing monadic chains',
    ],
    correctAnswer: 1,
    explanation: 'Monadic reflection (via shift/reset or reset/shift continuations) allows writing monadic code in direct style. It is related to Free monads via the Curry-Howard correspondence — both are ways to reify effects. Direct style Scala (Scala 3 with boundary/break or Kyo) implements this.',
    tags: ['free monads', 'continuations', 'direct style', 'algebraic effects'],
  },
  {
    id: 'scala-patterns-l3-062',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'tagless final',
    question: 'What is the "tagless final vs IO-based design" debate?',
    options: [
      'Whether to use tagless final (F[_] algebra) or simply use IO directly, coupling implementation to the specific IO type',
      'Whether to use IO[A] or Future[A] as the primary effect type',
      'Whether algebras should return IO or Unit',
      'There is no meaningful debate — tagless final is always superior',
    ],
    correctAnswer: 0,
    explanation: 'Some argue that tagless final adds complexity (many type class bounds, implicit hell) for limited benefit when `IO` is the only practical interpreter. "Just use IO" proponents point out that swapping IO for tests is possible without tagless final (using IO with test-friendly backends). The debate is about trade-offs in real projects.',
    tags: ['tagless final', 'IO', 'design decisions', 'pragmatism'],
  },
  {
    id: 'scala-patterns-l3-063',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'lens/optics',
    question: 'What is the `Getter` optic and how does it fit in the optic hierarchy?',
    options: [
      'A special case of Lens that only has get, no set',
      'An optic that provides only a read operation — `get: S => A` — without any modification capability; it is the dual of Setter',
      'An optic equivalent to a Prism without the reverseGet',
      'A read-only traversal for collections',
    ],
    correctAnswer: 1,
    explanation: '`Getter[S, A]` represents a read-only optic: just `get(s: S): A`. It is the dual of Setter. In the full optic hierarchy, Fold extends Getter (multiple reads), and Getter is useful for read-only views of data without the bidirectional nature of Lens.',
    tags: ['optics', 'getter', 'optic hierarchy', 'monocle'],
  },
  {
    id: 'scala-patterns-l3-064',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'builder pattern (Scala-style)',
    question: 'What is the "Aux pattern" in Shapeless and how is it used in builder-like type-level programming?',
    options: [
      'An auxiliary class for holding builder state',
      'A technique that uses a type member to expose the output type of a type-level computation as a type parameter, enabling the compiler to infer the result type',
      'A macro-generated auxiliary companion object',
      'A pattern for providing default values in Shapeless records',
    ],
    correctAnswer: 1,
    explanation: 'The Aux pattern is used when a type class computes an output type as a type member. `TypeClass.Aux[A, Out] = TypeClass[A] { type Result = Out }` exposes `Result` as a type parameter so the compiler can infer and propagate it in generic functions.',
    codeSnippet: `trait Concat[A, B] {
  type Result
  def concat(a: A, b: B): Result
}

object Concat {
  type Aux[A, B, R] = Concat[A, B] { type Result = R }
}

// Usage: compiler can infer R
def addConcat[A, B, R](a: A, b: B)(implicit ev: Concat.Aux[A, B, R]): R =
  ev.concat(a, b)`,
    tags: ['builder pattern', 'shapeless', 'Aux pattern', 'type-level programming'],
  },
  {
    id: 'scala-patterns-l3-065',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'type classes',
    question: 'What is the difference between `Semigroupal` and `Apply` (both sub-type classes of Applicative)?',
    options: [
      'Semigroupal provides `product[A, B](fa: F[A], fb: F[B]): F[(A, B)]`; Apply adds `ap[A, B](ff: F[A => B])(fa: F[A]): F[B]` — they are equivalent but different encodings',
      'Semigroupal is for combining values; Apply is for transforming values',
      'Semigroupal requires a Semigroup on the type; Apply does not',
      'Apply extends Semigroupal with a flatMap',
    ],
    correctAnswer: 0,
    explanation: '`Semigroupal[F]` provides `product` — combines two `F[A]` and `F[B]` into `F[(A,B)]` independently. `Apply[F]` extends `Functor` with `ap` (function application in a context). They are inter-derivable: `map2(fa, fb)(f) = product(fa, fb).map(f.tupled)`.',
    tags: ['type classes', 'Semigroupal', 'Apply', 'Applicative', 'cats'],
  },
  {
    id: 'scala-patterns-l3-066',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'interpreter pattern',
    question: 'What is "bidirectional transformation" in optics vs the interpreter pattern?',
    options: [
      'They are the same concept applied to different domains',
      'Interpreters are unidirectional (AST to result); optics (Iso, Prism) provide bidirectional transformations between representations',
      'Both use pattern matching as their primary mechanism',
      'The interpreter pattern is a form of optic composition',
    ],
    correctAnswer: 1,
    explanation: 'Interpreters transform an AST into a result (unidirectional). Optics like Iso and Prism are bidirectional — they can go from S to A and back from A to S. This makes optics composable in both directions, unlike interpreters which are only unidirectional.',
    tags: ['interpreter pattern', 'optics', 'bidirectional', 'Iso'],
  },
  {
    id: 'scala-patterns-l3-067',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'refined types',
    question: 'What is the performance overhead of using Refined types at scale?',
    options: [
      'Refined types have significant overhead due to runtime predicate checking on every access',
      'Refined types have zero overhead after creation — the value is stored as the raw type; checking only happens at creation with refineV, or not at all with refineMV',
      'Refined types have JVM boxing overhead for primitives',
      'Refined types add a header word per value for the predicate reference',
    ],
    correctAnswer: 1,
    explanation: 'At runtime, `Refined[T, P]` is just `T` — the `Refined` wrapper is a newtype with no fields. The predicate check happens once at creation (`refineV`). After that, the value is accessed as just `T`, with no per-access overhead.',
    tags: ['refined types', 'performance', 'overhead', 'runtime'],
  },
  {
    id: 'scala-patterns-l3-068',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'cake pattern',
    question: 'How does "abstract type member" vs "type parameter" affect the Cake Pattern design?',
    options: [
      'Abstract type members cannot be used in the Cake Pattern; use type parameters instead',
      'Abstract type members create path-dependent types tied to each instance, enabling more precise typing; type parameters require explicit passing and create different types for different parameterizations',
      'They are equivalent in the Cake Pattern context',
      'Type parameters are preferred because they are more visible',
    ],
    correctAnswer: 1,
    explanation: 'Abstract type members (`type Service`) in a component create path-dependent types — each component object has its own unique `Service` type. This provides stronger isolation. Type parameters would be visible at each usage site and would need to be propagated explicitly.',
    tags: ['cake pattern', 'abstract type members', 'type parameters', 'path-dependent types'],
  },
  {
    id: 'scala-patterns-l3-069',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'tagless final',
    question: 'What is the "horizontal composition" of tagless final algebras?',
    options: [
      'Combining algebras side-by-side into a product algebra that provides all operations simultaneously',
      'Composing algebras in sequence so the output of one feeds into the other',
      'Combining two F[_] requirements into one using implicit resolution',
      'Running two algebra interpretations in parallel',
    ],
    correctAnswer: 0,
    explanation: 'Horizontal composition combines algebras into a "product" algebra: `class AllAlgebras[F[_]](users: UserAlgebra[F], emails: EmailAlgebra[F])`. Programs written against AllAlgebras can use all operations. This is distinct from "vertical" composition (chaining via flatMap).',
    codeSnippet: `class AppAlgebras[F[_]](
  val users: UserAlgebra[F],
  val emails: EmailAlgebra[F],
  val logs: LogAlgebra[F]
)

def sendWelcome[F[_]: Monad](app: AppAlgebras[F], userId: UUID): F[Unit] =
  for {
    user <- app.users.find(userId)
    _    <- app.emails.send(user.email, "Welcome!")
    _    <- app.logs.info(s"Welcome email sent to $userId")
  } yield ()`,
    tags: ['tagless final', 'algebra composition', 'product algebra'],
  },
  {
    id: 'scala-patterns-l3-070',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'free monads',
    question: 'What is the "normalization" optimization in Free monad programs?',
    options: [
      'Converting Free monad programs to a normal form that is easier to interpret',
      'Rewriting the Free monad AST to remove unnecessary operations (e.g., `flatMap(pure(a))(f) = f(a)`) before interpretation',
      'Normalizing the type parameters of the Free monad',
      'Converting all Free.liftF calls to Free.pure for optimization',
    ],
    correctAnswer: 1,
    explanation: 'Normalization rewrites the Free monad AST applying monad laws: `flatMap(pure(a))(f) = f(a)` and `flatMap(flatMap(m)(f))(g) = flatMap(m)(a => flatMap(f(a))(g))`. This simplifies the tree before interpretation, reducing the number of operations.',
    tags: ['free monads', 'optimization', 'normalization', 'monad laws'],
  },
  {
    id: 'scala-patterns-l3-071',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'reader/writer/state',
    question: 'What is the "store comonad" and how does it relate to Lens?',
    options: [
      'The Store comonad is the mathematical dual of the State monad and is used for memoization',
      'The Store comonad is `(S => A, S)` — a position and a function from position to focus; it is the comonad representation of a Lens',
      'The Store comonad is a comonad for writing to an immutable store',
      'It is unrelated to Lens — Store is for grid-based comonadic computation',
    ],
    correctAnswer: 1,
    explanation: '`Store[S, A] = (S => A, S)` is the Store comonad. Given a Store, `extract` applies the function to the position. `duplicate` gives `Store[S, Store[S, A]]`. A Lens[S, A] can be represented as `S => Store[A, S]` — this is the comonad-based encoding of lenses.',
    tags: ['reader monad', 'store comonad', 'lens', 'comonad'],
  },
  {
    id: 'scala-patterns-l3-072',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'type classes',
    question: 'What is the "Free monad for a type class" pattern?',
    options: [
      'A pattern where you generate a Free monad automatically from a type class definition',
      'Using the Free monad structure to define a type class that can be interpreted in different ways',
      'A pattern for creating type class instances from Free monad programs',
      'A way to derive Free monads from type class hierarchies',
    ],
    correctAnswer: 0,
    explanation: 'Given a type class trait, you can mechanically generate a Free monad ADT for it: each method becomes an ADT case, and the type class instance for `Free[Op, A]` delegates to the algebra. This is the basis of the `freestyle` library\'s macro annotations.',
    tags: ['type classes', 'free monads', 'code generation', 'freestyle'],
  },
  {
    id: 'scala-patterns-l3-073',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'phantom types',
    question: 'What is "type-level Boolean" and how is it used with phantom types?',
    options: [
      'Using true/false as type arguments in phantom types',
      'Encoding Boolean values at the type level using sealed traits (True/False), enabling type-level if/then/else for phantom type conditions',
      'Using Boolean to index which phantom type is active',
      'A pattern for Boolean-valued predicate types in Refined',
    ],
    correctAnswer: 1,
    explanation: 'Type-level Booleans (`sealed trait True`, `sealed trait False`) enable type-level branching with phantom types. Type class instances can be provided conditionally based on the type-level Boolean, implementing compile-time if/else.',
    codeSnippet: `sealed trait True
sealed trait False

class Api[IsSecure](host: String)

// Only provide send method when IsSecure = True
implicit class SecureApiOps[A](api: Api[True]) {
  def send(data: A): Unit = println(s"Encrypting and sending $data")
}
// api: Api[False] won't have the send method in scope`,
    tags: ['phantom types', 'type-level Boolean', 'type-level programming'],
  },
  {
    id: 'scala-patterns-l3-074',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'interpreter pattern',
    question: 'What is a "hybrid interpreter" that mixes initial and final encodings?',
    options: [
      'An interpreter written in both Scala and Java',
      'An approach where parts of the program are initial (data) for optimization/inspection, and other parts are final (direct execution) for performance',
      'An interpreter that uses both pattern matching and virtual dispatch',
      'An interpreter that works for both Scala 2 and Scala 3',
    ],
    correctAnswer: 1,
    explanation: 'Hybrid interpreters use initial encoding (AST) for parts that benefit from inspection/optimization (e.g., SQL queries) and final encoding (tagless final) for parts that need direct execution (e.g., business logic). This combines the best of both worlds.',
    tags: ['interpreter pattern', 'hybrid', 'initial encoding', 'final encoding'],
  },
  {
    id: 'scala-patterns-l3-075',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'refined types',
    question: 'How do you define a refined type for a non-empty, trimmed, lowercase string?',
    options: [
      'String Refined (NonEmpty And Trimmed And Lowercase)',
      'String Refined NonEmpty Refined Trimmed Refined Lowercase',
      'RefinedString[NonEmpty, Trimmed, Lowercase]',
      'You cannot combine three predicates with Refined',
    ],
    correctAnswer: 0,
    explanation: 'Refined supports predicate combinators. `And[P1, And[P2, P3]]` (or the `And` infix syntax) chains multiple predicates. In Scala 2, this can be written as `String Refined (NonEmpty And Trimmed And Lowercase)` with appropriate imports.',
    codeSnippet: `import eu.timepit.refined.boolean.And
import eu.timepit.refined.string.{Trimmed, Lowercase}
import eu.timepit.refined.collection.NonEmpty

type CleanString = String Refined (NonEmpty And Trimmed And Lowercase)`,
    tags: ['refined types', 'predicate combinators', 'And', 'complex predicates'],
  },
  {
    id: 'scala-patterns-l3-076',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'tagless final',
    question: 'What is the "middleware" pattern in tagless final HTTP services?',
    options: [
      'Software between the OS and the application layer',
      'Wrapping an algebra or service interpreter with cross-cutting concerns (auth, logging, metrics) via function composition on the F[_] level',
      'A pattern for connecting two tagless final algebras',
      'A type class for middleware components',
    ],
    correctAnswer: 1,
    explanation: 'Tagless final middleware wraps service implementations with cross-cutting concerns. Using `Kleisli` (for request-response) or decorator pattern on the algebra implementation, you add authentication, logging, rate limiting, etc. transparently.',
    codeSnippet: `def withMetrics[F[_]: Clock: Monad](service: UserService[F]): UserService[F] =
  new UserService[F] {
    def findUser(id: UUID): F[Option[User]] =
      for {
        start  <- Clock[F].monotonic
        result <- service.findUser(id)
        end    <- Clock[F].monotonic
        _      <- recordMetric("findUser", end - start)
      } yield result
  }`,
    tags: ['tagless final', 'middleware', 'cross-cutting concerns', 'decorator'],
  },
  {
    id: 'scala-patterns-l3-077',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'lens/optics',
    question: 'What is "optic composition via profunctors" and why is it elegant?',
    options: [
      'A way to compose optics using the `compose` method on profunctors',
      'Encoding optics as profunctor transformers so composition is just profunctor composition (function composition), making all optics compose via a single operator',
      'A way to compose optics without knowing their specific types',
      'Using Star profunctors to compose optics with effects',
    ],
    correctAnswer: 1,
    explanation: 'In the profunctor encoding, an optic is `type Optic p s t a b = p a b -> p s t`. Composition is just: given `Optic p s t a b` and `Optic p a b x y`, their composition is `Optic p s t x y`. This is regular function composition, eliminating the need for special composition operators.',
    tags: ['optics', 'profunctor optics', 'composition', 'elegance'],
  },
  {
    id: 'scala-patterns-l3-078',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'cake pattern',
    question: 'What is "horizontal slicing" vs "vertical slicing" in Cake Pattern component design?',
    options: [
      'Horizontal slicing groups components by technical layer (repository, service, API); vertical slicing groups by business feature',
      'Horizontal slicing is for microservices; vertical slicing is for monoliths',
      'These terms are not used in Cake Pattern design',
      'Horizontal slicing uses traits; vertical slicing uses classes',
    ],
    correctAnswer: 0,
    explanation: 'Horizontal slicing creates components per layer (UserRepositoryComponent, OrderRepositoryComponent), while vertical slicing creates components per feature (UserComponent containing repo+service+API). Vertical slicing generally leads to more cohesive components in the Cake Pattern.',
    tags: ['cake pattern', 'architecture', 'slicing', 'component design'],
  },
  {
    id: 'scala-patterns-l3-079',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'free monads',
    question: 'What is the "monad morphism" and why is it important for Free monad composition?',
    options: [
      'A natural transformation between Free monads that preserves the monadic structure',
      'A function that converts a Free monad to a state monad',
      'A way to convert between different Free monad algebras',
      'A morphism in the category of monads — a monad homomorphism `F ~> G` where G is a monad, preserving pure and flatMap',
    ],
    correctAnswer: 3,
    explanation: 'A monad morphism `F ~> G` preserves the monad structure: `morphism(pure(a)) = pure(a)` and `morphism(m.flatMap(f)) = morphism(m).flatMap(a => morphism(f(a)))`. `foldMap` on Free monads requires this property to ensure the interpretation is consistent.',
    tags: ['free monads', 'monad morphism', 'natural transformation', 'foldMap'],
  },
  {
    id: 'scala-patterns-l3-080',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'strategy with FP',
    question: 'How does the "algebra of functions" approach generalize the Strategy pattern?',
    options: [
      'By combining functions using algebraic structures (Semigroup, Monoid) to compose multiple strategies into a unified strategy',
      'By using abstract algebra to prove strategies are correct',
      'By encoding strategies as algebraic data types',
      'By using the Algebra type class from Cats',
    ],
    correctAnswer: 0,
    explanation: 'Functions form algebraic structures. If `A => B` and B is a Monoid, then `A => B` is also a Monoid (combine strategies by combining their results). If B is a Semigroup, strategies can be combined by running both and merging. This generalizes OO Strategy composition.',
    codeSnippet: `import cats.instances.function._

// If B is a Monoid, A => B is also a Monoid
val strategy1: String => List[String] = s => List(s.toLowerCase)
val strategy2: String => List[String] = s => List(s.trim)

val combined = Monoid[String => List[String]].combine(strategy1, strategy2)
combined("  Hello  ") // List("  hello  ", "Hello")`,
    tags: ['strategy pattern', 'algebra of functions', 'Monoid', 'composition'],
  },
  {
    id: 'scala-patterns-l3-081',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'reader/writer/state',
    question: 'What is the "Tell" operation in the `Listen` type class (cats-mtl) and when is it used?',
    options: [
      'Tell sends a message to another actor',
      'Tell contributes a log entry to the accumulated log in a Writer-like computation, without producing a value',
      'Tell is the same as Writer.tell from cats.data.Writer',
      'Both B and C — Tell is the equivalent operation in cats-mtl\'s Tell type class to Writer.tell',
    ],
    correctAnswer: 3,
    explanation: '`Tell[F, W]` from cats-mtl provides `tell(w: W): F[Unit]`, equivalent to `Writer.tell` but polymorphic over F[_]. It allows accumulating log entries in a tagless final program without committing to a concrete Writer type.',
    tags: ['writer monad', 'cats-mtl', 'Tell', 'tagless final'],
  },
  {
    id: 'scala-patterns-l3-082',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'type classes',
    question: 'What is the "Validated" type in Cats and when should it be used instead of Either?',
    options: [
      'Validated should always be used instead of Either for error handling',
      'Validated is an Applicative (not Monad) type that accumulates ALL errors; use it when you want to collect multiple validation errors rather than fail-fast with the first',
      'Validated and Either are identical in behavior',
      'Validated is only for Form validation; Either is for all other error handling',
    ],
    correctAnswer: 1,
    explanation: '`Validated[E, A]` is an Applicative (with `E` a Semigroup) that accumulates errors. Unlike Either which short-circuits on first error, Validated collects all errors. Use Either for fail-fast sequential logic; Validated for parallel independent validations.',
    codeSnippet: `import cats.data.{Validated, ValidatedNel}
import cats.implicits._

def validateName(s: String): ValidatedNel[String, String] =
  if (s.nonEmpty) s.validNel else "Name cannot be empty".invalidNel

def validateAge(n: Int): ValidatedNel[String, Int] =
  if (n >= 0) n.validNel else "Age must be non-negative".invalidNel

// Both errors accumulated:
(validateName(""), validateAge(-1)).mapN(Person.apply)
// Invalid(NonEmptyList("Name cannot be empty", "Age must be non-negative"))`,
    tags: ['type classes', 'Validated', 'error accumulation', 'cats'],
  },
  {
    id: 'scala-patterns-l3-083',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'interpreter pattern',
    question: 'What is "partial evaluation" in the context of interpreters?',
    options: [
      'Running only part of the program to get a partial result',
      'Specializing an interpreter at compile time with some inputs fixed, enabling optimizations for the remaining inputs at runtime',
      'A pattern for skipping evaluation of irrelevant branches in a switch statement',
      'Lazily evaluating parts of the AST',
    ],
    correctAnswer: 1,
    explanation: 'Partial evaluation fixes some inputs to an interpreter at compile time, specializing the interpreter for those inputs and optimizing the residual program. Supercompilation and staged compilation use this. In Scala, staging (LMS, Scala 3 macros) implements partial evaluation.',
    tags: ['interpreter pattern', 'partial evaluation', 'staging', 'optimization'],
  },
  {
    id: 'scala-patterns-l3-084',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'lens/optics',
    question: 'What is the `alongside` method on optics in Monocle?',
    options: [
      'A method that runs two optics on the same structure simultaneously',
      'A method that focuses on a field alongside its container',
      'A method that combines two optics of the same type into a product optic that focuses on both simultaneously',
      'A method that creates a pair optic from two independent optics on different structures',
    ],
    correctAnswer: 2,
    explanation: '`alongside` (or `split` in some libraries) combines two optics of the same kind into a product optic: `(Lens[S, A], Lens[T, B]) => Lens[(S, T), (A, B)]`. This lets you apply both optics simultaneously to a pair of structures.',
    tags: ['monocle', 'optics', 'alongside', 'product optics'],
  },
  {
    id: 'scala-patterns-l3-085',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'tagless final',
    question: 'What is the "abstract factory" pattern in tagless final design?',
    options: [
      'Using a factory method `make[F[_]]` to create concrete instances of the algebra for different effect types',
      'Using abstract type class members to abstract over factories',
      'A trait that creates multiple related algebras for a given F[_]',
      'Using macros to generate algebra implementations',
    ],
    correctAnswer: 2,
    explanation: 'An abstract factory in tagless final provides a trait (or function) that creates a family of related algebras for the same `F[_]`. This ensures that all created algebras use the same effect type and are properly coordinated (e.g., they share a database connection).',
    codeSnippet: `trait Repositories[F[_]] {
  def users: UserRepository[F]
  def orders: OrderRepository[F]
  def products: ProductRepository[F]
}

def makeRepositories[F[_]: Sync](db: Database): Repositories[F] =
  new Repositories[F] {
    val users = new DbUserRepository[F](db)
    val orders = new DbOrderRepository[F](db)
    val products = new DbProductRepository[F](db)
  }`,
    tags: ['tagless final', 'abstract factory', 'algebras', 'resource sharing'],
  },
  {
    id: 'scala-patterns-l3-086',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'phantom types',
    question: 'What is the "existential type wrapper" pattern for storing phantom-typed values?',
    options: [
      'Using `Any` to store phantom-typed values',
      'Wrapping a phantom-typed value with its evidence in an existential wrapper so the type can be recovered using the evidence',
      'Using `_` as a phantom type wildcard',
      'Using a separate Map to track phantom type associations',
    ],
    correctAnswer: 1,
    explanation: 'To store and later recover phantom-typed values, wrap them: `case class Boxed[T](value: Container[T], evidence: Evidence[T])`. When extracting, you can use the evidence to call the type-safe API. This bridges the gap between runtime heterogeneity and compile-time type safety.',
    codeSnippet: `sealed trait Permission
case object Admin extends Permission
case object ReadOnly extends Permission

case class WithPermission[P <: Permission](
  session: Session[P],
  perm: P
)

def storeAll(sessions: List[WithPermission[_]]): Unit = ???
// Later: pattern match on perm to recover the type`,
    tags: ['phantom types', 'existential types', 'type recovery'],
  },
  {
    id: 'scala-patterns-l3-087',
    language: 'scala',
    level: 'level3',
    category: 'Design Patterns',
    subcategory: 'builder pattern (Scala-style)',
    question: 'What is "opaque type" in Scala 3 and how does it improve on value class newtypes for the builder pattern?',
    options: [
      'Opaque types are the same as value classes but with a different name',
      'Opaque types define a type alias that is opaque outside the defining scope, providing type safety without any wrapping overhead and without the AnyVal restrictions',
      'Opaque types allow inheritance of the underlying type methods',
      'Opaque types are compile-time only and provide no runtime representation',
    ],
    correctAnswer: 1,
    explanation: 'Scala 3 opaque types (`opaque type UserId = Long`) create a distinct type visible only inside the defining object. Outside, UserId is opaque (cannot use Long operations). No boxing, no wrapper class. It supersedes value classes for newtype patterns in Scala 3.',
    codeSnippet: `object Newtypes:
  opaque type UserId = Long
  object UserId:
    def apply(n: Long): UserId = n
    def value(id: UserId): Long = id

// Outside the object:
val id: Newtypes.UserId = Newtypes.UserId(42L)
// id + 1  // Compile error — Long operations not available on UserId`,
    tags: ['builder pattern', 'opaque types', 'Scala 3', 'newtype'],
  },
];

export default questions;
