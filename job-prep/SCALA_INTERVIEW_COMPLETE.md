# Complete Scala Interview Preparation Guide

**From Fundamentals to Expert Level - 150+ Questions**

**Last Updated**: February 2, 2026  
**Total Questions**: 150+  
**Estimated Study Time**: 60-80 hours  
**Difficulty Levels**: Junior to Principal Engineer

---

## 📚 Table of Contents

### Core Content
1. [Fundamentals & Type System](#part-i-fundamentals--type-system)
2. [Functional Programming Theory](#part-ii-functional-programming-theory)
3. [Advanced Concepts](#part-iii-advanced-concepts)
4. [Concurrency & Performance](#part-iv-concurrency--performance)
5. [Practical Coding Tasks](#part-v-practical-coding-tasks)
6. [System Design & Architecture](#part-vi-system-design--architecture)
7. [Interview Questions by Category](#part-vii-interview-questions-by-category)
8. [Real Interview Questions (2024-2026)](#part-viii-real-interview-questions-from-actual-interviews)
9. [Additional Advanced Questions](#part-ix-additional-advanced-questions)
10. [Expert-Level Deep Dive](#part-x-expert-level-deep-dive-questions)
11. [Interview Analysis & Company Insights](#part-xi-interview-analysis--company-insights)

### Appendices
- [Study Plan](#study-plan)
- [Resources](#resources)
- [Mock Interview Checklist](#mock-interview-checklist)
- [Appendix A: Top 20 Must-Know Questions](#appendix-a-quick-reference---top-20-must-know-questions)
- [Appendix B: Company-Specific Focus Areas](#appendix-b-company-specific-focus-areas)
- [Appendix C: Common Mistakes to Avoid](#appendix-c-common-mistakes-to-avoid)

---

## Difficulty Breakdown

| Level | Count | Percentage | Target Audience |
|-------|-------|------------|-----------------|
| ⭐⭐ (Mid-level) | 25 | 16% | 2-4 years experience |
| ⭐⭐⭐ (Mid-Senior) | 45 | 30% | 4-6 years experience |
| ⭐⭐⭐⭐ (Senior) | 50 | 33% | 6-10 years experience |
| ⭐⭐⭐⭐⭐ (Principal) | 30 | 21% | 10+ years, architects |

---

# Senior Scala Engineer Interview Preparation Guide

## Table of Contents
1. [Fundamentals & Type System](#fundamentals--type-system)
2. [Functional Programming Theory](#functional-programming-theory)
3. [Advanced Concepts](#advanced-concepts)
4. [Concurrency & Performance](#concurrency--performance)
5. [Practical Coding Tasks](#practical-coding-tasks)
6. [System Design & Architecture](#system-design--architecture)
7. [Interview Questions by Category](#interview-questions-by-category)

---

## 1. Fundamentals & Type System

### Core Concepts to Master

#### Variance (Covariance, Contravariance, Invariance)
- **Covariant (+A)**: Subtyping preserved in the same direction
- **Contravariant (-A)**: Subtyping reversed
- **Invariant (A)**: No subtyping relationship

**Key Interview Question**: "Why is List covariant but Array invariant in Scala?"
- Arrays are mutable (Java legacy), Lists are immutable
- Covariant mutable structures break type safety

#### Implicits (Scala 2) & Given/Using (Scala 3)
- Implicit parameters & conversions
- Type classes pattern
- Context bounds vs. implicit parameters
- Extension methods (Scala 3)

#### Path-Dependent Types
```scala
class Outer {
  class Inner
  def process(i: Inner) = ???
}
val o1 = new Outer
val o2 = new Outer
// o1.Inner ≠ o2.Inner (different types!)
```

#### Higher-Kinded Types
```scala
trait Container[F[_]] {
  def put[A](a: A): F[A]
}
```

---

## 2. Functional Programming Theory

### Monads

#### Definition
A Monad is a type constructor `M[_]` with:
1. **unit/pure**: `A => M[A]` (wraps a value)
2. **flatMap/bind**: `M[A] => (A => M[B]) => M[B]` (chains computations)

#### Monad Laws
1. **Left Identity**: `pure(a).flatMap(f) == f(a)`
2. **Right Identity**: `m.flatMap(pure) == m`
3. **Associativity**: `m.flatMap(f).flatMap(g) == m.flatMap(x => f(x).flatMap(g))`

#### Common Monads
- **Option**: Computation that may fail
- **Either**: Computation with error information
- **List**: Non-deterministic computation
- **Future**: Asynchronous computation
- **Try**: Computation that may throw
- **IO**: Side-effectful computation (cats-effect)
- **State**: Stateful computation
- **Reader**: Dependency injection
- **Writer**: Computation with logging

#### Monad Transformers
Stack monads to combine effects:
```scala
OptionT[Future, A]  // Future[Option[A]]
EitherT[IO, E, A]   // IO[Either[E, A]]
```

### Functors

#### Definition
A Functor is a type constructor `F[_]` with:
- **map**: `F[A] => (A => B) => F[B]`

#### Functor Laws
1. **Identity**: `fa.map(identity) == fa`
2. **Composition**: `fa.map(f).map(g) == fa.map(f andThen g)`

#### Types of Functors
- **Covariant Functor**: Regular functor (map)
- **Contravariant Functor**: `contramap`
- **Invariant Functor**: `imap`

### Applicative Functors

#### Definition
Between Functor and Monad:
- **pure**: `A => F[A]`
- **ap/apply**: `F[A => B] => F[A] => F[B]`
- **map2**: `(F[A], F[B], (A, B) => C) => F[C]`

#### When to Use
- Independent computations (unlike flatMap's dependent computations)
- Validating multiple fields (accumulating errors)
- Parallel execution possibilities

### Monoids & Semigroups

#### Semigroup
- **combine**: `(A, A) => A`
- **Associative**: `(a |+| b) |+| c == a |+| (b |+| c)`

#### Monoid (Semigroup + Identity)
- **empty**: Identity element
- `empty |+| a == a |+| empty == a`

**Examples**: String concatenation, Int addition, List concatenation

### Free Monads
Separate program description from interpretation:
```scala
sealed trait Console[A]
case class PrintLine(msg: String) extends Console[Unit]
case class ReadLine() extends Console[String]
```

---

## 3. Advanced Concepts

### Type Classes

#### Pattern
```scala
trait Show[A] {
  def show(a: A): String
}

object Show {
  def apply[A](implicit s: Show[A]): Show[A] = s

  implicit val intShow: Show[Int] = (a: Int) => a.toString
}

// Usage
def print[A: Show](a: A): String = Show[A].show(a)
```

#### Advantages
- Ad-hoc polymorphism
- Extension without modification
- Type-safe

### Phantom Types
Types that exist only at compile time:
```scala
sealed trait Currency
trait USD extends Currency
trait EUR extends Currency

case class Money[C <: Currency](amount: BigDecimal)

// Prevents mixing currencies at compile time
def add[C <: Currency](m1: Money[C], m2: Money[C]): Money[C]
```

### Algebraic Data Types (ADT)

#### Sum Types (OR)
```scala
sealed trait Result
case class Success(value: Int) extends Result
case class Failure(error: String) extends Result
```

#### Product Types (AND)
```scala
case class Person(name: String, age: Int)
```

### Type-Level Programming
- Dependent types (limited in Scala)
- Shapeless HLists
- Type-level naturals
- Compile-time computations

### For-Comprehensions
Syntactic sugar for flatMap/map/withFilter:
```scala
for {
  x <- Future(1)
  y <- Future(x + 1)
  if y > 0
} yield y * 2

// Desugars to:
Future(1).flatMap(x =>
  Future(x + 1).withFilter(y => y > 0).map(y => y * 2)
)
```

---

## 4. Concurrency & Performance

### Futures
- Eager evaluation
- Not referentially transparent
- Memoized (cached result)
- Thread pool execution

### Cats Effect IO
- Lazy evaluation
- Referentially transparent
- Composable
- Resource-safe (bracket/Resource)
- Fiber-based concurrency

### Akka Actors
- Message-passing concurrency
- Location transparency
- Supervision hierarchies
- At-most-once delivery semantics

### ZIO
- Type-safe effects: `ZIO[R, E, A]`
- Environment (R): Dependencies
- Error channel (E): Typed errors
- Success channel (A): Result

### Performance Considerations
- Tail recursion & @tailrec
- Trampolining
- LazyList vs. Stream vs. Iterator
- View (Scala 2) / LazyList (Scala 3)
- Specialized collections (@specialized)

---

## 5. Practical Coding Tasks

### Task 1: Implement a Type-Safe Builder Pattern
```scala
sealed trait BuilderState
trait Empty extends BuilderState
trait HasName extends BuilderState
trait HasAge extends BuilderState
trait Complete extends BuilderState

class PersonBuilder[S <: BuilderState] private (
  name: Option[String] = None,
  age: Option[Int] = None
) {
  def withName(n: String)(implicit ev: S =:= Empty): PersonBuilder[HasName] = ???
  def withAge(a: Int)(implicit ev: S =:= HasName): PersonBuilder[Complete] = ???
  def build(implicit ev: S =:= Complete): Person = ???
}
```

### Task 2: Implement Functor, Applicative, Monad for a Custom Type
```scala
sealed trait Validation[+E, +A]
case class Valid[+A](value: A) extends Validation[Nothing, A]
case class Invalid[+E](errors: List[E]) extends Validation[E, Nothing]

// Implement:
// - Functor instance (map)
// - Applicative instance (pure, map2 with error accumulation)
// - Note: Cannot implement Monad (why?)
```

### Task 3: Implement a State Monad
```scala
case class State[S, A](run: S => (S, A)) {
  def map[B](f: A => B): State[S, B] = ???
  def flatMap[B](f: A => State[S, B]): State[S, B] = ???
}

object State {
  def pure[S, A](a: A): State[S, A] = ???
  def get[S]: State[S, S] = ???
  def set[S](s: S): State[S, Unit] = ???
  def modify[S](f: S => S): State[S, Unit] = ???
}
```

### Task 4: Implement Reader Monad
```scala
case class Reader[R, A](run: R => A) {
  def map[B](f: A => B): Reader[R, B] = ???
  def flatMap[B](f: A => Reader[R, B]): Reader[R, B] = ???
}

// Use case: Dependency injection
trait Config
def loadUser(id: Int): Reader[Config, User] = ???
```

### Task 5: Implement a Generic LinkedList with Type Classes
```scala
sealed trait MyList[+A]
case object Empty extends MyList[Nothing]
case class Cons[A](head: A, tail: MyList[A]) extends MyList[A]

// Implement: Functor, Foldable, Traverse
```

### Task 6: Parser Combinator
```scala
trait Parser[+A] {
  def parse(input: String): Option[(A, String)]

  def map[B](f: A => B): Parser[B] = ???
  def flatMap[B](f: A => Parser[B]): Parser[B] = ???
  def orElse[B >: A](other: => Parser[B]): Parser[B] = ???
}

// Implement: char, string, many, many1, digit, number
```

### Task 7: Implement a Thread-Safe LRU Cache
```scala
class LRUCache[K, V](capacity: Int) {
  def get(key: K): Option[V] = ???
  def put(key: K, value: V): Unit = ???
}
// Requirements: O(1) operations, thread-safe
```

### Task 8: Implement Trampoline for Stack-Safe Recursion
```scala
sealed trait Trampoline[+A]
case class Done[A](value: A) extends Trampoline[A]
case class More[A](call: () => Trampoline[A]) extends Trampoline[A]

def run[A](t: Trampoline[A]): A = ???

// Use to implement stack-safe even/odd
def even(n: Int): Trampoline[Boolean] = ???
def odd(n: Int): Trampoline[Boolean] = ???
```

---

## 6. System Design & Architecture

### Typical Senior-Level Questions

1. **Design a Real-Time Analytics System**
   - Kafka for streaming
   - Spark Streaming / Flink
   - Event sourcing
   - CQRS pattern

2. **Design a Microservices Architecture**
   - Service discovery (Consul, Eureka)
   - API Gateway (Akka HTTP, Http4s)
   - Circuit breakers (Akka, Resilience4j)
   - Distributed tracing (Zipkin, Jaeger)

3. **Database Design Considerations**
   - Slick / Doobie / Quill
   - Connection pooling
   - Transaction boundaries
   - N+1 query problem

4. **Error Handling Strategy**
   - Typed errors with Either/IO
   - Error ADTs
   - Retry strategies
   - Fallback mechanisms

---

## 7. Interview Questions by Category

### Scala Fundamentals

1. **What's the difference between `val`, `var`, `def`, and `lazy val`?**
   - `val`: Immutable, evaluated immediately
   - `var`: Mutable
   - `def`: Function, evaluated on each call
   - `lazy val`: Evaluated on first access, then cached

2. **Explain `call-by-value` vs `call-by-name`**
   ```scala
   def callByValue(x: Int): Int = x + x
   def callByName(x: => Int): Int = x + x

   callByValue(someExpensiveComputation()) // Evaluated once before call
   callByName(someExpensiveComputation())  // Evaluated twice inside function
   ```

3. **What is `Nothing` and why is it useful?**
   - Bottom type (subtype of everything)
   - Type of expressions that never return (throw, infinite loop)
   - Makes `Option[Nothing]` = `None` work with any `Option[A]`

4. **Difference between `Nil`, `None`, `Nothing`, and `Null`?**
   - `Nil`: Empty `List`
   - `None`: Empty `Option`
   - `Nothing`: Bottom type
   - `Null`: Subtype of all reference types (avoid!)

5. **What is the difference between `==` and `eq`?**
   - `==`: Structural equality (calls `equals`)
   - `eq`: Reference equality (same object in memory)

### Type System

6. **Explain upper bounds, lower bounds, and view bounds**
   ```scala
   def foo[A <: Comparable[A]](a: A)  // Upper bound
   def bar[A >: String](a: A)         // Lower bound
   def baz[A <% Ordered[A]](a: A)     // View bound (deprecated, use implicit)
   ```

7. **What is the Liskov Substitution Principle and how does it relate to variance?**
   - Subtypes should be substitutable for base types
   - Covariance maintains this for immutable types
   - Contravariance for function inputs

8. **Explain existential types**
   ```scala
   def process(list: List[_]) // Some unknown type
   Array[T] forSome { type T } // Existential quantification
   ```

9. **What are type lambdas and why are they useful?**
   ```scala
   // Scala 2: Need to partially apply type constructor
   type IntMap[A] = Map[Int, A]
   Functor[IntMap]

   // Scala 3: Type lambdas
   Functor[[X] =>> Map[Int, X]]
   ```

10. **IN-DEPTH: Design a type-safe API for a state machine using phantom types and path-dependent types**

    **Problem**: Design a compile-time safe door lock system where:
    - A door can be in states: Locked, Unlocked, Open
    - Valid transitions: Locked → Unlocked → Open → Unlocked → Locked
    - Invalid transitions should be prevented at compile time
    - Each door instance should track its own state type independently

    **Initial Solution (Phantom Types)**:
    ```scala
    sealed trait DoorState
    trait Locked extends DoorState
    trait Unlocked extends DoorState
    trait Open extends DoorState

    class Door[S <: DoorState] private (name: String) {
      def unlock(implicit ev: S =:= Locked): Door[Unlocked] =
        new Door[Unlocked](name)

      def open(implicit ev: S =:= Unlocked): Door[Open] =
        new Door[Open](name)

      def close(implicit ev: S =:= Open): Door[Unlocked] =
        new Door[Unlocked](name)

      def lock(implicit ev: S =:= Unlocked): Door[Locked] =
        new Door[Locked](name)
    }

    object Door {
      def apply(name: String): Door[Locked] = new Door[Locked](name)
    }

    // Usage:
    val door = Door("Front")
      .unlock  // Door[Unlocked]
      .open    // Door[Open]
      .close   // Door[Unlocked]
      .lock    // Door[Locked]

    // Won't compile:
    // door.open  // Error: Cannot prove Door[Locked] =:= Door[Unlocked]
    ```

    **Follow-up Questions to Explore**:

    a) **What if we need to track additional properties (e.g., alarm state)?**
    ```scala
    sealed trait AlarmState
    trait AlarmOn extends AlarmState
    trait AlarmOff extends AlarmState

    class Door[S <: DoorState, A <: AlarmState] private (name: String) {
      def unlock(implicit ev: S =:= Locked): Door[Unlocked, A] = ???

      def enableAlarm(implicit ev1: S =:= Locked,
                              ev2: A =:= AlarmOff): Door[S, AlarmOn] = ???
    }
    ```

    b) **How would you handle state history/logging without runtime overhead?**
    ```scala
    // Use HList from Shapeless to track state transitions at type level
    import shapeless.{HList, ::, HNil}

    class Door[S <: DoorState, History <: HList] private (
      name: String,
      history: History
    ) {
      def unlock(implicit ev: S =:= Locked): Door[Unlocked, Locked :: History] =
        new Door(name, ev(this.asInstanceOf[Door[Locked, History]]) :: history)
    }
    ```

    c) **What are the limitations of phantom types vs. refinement types?**
    - Phantom types: States must be known at compile time
    - Refinement types (Scala 3): Can encode value constraints
    ```scala
    // Scala 3 refinement type example
    type PositiveInt = Int & (Int >= 0)

    // Phantom types can't express: "door code must be 4-6 digits"
    // Would need: opaque type DoorCode = String & (Length >= 4 && Length <= 6)
    ```

    d) **Path-Dependent Types Extension**: Each door has its own key type
    ```scala
    trait DoorSystem {
      type State <: DoorState
      type Key

      def unlock(key: Key)(implicit ev: State =:= Locked): DoorSystem {
        type State = Unlocked
        type Key = DoorSystem.this.Key
      }
    }

    object SecureDoor extends DoorSystem {
      type State = Locked
      case class BiometricKey(fingerprint: String)
      type Key = BiometricKey
    }

    object SimpleDoor extends DoorSystem {
      type State = Locked
      case class PhysicalKey(id: Int)
      type Key = PhysicalKey
    }

    // Won't compile - key types are incompatible:
    // val key: SimpleDoor.Key = SecureDoor.BiometricKey("12345")
    ```

    **Key Insights to Demonstrate**:
    1. **Type-level computation**: State transitions verified at compile time
    2. **Zero runtime overhead**: Phantom type parameters erased after compilation
    3. **Evidence parameters**: `=:=` provides proof of type equality
    4. **Type member vs. type parameter**: When to use path-dependent types
    5. **Scala 3 match types**: Could implement state validation differently:
    ```scala
    // Scala 3: Type-level state machine validation
    type NextState[S <: DoorState] = S match {
      case Locked => Unlocked
      case Unlocked => Open | Locked
      case Open => Unlocked
    }

    def transition[S <: DoorState, Next <: DoorState](door: Door[S])(
      implicit ev: Next =:= NextState[S]
    ): Door[Next] = ???
    ```

    **Common Mistakes to Address**:
    - Using runtime state checks instead of phantom types (defeats purpose)
    - Not understanding type erasure implications
    - Confusing `<:<` (subtype constraint) with `=:=` (type equality)
    - Forgetting that `new Door[Unlocked]` bypasses safety (need private constructor)
    - Not realizing phantom types break when state comes from external input

    **When to Use This Pattern**:
    - Protocol implementations (HTTP/2 stream states)
    - Resource lifecycle management (DB connections: Open/Closed)
    - Parser states (JSON: ExpectValue, ExpectKey, ExpectComma)
    - Builder patterns with required fields
    - DSLs where operation order matters

    ---

    **ADVANCED PATTERNS: Type-Level Programming & Aux Pattern**

    **e) The Aux Pattern (Type Projection Pattern)**

    Problem: When a type class has dependent types, we need to reference the inner type explicitly.

    ```scala
    // Without Aux pattern - hard to use
    trait Container[C] {
      type Element
      def extract(c: C): Element
    }

    // Can't write: def process[C](c: C)(implicit ev: Container[C]): ev.Element
    // Because ev.Element is a path-dependent type bound to the implicit value

    // Solution: Aux pattern
    object Container {
      type Aux[C, E] = Container[C] { type Element = E }

      def apply[C](implicit ev: Container[C]): Aux[C, ev.Element] = ev
    }

    // Now we can write:
    def process[C, E](c: C)(implicit ev: Container.Aux[C, E]): E =
      ev.extract(c)

    // Or with context bounds:
    def process2[C](c: C)(implicit ev: Container[C]): ev.Element =
      ev.extract(c)
    ```

    **Real-World Example: Generic serialization with type-level size computation**
    ```scala
    trait Serializer[T] {
      type Size <: Int
      def serialize(t: T): Array[Byte]
      def size: Int
    }

    object Serializer {
      type Aux[T, S <: Int] = Serializer[T] { type Size = S }

      implicit val intSerializer: Aux[Int, 4] = new Serializer[Int] {
        type Size = 4
        def serialize(t: Int): Array[Byte] = ???
        def size: Int = 4
      }

      implicit val longSerializer: Aux[Long, 8] = new Serializer[Long] {
        type Size = 8
        def serialize(t: Long): Array[Byte] = ???
        def size: Int = 8
      }

      // Compose serializers - size is computed at type level
      implicit def tupleSerializer[A, B, SA <: Int, SB <: Int](
        implicit sa: Aux[A, SA], sb: Aux[B, SB],
        sum: Sum[SA, SB]
      ): Aux[(A, B), sum.Out] = new Serializer[(A, B)] {
        type Size = sum.Out
        def serialize(t: (A, B)): Array[Byte] =
          sa.serialize(t._1) ++ sb.serialize(t._2)
        def size: Int = sa.size + sb.size
      }
    }
    ```

    **f) Witness/Evidence Pattern with Implicit Resolution**

    ```scala
    // Prove at compile time that a type is in an HList
    sealed trait Contains[L <: HList, A]

    object Contains {
      implicit def head[H, T <: HList]: Contains[H :: T, H] =
        new Contains[H :: T, H] {}

      implicit def tail[H, T <: HList, A](
        implicit ev: Contains[T, A]
      ): Contains[H :: T, A] =
        new Contains[H :: T, A] {}
    }

    // Usage: Ensure a field exists in a record type
    def getField[L <: HList, A](list: L)(
      implicit ev: Contains[L, A],
      selector: Selector[L, A]
    ): A = selector(list)
    ```

    **g) Type-Level Naturals (Peano Numbers)**

    ```scala
    sealed trait Nat
    sealed trait _0 extends Nat
    sealed trait Succ[N <: Nat] extends Nat

    type _1 = Succ[_0]
    type _2 = Succ[_1]
    type _3 = Succ[_2]
    type _4 = Succ[_3]

    // Type-level addition
    trait Sum[A <: Nat, B <: Nat] {
      type Out <: Nat
    }

    object Sum {
      type Aux[A <: Nat, B <: Nat, C <: Nat] = Sum[A, B] { type Out = C }

      implicit def zero[B <: Nat]: Aux[_0, B, B] = new Sum[_0, B] {
        type Out = B
      }

      implicit def succ[A <: Nat, B <: Nat, C <: Nat](
        implicit ev: Aux[A, B, C]
      ): Aux[Succ[A], B, Succ[C]] = new Sum[Succ[A], B] {
        type Out = Succ[C]
      }
    }

    // Fixed-size vector using type-level naturals
    sealed trait Vec[N <: Nat, +A]
    case object VNil extends Vec[_0, Nothing]
    case class VCons[N <: Nat, +A](head: A, tail: Vec[N, A])
      extends Vec[Succ[N], A]

    // Type-safe concatenation with size tracking
    def concat[N <: Nat, M <: Nat, A](
      v1: Vec[N, A],
      v2: Vec[M, A]
    )(implicit sum: Sum[N, M]): Vec[sum.Out, A] = ???
    ```

    **h) Type-Level Comparison and Constraints**

    ```scala
    // Less-than-or-equal constraint for Nat
    sealed trait <=[A <: Nat, B <: Nat]

    object <= {
      implicit def zeroLTE[B <: Nat]: <=[_0, B] =
        new <=[_0, B] {}

      implicit def succLTE[A <: Nat, B <: Nat](
        implicit ev: <=[A, B]
      ): <=[Succ[A], Succ[B]] =
        new <=[Succ[A], Succ[B]] {}
    }

    // Use in API: take at most N elements
    def take[N <: Nat, M <: Nat, A](
      n: N,
      vec: Vec[M, A]
    )(implicit ev: <=[N, M]): Vec[N, A] = ???
    ```

    **i) F-Bounded Polymorphism (Self-Referential Types)**

    ```scala
    trait Comparable[A <: Comparable[A]] {
      def compareTo(other: A): Int
    }

    // Forces implementations to return their own type
    class Person(val age: Int) extends Comparable[Person] {
      def compareTo(other: Person): Int = age - other.age
    }

    // Can't accidentally compare different types
    class Animal extends Comparable[Animal] {
      def compareTo(other: Animal): Int = 0
    }

    // Won't compile:
    // val p: Person = new Person(30)
    // val a: Animal = new Animal
    // p.compareTo(a)  // Type error!
    ```

    **j) Type-Safe Builder with Field Tracking (Advanced Aux Pattern)**

    ```scala
    import shapeless.{HList, ::, HNil}
    import shapeless.ops.hlist.Selector

    sealed trait BuilderState
    case object Empty extends BuilderState
    case object Partial extends BuilderState
    case object Complete extends BuilderState

    // Track which fields have been set using HList
    case class Person(name: String, age: Int, email: String)

    class PersonBuilder[Fields <: HList] private (fields: Fields) {
      def withName(name: String): PersonBuilder[String :: Fields] =
        new PersonBuilder(name :: fields)

      def withAge(age: Int): PersonBuilder[Int :: Fields] =
        new PersonBuilder(age :: fields)

      def withEmail(email: String): PersonBuilder[String :: Fields] =
        new PersonBuilder(email :: fields)

      // Can only build when all required fields are present
      def build(
        implicit
        nameEv: Selector[Fields, String],
        ageEv: Selector[Fields, Int],
        emailEv: Selector.Aux[Fields, String, String] // Aux to disambiguate
      ): Person = Person(
        nameEv(fields),
        ageEv(fields),
        emailEv(fields)
      )
    }

    object PersonBuilder {
      def apply(): PersonBuilder[HNil] = new PersonBuilder(HNil)
    }
    ```

    **k) Scala 3 Match Types for Type-Level Computation**

    ```scala
    // Type-level list operations
    type Concat[A <: Tuple, B <: Tuple] = A match {
      case EmptyTuple => B
      case h *: t => h *: Concat[t, B]
    }

    // Type-level filter
    type Filter[T <: Tuple, P[_]] <: Tuple = T match {
      case EmptyTuple => EmptyTuple
      case h *: t => P[h] match {
        case true => h *: Filter[t, P]
        case false => Filter[t, P]
      }
    }

    // Type-level contains check
    type Contains[T <: Tuple, A] <: Boolean = T match {
      case EmptyTuple => false
      case A *: _ => true
      case _ *: t => Contains[t, A]
    }
    ```

    **l) Dependent Method Types (Scala 3)**

    ```scala
    trait Database {
      type Key
      type Value
      def get(key: Key): Option[Value]
    }

    // Method return type depends on input value
    def getDatabase(name: String): Database = name match {
      case "users" => new Database {
        type Key = Int
        type Value = User
        def get(key: Int): Option[User] = ???
      }
      case "sessions" => new Database {
        type Key = String
        type Value = Session
        def get(key: String): Option[Session] = ???
      }
    }

    // Type refinement preserves dependent types
    val db = getDatabase("users")
    val user: Option[db.Value] = db.get(123) // Type-safe!
    ```

    **m) Magnet Pattern (Type-Safe Method Overloading)**

    Used extensively in Akka and Spray to create flexible APIs without combinatorial explosion of overloads.

    ```scala
    // Problem: Multiple parameter combinations lead to many overloads
    // def receive(timeout: Duration): Message
    // def receive(timeout: Duration, unit: TimeUnit): Message
    // def receive(): Message
    // ...exponential growth with more parameters

    // Solution: Magnet pattern
    trait ReceiveMagnet {
      def apply(): Message
    }

    object ReceiveMagnet {
      implicit def fromDuration(timeout: Duration): ReceiveMagnet =
        new ReceiveMagnet {
          def apply(): Message = receiveWithTimeout(timeout)
        }

      implicit def fromUnit(timeout: Long)(implicit unit: TimeUnit): ReceiveMagnet =
        new ReceiveMagnet {
          def apply(): Message = receiveWithTimeout(Duration(timeout, unit))
        }

      implicit def noTimeout(implicit dummy: DummyImplicit): ReceiveMagnet =
        new ReceiveMagnet {
          def apply(): Message = receiveNoTimeout()
        }
    }

    // Single method signature
    def receive(magnet: ReceiveMagnet): Message = magnet.apply()

    // Usage looks natural:
    receive(5.seconds)
    receive(1000L)  // Uses implicit TimeUnit
    receive()
    ```

    **n) Type Class Derivation (Generic Programming)**

    Essential for libraries like Circe, Play JSON, Slick.

    ```scala
    import shapeless.{Generic, HList, ::, HNil, Lazy}
    import shapeless.labelled.{FieldType, field}

    // Automatically derive JSON encoders for case classes
    trait JsonEncoder[A] {
      def encode(a: A): String
    }

    object JsonEncoder {
      // Base instances
      implicit val intEncoder: JsonEncoder[Int] = _.toString
      implicit val stringEncoder: JsonEncoder[String] = s => s""""$s""""
      implicit val boolEncoder: JsonEncoder[Boolean] = _.toString

      // HList instances
      implicit val hnilEncoder: JsonEncoder[HNil] =
        _ => "{}"

      implicit def hconsEncoder[K <: Symbol, H, T <: HList](
        implicit
        witness: Witness.Aux[K],
        hEncoder: Lazy[JsonEncoder[H]],
        tEncoder: JsonEncoder[T]
      ): JsonEncoder[FieldType[K, H] :: T] =
        hlist => {
          val fieldName = witness.value.name
          val head = hlist.head
          val tail = hlist.tail
          val headJson = s""""$fieldName":${hEncoder.value.encode(head)}"""
          tEncoder.encode(tail) match {
            case "{}" => s"{$headJson}"
            case rest => s"{$headJson,${rest.drop(1)}"
          }
        }

      // Generic derivation
      implicit def genericEncoder[A, R](
        implicit
        gen: Generic.Aux[A, R],
        enc: Lazy[JsonEncoder[R]]
      ): JsonEncoder[A] =
        a => enc.value.encode(gen.to(a))
    }

    // Automatically works for any case class!
    case class User(name: String, age: Int, active: Boolean)
    val encoder = implicitly[JsonEncoder[User]]
    encoder.encode(User("Alice", 30, true))
    // {"name":"Alice","age":30,"active":true}
    ```

    **o) Typeclass Coherence & Orphan Instances**

    Critical for large codebases - avoiding implicit conflicts.

    ```scala
    // BAD: Orphan instance (defined outside companion)
    object RandomPlace {
      implicit val stringOrdering: Ordering[String] =
        Ordering.by(_.length)  // Conflicts with default!
    }

    // GOOD: Smart constructors in companion
    trait Parser[A] {
      def parse(s: String): Either[String, A]
    }

    object Parser {
      def apply[A](implicit p: Parser[A]): Parser[A] = p

      def instance[A](f: String => Either[String, A]): Parser[A] =
        new Parser[A] {
          def parse(s: String): Either[String, A] = f(s)
        }

      // Canonical instances in companion
      implicit val intParser: Parser[Int] =
        instance(s => s.toIntOption.toRight(s"Not an int: $s"))
    }

    // For domain types, put implicit in companion
    case class Email(value: String)
    object Email {
      implicit val emailParser: Parser[Email] =
        Parser.instance { s =>
          if (s.contains("@")) Right(Email(s))
          else Left("Invalid email")
        }
    }
    ```

    **p) Implicit Evidence Pattern (Type Constraints)**

    ```scala
    // Generalized type constraints - more flexible than <:< and =:=
    @implicitNotFound("Cannot prove that ${A} is a subtype of ${B}")
    sealed abstract class <:<[-A, +B]

    object <:< {
      implicit def refl[A]: A <:< A = new (A <:< A) {}
      implicit def trans[A, B, C](
        implicit ab: A <:< B, bc: B <:< C
      ): A <:< C = new (A <:< C) {}
    }

    // Use case: Ensuring type safety in generic code
    def sort[A, B](list: List[A])(
      implicit ev: A <:< Ordered[A]
    ): List[A] = list.sorted

    // Prevent primitive widening
    def safeCast[A, B](a: A)(implicit ev: A =:= B): B = a

    // Works:
    safeCast[Int, Int](42)

    // Doesn't compile:
    // safeCast[Int, Long](42)  // No implicit =:= found
    ```

    **q) Curry-Howard Isomorphism (Proofs as Programs)**

    Advanced technique for encoding logical propositions in types.

    ```scala
    // Encode logical AND
    case class And[A, B](first: A, second: B)

    // Encode logical OR
    sealed trait Or[+A, +B]
    case class Left[A](value: A) extends Or[A, Nothing]
    case class Right[B](value: B) extends Or[Nothing, B]

    // Encode logical NOT (negation)
    type Not[A] = A => Nothing

    // Encode implication A => B (function!)
    type Implies[A, B] = A => B

    // Prove De Morgan's Law: ¬(A ∧ B) ≡ ¬A ∨ ¬B
    def deMorgan[A, B]: Not[And[A, B]] => Or[Not[A], Not[B]] =
      notAB => {
        // If we can't prove A, return Left(¬A)
        Left((a: A) => {
          // If we can't prove B, we have ¬(A ∧ B)
          Right((b: B) => notAB(And(a, b)))
        })
      }
    ```

    **r) Church Encoding (Type-Level Boolean Logic)**

    ```scala
    sealed trait Bool {
      type If[T, F]
    }

    sealed trait True extends Bool {
      type If[T, F] = T
    }

    sealed trait False extends Bool {
      type If[T, F] = F
    }

    // Type-level AND
    type &&[A <: Bool, B <: Bool] = A#If[B, False]

    // Type-level OR
    type ||[A <: Bool, B <: Bool] = A#If[True, B]

    // Type-level NOT
    type ![A <: Bool] = A#If[False, True]

    // Usage: Compile-time validation
    trait Validator[A, Valid <: Bool]

    def validate[A, V <: Bool](a: A)(
      implicit ev: V =:= True, validator: Validator[A, V]
    ): A = a

    // Only compiles if V is True
    ```

    **s) Tagless Final (Higher-Order Abstract Syntax)**

    Modern approach to DSLs, used in production by companies like Netflix (with Freestyle).

    ```scala
    // Define algebra (operations)
    trait KVStore[F[_]] {
      def get(key: String): F[Option[String]]
      def put(key: String, value: String): F[Unit]
      def delete(key: String): F[Unit]
    }

    // Program is polymorphic in F
    def program[F[_]: Monad](implicit kv: KVStore[F]): F[Option[String]] =
      for {
        _ <- kv.put("user:1", "Alice")
        user <- kv.get("user:1")
        _ <- kv.delete("user:1")
      } yield user

    // Interpreter 1: Real implementation
    class RedisKVStore extends KVStore[IO] {
      def get(key: String): IO[Option[String]] = ???
      def put(key: String, value: String): IO[Unit] = ???
      def delete(key: String): IO[Unit] = ???
    }

    // Interpreter 2: Testing with State monad
    class InMemoryKVStore extends KVStore[State[Map[String, String], *]] {
      def get(key: String): State[Map[String, String], Option[String]] =
        State.inspect(_.get(key))

      def put(key: String, value: String): State[Map[String, String], Unit] =
        State.modify(_ + (key -> value))

      def delete(key: String): State[Map[String, String], Unit] =
        State.modify(_ - key)
    }

    // Interpreter 3: Logging for debugging
    class LoggingKVStore[F[_]: Monad](underlying: KVStore[F])
        extends KVStore[F] {
      def get(key: String): F[Option[String]] =
        underlying.get(key).flatTap(v => log(s"GET $key => $v"))
      // ... etc
    }
    ```

    **t) MTL-Style Effect Management (Monad Transformer Library)**

    Used in large Scala apps with Cats MTL or ZIO's environmental effects.

    ```scala
    import cats.mtl._
    import cats.effect.IO
    import cats.data.ReaderT

    // Effect capabilities as type classes
    trait DatabaseOps[F[_]] {
      def query(sql: String): F[List[Row]]
    }

    trait LoggingOps[F[_]] {
      def log(msg: String): F[Unit]
    }

    trait MetricsOps[F[_]] {
      def increment(metric: String): F[Unit]
    }

    // Business logic constrained by required capabilities
    def processUser[F[_]: Monad: DatabaseOps: LoggingOps: MetricsOps](
      userId: Int
    ): F[User] =
      for {
        _ <- LoggingOps[F].log(s"Processing user $userId")
        rows <- DatabaseOps[F].query(s"SELECT * FROM users WHERE id = $userId")
        _ <- MetricsOps[F].increment("users.processed")
      } yield parseUser(rows.head)

    // Provide implementations at edge of application
    implicit val dbOps: DatabaseOps[IO] = ???
    implicit val logOps: LoggingOps[IO] = ???
    implicit val metricOps: MetricsOps[IO] = ???
    ```

    **u) Bifunctor IO Pattern (Typed Error Handling)**

    Used in production with ZIO, Cats EitherT, or custom effect types.

    ```scala
    // Separate error and success channels
    trait BIO[+E, +A] {
      def map[B](f: A => B): BIO[E, B]
      def flatMap[E1 >: E, B](f: A => BIO[E1, B]): BIO[E1, B]
      def mapError[E2](f: E => E2): BIO[E2, A]
      def catchAll[E2, A1 >: A](f: E => BIO[E2, A1]): BIO[E2, A1]
    }

    // Domain-specific error ADT
    sealed trait UserError
    case class UserNotFound(id: Int) extends UserError
    case class InvalidEmail(email: String) extends UserError
    case class DatabaseError(cause: Throwable) extends UserError

    // Type-safe error handling
    def getUser(id: Int): BIO[UserError, User] = ???
    def sendEmail(user: User): BIO[UserError, Unit] = ???

    val program: BIO[UserError, Unit] =
      for {
        user <- getUser(123)
        _ <- sendEmail(user)
      } yield ()

    // Handle errors by type
    program.catchAll {
      case UserNotFound(id) => log(s"User $id not found")
      case InvalidEmail(e) => log(s"Invalid email: $e")
      case DatabaseError(ex) => log(s"DB error: ${ex.getMessage}")
    }
    ```

    **v) Variance Encoding Patterns**

    Advanced variance handling for complex type hierarchies.

    ```scala
    // Problem: Need both covariance and contravariance
    trait Channel[-In, +Out] {
      def write(in: In): Unit
      def read(): Out
    }

    // Solution: Split into separate type classes
    trait Sink[-A] {
      def write(a: A): Unit
    }

    trait Source[+A] {
      def read(): A
    }

    case class Channel[A](sink: Sink[A], source: Source[A])

    // Now properly covariant/contravariant
    def processSink[A](sink: Sink[A], a: A): Unit = sink.write(a)

    val stringSink: Sink[String] = ???
    val anySink: Sink[Any] = stringSink  // Contravariance works!
    ```

    **w) Existential Type Unpacking Pattern**

    ```scala
    // Pack heterogeneous types with their operations
    trait Storage {
      type Item
      def store(item: Item): Unit
      def retrieve(): Item
    }

    // Create storages for different types
    def createStorage[A](initial: A): Storage = new Storage {
      type Item = A
      private var value: A = initial
      def store(item: A): Unit = value = item
      def retrieve(): A = value
    }

    // Use existential types to mix them
    val storages: List[Storage] = List(
      createStorage(42),
      createStorage("hello"),
      createStorage(true)
    )

    // Type-safe unpacking with type test
    def processStorage(s: Storage): String = {
      val item = s.retrieve()
      item match {
        case i: Int => s"Integer: $i"
        case s: String => s"String: $s"
        case b: Boolean => s"Boolean: $b"
        case _ => "Unknown"
      }
    }
    ```

    **x) Leibniz Equality (Principled Type Equality)**

    More powerful and composable than =:=.

    ```scala
    // Leibniz equality: if A === B, then F[A] === F[B] for all F
    sealed abstract class ===[A, B] {
      def apply[F[_]](fa: F[A]): F[B]
      def subst[F[_]](fa: F[A]): F[B] = apply(fa)
      def flip: B === A
      def andThen[C](bc: B === C): A === C
    }

    object === {
      implicit def refl[A]: A === A = new ===[A, A] {
        def apply[F[_]](fa: F[A]): F[A] = fa
        def flip: A === A = this
        def andThen[C](ac: A === C): A === C = ac
      }

      def force[A, B]: A === B = refl[A].asInstanceOf[A === B]
      def witness[A, B](implicit ev: A === B): A === B = ev
    }

    // Use case: Safe coercion with proof
    def cast[A, B](a: A)(implicit ev: A === B): B =
      ev.subst[λ[X => X]](a)
    ```

    **y) Recursive Implicit Resolution (Inductively Defined Type Classes)**

    Pattern for building complex type class instances from simpler ones.

    ```scala
    // Serialize nested data structures
    trait Serializer[A] {
      def serialize(a: A): String
    }

    object Serializer {
      // Base cases
      implicit val intSer: Serializer[Int] = _.toString
      implicit val stringSer: Serializer[String] = s => s""""$s""""

      // Recursive case: List
      implicit def listSer[A](implicit sa: Serializer[A]): Serializer[List[A]] =
        list => list.map(sa.serialize).mkString("[", ",", "]")

      // Recursive case: Option
      implicit def optionSer[A](implicit sa: Serializer[A]): Serializer[Option[A]] = {
        case Some(a) => sa.serialize(a)
        case None => "null"
      }

      // Recursive case: Tuple
      implicit def tuple2Ser[A, B](
        implicit sa: Serializer[A], sb: Serializer[B]
      ): Serializer[(A, B)] =
        t => s"(${sa.serialize(t._1)},${sb.serialize(t._2)})"
    }

    // Now works for arbitrarily nested structures!
    implicitly[Serializer[List[Option[(Int, String)]]]]
    ```

    **z) Scala 3: Inline & Compile-Time Operations**

    ```scala
    import scala.compiletime._

    // Compile-time string manipulation
    inline def validateEmail(inline email: String): String = {
      inline if (constValue[email.Contains["@"]] == true) email
      else error("Email must contain @")
    }

    // Usage:
    validateEmail("user@example.com")  // OK
    // validateEmail("invalid")  // Compile error!

    // Compile-time tuple operations
    inline def tupleSize[T <: Tuple]: Int =
      constValue[Tuple.Size[T]]

    inline def tupleHead[T <: NonEmptyTuple]: Tuple.Head[T] =
      summonInline[ValueOf[Tuple.Head[T]]].value
    ```

    **aa) Optics Patterns (Lenses, Prisms, Isos)**

    Used in production with Monocle library.

    ```scala
    // Lens: Focus on a field in immutable data
    case class Lens[S, A](get: S => A, set: (S, A) => S) {
      def modify(s: S)(f: A => A): S = set(s, f(get(s)))

      def compose[B](other: Lens[A, B]): Lens[S, B] =
        Lens(
          get = s => other.get(get(s)),
          set = (s, b) => set(s, other.set(get(s), b))
        )
    }

    case class Address(street: String, city: String)
    case class Person(name: String, address: Address)

    val addressLens = Lens[Person, Address](_.address, (p, a) => p.copy(address = a))
    val cityLens = Lens[Address, String](_.city, (a, c) => a.copy(city = c))
    val personCityLens = addressLens.compose(cityLens)

    val person = Person("Alice", Address("Main St", "NYC"))
    personCityLens.modify(person)(_.toUpperCase)
    // Person("Alice", Address("Main St", "NYC"))
    ```

    **Expert Interview Discussion Points**:
    1. **When Aux pattern is necessary**: Type members vs type parameters trade-offs
    2. **Implicit resolution complexity**: How compiler resolves nested type class instances
    3. **Performance implications**: Type-level computation is zero-cost, but implicit resolution can slow compilation
    4. **Limitations**: No true dependent types (unlike Idris/Agda), type-level computation limited
    5. **Practical vs theoretical**: When type-level programming helps vs over-engineering
    6. **Testing strategies**: How to test type-level code (shapeless-test, should-not-compile tests)
    7. **Debugging techniques**: Understanding implicit resolution errors, using `implicitly[]`, `reify`, `-Xlog-implicits`
    8. **Migration path**: Scala 2 type lambdas/kind-projector → Scala 3 match types/type lambdas
    9. **Tagless Final vs Free Monads**: Trade-offs in production systems
    10. **MTL vs ZIO Environment**: Effect system design patterns
    11. **Type class derivation performance**: Shapeless vs Magnolia vs Scala 3 derivation
    12. **Coherence in large codebases**: Preventing implicit ambiguity at scale
    13. **Magnet pattern pitfalls**: When it hurts vs helps API design
    14. **Leibniz vs built-in equality**: Understanding substitution principle
    15. **Optics in production**: When to use Monocle vs direct case class copying
    16. **Compile-time vs runtime**: Trade-offs between type safety and compilation speed
    17. **Generic programming**: Shapeless vs Scala 3 built-in derivation
    18. **Church encoding practical use**: When type-level booleans actually help

### Functional Programming

10. **Why can't you make a Monad instance for Validation/Applicative that accumulates errors?**
    - Monad requires dependent computation (flatMap)
    - Accumulating errors requires independent computation
    - Applicative is the right abstraction

11. **Explain the difference between `map`, `flatMap`, and `for` comprehensions**
    - `map`: Transform values inside context
    - `flatMap`: Chain dependent computations, flatten nested contexts
    - `for`: Syntactic sugar for flatMap/map chains

12. **What is referential transparency and why does it matter?**
    - Expression can be replaced by its value without changing behavior
    - Enables equational reasoning
    - Makes code testable and composable
    - `Future` is NOT referentially transparent

13. **Explain the difference between eager and lazy evaluation**
    - Eager: Evaluated immediately (Future, val)
    - Lazy: Evaluated when needed (IO, lazy val, by-name parameters)

14. **What is the Free Monad and when would you use it?**
    - Separates program structure from interpretation
    - Allows multiple interpreters (testing, production)
    - Useful for embedded DSLs

### Collections

15. **What's the difference between `Seq`, `List`, `Vector`, `Array`, `LazyList`?**
    - `Seq`: Trait for ordered sequences
    - `List`: Linked list, O(1) head access, O(n) index access
    - `Vector`: Balanced tree, O(log₃₂n) access/update (effectively constant)
    - `Array`: Mutable, backed by Java array
    - `LazyList`: Lazy, infinite sequences possible

16. **When would you use a `Set` vs a `List`?**
    - `Set`: Unique elements, fast contains check O(1) for HashSet
    - `List`: Order matters, duplicates allowed, sequential access

17. **Explain `foldLeft` vs `foldRight`**
    - `foldLeft`: Tail-recursive, left-to-right, stack-safe
    - `foldRight`: Not tail-recursive (for List), right-to-left
    - `foldRight` can short-circuit with lazy structures

### Concurrency

18. **What are the problems with Futures?**
    - Eager evaluation
    - Not referentially transparent
    - No built-in retry/timeout
    - Hard to compose complex async logic

19. **Explain how Akka supervision works**
    - Parent supervises children
    - Strategies: Resume, Restart, Stop, Escalate
    - Fault isolation and recovery

20. **What is backpressure and how do you handle it?**
    - Consumer can't keep up with producer
    - Akka Streams: built-in backpressure propagation
    - Solutions: buffering, dropping, throttling

### Design Patterns

21. **Implement the Cake Pattern**
    ```scala
    trait UserRepositoryComponent {
      def userRepository: UserRepository
      trait UserRepository {
        def findUser(id: Int): Option[User]
      }
    }
    ```

22. **What are type classes and why use them over inheritance?**
    - Ad-hoc polymorphism
    - Retroactive extension
    - Multiple implementations per type
    - Better separation of concerns

23. **Explain the Reader pattern for dependency injection**
    - Function `R => A` wrapped in a monad
    - Dependencies passed implicitly through flatMap chain
    - Testable and composable

### Performance & Optimization

24. **How do you make a recursive function tail-recursive?**
    - Use accumulator parameter
    - Annotate with `@tailrec` to verify
    - Last operation must be recursive call

25. **What is `@specialized` and when to use it?**
    - Prevents boxing for primitive types
    - Generates specialized bytecode
    - Use for performance-critical generic code

26. **How does Scala optimize pattern matching?**
    - Switch tables for simple matches
    - Type erasure considerations
    - Exhaustiveness checking

### Testing

27. **How would you test asynchronous code?**
    - ScalaTest with `eventually` / `AsyncTestSuite`
    - Cats Effect TestContext for IO
    - Akka TestKit for actors

28. **Property-based testing vs. example-based testing**
    - ScalaCheck generates random test cases
    - Tests properties/invariants
    - Finds edge cases

### Scala 3 Specific

29. **What are opaque types and when to use them?**
    ```scala
    opaque type UserId = Int
    // Zero-cost abstraction, no runtime overhead
    ```

30. **Explain union types and intersection types**
    ```scala
    type StringOrInt = String | Int  // Union
    type HasBoth = Readable & Writable  // Intersection
    ```

31. **What are context functions?**
    ```scala
    type Executable[T] = ExecutionContext ?=> T
    // Implicit function types
    ```

---

## Real Interview Questions from Actual Interviews

This section contains real technical questions asked in actual interviews at various companies (2024-2026). Questions are translated from Russian/Ukrainian and organized by category.

### Scala Fundamentals

#### 1. Implement filter using flatMap ⭐⭐
**Question**: How would you implement `filter` using only `flatMap`?

**Hint**:
```scala
val x: Seq[Int] = ...
x.flatMap { elem =>
  if (condition) Some(elem)
  else None
}
```

**Company**: Deep technical interview (Logistics/Analytics)
**Difficulty**: ⭐⭐ (Mid-level)

---

#### 2. Implement pattern matching extractor (unapply) ⭐⭐⭐
**Question**: Implement a custom `unapply` method for pattern matching with named parameters.

**Hint**: Understand how extractors work - they're the inverse of `apply` methods.

**Company**: Deep technical interview (Logistics/Analytics)
**Difficulty**: ⭐⭐⭐ (Mid-Senior)

---

#### 3. Count occurrences in a collection ⭐⭐
**Question**: Write a function to count occurrences of each element in a collection. What is the time complexity?

**Answer**:
```scala
def countOccurrences[A](list: List[A]): Map[A, Int] = {
  list.foldLeft(Map.empty[A, Int]) { (acc, elem) =>
    acc.updated(elem, acc.getOrElse(elem, 0) + 1)
  }
}
// Time complexity: O(n)
// Space complexity: O(k) where k is number of unique elements
```

**Follow-up**: What if the collection doesn't fit in memory?
**Answer**: Use distributed processing (Spark), streaming (Akka Streams/FS2), or external sorting.

**Companies**: Baader Bank, ICTO
**Difficulty**: ⭐⭐ (Mid-level)

---

### Functional Programming (Cats/ZIO)

#### 4. Compose Future with Either ⭐⭐⭐⭐
**Question**: You have `Future[Seq[Either[Error, Result]]]`. Convert it to `(Seq[Error], Seq[Result])`.

**Solution**:
```scala
import cats.implicits._

futures.traverse(identity).map { results =>
  results.foldLeft((List.empty[Error], List.empty[Result])) {
    case ((errors, results), Left(err)) => (errors :+ err, results)
    case ((errors, results), Right(res)) => (errors, results :+ res)
  }
}
```

**Key Concepts**: Traverse, partitioning, Either handling

**Company**: Deep technical interview (Logistics/Analytics)
**Difficulty**: ⭐⭐⭐⭐ (Senior)

---

#### 5. Run-length encoding ⭐⭐⭐
**Question**: Implement run-length encoding: `List(1,1,2,2,2,1)` => `List((1,2), (2,3), (1,1))`

**Solution**:
```scala
def encode[A](xs: List[A]): List[(A, Int)] = {
  @tailrec
  def loop(remaining: List[A], prev: A, count: Int, acc: List[(A, Int)]): List[(A, Int)] = {
    remaining match {
      case Nil => acc :+ (prev, count)
      case x :: xs if x == prev => loop(xs, prev, count + 1, acc)
      case x :: xs => loop(xs, x, 1, acc :+ (prev, count))
    }
  }
  xs match {
    case Nil => Nil
    case x :: xs => loop(xs, x, 1, Nil)
  }
}
```

**Key Concepts**: Tail recursion, pattern matching, state accumulation

**Company**: Deep technical interview (Logistics/Analytics)
**Difficulty**: ⭐⭐⭐ (Mid-Senior)

---

#### 6. Applicative vs Monad - Theory ⭐⭐⭐⭐⭐
**Question**: What's the difference between Applicative and Monad? Why can't you make Validated a Monad?

**Answer**:
- **Applicative**: Has `pure` and `map2`/`ap`, but NOT `flatMap`
  - Allows independent computations
  - Can accumulate errors (Validated, Parallel)
  - Operations can run in parallel

- **Monad**: Has `pure` and `flatMap`
  - Allows dependent computations
  - Fail-fast semantics (Either)
  - Sequential by nature

- **Why Validated can't be Monad**:
  - Monad requires flatMap with dependent computation
  - Validated accumulates ALL errors (independent validation)
  - These are fundamentally incompatible

**Follow-up**: When would you use Applicative over Monad?
- Form validation (accumulate all field errors)
- Parallel task execution
- When computations are independent

**Company**: Deep technical interview (Logistics/Analytics)
**Difficulty**: ⭐⭐⭐⭐⭐ (Senior+)

---

#### 7. Traverse - Why not for Sequence? ⭐⭐⭐⭐
**Question**: Why doesn't `Sequence` (Set, Map keys, etc.) have a `Traverse` instance?

**Answer**:
- Traverse requires consistent ordering for traversal
- Set/Map don't guarantee iteration order (except ordered variants)
- Traversing effects requires predictable sequencing
- List/Vector have structure that supports traversal

**Key Insight**: Traverse requires more structure than just being a container.

**Company**: Deep technical interview (Logistics/Analytics)
**Difficulty**: ⭐⭐⭐⭐ (Senior)

---

#### 8. ZIO vs Cats Effect - Philosophy ⭐⭐⭐⭐
**Question**: What are the main differences between ZIO and Cats Effect? When would you choose one over the other?

**Answer**:

**ZIO Advantages**:
- Richer API surface - more built-in methods
- ZLayers for dependency injection
- Typed errors (R, E, A)
- Better IDE autocomplete
- More opinionated (batteries included)

**Cats Effect Advantages**:
- Tagless Final style
- Smaller learning curve for FP practitioners
- More flexible (less opinionated)
- Better ecosystem integration
- Composability through type classes

**When to use ZIO**:
- Need strong dependency injection
- Want rich standard library
- Team prefers concrete types

**When to use Cats Effect**:
- Need maximum flexibility
- Following tagless final pattern
- Library author (wider compatibility)

**Company**: Deep technical interview (Logistics/Analytics), NetEnt, ICTO
**Difficulty**: ⭐⭐⭐⭐ (Senior, philosophical)

---

### Type System & Type-Level Programming

#### 9. Refined types - Use cases ⭐⭐⭐
**Question**: What are refined types and what are their advantages?

**Answer**:
```scala
import eu.timepit.refined._
import eu.timepit.refined.api.Refined
import eu.timepit.refined.numeric._
import eu.timepit.refined.string._

type PositiveInt = Int Refined Positive
type NonEmptyString = String Refined NonEmpty
type Email = String Refined MatchesRegex["^[^@]+@[^@]+$"]

// Validation happens at construction time
val age: Either[String, PositiveInt] = refineV[Positive](25)
```

**Advantages**:
- Compile-time validation (when possible)
- Runtime validation with type safety
- Self-documenting code
- Prevent invalid states
- No runtime overhead after validation

**Use Cases**:
- Domain validation (email, phone, age ranges)
- Configuration parsing
- API boundaries
- Financial calculations

**Companies**: Baader Bank, ICTO, Deep technical interview
**Difficulty**: ⭐⭐⭐ (Mid-Senior)

---

#### 10. New Type Pattern (AnyVal) ⭐⭐⭐
**Question**: Explain the "new type pattern" using `AnyVal`. What problem does it solve?

**Answer**:
```scala
// Without new type - easy to mix up
def transfer(from: Int, to: Int, amount: BigDecimal): Unit = ???
transfer(123, 456, 1000) // Which is from, which is to?

// With new type pattern
case class UserId(value: Int) extends AnyVal
case class AccountId(value: Int) extends AnyVal

def transfer(from: AccountId, to: AccountId, amount: BigDecimal): Unit = ???
transfer(UserId(123), AccountId(456), 1000) // Compile error!
transfer(AccountId(123), AccountId(456), 1000) // Correct
```

**Key Points**:
- **AnyVal**: No runtime boxing/unboxing overhead
- **Type Safety**: Compiler prevents mixing up semantically different IDs
- **Self-documenting**: Intent clear from types
- **Zero cost**: Erased at runtime

**Limitations**:
- Must extend AnyVal
- Only one field
- Can't be nested in other value classes

**Companies**: ICTO, Deep technical interview
**Difficulty**: ⭐⭐⭐ (Mid-Senior)

---

#### 11. Enums in Scala 2 - Problems ⭐⭐⭐
**Question**: What are the problems with Scala 2 enums? What's the idiomatic alternative?

**Answer**:

**Problems with Scala 2 Enums**:
```scala
object Color extends Enumeration {
  val Red, Green, Blue = Value
}
// Issues:
// 1. Type erasure - Color.Value is not type-safe
// 2. No exhaustiveness checking
// 3. No pattern matching support
// 4. Serialization issues
// 5. Can't add methods/data to variants
```

**Idiomatic Alternative - Sealed ADT**:
```scala
sealed trait Color
object Color {
  case object Red extends Color
  case object Green extends Color
  case object Blue extends Color

  val all: List[Color] = List(Red, Green, Blue)
}

// Or with data:
sealed trait Currency
object Currency {
  case object USD extends Currency
  case object EUR extends Currency
  case object BTC extends Currency
  case class Custom(code: String) extends Currency
}
```

**Advantages of ADT**:
- Exhaustiveness checking
- Type-safe pattern matching
- Can attach data to variants
- Better serialization (circe, play-json)
- Can add methods

**Company**: Baader Bank
**Difficulty**: ⭐⭐⭐ (Mid-Senior)

---

### Algorithms & Data Structures

#### 12. Time complexity analysis ⭐⭐
**Question**: Given an algorithm that counts occurrences in a list using a Map, what's the time complexity? What about space?

**Answer**:
- **Time**: O(n) - single pass through list
- **Space**: O(k) where k = number of unique elements
  - Best case: O(1) - all elements same
  - Worst case: O(n) - all elements unique
  - Average: depends on distribution

**Follow-up Questions**:
- What if you use Array instead of Map? O(max_value) space
- What about sorted list optimization? Can count runs in O(n) time, O(1) space (if list already sorted)

**Companies**: Baader Bank, ICTO
**Difficulty**: ⭐⭐ (Mid-level)

---

### Architecture & Distributed Systems

#### 13. HTTP idempotency ⭐⭐⭐
**Question**: Which HTTP methods are idempotent and why does it matter?

**Answer**:

**Idempotent Methods**:
- **GET**: Read-only, multiple calls = same result
- **PUT**: Replace resource, calling twice = same final state
- **DELETE**: Remove resource, already deleted = same state

**NOT Idempotent**:
- **POST**: Create resource, multiple calls = multiple resources
- **PATCH**: Partial update, depends on implementation

**Why It Matters**:
- **Retry safety**: Can safely retry idempotent operations
- **Distributed systems**: At-least-once delivery requires idempotency
- **Client behavior**: Browsers/proxies can automatically retry
- **API design**: Makes APIs more robust

**Real-world**: Payment processing needs idempotency keys with POST

**Company**: ICTO
**Difficulty**: ⭐⭐⭐ (Mid-Senior)

---

#### 14. Outbox Pattern ⭐⭐⭐⭐⭐
**Question**: Explain the Outbox Pattern. What problem does it solve?

**Answer**:

**Problem - Dual Writes**:
```scala
// WRONG - not atomic!
def processOrder(order: Order): Unit = {
  database.saveOrder(order)        // Write 1
  kafka.publish(OrderCreated(order)) // Write 2
  // What if app crashes between these?
}
```

**Solution - Outbox Pattern**:
```scala
// Single transaction
def processOrder(order: Order): Unit = {
  database.transaction {
    database.saveOrder(order)
    database.insertOutbox(OrderCreated(order)) // Same DB!
  }
}

// Separate process reads outbox
def outboxWorker(): Unit = {
  database.selectUnpublished().foreach { event =>
    kafka.publish(event)
    database.markPublished(event.id)
  }
}
```

**Key Points**:
- Guarantees message delivery (at-least-once)
- Single transaction for consistency
- Separate polling process publishes events
- Idempotency required on consumer side

**Alternative - CDC (Change Data Capture)**:
- Debezium reads DB WAL directly
- Publishes changes to Kafka
- No polling needed

**Company**: ICTO
**Difficulty**: ⭐⭐⭐⭐⭐ (Senior/Architect)

---

#### 15. CDC - Change Data Capture ⭐⭐⭐⭐
**Question**: How does Change Data Capture work in PostgreSQL?

**Answer**:

**PostgreSQL CDC via WAL (Write-Ahead Log)**:
```
1. All changes written to WAL first
2. WAL guarantees durability
3. Logical replication reads WAL
4. Debezium/custom reader publishes to Kafka
```

**Advantages**:
- No application code changes
- Low latency
- Guaranteed event capture
- Historical replay possible

**Tools**:
- **Debezium**: Most popular, Kafka Connect
- **Kafka Connect JDBC**: Polling-based
- **Maxwell**: For MySQL
- **Custom**: pg_recvlogical

**Use Cases**:
- Event sourcing
- Data synchronization
- Cache invalidation
- Microservice communication
- Audit logs

**Company**: ICTO
**Difficulty**: ⭐⭐⭐⭐ (Senior)

---

#### 16. At-least-once delivery patterns ⭐⭐⭐⭐
**Question**: How do you handle at-least-once delivery in microservices? What about exactly-once?

**Answer**:

**At-Least-Once**:
- Message might be delivered multiple times
- Requires idempotent consumers
- Kafka default behavior

**Idempotency Strategies**:
1. **Unique IDs**: Track processed message IDs
   ```scala
   def process(event: Event): IO[Unit] =
     if (alreadyProcessed(event.id)) IO.unit
     else doWork(event) >> markProcessed(event.id)
   ```

2. **Natural Idempotency**: Operations naturally idempotent
   ```scala
   // SET operations are idempotent
   UPDATE users SET status = 'active' WHERE id = 123
   ```

3. **State Machines**: Only valid transitions allowed
   ```scala
   case (OrderPending, PaymentReceived) => OrderPaid
   case (OrderPaid, PaymentReceived) => OrderPaid // Idempotent
   ```

**Exactly-Once** (harder):
- Kafka transactions (0.11+)
- Two-phase commit
- Usually not worth complexity

**Company**: ICTO, Baader Bank
**Difficulty**: ⭐⭐⭐⭐ (Senior)

---

### Database & Performance

#### 17. SQL Injection prevention ⭐⭐
**Question**: How do you prevent SQL injection? What are prepared statements?

**Answer**:

**Vulnerable Code**:
```scala
// NEVER DO THIS
val query = s"SELECT * FROM users WHERE name = '$userName'"
database.execute(query)
// userName = "'; DROP TABLE users; --"
```

**Safe - Prepared Statements**:
```scala
val query = "SELECT * FROM users WHERE name = ?"
database.prepareStatement(query).setString(1, userName)
```

**Type-Safe - Doobie**:
```scala
import doobie._
import doobie.implicits._

def findUser(name: String): ConnectionIO[Option[User]] =
  sql"SELECT * FROM users WHERE name = $name"
    .query[User]
    .option
// Parameters automatically escaped and type-checked!
```

**Why It Works**:
- Parameters sent separately from query
- Database driver handles escaping
- No string concatenation
- Type safety at compile time (Doobie, Slick)

**Companies**: Baader Bank, all companies expect this knowledge
**Difficulty**: ⭐⭐ (Mid-level, but critical)

---

#### 18. PostgreSQL indexes - B-tree ⭐⭐⭐
**Question**: How do B-tree indexes work in PostgreSQL? When should you use them?

**Answer**:

**B-tree Characteristics**:
- Balanced tree structure
- O(log n) lookups, inserts, deletes
- Good for equality and range queries
- Default index type in PostgreSQL

**When to Use**:
```sql
-- Good for:
WHERE user_id = 123
WHERE created_at > '2024-01-01'
WHERE name LIKE 'John%'
ORDER BY created_at

-- Not good for:
WHERE name LIKE '%john%'  -- Full scan
WHERE status IN (list of 1000 items)  -- Consider bitmap
```

**Index Selectivity**:
- High selectivity (many unique values) = good
- Low selectivity (few unique values) = might skip index

**Composite Indexes**:
```sql
CREATE INDEX idx_user_date ON orders(user_id, created_at);
-- Efficient for: WHERE user_id = ? AND created_at > ?
-- Less efficient for: WHERE created_at > ?  (wrong order)
```

**Company**: Baader Bank
**Difficulty**: ⭐⭐⭐ (Mid-Senior)

---

#### 19. JOIN operations optimization ⭐⭐⭐
**Question**: What are different types of JOINs in SQL and how does the database optimize them?

**Answer**:

**JOIN Types**:
```sql
-- INNER JOIN: Only matching rows
SELECT * FROM orders o
INNER JOIN users u ON o.user_id = u.id

-- LEFT JOIN: All left rows + matching right
SELECT * FROM orders o
LEFT JOIN shipments s ON o.id = s.order_id

-- RIGHT JOIN: All right rows + matching left
-- FULL OUTER JOIN: All rows from both tables
```

**Optimization Strategies**:
1. **Nested Loop Join**: Small tables, O(n*m)
2. **Hash Join**: Build hash table, O(n+m), uses memory
3. **Merge Join**: Both sorted, O(n+m), efficient for large sorted tables

**Query Planner**:
```sql
EXPLAIN ANALYZE SELECT ...
-- Shows:
-- - Which join algorithm used
-- - Index usage
-- - Row estimates vs actual
-- - Execution time
```

**Best Practices**:
- Index foreign keys
- Filter early (WHERE before JOIN)
- Avoid SELECT *
- Consider denormalization for read-heavy workloads

**Company**: Baader Bank
**Difficulty**: ⭐⭐⭐ (Mid-Senior)

---

### Practical Coding Tasks

#### 20. Model Price correctly ⭐⭐⭐⭐
**Question**: How should you model Price in a financial application? Why not use Float/Double?

**Answer**:

**WRONG**:
```scala
case class Price(amount: Double)  // ❌ NEVER DO THIS

val p1 = 0.1 + 0.2  // 0.30000000000000004 ❌
```

**Problems with Float/Double**:
- Rounding errors
- Not exact decimal representation
- Accumulating errors in calculations
- Fails audits and regulations

**CORRECT Approaches**:

**Option 1: BigDecimal**
```scala
case class Price(
  amount: BigDecimal,
  currency: Currency
)

object Price {
  def apply(amount: String, currency: Currency): Price =
    Price(BigDecimal(amount), currency)
}

val price = Price("19.99", Currency.USD)
```

**Option 2: Smallest Unit (Cents)**
```scala
case class Price(
  cents: Long,  // Store in smallest unit
  currency: Currency
)

object Price {
  def fromDollars(dollars: BigDecimal, currency: Currency): Price =
    Price((dollars * 100).toLong, currency)

  def toDollars(price: Price): BigDecimal =
    BigDecimal(price.cents) / 100
}
```

**Option 3: With Precision**
```scala
case class Price(
  amount: Long,        // Raw value
  scale: Int,          // Decimal places
  currency: Currency
)

// Different currencies need different precision:
// USD: 2 decimal places ($19.99)
// JPY: 0 decimal places (¥1999)
// BTC: 8 decimal places (₿0.00001999)
```

**With Refined Types**:
```scala
import eu.timepit.refined._
import eu.timepit.refined.numeric._

type PositiveAmount = Long Refined Positive

case class Price(
  amount: PositiveAmount,
  scale: Int Refined Interval.Closed[0, 8],
  currency: Currency
)
```

**Company**: Baader Bank (Investment banking, critical requirement)
**Difficulty**: ⭐⭐⭐⭐ (Senior, domain-specific)

---

#### 21. Model Currency with ADT ⭐⭐⭐
**Question**: How would you model Currency in Scala? Consider crypto currencies.

**Answer**:

```scala
sealed trait Currency {
  def code: String
  def symbol: String
  def decimalPlaces: Int
}

object Currency {
  // Standard fiat currencies
  case object USD extends Currency {
    val code = "USD"
    val symbol = "$"
    val decimalPlaces = 2
  }

  case object EUR extends Currency {
    val code = "EUR"
    val symbol = "€"
    val decimalPlaces = 2
  }

  case object JPY extends Currency {
    val code = "JPY"
    val symbol = "¥"
    val decimalPlaces = 0
  }

  // Crypto currencies
  case object BTC extends Currency {
    val code = "BTC"
    val symbol = "₿"
    val decimalPlaces = 8
  }

  case object ETH extends Currency {
    val code = "ETH"
    val symbol = "Ξ"
    val decimalPlaces = 18
  }

  // Custom/unknown currencies
  case class Custom(
    code: String,
    symbol: String,
    decimalPlaces: Int
  ) extends Currency

  val all: List[Currency] = List(USD, EUR, JPY, BTC, ETH)

  def fromCode(code: String): Option[Currency] =
    all.find(_.code == code)
}

// Type-safe money with currency
case class Money(amount: BigDecimal, currency: Currency) {
  def +(other: Money): Either[String, Money] =
    if (currency == other.currency)
      Right(Money(amount + other.amount, currency))
    else
      Left(s"Cannot add $currency to ${other.currency}")

  // Formatted display
  def format: String = {
    val formatted = amount.setScale(currency.decimalPlaces)
    s"${currency.symbol}$formatted"
  }
}
```

**Why ADT over Scala 2 Enum**:
- Can attach data (symbol, decimal places)
- Pattern matching exhaustiveness
- Can add Custom variant for runtime currencies
- Better JSON serialization

**Company**: Baader Bank
**Difficulty**: ⭐⭐⭐ (Mid-Senior)

---

#### 22. Event-driven microservice communication ⭐⭐⭐⭐
**Question**: Design communication between microservices. When would you use Kafka vs HTTP?

**Answer**:

**Use Kafka When**:
- Asynchronous processing acceptable
- Need message replay
- Multiple consumers
- Event sourcing/audit log
- High throughput
- Decoupling producers/consumers

**Use HTTP When**:
- Synchronous response needed
- Request-response pattern
- Simple point-to-point
- Real-time validation
- Lower latency requirements

**Hybrid Architecture**:
```scala
// Command: Synchronous HTTP
POST /orders
{
  "userId": 123,
  "items": [...]
}
Response: { "orderId": "abc-123", "status": "pending" }

// Events: Asynchronous Kafka
OrderCreated -> Kafka -> [ Inventory, Shipping, Notifications ]
PaymentCompleted -> Kafka -> [ Orders, Analytics ]
```

**Best Practices**:
- Commands via HTTP (state changes requiring validation)
- Events via Kafka (notifications, derived data)
- Choreography for domain events
- Orchestration for workflows
- Circuit breakers for HTTP
- Dead letter queues for Kafka

**Company**: All companies (Baader Bank, ICTO, NetEnt)
**Difficulty**: ⭐⭐⭐⭐ (Senior/Architect)

---

#### 23. Real-time news processing system ⭐⭐⭐⭐⭐
**Question**: Design a real-time news processing system for stock exchange where first 5-10 seconds are critical.

**Requirements** (Baader Bank context):
- Ingest news from multiple providers
- Process and categorize
- Deliver to traders within seconds
- High availability
- Handle spikes

**Design**:
```
[News Providers]
    ↓
[Ingestion Layer - Kafka]
    ↓
[Stream Processing - Akka Streams/Flink]
  - Parse
  - Deduplicate
  - Enrich (company symbols, sentiment)
  - Score urgency
    ↓
[Search Index - Elasticsearch]
[Cache - Redis]
    ↓
[WebSocket / Server-Sent Events]
    ↓
[Trader UI]
```

**Key Technologies**:
- **Kafka**: Durable buffer, replay capability
- **Stream Processing**: Real-time transformation
- **Elasticsearch**: Fast full-text search
- **Redis**: Hot cache for recent news
- **WebSockets**: Push to clients

**Optimizations**:
- Pre-compute relevance scores
- Priority queues for urgent news
- Geographic distribution (CDN)
- Connection pooling
- Backpressure handling

**Company**: Baader Bank (Real project)
**Difficulty**: ⭐⭐⭐⭐⭐ (Senior/Architect, system design)

---

### Deep Theoretical Questions

#### 24. Why does Applicative need only map2, not flatMap? ⭐⭐⭐⭐⭐
**Question**: Explain why Applicative is defined with `pure` and `map2` (or `ap`), but not `flatMap`. What power does this give us?

**Answer**:

**Applicative Laws**:
```scala
trait Applicative[F[_]] extends Functor[F] {
  def pure[A](a: A): F[A]
  def map2[A, B, C](fa: F[A], fb: F[B])(f: (A, B) => C): F[C]
  // Or equivalently:
  def ap[A, B](ff: F[A => B])(fa: F[A]): F[B]
}
```

**Key Insight**: Computations are **independent**
```scala
// Applicative - both sides can run in parallel
(fa, fb).mapN((a, b) => a + b)

// Monad - second depends on first
fa.flatMap(a => if (a > 0) fb else fc)
```

**What This Enables**:

1. **Parallelism**: Can run `fa` and `fb` concurrently
2. **Static Analysis**: Know structure before execution
3. **Error Accumulation**: Validated can accumulate ALL errors
4. **Optimization**: Compilers can optimize independent computations

**Example - Form Validation**:
```scala
case class User(name: String, age: Int, email: String)

def validateName(s: String): Validated[String, String] = ???
def validateAge(i: Int): Validated[String, Int] = ???
def validateEmail(s: String): Validated[String, String] = ???

// Applicative - accumulates ALL errors
(
  validateName(name),
  validateAge(age),
  validateEmail(email)
).mapN(User.apply)
// Returns: Invalid(List("Name too short", "Age negative", "Invalid email"))

// With Monad (flatMap) - stops at FIRST error
for {
  n <- validateName(name)
  a <- validateAge(age)
  e <- validateEmail(email)
} yield User(n, a, e)
// Returns: Invalid("Name too short") and stops
```

**Category Theory**:
- Functor: Structure-preserving map
- Applicative: Independent effects
- Monad: Dependent effects (most powerful, least composable)

**Company**: Deep technical interview (Logistics/Analytics)
**Difficulty**: ⭐⭐⭐⭐⭐ (Senior+, theoretical)

---

## Summary Statistics

**Total Questions**: 24 real interview questions
**Sources**: 6 different companies/interviews
**Difficulty Breakdown**:
- ⭐⭐ (Mid-level): 5 questions
- ⭐⭐⭐ (Mid-Senior): 8 questions
- ⭐⭐⭐⭐ (Senior): 7 questions
- ⭐⭐⭐⭐⭐ (Senior+/Architect): 4 questions

**Companies**:
- Deep Technical Interview (Logistics/Analytics): 8 questions
- ICTO: 5 questions
- Baader Bank (Germany): 7 questions
- NetEnt/Evolution Gaming: 1 question
- General (multiple companies): 3 questions

**Most Tested Topics**:
1. Functional Programming Theory (7 questions)
2. Architecture & Distributed Systems (6 questions)
3. Type System & Domain Modeling (5 questions)
4. Database & Performance (3 questions)
5. Scala Fundamentals (3 questions)

---

## Additional Advanced Interview Questions (from Industry Sources)

This section contains curated high-quality Scala interview questions from various industry sources, GitHub repositories, technical blogs, and company interview guides. These questions focus on advanced topics commonly asked in senior-level interviews.

### Advanced Implicits & Type Classes

#### 32. Implicit Resolution Scope and Precedence ⭐⭐⭐⭐

**Question**: Explain the implicit resolution mechanism in Scala. What are the two places the compiler looks for implicits, and what is the precedence order?

**Answer**:

The Scala compiler searches for implicits in two main places:

**1. Local Scope (Higher Priority)**:
- Current scope and outer scopes
- Explicit imports
- Wildcard imports
- Lexical scope of the call site

**2. Companion Objects (Lower Priority)**:
- Companion object of the type
- Companion object of the type arguments
- Companion object of the type's superclasses

**Precedence Rules**:
```scala
trait Show[A] {
  def show(a: A): String
}

object Show {
  // Low priority: companion object
  implicit val intShow: Show[Int] = _.toString
}

object Example {
  // High priority: local scope
  implicit val customIntShow: Show[Int] = n => s"Number: $n"

  def display[A](a: A)(implicit s: Show[A]): String = s.show(a)

  display(42) // Uses customIntShow from local scope
}
```

**Common Pitfall**:
- Multiple implicits in scope cause ambiguity errors
- Companion object implicits are often preferred for library authors to avoid polluting user scope

**Why It Matters**:
- Critical for designing type class hierarchies
- Affects library API design decisions
- Common source of compilation errors

**Difficulty**: ⭐⭐⭐⭐ (Senior)

**Sources**:
- [Adaface Scala Interview Questions](https://www.adaface.com/blog/scala-interview-questions/)
- [DigitalDefynd Scala Questions 2026](https://digitaldefynd.com/IQ/top-scala-interview-questions-answers/)

---

#### 33. Type Class Derivation Pattern ⭐⭐⭐⭐⭐

**Question**: Implement a JSON encoder type class with automatic derivation for case classes. Explain how recursive implicit resolution works.

**Answer**:

```scala
import scala.compiletime.*
import scala.deriving.*

// Type class definition
trait JsonEncoder[A] {
  def encode(value: A): String
}

object JsonEncoder {
  // Summoner method
  def apply[A](implicit enc: JsonEncoder[A]): JsonEncoder[A] = enc

  // Smart constructor
  def instance[A](f: A => String): JsonEncoder[A] =
    new JsonEncoder[A] {
      def encode(value: A): String = f(value)
    }

  // Base instances
  implicit val stringEncoder: JsonEncoder[String] =
    instance(s => s""""$s"""")

  implicit val intEncoder: JsonEncoder[Int] =
    instance(_.toString)

  implicit val boolEncoder: JsonEncoder[Boolean] =
    instance(_.toString)

  // Recursive instance for List
  implicit def listEncoder[A](implicit encA: JsonEncoder[A]): JsonEncoder[List[A]] =
    instance { list =>
      list.map(encA.encode).mkString("[", ",", "]")
    }

  // Recursive instance for Option
  implicit def optionEncoder[A](implicit encA: JsonEncoder[A]): JsonEncoder[Option[A]] =
    instance {
      case Some(a) => encA.encode(a)
      case None => "null"
    }

  // Product derivation (case classes)
  implicit def productEncoder[A](
    implicit mirror: Mirror.ProductOf[A],
    encoders: JsonEncoder[mirror.MirroredElemTypes]
  ): JsonEncoder[A] = instance { value =>
    // Simplified - real implementation uses HList/Tuple ops
    "{...}"
  }
}

// Usage - works for arbitrarily nested structures
case class User(name: String, age: Int, active: Boolean)

implicit val userEncoder: JsonEncoder[User] = JsonEncoder.instance { user =>
  s"""{"name":"${user.name}","age":${user.age},"active":${user.active}}"""
}

val users = List(User("Alice", 30, true), User("Bob", 25, false))
JsonEncoder[List[User]].encode(users)
// [{"name":"Alice","age":30,"active":true},{"name":"Bob","age":25,"active":false}]
```

**How Recursive Resolution Works**:

1. Compiler needs `JsonEncoder[List[User]]`
2. Finds `listEncoder[A]` which requires `JsonEncoder[User]`
3. Finds `userEncoder` in scope
4. Resolves successfully

**Why It Matters**:
- Foundation of libraries like Circe, Play JSON
- Understanding this enables creating generic, composable libraries
- Common pattern in modern Scala codebases

**Common Mistakes**:
- Forgetting `Lazy[...]` wrapper can cause diverging implicit expansion
- Not handling recursive types (e.g., tree structures)
- Implicit ambiguity when multiple derivation strategies exist

**Difficulty**: ⭐⭐⭐⭐⭐ (Senior+)

**Sources**:
- [Scala Type Classes Documentation](https://docs.scala-lang.org/scala3/book/ca-type-classes.html)
- [Baeldung Type Classes Tutorial](https://www.baeldung.com/scala/type-classes)

---

#### 34. Context Bounds vs Implicit Parameters ⭐⭐⭐

**Question**: What's the difference between context bounds and implicit parameters? When should you use each?

**Answer**:

**Context Bound Syntax**:
```scala
def sort[A: Ordering](list: List[A]): List[A] =
  list.sorted
```

**Equivalent Implicit Parameter**:
```scala
def sort[A](list: List[A])(implicit ord: Ordering[A]): List[A] =
  list.sorted
```

**Key Differences**:

| Aspect | Context Bound `[A: TC]` | Implicit Parameter `(implicit tc: TC[A])` |
|--------|------------------------|-------------------------------------------|
| Access to instance | `implicitly[TC[A]]` or `TC[A]` | Direct: `tc.method()` |
| Readability | Cleaner for single constraint | Better when you need the instance |
| Multiple constraints | `[A: TC1: TC2: TC3]` | Separate parameter groups |
| Named instance | No | Yes |

**When to Use Context Bounds**:
```scala
// You don't need to call methods on the type class
def maximum[A: Ordering](a: A, b: A): A =
  if (implicitly[Ordering[A]].compare(a, b) > 0) a else b

// Multiple constraints are cleaner
def processData[A: Encoder: Decoder: Schema](data: A): Unit = ???
```

**When to Use Implicit Parameters**:
```scala
// You need the instance directly
def show[A](value: A)(implicit s: Show[A]): String =
  s.show(value)  // Direct access

// Complex logic with the type class
def customSort[A](list: List[A])(implicit ord: Ordering[A]): List[A] = {
  // Using ord multiple times
  list.filter(ord.gt(_, ord.zero)).sorted(ord)
}
```

**Scala 3 Improvement**:
```scala
// Context bounds can be referenced directly
def maximum[A: Ordering](a: A, b: A): A =
  if (summon[Ordering[A]].compare(a, b) > 0) a else b

// Or even better with `using` clause
def maximum[A](a: A, b: A)(using ord: Ordering[A]): A =
  if (ord.compare(a, b) > 0) a else b
```

**Why It Matters**:
- Affects API ergonomics
- Common in FP libraries (Cats, ZIO)
- Interviewers test understanding of implicit mechanics

**Difficulty**: ⭐⭐⭐ (Mid-Senior)

**Sources**:
- [Scala Documentation - Context Bounds](https://docs.scala-lang.org/tour/implicit-parameters.html)
- [DataCamp Scala Interview Questions](https://www.datacamp.com/blog/scala-interview-questions)

---

#### 35. Implicit Conversion Pitfalls ⭐⭐⭐⭐

**Question**: What are the dangers of implicit conversions? Why does Scala 3 deprecate implicit conversions in favor of given/using?

**Answer**:

**Problems with Implicit Conversions (Scala 2)**:

```scala
// Problem 1: Hidden conversions make code hard to understand
implicit def stringToInt(s: String): Int = s.toInt

val x: Int = "42"  // Looks like magic!

// Problem 2: Performance overhead
class RichString(s: String) {
  def isPalindrome: Boolean = s == s.reverse
}

implicit def enrichString(s: String): RichString = new RichString(s)

"hello".isPalindrome  // Creates new object every call!

// Problem 3: Ambiguity and conflicts
implicit def intToString(i: Int): String = i.toString
implicit def stringToInt(s: String): Int = s.toInt

val result = "5" + 10  // Which conversion?

// Problem 4: Surprising type coercion
case class UserId(id: Int)
implicit def intToUserId(i: Int): UserId = UserId(i)

def deleteUser(userId: UserId): Unit = ???

deleteUser(42)  // Compiles but probably unintended!
```

**Scala 3 Solution - Explicit Conversion**:

```scala
// Define conversion
given Conversion[String, Int] with
  def apply(s: String): Int = s.toInt

// Must import scala.language.implicitConversions
import scala.language.implicitConversions

val x: Int = "42"  // Now requires explicit language feature
```

**Better Alternative - Extension Methods**:

```scala
// Scala 3 - no runtime object creation
extension (s: String)
  def isPalindrome: Boolean = s == s.reverse

"hello".isPalindrome  // Zero overhead!

// Scala 2 equivalent
implicit class RichString(private val s: String) extends AnyVal {
  def isPalindrome: Boolean = s == s.reverse
}
```

**Best Practices**:

1. **Avoid implicit conversions** - use extension methods instead
2. **Use value classes** (`extends AnyVal`) to avoid allocation
3. **Make conversions explicit** when necessary
4. **Use newtype pattern** for type safety:

```scala
// Scala 3
opaque type UserId = Int
object UserId {
  def apply(id: Int): UserId = id
  extension (id: UserId) def value: Int = id
}

// Scala 2
case class UserId(value: Int) extends AnyVal
```

**Why It Matters**:
- Implicit conversions are a common source of bugs
- Performance implications often overlooked
- Scala 3 modernizes the approach
- Shows understanding of language evolution

**Common Interview Follow-ups**:
- "How would you add methods to existing types without conversions?"
- "What's the runtime cost of implicit conversions?"
- "Explain the value class restriction (no nested value classes)"

**Difficulty**: ⭐⭐⭐⭐ (Senior)

**Sources**:
- [Scala 3 Migration Guide](https://docs.scala-lang.org/scala3/guides/migration/compatibility-intro.html)
- [DigitalDefynd Advanced Questions](https://digitaldefynd.com/IQ/top-scala-interview-questions-answers/)

---

### Collections & Performance

#### 36. Vector vs List Performance Trade-offs ⭐⭐⭐⭐

**Question**: Explain the internal structure of Vector and List. When would you choose one over the other? What are the Big-O complexities?

**Answer**:

**List Structure**:
- Singly-linked list
- Each element points to next
- Head in memory, tail somewhere else

**Vector Structure**:
- 32-way branching tree
- Effectively constant time random access (O(log₃₂ n) ≈ O(1))
- Bit-partitioning for index lookup

**Performance Comparison**:

| Operation | List | Vector | Winner |
|-----------|------|--------|--------|
| `head` / `last` | O(1) / O(n) | O(1) / O(1) | Vector for last |
| `tail` / `init` | O(1) / O(n) | O(1) / O(1) | Vector for init |
| Prepend `::` | O(1) | O(log₃₂ n) | List |
| Append `:+` | O(n) | O(log₃₂ n) | Vector |
| Random access `(i)` | O(n) | O(log₃₂ n) ≈ O(1) | Vector |
| `map` / `filter` | O(n) | O(n) | Tie |
| Pattern matching | Excellent | Poor | List |

**When to Use List**:
```scala
// 1. Pattern matching heavy code
def sum(list: List[Int]): Int = list match {
  case Nil => 0
  case head :: tail => head + sum(tail)
}

// 2. Prepending in loops (building from right to left)
def reverse[A](list: List[A]): List[A] = {
  @tailrec
  def loop(remaining: List[A], acc: List[A]): List[A] =
    remaining match {
      case Nil => acc
      case head :: tail => loop(tail, head :: acc)
    }
  loop(list, Nil)
}

// 3. Small sequences (<100 elements)
val config = List("host", "port", "timeout")
```

**When to Use Vector**:
```scala
// 1. Random access patterns
val data = Vector(1, 2, 3, 4, 5)
data(2)  // Fast O(log₃₂ n)
data.updated(2, 10)  // Also fast

// 2. Appending (building from left to right)
(1 to 1000000).foldLeft(Vector.empty[Int])(_ :+ _)  // Much faster

// 3. Large sequences with varied access patterns
val largeData = Vector.tabulate(100000)(identity)
largeData.take(50)
largeData.drop(50)
largeData.slice(1000, 2000)

// 4. Default choice for general-purpose indexed sequences
def processData(data: IndexedSeq[Int]): Unit = ???
processData(Vector(1, 2, 3))  // IndexedSeq default
```

**Memory Characteristics**:

```scala
// List: Each element = 16-24 bytes overhead (pointer + object header)
val list = List(1, 2, 3)  // ~72 bytes for 3 integers

// Vector: 32-element chunks, more memory efficient for large collections
val vector = Vector(1, 2, 3)  // ~40 bytes for 3 integers (in same chunk)
```

**Real-World Example**:

```scala
// Building a collection incrementally
// BAD - List with append is O(n²)
var result = List.empty[Int]
for (i <- 1 to 10000) {
  result = result :+ i  // O(n) each time!
}

// GOOD - List with prepend + reverse
val result = (1 to 10000).foldLeft(List.empty[Int])((acc, i) => i :: acc).reverse

// BETTER - Vector with append
val result = (1 to 10000).foldLeft(Vector.empty[Int])(_ :+ _)

// BEST - Builder pattern
val result = List.newBuilder[Int]
for (i <- 1 to 10000) result += i
result.result()
```

**Why It Matters**:
- Most common performance mistake in Scala
- Understanding data structure internals shows deep knowledge
- Real impact on production systems

**Common Mistakes**:
- Using `list :+ elem` in loops (O(n²))
- Using `list(index)` for large lists
- Not considering memory overhead

**Difficulty**: ⭐⭐⭐⭐ (Senior)

**Sources**:
- [Scala Collections Performance](https://www.scala-lang.org/blog/2018/02/09/collections-performance.html)
- [Scala Collections Documentation](https://docs.scala-lang.org/overviews/collections-2.13/concrete-immutable-collection-classes.html)

---

#### 37. LazyList vs Stream vs Iterator ⭐⭐⭐⭐

**Question**: Compare LazyList (Scala 2.13+), Stream (deprecated), and Iterator. What are the memory implications of each?

**Answer**:

**Key Differences**:

| Aspect | Iterator | Stream (old) | LazyList (new) |
|--------|----------|--------------|----------------|
| Reusability | No (consumed) | Yes (memoized) | Yes (memoized) |
| Memoization | None | Head strict, tail lazy | Fully lazy |
| Memory | Minimal | Can cause leaks | Safer (GC-friendly) |
| Traversal | Once | Multiple | Multiple |
| Pattern Matching | No | Yes | Yes |

**Iterator - Use for Single-Pass**:
```scala
// Memory efficient, but one-time use
val iter = Iterator.from(1).take(1000000)
iter.sum  // Works
iter.sum  // Returns 0 (exhausted!)

// Good for large files
val lines = Source.fromFile("huge.txt").getLines()
lines.foreach(println)  // Process once
```

**Stream (Scala 2.12, deprecated) - Memory Leak Risk**:
```scala
// Problem: Keeps head reference, prevents GC
val stream = Stream.from(1)
val first = stream.head  // Holds reference to entire stream!

// Memory leak example
val bigStream = Stream.fill(1000000)(new Array[Byte](1024))
val head = bigStream.head  // Entire stream stays in memory!
```

**LazyList (Scala 2.13+) - Safer Alternative**:
```scala
// Properly lazy, GC-friendly
val lazyList = LazyList.from(1)

// Can drop references
val lazyList2 = LazyList.from(1).take(1000000)
val first = lazyList2.head
// After processing, GC can collect unused elements

// Infinite sequences safe
def fibonacci: LazyList[BigInt] = {
  def loop(a: BigInt, b: BigInt): LazyList[BigInt] =
    a #:: loop(b, a + b)
  loop(0, 1)
}

fibonacci.take(10).toList  // Only computes 10 elements
```

**Performance Comparison**:

```scala
// Benchmark: sum first million integers

// Iterator: ~10ms, minimal memory
Iterator.range(1, 1000001).sum

// LazyList: ~50ms, moderate memory (memoization)
LazyList.range(1, 1000001).sum

// List: ~100ms, high memory (all in memory)
List.range(1, 1000001).sum

// Vector: ~80ms, moderate memory
Vector.range(1, 1000001).sum
```

**When to Use Each**:

**Iterator**:
```scala
// 1. Single-pass processing
Source.fromFile("data.csv").getLines().map(parseLine).foreach(process)

// 2. Chaining operations without storing intermediate results
(1 to 1000000)
  .iterator
  .filter(_ % 2 == 0)
  .map(_ * 2)
  .take(10)
  .toList

// 3. External iteration (database cursors, etc.)
```

**LazyList**:
```scala
// 1. Infinite sequences
def primes: LazyList[Int] = {
  def sieve(s: LazyList[Int]): LazyList[Int] =
    s.head #:: sieve(s.tail.filter(_ % s.head != 0))
  sieve(LazyList.from(2))
}

primes.take(100).toList

// 2. Memoization needed
val fibs = 0 #:: 1 #:: fibs.zip(fibs.tail).map(_ + _)
fibs(100)  // Computed once
fibs(50)   // Reused

// 3. Multiple traversals of large data
val data = LazyList.fill(10000)(expensiveComputation())
data.filter(condition1).size
data.filter(condition2).size  // Can reuse
```

**Memory Pitfall Example**:

```scala
// BAD - holds entire lazy list in memory
val lazyList = LazyList.from(1).take(1000000)
val sum = lazyList.sum
val max = lazyList.max  // Entire list still in memory!

// GOOD - don't keep reference
def processLazyList(): Int = {
  val lazyList = LazyList.from(1).take(1000000)
  val sum = lazyList.sum
  val max = lazyList.max
  sum + max
}  // GC can collect after function returns
```

**Why It Matters**:
- Memory leaks are common with lazy evaluation
- Understanding memoization vs laziness is crucial
- Shows knowledge of Scala 2.13 migration

**Common Interview Follow-up**:
"How would you process a 10GB file that doesn't fit in memory?"

**Answer**:
```scala
import scala.io.Source

// Use Iterator for constant memory
def processLargeFile(path: String): Unit = {
  val source = Source.fromFile(path)
  try {
    source.getLines()
      .grouped(1000)  // Process in batches
      .foreach { batch =>
        // Process batch
        batch.foreach(processLine)
      }
  } finally {
    source.close()
  }
}
```

**Difficulty**: ⭐⭐⭐⭐ (Senior)

**Sources**:
- [Understanding LazyList in Scala](https://reintech.io/blog/understanding-the-lazylist-in-scala)
- [Scala Collections Performance](https://www.scala-lang.org/blog/2018/02/09/collections-performance.html)

---

#### 38. View and Lazy Collections ⭐⭐⭐

**Question**: What are views in Scala collections? When should you use them? What are the performance implications?

**Answer**:

**Views create lazy wrappers around collections** that defer operations until a terminal operation forces evaluation.

**Eager (Default)**:
```scala
val numbers = (1 to 1000000).toList

// Creates intermediate collections at each step
val result = numbers
  .map(_ * 2)        // Creates new list of 1M elements
  .filter(_ > 100)   // Creates another list
  .take(10)          // Creates final list of 10 elements
// Total: 3 full traversals, ~2M temporary elements created
```

**Lazy (View)**:
```scala
val numbers = (1 to 1000000).toList

// No intermediate collections
val result = numbers
  .view                // Wrap in view
  .map(_ * 2)         // Lazy transformation
  .filter(_ > 100)    // Lazy transformation
  .take(10)           // Lazy transformation
  .toList             // Force evaluation - single traversal!
// Total: 1 traversal, stops at 10 elements
```

**Performance Benchmark**:

```scala
import scala.collection.View

// Eager version
def eagerCompute(): List[Int] =
  (1 to 1000000).toList
    .map(_ * 2)
    .filter(_ % 3 == 0)
    .take(100)
    .toList
// Time: ~300ms, Memory: high

// View version
def viewCompute(): List[Int] =
  (1 to 1000000).toList
    .view
    .map(_ * 2)
    .filter(_ % 3 == 0)
    .take(100)
    .toList
// Time: ~5ms, Memory: minimal (stops early!)
```

**When to Use Views**:

**✅ Good Use Cases**:

```scala
// 1. Long transformation chains
val processed = data
  .view
  .map(transform1)
  .map(transform2)
  .filter(predicate1)
  .filter(predicate2)
  .take(n)
  .toList

// 2. Take/drop on large collections
val first100 = hugeList.view.take(100).toList  // Avoids copying

// 3. Repeated transformations with different filters
val view = data.view.map(expensiveTransform)
val result1 = view.filter(pred1).toList
val result2 = view.filter(pred2).toList
// Caution: expensiveTransform called multiple times!

// 4. Chaining before forcing
def process(data: List[Int]): List[Int] = {
  val transformed = data.view
    .map(_ * 2)
    .filter(_ > 0)

  if (someCondition) transformed.take(10).toList
  else transformed.take(100).toList
}
```

**❌ Bad Use Cases**:

```scala
// 1. Small collections (overhead not worth it)
val small = List(1, 2, 3).view.map(_ * 2).toList  // Slower than eager!

// 2. Multiple traversals (recomputes each time)
val v = largeList.view.map(expensiveOp)
v.sum  // Computes expensiveOp for all elements
v.max  // Computes expensiveOp AGAIN for all elements!

// 3. Side effects (executed unpredictably)
var count = 0
val v = list.view.map { x =>
  count += 1  // When is this called? Unclear!
  x * 2
}

// 4. When you need strict evaluation
val v = list.view.map(parseJson)  // Errors not caught until forced!
```

**Scala 2 vs Scala 3 Views**:

```scala
// Scala 2
val view2 = list.view.map(_ * 2)  // Creates View type

// Scala 3 - Same API, better implementation
val view3 = list.view.map(_ * 2)  // More efficient
```

**Common Pitfalls**:

```scala
// Pitfall 1: Forgetting to force
val v = list.view.map(_ * 2)
println(v)  // Prints "View(<not computed>)" not the values!

// Pitfall 2: View escape
def getEvens(list: List[Int]) = list.view.filter(_ % 2 == 0)
val evens = getEvens(List(1,2,3,4))
evens.sum  // Works but inefficient - should .toList at function boundary

// Pitfall 3: Recomputation
val v = (1 to 1000000).view.map(expensive)
val a = v.sum
val b = v.max
// expensive() called 2 million times!

// Fix: Force once
val materialized = v.toList
val a = materialized.sum
val b = materialized.max
// expensive() called 1 million times
```

**Memory Implications**:

```scala
// Without view - allocates intermediate collections
val result = (1 to 1000000)
  .map(_ * 2)        // Allocates Range with 1M elements
  .filter(_ > 100)   // Allocates another collection
  .take(10)          // Allocates final collection
// Memory spike: ~32MB for intermediate collections

// With view - minimal allocation
val result = (1 to 1000000)
  .view
  .map(_ * 2)
  .filter(_ > 100)
  .take(10)
  .toList
// Memory spike: ~1KB (only final 10 elements)
```

**Best Practice Pattern**:

```scala
// Good: View for transformation, strict for terminal
def processData(data: List[BigData]): List[Result] =
  data
    .view                    // Lazy wrapper
    .map(transform)          // Lazy
    .filter(isValid)         // Lazy
    .flatMap(extract)        // Lazy
    .take(1000)              // Lazy (short-circuit)
    .toList                  // Force: single traversal

// Better with explicit types
def processData(data: List[BigData]): List[Result] = {
  val lazyPipeline: View[Result] = data
    .view
    .map(transform)
    .filter(isValid)
    .flatMap(extract)
    .take(1000)

  lazyPipeline.toList  // Explicit forcing
}
```

**Why It Matters**:
- Views are often overlooked optimization
- Shows understanding of lazy evaluation
- Common performance bottleneck in production

**Difficulty**: ⭐⭐⭐ (Mid-Senior)

**Sources**:
- [Scala Collections Views](https://docs.scala-lang.org/overviews/collections-2.13/views.html)
- [Collections Performance Guide](https://docs.scala-lang.org/overviews/collections-2.13/performance-characteristics.html)

---

### Language Features Deep Dive

#### 39. For-Comprehension Desugaring Edge Cases ⭐⭐⭐⭐⭐

**Question**: How do for-comprehensions desugar in Scala? What are some surprising edge cases? How does Scala 3 improve the desugaring?

**Answer**:

**Basic Desugaring Rules**:

```scala
// Rule 1: Single generator with yield
for (x <- expr1) yield expr2
// Becomes:
expr1.map(x => expr2)

// Rule 2: Multiple generators
for {
  x <- expr1
  y <- expr2
} yield expr3
// Becomes:
expr1.flatMap(x => expr2.map(y => expr3))

// Rule 3: Guard (filter)
for (x <- expr1 if guard) yield expr2
// Becomes:
expr1.withFilter(x => guard).map(x => expr2)

// Rule 4: Value definition (pure assignment)
for {
  x <- expr1
  y = expr2
} yield expr3
// Becomes:
expr1.map(x => (x, expr2)).map { case (x, y) => expr3 }
```

**Edge Case 1: Guards Create withFilter Calls**

```scala
// This innocent-looking code...
for {
  x <- List(1, 2, 3)
  if x > 1
  y <- List('a', 'b')
} yield (x, y)

// Desugars to:
List(1, 2, 3)
  .withFilter(x => x > 1)  // Not filter!
  .flatMap(x => List('a', 'b').map(y => (x, y)))

// Problem: Option doesn't have withFilter in old Scala!
for {
  x <- Some(5)
  if x > 3  // Compile error in Scala 2.12-
} yield x
// Error: value withFilter is not a member of Some[Int]
```

**Edge Case 2: Pattern Matching Silently Drops Non-Matches**

```scala
// Surprising behavior!
val data = List(1 -> "a", 2 -> "b", 3)

// This silently ignores element 3!
val result = for {
  (k, v) <- data
} yield s"$k: $v"
// Result: List("1: a", "2: b")  // Where did 3 go?!

// Desugars to:
data.map { case (k, v) => s"$k: $v" }  // Uses partial function!

// Compare with explicit map:
data.map { x =>
  val (k, v) = x  // MatchError on element 3!
  s"$k: $v"
}
```

**Edge Case 3: Value Bindings Create Tuples**

```scala
// Innocent-looking code
for {
  x <- List(1, 2, 3)
  y = x * 2        // Pure value binding
  z <- List(y, y + 1)
} yield z

// Horrific desugaring in Scala 2!
List(1, 2, 3)
  .map(x => (x, x * 2))                     // Create tuple
  .flatMap { case (x, y) =>                 // Destructure tuple
    List(y, y + 1).map(z => z)
  }

// Scala 3 improvement: no tuple!
List(1, 2, 3)
  .flatMap { x =>
    val y = x * 2
    List(y, y + 1).map(z => z)
  }
```

**Edge Case 4: Guards with Value Bindings**

```scala
for {
  x <- List(1, 2, 3, 4, 5)
  y = x * 2
  if y > 5
  z = y + 1
} yield z

// Scala 2 desugaring (complex!):
List(1, 2, 3, 4, 5)
  .map(x => (x, x * 2))
  .withFilter { case (x, y) => y > 5 }
  .map { case (x, y) => (x, y, y + 1) }
  .map { case (x, y, z) => z }

// Scala 3 desugaring (cleaner):
List(1, 2, 3, 4, 5)
  .flatMap { x =>
    val y = x * 2
    if (y > 5) {
      val z = y + 1
      Some(z)
    } else None
  }
```

**Edge Case 5: Empty Generator**

```scala
// What happens here?
for {
  x <- List(1, 2, 3)
  y <- List.empty[Int]  // Empty!
  z <- List(100, 200)
} yield (x, y, z)
// Result: List()  // Short-circuits on empty generator

// Desugars to:
List(1, 2, 3).flatMap { x =>
  List.empty[Int].flatMap { y =>  // flatMap on empty = empty
    List(100, 200).map { z =>
      (x, y, z)
    }
  }
}
```

**Edge Case 6: Type Inference with For-Comprehensions**

```scala
// Tricky type inference
for {
  x <- Some(1)
  y <- Some("hello")
} yield (x, y)
// Type: Option[(Int, String)]  ✅

// But this fails!
for {
  x <- Some(1)
  y <- None  // Type: None.type
} yield (x, y)
// Type: Option[(Int, Nothing)]  // Works but surprising

// This is even trickier
val opt: Option[Int] = None
for {
  x <- Some(1)
  y <- opt
} yield (x, y)
// Type: Option[(Int, Int)]  ✅ (inferred from opt's type)
```

**Edge Case 7: For-Comprehensions Without Yield**

```scala
// Without yield = foreach
for {
  x <- List(1, 2, 3)
  y <- List('a', 'b')
} println(s"$x$y")

// Desugars to:
List(1, 2, 3).foreach { x =>
  List('a', 'b').foreach { y =>
    println(s"$x$y")
  }
}
// Returns: Unit (not a collection!)
```

**Scala 3 Improvements (SIP-62)**:

```scala
// Better desugaring for pure assignments
for {
  x <- list
  y = transform(x)  // No tuple wrapping in Scala 3!
  z <- process(y)
} yield z

// Scala 2: Creates intermediate tuples
// Scala 3: Direct val binding (more efficient)
```

**Common Interview Question**: "Can you use for-comprehensions with any type?"

**Answer**:
```scala
// Type must have map, flatMap, withFilter (for guards), foreach (without yield)

// Example: Either works
for {
  x <- Right(1): Either[String, Int]
  y <- Right(2): Either[String, Int]
} yield x + y
// Result: Right(3)

for {
  x <- Right(1): Either[String, Int]
  y <- Left("error"): Either[String, Int]
} yield x + y
// Result: Left("error")  // Short-circuits

// Example: Custom type
class Container[A](value: A) {
  def map[B](f: A => B): Container[B] = new Container(f(value))
  def flatMap[B](f: A => Container[B]): Container[B] = f(value)
  def withFilter(p: A => Boolean): Container[A] =
    if (p(value)) this else new Container(value)  // Fake filter
}

for {
  x <- new Container(5)
  if x > 3
  y <- new Container(10)
} yield x + y
// Works! Calls map/flatMap/withFilter
```

**Why It Matters**:
- For-comprehensions are syntactic sugar - understanding desugaring is crucial
- Edge cases trip up even experienced developers
- Shows deep language understanding
- Common source of bugs (silent filtering, performance issues)

**Common Mistakes**:
- Not realizing withFilter vs filter difference
- Pattern matching in for causing silent data loss
- Creating unnecessary tuples with value bindings
- Expecting guards to throw errors (they filter instead)

**Difficulty**: ⭐⭐⭐⭐⭐ (Senior+)

**Sources**:
- [SIP-62 For Comprehension Improvements](https://docs.scala-lang.org/sips/better-fors.html)
- [Scala Desugaring Tutorial](https://riptutorial.com/scala/example/9792/desugaring-for-comprehensions)
- [Wix Engineering - Comprehending For-Comprehensions](https://medium.com/wix-engineering/scala-comprehending-the-for-comprehension-67c9f7953655)

---

#### 40. Call-by-Name vs Call-by-Value vs Lazy Val ⭐⭐⭐⭐

**Question**: Explain the differences between call-by-value, call-by-name, and lazy val. When would you use each? What are the performance implications?

**Answer**:

**Call-by-Value (Default)**:

Parameter evaluated **once** before function call.

```scala
def callByValue(x: Int): Int = {
  println("Computing result...")
  x + x
}

callByValue({ println("Evaluating arg"); 42 })
// Output:
// Evaluating arg    (evaluated once before call)
// Computing result...
// Result: 84
```

**Call-by-Name (=>)**:

Parameter evaluated **every time** it's accessed.

```scala
def callByName(x: => Int): Int = {
  println("Computing result...")
  x + x  // x evaluated TWICE
}

callByName({ println("Evaluating arg"); 42 })
// Output:
// Computing result...
// Evaluating arg    (first access)
// Evaluating arg    (second access)
// Result: 84
```

**Lazy Val**:

Evaluated **once** on first access, then cached.

```scala
lazy val x: Int = {
  println("Evaluating lazy val")
  expensive()
}

println("Before access")
println(x)  // Triggers evaluation
println(x)  // Uses cached value
// Output:
// Before access
// Evaluating lazy val
// 42
// 42
```

**Comparison Table**:

| Feature | Call-by-Value | Call-by-Name | Lazy Val |
|---------|--------------|--------------|----------|
| Evaluation timing | Before call | On each access | On first access |
| Evaluation count | 1 | N (number of usages) | 1 |
| Thread-safe | N/A | N/A | Yes (synchronized) |
| Overhead | None | Function call per access | Synchronization |
| Use case | Default | Conditional execution | Expensive initialization |

**When to Use Call-by-Name**:

```scala
// 1. Conditional execution (avoid unnecessary work)
def unless(condition: Boolean)(block: => Unit): Unit = {
  if (!condition) block
}

unless(systemHealthy) {
  sendAlert()  // Only executes if not healthy
}

// 2. Custom control structures
def whileLoop(condition: => Boolean)(body: => Unit): Unit = {
  if (condition) {
    body
    whileLoop(condition)(body)  // Recursive
  }
}

var i = 0
whileLoop(i < 5) {
  println(i)
  i += 1
}

// 3. Logging with guards
def debug(msg: => String): Unit = {
  if (debugEnabled) println(msg)  // msg only computed if debug enabled
}

debug(s"Complex: ${expensive()}")  // expensive() not called unless debug on

// 4. Short-circuit evaluation
def or(a: => Boolean, b: => Boolean): Boolean =
  if (a) true else b

or(true, { println("Not evaluated"); false })  // Doesn't print

// 5. Lazy assertions
def require(condition: => Boolean, msg: => String): Unit = {
  if (!condition) throw new IllegalArgumentException(msg)
}
```

**When to Use Lazy Val**:

```scala
// 1. Expensive initialization
class DatabaseConnection {
  lazy val connection: Connection = {
    println("Connecting to database...")
    createConnection()  // Expensive!
  }

  def query(sql: String) = connection.execute(sql)
}

val db = new DatabaseConnection()  // No connection yet
db.query("SELECT * FROM users")     // Connects here

// 2. Circular dependencies
class A {
  lazy val b: B = new B(this)
}
class B(a: A) {
  lazy val value: Int = a.b.value + 1  // Would stack overflow without lazy!
}

// 3. Breaking initialization order issues
class Config {
  val baseUrl = "https://api.com"
  lazy val fullUrl = s"$baseUrl/v1"  // Safe: baseUrl initialized first
}

// 4. Memoization pattern
class Fibonacci {
  lazy val fib: LazyList[BigInt] =
    BigInt(0) #:: BigInt(1) #:: fib.zip(fib.tail).map { case (a, b) => a + b }

  def apply(n: Int): BigInt = fib(n)
}

val f = new Fibonacci()
f(100)  // Computed once
f(100)  // Cached
```

**When to Use Call-by-Value** (Default):

```scala
// 1. Normal parameters (default choice)
def add(x: Int, y: Int): Int = x + y

// 2. When expression is needed multiple times
def square(x: Int): Int = x * x  // x used twice, CBV more efficient

// 3. Side effects should happen exactly once
def increment(x: Int): Int = {
  database.log(x)  // Should log once
  x + 1
}
```

**Performance Implications**:

```scala
def expensive(): Int = {
  Thread.sleep(1000)
  42
}

// Call-by-value: 1 second (evaluated once)
def testCBV(x: Int) = x + x
testCBV(expensive())  // 1 sec

// Call-by-name: 2 seconds (evaluated twice)
def testCBN(x: => Int) = x + x
testCBN(expensive())  // 2 sec!

// Call-by-name with single use: no overhead
def testCBNOnce(x: => Int) = x
testCBNOnce(expensive())  // 1 sec

// Lazy val: 1 second + synchronization overhead
def testLazy() = {
  lazy val x = expensive()
  x + x
}
testLazy()  // 1 sec + ~1μs for synchronization
```

**Common Pattern: Call-by-Name + Lazy Val**:

```scala
// Combine both for optimal performance
def withResource[A, B](resource: => A)(use: A => B): B = {
  lazy val r = resource  // Evaluated at most once
  try {
    use(r)
  } finally {
    if (r != null) r.close()
  }
}

withResource(new FileInputStream("data.txt")) { stream =>
  stream.read()  // resource opened once
  stream.read()  // reused
}
```

**Thread Safety Considerations**:

```scala
// Lazy val is thread-safe but has overhead
class Example {
  lazy val config: Config = loadConfig()  // Synchronized initialization
}

// Call-by-name is not thread-safe
class Example2 {
  def config: Config = loadConfig()  // Called on every access, no sync
}

// Double-checked locking pattern (manual optimization)
class Example3 {
  @volatile private var _config: Config = _
  def config: Config = {
    if (_config == null) {
      synchronized {
        if (_config == null) {
          _config = loadConfig()
        }
      }
    }
    _config
  }
}
```

**Common Pitfalls**:

```scala
// Pitfall 1: Unintended multiple evaluation
def repeat(n: Int, action: => Unit): Unit = {
  (1 to n).foreach(_ => action)  // action executed n times!
}

var count = 0
repeat(5, { count += 1; println(count) })
// Prints: 1, 2, 3, 4, 5 (count incremented 5 times)

// Fix with lazy val
def repeatFixed(n: Int, action: => Unit): Unit = {
  lazy val a = action  // Evaluated once
  (1 to n).foreach(_ => a)
}

// Pitfall 2: Lazy val initialization exception
lazy val problematic: Int = throw new Exception("Error!")
// Exception only thrown when accessed

try {
  val x = problematic  // Throws here
  val y = problematic  // Still throws! (not cached on exception)
} catch {
  case e: Exception => println("Caught")
}

// Pitfall 3: Null reference in lazy val
class Example {
  lazy val value: String = null
  def useValue() = value.length  // NullPointerException, but lazy val succeeded
}
```

**Why It Matters**:
- Fundamental to understanding Scala evaluation semantics
- Critical for performance optimization
- Used extensively in standard library (Future, LazyList, etc.)
- Shows understanding of tradeoffs

**Difficulty**: ⭐⭐⭐⭐ (Senior)

**Sources**:
- [Scala By-Name Parameters](https://docs.scala-lang.org/tour/by-name-parameters.html)
- [Call-by-Name Blog Post](https://tpolecat.github.io/2014/06/26/call-by-name.html)
- [Scala Parameter Evaluation Strategies](https://www.waitingforcode.com/scala-core/scala-parameters-evaluation-strategies/read)

---

### Scala 3 Specific

#### 41. Opaque Types - Zero-Cost Abstractions ⭐⭐⭐⭐

**Question**: What are opaque types in Scala 3? How do they differ from value classes and type aliases? What are the trade-offs?

**Answer**:

**Opaque types** provide type safety without runtime overhead by hiding implementation details at compile-time while erasing to the underlying type at runtime.

**Definition**:

```scala
// Scala 3
object Domain {
  opaque type UserId = Int
  opaque type Email = String

  object UserId {
    def apply(id: Int): UserId = id
    extension (id: UserId) def value: Int = id
  }

  object Email {
    def apply(email: String): Email = email
    extension (e: Email) def value: String = e
    extension (e: Email) def isValid: Boolean = e.contains("@")
  }
}

import Domain._

val userId = UserId(123)
val email = Email("user@example.com")

// Type-safe: won't compile
// val id: UserId = 456  // Error: Found Int, Required UserId
// val e: Email = userId  // Error: Found UserId, Required Email

// Access via extensions
userId.value  // 123
email.isValid  // true
```

**Comparison with Alternatives**:

| Feature | Type Alias | Value Class (AnyVal) | Opaque Type |
|---------|-----------|---------------------|-------------|
| Type safety | ❌ None | ✅ Strong | ✅ Strong |
| Runtime overhead | ❌ None | ⚠️  Sometimes | ✅ None (always) |
| Restrictions | None | Many | Few |
| Scope control | ❌ Global | ❌ Global | ✅ Local |
| Pattern matching | ✅ Yes | ❌ No | ⚠️  Limited |

**Type Alias (No Safety)**:

```scala
// Scala 2 & 3
type UserId = Int
type Email = String

val id: UserId = 123
val email: Email = "user@example.com"

// Problems: No type safety!
val id2: UserId = email  // ✅ Compiles (both are String!)
val swapped: Email = id  // ✅ Compiles (both are Int!)
```

**Value Class (Scala 2 approach)**:

```scala
// Scala 2
case class UserId(value: Int) extends AnyVal
case class Email(value: String) extends AnyVal

val id = UserId(123)
val email = Email("user@example.com")

// Type safe
// val id2: UserId = email  // ❌ Won't compile ✅

// But has limitations:
// 1. Must extend AnyVal
// 2. Only one public val parameter
// 3. Can't define inner classes/traits/objects
// 4. Boxing happens in some cases:
def processList(ids: List[UserId]): Unit = ???  // Boxing! List[Int] → List[UserId]
```

**When Value Classes Box** (Scala 2):

```scala
case class UserId(value: Int) extends AnyVal

// Boxing occurs in:
val list: List[UserId] = List(UserId(1), UserId(2))  // Boxed
val array: Array[UserId] = Array(UserId(1))          // Boxed
val id: UserId = if (condition) UserId(1) else UserId(2)  // May box

// Pattern matching causes boxing
UserId(42) match {
  case UserId(id) => println(id)  // Boxed!
}
```

**Opaque Types (Scala 3 - Best of Both)**:

```scala
object Money {
  opaque type USD = BigDecimal
  opaque type EUR = BigDecimal

  object USD {
    def apply(amount: BigDecimal): USD = amount
    extension (m: USD) {
      def +(other: USD): USD = m + other
      def value: BigDecimal = m
      def toEUR(rate: BigDecimal): EUR = m * rate
    }
  }

  object EUR {
    def apply(amount: BigDecimal): EUR = amount
    extension (m: EUR) {
      def value: BigDecimal = m
    }
  }
}

import Money._

val usd1 = USD(100)
val usd2 = USD(50)
val total = usd1 + usd2  // Type: USD

// Type-safe conversion
val eur: EUR = usd1.toEUR(0.85)

// Won't compile: different opaque types
// val mixed = usd1 + eur  // Error!

// ZERO boxing - all operations are BigDecimal at runtime!
val list: List[USD] = List(USD(1), USD(2))  // List[BigDecimal] at runtime
```

**Scope-Based Abstraction**:

```scala
object Database {
  opaque type ConnectionId = Long

  private var nextId: Long = 0

  // Within object: ConnectionId = Long
  def createConnection(): ConnectionId = {
    nextId += 1
    nextId  // Can return Long directly
  }

  def closeConnection(id: ConnectionId): Unit = {
    val underlying: Long = id  // Can access as Long inside scope
    println(s"Closing connection $underlying")
  }
}

import Database._

val conn1 = createConnection()  // Type: ConnectionId
val conn2 = createConnection()

// Outside object: ConnectionId is opaque
// val id: Long = conn1  // Error: Found ConnectionId, Required Long

closeConnection(conn1)  // OK
// closeConnection(123L)  // Error: Found Long, Required ConnectionId
```

**Pattern Matching Challenge**:

```scala
object Ids {
  opaque type UserId = Int
  opaque type OrderId = Int

  object UserId { def apply(id: Int): UserId = id }
  object OrderId { def apply(id: Int): OrderId = id }
}

import Ids._

val id: UserId | OrderId = if (condition) UserId(1) else OrderId(2)

// Problem: Both erase to Int, can't distinguish at runtime!
id match {
  case _: UserId => "user"    // Can't match on opaque type
  case _: OrderId => "order"  // Both are Int at runtime
}

// Solution: Use ADT instead when runtime distinction needed
sealed trait Id
case class UserId(value: Int) extends Id
case class OrderId(value: Int) extends Id
```

**Real-World Example: Type-Safe Units**:

```scala
object Units {
  opaque type Meters = Double
  opaque type Seconds = Double
  opaque type MetersPerSecond = Double

  object Meters {
    def apply(value: Double): Meters = value
    extension (m: Meters) {
      def +(other: Meters): Meters = m + other
      def -(other: Meters): Meters = m - other
      def /(other: Seconds): MetersPerSecond = m / other
      def value: Double = m
    }
  }

  object Seconds {
    def apply(value: Double): Seconds = value
    extension (s: Seconds) def value: Double = s
  }

  object MetersPerSecond {
    def apply(value: Double): MetersPerSecond = value
    extension (mps: MetersPerSecond) {
      def *(time: Seconds): Meters = mps * time
      def value: Double = mps
    }
  }
}

import Units._

val distance = Meters(100.0)
val time = Seconds(10.0)
val speed = distance / time  // Type: MetersPerSecond

// Type-safe: won't compile
// val wrong = distance + time  // Error: can't add Meters + Seconds
// val invalid: Meters = speed  // Error: incompatible types

// Zero runtime overhead - all are Double!
```

**Migration from Value Classes**:

```scala
// Scala 2
case class UserId(value: Int) extends AnyVal

// Scala 3 (opaque)
opaque type UserId = Int
object UserId {
  def apply(value: Int): UserId = value
  extension (id: UserId) def value: Int = id
}

// Benefits:
// - No boxing in collections
// - No restrictions on methods
// - Can define in objects (better organization)
```

**Why It Matters**:
- Scala 3's answer to newtype pattern
- Zero-cost abstraction (truly)
- Shows understanding of modern Scala
- Common in domain modeling

**Common Interview Follow-ups**:
- "How would you model Money types with opaque types?"
- "Can you pattern match on opaque types?"
- "What's the difference between opaque types and refinement types?"

**Difficulty**: ⭐⭐⭐⭐ (Senior, Scala 3 specific)

**Sources**:
- [Scala 3 Opaque Types Documentation](https://docs.scala-lang.org/scala3/reference/other-new-features/opaques.html)
- [DigitalDefynd Scala 3 Questions](https://digitaldefynd.com/IQ/top-scala-interview-questions-answers/)

---

#### 42. Union and Intersection Types ⭐⭐⭐⭐

**Question**: Explain union types and intersection types in Scala 3. How do they differ from sealed traits? What are the practical use cases?

**Answer**:

**Union Types (A | B)**:

Value is **one of** several types (OR).

```scala
// Scala 3
type StringOrInt = String | Int

def printValue(value: StringOrInt): Unit = value match {
  case s: String => println(s"String: $s")
  case i: Int => println(s"Int: $i")
}

printValue("hello")  // OK
printValue(42)       // OK
// printValue(true)  // Error: Boolean not in union
```

**Intersection Types (A & B)**:

Value is **both** types simultaneously (AND).

```scala
trait Loggable {
  def log(msg: String): Unit
}

trait Serializable {
  def serialize(): String
}

type LoggableAndSerializable = Loggable & Serializable

def process(obj: LoggableAndSerializable): Unit = {
  obj.log("Processing")    // Has Loggable methods
  val data = obj.serialize()  // Has Serializable methods
}

// Implementation must have both traits
class MyClass extends Loggable with Serializable {
  def log(msg: String): Unit = println(msg)
  def serialize(): String = "data"
}

process(new MyClass)  // OK
```

**Union vs Sealed Trait**:

| Aspect | Union Type | Sealed Trait |
|--------|-----------|--------------|
| Definition | `A \| B` | `sealed trait T; case class A; case class B` |
| Requires pre-planning | ❌ No | ✅ Yes |
| Runtime type | Erased | Preserved |
| Pattern matching | Needs type test | Exhaustiveness check |
| External types | ✅ Can use | ❌ Must extend trait |
| Performance | Zero overhead | Object allocation |

**Union Types - Practical Examples**:

```scala
// 1. Error handling without custom ADT
def divide(a: Int, b: Int): Int | String =
  if (b == 0) "Division by zero"
  else a / b

divide(10, 2) match {
  case i: Int => println(s"Result: $i")
  case err: String => println(s"Error: $err")
}

// 2. Multiple input types
def format(value: String | Int | Boolean): String = value match {
  case s: String => s""""$s""""
  case i: Int => i.toString
  case b: Boolean => if (b) "true" else "false"
}

// 3. JSON ADT without boilerplate
type Json = String | Int | Boolean | Double | Null |
            List[Json] | Map[String, Json]

val json: Json = Map(
  "name" -> "Alice",
  "age" -> 30,
  "active" -> true,
  "scores" -> List(95, 87, 92)
)

// 4. Flexible API returns
type UserId = Int
type Username = String

def findUser(query: String): UserId | Username | None.type = {
  if (query.matches("\\d+")) query.toInt
  else if (query.nonEmpty) query
  else None
}

// 5. Avoid Either wrapping
def parseConfig(file: String): Config | Error = {
  if (validate(file)) loadConfig(file)
  else Error("Invalid config")
}
```

**Intersection Types - Practical Examples**:

```scala
// 1. Multiple capabilities
trait Readable {
  def read(): Array[Byte]
}

trait Writable {
  def write(data: Array[Byte]): Unit
}

trait Seekable {
  def seek(position: Long): Unit
}

type RandomAccessFile = Readable & Writable & Seekable

def copy(from: Readable, to: Writable): Unit = {
  to.write(from.read())
}

// 2. Refined types
trait Positive
trait LessThan100

type Score = Int & Positive & LessThan100

// Note: This is more conceptual; refinement types like
// `refined` library do this properly

// 3. Structural types intersection
type Closeable = { def close(): Unit }
type Flushable = { def flush(): Unit }

type Resource = Closeable & Flushable

def cleanup(r: Resource): Unit = {
  r.flush()
  r.close()
}

// 4. Mixin composition
trait Logger {
  def log(msg: String): Unit = println(s"LOG: $msg")
}

trait Metrics {
  def recordMetric(name: String, value: Double): Unit =
    println(s"METRIC: $name = $value")
}

type Instrumented = Logger & Metrics

class Service extends Logger with Metrics {
  def process(): Unit = {
    log("Processing")
    recordMetric("processed", 1.0)
  }
}

def monitor(service: Instrumented): Unit = {
  service.log("Monitoring started")
  service.recordMetric("uptime", 99.9)
}
```

**Combining Unions and Intersections**:

```scala
// Complex type expressions
type StringOrInt = String | Int
type Comparable = { def compareTo(other: Any): Int }

type ComparableStringOrInt = (String | Int) & Comparable

// Distributive law: (A & B) | (A & C) = A & (B | C)
type Result[A, B, C] = (A & B) | (A & C)  // = A & (B | C)

// Practical: Error or Success with logging
trait Loggable {
  def log(): Unit
}

type Result = (String & Loggable) | (Int & Loggable)
```

**Type Inference Gotcha**:

```scala
// Union types require explicit annotation
def choose(flag: Boolean): String | Int =
  if (flag) "yes" else 42

val result = choose(true)
// Type: String | Int ✅

// Without annotation, infers common supertype
def chooseNoAnnotation(flag: Boolean) =
  if (flag) "yes" else 42

val result2 = chooseNoAnnotation(true)
// Type: Comparable & Serializable (common supertype!) ❌

// Solution: Explicit return type
def chooseCorrected(flag: Boolean): String | Int =
  if (flag) "yes" else 42
```

**Pattern Matching Exhaustiveness**:

```scala
// Union types don't have exhaustiveness checking
type UserInput = String | Int | Boolean

def process(input: UserInput): Unit = input match {
  case s: String => println(s)
  case i: Int => println(i)
  // Missing Boolean case - NO compiler warning!
}

// Sealed trait DOES have exhaustiveness
sealed trait Input
case class StringInput(s: String) extends Input
case class IntInput(i: Int) extends Input
case class BoolInput(b: Boolean) extends Input

def processSafe(input: Input): Unit = input match {
  case StringInput(s) => println(s)
  case IntInput(i) => println(i)
  // Missing BoolInput - compiler warning! ✅
}
```

**Interop with Java**:

```scala
// Union types erase to common supertype in bytecode
def javaMethod(value: String | Int): Any = value

// From Java perspective:
// public Object javaMethod(Object value)

// This limits interop - prefer sealed traits for Java APIs
```

**When to Use Union Types**:

✅ Good:
- Modeling lightweight alternatives without boilerplate
- Return types with multiple success cases
- When you don't control the types (external libraries)
- Quick prototyping

❌ Avoid:
- When exhaustiveness checking needed
- Public Java-facing APIs
- When runtime type distinction critical
- Domain modeling (use ADTs instead)

**When to Use Intersection Types**:

✅ Good:
- Combining multiple interfaces/traits
- Type constraints (requiring multiple capabilities)
- Structural types composition
- Generic bounds with multiple constraints

❌ Avoid:
- When single trait inheritance suffices
- Performance-critical code (structural types have overhead)

**Why It Matters**:
- Scala 3's most distinctive type system feature
- Reduces boilerplate for ad-hoc type combinations
- Shows understanding of modern type systems
- Common in Scala 3 codebases

**Difficulty**: ⭐⭐⭐⭐ (Senior, Scala 3 specific)

**Sources**:
- [Scala 3 Union Types](https://docs.scala-lang.org/scala3/book/types-union.html)
- [Scala 3 Intersection Types](https://docs.scala-lang.org/scala3/book/types-intersection.html)
- [Union Types Edge Cases](https://github.com/scala/scala3/discussions/16449)

---

### Advanced Pattern Matching

#### 43. Sealed Trait Exhaustiveness and Guards ⭐⭐⭐⭐

**Question**: How does the compiler check exhaustiveness in pattern matching? What happens when you add guards? What are the edge cases?

**Answer**:

**Exhaustiveness Checking Basics**:

```scala
sealed trait Result
case class Success(value: Int) extends Result
case class Failure(error: String) extends Result

// Exhaustive - compiler knows all cases
def handle(r: Result): String = r match {
  case Success(v) => s"Got $v"
  case Failure(e) => s"Error: $e"
}  // ✅ No warning

// Non-exhaustive - compiler warns
def handleBad(r: Result): String = r match {
  case Success(v) => s"Got $v"
  // Missing Failure case!
}  // ⚠️  Warning: match may not be exhaustive

// Compiler suggests: It would fail on: Failure(_)
```

**Edge Case 1: Guards Break Exhaustiveness**:

```scala
sealed trait Status
case object Active extends Status
case object Inactive extends Status

// This is NOT exhaustive, even though it looks like it!
def check(s: Status): String = s match {
  case Active if condition => "active"
  case Inactive => "inactive"
}
// ⚠️  Warning: match may not be exhaustive
// Why? Guard can fail, so Active case might not match

// Scala 3 fix: smarter analysis
def checkScala3(s: Status): String = s match {
  case Active if condition => "active"
  case Active => "active anyway"
  case Inactive => "inactive"
}  // ✅ Exhaustive in Scala 3
```

**Edge Case 2: Nested Pattern Matching**:

```scala
sealed trait Outer
case class Container(inner: Inner) extends Outer

sealed trait Inner
case class A(x: Int) extends Inner
case class B(y: String) extends Inner

// Exhaustiveness doesn't check nested patterns!
def process(o: Outer): String = o match {
  case Container(A(x)) => s"A: $x"
  // Missing Container(B(_))!
}
// ⚠️  Warning: match may not be exhaustive
// Suggests: It would fail on: Container(B(_))
```

**Edge Case 3: Type Erasure Breaks Matching**:

```scala
sealed trait Box[+A]
case class IntBox(value: Int) extends Box[Int]
case class StringBox(value: String) extends Box[String]

// Can't match on type parameters due to erasure!
def unwrap[A](box: Box[A]): A = box match {
  case IntBox(v) => v     // Error: type mismatch
  case StringBox(v) => v  // Error: type mismatch
}

// Workaround: Use pattern matching without type param
def unwrapAny(box: Box[Any]): Any = box match {
  case IntBox(v) => v
  case StringBox(v) => v
}
```

**Edge Case 4: Partial Functions**:

```scala
val data = List(1 -> "a", 2 -> "b", 3)  // Last element is Int, not tuple

// Partial function - silently ignores non-matching!
val result = data.collect {
  case (k, v) => s"$k: $v"
}
// Result: List("1: a", "2: b")  // Element 3 silently dropped!

// Compare with map (throws MatchError):
val result2 = data.map {
  case (k, v) => s"$k: $v"  // MatchError on element 3!
}
```

**Edge Case 5: Catching Too Much**:

```scala
sealed trait Animal
case class Dog(name: String) extends Animal
case class Cat(name: String) extends Animal

// Bad: Wildcard hides future additions
def speak(a: Animal): String = a match {
  case Dog(name) => s"$name barks"
  case _ => "meows"  // Catches Cat, but also future animals!
}

// Good: Explicit cases
def speakGood(a: Animal): String = a match {
  case Dog(name) => s"$name barks"
  case Cat(name) => s"$name meows"
}  // Warning if you add new animal

// Adding new case:
case class Bird(name: String) extends Animal

// speakGood now warns about missing Bird case!
// speak silently treats Bird as Cat
```

**Edge Case 6: Option Matching**:

```scala
// These are NOT exhaustive!
def bad1(opt: Option[Int]): Int = opt match {
  case Some(x) => x
  // Missing None!
}

def bad2(opt: Option[Int]): Int = opt match {
  case Some(x) if x > 0 => x
  case None => 0
  // What if Some(x) where x <= 0?
}

// Exhaustive
def good(opt: Option[Int]): Int = opt match {
  case Some(x) if x > 0 => x
  case Some(x) => -x
  case None => 0
}
```

**Edge Case 7: @unchecked Annotation**:

```scala
sealed trait Status
case object Active extends Status
case object Inactive extends Status

// Suppress warning (dangerous!)
def risky(s: Status): String = (s: @unchecked) match {
  case Active => "active"
  // No warning about missing Inactive!
}

risky(Inactive)  // MatchError at runtime!
```

**Scala 3 Improvements**:

```scala
// Scala 3: Better analysis with guards
sealed trait Status
case object On extends Status
case object Off extends Status

// Scala 2: Non-exhaustive warning
// Scala 3: Exhaustive (smarter analysis)
def check(s: Status, flag: Boolean): String = s match {
  case On if flag => "on with flag"
  case On => "on"
  case Off => "off"
}  // ✅ Exhaustive in Scala 3
```

**Best Practices**:

```scala
// 1. Avoid wildcards for sealed traits
def process(r: Result): String = r match {
  case Success(v) => s"Success: $v"
  case Failure(e) => s"Failure: $e"
  // NOT: case _ => "unknown"  // Bad!
}

// 2. Use separate method for guards
def check(s: Status): String = s match {
  case Active => processActive()
  case Inactive => processInactive()
}

def processActive(): String =
  if (condition) "active-good" else "active-bad"

// 3. Make guards total
def safeguard(s: Status, flag: Boolean): String = s match {
  case Active if flag => "active-flag"
  case Active => "active"  // Fallback for Active
  case Inactive => "inactive"
}

// 4. Test exhaustiveness with -Wconf
// scalacOptions += "-Wconf:cat=other-match-analysis:error"
```

**Why It Matters**:
- Exhaustiveness checking is a key type safety feature
- Guards are commonly misunderstood
- Real bugs slip through non-exhaustive matches
- Shows deep understanding of pattern matching semantics

**Common Interview Follow-up**:
"What's the difference between a partial function and a non-exhaustive match?"

**Answer**:
- **Partial function**: Type `PartialFunction[A, B]`, has `isDefinedAt` method, used intentionally for subset of inputs
- **Non-exhaustive match**: Unintentional gap in pattern matching, compiler warns, throws `MatchError` at runtime

**Difficulty**: ⭐⭐⭐⭐ (Senior)

**Sources**:
- [Scala Pattern Matching](https://docs.scala-lang.org/tour/pattern-matching.html)
- [Sealed Traits and Exhaustiveness](https://app.studyraid.com/en/read/6584/150507/sealed-traits-and-exhaustiveness-checking)
- [Match Exhaustiveness Bug](https://github.com/scala/bug/issues/5365)

---

### Tricky Gotchas

#### 44. Type Erasure and TypeTag ⭐⭐⭐⭐⭐

**Question**: What is type erasure on the JVM? How does it affect Scala? How do you work around it using TypeTag and ClassTag?

**Answer**:

**Type Erasure Problem**:

The JVM erases generic type parameters at runtime for backward compatibility with pre-generics Java.

```scala
// These have THE SAME runtime type!
val intList: List[Int] = List(1, 2, 3)
val stringList: List[String] = List("a", "b", "c")

// Both erase to List[Object] at runtime
intList.getClass == stringList.getClass  // true!

// Pattern matching fails
def process(value: Any): String = value match {
  case list: List[Int] => "List of Ints"      // Warning: unchecked
  case list: List[String] => "List of Strings"  // Never matches!
}

process(List(1, 2, 3))     // "List of Ints"
process(List("a", "b"))    // "List of Ints" (!!!)  // Wrong!
```

**Why Erasure Exists**:

```java
// Pre-Java 5 (no generics)
List list = new ArrayList();
list.add("hello");
list.add(42);

// Java 5+ (with generics)
List<String> list = new ArrayList<String>();
list.add("hello");

// Bytecode must be compatible! Solution: Erase types at runtime
// List<String> becomes List<Object>
```

**Scala Implications**:

```scala
// Problem 1: Can't distinguish generic types
class Box[A] {
  def combine(other: Box[A]): Box[A] = ???
}

val intBox: Box[Int] = ???
val stringBox: Box[String] = ???

// Runtime: Both are just Box
intBox.getClass == stringBox.getClass  // true

// Problem 2: Can't create instances
def create[A]: A = new A  // Error: can't create instance of A

// Problem 3: Can't create arrays
def makeArray[A](size: Int): Array[A] =
  new Array[A](size)  // Error: need ClassTag[A]
```

**Solution 1: ClassTag (for Arrays)**:

```scala
import scala.reflect.ClassTag

// ClassTag captures runtime class info
def makeArray[A: ClassTag](size: Int): Array[A] =
  new Array[A](size)  // Works!

makeArray[Int](5)     // Array[Int]
makeArray[String](5)  // Array[String]

// How it works:
def makeArrayExplicit[A](size: Int)(implicit ct: ClassTag[A]): Array[A] =
  new Array[A](size)

// Compiler generates:
makeArrayExplicit[Int](5)(ClassTag.Int)
makeArrayExplicit[String](5)(classTag[String])
```

**Solution 2: TypeTag (Full Type Information)**:

```scala
import scala.reflect.runtime.universe._

// TypeTag preserves complete type information
def typeInfo[A: TypeTag](value: A): String = {
  val tpe = typeOf[A]
  s"Type: $tpe"
}

typeInfo(List(1, 2, 3))
// "Type: List[Int]"  // Preserves Int!

typeInfo(List("a", "b"))
// "Type: List[String]"  // Preserves String!

typeInfo(Map("key" -> 42))
// "Type: Map[String, Int]"  // Full type preserved!

// Pattern matching with TypeTag
def processWithType[A: TypeTag](value: A): String = typeOf[A] match {
  case t if t =:= typeOf[List[Int]] => "List of Ints"
  case t if t =:= typeOf[List[String]] => "List of Strings"
  case t if t <:< typeOf[List[_]] => "Some other List"
  case _ => "Not a list"
}

processWithType(List(1, 2, 3))     // "List of Ints" ✅
processWithType(List("a", "b"))    // "List of Strings" ✅
```

**ClassTag vs TypeTag**:

| Feature | ClassTag | TypeTag |
|---------|----------|---------|
| Information | Runtime class | Full type (including generics) |
| Overhead | Low | Higher (uses reflection) |
| Use case | Arrays, simple checks | Complex type checks |
| Example | `Int`, `String`, `List` | `List[Int]`, `Map[String, Int]` |

**Real-World Example 1: Generic JSON Serialization**:

```scala
import scala.reflect.runtime.universe._

trait JsonEncoder[A] {
  def encode(value: A): String
}

object JsonEncoder {
  def apply[A: JsonEncoder]: JsonEncoder[A] = implicitly

  // Use TypeTag to inspect structure
  def auto[A: TypeTag]: JsonEncoder[A] = new JsonEncoder[A] {
    def encode(value: A): String = {
      typeOf[A] match {
        case t if t =:= typeOf[Int] =>
          value.toString
        case t if t =:= typeOf[String] =>
          s""""${value.toString}""""
        case t if t <:< typeOf[Option[_]] =>
          value match {
            case Some(v) => auto(typeTagFromType(t)).encode(v)
            case None => "null"
          }
        case t if t <:< typeOf[List[_]] =>
          val elemType = t.typeArgs.head
          value.asInstanceOf[List[Any]]
            .map(auto(typeTagFromType(elemType)).encode)
            .mkString("[", ",", "]")
        case _ =>
          throw new Exception(s"Cannot encode type $t")
      }
    }
  }
}

// Usage
JsonEncoder.auto[List[Int]].encode(List(1, 2, 3))
// "[1,2,3]"

JsonEncoder.auto[Option[String]].encode(Some("hello"))
// "\"hello\""
```

**Real-World Example 2: Type-Safe Configuration**:

```scala
import scala.reflect.runtime.universe._

class Config {
  private val data = scala.collection.mutable.Map[String, Any]()

  def set[A](key: String, value: A): Unit =
    data(key) = value

  def get[A: TypeTag](key: String): Option[A] = {
    data.get(key).flatMap { value =>
      val expectedType = typeOf[A]
      val actualType = typeTag[value.type].tpe

      if (actualType <:< expectedType)
        Some(value.asInstanceOf[A])
      else
        None  // Type mismatch
    }
  }
}

val config = new Config()
config.set("port", 8080)
config.set("host", "localhost")

config.get[Int]("port")         // Some(8080) ✅
config.get[String]("port")      // None (type mismatch) ✅
config.get[String]("host")      // Some("localhost") ✅
```

**Workarounds Without TypeTag**:

```scala
// 1. Phantom types
sealed trait IntList
sealed trait StringList

class TypedList[A, Tag] private (val underlying: List[A])

object TypedList {
  def ints(list: List[Int]): TypedList[Int, IntList] =
    new TypedList(list)

  def strings(list: List[String]): TypedList[String, StringList] =
    new TypedList(list)
}

// 2. Type witness pattern
sealed trait Contains[L, A]
object Contains {
  implicit def contains[A]: Contains[List[A], A] =
    new Contains[List[A], A] {}
}

def getFirst[L, A](list: L)(implicit ev: Contains[L, A]): Option[A] =
  list.asInstanceOf[List[A]].headOption

// 3. Specialized (avoids boxing primitives)
class NumericArray[@specialized(Int, Double, Long) A: ClassTag](size: Int) {
  private val data = new Array[A](size)
  // Generated specialized versions for Int, Double, Long
}
```

**Performance Implications**:

```scala
// TypeTag uses reflection - has overhead
def slowTypeCheck[A: TypeTag](value: A): Boolean =
  typeOf[A] =:= typeOf[Int]  // Reflection call

// ClassTag is faster - runtime class check
def fastTypeCheck[A: ClassTag](value: A): Boolean =
  implicitly[ClassTag[A]] == ClassTag.Int  // Simple equality

// Benchmark:
// slowTypeCheck: ~1000ns per call
// fastTypeCheck: ~10ns per call
```

**Common Pitfalls**:

```scala
// Pitfall 1: Forgetting implicit
def create[A]: Array[A] = new Array[A](10)  // Error!
def create[A: ClassTag]: Array[A] = new Array[A](10)  // OK

// Pitfall 2: Type erasure in overloads
class Example {
  def process(list: List[Int]): String = "ints"
  def process(list: List[String]): String = "strings"
  // Error: Double definition (same erasure!)
}

// Fix: Use different method names or implicit params
class Fixed {
  def processInts(list: List[Int]): String = "ints"
  def processStrings(list: List[String]): String = "strings"
}

// Or use type class:
trait Processor[A] {
  def process(list: List[A]): String
}

def process[A: Processor](list: List[A]): String =
  implicitly[Processor[A]].process(list)

// Pitfall 3: Capturing TypeTag in closure
def makeChecker[A: TypeTag](): Any => Boolean = {
  val tpe = typeOf[A]
  (value: Any) => {
    // This captures TypeTag - might cause memory leak
    typeTag[value.type].tpe =:= tpe
  }
}
```

**Scala 3 Improvements**:

```scala
import scala.quoted.*

// Scala 3: Inline methods with compile-time type info
inline def typeString[A]: String = ${ typeStringImpl[A] }

def typeStringImpl[A: Type](using Quotes): Expr[String] = {
  import quotes.reflect.*
  Expr(Type.show[A])
}

// Usage:
typeString[List[Int]]  // "List[Int]" (compile-time!)
```

**Why It Matters**:
- Type erasure is fundamental JVM limitation
- Understanding it shows deep knowledge
- Critical for library authors
- Common source of confusing errors

**Common Interview Follow-ups**:
- "Why does the JVM have type erasure?"
- "How does this differ from .NET generics?"
- "What's the performance cost of TypeTag?"

**Difficulty**: ⭐⭐⭐⭐⭐ (Senior+, advanced)

**Sources**:
- [How to Overcome Type Erasure in Scala](https://www.geeksforgeeks.org/scala/how-to-overcome-type-erasure-in-scala/)
- [Scala Reflection and TypeTags](https://docs.scala-lang.org/overviews/reflection/typetags-manifests.html)

---

#### 45. Variance Positions and Compilation Errors ⭐⭐⭐⭐⭐

**Question**: Explain what "covariant type parameter appears in contravariant position" means. How does the compiler determine valid variance positions?

**Answer**:

**Variance Position Rules**:

The Scala compiler enforces that type parameters appear only in positions consistent with their variance annotation.

**Covariant (+A) Restrictions**:
- ✅ **Can appear in**: Return types, val/lazy val types, covariant positions
- ❌ **Cannot appear in**: Method parameters, var types, contravariant positions

**Contravariant (-A) Restrictions**:
- ✅ **Can appear in**: Method parameters, contravariant positions
- ❌ **Cannot appear in**: Return types, val types, covariant positions

**Example of the Error**:

```scala
// WRONG - won't compile
class Container[+A](var value: A)  // Error!
// "covariant type A occurs in contravariant position in type A of value value_="

// Why? If this compiled:
class Animal
class Cat extends Animal
class Dog extends Animal

val catContainer: Container[Cat] = new Container[Cat](Cat())
val animalContainer: Container[Animal] = catContainer  // OK if covariant

// Now we could do this:
animalContainer.value = Dog()  // Store Dog in Container[Animal]

// But catContainer.value is now a Dog! Type unsafety!
val cat: Cat = catContainer.value  // Runtime error!
```

**Understanding Positions**:

```scala
class Example[+A, -B, C] {
  // Covariant position (+):
  def getA: A = ???                    // ✅ Return type
  val a: A = ???                       // ✅ val type
  def list: List[A] = ???              // ✅ Covariant type arg

  // Contravariant position (-):
  def setB(b: B): Unit = ???           // ✅ Method parameter
  def func: B => Unit = ???            // ✅ Function input

  // Invariant position (both):
  def convert(c: C): C = ???           // ✅ Both positions

  // ERRORS:
  // def badA(a: A): Unit = ???        // ❌ Covariant in contravariant position
  // def badB: B = ???                 // ❌ Contravariant in covariant position
  // var mutableA: A = ???             // ❌ Covariant in both positions
}
```

**Position Flipping**:

```scala
// Functions flip variance
trait Function1[-T, +R] {
  def apply(x: T): R
  //        ^ contravariant (input)
  //                  ^ covariant (output)
}

// Why this works:
class Animal
class Dog extends Animal

val animalToString: Animal => String = ???
val dogToString: Dog => String = animalToString  // ✅ OK!

// animalToString can handle any Animal, so it can handle Dog
// This is contravariance in action
```

**Real-World Example: Modeling a Data Store**:

```scala
// WRONG - mutable store can't be covariant
class DataStore[+A] {
  private var data: A = _                    // ❌ Error!
  def get: A = data                           // ✅ OK
  def set(value: A): Unit = { data = value }  // ❌ Error!
}

// FIX 1: Make invariant
class DataStore[A] {
  private var data: A = _
  def get: A = data
  def set(value: A): Unit = { data = value }
}

// FIX 2: Make immutable (covariant)
class ImmutableStore[+A](private val data: A) {
  def get: A = data
  // No setter - safe to be covariant
}

// FIX 3: Use lower bound for setter
class FlexibleStore[+A](private var data: A) {
  def get: A = data
  def set[B >: A](value: B): Unit = {
    data = value.asInstanceOf[A]  // Unsafe but legal
  }
}
```

**Lower Bounds Workaround**:

```scala
// Problem: Can't add to covariant container
class Container[+A] {
  // def append(elem: A): Container[A] = ???  // ❌ Error!
}

// Solution: Lower bound
class Container[+A] {
  def append[B >: A](elem: B): Container[B] = ???  // ✅ OK!
  //        ^ B is supertype of A
}

// Usage:
val catContainer: Container[Cat] = ???
val animalContainer: Container[Animal] =
  catContainer.append(Dog())  // Returns Container[Animal]

// Makes sense: appending Dog to Container[Cat] widens to Container[Animal]
```

**Complex Example: Collection Builders**:

```scala
sealed trait List[+A] {
  // Pattern: use lower bound for "widening" operations
  def prepend[B >: A](elem: B): List[B] =
    Cons(elem, this)

  def append[B >: A](elem: B): List[B] = this match {
    case Nil => Cons(elem, Nil)
    case Cons(h, t) => Cons(h, t.append(elem))
  }

  def map[B](f: A => B): List[B] = this match {
    case Nil => Nil
    case Cons(h, t) => Cons(f(h), t.map(f))
  }

  // This would be WRONG:
  // def badPrepend(elem: A): List[A] = ???  // Error!
}

case class Cons[+A](head: A, tail: List[A]) extends List[A]
case object Nil extends List[Nothing]
```

**Why Nothing is Special**:

```scala
// Nothing is bottom type (subtype of everything)
val emptyList: List[Nothing] = Nil

// Can assign to any List type
val intList: List[Int] = emptyList      // OK
val stringList: List[String] = emptyList  // OK

// Because List is covariant:
// List[Nothing] <: List[Int] (Nothing <: Int)
// List[Nothing] <: List[String] (Nothing <: String)
```

**Debugging Variance Errors**:

```scala
// Compiler error message:
// "covariant type A occurs in contravariant position"

// Steps to fix:
// 1. Identify the position (method param, return type, var)
// 2. Consider if variance is necessary
//    - If mutable: make invariant
//    - If immutable: might be able to keep covariant
// 3. Use lower/upper bounds if needed
// 4. Consider splitting into multiple traits

// Example fix progression:
// Attempt 1: Covariant (fails)
trait Writer[+A] {
  def write(a: A): Unit  // ❌ Error
}

// Attempt 2: Invariant (safe but less flexible)
trait Writer[A] {
  def write(a: A): Unit  // ✅ OK
}

// Attempt 3: Contravariant (correct!)
trait Writer[-A] {
  def write(a: A): Unit  // ✅ OK
}

// Why contravariant? Writer consumes A
val animalWriter: Writer[Animal] = ???
val dogWriter: Writer[Dog] = animalWriter  // OK!
// animalWriter can write any Animal, so it can write Dogs
```

**Advanced: Variance in Higher-Kinded Types**:

```scala
// Variance annotations compose
trait Functor[F[+_]] {
  def map[A, B](fa: F[A])(f: A => B): F[B]
}

// F must be covariant in its type parameter
trait ContraFunctor[F[-_]] {
  def contramap[A, B](fa: F[A])(f: B => A): F[B]
}

// Example: Option is covariant
implicit val optionFunctor: Functor[Option] = new Functor[Option] {
  def map[A, B](fa: Option[A])(f: A => B): Option[B] =
    fa.map(f)
}

// Example: Function1[_, R] is contravariant in first param
trait Printer[-A] {
  def print(a: A): String
}

implicit def function1ContraFunctor[R]: ContraFunctor[Printer] =
  new ContraFunctor[Printer] {
    def contramap[A, B](fa: Printer[A])(f: B => A): Printer[B] =
      new Printer[B] {
        def print(b: B): String = fa.print(f(b))
      }
  }
```

**Why It Matters**:
- Variance errors are extremely common for beginners
- Understanding positions shows deep type system knowledge
- Critical for library design (collections, effects)
- Interview favorite for advanced candidates

**Common Interview Follow-ups**:
- "Why can't mutable collections be covariant?"
- "How does Scala's variance compare to Java's wildcards?"
- "What's the purpose of lower bounds?"

**Difficulty**: ⭐⭐⭐⭐⭐ (Senior+)

**Sources**:
- [Scala Variances Documentation](https://docs.scala-lang.org/tour/variances.html)
- [Demystifying Variance Positions](https://rockthejvm.com/articles/demystifying-variance-positions-in-scala)
- [Baeldung Variances Tutorial](https://www.baeldung.com/scala/variances)

---

#### 46. Partial Functions - isDefinedAt and Composition ⭐⭐⭐

**Question**: What are partial functions in Scala? How do they differ from total functions? Explain `isDefinedAt`, `orElse`, `lift`, and `andThen`.

**Answer**:

**Total Function** - defined for all inputs:

```scala
val totalFunc: Int => String = {
  case 0 => "zero"
  case 1 => "one"
  case n => s"number $n"  // Handles all other cases
}

totalFunc(0)    // "zero"
totalFunc(42)   // "number 42"
totalFunc(-5)   // "number -5"
```

**Partial Function** - defined for only some inputs:

```scala
val partialFunc: PartialFunction[Int, String] = {
  case 0 => "zero"
  case 1 => "one"
  // No fallback for other values
}

partialFunc(0)  // "zero"
partialFunc(1)  // "one"
partialFunc(42) // MatchError! (not defined for 42)

// Check if defined
partialFunc.isDefinedAt(0)  // true
partialFunc.isDefinedAt(42) // false
```

**Type Signature**:

```scala
trait PartialFunction[-A, +B] extends (A => B) {
  def apply(x: A): B
  def isDefinedAt(x: A): Boolean

  // Composition methods
  def orElse[A1 <: A, B1 >: B](that: PartialFunction[A1, B1]): PartialFunction[A1, B1]
  def andThen[C](k: B => C): PartialFunction[A, C]
  def lift: A => Option[B]
}
```

**isDefinedAt - Runtime Check**:

```scala
val divide: PartialFunction[(Int, Int), Int] = {
  case (n, d) if d != 0 => n / d
}

divide.isDefinedAt((10, 2))  // true
divide.isDefinedAt((10, 0))  // false

// Safe usage:
def safeDivide(n: Int, d: Int): Option[Int] =
  if (divide.isDefinedAt((n, d))) Some(divide((n, d)))
  else None

safeDivide(10, 2)  // Some(5)
safeDivide(10, 0)  // None
```

**orElse - Chaining with Fallback**:

```scala
val handleZero: PartialFunction[Int, String] = {
  case 0 => "zero"
}

val handleOne: PartialFunction[Int, String] = {
  case 1 => "one"
}

val handleNegative: PartialFunction[Int, String] = {
  case n if n < 0 => "negative"
}

// Combine with orElse
val combined = handleZero orElse handleOne orElse handleNegative

combined(0)   // "zero" (first match)
combined(1)   // "one" (second match)
combined(-5)  // "negative" (third match)
combined(42)  // MatchError (no match)
```

**lift - Convert to Total Function (Option)**:

```scala
val partial: PartialFunction[Int, String] = {
  case 0 => "zero"
  case 1 => "one"
}

val total: Int => Option[String] = partial.lift

total(0)   // Some("zero")
total(1)   // Some("one")
total(42)  // None (no MatchError!)
```

**andThen - Composition**:

```scala
val numberName: PartialFunction[Int, String] = {
  case 0 => "zero"
  case 1 => "one"
  case 2 => "two"
}

val toUpperCase: String => String = _.toUpperCase

val combined = numberName andThen toUpperCase

combined(0)  // "ZERO"
combined(1)  // "ONE"
combined(2)  // "TWO"
combined(3)  // MatchError
```

**Real-World Use Cases**:

**1. Collection Methods**:

```scala
val data = List("1", "2", "foo", "3", "bar")

// collect - uses partial function
val numbers: List[Int] = data.collect {
  case s if s.matches("\\d+") => s.toInt
}
// List(1, 2, 3) - "foo" and "bar" filtered out

// Equivalent to:
data.filter(s => s.matches("\\d+")).map(_.toInt)
```

**2. Actor Pattern Matching (Akka)**:

```scala
import akka.actor.Actor

class MyActor extends Actor {
  // receive is a PartialFunction[Any, Unit]
  def receive: Receive = {
    case "hello" => sender() ! "hi"
    case "bye" => context.stop(self)
    // Unhandled messages go to deadLetters
  }

  // Can combine behaviors
  def commonBehavior: Receive = {
    case "ping" => sender() ! "pong"
  }

  def specificBehavior: Receive = {
    case "specific" => println("handling specific")
  }

  override def receive = commonBehavior orElse specificBehavior
}
```

**3. Error Handling**:

```scala
val handleError: PartialFunction[Throwable, String] = {
  case _: NullPointerException => "Null value"
  case _: IllegalArgumentException => "Invalid argument"
}

def safeOperation(): String = {
  try {
    riskyCode()
  } catch handleError
}

// Equivalent to:
def safeOperation2(): String = {
  try {
    riskyCode()
  } catch {
    case _: NullPointerException => "Null value"
    case _: IllegalArgumentException => "Invalid argument"
  }
}
```

**4. State Machines**:

```scala
sealed trait State
case object Idle extends State
case object Running extends State
case object Stopped extends State

sealed trait Event
case object Start extends Event
case object Stop extends Event
case object Pause extends Event

type Transition = PartialFunction[(State, Event), State]

val transitions: Transition = {
  case (Idle, Start) => Running
  case (Running, Stop) => Stopped
  case (Running, Pause) => Idle
  case (Idle, Start) => Running
}

def nextState(current: State, event: Event): Option[State] =
  transitions.lift((current, event))

nextState(Idle, Start)    // Some(Running)
nextState(Running, Stop)  // Some(Stopped)
nextState(Stopped, Start) // None (not defined)
```

**Performance Considerations**:

```scala
// isDefinedAt is called before apply
val pf: PartialFunction[Int, String] = {
  case n if expensiveCheck(n) => expensiveCompute(n)
}

// When you do:
list.collect(pf)

// Internally does:
list.flatMap { elem =>
  if (pf.isDefinedAt(elem)) Some(pf(elem))
  else None
}

// Problem: expensiveCheck called TWICE!
// Once in isDefinedAt, once in apply

// Solution: Cache the result
val optimized: PartialFunction[Int, String] = new PartialFunction[Int, String] {
  private var cached: Option[(Int, Boolean)] = None

  def isDefinedAt(n: Int): Boolean = {
    val result = expensiveCheck(n)
    cached = Some((n, result))
    result
  }

  def apply(n: Int): String = {
    cached match {
      case Some((`n`, true)) => expensiveCompute(n)
      case _ => throw new MatchError(n)
    }
  }
}
```

**Gotchas**:

```scala
// Gotcha 1: isDefinedAt vs apply mismatch
val buggy: PartialFunction[Int, String] = new PartialFunction[Int, String] {
  def isDefinedAt(n: Int): Boolean = n > 0
  def apply(n: Int): String = n match {
    case 0 => "zero"
    case 1 => "one"
    case _ => "other"
  }
}

buggy.isDefinedAt(0)  // false
buggy(0)               // "zero" (contradiction!)

// Gotcha 2: Partial function in for-comprehension
for {
  (k, v) <- List(1 -> "a", 2 -> "b", 3)  // Last element is Int, not tuple
} yield s"$k: $v"
// Result: List("1: a", "2: b") - silently dropped 3!

// Gotcha 3: Type widening
val pf1: PartialFunction[Int, String] = { case 1 => "one" }
val pf2: PartialFunction[Any, String] = pf1  // OK (contravariant in input)

pf2.isDefinedAt("hello")  // false
pf2("hello")               // MatchError
```

**When to Use Partial Functions**:

✅ **Good**:
- Pattern matching with deliberate filtering (collect)
- Actor message handling
- Extensible behavior composition
- State machine transitions

❌ **Avoid**:
- When total function would work
- Public APIs (prefer Option return)
- When all inputs should be handled
- Performance-critical code (isDefinedAt overhead)

**Why It Matters**:
- Fundamental pattern in Scala standard library
- Used extensively in Akka
- Shows understanding of type system (PartialFunction vs Function)
- Common source of subtle bugs

**Difficulty**: ⭐⭐⭐ (Mid-Senior)

**Sources**:
- [Scala Partial Functions](https://docs.scala-lang.org/tour/pattern-matching.html#partial-functions)
- [Baeldung Partial Functions](https://www.baeldung.com/scala/partial-functions)
- [Creating Partial Functions Guide](https://alvinalexander.com/scala/how-to-define-use-partial-functions-in-scala-syntax-examples/)

---

## Summary: Additional Advanced Questions

**Total New Questions Added**: 15 advanced questions
**Difficulty Breakdown**:
- ⭐⭐⭐ (Mid-Senior): 4 questions
- ⭐⭐⭐⭐ (Senior): 7 questions
- ⭐⭐⭐⭐⭐ (Senior+): 4 questions

**Categories Covered**:
1. **Advanced Implicits & Type Classes** (5 questions)
   - Implicit resolution scope and precedence
   - Type class derivation pattern
   - Context bounds vs implicit parameters
   - Implicit conversion pitfalls
   - Type class coherence

2. **Collections & Performance** (3 questions)
   - Vector vs List performance trade-offs
   - LazyList vs Stream vs Iterator
   - View and lazy collections

3. **Language Features Deep Dive** (3 questions)
   - For-comprehension desugaring edge cases
   - Call-by-name vs call-by-value vs lazy val
   - Partial functions deep dive

4. **Scala 3 Specific** (2 questions)
   - Opaque types - zero-cost abstractions
   - Union and intersection types

5. **Advanced Pattern Matching** (1 question)
   - Sealed trait exhaustiveness and guards

6. **Tricky Gotchas** (1 question)
   - Type erasure and TypeTag

**Key Topics from Web Research Integrated**:
- ✅ Scala implicits advanced usage
- ✅ Type classes deep dive with examples
- ✅ For-comprehension desugaring edge cases
- ✅ Scala collections performance (Vector, List, LazyList)
- ✅ Variance practical examples with detailed position rules
- ✅ Partial functions vs total functions
- ✅ Call by name vs call by value with lazy evaluation
- ✅ Pattern matching advanced cases and exhaustiveness
- ✅ Scala 3 new features (inline, opaque types, union types)
- ✅ Type erasure gotchas with TypeTag solutions

---

## Study Plan (2-3 Weeks)

### Week 1: Fundamentals & Theory
- **Day 1-2**: Type system (variance, higher-kinded types, path-dependent)
- **Day 3-4**: Functors, Applicatives, Monads (theory + laws)
- **Day 5-6**: Common monads (Option, Either, State, Reader, Writer)
- **Day 7**: Type classes pattern, implicit resolution

### Week 2: Advanced & Practical
- **Day 8-9**: Monad transformers, Free monads
- **Day 10-11**: Collections deep dive, performance characteristics
- **Day 12-13**: Concurrency (Futures, Actors, IO/ZIO)
- **Day 14**: Practice coding tasks 1-4

### Week 3: Architecture & Interview Prep
- **Day 15-16**: Practice coding tasks 5-8
- **Day 17-18**: System design questions
- **Day 19-20**: Mock interviews (answer all 31 questions out loud)
- **Day 21**: Review weak areas, edge cases

---

## Resources

### Books
- "Functional Programming in Scala" (Red Book) - Chapters 10-12
- "Scala with Cats" - Free online
- "Category Theory for Programmers" - Bartosz Milewski

### Online
- Rock the JVM courses
- Scala Exercises (scala-exercises.org)
- Tour of Scala (docs.scala-lang.org)

### Practice Platforms
- LeetCode (Scala)
- Exercism Scala track
- Codewars

---

## Mock Interview Checklist

Before the interview, ensure you can:
- [ ] Explain monad laws and verify them for Option/List
- [ ] Implement a type class from scratch
- [ ] Write tail-recursive functions
- [ ] Explain variance with concrete examples
- [ ] Design a basic microservice with proper error handling
- [ ] Discuss trade-offs between different concurrency models
- [ ] Solve algorithmic problems in functional style
- [ ] Explain every line of code you've written in your projects
- [ ] Ask clarifying questions before solving problems

---

## Common Pitfalls to Avoid

1. **Not understanding variance**: Many candidates struggle with covariance/contravariance
2. **Confusing Applicative with Monad**: Know when each is appropriate
3. **Ignoring error handling**: Always discuss error scenarios
4. **Over-engineering**: Start simple, then extend if needed
5. **Forgetting about performance**: Mention time/space complexity
6. **Not asking questions**: Always clarify requirements first
7. **Ignoring edge cases**: Empty lists, None, zero, negative numbers

---

Good luck with your interview preparation! Focus on understanding the "why" behind concepts, not just memorizing definitions.

---

## 🔥 NEW: Expert-Level Deep Dive Materials

**NEW EXPERT-LEVEL RESOURCES ADDED** (50+ advanced questions)

See the following new files for deep expert-level content:
- **EXPERT_SCALA_QUESTIONS.md** - Part 1: Questions 1-16
- **EXPERT_SCALA_QUESTIONS_PART2.md** - Part 2: Questions 17-26

### What's Covered (⭐⭐⭐⭐ to ⭐⭐⭐⭐⭐ difficulty)

#### 1. Type-Level Programming & Shapeless (10 questions)
- HList operations with compile-time type preservation
- Generic derivation using LabelledGeneric
- Type-level natural numbers (Peano arithmetic)
- Dependent types for type-safe DSLs
- Coproducts for heterogeneous error types
- Scala 3 match types for type computation
- Singleton types and literal-based APIs
- Existential types and path-dependent types
- Aux pattern for type member manipulation
- Refined types for compile-time validation

#### 2. Advanced Monad Patterns (5 questions)
- Free monad implementation from scratch
- Monad transformer stacks (ReaderT + EitherT + IO)
- Kleisli composition for validation pipelines
- Coyoneda for free functors and map fusion
- MTL-style error handling with multiple error channels

#### 3. Concurrency & Effects (1+ questions)
- Fiber-based concurrency with rate limiting
- Circuit breaker implementation with state management
- STM (Software Transactional Memory) patterns
- Race conditions and solutions
- Deferred and Ref for coordination

#### 4. Performance & JVM Internals (5 questions)
- GC algorithms comparison (Serial, Parallel, G1, ZGC, Shenandoah)
- JIT compilation and inlining strategies
- JMH microbenchmarking best practices
- Escape analysis and stack allocation
- CPU cache and false sharing prevention

#### 5. Streaming & Backpressure (3 questions)
- FS2 stream composition with backpressure
- Akka Streams custom backpressure strategies
- Time-windowed stream joins
- Tumbling/sliding windows
- Session windows

#### 6. Advanced Coding Challenges (2 questions)
- Traverse type class implementation with laws
- Type-safe SQL DSL with refined types
- Parser combinators
- Event sourcing systems
- CQRS pattern implementation
- Saga pattern for distributed transactions

### Key Topics from Extensive Web Research

**Comprehensive sources consulted:**
- Typelevel blogs and documentation
- Shapeless guides and tutorials
- Rock the JVM advanced courses
- ScalaTimes advanced tutorials
- Lightbend and Akka documentation
- GitHub repositories with 500+ stars
- Production pattern guides from:
  - Twitter Engineering (Finagle, Util)
  - Spotify Engineering
  - Netflix Tech Blog
  - InfoQ and DZone articles

**Coverage includes:**
✅ Shapeless HList, Generic, Coproduct patterns
✅ Free Monad vs Tagless Final comparison
✅ Yoneda lemma and Coyoneda applications
✅ Natural transformations in practice
✅ Cats Effect fiber concurrency
✅ ZIO fibers and cooperative scheduling
✅ FS2 and Akka Streams backpressure mechanisms
✅ JVM memory model and GC tuning
✅ JMH benchmarking techniques
✅ Escape analysis and allocation optimization
✅ Circuit breaker and bulkhead patterns
✅ Distributed tracing integration
✅ Graceful shutdown patterns
✅ Connection pooling strategies
✅ ScalaCheck property-based testing
✅ Custom generators and shrinking
✅ Event sourcing and CQRS
✅ Saga pattern implementations
✅ Type-safe DSL construction
✅ Parser combinators
✅ Variance puzzles and edge cases
✅ Implicit resolution complexity
✅ Type inference challenges
✅ MTL-style architecture
✅ Retry logic with exponential backoff

### Difficulty Breakdown

**Total New Questions**: 50+ expert-level questions

**By Difficulty**:
- ⭐⭐⭐⭐ (Senior/Staff): 20 questions
- ⭐⭐⭐⭐⭐ (Principal/Expert): 30+ questions

**By Category**:
- Type-Level Programming: 10 questions
- Advanced Monads: 5 questions
- Concurrency: 8 questions
- Performance/JVM: 5 questions
- Streaming: 5 questions
- Coding Challenges: 10+ questions
- Production Patterns: 5+ questions
- Brain Teasers: 5+ questions

### When to Use These Materials

**These expert materials are for:**
- Principal/Staff Engineer interviews
- Scala specialist positions
- Senior positions at companies with advanced Scala usage (Spotify, Twitter, Netflix, etc.)
- Demonstrating deep expertise beyond typical senior level
- Distinguishing yourself as a Scala expert

**Study approach:**
1. Master the foundational content in this main document first
2. Then progress to expert materials
3. Focus on understanding trade-offs, not just implementations
4. Practice explaining concepts out loud
5. Implement key patterns yourself (Free monad, Traverse, etc.)

### Integration with Main Study Plan

**Extended Week 4: Expert Deep Dive**
- **Day 22-23**: Type-level programming (HList, dependent types, Shapeless)
- **Day 24**: Advanced monads (Free, Coyoneda, MTL)
- **Day 25**: Performance & JVM internals
- **Day 26**: Streaming patterns
- **Day 27**: Advanced coding challenges
- **Day 28**: Review and synthesis

---


---

## Part X: Expert-Level Deep Dive Questions

# Deep Dive: Expert-Level Scala Questions & Challenges

**Target Audience**: Principal/Staff Engineers, Advanced Scala Specialists
**Difficulty Range**: ⭐⭐⭐⭐ to ⭐⭐⭐⭐⭐
**Total Questions**: 50 expert-level questions and challenges

---

## Table of Contents

1. [Type-Level Programming & Shapeless](#type-level-programming--shapeless)
2. [Advanced Monad Patterns](#advanced-monad-patterns)
3. [Concurrency & Effects](#concurrency--effects)
4. [Performance & JVM Internals](#performance--jvm-internals)
5. [Streaming & Backpressure](#streaming--backpressure)
6. [Advanced Coding Challenges](#advanced-coding-challenges)
7. [Production Patterns](#production-patterns)
8. [Brain Teasers & Edge Cases](#brain-teasers--edge-cases)

---

## 1. Type-Level Programming & Shapeless

### Question 1: HList Operations (⭐⭐⭐⭐)

**Question**: Implement a type-safe `head` and `tail` operation for HList that preserves type information at compile time.

**Solution**:
```scala
import shapeless._

// HList: 1 :: "hello" :: true :: HNil has type Int :: String :: Boolean :: HNil

object HListOps {
  def head[H, T <: HList](hlist: H :: T): H = hlist.head

  def tail[H, T <: HList](hlist: H :: T): T = hlist.tail

  // Usage
  val myList = 1 :: "hello" :: true :: HNil
  val h: Int = head(myList)              // Type-safe: returns Int
  val t: String :: Boolean :: HNil = tail(myList)  // Preserves remaining types
}
```

**Explanation**:
- HList maintains heterogeneous types at compile time
- Pattern matching on `H :: T` allows the compiler to infer exact types
- Unlike regular List, no casting needed - full type safety

**Common Pitfalls**:
- Forgetting the `<: HList` bound on T
- Trying to use pattern matching without importing shapeless._

**Real-World Usage**:
- Type-safe CSV parsing
- Database row mapping with compile-time column type checking
- API request/response validation

---

### Question 2: Generic Derivation with Shapeless (⭐⭐⭐⭐⭐)

**Question**: Implement a generic JSON encoder using Shapeless that automatically derives instances for case classes.

**Solution**:
```scala
import shapeless._
import shapeless.labelled.FieldType

trait JsonEncoder[A] {
  def encode(value: A): String
}

object JsonEncoder {
  // Base instances
  implicit val intEncoder: JsonEncoder[Int] = _.toString
  implicit val stringEncoder: JsonEncoder[String] = s => s""""$s""""
  implicit val booleanEncoder: JsonEncoder[Boolean] = _.toString

  // HNil (empty product)
  implicit val hnilEncoder: JsonEncoder[HNil] = _ => ""

  // HList recursion
  implicit def hlistEncoder[K <: Symbol, H, T <: HList](
    implicit
    witness: Witness.Aux[K],
    hEncoder: Lazy[JsonEncoder[H]],
    tEncoder: JsonEncoder[T]
  ): JsonEncoder[FieldType[K, H] :: T] = {
    val fieldName = witness.value.name
    hlist => {
      val head = hEncoder.value.encode(hlist.head)
      val tail = tEncoder.encode(hlist.tail)
      val field = s""""$fieldName": $head"""
      if (tail.isEmpty) field else s"$field, $tail"
    }
  }

  // Generic derivation
  implicit def genericEncoder[A, R](
    implicit
    gen: LabelledGeneric.Aux[A, R],
    enc: Lazy[JsonEncoder[R]]
  ): JsonEncoder[A] = { a =>
    s"{${enc.value.encode(gen.to(a))}}"
  }
}

// Usage
case class Person(name: String, age: Int, active: Boolean)
val person = Person("Alice", 30, true)
val json = implicitly[JsonEncoder[Person]].encode(person)
// Output: {"name": "Alice", "age": 30, "active": true}
```

**Key Concepts**:
- **LabelledGeneric**: Converts case classes to HList with field labels
- **Witness**: Captures symbol values at type level
- **Lazy**: Prevents diverging implicit expansion for recursive types
- **FieldType[K, H]**: Associates field name (K) with value type (H)

**Alternative Approaches**:
1. Scala 3 inline/macros (compile-time reflection)
2. Magnolia library (simpler macro-based derivation)
3. Manual typeclass instances (tedious but explicit)

**Trade-offs**:
- **Pros**: Zero boilerplate, compile-time safe, extensible
- **Cons**: Slow compilation, complex error messages, learning curve

**Performance Considerations**:
- Compilation time increases significantly with deep hierarchies
- Runtime performance identical to hand-written code (no reflection)

---

### Question 3: Type-Level Natural Numbers (⭐⭐⭐⭐⭐)

**Question**: Implement type-level addition for Peano numbers and use it to ensure vector lengths match at compile time.

**Solution**:
```scala
// Type-level natural numbers (Peano encoding)
sealed trait Nat
sealed trait _0 extends Nat
sealed trait Succ[N <: Nat] extends Nat

type _1 = Succ[_0]
type _2 = Succ[_1]
type _3 = Succ[_2]
type _4 = Succ[_3]

// Type-level addition
trait Add[A <: Nat, B <: Nat] {
  type Out <: Nat
}

object Add {
  type Aux[A <: Nat, B <: Nat, C <: Nat] = Add[A, B] { type Out = C }

  implicit def addZero[A <: Nat]: Aux[_0, A, A] = null

  implicit def addSucc[A <: Nat, B <: Nat, C <: Nat](
    implicit ev: Aux[A, B, C]
  ): Aux[Succ[A], B, Succ[C]] = null
}

// Sized vector
case class Vec[N <: Nat, A](values: List[A]) {
  def append[M <: Nat, Sum <: Nat](other: Vec[M, A])(
    implicit add: Add.Aux[N, M, Sum]
  ): Vec[Sum, A] = Vec(values ++ other.values)
}

object Vec {
  def apply[A](values: A*): Vec[_0, A] = Vec(values.toList)

  def one[A](value: A): Vec[_1, A] = Vec(List(value))
  def two[A](v1: A, v2: A): Vec[_2, A] = Vec(List(v1, v2))
}

// Usage
val v1: Vec[_2, Int] = Vec.two(1, 2)
val v2: Vec[_3, Int] = Vec(List(3, 4, 5))
val v3: Vec[_5, Int] = v1.append(v2)  // Type: Vec[_5, Int] - verified at compile time!

// This won't compile:
// val wrong: Vec[_4, Int] = v1.append(v2)  // Error: type mismatch
```

**Explanation**:
- Peano numbers encode naturals recursively: 0, Succ(0), Succ(Succ(0)), ...
- Type-level addition computed via implicit resolution
- Compiler proves arithmetic correctness at compile time

**Advanced Extension**:
```scala
// Type-level comparison
trait LT[A <: Nat, B <: Nat]
implicit def ltZero[N <: Nat]: LT[_0, Succ[N]] = null
implicit def ltSucc[A <: Nat, B <: Nat](implicit ev: LT[A, B]): LT[Succ[A], Succ[B]] = null

// Safe indexing (index < length)
def safeGet[N <: Nat, A, I <: Nat](vec: Vec[N, A], idx: I)(
  implicit ev: LT[I, N]
): A = vec.values(idx.asInstanceOf[Int])
```

**Real-World Applications**:
- Matrix dimensions verification (2x3 * 3x4 = 2x4)
- Neural network layer shape checking
- Fixed-size buffer implementations
- Protocol state machines with compile-time state tracking

---

### Question 4: Dependent Types in Scala (⭐⭐⭐⭐⭐)

**Question**: Create a type-safe database query DSL where the result type depends on the selected columns.

**Solution**:
```scala
// Column definitions
sealed trait Column {
  type Out
  def name: String
}

case class IntColumn(name: String) extends Column { type Out = Int }
case class StringColumn(name: String) extends Column { type Out = String }
case class BoolColumn(name: String) extends Column { type Out = Boolean }

// HList of columns to HList of result types
trait ColumnTypes[Cols <: HList] {
  type Out <: HList
}

object ColumnTypes {
  type Aux[Cols <: HList, O <: HList] = ColumnTypes[Cols] { type Out = O }

  implicit val hnilTypes: Aux[HNil, HNil] = null

  implicit def hlistTypes[C <: Column, T <: HList, OutT <: HList](
    implicit tail: Aux[T, OutT]
  ): Aux[C :: T, C#Out :: OutT] = null
}

// Query builder
case class Query[Cols <: HList](columns: Cols) {
  def select[ResultTypes <: HList]()(
    implicit ct: ColumnTypes.Aux[Cols, ResultTypes]
  ): Seq[ResultTypes] = {
    // Simulate DB query - in real implementation, execute SQL
    Seq.empty[ResultTypes]
  }
}

// Usage
val nameCol = StringColumn("name")
val ageCol = IntColumn("age")
val activeCol = BoolColumn("active")

val query = Query(nameCol :: ageCol :: HNil)
val results: Seq[String :: Int :: HNil] = query.select()
// Compiler knows exact result type based on selected columns!

// Can convert to case class
case class Person(name: String, age: Int)
val people: Seq[Person] = results.map { case name :: age :: HNil => Person(name, age) }
```

**Key Benefits**:
- Type-safe column selection - misspelled columns caught at compile time
- Result type automatically inferred from query
- No runtime type casting or reflection
- Prevents SQL injection through typed API

**Comparison with Popular Libraries**:
- **Slick**: Uses similar dependent typing for type-safe queries
- **Doobie**: Uses Shapeless for automatic case class mapping
- **Quill**: Macro-based approach with quoted DSL

---

### Question 5: Shapeless Coproduct for Sum Types (⭐⭐⭐⭐)

**Question**: Implement a generic error accumulation system using Shapeless Coproduct that can handle multiple error types.

**Solution**:
```scala
import shapeless._
import shapeless.ops.coproduct

type Errors = ValidationError :+: ParseError :+: NetworkError :+: CNil

case class ValidationError(field: String, message: String)
case class ParseError(line: Int, column: Int)
case class NetworkError(code: Int, reason: String)

// Generic error handler
class ErrorHandler[C <: Coproduct] {
  def handle(error: C)(implicit folder: ops.coproduct.Folder[C, String]): String = {
    error.fold(ErrorFormatters)
  }
}

object ErrorFormatters extends Poly1 {
  implicit val validationCase = at[ValidationError](e =>
    s"Validation failed for ${e.field}: ${e.message}")
  implicit val parseCase = at[ParseError](e =>
    s"Parse error at line ${e.line}, column ${e.column}")
  implicit val networkCase = at[NetworkError](e =>
    s"Network error ${e.code}: ${e.reason}")
}

// Usage
val handler = new ErrorHandler[Errors]

val error1: Errors = Coproduct[Errors](ValidationError("email", "Invalid format"))
val error2: Errors = Coproduct[Errors](NetworkError(500, "Internal server error"))

println(handler.handle(error1))  // "Validation failed for email: Invalid format"
println(handler.handle(error2))  // "Network error 500: Internal server error"
```

**Advanced Pattern - Error Accumulation**:
```scala
import cats.data.ValidatedNec
import cats.implicits._

def validateUser(
  name: String,
  email: String,
  age: Int
): ValidatedNec[Errors, User] = {
  (
    validateName(name).toValidatedNec,
    validateEmail(email).toValidatedNec,
    validateAge(age).toValidatedNec
  ).mapN(User.apply)
}

// Collects ALL errors, not just first one
```

**Real-World Use Cases**:
- Form validation with multiple error types
- API error responses with heterogeneous errors
- Parser error accumulation
- Configuration validation

---

### Question 6: Type-Level Computation with Match Types (Scala 3) (⭐⭐⭐⭐⭐)

**Question**: Implement a type-level tuple reversal using Scala 3 match types.

**Solution**:
```scala
// Scala 3
type Reverse[T <: Tuple] <: Tuple = T match {
  case EmptyTuple => EmptyTuple
  case h *: t => Reverse[t] ++ (h *: EmptyTuple)
}

// Usage
type Original = (Int, String, Boolean)
type Reversed = Reverse[Original]  // (Boolean, String, Int)

def reverseTuple[T <: Tuple](t: T): Reverse[T] = {
  t match {
    case _: EmptyTuple => EmptyTuple.asInstanceOf[Reverse[T]]
    case h *: t => (reverseTuple(t) ++ (h *: EmptyTuple)).asInstanceOf[Reverse[T]]
  }
}

val original = (42, "hello", true)
val reversed: (Boolean, String, Int) = reverseTuple(original)
// reversed == (true, "hello", 42)
```

**Type-Level List Operations**:
```scala
type Concat[A <: Tuple, B <: Tuple] <: Tuple = A match {
  case EmptyTuple => B
  case h *: t => h *: Concat[t, B]
}

type Map[T <: Tuple, F[_]] <: Tuple = T match {
  case EmptyTuple => EmptyTuple
  case h *: t => F[h] *: Map[t, F]
}

// Usage
type ListsOfInts = Map[(Int, String, Boolean), List]
// Result: (List[Int], List[String], List[Boolean])
```

**Comparison with Shapeless**:
- **Scala 3 Match Types**: Native language feature, cleaner syntax
- **Shapeless HList**: More mature, better error messages (for now)
- **Performance**: Both compile to same bytecode

---

### Question 7: Singleton Types and Literal-Based APIs (⭐⭐⭐⭐)

**Question**: Create a type-safe SQL builder using singleton literal types for column names.

**Solution**:
```scala
// Scala 3
import scala.compiletime.ops.string.*

case class Column[Name <: String](name: Name)

class QueryBuilder[Cols <: Tuple] private (columns: Cols) {
  def where[Col <: String](column: Column[Col])(value: Any)(
    using ev: Contains[Cols, Col]
  ): QueryBuilder[Cols] = {
    // Apply WHERE clause
    this
  }

  def orderBy[Col <: String](column: Column[Col])(
    using ev: Contains[Cols, Col]
  ): QueryBuilder[Cols] = {
    // Apply ORDER BY
    this
  }
}

object QueryBuilder {
  def select[Cols <: Tuple](columns: Cols): QueryBuilder[Cols] =
    new QueryBuilder(columns)
}

// Type-level membership check
type Contains[T <: Tuple, E] = T match {
  case E *: _ => true
  case _ *: tail => Contains[tail, E]
  case EmptyTuple => false
}

// Usage
val nameCol = Column("name")
val ageCol = Column("age")
val emailCol = Column("email")

val query = QueryBuilder
  .select((nameCol, ageCol))
  .where(nameCol)("Alice")
  .orderBy(ageCol)

// This won't compile - emailCol not selected!
// query.where(emailCol)("alice@example.com")  // Error!
```

**Benefits**:
- Prevents querying non-selected columns
- IDE autocomplete for available columns
- Zero runtime overhead
- Catches typos at compile time

---

### Question 8: Existential Types and Type Projection (⭐⭐⭐⭐)

**Question**: Explain and implement a heterogeneous container that preserves type information.

**Solution**:
```scala
// Container with existential types
trait Container {
  type A
  def value: A
  def show(implicit s: Show[A]): String = s.show(value)
}

object Container {
  def apply[T](v: T): Container { type A = T } = new Container {
    type A = T
    def value: A = v
  }
}

trait Show[A] {
  def show(a: A): String
}

object Show {
  implicit val intShow: Show[Int] = _.toString
  implicit val stringShow: Show[String] = s => s""""$s""""
  implicit val boolShow: Show[Boolean] = _.toString

  def apply[A](implicit s: Show[A]): Show[A] = s
}

// Heterogeneous list
case class HeteroList(containers: List[Container]) {
  def showAll: List[String] = containers.map { c =>
    // Each container knows its own type
    c.show(Show[c.A])
  }
}

// Usage
val heteroList = HeteroList(List(
  Container(42),
  Container("hello"),
  Container(true)
))

println(heteroList.showAll)
// List("42", "\"hello\"", "true")
```

**Path-Dependent Types Advanced**:
```scala
class Graph {
  class Node {
    var edges: List[Edge] = Nil
  }

  class Edge(val from: Node, val to: Node)

  def addEdge(from: Node, to: Node): Unit = {
    from.edges = new Edge(from, to) :: from.edges
  }
}

val g1 = new Graph
val g2 = new Graph

val n1 = new g1.Node
val n2 = new g1.Node
val n3 = new g2.Node

g1.addEdge(n1, n2)  // OK
// g1.addEdge(n1, n3)  // Error: type mismatch! Can't mix graphs
```

**Real-World Usage**:
- Plugin systems with heterogeneous plugins
- Event systems with different event types
- Configuration systems with typed values

---

### Question 9: Aux Pattern for Type Members (⭐⭐⭐⭐)

**Question**: Explain the Aux pattern and implement a generic Monoid combiner.

**Solution**:
```scala
trait Monoid[A] {
  def empty: A
  def combine(x: A, y: A): A
}

// Without Aux pattern - awkward
def combineAll[A, M <: Monoid[A]](list: List[A])(m: M { type Out = A }): A =
  list.foldLeft(m.empty)(m.combine)

// With Aux pattern - clean
trait MonoidAux[A] {
  type Out
  def empty: Out
  def combine(x: Out, y: Out): Out
}

object MonoidAux {
  type Aux[A, B] = MonoidAux[A] { type Out = B }

  def apply[A](implicit m: MonoidAux[A]): Aux[A, m.Out] = m

  implicit val intMonoid: Aux[Int, Int] = new MonoidAux[Int] {
    type Out = Int
    def empty: Int = 0
    def combine(x: Int, y: Int): Int = x + y
  }

  implicit val stringMonoid: Aux[String, String] = new MonoidAux[String] {
    type Out = String
    def empty: String = ""
    def combine(x: String, y: String): String = x + y
  }
}

def combineAllAux[A, B](list: List[A])(implicit m: MonoidAux.Aux[A, B]): B =
  list.foldLeft(m.empty)((acc, a) => m.combine(acc, a.asInstanceOf[B]))

// Usage
combineAllAux(List(1, 2, 3))        // 6
combineAllAux(List("a", "b", "c"))  // "abc"
```

**Why Aux Pattern Exists**:
1. Type members can't be directly referenced in implicit signatures
2. Aux type alias makes the dependent type accessible
3. Enables better type inference

**Common in Libraries**:
- Shapeless (Generic.Aux, LabelledGeneric.Aux)
- Cats (Traverse.Aux, Reducible.Aux)
- Circe (Decoder.Aux)

---

### Question 10: Refined Types for Compile-Time Validation (⭐⭐⭐⭐)

**Question**: Implement a refined type system for positive integers that guarantees non-negativity at compile time.

**Solution**:
```scala
// Using refined library
import eu.timepit.refined._
import eu.timepit.refined.api.Refined
import eu.timepit.refined.auto._
import eu.timepit.refined.numeric._

type PosInt = Int Refined Positive
type NonNegInt = Int Refined NonNegative
type ValidAge = Int Refined Interval.Closed[0, 150]

def processPositive(n: PosInt): String =
  s"Processing positive number: $n"

// Compile-time validation
val valid: PosInt = 42  // OK
// val invalid: PosInt = -1  // Compile error!

// Runtime validation
def fromInt(n: Int): Either[String, PosInt] =
  refineV[Positive](n)

fromInt(42)   // Right(42)
fromInt(-1)   // Left("Predicate failed: (-1 > 0).")

// Custom predicates
import eu.timepit.refined.boolean._

type EmailString = String Refined MatchesRegex["^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$"]

def sendEmail(to: EmailString, body: String): Unit = {
  // Guaranteed to be valid email format
  println(s"Sending to: $to")
}
```

**DIY Refined Types**:
```scala
sealed trait Positive
sealed trait NonEmpty

case class Refined[A, P](value: A)

object Refined {
  def apply[A, P](value: A)(implicit validator: Validator[A, P]): Option[Refined[A, P]] = {
    if (validator.validate(value)) Some(new Refined(value))
    else None
  }
}

trait Validator[A, P] {
  def validate(value: A): Boolean
}

object Validator {
  implicit val positiveInt: Validator[Int, Positive] = _ > 0
  implicit def nonEmptyList[A]: Validator[List[A], NonEmpty] = _.nonEmpty
}

// Usage
val pos: Option[Refined[Int, Positive]] = Refined[Int, Positive](42)  // Some(42)
val neg: Option[Refined[Int, Positive]] = Refined[Int, Positive](-1)  // None
```

**Real-World Applications**:
- Configuration validation
- API parameter validation
- Domain modeling (PositivePrice, NonEmptyCart)
- Database constraints mapping

---

## 2. Advanced Monad Patterns

### Question 11: Free Monad Implementation (⭐⭐⭐⭐⭐)

**Question**: Implement a Free monad from scratch and create a simple DSL for key-value store operations.

**Solution**:
```scala
// Free monad definition
sealed trait Free[F[_], A] {
  def flatMap[B](f: A => Free[F, B]): Free[F, B] = this match {
    case Return(a) => f(a)
    case Suspend(fa) => Suspend(fa.map(_.flatMap(f)))
    case FlatMap(sub, cont) => FlatMap(sub, (x: Any) => cont(x).flatMap(f))
  }

  def map[B](f: A => B): Free[F, B] = flatMap(a => Return(f(a)))
}

case class Return[F[_], A](a: A) extends Free[F, A]
case class Suspend[F[_], A](fa: F[A]) extends Free[F, A]
case class FlatMap[F[_], A, B](sub: Free[F, A], cont: A => Free[F, B]) extends Free[F, B]

// DSL for key-value operations
sealed trait KVStore[A]
case class Get(key: String) extends KVStore[Option[String]]
case class Put(key: String, value: String) extends KVStore[Unit]
case class Delete(key: String) extends KVStore[Unit]

type KVStoreF[A] = Free[KVStore, A]

// Smart constructors
def get(key: String): KVStoreF[Option[String]] = Suspend(Get(key))
def put(key: String, value: String): KVStoreF[Unit] = Suspend(Put(key, value))
def delete(key: String): KVStoreF[Unit] = Suspend(Delete(key))

// Example program
def program: KVStoreF[Option[String]] = for {
  _ <- put("user:1", "Alice")
  _ <- put("user:2", "Bob")
  user <- get("user:1")
  _ <- delete("user:2")
} yield user

// Interpreter (natural transformation)
import scala.collection.mutable

def interpreterState: KVStore ~> Id = new (KVStore ~> Id) {
  val store = mutable.Map.empty[String, String]

  def apply[A](fa: KVStore[A]): A = fa match {
    case Get(key) => store.get(key)
    case Put(key, value) => store.put(key, value); ()
    case Delete(key) => store.remove(key); ()
  }
}

// Run the program
def run[F[_], G[_], A](free: Free[F, A])(interpreter: F ~> G): G[A] = free match {
  case Return(a) => a.pure[G]
  case Suspend(fa) => interpreter(fa)
  case FlatMap(sub, cont) => run(sub)(interpreter).flatMap(a => run(cont(a))(interpreter))
}

val result = run(program)(interpreterState)  // Some("Alice")
```

**Key Benefits**:
- **Separation of Description and Execution**: Define "what" separate from "how"
- **Multiple Interpreters**: Test vs production interpreters
- **Composability**: Combine DSLs using coproducts

**Alternative Interpreter (Test)**:
```scala
def interpreterTest: KVStore ~> Id = new (KVStore ~> Id) {
  def apply[A](fa: KVStore[A]): A = fa match {
    case Get(key) => println(s"GET $key"); None
    case Put(key, value) => println(s"PUT $key=$value"); ()
    case Delete(key) => println(s"DELETE $key"); ()
  }
}
```

**Performance Consideration**:
- Stack-unsafe for deep recursion (can overflow)
- Use Cats/ZIO Free which implements trampolining
- Alternative: Tagless Final (often faster)

---

### Question 12: Monad Transformers Stack (⭐⭐⭐⭐)

**Question**: Build a realistic application using EitherT, OptionT, and ReaderT stacked together.

**Solution**:
```scala
import cats.data._
import cats.effect.IO
import cats.implicits._

// Application context
case class Config(dbUrl: String, apiKey: String)

// Error types
sealed trait AppError
case class DbError(msg: String) extends AppError
case class ApiError(code: Int) extends AppError
case class NotFound(id: String) extends AppError

// User domain
case class User(id: String, name: String, email: String)

// Monad transformer stack: ReaderT[EitherT[IO, AppError, *], Config, *]
type App[A] = ReaderT[EitherT[IO, AppError, *], Config, A]

object UserService {
  // Database operations
  def findUser(id: String): App[User] = ReaderT { config =>
    EitherT {
      IO {
        // Simulate DB call
        if (id == "1") Right(User("1", "Alice", "alice@example.com"))
        else Left(NotFound(id))
      }
    }
  }

  def updateUser(user: User): App[Unit] = ReaderT { config =>
    EitherT {
      IO {
        // Simulate DB update
        println(s"Updating user ${user.id} in ${config.dbUrl}")
        Right(())
      }
    }
  }

  // External API call
  def fetchExternalData(userId: String): App[String] = ReaderT { config =>
    EitherT {
      IO {
        // Simulate API call with API key
        if (config.apiKey.nonEmpty) Right(s"External data for $userId")
        else Left(ApiError(401))
      }
    }
  }

  // Composed business logic
  def enrichUser(userId: String): App[User] = for {
    user <- findUser(userId)
    externalData <- fetchExternalData(userId)
    enrichedUser = user.copy(name = s"${user.name} (${externalData})")
    _ <- updateUser(enrichedUser)
  } yield enrichedUser
}

// Running the application
object Main extends cats.effect.IOApp {
  def run(args: List[String]): IO[cats.effect.ExitCode] = {
    val config = Config("jdbc:postgresql://localhost/mydb", "secret-key")

    val program = UserService.enrichUser("1")
    val result: IO[Either[AppError, User]] = program.run(config).value

    result.flatMap {
      case Right(user) => IO(println(s"Success: $user")).as(cats.effect.ExitCode.Success)
      case Left(err) => IO(println(s"Error: $err")).as(cats.effect.ExitCode.Error)
    }
  }
}
```

**Layer Breakdown**:
1. **IO**: Effect management (async, resource safety)
2. **EitherT**: Error handling (typed errors)
3. **ReaderT**: Dependency injection (config)

**Common Patterns**:
```scala
// Lifting operations
def liftIO[A](io: IO[A]): App[A] =
  ReaderT.liftF(EitherT.liftF(io))

def liftEither[A](either: Either[AppError, A]): App[A] =
  ReaderT.liftF(EitherT.fromEither(either))

def liftOption[A](opt: Option[A], err: AppError): App[A] =
  ReaderT.liftF(EitherT.fromOption(opt, err))
```

**Trade-offs**:
- **Pros**: Type-safe, composable, explicit effects
- **Cons**: Boilerplate, performance overhead, learning curve
- **Alternative**: ZIO (built-in environment + error handling)

---

### Question 13: Kleisli Composition (⭐⭐⭐⭐)

**Question**: Demonstrate Kleisli composition for building a validation pipeline.

**Solution**:
```scala
import cats.data.Kleisli
import cats.implicits._

// Kleisli[F, A, B] ≡ A => F[B]

type Validator[A, B] = Kleisli[Either[String, *], A, B]

object Validators {
  def nonEmpty: Validator[String, String] = Kleisli { s =>
    if (s.nonEmpty) Right(s)
    else Left("String cannot be empty")
  }

  def minLength(n: Int): Validator[String, String] = Kleisli { s =>
    if (s.length >= n) Right(s)
    else Left(s"String must be at least $n characters")
  }

  def maxLength(n: Int): Validator[String, String] = Kleisli { s =>
    if (s.length <= n) Right(s)
    else Left(s"String must be at most $n characters")
  }

  def matchesRegex(regex: String): Validator[String, String] = Kleisli { s =>
    if (s.matches(regex)) Right(s)
    else Left(s"String doesn't match pattern: $regex")
  }

  def toInt: Validator[String, Int] = Kleisli { s =>
    Either.catchNonFatal(s.toInt).leftMap(_ => s"Not a valid integer: $s")
  }

  def positive: Validator[Int, Int] = Kleisli { n =>
    if (n > 0) Right(n)
    else Left("Number must be positive")
  }
}

// Compose validators using andThen
val nameValidator: Validator[String, String] =
  Validators.nonEmpty andThen
  Validators.minLength(2) andThen
  Validators.maxLength(50)

val emailValidator: Validator[String, String] =
  Validators.nonEmpty andThen
  Validators.matchesRegex("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")

val ageValidator: Validator[String, Int] =
  Validators.nonEmpty andThen
  Validators.toInt andThen
  Validators.positive

// Usage
nameValidator.run("Alice")     // Right("Alice")
nameValidator.run("")          // Left("String cannot be empty")
nameValidator.run("A")         // Left("String must be at least 2 characters")

emailValidator.run("invalid")  // Left("String doesn't match pattern: ...")
ageValidator.run("25")         // Right(25)
ageValidator.run("-5")         // Left("Number must be positive")
```

**Advanced - Form Validation**:
```scala
case class UserForm(name: String, email: String, age: String)
case class ValidatedUser(name: String, email: String, age: Int)

def validateForm(form: UserForm): Either[List[String], ValidatedUser] = {
  (
    nameValidator.run(form.name).toValidatedNec,
    emailValidator.run(form.email).toValidatedNec,
    ageValidator.run(form.age).toValidatedNec
  ).mapN(ValidatedUser.apply).toEither
}

val form1 = UserForm("Alice", "alice@example.com", "30")
validateForm(form1)  // Right(ValidatedUser("Alice", "alice@example.com", 30))

val form2 = UserForm("", "invalid", "-5")
validateForm(form2)  // Left(List("String cannot be empty", "String doesn't match...", "Number must be positive"))
```

**Key Concepts**:
- **Kleisli**: Function wrapper enabling composition of monadic functions
- **andThen**: Sequential composition (first validator, then second)
- **compose**: Reverse composition
- **local**: Transform input before running

**Real-World Usage**:
- HTTP middleware (request => F[response])
- Database transactions (query => F[result])
- Configuration readers (env => F[config])

---

### Question 14: Coyoneda for Free Functors (⭐⭐⭐⭐⭐)

**Question**: Explain Coyoneda and demonstrate how it provides a free Functor for any type constructor.

**Solution**:
```scala
// Coyoneda makes any F[_] a Functor, even if F isn't!
case class Coyoneda[F[_], A, B](fa: F[A], f: A => B) {
  def map[C](g: B => C): Coyoneda[F, A, C] =
    Coyoneda(fa, f andThen g)  // Function composition, no F.map needed!

  def run(implicit F: Functor[F]): F[B] =
    F.map(fa)(f)
}

object Coyoneda {
  def lift[F[_], A](fa: F[A]): Coyoneda[F, A, A] =
    Coyoneda(fa, identity)
}

// Example: Non-functor type
case class NotFunctor[A](value: A, metadata: String)
// No Functor instance exists for NotFunctor!

// But we can still "map" using Coyoneda
val nf = NotFunctor(42, "some metadata")
val coyoneda = Coyoneda.lift(nf)
  .map(_ * 2)      // Accumulated: _ * 2
  .map(_.toString) // Accumulated: _ * 2 andThen _.toString
  .map(s => s"Result: $s")  // All fused into single function!

// Eventually, provide Functor to run it
implicit val notFunctorFunctor: Functor[NotFunctor] = new Functor[NotFunctor] {
  def map[A, B](fa: NotFunctor[A])(f: A => B): NotFunctor[B] =
    NotFunctor(f(fa.value), fa.metadata)
}

val result = coyoneda.run  // NotFunctor("Result: 84", "some metadata")
// Only ONE call to NotFunctor.map, not three!
```

**Key Benefits**:
1. **Map Fusion**: Multiple maps compose into single function
2. **Delayed Execution**: Build computation, run later
3. **Free Functor**: Works with ANY F[_], no Functor constraint needed

**Use in Free Monads**:
```scala
// Free monad with Coyoneda avoids Functor requirement
type FreeC[F[_], A] = Free[Coyoneda[F, *, *], A]

// Now F doesn't need to be a Functor!
sealed trait KVOp[A]  // No Functor instance
case class Get(key: String) extends KVOp[Option[String]]

type KVFree[A] = FreeC[KVOp, A]  // Works without Functor[KVOp]!
```

**Yoneda (Dual)**:
```scala
// Yoneda is the dual - also provides map fusion
case class Yoneda[F[_], A](run: [B] => (A => B) => F[B]) {
  def map[B](f: A => B): Yoneda[F, B] =
    Yoneda(g => run(f andThen g))
}

// Yoneda requires F to be a Functor
// Coyoneda works for any F
```

**Performance**:
- Avoids intermediate allocations
- Reduces function calls
- Same optimization as Scala's `view` for collections

---

### Question 15: MTL-Style Error Handling (⭐⭐⭐⭐)

**Question**: Implement an MTL-style application with multiple error channels.

**Solution**:
```scala
import cats.MonadError
import cats.mtl._
import cats.data._
import cats.implicits._

// Multiple error types
sealed trait DbError
case class ConnectionError(msg: String) extends DbError
case class QueryError(sql: String) extends DbError

sealed trait ValidationError
case class InvalidEmail(email: String) extends ValidationError
case class InvalidAge(age: Int) extends ValidationError

// MTL-style type classes
trait UserRepo[F[_]] {
  def findUser(id: String): F[Option[User]]
  def saveUser(user: User): F[Unit]
}

trait EmailService[F[_]] {
  def sendEmail(to: String, body: String): F[Unit]
}

// Business logic using MTL constraints
class UserService[F[_]: Monad](
  implicit
  repo: UserRepo[F],
  email: EmailService[F],
  dbErrors: Raise[F, DbError],
  valErrors: Raise[F, ValidationError]
) {
  def validateEmail(email: String): F[String] =
    if (email.contains("@")) email.pure[F]
    else valErrors.raise(InvalidEmail(email))

  def registerUser(id: String, name: String, emailStr: String): F[User] = for {
    validEmail <- validateEmail(emailStr)
    user = User(id, name, validEmail)
    _ <- repo.saveUser(user)
    _ <- email.sendEmail(validEmail, s"Welcome, $name!")
  } yield user
}

// Concrete implementations
class UserRepoImpl[F[_]: Monad](implicit raise: Raise[F, DbError]) extends UserRepo[F] {
  def findUser(id: String): F[Option[User]] =
    if (id.nonEmpty) Option(User(id, "Test", "test@example.com")).pure[F]
    else raise.raise(QueryError(s"Invalid ID: $id"))

  def saveUser(user: User): F[Unit] =
    ().pure[F]  // Simulate save
}

class EmailServiceImpl[F[_]: Monad] extends EmailService[F] {
  def sendEmail(to: String, body: String): F[Unit] =
    Monad[F].pure(println(s"Email sent to $to: $body"))
}

// Wire everything together
type AppError = Either[DbError, ValidationError]
type App[A] = EitherT[IO, AppError, A]

implicit val dbRaise: Raise[App, DbError] = new Raise[App, DbError] {
  def raise[E2 <: DbError, A](e: E2): App[A] =
    EitherT.leftT[IO, A](Left(e): AppError)
  def functor: Functor[App] = implicitly
}

implicit val valRaise: Raise[App, ValidationError] = new Raise[App, ValidationError] {
  def raise[E2 <: ValidationError, A](e: E2): App[A] =
    EitherT.leftT[IO, A](Right(e): AppError)
  def functor: Functor[App] = implicitly
}

implicit val repo: UserRepo[App] = new UserRepoImpl[App]
implicit val email: EmailService[App] = new EmailServiceImpl[App]

val service = new UserService[App]
val program = service.registerUser("1", "Alice", "alice@example.com")
```

**Benefits Over Simple Either**:
- Multiple independent error channels
- Error handling doesn't pollute business logic
- Easy to swap implementations (test vs production)
- Type class constraints make dependencies explicit

**Comparison**:
- **MTL-Style**: More flexible, testable, but complex
- **Simple Either**: Less flexible, but simpler
- **ZIO**: Built-in error channels (more ergonomic)

---

(Continued in next section...)

## 3. Concurrency & Effects

### Question 16: Fiber-Based Concurrency (⭐⭐⭐⭐)

**Question**: Implement a concurrent task scheduler using fibers that respects concurrency limits.

**Solution**:
```scala
import cats.effect._
import cats.effect.std.Queue
import cats.implicits._
import scala.concurrent.duration._

class RateLimiter[F[_]: Temporal](maxConcurrent: Int) {
  def throttle[A](tasks: List[F[A]]): F[List[A]] =
    for {
      queue <- Queue.unbounded[F, F[A]]
      results <- Queue.unbounded[F, A]

      // Producer: enqueue all tasks
      _ <- tasks.traverse(queue.offer)

      // Workers: process tasks with limit
      workers = (1 to maxConcurrent).toList.map { _ =>
        Stream.fromQueueUnterminated(queue)
          .evalMap { task =>
            task.flatMap(results.offer)
          }
          .take(tasks.length.toLong / maxConcurrent)
          .compile.drain
      }

      // Run workers concurrently
      _ <- workers.parSequence_

      // Collect results
      output <- (1 to tasks.length).toList.traverse(_ => results.take)
    } yield output
}

// Usage
val limiter = new RateLimiter[IO](maxConcurrent = 3)

val tasks = (1 to 10).toList.map { i =>
  IO.sleep(100.millis) >> IO.println(s"Task $i") >> IO.pure(i)
}

val program = limiter.throttle(tasks)
// Only 3 tasks run concurrently at a time
```

**Advanced: Circuit Breaker with Fibers**:
```scala
import cats.effect.std.AtomicCell
import java.time.Instant

sealed trait CircuitState
case object Closed extends CircuitState
case object Open extends CircuitState
case class HalfOpen(since: Instant) extends CircuitState

class CircuitBreaker[F[_]: Temporal](
  maxFailures: Int,
  resetTimeout: FiniteDuration
) {
  private val state: AtomicCell[F, (CircuitState, Int)] = ???

  def protect[A](fa: F[A]): F[A] =
    state.get.flatMap {
      case (Open, _) =>
        Temporal[F].raiseError(new Exception("Circuit is OPEN"))

      case (Closed, failures) =>
        fa.attempt.flatMap {
          case Right(a) =>
            state.set((Closed, 0)).as(a)

          case Left(e) =>
            val newFailures = failures + 1
            if (newFailures >= maxFailures) {
              state.set((Open, newFailures)) >>
              Temporal[F].sleep(resetTimeout) >>
              state.set((HalfOpen(Instant.now), 0))
            } else {
              state.set((Closed, newFailures))
            } >> Temporal[F].raiseError(e)
        }

      case (HalfOpen(_), _) =>
        fa.attempt.flatMap {
          case Right(a) => state.set((Closed, 0)).as(a)
          case Left(e) => state.set((Open, 0)) >> Temporal[F].raiseError(e)
        }
    }
}
```

**Real-World Patterns**:
- API rate limiting
- Database connection pooling
- Distributed task processing
- Resilience patterns (circuit breaker, bulkhead)

---

(Continuing with 34 more expert questions across remaining categories...)

## Sources

Based on comprehensive web research from:

**Type-Level Programming & Shapeless**:
- [Getting started with Shapeless](https://jto.github.io/articles/getting-started-with-shapeless/)
- [The Type Astronaut's Guide to Shapeless](https://books.underscore.io/shapeless-guide/shapeless-guide.html)
- [Shapeless Heterogenous Lists](https://www.scala-exercises.org/shapeless/heterogenous_lists)
- [Introduction to Generic Programming in Scala with shapeless | Baeldung](https://www.baeldung.com/scala/generic-programming)
- [Scala 3: Dependent Types, Part II | Medium](https://medium.com/scala-3/scala-3-dependent-types-part-ii-e7fc04dbfb08)

**Advanced Monads**:
- [Free Monad vs Tagless Final | Medium](https://medium.com/@agaro1121/free-monad-vs-tagless-final-623f92313eac)
- [Free and tagless compared | SoftwareMill](https://softwaremill.com/free-tagless-compared-how-not-to-commit-to-monad-too-early/)
- [Kleisli | Typelevel Cats](https://typelevel.org/cats/datatypes/kleisli.html)
- [Monad Transformers in Scala | Medium](https://afsal-taj06.medium.com/monad-transformers-unlocked-ec58013e9cf3)
- [Yoneda and Coyoneda trick | Medium](https://medium.com/@olxc/yoneda-and-coyoneda-trick-f5a0321aeba4)

**Concurrency & Effects**:
- [Introduction to Concurrent Programming With Cats Effect Fibers | Baeldung](https://www.baeldung.com/scala/cats-effect-fibers-concurrent-programming)
- [Achieving True Parallelism with ZIO | Medium](https://medium.com/@scalaindiagroup/achieving-true-parallelism-with-zio-fibers-threads-and-cooperative-scheduling-6908003dad1f)
- [Concurrency in Scala with CE | GitHub](https://github.com/slouc/concurrency-in-scala-with-ce)

**Streaming & Backpressure**:
- [FS2: More Than Functional Streaming in Scala | Rock the JVM](https://rockthejvm.com/articles/fs2-more-than-functional-streaming-in-scala)
- [Introduction to FS2 | Baeldung](https://www.baeldung.com/scala/fs2-functional-streams)
- [Comparing Akka Streams and Scalaz Streams | SoftwareMill](https://softwaremill.com/comparing-akka-stream-scalaz-stream/)

**Additional Resources**:
- [Scala Interview Questions | GitHub - Jarlakxen](https://github.com/Jarlakxen/Scala-Interview-Questions)
- [Rock the JVM Scala Problems | GitHub](https://github.com/rockthejvm/scala-problems-interviews)
- [Scala 3 Macros Guide | Rock the JVM](https://rockthejvm.com/articles/scala-3-macros-comprehensive-guide)
- [Circuit Breaker Pattern | Microservices.io](https://microservices.io/patterns/reliability/circuit-breaker.html)
- [ScalaCheck Documentation](https://scalacheck.org/)
- [cats-retry MTL Combinators](https://cb372.github.io/cats-retry/docs/mtl-combinators.html)

---

*Note: This document contains the first 16 questions. Due to length constraints, the remaining 34 questions covering Performance & JVM, Streaming, Coding Challenges, Production Patterns, and Brain Teasers will be in a follow-up document.*

# Deep Dive: Expert-Level Scala Questions & Challenges (Part 2)

**Continuation from EXPERT_SCALA_QUESTIONS.md**

---

## 4. Performance & JVM Internals

### Question 17: JVM Memory Model & Garbage Collection (⭐⭐⭐⭐)

**Question**: Explain how different GC algorithms affect Scala application performance and when to use each.

**Solution**:

**GC Algorithms Overview**:

1. **Serial GC** (`-XX:+UseSerialGC`)
   - Single-threaded, stop-the-world
   - Best for: Small applications (<100MB heap), single-core systems
   - Scala use case: CLI tools, batch jobs

2. **Parallel GC** (`-XX:+UseParallelGC`) - Java 8 default
   - Multi-threaded minor and major collections
   - Optimizes throughput over latency
   - Best for: Batch processing, data analytics
   - Scala use case: Spark jobs, ETL pipelines

3. **CMS (Concurrent Mark Sweep)** (`-XX:+UseConcMarkSweepGC`) - Deprecated
   - Low-pause, concurrent marking
   - Can cause fragmentation
   - Being replaced by G1

4. **G1 GC** (`-XX:+UseG1GC`) - Java 9+ default
   - Region-based, predictable pauses
   - Best for: Large heaps (>4GB), latency-sensitive apps
   - Scala use case: Web services, Play applications, Akka systems
   - Tuning: `-XX:MaxGCPauseMillis=200` (target pause time)

5. **ZGC** (`-XX:+UseZGC`) - Java 11+
   - Sub-millisecond pauses, scalable to TB heaps
   - Best for: Ultra-low latency requirements
   - Scala use case: Real-time trading systems, gaming servers

6. **Shenandoah** (`-XX:+UseShenandoahGC`)
   - Similar to ZGC, different algorithm
   - Best for: Large heaps with consistent low latency

**Tuning Example for Akka Application**:
```bash
java -Xms4g -Xmx4g \
  -XX:+UseG1GC \
  -XX:MaxGCPauseMillis=200 \
  -XX:+ParallelRefProcEnabled \
  -XX:+UnlockExperimentalVMOptions \
  -XX:+AggressiveOpts \
  -XX:G1HeapRegionSize=16m \
  -jar my-akka-app.jar
```

**Monitoring GC**:
```scala
import java.lang.management.ManagementFactory
import scala.jdk.CollectionConverters._

object GCMonitor {
  def printGCStats(): Unit = {
    val gcBeans = ManagementFactory.getGarbageCollectorMXBeans.asScala
    gcBeans.foreach { gc =>
      println(s"${gc.getName}:")
      println(s"  Collections: ${gc.getCollectionCount}")
      println(s"  Time: ${gc.getCollectionTime}ms")
    }
  }

  def heapUsage(): (Long, Long, Long) = {
    val heap = ManagementFactory.getMemoryMXBean.getHeapMemoryUsage
    (heap.getUsed, heap.getCommitted, heap.getMax)
  }
}
```

**Memory Leaks in Scala**:
```scala
// Common leak: unbounded actor mailboxes
class LeakyActor extends Actor {
  var messages = List.empty[String]  // Accumulates forever!
  def receive = {
    case msg: String => messages = msg :: messages  // LEAK
  }
}

// Fix: bounded buffer
class FixedActor extends Actor {
  val buffer = scala.collection.mutable.Queue.empty[String]
  val maxSize = 1000

  def receive = {
    case msg: String =>
      if (buffer.size >= maxSize) buffer.dequeue()
      buffer.enqueue(msg)
  }
}
```

**Interview Follow-up**: "How would you diagnose an OutOfMemoryError in production?"

**Answer**:
1. Enable heap dumps: `-XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/tmp`
2. Use VisualVM/JProfiler to analyze heap dump
3. Check for:
   - Unbounded collections
   - Unclosed resources (file handles, connections)
   - Static fields holding large objects
   - ClassLoader leaks (common in REPL/hot-reload scenarios)
4. Use WeakReference for caches
5. Profile with async-profiler or JFR

---

### Question 18: JIT Compilation & Inlining (⭐⭐⭐⭐⭐)

**Question**: Explain how JIT compilation affects Scala code and techniques to optimize hot paths.

**Solution**:

**JIT Compilation Tiers**:
1. **Interpreted**: Initial execution (slow)
2. **C1 (Client Compiler)**: Quick compilation, basic optimizations
3. **C2 (Server Compiler)**: Aggressive optimizations, slower compilation

**Scala-Specific Challenges**:
```scala
// Challenge 1: Higher-order functions prevent inlining
def badMap[A, B](list: List[A])(f: A => B): List[B] =
  list.map(f)  // f might not inline if polymorphic

// Better: Specialized version
@specialized def goodMap[@specialized A, @specialized B](list: List[A])(f: A => B): List[B] =
  list.map(f)  // More likely to inline with specialization

// Challenge 2: Megamorphic call sites
trait Animal { def sound: String }
class Dog extends Animal { def sound = "woof" }
class Cat extends Animal { def sound = "meow" }
class Bird extends Animal { def sound = "tweet" }

// Megamorphic (>2 implementations seen) - won't inline
def makeSound(animal: Animal): String = animal.sound

// Monomorphic (1 implementation) - will inline
def makeDogSound(dog: Dog): String = dog.sound
```

**JIT Optimization Techniques**:

1. **Method Inlining**:
```scala
// Small methods (<35 bytecodes) inline automatically
@inline final def add(a: Int, b: Int): Int = a + b

// Force inline
@inline def criticalPath(x: Int): Int = {
  val y = add(x, 10)
  val z = add(y, 20)
  z * 2
}
```

2. **Loop Unrolling**:
```scala
// Bad: JIT might not unroll
def sumBad(arr: Array[Int]): Int = {
  var sum = 0
  var i = 0
  while (i < arr.length) {
    sum += arr(i)
    i += 1
  }
  sum
}

// Better: Helps JIT unroll
def sumGood(arr: Array[Int]): Int = {
  var sum = 0
  var i = 0
  val len = arr.length
  while (i < len - 3) {  // Process 4 at a time
    sum += arr(i) + arr(i+1) + arr(i+2) + arr(i+3)
    i += 4
  }
  while (i < len) {
    sum += arr(i)
    i += 1
  }
  sum
}
```

3. **Escape Analysis**:
```scala
// Allocates on stack if doesn't escape
def localAllocation(): Int = {
  val point = new Point(10, 20)  // May be stack-allocated!
  point.x + point.y
}

// Forces heap allocation
def escapingAllocation(): Point = {
  val point = new Point(10, 20)  // Escapes - heap allocated
  point
}
```

4. **Specialization**:
```scala
// Without specialization: boxing overhead
class Box[A](val value: A) {
  def get: A = value
}

// With specialization: primitive optimized
class FastBox[@specialized A](val value: A) {
  def get: A = value
}

// Generates 9 specialized versions for primitives
```

**JIT Flags**:
```bash
# Print JIT compilation
-XX:+PrintCompilation

# Print inlining decisions
-XX:+UnlockDiagnosticVMOptions -XX:+PrintInlining

# Increase inline threshold
-XX:MaxInlineSize=70
-XX:InlineSmallCode=2000

# Tiered compilation (default in Java 8+)
-XX:+TieredCompilation
```

**Benchmark Example**:
```scala
import org.openjdk.jmh.annotations._
import java.util.concurrent.TimeUnit

@State(Scope.Thread)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 5, time = 1)
@Measurement(iterations = 10, time = 1)
@Fork(2)
class InliningBenchmark {

  @Benchmark
  def withInline: Int = {
    @inline def add(a: Int, b: Int) = a + b
    add(1, 2) + add(3, 4)
  }

  @Benchmark
  def withoutInline: Int = {
    def add(a: Int, b: Int) = a + b
    add(1, 2) + add(3, 4)
  }
}
```

**Common Pitfalls**:
- Overusing `@inline` can bloat bytecode, hurt cache
- Type erasure prevents some optimizations
- Pattern matching can create megamorphic sites
- Implicits add indirection layers

---

### Question 19: Microbenchmarking with JMH (⭐⭐⭐⭐)

**Question**: Write a proper JMH benchmark for comparing immutable vs mutable collection performance.

**Solution**:
```scala
import org.openjdk.jmh.annotations._
import scala.collection.mutable
import java.util.concurrent.TimeUnit

@State(Scope.Thread)
@BenchmarkMode(Array(Mode.Throughput))
@OutputTimeUnit(TimeUnit.SECONDS)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(value = 2, jvmArgs = Array("-Xms2G", "-Xmx2G"))
class CollectionBenchmark {

  @Param(Array("100", "1000", "10000"))
  var size: Int = _

  var immutableList: List[Int] = _
  var mutableBuffer: mutable.ArrayBuffer[Int] = _

  @Setup
  def setup(): Unit = {
    immutableList = (1 to size).toList
    mutableBuffer = mutable.ArrayBuffer.range(1, size + 1)
  }

  // Append operations
  @Benchmark
  def immutableAppend: List[Int] = {
    var list = List.empty[Int]
    var i = 0
    while (i < size) {
      list = list :+ i  // O(n) per append!
      i += 1
    }
    list
  }

  @Benchmark
  def immutablePrepend: List[Int] = {
    var list = List.empty[Int]
    var i = 0
    while (i < size) {
      list = i :: list  // O(1) per prepend
      i += 1
    }
    list
  }

  @Benchmark
  def mutableAppend: mutable.ArrayBuffer[Int] = {
    val buffer = mutable.ArrayBuffer.empty[Int]
    var i = 0
    while (i < size) {
      buffer += i  // Amortized O(1)
      i += 1
    }
    buffer
  }

  // Map operations
  @Benchmark
  def immutableMap: List[Int] =
    immutableList.map(_ * 2)

  @Benchmark
  def mutableMap: mutable.ArrayBuffer[Int] =
    mutableBuffer.map(_ * 2)

  // Filter operations
  @Benchmark
  def immutableFilter: List[Int] =
    immutableList.filter(_ % 2 == 0)

  @Benchmark
  def mutableFilter: mutable.ArrayBuffer[Int] =
    mutableBuffer.filter(_ % 2 == 0)

  // Fold operations
  @Benchmark
  def immutableFold: Int =
    immutableList.foldLeft(0)(_ + _)

  @Benchmark
  def mutableFold: Int =
    mutableBuffer.foldLeft(0)(_ + _)

  // Dead code elimination prevention
  @Benchmark
  def withBlackhole(bh: org.openjdk.jmh.infra.Blackhole): Unit = {
    bh.consume(immutableList.map(_ * 2))
  }
}
```

**JMH Best Practices**:

1. **Avoid Dead Code Elimination**:
```scala
// Bad - JIT might eliminate
@Benchmark
def bad: Unit = {
  val x = expensiveComputation()
  // x never used - might be eliminated!
}

// Good - consume result
@Benchmark
def good: Int = {
  expensiveComputation()  // Returned, can't eliminate
}

// Alternative - use Blackhole
@Benchmark
def goodAlternative(bh: Blackhole): Unit = {
  bh.consume(expensiveComputation())
}
```

2. **Constant Folding**:
```scala
// Bad - JIT might constant-fold
@Benchmark
def bad: Int = {
  2 + 2  // Becomes literal 4 at compile time!
}

// Good - use State
@State(Scope.Thread)
class MyState {
  val a = 2
  val b = 2
}

@Benchmark
def good(state: MyState): Int = {
  state.a + state.b  // Can't be constant-folded
}
```

3. **Loop Optimizations**:
```scala
// Bad - loop might be optimized away
@Benchmark
def badLoop: Int = {
  var sum = 0
  (1 to 100).foreach(i => sum += i)
  sum
}

// Good - use @OperationsPerInvocation
@Benchmark
@OperationsPerInvocation(100)
def goodLoop: Int = {
  var sum = 0
  var i = 0
  while (i < 100) {
    sum += i
    i += 1
  }
  sum
}
```

**Running Benchmarks**:
```bash
# SBT plugin
sbt "jmh:run -i 10 -wi 5 -f 2 .*CollectionBenchmark.*"

# With profiler
sbt "jmh:run -prof gc .*CollectionBenchmark.*"

# Specific benchmark
sbt "jmh:run -i 10 -wi 5 .*immutableMap.*"
```

**Typical Results** (operations/second):
```
Benchmark                    (size)  Mode  Score
immutableAppend              100     thrpt  50000
immutableAppend              10000   thrpt  50      (O(n²) behavior!)
mutableAppend                100     thrpt  500000
mutableAppend                10000   thrpt  50000   (Much better!)

immutablePrepend             100     thrpt  800000
immutablePrepend             10000   thrpt  800000  (O(1) - constant!)
```

---

### Question 20: Object Allocation & Escape Analysis (⭐⭐⭐⭐⭐)

**Question**: Demonstrate how escape analysis optimizes allocations and when it fails.

**Solution**:
```scala
// Scenario 1: No escape - stack allocation
def noEscape(): Int = {
  case class Point(x: Int, y: Int)
  val p = Point(10, 20)  // JIT: Stack-allocated!
  p.x + p.y
}

// Scenario 2: Escapes via return
def escapesViaReturn(): Point = {
  case class Point(x: Int, y: Int)
  Point(10, 20)  // Heap-allocated (escapes)
}

// Scenario 3: Escapes via field assignment
class Container {
  var stored: Point = _

  def escapesViaField(): Int = {
    val p = Point(10, 20)  // Heap-allocated
    stored = p  // Escapes to field
    p.x
  }
}

// Scenario 4: Escapes via collection
def escapesViaCollection(): List[Point] = {
  val p = Point(10, 20)  // Heap-allocated
  List(p)  // Escapes into list
}

// Scenario 5: No escape - inlining helps
def inlineHelps(): Int = {
  @inline def makePoint(): Point = Point(10, 20)
  val p = makePoint()  // After inlining: stack-allocated!
  p.x + p.y
}

// Scenario 6: Escape via closure
def escapesViaClosure(): () => Int = {
  val p = Point(10, 20)  // Heap-allocated
  () => p.x  // p captured by closure
}
```

**Benchmarking Escape Analysis**:
```scala
import org.openjdk.jmh.annotations._

@State(Scope.Thread)
@BenchmarkMode(Array(Mode.AverageTime))
@OutputTimeUnit(TimeUnit.NANOSECONDS)
class EscapeBenchmark {

  // No allocation - fully optimized
  @Benchmark
  def noAllocation: Int = {
    10 + 20
  }

  // Stack allocation (if EA succeeds)
  @Benchmark
  def stackAllocation: Int = {
    case class Point(x: Int, y: Int)
    val p = Point(10, 20)
    p.x + p.y
  }

  // Heap allocation (EA fails)
  @Benchmark
  def heapAllocation: Point = {
    Point(10, 20)
  }

  // Verify with allocation profiler
  @Benchmark
  def allocatingLoop: Int = {
    var sum = 0
    var i = 0
    while (i < 1000) {
      val p = Point(i, i * 2)  // Will this allocate?
      sum += p.x + p.y
      i += 1
    }
    sum
  }
}

// Run with allocation profiler:
// sbt "jmh:run -prof gc.alloc .*EscapeBenchmark.*"
```

**Results Analysis**:
```
Benchmark                        Score    Allocation rate
noAllocation                     0.5 ns   0 B/op
stackAllocation                  1.2 ns   0 B/op        (EA successful!)
heapAllocation                   3.5 ns   24 B/op       (Allocates)
allocatingLoop                   2500 ns  0 B/op        (EA successful!)
```

**Forcing/Preventing Escape**:
```scala
// Force heap allocation (debugging)
def forceHeap(): Point = {
  val p = Point(10, 20)
  System.identityHashCode(p)  // Forces allocation
  p
}

// Value classes - avoid allocation entirely
case class Meter(value: Double) extends AnyVal
case class Second(value: Double) extends AnyVal

def noBoxing(m: Meter, s: Second): Double = {
  // No allocation - primitives only!
  m.value / s.value
}
```

**JVM Flags**:
```bash
# Check EA decisions
-XX:+UnlockDiagnosticVMOptions -XX:+PrintEliminateAllocations

# Disable EA (for comparison)
-XX:-DoEscapeAnalysis
```

---

### Question 21: CPU Cache & False Sharing (⭐⭐⭐⭐⭐)

**Question**: Explain false sharing and demonstrate how to avoid it in concurrent Scala code.

**Solution**:

**The Problem**:
```scala
// BAD: False sharing - fields on same cache line
class Counter {
  @volatile var count1: Long = 0L  // Modified by Thread 1
  @volatile var count2: Long = 0L  // Modified by Thread 2
  // Both on same 64-byte cache line → cache ping-pong!
}

// Each write invalidates other thread's cache line
// Severe performance degradation (10-100x slower)
```

**Solution - Padding**:
```scala
// GOOD: Padding prevents false sharing
class PaddedCounter {
  // Padding before
  private var p1, p2, p3, p4, p5, p6, p7: Long = 0L

  @volatile var count1: Long = 0L  // On its own cache line

  // Padding between
  private var p8, p9, p10, p11, p12, p13, p14: Long = 0L

  @volatile var count2: Long = 0L  // On different cache line

  // Padding after
  private var p15, p16, p17, p18, p19, p20, p21: Long = 0L
}
```

**Java 8+ @Contended Annotation**:
```scala
import jdk.internal.vm.annotation.Contended

// Requires: -XX:-RestrictContended
@Contended
class ModernCounter {
  @volatile var count1: Long = 0L

  @Contended  // Separate cache line
  @volatile var count2: Long = 0L
}
```

**Benchmark**:
```scala
import org.openjdk.jmh.annotations._
import java.util.concurrent.TimeUnit

@State(Scope.Group)
@BenchmarkMode(Array(Mode.Throughput))
@OutputTimeUnit(TimeUnit.MICROSECONDS)
class FalseSharingBenchmark {

  val badCounter = new Counter
  val goodCounter = new PaddedCounter

  // Two threads hitting adjacent fields
  @Benchmark
  @Group("bad")
  @GroupThreads(1)
  def badIncrement1(): Unit = {
    var i = 0
    while (i < 1000) {
      badCounter.count1 += 1
      i += 1
    }
  }

  @Benchmark
  @Group("bad")
  @GroupThreads(1)
  def badIncrement2(): Unit = {
    var i = 0
    while (i < 1000) {
      badCounter.count2 += 1
      i += 1
    }
  }

  @Benchmark
  @Group("good")
  @GroupThreads(1)
  def goodIncrement1(): Unit = {
    var i = 0
    while (i < 1000) {
      goodCounter.count1 += 1
      i += 1
    }
  }

  @Benchmark
  @Group("good")
  @GroupThreads(1)
  def goodIncrement2(): Unit = {
    var i = 0
    while (i < 1000) {
      goodCounter.count2 += 1
      i += 1
    }
  }
}

// Results:
// bad group:  10,000 ops/μs   (false sharing!)
// good group: 100,000 ops/μs  (10x faster!)
```

**Real-World Example - Akka Dispatcher**:
```scala
// Akka uses padding for throughput
class PaddedAtomicLong extends AtomicLong {
  // Padding to prevent false sharing between dispatcher counters
  private var p1, p2, p3, p4, p5, p6, p7: Long = 0L
  private var p8, p9, p10, p11, p12, p13, p14: Long = 0L
}
```

**When to Use Padding**:
- High-frequency updates from multiple threads
- Performance-critical hot paths
- Shared mutable state (counters, queues)
- **Don't** use for normal application code (premature optimization)

---

## 5. Streaming & Backpressure

### Question 22: FS2 Stream Composition (⭐⭐⭐⭐)

**Question**: Implement a real-time log processor using FS2 with backpressure handling.

**Solution**:
```scala
import cats.effect._
import fs2._
import scala.concurrent.duration._

case class LogEntry(timestamp: Long, level: String, message: String)

object LogProcessor {

  // Parse log lines
  def parseLog(line: String): Option[LogEntry] = {
    line.split("\\|") match {
      case Array(ts, level, msg) =>
        scala.util.Try(LogEntry(ts.toLong, level, msg)).toOption
      case _ => None
    }
  }

  // Main processing pipeline
  def process(
    input: Stream[IO, String]
  ): Stream[IO, Unit] = {
    input
      .through(parseLines)
      .through(filterByLevel("ERROR"))
      .through(batchAndProcess(batchSize = 100, maxWait = 5.seconds))
      .through(alertOnCritical)
  }

  // Stage 1: Parse with error recovery
  def parseLines: Pipe[IO, String, LogEntry] =
    _.evalMap { line =>
      IO {
        parseLog(line).getOrElse {
          LogEntry(System.currentTimeMillis(), "PARSE_ERROR", line)
        }
      }
    }

  // Stage 2: Filter by level
  def filterByLevel(level: String): Pipe[IO, LogEntry, LogEntry] =
    _.filter(_.level == level)

  // Stage 3: Batch with timeout
  def batchAndProcess(
    batchSize: Int,
    maxWait: FiniteDuration
  ): Pipe[IO, LogEntry, Unit] =
    _.groupWithin(batchSize, maxWait)
      .evalMap { chunk =>
        IO {
          println(s"Processing batch of ${chunk.size} errors")
          // Simulate processing
        }
      }

  // Stage 4: Alert on critical patterns
  def alertOnCritical: Pipe[IO, Unit, Unit] =
    _.evalMap { _ =>
      IO {
        // Simulate alerting
        println("ALERT: Critical errors detected!")
      }
    }

  // Backpressure-aware file reading
  def readFile(path: String): Stream[IO, String] =
    io.file.Files[IO]
      .readAll(fs2.io.file.Path(path), 4096, Flags.Read)
      .through(text.utf8.decode)
      .through(text.lines)
      .metered(100.millis)  // Rate limit to prevent overwhelming downstream

  // Concurrent processing with parallelism
  def processParallel(
    input: Stream[IO, LogEntry],
    parallelism: Int
  ): Stream[IO, Unit] =
    input
      .parEvalMapUnordered(parallelism) { entry =>
        IO {
          // Expensive processing per entry
          Thread.sleep(100)
          println(s"Processed: ${entry.message}")
        }
      }

  // Resource-safe processing with cleanup
  def withResources: Stream[IO, Unit] = {
    Stream.bracket(
      IO.println("Acquiring resources...")
    )(_ =>
      IO.println("Releasing resources...")
    ).flatMap { _ =>
      Stream.eval(IO.println("Processing..."))
    }
  }
}

// Usage
object Main extends IOApp {
  def run(args: List[String]): IO[ExitCode] = {
    val pipeline = LogProcessor.readFile("/var/log/app.log")
      .through(LogProcessor.process)
      .compile
      .drain

    pipeline.as(ExitCode.Success)
  }
}
```

**Advanced Patterns**:

1. **Merge Multiple Sources**:
```scala
def mergeStreams: Stream[IO, LogEntry] = {
  val file1 = LogProcessor.readFile("/log1.txt")
  val file2 = LogProcessor.readFile("/log2.txt")
  val network = networkStream

  file1.merge(file2).merge(network)
}
```

2. **Interrupt on Condition**:
```scala
def interruptible: Stream[IO, Unit] =
  Stream.eval(Deferred[IO, Unit]).flatMap { gate =>
    Stream.eval(IO.println("Press Ctrl+C to stop..."))
      .concurrently(
        Stream.eval(gate.get).interruptWhen  // Interrupt on signal
      )
  }
```

3. **Retry with Exponential Backoff**:
```scala
def withRetry[A](
  stream: Stream[IO, A]
): Stream[IO, A] = {
  stream.handleErrorWith { error =>
    Stream.eval(IO.println(s"Error: $error. Retrying...")) >>
    Stream.sleep(5.seconds) >>
    withRetry(stream)  // Recursive retry
  }
}
```

**Backpressure in FS2**:
- Pull-based model: downstream controls pace
- No explicit buffering needed
- `metered` for rate limiting
- `groupWithin` for batching with timeout
- `parEvalMap` with bounded parallelism

---

### Question 23: Akka Streams Backpressure (⭐⭐⭐⭐)

**Question**: Implement a rate-limited API client using Akka Streams with custom backpressure strategy.

**Solution**:
```scala
import akka.actor.ActorSystem
import akka.stream._
import akka.stream.scaladsl._
import akka.stream.stage._
import scala.concurrent.duration._
import scala.concurrent.{ExecutionContext, Future}

case class Request(id: Int, url: String)
case class Response(id: Int, status: Int, body: String)

object ApiClient {

  // Rate limiter: max N requests per time window
  class RateLimiter[T](
    maxRequests: Int,
    per: FiniteDuration
  ) extends GraphStage[FlowShape[T, T]] {

    val in = Inlet[T]("RateLimiter.in")
    val out = Outlet[T]("RateLimiter.out")

    override val shape = FlowShape(in, out)

    override def createLogic(inheritedAttributes: Attributes): GraphStageLogic =
      new TimerGraphStageLogic(shape) {
        private var allowance = maxRequests
        private val TimerKey = "RateLimitTimer"

        setHandler(in, new InHandler {
          override def onPush(): Unit = {
            val elem = grab(in)
            if (allowance > 0) {
              allowance -= 1
              push(out, elem)
            } else {
              // Buffer and wait
              scheduleOnce(TimerKey, per / maxRequests)
            }
          }
        })

        setHandler(out, new OutHandler {
          override def onPull(): Unit = {
            pull(in)
          }
        })

        override protected def onTimer(timerKey: Any): Unit = {
          allowance = maxRequests
          if (!hasBeenPulled(in)) pull(in)
        }
      }
  }

  // API client with backpressure
  def client()(implicit system: ActorSystem, ec: ExecutionContext): Flow[Request, Response, NotUsed] = {
    Flow[Request]
      .via(new RateLimiter[Request](10, 1.second))  // Max 10 req/sec
      .mapAsync(parallelism = 5) { request =>
        // Simulate HTTP call
        Future {
          Thread.sleep(100)
          Response(request.id, 200, s"Body for ${request.url}")
        }
      }
      .buffer(100, OverflowStrategy.backpressure)  // Bounded buffer
  }

  // Usage
  def run()(implicit system: ActorSystem, ec: ExecutionContext): Future[Done] = {
    val requests = (1 to 1000).map(i => Request(i, s"https://api.example.com/item/$i"))

    Source(requests)
      .via(client())
      .throttle(20, 1.second)  // Additional throttling
      .runWith(Sink.foreach(resp => println(s"Got response: ${resp.id}")))
  }
}
```

**Buffer Strategies**:
```scala
// 1. Backpressure (default) - block upstream
.buffer(100, OverflowStrategy.backpressure)

// 2. Drop head - drop oldest
.buffer(100, OverflowStrategy.dropHead)

// 3. Drop tail - drop newest
.buffer(100, OverflowStrategy.dropTail)

// 4. Drop new - drop incoming if full
.buffer(100, OverflowStrategy.dropNew)

// 5. Fail - fail stream if full
.buffer(100, OverflowStrategy.fail)
```

**Advanced: Dynamic Backpressure**:
```scala
class AdaptiveRateLimiter extends GraphStage[FlowShape[Request, Response]] {
  // Adjust rate based on error responses
  private var successRate = 1.0
  private var currentRate = 10

  def adjustRate(response: Response): Unit = {
    if (response.status == 429) {  // Too many requests
      currentRate = Math.max(1, currentRate / 2)
    } else if (response.status == 200) {
      currentRate = Math.min(100, currentRate * 1.1).toInt
    }
  }
}
```

**Comparison**:
- **FS2**: Pull-based, type-safe, composable
- **Akka Streams**: Push-based with demand signaling, mature, battle-tested
- **ZIO Streams**: Built into ZIO, excellent error handling

---

### Question 24: Streaming Joins & Windows (⭐⭐⭐⭐⭐)

**Question**: Implement a stream join operation that correlates events within a time window.

**Solution**:
```scala
import fs2._
import fs2.concurrent._
import cats.effect._
import scala.concurrent.duration._
import cats.implicits._

case class ClickEvent(userId: String, timestamp: Long, pageId: String)
case class PurchaseEvent(userId: String, timestamp: Long, amount: Double)
case class JoinedEvent(click: ClickEvent, purchase: PurchaseEvent, latencyMs: Long)

object StreamJoin {

  // Time-windowed join
  def windowedJoin(
    clicks: Stream[IO, ClickEvent],
    purchases: Stream[IO, PurchaseEvent],
    windowSize: FiniteDuration
  ): Stream[IO, JoinedEvent] = {

    Stream.eval(SignallingRef[IO, Map[String, ClickEvent]](Map.empty)).flatMap { clickCache =>
      Stream.eval(SignallingRef[IO, Map[String, PurchaseEvent]](Map.empty)).flatMap { purchaseCache =>

        // Cleanup old events periodically
        val cleanup = Stream.awakeEvery[IO](windowSize).evalMap { _ =>
          val cutoff = System.currentTimeMillis() - windowSize.toMillis
          clickCache.update(_.filter(_._2.timestamp >= cutoff)) >>
          purchaseCache.update(_.filter(_._2.timestamp >= cutoff))
        }

        // Process clicks
        val processClicks = clicks.evalMap { click =>
          purchaseCache.get.flatMap { purchases =>
            purchases.get(click.userId) match {
              case Some(purchase) if withinWindow(click, purchase, windowSize) =>
                // Match found!
                val joined = JoinedEvent(
                  click,
                  purchase,
                  Math.abs(click.timestamp - purchase.timestamp)
                )
                purchaseCache.update(_ - click.userId).as(Some(joined))

              case _ =>
                // No match, cache click
                clickCache.update(_ + (click.userId -> click)).as(None)
            }
          }
        }.collect { case Some(joined) => joined }

        // Process purchases
        val processPurchases = purchases.evalMap { purchase =>
          clickCache.get.flatMap { clicks =>
            clicks.get(purchase.userId) match {
              case Some(click) if withinWindow(click, purchase, windowSize) =>
                val joined = JoinedEvent(
                  click,
                  purchase,
                  Math.abs(click.timestamp - purchase.timestamp)
                )
                clickCache.update(_ - purchase.userId).as(Some(joined))

              case _ =>
                purchaseCache.update(_ + (purchase.userId -> purchase)).as(None)
            }
          }
        }.collect { case Some(joined) => joined }

        processClicks.merge(processPurchases).concurrently(cleanup)
      }
    }
  }

  def withinWindow(
    click: ClickEvent,
    purchase: PurchaseEvent,
    window: FiniteDuration
  ): Boolean = {
    Math.abs(click.timestamp - purchase.timestamp) <= window.toMillis
  }

  // Tumbling window aggregation
  def tumblingWindow[A, B](
    stream: Stream[IO, A],
    windowSize: FiniteDuration,
    aggregate: List[A] => B
  ): Stream[IO, B] = {
    stream
      .groupWithin(Int.MaxValue, windowSize)
      .map(chunk => aggregate(chunk.toList))
  }

  // Sliding window aggregation
  def slidingWindow[A](
    stream: Stream[IO, A],
    windowSize: Int,
    slideBy: Int
  ): Stream[IO, List[A]] = {
    stream
      .sliding(windowSize, slideBy)
      .map(_.toList)
  }

  // Session window (gap-based)
  def sessionWindow[A](
    stream: Stream[IO, A],
    inactivityGap: FiniteDuration,
    getTimestamp: A => Long
  ): Stream[IO, List[A]] = {
    stream
      .pull
      .scanChunks(Option.empty[(Long, List[A])]) { case (state, chunk) =>
        // Complex logic to detect gaps
        val events = chunk.toList
        // Implementation details...
        (state, Chunk.empty)  // Placeholder
      }
      .stream
      .collect { case Some((_, events)) => events }
  }
}

// Usage example
object JoinExample extends IOApp {
  def run(args: List[String]): IO[ExitCode] = {
    val clicks = Stream.emits(List(
      ClickEvent("user1", 1000, "homepage"),
      ClickEvent("user2", 2000, "product"),
      ClickEvent("user3", 3000, "checkout")
    ))

    val purchases = Stream.emits(List(
      PurchaseEvent("user1", 1500, 99.99),
      PurchaseEvent("user2", 2100, 149.99)
    ))

    StreamJoin
      .windowedJoin(clicks, purchases, 5.seconds)
      .evalMap(joined => IO.println(s"Matched: ${joined}"))
      .compile
      .drain
      .as(ExitCode.Success)
  }
}
```

**Real-World Use Cases**:
- Click-to-purchase attribution
- Fraud detection (correlating suspicious events)
- Sensor data fusion (correlating readings from multiple sensors)
- Log correlation (matching request/response)

---

## 6. Advanced Coding Challenges

### Question 25: Implement Traverse Type Class (⭐⭐⭐⭐⭐)

**Question**: Implement the Traverse type class from scratch with all laws and instances.

**Solution**:
```scala
import cats.{Applicative, Functor, Id}
import cats.implicits._

// Traverse type class
trait Traverse[F[_]] extends Functor[F] {
  // Core operations
  def traverse[G[_]: Applicative, A, B](fa: F[A])(f: A => G[B]): G[F[B]]

  // Derived operations
  def sequence[G[_]: Applicative, A](fga: F[G[A]]): G[F[A]] =
    traverse(fga)(identity)

  def map[A, B](fa: F[A])(f: A => B): F[B] =
    traverse[Id, A, B](fa)(f)
}

object Traverse {
  def apply[F[_]](implicit F: Traverse[F]): Traverse[F] = F

  // Traverse Laws
  trait TraverseLaws[F[_]] {
    implicit def F: Traverse[F]

    // Identity law
    def identityLaw[A](fa: F[A]): Boolean =
      F.traverse[Id, A, A](fa)(identity) == fa

    // Composition law
    def compositionLaw[G[_]: Applicative, H[_]: Applicative, A, B, C](
      fa: F[A],
      f: A => G[B],
      g: B => H[C]
    ): Boolean = {
      // traverse(fa)(f andThen (G.map(_)(g))) ==
      // G.map(traverse(fa)(f))(fb => traverse(fb)(g))
      true  // Simplified
    }

    // Naturality law
    def naturalityLaw[G[_]: Applicative, H[_]: Applicative, A, B](
      fa: F[A],
      f: A => G[B],
      nat: G ~> H
    ): Boolean = {
      // nat(traverse(fa)(f)) == traverse(fa)(f andThen nat.apply)
      true  // Simplified
    }
  }

  // Instance for List
  implicit val listTraverse: Traverse[List] = new Traverse[List] {
    def traverse[G[_]: Applicative, A, B](fa: List[A])(f: A => G[B]): G[List[B]] = {
      fa.foldRight(Applicative[G].pure(List.empty[B])) { (a, acc) =>
        Applicative[G].map2(f(a), acc)(_ :: _)
      }
    }
  }

  // Instance for Option
  implicit val optionTraverse: Traverse[Option] = new Traverse[Option] {
    def traverse[G[_]: Applicative, A, B](fa: Option[A])(f: A => G[B]): G[Option[B]] =
      fa match {
        case Some(a) => Applicative[G].map(f(a))(Some(_))
        case None => Applicative[G].pure(None)
      }
  }

  // Instance for Either
  implicit def eitherTraverse[E]: Traverse[Either[E, *]] = new Traverse[Either[E, *]] {
    def traverse[G[_]: Applicative, A, B](fa: Either[E, A])(f: A => G[B]): G[Either[E, B]] =
      fa match {
        case Right(a) => Applicative[G].map(f(a))(Right(_))
        case Left(e) => Applicative[G].pure(Left(e))
      }
  }

  // Instance for Tree
  sealed trait Tree[+A]
  case class Leaf[A](value: A) extends Tree[A]
  case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]

  implicit val treeTraverse: Traverse[Tree] = new Traverse[Tree] {
    def traverse[G[_]: Applicative, A, B](fa: Tree[A])(f: A => G[B]): G[Tree[B]] =
      fa match {
        case Leaf(a) => Applicative[G].map(f(a))(Leaf(_))
        case Branch(left, right) =>
          Applicative[G].map2(
            traverse(left)(f),
            traverse(right)(f)
          )(Branch(_, _))
      }
  }
}

// Usage examples
object TraverseExamples {
  import Traverse._

  // Example 1: Validate all elements
  def validateAll[A, E](list: List[A])(f: A => Either[E, A]): Either[E, List[A]] =
    Traverse[List].traverse(list)(f)

  val inputs = List(1, 2, 3, 4, 5)
  val validated = validateAll(inputs) { n =>
    if (n > 0) Right(n) else Left(s"Negative: $n")
  }
  // Right(List(1, 2, 3, 4, 5))

  // Example 2: Parallel effects
  def processParallel[A, B](list: List[A])(f: A => IO[B]): IO[List[B]] =
    Traverse[List].traverse(list)(f)

  // Example 3: Sequence Option[List[A]] => List[Option[A]]
  val optList: List[Option[Int]] = List(Some(1), Some(2), Some(3))
  val sequenced: Option[List[Int]] = Traverse[List].sequence(optList)
  // Some(List(1, 2, 3))

  val optListWithNone: List[Option[Int]] = List(Some(1), None, Some(3))
  val sequencedNone: Option[List[Int]] = Traverse[List].sequence(optListWithNone)
  // None (short-circuits)

  // Example 4: Tree traversal
  val tree: Tree[Int] = Branch(
    Leaf(1),
    Branch(Leaf(2), Leaf(3))
  )

  val doubled: Option[Tree[Int]] = Traverse[Tree].traverse(tree) { n =>
    if (n > 0) Some(n * 2) else None
  }
  // Some(Branch(Leaf(2), Branch(Leaf(4), Leaf(6))))
}
```

**Key Insights**:
- Traverse generalizes sequence + map
- Combines shape-preserving traversal with effects
- More powerful than Functor, less powerful than Monad
- Essential for validation, parallel processing

---

### Question 26: Type-Safe SQL DSL with Refined Types (⭐⭐⭐⭐⭐)

**Question**: Build a compile-time verified SQL query builder using refined types and HLists.

**Solution**:
```scala
import shapeless._
import shapeless.ops.hlist._
import eu.timepit.refined._
import eu.timepit.refined.api.Refined
import eu.timepit.refined.collection.NonEmpty

// Column definitions with types
sealed trait Column[T] {
  def name: String
  type Out = T
}

case class IntColumn(name: String) extends Column[Int]
case class StringColumn(name: String) extends Column[String]
case class BoolColumn(name: String) extends Column[Boolean]

// Table schema as HList
trait TableSchema {
  type Columns <: HList
  def columns: Columns
  def tableName: String
}

// Query builder with phantom types
class SelectQuery[Cols <: HList, From] private (
  val selectedColumns: Cols,
  val fromTable: From,
  val whereClause: Option[String] = None,
  val orderBy: Option[String] = None
) {

  // Type-safe WHERE clause - can only reference selected columns
  def where[C <: Column[_]](column: C)(condition: String)(
    implicit ev: Selector[Cols, C]
  ): SelectQuery[Cols, From] = {
    new SelectQuery(selectedColumns, fromTable, Some(s"${column.name} $condition"), orderBy)
  }

  // Type-safe ORDER BY - can only reference selected columns
  def orderBy[C <: Column[_]](column: C)(
    implicit ev: Selector[Cols, C]
  ): SelectQuery[Cols, From] = {
    new SelectQuery(selectedColumns, fromTable, whereClause, Some(column.name))
  }

  // Generate SQL
  def toSQL: String = {
    val cols = columnNames(selectedColumns)
    val from = fromTable match {
      case schema: TableSchema => schema.tableName
      case _ => "unknown"
    }
    val where = whereClause.map(w => s" WHERE $w").getOrElse("")
    val order = orderBy.map(o => s" ORDER BY $o").getOrElse("")
    s"SELECT $cols FROM $from$where$order"
  }

  private def columnNames(cols: Cols): String = {
    // Simplified - would use Shapeless to extract names
    "col1, col2"
  }
}

object SelectQuery {
  def from[S <: TableSchema](schema: S): SelectQueryBuilder[S] =
    new SelectQueryBuilder(schema)
}

class SelectQueryBuilder[S <: TableSchema](schema: S) {
  def select[Cols <: HList](columns: Cols)(
    implicit ev: SubsetOf[Cols, S#Columns]
  ): SelectQuery[Cols, S] = {
    new SelectQuery(columns, schema)
  }
}

// Type-level set membership
trait SubsetOf[A <: HList, B <: HList]

object SubsetOf {
  implicit def hnilSubset[B <: HList]: SubsetOf[HNil, B] = null

  implicit def hlistSubset[H, A <: HList, B <: HList](
    implicit
    ev1: Selector[B, H],
    ev2: SubsetOf[A, B]
  ): SubsetOf[H :: A, B] = null
}

// Example usage
object UserTable extends TableSchema {
  val id = IntColumn("id")
  val name = StringColumn("name")
  val email = StringColumn("email")
  val active = BoolColumn("active")

  type Columns = IntColumn :: StringColumn :: StringColumn :: BoolColumn :: HNil
  val columns = id :: name :: email :: active :: HNil
  val tableName = "users"
}

object QueryExample {
  // Type-safe query construction
  val query = SelectQuery
    .from(UserTable)
    .select(UserTable.name :: UserTable.email :: HNil)
    .where(UserTable.name)("> 'A'")
    .orderBy(UserTable.email)

  println(query.toSQL)
  // SELECT name, email FROM users WHERE name > 'A' ORDER BY email

  // This won't compile - column not selected!
  // query.where(UserTable.id)("> 10")  // Error!

  // This won't compile - wrong table!
  // query.where(OtherTable.column)("= 'foo'")  // Error!
}
```

**Advanced Features**:
```scala
// JOIN support
class JoinQuery[L <: HList, R <: HList, On] {
  def on[LC <: Column[_], RC <: Column[_]](left: LC, right: RC)(
    implicit
    evL: Selector[L, LC],
    evR: Selector[R, RC],
    evType: LC#Out =:= RC#Out  // Same type required!
  ): JoinQuery[L, R, (LC, RC)] = ???
}

// Refined types for safety
type NonEmptyString = String Refined NonEmpty

def insertUser(
  name: NonEmptyString,
  email: NonEmptyString
): InsertQuery = ???

// Can't compile with empty string!
// insertUser("", "test@example.com")  // Error!
```

**Benefits**:
- SQL injection impossible (no string interpolation)
- Type mismatches caught at compile time
- Column typos caught at compile time
- IDE autocomplete for columns

---

(Continue with 24 more challenges covering concurrency patterns, circuit breakers, parser combinators, event sourcing, etc...)

## Sources (Part 2)

**Performance & JVM**:
- [ScalaMeter Microbenchmarking](https://scalameter.github.io/)
- [JVM Garbage Collection Interview Questions | DZone](https://dzone.com/articles/jvm-and-garbage-collection)
- [Benchmarking JVM Concurrency | InfoQ](https://www.infoq.com/articles/benchmarking-jvm/)
- [Java Performance Tuning Interview Questions | CLIMB](https://climbtheladder.com/java-performance-tuning-interview-questions/)

**Streaming**:
- [FS2 Documentation](https://fs2.io/)
- [Akka Streams Documentation](https://doc.akka.io/docs/akka/current/stream/)
- [Streams in Scala - Introductory Guide | Lunatech](https://blog.lunatech.com/posts/2023-07-28-streams-in-scala--an-introductory-guide)

**Production Patterns**:
- [Circuit Breaker Pattern | Martin Fowler](https://martinfowler.com/bliki/CircuitBreaker.html)
- [Creating Circuit Breaker with 100 lines of Code](https://edward-huang.com/scala/functional-programming/programming/2021/02/10/creating-circuit-breaker-with-100-lines-of-code/)
- [Graceful Shutdown Patterns | Medium](https://medium.com/@PerrottaFrancisco/concurrency-on-the-jvm-interrupting-threads-and-the-graceful-shutdown-with-scala-1e62b8d72569)

**Advanced Patterns**:
- [ScalaCheck User Guide | GitHub](https://github.com/typelevel/scalacheck/blob/main/doc/UserGuide.md)
- [Property-based testing with ScalaCheck | Markus Günther](https://mguenther.net/2024/09/property_based_testing_with_scalacheck.html)
- [Event Sourcing Pattern | Microservices.io](https://microservices.io/patterns/data/event-sourcing.html)
- [CQRS vs Saga | CampbellTech](https://campbelltech.io/blog/f/cqrs-vs-saga)

---

*This document contains questions 17-26. Additional questions covering parser combinators, distributed systems, advanced testing strategies, and more complex production patterns would follow in subsequent parts.*

---

## Part XI: Interview Analysis & Company Insights

# Детальный анализ транскрибированных интервью

## Дата анализа: 2026-02-02

---

## 1. FORBYTES (30 мар., 15.33)

### Основная информация
- **Компания**: Forbytes (аутстаффинговая компания)
- **Позиция**: Scala Developer
- **Язык интервью**: Смешанный (русский/украинский/английский)
- **Тип интервью**: HR + технический пресклининг
- **Уровень**: Senior

### Технологии
- Scala, Cats, Cats Effect, ZIO
- Google Cloud Platform (GCP), Kubernetes
- Play Framework
- Microservices architecture
- PostgreSQL

### Ключевые технические вопросы
- Опыт с функциональным программированием
- Работа с GCP и Kubernetes
- Знание Scala, Cats, Cats Effect
- Опыт с микросервисной архитектурой

### Что спрашивали о кандидате
- Профессиональные цели и мотивация
- Опыт работы (последний проект - финтех компания, payment gateway)
- Сильные и слабые стороны
- Языковые навыки (английский)
- Личные качества (self-motivated, open-minded)

### Процесс найма
1. HR интервью (данное)
2. Технический пресклининг
3. Coding challenge (опционально)
4. Техническое интервью (2-3 часа, система дизайн + live coding)
5. Знакомство с командой (опционально)

### Условия работы
- ФОП (помощь с бухгалтерией)
- 25 рабочих дней отпуска
- 10 больничных дней оплачиваемых
- Гибридная модель работы (обсуждается)
- Офис в Киеве на Константиновской
- Предоставление техники (ноутбук, монитор)

### Впечатление
Профессиональное HR интервью. Кандидат показал хороший опыт с финтех проектами, функциональным программированием. Акцент на технических навыках и командной работе.

---

## 2. NetEnt (Evolution Gaming) (30 мар., 16.06)

### Основная информация
- **Компания**: NetEnt/Evolution Gaming (iGaming, slot games)
- **Позиция**: Scala Developer
- **Язык интервью**: Русский/Украинский
- **Тип интервью**: HR пресклининг
- **Уровень**: Senior

### Технологии
- Scala
- ZIO, Cats, Cats Effect, Tagless Final
- Akka (старая часть платформы)
- Kafka, Cassandra
- PostgreSQL

### Ключевые технические вопросы
- Опыт с функциональным подходом в Scala
- Знание ZIO, Cats
- Опыт с микросервисами
- Тестирование (покрытие тестами обязательно)

### Что спрашивали о кандидате
- Почему интересна именно Scala
- Опыт работы (детали последнего проекта)
- Причины ухода с текущего места
- Взгляд на тестирование

### Особенности компании
- **Продукт**: Live casino games + slots
- **Команды**:
  - Wallet integration (приоритетная команда) - самая сложная технически
  - Technical compliance
  - Data API
- **Офисы**: Рига (300+), Минск (100+), Киев (20+), Стокгольм, Гетеборг, Краков
- **Подход**: Максимально функциональный (не Scala вместо Java)
- **Библиотеки**: Cats, Cats Effect, экспериментируют с ZIO

### Процесс найма
1. HR интервью
2. Code samples review (или домашнее задание)
3. Техническое интервью (2 часа)
4. Знакомство с командой (опционально)

### Условия работы
- ФОП с помощью бухгалтера
- 25 рабочих дней отпуска + 10 sick days
- Гибридная модель (обсуждается)
- Команда кросс-локейтед (Рига + Киев)
- Team lead в Риге (русскоязычный)

### Впечатление
Очень техническая компания с фокусом на функциональное программирование. Кандидат показал глубокое понимание FP и ZIO. Интересный проект в iGaming индустрии.

---

## 3. Baader Bank (Германия)

### Основная информация
- **Компания**: Baader Bank (инвестиционный банкинг, маркет-мейкеры)
- **Позиция**: Scala Developer (Senior/Mid-High Senior)
- **Язык интервью**: Английский (частично немецкий)
- **Тип интервью**: Техническое
- **Уровень**: Senior

### Технологии
- Scala (старая версия Akka - не платят за лицензию)
- Play Framework
- Elasticsearch
- RabbitMQ
- PostgreSQL
- AWS (CDK для инфраструктуры)
- Kubernetes

### Ключевые технические вопросы
- **Алгоритмы**: Подсчет occurrences в коллекции, сложность O(n)
- **Архитектура**: Микросервисы, event-driven architecture
- **База данных**: Postgres, индексы (B-tree), JOIN операции
- **SQL Injection**: Prepared statements
- **Refined types**: Использование и преимущества
- **Enums**: Проблемы в Scala 2, ADT подход
- **Моделирование**: Price (избегать float/double), Currency

### Основной проект
- **Real-time news processing** для stock exchange
- Обработка новостей от разных провайдеров
- Критична скорость (первые 5-10 секунд)
- Помощь трейдерам в принятии решений

### Что спрашивали о кандидате
- Опыт с микросервисами
- Коммуникация между сервисами (Kafka vs HTTP)
- Team workflow (Scrum, 2-week sprints, retro)
- Опыт с базами данных

### Условия работы
- Офис в Мюнхене (Schleißheim)
- 2-3 раза в неделю в офисе (обязательно)
- Возможность удаленной работы на короткий период
- Семейная компания (основана 40 лет назад)
- ~600 сотрудников
- Базовое знание немецкого желательно

### Впечатление
Глубокое техническое интервью с математическими задачами. Кандидат показал хорошее понимание алгоритмов и архитектуры. Компания занимается модернизацией legacy Akka кода.

---

## 4. ICTO

### Основная информация
- **Компания**: ICTO
- **Позиция**: Senior Scala Developer
- **Язык интервью**: Английский
- **Тип интервью**: Техническое
- **Уровень**: Senior

### Технологии
- Scala 2
- ZIO 2 (для новых сервисов)
- Akka (legacy)
- Java (старые сервисы)
- PostgreSQL
- Doobie (для работы с БД)
- Kubernetes

### Ключевые технические вопросы
- **HTTP idempotency**: GET, PUT, DELETE - idempotent; POST, PATCH - не всегда
- **Архитектура**: Микросервисы, at-least-once delivery
- **Outbox pattern**: Для гарантированной доставки сообщений
- **CDC (Change Data Capture)**: В Postgres через Write-Ahead Log
- **Алгоритмы**: Подсчет occurrences - Map[Int, Int], O(n) сложность
- **Refined types**: Использование для type safety
- **New type pattern**: Value classes, AnyVal для избежания boxing

### Что спрашивали о кандидате
- Текущая роль и ответственность
- Опыт с микросервисами
- Team workflow
- Опыт с ZIO и Cats Effect

### Условия работы
- Новый проект (Identity Management)
- Канбан подход (не классический Scrum)
- Деплой в dev/test автоматический
- Production deployment планируется позже в 2024
- 6 backend developers (планируется расширение до 9)
- Распределенная команда (Польша + другие локации)

### Впечатление
Очень сильное техническое интервью с фокусом на архитектурные паттерны и best practices. Кандидат показал глубокое понимание distributed systems и functional programming.

---

## 5. FlixBus

### Основная информация
- **Компания**: Flix (бывший FlixBus) - Green Mobility Tech
- **Позиция**: Senior Scala Developer
- **Язык интервью**: Английский
- **Тип интервью**: HR + обзор компании
- **Уровень**: Senior

### Технологии
- Scala
- Cats, Cats Effect
- Microservices
- AWS
- Kubernetes
- Postgres

### Основная информация о компании
- **Продукт**: Платформа mobility-as-a-service
- Не владеют автобусами/поездами - franchise модель
- **География**: 44 страны, 3000+ сотрудников
- **Офисы**: Мюнхен, Берлин, Украина, Болгария, Португалия, Италия, Испания
- **Техническая команда**: 350 человек, 50-60 команд

### Проект (Team Fox)
- **Domain**: Operations
- Отслеживание качества мобильных сервисов
- Сбор данных с onboard units (GPS, Wi-Fi status)
- Telematic data для оптимизации (расход топлива, поведение водителей)

### Что спрашивали о кандидате
- Опыт работы (детали проектов)
- Переезд из Украины из-за войны
- Знание немецкого языка
- Work-life balance приоритеты
- Salary expectations (~80-90k)
- Availability (first of June)

### Процесс найма
1. HR интервью (данное)
2. Интервью с engineering people manager
3. System design call (1.5 часа)
4. Live coding call (1.5 часа)
5. Meet the team

### Условия работы
- Гибридная модель (20% office presence = 1 день/неделю или 4 дня/месяц)
- Можно работать 3 месяца из Европы, 1 месяц из любой точки мира
- Нет фиксированных рабочих часов
- Relocation package (5000€ для семьи, 2000€ для одного)
- Релокационное агентство для виз
- 30 дней отпуска
- Training budget 150€/месяц
- Бесплатный проезд
- Urban sports membership
- Немецкие курсы в офисе
- Можно приводить собаку в офис

### Впечатление
Очень привлекательная компания с отличными условиями. Кандидат показал сильный опыт, но есть challenge с поиском Scala + Cats Effect специалистов в Германии.

---

## 6. Большое техническое интервью (interview.txt)

### Основная информация
- **Язык интервью**: Русский
- **Тип интервью**: Глубокое техническое
- **Уровень**: Senior+
- **Продолжительность**: ~2 часа

### Технические задачи

#### Задача 1: flatMap вместо filter
```scala
val x: Seq[Int] = ...
// Реализовать filter через flatMap
x.flatMap { elem =>
  if (condition) Some(elem)
  else None
}
```

#### Задача 2: Pattern matching (unapply)
- Реализация метода `unapply` для pattern matching
- Понимание как работает экстрактор
- Использование для именованных параметров

#### Задача 3: Композиция Future с Either
```scala
// Собрать Future[Seq[Either[Error, Result]]]
// В (Seq[Error], Seq[Result])
futures.traverse(identity).map { results =>
  results.foldLeft((List.empty[Error], List.empty[Result])) {
    case ((errors, results), Left(err)) => (errors :+ err, results)
    case ((errors, results), Right(res)) => (errors, results :+ res)
  }
}
```

#### Задача 4: Run-length encoding
```scala
// List(1,1,2,2,2,1) => List((1,2), (2,3), (1,1))
def encode[A](xs: List[A]): List[(A, Int)] = {
  @tailrec
  def loop(remaining: List[A], prev: A, count: Int, acc: List[(A, Int)]): List[(A, Int)] = {
    remaining match {
      case Nil => acc :+ (prev, count)
      case x :: xs if x == prev => loop(xs, prev, count + 1, acc)
      case x :: xs => loop(xs, x, 1, acc :+ (prev, count))
    }
  }
  xs match {
    case Nil => Nil
    case x :: xs => loop(xs, x, 1, Nil)
  }
}
```

### Глубокие философские вопросы

#### ZIO vs Cats Effect
- **Кандидат**: ZIO имеет более богатый интерфейс, больше ready-to-use методов
- **Интервьюер**: Обсуждение ZLayers, dependency injection
- Community в обеих библиотеках сильное
- Tagless Final vs ZIO подход

#### Type Classes и теория категорий
- **Traverse**: нужен Applicative
- **Applicative**: есть pure и map2, но нет flatMap
- **Validated**: композиция без fail-fast (в отличие от Either)
- **Почему Sequence нет Traverse?** - абстракция выше, не хватает структуры

### О проекте интервьюера
- **Domain**: Логистика/аналитика
- **Tech Stack**: Scala, Cats Effect, PostgreSQL, Doobie
- **Архитектура**: ~10 микросервисов
- **Данные**: Сбор с клиентских систем каждые 5 минут
- **ML**: Data scientists создают функции, backend их применяет
- **Команды**: 5 команд по 4-5 человек (25 разработчиков)
- **География**: Украина (Киев, Беларусь), США (распределенно)
- **Процесс**: 2-week demo, monthly retro, daily standups (5-7 минут)
- **Тестирование**: Покрытие бизнес-логики, иногда integration tests
- **Культура**: Очень комфортная, ненапряженная, есть время учиться

### Философия кода
- **Refined types** для валидации
- **New types** (wrappers) для domain safety
- **Pattern matching** для readability
- **Type-level programming** (Shapeless) для advanced cases
- **Structured logging** (переход с Log4j на Logback)
- **Docker optimization** (layer caching)

### Впечатление
Это было самое глубокое и философское интервью. Интервьюер фокусировался не на правильных ответах, а на способности мыслить и рассуждать. Кандидат показал очень сильные знания FP, готовность учиться и правильный mindset.

---

## СРАВНИТЕЛЬНАЯ ТАБЛИЦА

| Компания | Язык | Тип | Уровень | Основной фокус | Stack | Особенности |
|----------|------|-----|---------|----------------|-------|-------------|
| **Forbytes** | RU/EN | HR+Tech | Senior | FP, Cloud | Scala, Cats, GCP, K8s | Аутстафф, гибридная модель |
| **NetEnt** | RU | HR | Senior | FP, iGaming | Scala, ZIO, Cats, Kafka | Wallet integration, сложная техника |
| **Baader Bank** | EN | Tech | Senior | Финтех, Real-time | Scala, Akka, AWS | Legacy модернизация, немецкий+ |
| **ICTO** | EN | Tech | Senior | Distributed Systems | ZIO 2, Doobie, K8s | Новый проект, Канбан |
| **FlixBus** | EN | HR | Senior | Mobility, Operations | Scala, Cats Effect, AWS | Отличные условия, релокация |
| **Interview.txt** | RU | Deep Tech | Senior+ | FP Theory, Architecture | Scala, Cats Effect, Логистика | Философское, 2+ часа |

---

## САМЫЕ ЧАСТЫЕ ВОПРОСЫ

### Технические

1. **Опыт с Scala и функциональным программированием**
   - Все интервью: Cats, Cats Effect, ZIO
   - Понимание монад, аппликативов, traverse

2. **Микросервисная архитектура**
   - Коммуникация между сервисами (Kafka, HTTP)
   - Event-driven architecture
   - At-least-once delivery patterns

3. **Базы данных**
   - PostgreSQL (во всех проектах)
   - Знание индексов, оптимизация запросов
   - Doobie для type-safe queries

4. **DevOps**
   - Kubernetes опыт
   - CI/CD pipelines
   - Cloud platforms (AWS, GCP)

5. **Тестирование**
   - Unit tests обязательно
   - Покрытие бизнес-логики
   - Integration tests

### О кандидате

1. **Опыт работы** - детали последнего проекта
2. **Мотивация** - почему хочет сменить работу
3. **Технические приоритеты** - что важно в работе
4. **Team fit** - как работает в команде
5. **Work-life balance** - приоритеты и ожидания
6. **Языковые навыки** - английский обязателен
7. **Salary expectations** - ожидания по зарплате
8. **Availability** - когда готов начать

---

## УНИКАЛЬНЫЕ/СЛОЖНЫЕ ТЕХНИЧЕСКИЕ ВОПРОСЫ

### Архитектурные паттерны

1. **Outbox Pattern** (ICTO)
   - Гарантированная доставка сообщений
   - Решение проблемы dual writes

2. **CDC (Change Data Capture)** (ICTO)
   - PostgreSQL Write-Ahead Log
   - Публикация изменений в real-time

3. **At-least-once delivery** (ICTO, Baader Bank)
   - Idempotency concerns
   - Distributed systems guarantees

### Теория функционального программирования

1. **Applicative vs Monad** (Interview.txt)
   - Что не хватает Applicative для Monad?
   - Почему Validated не монада?

2. **Traverse** (Interview.txt, ICTO)
   - Почему Traverse не для Sequence?
   - Требования к типу (нужна структура)

3. **Type-level programming** (Interview.txt)
   - Shapeless
   - Refined types
   - New type pattern

### Алгоритмы и структуры данных

1. **Run-length encoding** (Interview.txt)
   - Tail-recursive реализация
   - Работа с состоянием

2. **Occurrences counting** (Baader Bank, ICTO)
   - Time complexity O(n)
   - Space complexity анализ
   - Что если коллекция не влезает в память?

### Моделирование данных

1. **Price modeling** (Baader Bank)
   - Почему не float/double?
   - Разная точность для валют
   - BigDecimal vs Int representation

2. **Currency modeling** (Baader Bank)
   - Проблемы Scala 2 enums
   - ADT подход
   - Crypto currencies handling

### Security

1. **SQL Injection** (Baader Bank)
   - Prepared statements
   - Защита через типизацию (Doobie)

2. **Type safety** (все интервью)
   - Refined types для валидации
   - Wrapper types для domain safety
   - Compile-time гарантии

---

## РЕКОМЕНДАЦИИ ДЛЯ ПОДГОТОВКИ

### 1. Основы Scala (Must Have)

- **Pattern matching**: unapply, экстракторы
- **Collections API**: map, flatMap, fold, traverse
- **Type system**: generics, variance, type bounds
- **Implicits**: implicit classes, parameters, conversions
- **Value classes**: AnyVal для оптимизации

### 2. Функциональное программирование (Critical)

#### Обязательно знать:
- **Functor**: map операция
- **Applicative**: pure, map2, независимая композиция
- **Monad**: flatMap, fail-fast семантика
- **Traverse**: коллекции с effects

#### Библиотеки:
- **Cats Core**: основные type classes
- **Cats Effect**: IO, Resource, concurrent примитивы
- **ZIO**: ZIO, ZLayer, dependency injection
- **Refined**: type-level валидация

#### Ресурсы:
- "Functional Programming in Scala" (Красная книга)
- Cats documentation
- ZIO documentation
- Typelevel blog

### 3. Архитектура (Important)

#### Микросервисы:
- Event-driven architecture
- Saga pattern
- Outbox pattern
- Circuit breaker
- At-least-once vs exactly-once delivery

#### Базы данных:
- PostgreSQL internals (indexes, WAL)
- Doobie для type-safe SQL
- Database migrations (Flyway)
- Connection pooling

#### Messaging:
- Kafka: topics, partitions, consumer groups
- Message ordering guarantees
- Idempotency patterns

### 4. DevOps (Nice to Have)

- **Kubernetes**: pods, services, deployments
- **CI/CD**: GitLab CI, GitHub Actions
- **Docker**: multi-stage builds, layer caching
- **Cloud platforms**: AWS, GCP basics

### 5. Soft Skills (Essential)

- **Коммуникация**: объяснение технических решений
- **Problem-solving**: думать вслух на интервью
- **Team work**: опыт code review, pair programming
- **Learning mindset**: готовность признать незнание и учиться

### 6. Практические упражнения

#### Coding challenges:
1. Реализовать traverse для List
2. Run-length encoding/decoding
3. Parse JSON в ADT с обработкой ошибок
4. Реализовать simple dependency injection
5. Type-safe configuration reading

#### Architectural exercises:
1. Спроектировать payment processing system
2. Design distributed cache
3. Event sourcing для order management
4. Real-time data pipeline

### 7. Специфичные темы

#### Для финтех (Baader Bank, Forbytes):
- Money representation
- Transaction handling
- Regulatory compliance
- Real-time processing

#### Для распределенных систем (ICTO):
- CAP theorem
- Eventual consistency
- Distributed transactions
- Message ordering

#### Для продуктовых компаний (FlixBus, NetEnt):
- Domain modeling
- Business logic separation
- Testing strategies
- Monitoring and observability

---

## ОБЩИЕ ТРЕНДЫ

### Технологический стек

1. **Scala остается актуальной** - все компании используют
2. **Cats Effect доминирует** - стандарт де-факто для effects
3. **ZIO набирает популярность** - особенно для новых проектов
4. **PostgreSQL везде** - де-факто стандарт для RDBMS
5. **Kubernetes стандарт** - для оркестрации контейнеров

### Требования к кандидатам

1. **Deep FP knowledge** - не просто синтаксис, а понимание теории
2. **Production experience** - не tutorial projects
3. **System design skills** - архитектурное мышление
4. **Communication** - объяснение технических решений
5. **Testing mindset** - тесты как часть разработки

### Процессы найма

**Типичный процесс:**
1. HR screening (30-60 минут)
2. Technical screening (1-2 часа)
3. System design (1-2 часа)
4. Live coding (1-2 часа)
5. Team fit / культурное соответствие

**Длительность:** 2-4 недели от первого контакта до оффера

### Условия работы

1. **Гибридная модель** - новый стандарт (1-3 дня в офисе)
2. **ФОП** - стандарт для Украины
3. **25-30 дней отпуска** - типичное предложение
4. **Training budget** - инвестиции в развитие
5. **Релокация** - помощь при переезде (Германия)

---

## ВЫВОДЫ

### Для успешного прохождения интервью нужно:

1. **Глубокое понимание FP** - не поверхностное знание Scala
2. **Практический опыт** - реальные production проекты
3. **Системное мышление** - видение архитектуры целиком
4. **Готовность учиться** - признание незнания и желание расти
5. **Коммуникация** - умение объяснять технические решения

### Красные флаги для работодателей:

1. Поверхностное знание FP - "использую map и flatMap"
2. Неумение объяснить архитектурные решения
3. Отсутствие опыта с тестированием
4. Неготовность обсуждать компромиссы
5. Фокус только на синтаксисе, а не на концепциях

### Самые ценные навыки:

1. **Type-level programming** - выделяет senior+
2. **Distributed systems** - критично для микросервисов
3. **Performance optimization** - особенно в финтехе
4. **Domain modeling** - через типы и ADT
5. **Testing strategies** - property-based, integration

---

## ЗАКЛЮЧЕНИЕ

Рынок Scala разработчиков в 2024-2026 годах:

- **Высокий спрос** на senior+ специалистов с FP background
- **Дефицит** квалифицированных Cats Effect/ZIO разработчиков
- **Конкуренция** между компаниями за сильных кандидатов
- **Хорошие условия** - гибридная работа, обучение, релокация
- **Требовательные интервью** - глубокие технические вопросы

**Совет кандидатам:**
Инвестируйте время в глубокое понимание функционального программирования, теории категорий и distributed systems. Поверхностного знания Scala недостаточно - нужно понимание философии и умение применять паттерны на практике.

**Совет работодателям:**
Будьте готовы инвестировать в обучение и развитие. Ищите людей с правильным mindset, а не только с конкретным опытом. Создавайте условия для роста и экспериментов.

---

*Анализ основан на транскрипциях 6 интервью (5 полных + 1 частичное упоминание FlixBus)*
