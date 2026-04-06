# Kotlin Interview Preparation Guide (USA)

Complete guide to preparing for Kotlin developer interviews in the United States.

---

## 📋 Interview Structure in USA

### Round 1: Phone Screen (30-45 min)
- Background questions about your experience
- Basic Kotlin questions
- Why Kotlin? Why this company?
- Salary expectations (often asked early)

### Round 2: Technical Screen (60-90 min)
- Live coding (CoderPad, HackerRank, Codility)
- Medium-difficulty algorithms in Kotlin
- Kotlin/Coroutines questions
- Sometimes a brief system design discussion

### Round 3-5: Onsite / Virtual Onsite (4-6 hours)
- **System Design** (45-60 min)
- **Coding Round 1** (45-60 min) — algorithms
- **Coding Round 2** (45-60 min) — practical/domain-specific
- **Behavioral** (45-60 min)
- **Team Fit / Culture** (30-45 min)
- Sometimes: **Deep Dive** into past projects or Kotlin-specific topics

---

## 🎯 Kotlin Core Questions

### Basic Questions (Junior/Mid)

#### Null Safety
```kotlin
// Kotlin's type system distinguishes nullable and non-nullable types
val nonNull: String = "hello"       // cannot be null
val nullable: String? = null        // can be null

// Safe call operator ?.
val length: Int? = nullable?.length  // null if nullable is null

// Elvis operator ?:
val len: Int = nullable?.length ?: 0  // default value if null

// Not-null assertion !! (avoid in production code)
val forced: Int = nullable!!.length  // throws NPE if null

// Smart cast — compiler tracks null checks
fun process(s: String?) {
    if (s != null) {
        // s is automatically cast to String (non-nullable) here
        println(s.length)
    }
}

// Safe cast as?
val x: Any = "hello"
val s: String? = x as? String   // null if cast fails (no ClassCastException)

// let — idiomatic null handling
nullable?.let { value ->
    // value is non-null here
    println("Length is ${value.length}")
}
```

#### Data Classes
```kotlin
// What does data class provide?
data class User(val name: String, val age: Int)

// 1. equals() and hashCode() based on all constructor properties
// 2. toString() — "User(name=John, age=30)"
// 3. copy() for creating modified copies
// 4. componentN() functions for destructuring
// 5. Structural equality by default

val user = User("John", 30)
val older = user.copy(age = 31)

// Destructuring
val (name, age) = user
println("$name is $age years old")

// Data classes in collections — equality works as expected
val set = setOf(User("John", 30), User("John", 30))
println(set.size) // 1 — same content means same object

// Limitations:
// - Cannot be abstract, open, sealed, or inner
// - Primary constructor must have at least one val/var parameter
// - Properties not in constructor are excluded from generated methods
data class Person(val name: String) {
    var age: Int = 0  // NOT included in equals/hashCode/copy
}
```

#### Sealed Classes and Sealed Interfaces
```kotlin
// Sealed classes restrict class hierarchies — all subclasses known at compile time
sealed class PaymentStatus {
    data object Pending : PaymentStatus()
    data class Completed(val transactionId: String) : PaymentStatus()
    data class Failed(val error: String, val code: Int) : PaymentStatus()
    data class Refunded(val amount: Double) : PaymentStatus()
}

// Exhaustive when — compiler enforces handling all cases
fun handlePayment(status: PaymentStatus): String = when (status) {
    is PaymentStatus.Pending -> "Waiting for payment..."
    is PaymentStatus.Completed -> "Paid: ${status.transactionId}"
    is PaymentStatus.Failed -> "Error ${status.code}: ${status.error}"
    is PaymentStatus.Refunded -> "Refunded $${"%.2f".format(status.amount)}"
    // No else needed — compiler knows all cases are covered
}

// Sealed interface — allows multiple inheritance
sealed interface Error {
    data class NetworkError(val code: Int) : Error
    data class DatabaseError(val query: String) : Error
    data object UnknownError : Error
}

// Sealed classes vs enums:
// - Enums: single instance per type, same constructor for all
// - Sealed: multiple instances, different data per subclass
```

#### Extension Functions
```kotlin
// Add functions to existing classes without inheritance
fun String.isPalindrome(): Boolean =
    this == this.reversed()

println("racecar".isPalindrome()) // true

// Extension functions are resolved statically (at compile time)
open class Shape
class Rectangle : Shape()

fun Shape.getName() = "Shape"
fun Rectangle.getName() = "Rectangle"

fun printName(s: Shape) {
    println(s.getName())  // Always prints "Shape" — resolved by declared type
}
printName(Rectangle())  // "Shape" — NOT "Rectangle"!

// Extension properties
val String.wordCount: Int
    get() = this.trim().split("\\s+".toRegex()).size

println("hello world foo".wordCount) // 3

// Extension functions on nullable types
fun String?.orEmpty(): String = this ?: ""

// Extensions are great for:
// 1. Adding utility methods to types you don't own
// 2. Keeping classes focused — move helpers to extensions
// 3. Domain-specific languages (DSLs)
```

#### Scope Functions (let, run, with, apply, also)
```kotlin
// let — transform and return result; great for nullable handling
val result = "Hello".let { it.length }  // 5

user?.let { u ->
    sendEmail(u.email)
    logAccess(u.id)
}

// run — execute block with `this` as receiver; return result
val greeting = user.run {
    // `this` is user
    "Hello, $name! You are $age years old."
}

// with — non-extension version of run
val description = with(user) {
    "Name: $name, Age: $age"
}

// apply — configure object; returns the object itself
val config = ServerConfig().apply {
    host = "localhost"
    port = 8080
    maxConnections = 100
}

// also — perform side effects; returns the object itself
val numbers = mutableListOf(1, 2, 3).also {
    println("Initial list: $it")
}.also {
    it.add(4)
}

// Quick reference:
// ┌──────────┬─────────────┬──────────────┐
// │ Function │ Object ref  │ Return value │
// ├──────────┼─────────────┼──────────────┤
// │ let      │ it          │ Lambda result│
// │ run      │ this        │ Lambda result│
// │ with     │ this        │ Lambda result│
// │ apply    │ this        │ Context obj  │
// │ also     │ it          │ Context obj  │
// └──────────┴─────────────┴──────────────┘
```

#### val vs var vs const val vs lateinit
```kotlin
val x = 42              // immutable reference, evaluated at runtime
var y = 1               // mutable reference
const val PI = 3.14159  // compile-time constant (only primitives & String)
lateinit var service: UserService  // initialized later (not null, no initial value)

// const val restrictions:
// - Must be top-level or in object/companion object
// - Only String or primitive types
// - No custom getter

// lateinit usage:
// - Only var, not val
// - Only non-nullable, non-primitive types
// - Common in DI frameworks (Spring, Dagger)
// - Check with ::service.isInitialized

// lazy — evaluated once on first access
val expensive: String by lazy {
    println("Computing...")
    "result"
}
// "Computing..." printed only on first access
```

#### Object Declarations and Companion Objects
```kotlin
// Object declaration — singleton
object DatabaseConnection {
    private val connection = createConnection()
    fun query(sql: String): ResultSet = connection.query(sql)
}
// Usage: DatabaseConnection.query("SELECT * FROM users")

// Companion object — associated with a class
class User private constructor(val name: String, val age: Int) {
    companion object {
        // Factory methods
        fun create(name: String, age: Int): User? =
            if (age >= 0) User(name, age) else null

        fun fromJson(json: String): User = TODO()

        // Constants
        const val MIN_AGE = 0
        const val MAX_AGE = 150
    }
}

val user = User.create("John", 30)

// Companion objects can implement interfaces
interface Factory<T> {
    fun create(): T
}

class MyClass {
    companion object : Factory<MyClass> {
        override fun create(): MyClass = MyClass()
    }
}

// Object expressions — anonymous objects (like Java anonymous classes)
val comparator = object : Comparator<String> {
    override fun compare(a: String, b: String): Int = a.length - b.length
}
```

---

### Intermediate Questions (Mid/Senior)

#### Generics: in/out (Variance)
```kotlin
// out = covariant (producer) — like Java's ? extends T
// in = contravariant (consumer) — like Java's ? super T

// Covariant — can read T, cannot write T
interface Producer<out T> {
    fun produce(): T
    // fun consume(item: T) // ERROR — T in "in" position
}

// Contravariant — can write T, cannot read T as T
interface Consumer<in T> {
    fun consume(item: T)
    // fun produce(): T // ERROR — T in "out" position
}

// Invariant — default, can read and write
class MutableBox<T>(var value: T)

// Example: List is covariant (out), MutableList is invariant
val strings: List<String> = listOf("a", "b")
val objects: List<Any> = strings  // OK — List<out T>

// val mutableStrings: MutableList<String> = mutableListOf("a")
// val mutableObjects: MutableList<Any> = mutableStrings  // ERROR — invariant

// Use-site variance (type projection)
fun copy(from: Array<out Any>, to: Array<Any>) {
    for (i in from.indices) {
        to[i] = from[i]
    }
}

// Star projection — when you don't care about the type
fun printAll(list: List<*>) {
    for (item in list) println(item)  // item is Any?
}

// PECS mnemonic still applies:
// Producer = out (Extends)
// Consumer = in (Super)
```

#### Delegates and Delegated Properties
```kotlin
// Class delegation — "composition over inheritance"
interface Repository {
    fun findById(id: Long): User?
    fun save(user: User): User
}

class CachedRepository(
    private val delegate: Repository
) : Repository by delegate {
    private val cache = mutableMapOf<Long, User>()

    // Override only what needs caching
    override fun findById(id: Long): User? =
        cache.getOrPut(id) { delegate.findById(id) ?: return null }
}

// Delegated properties
// lazy — computed on first access
val heavyObject: HeavyObject by lazy { HeavyObject() }

// observable — react to changes
var name: String by Delegates.observable("initial") { prop, old, new ->
    println("$old -> $new")
}

// vetoable — reject changes
var positiveNumber: Int by Delegates.vetoable(0) { _, _, new ->
    new >= 0  // reject negative values
}

// Map delegation — properties from a map
class Config(map: Map<String, Any?>) {
    val host: String by map
    val port: Int by map
    val debug: Boolean by map
}

val config = Config(mapOf(
    "host" to "localhost",
    "port" to 8080,
    "debug" to true
))
println(config.host) // "localhost"

// Custom delegate
class Trimmed {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String = value
    operator fun setValue(thisRef: Any?, property: KProperty<*>, newValue: String) {
        value = newValue.trim()
    }
    private var value: String = ""
}

var input: String by Trimmed()
input = "  hello  "
println(input) // "hello"
```

#### Inline Functions and Reified Type Parameters
```kotlin
// inline — function body is copied to call site (no lambda overhead)
inline fun <T> measureTime(block: () -> T): Pair<T, Long> {
    val start = System.nanoTime()
    val result = block()
    val elapsed = System.nanoTime() - start
    return result to elapsed
}

// Without inline: lambda creates an anonymous class (allocation + invocation overhead)
// With inline: lambda code is inlined at call site — zero overhead

// noinline — exclude specific lambdas from inlining
inline fun doSomething(inlined: () -> Unit, noinline notInlined: () -> Unit) {
    inlined()
    // notInlined can be stored, passed around
    saveLambda(notInlined)
}

// crossinline — lambda cannot use non-local return
inline fun runInTransaction(crossinline block: () -> Unit) {
    val transaction = beginTransaction()
    try {
        block()  // block cannot do `return` from outer function
        transaction.commit()
    } catch (e: Exception) {
        transaction.rollback()
    }
}

// reified — access generic type at runtime (only in inline functions)
inline fun <reified T> parseJson(json: String): T =
    objectMapper.readValue(json, T::class.java)

// Without reified you'd need: parseJson(json, User::class.java)
// With reified: parseJson<User>(json)

inline fun <reified T> isInstance(value: Any): Boolean = value is T

println(isInstance<String>("hello"))  // true
println(isInstance<Int>("hello"))     // false

// reified enables:
// 1. T::class — get KClass
// 2. is T — type checking
// 3. as T — casting
// 4. Java class reference: T::class.java
```

#### Coroutines Basics
```kotlin
import kotlinx.coroutines.*

// Coroutine = lightweight thread (can have millions)
// suspend = function that can be paused and resumed

suspend fun fetchUser(id: Long): User {
    delay(1000)  // non-blocking sleep (suspends, doesn't block thread)
    return User("John", 30)
}

// Launch — fire and forget (returns Job)
fun main() = runBlocking {
    val job = launch {
        val user = fetchUser(1)
        println(user)
    }
    job.join()  // wait for completion
}

// Async — returns a result (returns Deferred<T>)
fun main() = runBlocking {
    val deferred1 = async { fetchUser(1) }
    val deferred2 = async { fetchUser(2) }

    // Both requests run concurrently
    val user1 = deferred1.await()
    val user2 = deferred2.await()
    println("$user1, $user2")
}

// Structured concurrency — parent waits for all children
fun main() = runBlocking {
    // If any child fails, all siblings are cancelled
    launch { fetchUser(1) }
    launch { fetchUser(2) }
    // runBlocking waits for both to complete
}

// withContext — switch coroutine context
suspend fun loadData(): String = withContext(Dispatchers.IO) {
    // Runs on IO thread pool — good for blocking I/O
    File("data.txt").readText()
}
```

#### Sequences (Lazy Evaluation)
```kotlin
// List operations — eager, each creates intermediate collection
val result = listOf(1, 2, 3, 4, 5)
    .map { it * it }         // creates List(1, 4, 9, 16, 25)
    .filter { it > 5 }       // creates List(9, 16, 25)
    .take(2)                  // creates List(9, 16)

// Sequence operations — lazy, element by element
val result2 = listOf(1, 2, 3, 4, 5)
    .asSequence()
    .map { it * it }         // no intermediate collection
    .filter { it > 5 }       // no intermediate collection
    .take(2)                  // stops after finding 2 elements
    .toList()                 // terminal operation triggers evaluation

// Sequences are better when:
// 1. Large collections
// 2. Multiple chained operations
// 3. You only need a subset of results (first, take)

// Creating sequences
val seq1 = sequenceOf(1, 2, 3)
val seq2 = listOf(1, 2, 3).asSequence()
val seq3 = generateSequence(1) { it + 1 }  // infinite: 1, 2, 3, ...
val seq4 = sequence {
    yield(1)
    yieldAll(listOf(2, 3))
    yieldAll(generateSequence(4) { it + 1 })
}

// Fibonacci with sequence
val fibonacci = sequence {
    var a = 0L
    var b = 1L
    while (true) {
        yield(a)
        val next = a + b
        a = b
        b = next
    }
}

fibonacci.take(10).toList() // [0, 1, 1, 2, 3, 5, 8, 13, 21, 34]
```

#### Higher-Order Functions and Lambdas
```kotlin
// Function types
val add: (Int, Int) -> Int = { a, b -> a + b }
val isPositive: (Int) -> Boolean = { it > 0 }

// Higher-order function — takes or returns a function
fun <T> List<T>.customFilter(predicate: (T) -> Boolean): List<T> {
    val result = mutableListOf<T>()
    for (item in this) {
        if (predicate(item)) result.add(item)
    }
    return result
}

listOf(1, -2, 3, -4).customFilter { it > 0 }  // [1, 3]

// Trailing lambda syntax
listOf(1, 2, 3).fold(0) { acc, n -> acc + n }

// Function references
fun isEven(n: Int): Boolean = n % 2 == 0
listOf(1, 2, 3, 4).filter(::isEven)  // [2, 4]

// Method reference
listOf("hello", "WORLD").map(String::lowercase)  // ["hello", "world"]

// Returning functions
fun multiplier(factor: Int): (Int) -> Int = { it * factor }
val triple = multiplier(3)
triple(5)  // 15

// Function composition (not built-in, but easy to create)
infix fun <A, B, C> ((B) -> C).compose(other: (A) -> B): (A) -> C =
    { a -> this(other(a)) }

val doubleAndToString = Int::toString compose { it: Int -> it * 2 }
doubleAndToString(5)  // "10"
```

---

### Advanced Questions (Senior/Staff)

#### Coroutine Internals — How Coroutines Work Under the Hood
```kotlin
// Coroutines compile to state machines via CPS (Continuation Passing Style)

// This suspend function:
suspend fun fetchAndProcess(): String {
    val data = fetchData()        // suspension point 1
    val processed = process(data) // suspension point 2
    return processed
}

// Compiles roughly to a state machine:
// class FetchAndProcess : Continuation {
//     var state = 0
//     var result: Any? = null
//
//     fun invokeSuspend(result: Result<Any?>): Any? {
//         when (state) {
//             0 -> {
//                 state = 1
//                 val outcome = fetchData(this) // pass continuation
//                 if (outcome == COROUTINE_SUSPENDED) return COROUTINE_SUSPENDED
//                 result = outcome
//             }
//             1 -> {
//                 val data = result as Data
//                 state = 2
//                 val outcome = process(data, this)
//                 if (outcome == COROUTINE_SUSPENDED) return COROUTINE_SUSPENDED
//                 result = outcome
//             }
//             2 -> {
//                 return result as String
//             }
//         }
//     }
// }

// Key concepts:
// - Continuation = callback that knows where to resume
// - COROUTINE_SUSPENDED = special value meaning "I'm not done yet"
// - Each suspension point becomes a state in the state machine
// - No thread is blocked — thread is freed when coroutine suspends

// CoroutineContext — a set of elements
// Key elements:
// - Job — lifecycle and cancellation
// - CoroutineDispatcher — which thread(s) to run on
// - CoroutineName — for debugging
// - CoroutineExceptionHandler — uncaught exception handling

val context = Dispatchers.IO + CoroutineName("my-coroutine") + SupervisorJob()

// Dispatchers:
// - Dispatchers.Default — CPU-intensive work (thread pool = number of cores)
// - Dispatchers.IO — blocking I/O (grows up to 64 threads)
// - Dispatchers.Main — UI thread (Android/desktop)
// - Dispatchers.Unconfined — starts in caller thread, resumes in any thread
```

#### Flow — Reactive Streams with Coroutines
```kotlin
import kotlinx.coroutines.flow.*

// Flow = cold asynchronous stream (like Sequence, but async)
fun numberFlow(): Flow<Int> = flow {
    for (i in 1..5) {
        delay(100)
        emit(i)  // emit values
    }
}

// Collecting a flow
suspend fun main() {
    numberFlow()
        .map { it * it }
        .filter { it > 5 }
        .collect { println(it) }  // terminal operator
}

// Flow is cold — nothing runs until collect() is called
// Each collect() starts a fresh execution

// Flow operators
val flow = flowOf(1, 2, 3, 4, 5)
    .map { it * 2 }                     // transform
    .filter { it > 4 }                  // filter
    .take(2)                            // limit
    .onEach { println("Processing $it") } // side effect

// Combining flows
val flow1 = flowOf(1, 2, 3)
val flow2 = flowOf("a", "b", "c")

flow1.zip(flow2) { num, letter -> "$num$letter" }  // "1a", "2b", "3c"

flow1.combine(flow2) { num, letter -> "$num$letter" }
// emits on EVERY update from either flow

flow1.flatMapConcat { num ->
    flowOf("$num-a", "$num-b")
}  // "1-a", "1-b", "2-a", "2-b", "3-a", "3-b"

// StateFlow — hot flow that holds current value (like LiveData)
class UserViewModel {
    private val _state = MutableStateFlow(UiState.Loading)
    val state: StateFlow<UiState> = _state.asStateFlow()

    fun loadUser(id: Long) {
        viewModelScope.launch {
            _state.value = UiState.Loading
            try {
                val user = repository.fetchUser(id)
                _state.value = UiState.Success(user)
            } catch (e: Exception) {
                _state.value = UiState.Error(e.message ?: "Unknown error")
            }
        }
    }
}

// SharedFlow — hot flow for events (no initial value)
class EventBus {
    private val _events = MutableSharedFlow<Event>(
        replay = 0,
        extraBufferCapacity = 64,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )
    val events: SharedFlow<Event> = _events.asSharedFlow()

    suspend fun emit(event: Event) = _events.emit(event)
}

// Flow exception handling
flow {
    emit(1)
    throw RuntimeException("Error!")
    emit(2)
}
.catch { e -> emit(-1) }  // catches upstream errors
.onCompletion { cause ->
    if (cause != null) println("Flow completed with error: $cause")
    else println("Flow completed successfully")
}
.collect { println(it) }  // 1, -1

// flowOn — change upstream dispatcher
fun readFiles(): Flow<String> = flow {
    // This runs on IO dispatcher
    File("data").listFiles()?.forEach { emit(it.readText()) }
}.flowOn(Dispatchers.IO)

// buffer — concurrent collection (producer and collector run concurrently)
flow {
    emit(1); delay(100)
    emit(2); delay(100)
    emit(3); delay(100)
}
.buffer()  // allows producer to run ahead
.collect { value ->
    delay(300)  // slow consumer
    println(value)
}
// Without buffer: ~1200ms total
// With buffer: ~900ms total (producer doesn't wait for consumer)

// conflate — skip intermediate values when collector is slow
flow {
    emit(1); delay(100)
    emit(2); delay(100)
    emit(3); delay(100)
}
.conflate()
.collect { value ->
    delay(300)
    println(value)  // might skip 2
}
```

#### Context Receivers (Kotlin 1.6.20+ experimental)
```kotlin
// Context receivers provide a way to declare that a function requires
// certain context objects — more powerful than extension functions

// Traditional approach — extension function can only have ONE receiver
fun Logger.log(message: String) { /* ... */ }

// Context receivers — multiple implicit receivers
context(Logger, CoroutineScope)
fun fetchAndLog(url: String): Deferred<Response> {
    log("Fetching $url")  // Logger method
    return async {         // CoroutineScope method
        httpClient.get(url)
    }
}

// Usage
with(logger) {
    coroutineScope {
        val response = fetchAndLog("https://api.example.com")
    }
}

// Context receivers for domain modeling
context(TransactionScope)
fun transferMoney(from: Account, to: Account, amount: Money) {
    withdraw(from, amount)    // TransactionScope method
    deposit(to, amount)       // TransactionScope method
    commit()                  // TransactionScope method
}

// Context receivers with classes
context(Clock)
class AuditLog {
    fun record(event: String) {
        val timestamp = now()  // Clock method
        entries.add(Entry(timestamp, event))
    }
}
```

#### Compiler Plugins and KSP (Kotlin Symbol Processing)
```kotlin
// KSP — Kotlin Symbol Processing (successor to KAPT)
// Used for compile-time code generation

// Example: Auto-generate a Builder pattern

// Define annotation
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.SOURCE)
annotation class GenerateBuilder

// Usage
@GenerateBuilder
data class Config(
    val host: String,
    val port: Int,
    val debug: Boolean
)

// KSP Processor generates:
class ConfigBuilder {
    private var host: String? = null
    private var port: Int? = null
    private var debug: Boolean? = null

    fun host(value: String) = apply { host = value }
    fun port(value: Int) = apply { port = value }
    fun debug(value: Boolean) = apply { debug = value }

    fun build(): Config = Config(
        host = host ?: error("host is required"),
        port = port ?: error("port is required"),
        debug = debug ?: false
    )
}

// KSP advantages over KAPT:
// 1. Up to 2x faster — doesn't generate Java stubs
// 2. Kotlin-native — understands Kotlin-specific features
// 3. Incremental processing
// 4. Multiplatform support

// Popular libraries using KSP:
// - Room (Android database)
// - Moshi (JSON)
// - Koin (DI)
// - Hilt is migrating from KAPT to KSP

// Compiler plugins (deeper integration):
// - kotlinx.serialization — generates serializers at compile time
// - Compose compiler — transforms @Composable functions
// - All-open / No-arg — modify class generation (for Spring/JPA)
// - SAM-with-receiver — makes SAM interfaces use receiver syntax
```

#### Type-Safe Builders (DSLs)
```kotlin
// Kotlin's syntax features enable powerful DSLs

// HTML builder example
fun html(block: HtmlBuilder.() -> Unit): String {
    val builder = HtmlBuilder()
    builder.block()
    return builder.build()
}

class HtmlBuilder {
    private val children = mutableListOf<String>()

    fun head(block: HeadBuilder.() -> Unit) {
        val head = HeadBuilder()
        head.block()
        children.add("<head>${head.build()}</head>")
    }

    fun body(block: BodyBuilder.() -> Unit) {
        val body = BodyBuilder()
        body.block()
        children.add("<body>${body.build()}</body>")
    }

    fun build(): String = "<html>${children.joinToString("")}</html>"
}

// Usage — reads like a declarative language
val page = html {
    head {
        title("My Page")
    }
    body {
        h1("Welcome")
        p("This is a paragraph")
        ul {
            li("Item 1")
            li("Item 2")
        }
    }
}

// @DslMarker — restrict scope leaking
@DslMarker
annotation class HtmlDsl

@HtmlDsl
class BodyBuilder { /* ... */ }

@HtmlDsl
class UlBuilder { /* ... */ }

// With @DslMarker, you can't accidentally call body methods inside ul block
// This prevents common DSL bugs

// Ktor routing DSL (real-world example)
fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello, World!")
        }
        route("/api/v1") {
            get("/users") {
                val users = userService.findAll()
                call.respond(users)
            }
            post("/users") {
                val request = call.receive<CreateUserRequest>()
                val user = userService.create(request)
                call.respond(HttpStatusCode.Created, user)
            }
        }
    }
}
```

#### Value Classes (Inline Classes)
```kotlin
// Wraps a single value with zero runtime overhead (in most cases)
@JvmInline
value class UserId(val value: Long)

@JvmInline
value class Email(val value: String) {
    init {
        require(value.contains("@")) { "Invalid email: $value" }
    }

    val domain: String get() = value.substringAfter("@")
}

// Type safety without boxing penalty
fun findUser(id: UserId): User? = TODO()
fun sendEmail(to: Email, subject: String): Unit = TODO()

// Cannot accidentally pass wrong Long:
// findUser(orderId) // compile error if orderId is OrderId, not UserId

// At runtime, UserId is just a Long — no wrapper object allocated
// (except when used as nullable, generic, or interface type)

// Value classes can:
// - Have init blocks
// - Have properties and functions
// - Implement interfaces
@JvmInline
value class Password(private val value: String) : CharSequence by value {
    override fun toString(): String = "Password(***)"  // hide in logs
}
```

---

## 🔄 Coroutines Deep Dive

### Structured Concurrency
```kotlin
// The golden rule: a coroutine's lifetime is bound to its scope

// coroutineScope — fails fast, cancels siblings on failure
suspend fun loadPage(): Page = coroutineScope {
    val header = async { fetchHeader() }
    val content = async { fetchContent() }   // if this fails...
    val footer = async { fetchFooter() }     // ...this is cancelled

    Page(header.await(), content.await(), footer.await())
}

// supervisorScope — failure of one child doesn't cancel siblings
suspend fun loadDashboard(): Dashboard = supervisorScope {
    val weather = async { fetchWeather() }      // can fail independently
    val stocks = async { fetchStocks() }        // keeps running
    val news = async { fetchNews() }            // keeps running

    Dashboard(
        weather = weather.awaitOrNull(),
        stocks = stocks.awaitOrNull(),
        news = news.awaitOrNull()
    )
}

// Helper for supervisorScope
suspend fun <T> Deferred<T>.awaitOrNull(): T? = try { await() } catch (e: Exception) { null }
```

### Cancellation
```kotlin
// Cancellation is cooperative — coroutine must check for it

suspend fun longRunningTask() = coroutineScope {
    val job = launch {
        repeat(1000) { i ->
            // All suspend functions check for cancellation
            delay(100)
            println("Working on $i")
        }
    }

    delay(500)
    job.cancel()            // request cancellation
    job.join()              // wait for completion
    // or: job.cancelAndJoin()
    println("Cancelled!")
}

// CPU-bound work — must check manually
suspend fun cpuIntensiveWork() {
    var i = 0
    while (isActive) {      // check if coroutine is still active
        // heavy computation
        i++
        if (i % 1000 == 0) yield()  // give chance to check cancellation
    }
}

// ensureActive() — throws CancellationException if cancelled
suspend fun process(items: List<Item>) {
    for (item in items) {
        ensureActive()
        processItem(item)
    }
}

// Cleanup with try/finally
suspend fun managedResource() {
    val resource = acquireResource()
    try {
        resource.use()
    } finally {
        // This runs even when cancelled
        // BUT: you cannot call suspend functions here normally
        withContext(NonCancellable) {
            resource.close()  // this suspend function will run
        }
    }
}

// withTimeout — cancel after time limit
suspend fun fetchWithTimeout(): Result<Data> = try {
    withTimeout(5000L) {
        fetchData()
    }.let { Result.success(it) }
} catch (e: TimeoutCancellationException) {
    Result.failure(e)
}

// withTimeoutOrNull — returns null instead of throwing
val result: Data? = withTimeoutOrNull(5000L) {
    fetchData()
}
```

### Exception Handling in Coroutines
```kotlin
// launch — exceptions propagate to parent
val scope = CoroutineScope(SupervisorJob() + Dispatchers.Default)

scope.launch {
    throw RuntimeException("Boom!")
    // Exception propagates up; with regular Job, cancels siblings
    // With SupervisorJob, other children are unaffected
}

// async — exceptions are deferred until await()
val deferred = scope.async {
    throw RuntimeException("Boom!")
}
try {
    deferred.await()  // exception thrown here
} catch (e: RuntimeException) {
    println("Caught: ${e.message}")
}

// CoroutineExceptionHandler — last resort handler
val handler = CoroutineExceptionHandler { _, exception ->
    println("Caught: $exception")
    // Log, report to crash analytics, etc.
}

val scope2 = CoroutineScope(SupervisorJob() + handler)
scope2.launch {
    throw RuntimeException("Handled by handler")
}

// Important: CoroutineExceptionHandler only works on:
// 1. Root coroutines (created directly on scope)
// 2. launch (not async)

// Pattern: Result wrapper for async error handling
sealed class ApiResult<out T> {
    data class Success<T>(val data: T) : ApiResult<T>()
    data class Error(val exception: Throwable) : ApiResult<Nothing>()
}

suspend fun <T> safeApiCall(block: suspend () -> T): ApiResult<T> = try {
    ApiResult.Success(block())
} catch (e: CancellationException) {
    throw e  // NEVER catch CancellationException — re-throw it!
} catch (e: Exception) {
    ApiResult.Error(e)
}
```

### Channels
```kotlin
import kotlinx.coroutines.channels.*

// Channel = pipe for communication between coroutines

// Rendezvous channel (default, capacity = 0)
val channel = Channel<Int>()

launch {
    for (i in 1..5) {
        channel.send(i)  // suspends until receiver is ready
    }
    channel.close()
}

launch {
    for (value in channel) {  // iterates until channel is closed
        println(value)
    }
}

// Buffered channel
val buffered = Channel<Int>(capacity = 10)

// Unlimited channel
val unlimited = Channel<Int>(Channel.UNLIMITED)

// Conflated channel — only keeps the latest value
val conflated = Channel<Int>(Channel.CONFLATED)

// produce — coroutine builder that returns ReceiveChannel
fun CoroutineScope.produceNumbers(): ReceiveChannel<Int> = produce {
    var x = 1
    while (true) {
        send(x++)
        delay(100)
    }
}

// Fan-out — multiple consumers
val producer = produceNumbers()
repeat(3) { consumerId ->
    launch {
        for (msg in producer) {
            println("Consumer $consumerId received $msg")
        }
    }
}

// Fan-in — multiple producers, one consumer
suspend fun produceMessages(channel: SendChannel<String>, name: String) {
    while (true) {
        channel.send("Message from $name")
        delay(100)
    }
}

val channel2 = Channel<String>()
launch { produceMessages(channel2, "producer1") }
launch { produceMessages(channel2, "producer2") }

// Select expression — await multiple suspending operations
select<Unit> {
    channel1.onReceive { value -> println("Channel 1: $value") }
    channel2.onReceive { value -> println("Channel 2: $value") }
    onTimeout(1000L) { println("Timeout!") }
}
```

### Coroutine Testing
```kotlin
import kotlinx.coroutines.test.*

// runTest — automatically advances virtual time
@Test
fun testFetchUser() = runTest {
    val service = UserService(TestDispatcher())

    val user = service.fetchUser(1)

    assertEquals("John", user.name)
    // delay() calls inside are auto-advanced — test runs instantly
}

// advanceTimeBy — control time manually
@Test
fun testDebounce() = runTest {
    val flow = MutableSharedFlow<String>()
    val results = mutableListOf<String>()

    val job = launch {
        flow.debounce(500).collect { results.add(it) }
    }

    flow.emit("a")
    advanceTimeBy(300)
    flow.emit("b")  // "a" should be dropped (debounced)
    advanceTimeBy(600)

    assertEquals(listOf("b"), results)
    job.cancel()
}

// TestDispatcher — control coroutine execution
@Test
fun testConcurrent() = runTest {
    val testDispatcher = StandardTestDispatcher(testScheduler)

    var result = ""
    launch(testDispatcher) { result += "a" }
    launch(testDispatcher) { result += "b" }

    advanceUntilIdle()  // execute all pending coroutines
    assertEquals("ab", result)
}

// UnconfinedTestDispatcher — executes eagerly
@Test
fun testEager() = runTest {
    val unconfined = UnconfinedTestDispatcher(testScheduler)
    var result = ""

    launch(unconfined) { result += "a" }
    // Already executed at this point!
    assertEquals("a", result)
}
```

---

## 🧮 Kotlin Ecosystem

### Ktor (HTTP Framework)
```kotlin
// Ktor — lightweight, coroutine-based web framework by JetBrains

// Server setup
fun main() {
    embeddedServer(Netty, port = 8080) {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                ignoreUnknownKeys = true
            })
        }
        install(StatusPages) {
            exception<NotFoundException> { call, cause ->
                call.respond(HttpStatusCode.NotFound, ErrorResponse(cause.message ?: "Not found"))
            }
            exception<Throwable> { call, cause ->
                call.respond(HttpStatusCode.InternalServerError, ErrorResponse("Internal error"))
            }
        }
        install(Authentication) {
            jwt("auth-jwt") {
                verifier(JwtConfig.verifier)
                validate { credential ->
                    if (credential.payload.getClaim("userId").asLong() != null)
                        JWTPrincipal(credential.payload)
                    else null
                }
            }
        }
        configureRouting()
    }.start(wait = true)
}

// Routing with dependency injection
fun Application.configureRouting() {
    val userService = UserService(UserRepository())

    routing {
        route("/api/v1") {
            // Public endpoints
            post("/login") {
                val credentials = call.receive<LoginRequest>()
                val token = userService.authenticate(credentials)
                    ?: throw UnauthorizedException("Invalid credentials")
                call.respond(TokenResponse(token))
            }

            // Protected endpoints
            authenticate("auth-jwt") {
                route("/users") {
                    get {
                        val users = userService.findAll()
                        call.respond(users)
                    }
                    get("/{id}") {
                        val id = call.parameters["id"]?.toLongOrNull()
                            ?: throw BadRequestException("Invalid ID")
                        val user = userService.findById(id)
                            ?: throw NotFoundException("User $id not found")
                        call.respond(user)
                    }
                    post {
                        val request = call.receive<CreateUserRequest>()
                        val user = userService.create(request)
                        call.respond(HttpStatusCode.Created, user)
                    }
                }
            }
        }
    }
}

// Ktor client — also coroutine-based
val client = HttpClient(CIO) {
    install(ContentNegotiation) { json() }
    install(HttpTimeout) {
        requestTimeoutMillis = 5000
        connectTimeoutMillis = 3000
    }
    install(Logging) {
        level = LogLevel.INFO
    }
}

suspend fun fetchUsers(): List<User> =
    client.get("https://api.example.com/users").body()
```

### Exposed (SQL Framework)
```kotlin
// Exposed — Kotlin SQL framework by JetBrains (two flavors: DSL and DAO)

// Table definition
object Users : Table("users") {
    val id = long("id").autoIncrement()
    val name = varchar("name", 255)
    val email = varchar("email", 255).uniqueIndex()
    val age = integer("age").nullable()
    val createdAt = datetime("created_at").defaultExpression(CurrentDateTime)

    override val primaryKey = PrimaryKey(id)
}

object Orders : Table("orders") {
    val id = long("id").autoIncrement()
    val userId = long("user_id").references(Users.id)
    val total = decimal("total", 10, 2)
    val status = enumerationByName<OrderStatus>("status", 20)

    override val primaryKey = PrimaryKey(id)
}

// DSL approach — type-safe SQL
fun findUsersByAge(minAge: Int): List<UserDto> = transaction {
    Users
        .selectAll()
        .where { Users.age greaterEq minAge }
        .orderBy(Users.name)
        .map { row ->
            UserDto(
                id = row[Users.id],
                name = row[Users.name],
                email = row[Users.email]
            )
        }
}

// Joins
fun getUserOrders(userId: Long): List<OrderDto> = transaction {
    (Users innerJoin Orders)
        .selectAll()
        .where { Users.id eq userId }
        .map { row ->
            OrderDto(
                orderId = row[Orders.id],
                userName = row[Users.name],
                total = row[Orders.total],
                status = row[Orders.status]
            )
        }
}

// Insert
fun createUser(name: String, email: String): Long = transaction {
    Users.insertAndGetId {
        it[Users.name] = name
        it[Users.email] = email
    }.value
}

// DAO approach — entity classes
class UserEntity(id: EntityID<Long>) : LongEntity(id) {
    companion object : LongEntityClass<UserEntity>(Users)

    var name by Users.name
    var email by Users.email
    var age by Users.age
    val orders by OrderEntity referrersOn Orders.userId
}

// Usage
val user = UserEntity.new {
    name = "John"
    email = "john@example.com"
}

val allUsers = UserEntity.find { Users.age greaterEq 18 }
```

### Arrow (Functional Programming)
```kotlin
// Arrow — functional programming library for Kotlin

// Either — error handling without exceptions
sealed class DomainError {
    data class UserNotFound(val id: Long) : DomainError()
    data class ValidationError(val message: String) : DomainError()
    data class DatabaseError(val cause: Throwable) : DomainError()
}

suspend fun findUser(id: Long): Either<DomainError, User> = either {
    val user = userRepo.findById(id)
        ?: raise(DomainError.UserNotFound(id))
    ensure(user.isActive) { DomainError.ValidationError("User is inactive") }
    user
}

// Chaining with either block (like for-comprehension in Scala)
suspend fun processOrder(userId: Long, itemId: Long): Either<DomainError, Order> = either {
    val user = findUser(userId).bind()         // short-circuits on Left
    val item = findItem(itemId).bind()
    val validated = validateOrder(user, item).bind()
    createOrder(validated).bind()
}

// Raise DSL — functional error handling in context
context(Raise<DomainError>)
suspend fun transferMoney(fromId: Long, toId: Long, amount: BigDecimal) {
    val from = findUser(fromId).bind()
    val to = findUser(toId).bind()
    ensure(from.balance >= amount) {
        DomainError.ValidationError("Insufficient funds")
    }
    accountRepo.debit(fromId, amount)
    accountRepo.credit(toId, amount)
}

// Parallel operations with Arrow
suspend fun loadDashboard(userId: Long): Either<DomainError, Dashboard> = either {
    // Run in parallel, collect all errors
    val (profile, orders, notifications) = parZip(
        { findUser(userId).bind() },
        { findOrders(userId).bind() },
        { findNotifications(userId).bind() }
    ) { p, o, n -> Triple(p, o, n) }

    Dashboard(profile, orders, notifications)
}

// Resource management (like Scala's Resource)
suspend fun withDatabaseConnection(block: suspend (Connection) -> Unit) {
    resourceScope {
        val connection = install({ dataSource.connection }) { conn, _ -> conn.close() }
        block(connection)
    }
}
```

### kotlinx.serialization
```kotlin
// kotlinx.serialization — compile-time, multiplatform serialization

@Serializable
data class User(
    val name: String,
    val age: Int,
    @SerialName("email_address")
    val email: String,
    val roles: List<String> = emptyList(),
    @Transient
    val internalId: Long = 0  // excluded from serialization
)

// JSON serialization
val json = Json {
    prettyPrint = true
    ignoreUnknownKeys = true
    encodeDefaults = false
    coerceInputValues = true
}

val user = User("John", 30, "john@example.com", listOf("admin"))
val jsonString = json.encodeToString(user)
val decoded = json.decodeFromString<User>(jsonString)

// Polymorphic serialization
@Serializable
sealed class Event {
    @Serializable
    @SerialName("click")
    data class Click(val x: Int, val y: Int) : Event()

    @Serializable
    @SerialName("keypress")
    data class KeyPress(val key: String) : Event()
}

val event: Event = Event.Click(10, 20)
val eventJson = json.encodeToString(event)
// {"type":"click","x":10,"y":20}

// Custom serializer
object InstantSerializer : KSerializer<Instant> {
    override val descriptor = PrimitiveSerialDescriptor("Instant", PrimitiveKind.STRING)
    override fun serialize(encoder: Encoder, value: Instant) =
        encoder.encodeString(value.toString())
    override fun deserialize(decoder: Decoder): Instant =
        Instant.parse(decoder.decodeString())
}

@Serializable
data class AuditEntry(
    val action: String,
    @Serializable(with = InstantSerializer::class)
    val timestamp: Instant
)

// Advantages over Jackson/Gson:
// 1. Compile-time — no reflection at runtime
// 2. Multiplatform — works on JVM, JS, Native
// 3. Kotlin-native — understands data classes, sealed classes, default values
// 4. Faster — no reflection overhead
```

### Testing: Kotest and MockK
```kotlin
// Kotest — comprehensive testing framework for Kotlin

// String spec — BDD style
class UserServiceTest : StringSpec({
    "should create user with valid data" {
        val service = UserService(FakeUserRepository())
        val user = service.create("John", "john@example.com")
        user.name shouldBe "John"
        user.email shouldBe "john@example.com"
    }

    "should throw on invalid email" {
        val service = UserService(FakeUserRepository())
        shouldThrow<ValidationException> {
            service.create("John", "invalid-email")
        }
    }
})

// FunSpec — traditional style
class CalculatorTest : FunSpec({
    test("addition") {
        Calculator.add(2, 3) shouldBe 5
    }

    context("division") {
        test("normal division") {
            Calculator.divide(10, 2) shouldBe 5
        }
        test("division by zero throws") {
            shouldThrow<ArithmeticException> {
                Calculator.divide(10, 0)
            }
        }
    }
})

// Property-based testing with Kotest
class PropertyTest : StringSpec({
    "string reversal is its own inverse" {
        checkAll<String> { s ->
            s.reversed().reversed() shouldBe s
        }
    }

    "addition is commutative" {
        checkAll(Arb.int(), Arb.int()) { a, b ->
            a + b shouldBe b + a
        }
    }

    "list sort is idempotent" {
        checkAll(Arb.list(Arb.int())) { list ->
            list.sorted().sorted() shouldBe list.sorted()
        }
    }
})

// Kotest matchers — rich assertion library
user.name shouldBe "John"
list shouldContainExactly listOf(1, 2, 3)
list shouldHaveSize 3
string shouldStartWith "Hello"
number shouldBeInRange 1..100
nullable.shouldBeNull()
result.shouldBeInstanceOf<Success>()

// MockK — Kotlin-first mocking library
class OrderServiceTest : FunSpec({
    val userRepo = mockk<UserRepository>()
    val orderRepo = mockk<OrderRepository>()
    val emailService = mockk<EmailService>(relaxed = true)  // relaxed = return defaults
    val service = OrderService(userRepo, orderRepo, emailService)

    beforeTest {
        clearAllMocks()
    }

    test("should create order and send confirmation email") {
        // Arrange
        val user = User(1, "John", "john@example.com")
        coEvery { userRepo.findById(1) } returns user  // coEvery for suspend functions
        coEvery { orderRepo.save(any()) } answers { firstArg() }

        // Act
        val order = service.createOrder(userId = 1, items = listOf(item1, item2))

        // Assert
        order.userId shouldBe 1
        order.items shouldHaveSize 2

        coVerify(exactly = 1) { emailService.sendOrderConfirmation(user.email, any()) }
        coVerify { orderRepo.save(match { it.userId == 1L }) }
    }

    test("should throw when user not found") {
        coEvery { userRepo.findById(any()) } returns null

        shouldThrow<NotFoundException> {
            service.createOrder(userId = 999, items = emptyList())
        }

        coVerify(exactly = 0) { orderRepo.save(any()) }
    }
})

// MockK features for Kotlin:
// - coEvery/coVerify — for suspend functions
// - mockk<T>(relaxed = true) — auto-return defaults
// - slot<T>() — capture arguments
// - every { obj.method() } returnsMany listOf(1, 2, 3) — return sequence
// - spyk(realObject) — partial mock
// - mockkObject(Singleton) — mock object declarations
// - mockkStatic("com.example.UtilsKt") — mock top-level functions
```

---

## 🏗 System Design Questions

### Framework for System Design

#### 1. Clarify Requirements (5 min)
```
- Functional requirements — what should the system do?
- Non-functional requirements — scale, latency, availability?
- Constraints — budget, timeline, team size?
```

#### 2. Back-of-envelope Estimation (5 min)
```
- Traffic: requests/second
- Storage: data size, growth rate
- Bandwidth: read/write ratio
```

#### 3. High-Level Design (10 min)
```
- Core components
- Data flow
- APIs
```

#### 4. Deep Dive (15 min)
```
- Database choice & schema
- Caching strategy
- Scaling approach
- Failure handling
```

#### 5. Wrap Up (5 min)
```
- Trade-offs made
- Future improvements
- Monitoring & alerts
```

### Example: Real-Time Notification System

#### Requirements
```
Functional:
- Send push, email, SMS notifications
- User preference management (opt-in/out per channel)
- Notification templates
- Delivery tracking & retry

Non-functional:
- 10M users
- 1B notifications/day
- < 1s delivery for push notifications
- At-least-once delivery guarantee
- 99.99% availability
```

#### Estimation
```
Write: 1B / (24 * 3600) ≈ 11,500 notifications/sec
Peak: 3x average ≈ 35,000/sec
Storage (1 year): 1B * 365 * 0.5KB ≈ 180TB
```

#### High-Level Design
```
┌─────────┐     ┌──────────────┐     ┌──────────────┐
│ Client  │────▶│ API Gateway  │────▶│ Notification │
└─────────┘     └──────────────┘     │   Service    │
                                     └──────┬───────┘
                                            │
                           ┌────────────────┼────────────────┐
                           │                │                │
                           ▼                ▼                ▼
                    ┌────────────┐   ┌────────────┐   ┌────────────┐
                    │ Push Queue │   │ Email Queue│   │ SMS Queue  │
                    │  (Kafka)   │   │  (Kafka)   │   │  (Kafka)   │
                    └─────┬──────┘   └─────┬──────┘   └─────┬──────┘
                          │                │                │
                          ▼                ▼                ▼
                    ┌────────────┐   ┌────────────┐   ┌────────────┐
                    │ Push Worker│   │Email Worker│   │ SMS Worker │
                    │  (FCM/APNs)│   │ (SendGrid) │   │ (Twilio)  │
                    └────────────┘   └────────────┘   └────────────┘
```

#### Kotlin Implementation Sketch
```kotlin
// Notification service with Kotlin coroutines
class NotificationService(
    private val preferenceRepo: PreferenceRepository,
    private val templateEngine: TemplateEngine,
    private val kafkaProducer: KafkaProducer,
    private val notificationRepo: NotificationRepository
) {
    suspend fun send(request: NotificationRequest): NotificationResult =
        coroutineScope {
            val preferences = preferenceRepo.getForUser(request.userId)
            val rendered = templateEngine.render(request.templateId, request.params)

            val channels = request.channels.filter { preferences.isEnabled(it) }

            val jobs = channels.map { channel ->
                async {
                    val notification = Notification(
                        id = UUID.randomUUID(),
                        userId = request.userId,
                        channel = channel,
                        content = rendered,
                        status = NotificationStatus.PENDING
                    )
                    notificationRepo.save(notification)
                    kafkaProducer.send(channel.topic, notification)
                    notification
                }
            }

            NotificationResult(
                notifications = jobs.awaitAll(),
                skippedChannels = request.channels - channels.toSet()
            )
        }
}
```

### Example: URL Shortener

#### Requirements
```
Functional:
- Shorten long URL -> short URL
- Redirect short URL -> original URL
- Custom short URLs (optional)
- Analytics (optional)

Non-functional:
- 100M URLs created/month
- 10B redirects/month
- 99.9% availability
- < 100ms latency for redirect
```

#### Estimation
```
Write: 100M / (30 * 24 * 3600) ≈ 40 URLs/sec
Read: 10B / (30 * 24 * 3600) ≈ 4000 redirects/sec
Read:Write ratio = 100:1

Storage (5 years):
- 100M * 12 * 5 = 6B URLs
- Each URL: ~500 bytes (short + long + metadata)
- Total: 6B * 500B = 3TB
```

#### High-Level Design
```
┌─────────┐     ┌──────────────┐     ┌──────────┐
│ Client  │────▶│ Load Balancer│────▶│ App Server│
└─────────┘     └──────────────┘     └────┬─────┘
                                          │
                    ┌─────────────────────┼─────────────────────┐
                    │                     │                     │
                    ▼                     ▼                     ▼
              ┌──────────┐         ┌──────────┐         ┌──────────┐
              │  Cache   │         │ Database │         │ Key Gen  │
              │ (Redis)  │         │(Postgres)│         │ Service  │
              └──────────┘         └──────────┘         └──────────┘
```

#### Key Generation in Kotlin
```kotlin
// Base62 encoding of auto-increment ID
object Base62 {
    private const val CHARS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"

    fun encode(id: Long): String {
        require(id >= 0) { "ID must be non-negative" }
        if (id == 0L) return CHARS[0].toString()

        return buildString {
            var n = id
            while (n > 0) {
                append(CHARS[(n % 62).toInt()])
                n /= 62
            }
            reverse()
        }
    }

    fun decode(shortCode: String): Long =
        shortCode.fold(0L) { acc, c ->
            acc * 62 + CHARS.indexOf(c)
        }
}

// URL shortener service
class UrlShortenerService(
    private val urlRepo: UrlRepository,
    private val cache: RedisCache,
    private val idGenerator: DistributedIdGenerator
) {
    suspend fun shorten(originalUrl: String): ShortUrl {
        val id = idGenerator.nextId()
        val shortCode = Base62.encode(id)
        val shortUrl = ShortUrl(shortCode, originalUrl)
        urlRepo.save(shortUrl)
        cache.set(shortCode, originalUrl, ttl = 24.hours)
        return shortUrl
    }

    suspend fun resolve(shortCode: String): String? {
        // Check cache first
        cache.get(shortCode)?.let { return it }

        // Cache miss — check database
        val url = urlRepo.findByCode(shortCode) ?: return null
        cache.set(shortCode, url.originalUrl, ttl = 24.hours)
        return url.originalUrl
    }
}
```

---

## 🗣 Behavioral Questions (STAR Format)

### STAR Method
- **S**ituation — context
- **T**ask — your responsibility/role
- **A**ction — what you specifically did
- **R**esult — measurable outcome

### Example Answers

#### "Tell me about a challenging project"
```
S: At a fintech company, we needed to migrate a Spring Boot monolith to
   Kotlin microservices with coroutines under 24/7 load with zero downtime.

T: I was the tech lead responsible for architecture decisions and
   coordinating a team of 5 engineers.

A: - Designed a strangler fig migration strategy with API gateway routing
   - Built shared Kotlin libraries for common patterns (error handling, auth)
   - Implemented coroutine-based services with Ktor for 3x throughput
   - Set up canary deployments — 1% traffic first, gradually increased
   - Organized weekly knowledge-sharing sessions on Kotlin/coroutines

R: - Migration completed in 4 months instead of expected 8
   - Zero downtime — no customer-facing incidents
   - P95 latency reduced by 60% (coroutines vs thread-per-request)
   - Team fully onboarded to Kotlin — voluntary adoption in other teams
```

#### "Time when you disagreed with your manager"
```
S: Manager wanted to use a NoSQL database for an event-sourcing system
   because of "faster writes."

T: I needed to either agree or present technical evidence for
   an alternative approach.

A: - Ran benchmarks: PostgreSQL with JSONB vs MongoDB for our write patterns
   - Showed that PostgreSQL JSONB was within 5% of MongoDB for our workload
   - Highlighted consistency guarantees we'd lose with MongoDB
   - Proposed compromise: PostgreSQL for event store, Redis for read projections
   - Presented findings in a 20-minute tech talk with the team

R: - Manager agreed to PostgreSQL-based approach
   - Saved months of complexity dealing with eventual consistency
   - Our event store handled 50K events/sec in production
   - Approach became a template for other teams
```

#### "Biggest failure and what you learned"
```
S: Introduced Kotlin coroutines into a critical payment service without
   sufficient understanding of structured concurrency. A missed exception
   in an async block caused silent payment failures for ~2 hours.

T: Needed to quickly identify the root cause, restore the service,
   and prevent recurrence.

A: - Identified the issue: uncaught exception in async without SupervisorJob
   - Deployed hotfix within 30 minutes — added proper exception handling
   - Wrote comprehensive post-mortem with timeline and root cause
   - Created team guidelines for coroutine error handling patterns
   - Added integration tests that verify exception propagation
   - Set up alerts on payment completion rate drops

R: - Recovered $23K in failed payments through manual reconciliation
   - Created "Kotlin Coroutines Best Practices" doc adopted company-wide
   - Implemented monitoring dashboard that caught 3 similar issues early
   - Never had another silent failure in the payment system
```

#### "Tell me about a time you mentored someone"
```
S: A junior developer joined our team with Java experience but no
   Kotlin knowledge. They were assigned to build a new microservice.

T: As the senior Kotlin developer, I was asked to mentor them and
   ensure the project stayed on track.

A: - Created a 2-week Kotlin onboarding curriculum with daily exercises
   - Paired programmed 2 hours/day during the first week
   - Reviewed every PR with detailed explanations of idiomatic Kotlin
   - Shared resources: Kotlin Koans, official docs, Arrow tutorials
   - Gradually reduced pairing as their confidence grew

R: - Developer was writing idiomatic Kotlin within 3 weeks
   - Microservice delivered on time with high code quality
   - Developer presented "Kotlin for Java Developers" at team meeting
   - They became a Kotlin advocate and helped onboard the next hire
```

---

## 💰 Salary Data 2025-2026

### Kotlin Developer Salaries (USA, Total Compensation)

#### By Level
```
┌──────────────┬─────────────────┬──────────────────┬───────────────────┐
│ Level        │ Base Salary     │ Total Comp (TC)  │ Notes             │
├──────────────┼─────────────────┼──────────────────┼───────────────────┤
│ Junior       │ $80K - $110K    │ $90K - $130K     │ 0-2 years exp     │
│ Mid-Level    │ $110K - $150K   │ $130K - $180K    │ 2-5 years exp     │
│ Senior       │ $150K - $200K   │ $170K - $250K    │ 5-8 years exp     │
│ Staff        │ $190K - $260K   │ $250K - $400K+   │ 8+ years exp      │
│ Principal    │ $230K - $300K   │ $350K - $550K+   │ 12+ years exp     │
└──────────────┴─────────────────┴──────────────────┴───────────────────┘
```

#### By Location
```
┌───────────────────┬─────────────┬───────────────────────────────────┐
│ Location          │ Multiplier  │ Senior TC Range                   │
├───────────────────┼─────────────┼───────────────────────────────────┤
│ SF Bay Area       │ 1.0x        │ $200K - $350K                     │
│ NYC               │ 0.95x       │ $190K - $330K                     │
│ Seattle           │ 0.95x       │ $190K - $330K                     │
│ Boston            │ 0.85x       │ $170K - $300K                     │
│ Austin            │ 0.80x       │ $160K - $280K                     │
│ Denver/Boulder    │ 0.80x       │ $160K - $280K                     │
│ Chicago           │ 0.78x       │ $155K - $270K                     │
│ Remote (US)       │ 0.85x       │ $170K - $300K                     │
│ Midwest/South     │ 0.70x       │ $140K - $250K                     │
└───────────────────┴─────────────┴───────────────────────────────────┘
```

#### By Company Type
```
┌─────────────────────┬──────────────────┬──────────────────────────┐
│ Company Type        │ Senior TC Range  │ Notes                    │
├─────────────────────┼──────────────────┼──────────────────────────┤
│ FAANG / Big Tech    │ $250K - $450K+   │ Significant equity comp  │
│ Unicorn Startup     │ $200K - $350K    │ Higher equity risk/reward│
│ Fintech             │ $200K - $350K    │ Strong Kotlin adoption   │
│ Mid-size Tech       │ $170K - $280K    │ Good WLB typically       │
│ Enterprise          │ $150K - $250K    │ More stable, lower TC    │
│ Early Startup       │ $120K - $200K    │ Equity-heavy comp        │
│ Consultancy         │ $140K - $220K    │ Hourly rates: $80-$180/hr│
└─────────────────────┴──────────────────┴──────────────────────────┘
```

### Negotiation Tips
- Don't name a number first if possible
- If asked: "Based on my research and experience, I'm targeting total compensation in the $X-Y range"
- Always negotiate — first offer is rarely final
- Consider total comp: base + bonus + equity + benefits + PTO
- Kotlin expertise commands premium over Java-only (10-20% depending on market)
- Remote positions have widened salary bands significantly

---

## 🏢 Companies Using Kotlin Server-Side

### Big Tech
```
┌───────────────────┬──────────────────────────────────────────────────┐
│ Company           │ Kotlin Usage                                     │
├───────────────────┼──────────────────────────────────────────────────┤
│ Google            │ Android, server-side services, internal tools    │
│ Square / Block    │ Primary language for backend services             │
│ Netflix           │ Microservices, data engineering pipelines         │
│ Amazon            │ AWS SDK for Kotlin, internal services             │
│ JetBrains         │ Creator of Kotlin; all products use Kotlin       │
│ Meta              │ Android apps, some backend services               │
│ Uber              │ Android, backend microservices                    │
│ Pinterest         │ Server-side Kotlin with coroutines                │
│ Atlassian         │ Backend services, Jira/Confluence plugins         │
│ Slack             │ Android and backend services                      │
│ Airbnb            │ Android, migrating backend services               │
│ DoorDash          │ Backend services with Kotlin + Spring Boot        │
└───────────────────┴──────────────────────────────────────────────────┘
```

### Fintech & Banking
```
┌───────────────────┬──────────────────────────────────────────────────┐
│ Company           │ Kotlin Usage                                     │
├───────────────────┼──────────────────────────────────────────────────┤
│ Cash App (Block)  │ Full-stack Kotlin (server + Android)             │
│ Revolut           │ Microservices with Spring Boot + Kotlin           │
│ N26               │ Backend services in Kotlin                        │
│ Robinhood         │ Backend services, trading platform                │
│ Stripe            │ Internal tooling, some services                   │
│ Goldman Sachs     │ Trading platforms, internal tools                 │
│ Capital One       │ Microservices migration from Java                 │
│ JP Morgan         │ Trading and risk systems                          │
└───────────────────┴──────────────────────────────────────────────────┘
```

### Startups & Mid-Size
```
┌───────────────────┬──────────────────────────────────────────────────┐
│ Company           │ Kotlin Usage                                     │
├───────────────────┼──────────────────────────────────────────────────┤
│ Gradle            │ Build tool written in Kotlin                      │
│ Corda (R3)        │ Blockchain platform written in Kotlin             │
│ Trello            │ Backend services                                  │
│ Basecamp          │ Android and server-side                           │
│ Kickstarter       │ Android and backend                               │
│ Allegro           │ Microservices platform                            │
│ Shazam            │ Backend services                                  │
│ Pivotal/VMware    │ Spring framework Kotlin support                   │
└───────────────────┴──────────────────────────────────────────────────┘
```

### Why Companies Choose Kotlin
```
1. Java interoperability — incremental migration from Java
2. Null safety — reduces production NPEs by 80%+ (Google's data)
3. Coroutines — better concurrency model than threads
4. Conciseness — 30-40% less code than Java
5. Developer happiness — consistently ranked top in surveys
6. JetBrains backing — strong tooling and IDE support
7. Spring Boot support — first-class Kotlin integration
8. Multiplatform potential — share code across platforms
```

---

## 📖 Preparation Resources

### Kotlin / Coroutines
- **"Kotlin in Action" (2nd Edition)** — updated for Kotlin 2.0, must read
- **"Kotlin Coroutines: Deep Dive"** by Marcin Moskala — the definitive coroutines book
- **"Effective Kotlin"** by Marcin Moskala — best practices
- **Kotlin Koans** — official interactive exercises (play.kotlinlang.org)
- **JetBrains Academy** — structured Kotlin courses
- **Rock the JVM** — Kotlin video courses

### Arrow / Functional Kotlin
- **Arrow documentation** — arrow-kt.io
- **"Functional Programming in Kotlin"** by Marco Vermeulen et al.
- **Arrow GitHub examples** — practical code samples

### Algorithms
- **LeetCode** — Medium level is sufficient (150-200 problems)
- **"Cracking the Coding Interview"**
- **NeetCode.io** — structured roadmap
- Use Kotlin for all solutions — practice idiomatic syntax under pressure

### System Design
- **"Designing Data-Intensive Applications"** (DDIA) — must read
- **System Design Primer** (GitHub)
- **Grokking System Design** — course
- **ByteByteGo** — YouTube channel

### Behavioral
- **STAR Method** — search for examples
- Prepare 5-7 stories, adapt to questions

---

## ✅ Pre-Interview Checklist

### One Week Before
- [ ] Research company, product, tech stack
- [ ] Solve 10-15 LeetCode Medium problems in Kotlin
- [ ] Review Kotlin basics: null safety, coroutines, collections, extensions
- [ ] Prepare 5 STAR stories
- [ ] Review coroutine patterns: structured concurrency, exception handling, Flow

### Day Before
- [ ] Get a good night's sleep!
- [ ] Set up workspace (camera, microphone, lighting)
- [ ] Open IDE with Kotlin project ready
- [ ] Have water nearby

### During Coding Interview
- [ ] Clarify requirements before coding
- [ ] Think out loud — explain your thoughts
- [ ] Start with brute force, then optimize
- [ ] Use Kotlin idioms: scope functions, extension functions, data classes
- [ ] Test your code verbally
- [ ] Ask for hints if stuck (it is OK!)

### During System Design
- [ ] Clarify requirements (5 min)
- [ ] Make estimations
- [ ] Draw high-level design first
- [ ] Deep dive on 1-2 components
- [ ] Discuss trade-offs
- [ ] Mention Kotlin-specific advantages where relevant (coroutines for async, Flow for streaming)

---

## 📝 Exercise File Index

### 728 Exercises Across 19 Categories

```
┌────┬─────────────────────────────────────────┬───────────┬────────────────────┐
│ #  │ Category                                │ Exercises │ Difficulty         │
├────┼─────────────────────────────────────────┼───────────┼────────────────────┤
│ 01 │ Kotlin Basics & Null Safety             │ 45        │ Beginner           │
│ 02 │ Data Classes & Sealed Classes           │ 38        │ Beginner-Inter     │
│ 03 │ Extension Functions & Scope Functions   │ 42        │ Beginner-Inter     │
│ 04 │ Collections & Sequences                 │ 55        │ Intermediate       │
│ 05 │ Generics & Variance (in/out)            │ 35        │ Intermediate       │
│ 06 │ Delegation & Delegated Properties       │ 30        │ Intermediate       │
│ 07 │ Inline, Reified & Value Classes         │ 28        │ Inter-Advanced     │
│ 08 │ Functional Programming Patterns         │ 40        │ Intermediate       │
│ 09 │ Coroutines Fundamentals                 │ 50        │ Intermediate       │
│ 10 │ Coroutines Advanced (Channels, Select)  │ 45        │ Advanced           │
│ 11 │ Flow & Reactive Streams                 │ 48        │ Advanced           │
│ 12 │ Exception Handling & Error Modeling      │ 32        │ Intermediate       │
│ 13 │ Ktor (Server & Client)                  │ 42        │ Inter-Advanced     │
│ 14 │ Exposed (Database)                      │ 35        │ Intermediate       │
│ 15 │ Arrow (Functional Programming)          │ 38        │ Advanced           │
│ 16 │ kotlinx.serialization                   │ 28        │ Intermediate       │
│ 17 │ Testing (Kotest, MockK, Coroutine Test) │ 40        │ Inter-Advanced     │
│ 18 │ System Design & Architecture            │ 32        │ Advanced           │
│ 19 │ LeetCode in Kotlin (Top 75)             │ 25        │ Mixed              │
├────┼─────────────────────────────────────────┼───────────┼────────────────────┤
│    │ TOTAL                                   │ 728       │                    │
└────┴─────────────────────────────────────────┴───────────┴────────────────────┘
```

### Category Details

#### 01 — Kotlin Basics & Null Safety (45 exercises)
```
001. val vs var — immutability quiz
002. Null safety operators: ?. ?: !! as?
003. Smart casting with is and as
004. String templates and raw strings
005. when expression — exhaustive matching
006. Range expressions and progressions
007. Type aliases and type checking
008. Nothing type — functions that never return
009. Unit vs Nothing vs Any
010. Destructuring declarations
011. Operator overloading basics
012. Infix functions
013. Vararg parameters and spread operator
014. Named and default arguments
015. Local functions and closures
016-045. Progressive exercises combining concepts
```

#### 02 — Data Classes & Sealed Classes (38 exercises)
```
001. Define data class with validation in init block
002. copy() with nested data classes
003. Sealed class hierarchy for API responses
004. Sealed interface with multiple inheritance
005. Enum vs sealed class trade-offs
006. data object for singletons in sealed hierarchies
007. Implement equals/hashCode manually vs data class
008. Destructuring with componentN functions
009. Abstract sealed class with shared behavior
010. Recursive sealed class (expression tree)
011-038. Domain modeling exercises with sealed hierarchies
```

#### 03 — Extension Functions & Scope Functions (42 exercises)
```
001. Write extension function on String
002. Extension property with backing logic
003. Extension on nullable type (String?.orEmpty)
004. Scope function selection: let vs run vs apply vs also
005. Builder pattern with apply
006. Null-safe chain with let
007. Logging with also (non-intrusive side effects)
008. Object configuration with run
009. Generic extension functions
010. Extension functions on companion objects
011. @DslMarker for type-safe builders
012-042. Practical DSL-building and utility extensions
```

#### 04 — Collections & Sequences (55 exercises)
```
001. map, filter, flatMap basics
002. groupBy, associateBy, partition
003. fold vs reduce vs aggregate
004. zip, unzip, windowed, chunked
005. Sequence vs List performance comparison
006. Infinite sequences with generateSequence
007. Custom sequence with sequence { yield() }
008. Collection performance: List vs Set vs Map
009. sortedBy, sortedWith custom comparators
010. distinctBy, takeWhile, dropWhile
011. buildList, buildMap, buildSet builders
012. Nested collection flattening
013. Collection transformation chains
014-055. Algorithm exercises using collection operations
```

#### 05 — Generics & Variance (35 exercises)
```
001. Generic function with type parameter
002. Generic class with upper bound <T : Comparable<T>>
003. Covariance (out) with Producer interface
004. Contravariance (in) with Consumer interface
005. Use-site variance (type projection)
006. Star projection (*)
007. Reified type parameters in inline functions
008. Generic constraints: where T : A, T : B
009. Type erasure and its implications
010. Variance in collection types (List vs MutableList)
011-035. Design exercises with generic APIs
```

#### 06 — Delegation & Delegated Properties (30 exercises)
```
001. Class delegation with by keyword
002. lazy delegate implementation
003. observable delegate for state tracking
004. vetoable delegate for validation
005. Map-backed delegate for configuration
006. Custom ReadWriteProperty delegate
007. Delegation vs inheritance trade-offs
008. Delegated property for SharedPreferences (Android)
009. Thread-safe lazy initialization
010. Delegate that logs property access
011-030. Real-world delegation patterns
```

#### 07 — Inline, Reified & Value Classes (28 exercises)
```
001. Inline function to avoid lambda allocation
002. noinline and crossinline usage
003. Reified type parameter for JSON parsing
004. Reified type check (is T)
005. Value class for type-safe IDs
006. Value class with validation
007. Value class implementing interface
008. Inline function with multiple lambda parameters
009. Performance benchmark: inline vs non-inline
010. Contract function with callsInPlace
011-028. Advanced inline and value class patterns
```

#### 08 — Functional Programming Patterns (40 exercises)
```
001. Higher-order functions
002. Function composition
003. Currying and partial application
004. Monad-like chaining with Result
005. Functor pattern (map over container)
006. Applicative pattern (zip/combine)
007. Railway-oriented programming with Result
008. Memoization with function caching
009. Trampolining for stack-safe recursion
010. Church encoding in Kotlin
011. Free monad-like pattern
012. Reader pattern for dependency injection
013-040. Practical FP exercises
```

#### 09 — Coroutines Fundamentals (50 exercises)
```
001. First coroutine with runBlocking
002. launch vs async
003. suspend function basics
004. withContext and dispatcher switching
005. Structured concurrency principles
006. Job lifecycle: New, Active, Completing, Completed, Cancelled
007. Coroutine cancellation and isActive
008. withTimeout and withTimeoutOrNull
009. coroutineScope vs supervisorScope
010. Dispatchers: Default, IO, Main, Unconfined
011. Coroutine naming for debugging
012. yield() for cooperative cancellation
013. NonCancellable for cleanup
014. Concurrent decomposition pattern
015. Sequential vs parallel execution
016-050. Progressive coroutine exercises
```

#### 10 — Coroutines Advanced (45 exercises)
```
001. Channel basics: send and receive
002. Buffered vs rendezvous vs conflated channels
003. Producer-consumer with produce builder
004. Fan-out pattern (multiple consumers)
005. Fan-in pattern (multiple producers)
006. select expression for multiple channels
007. Mutex for shared mutable state
008. Actor pattern with channels
009. Semaphore for resource limiting
010. Custom CoroutineScope management
011. CoroutineExceptionHandler patterns
012. SupervisorJob deep dive
013. Coroutine debugging and stack traces
014. Thread confinement pattern
015. Atomic operations with coroutines
016-045. Complex concurrency scenarios
```

#### 11 — Flow & Reactive Streams (48 exercises)
```
001. Create basic flow with flow builder
002. flowOf, asFlow conversions
003. map, filter, take operators
004. collect, toList terminal operators
005. flowOn for changing context
006. buffer, conflate, collectLatest
007. combine, zip flows
008. flatMapConcat, flatMapMerge, flatMapLatest
009. StateFlow basics
010. SharedFlow for events
011. Flow exception handling with catch
012. onCompletion handler
013. retry and retryWhen
014. debounce, sample, distinctUntilChanged
015. transform operator
016. callbackFlow for callback-based APIs
017. channelFlow for concurrent emission
018. stateIn, shareIn for cold-to-hot conversion
019. Flow testing patterns
020-048. Real-world reactive stream scenarios
```

#### 12 — Exception Handling & Error Modeling (32 exercises)
```
001. Result type basics
002. runCatching and fold
003. Either pattern (Arrow or custom)
004. Sealed class error hierarchies
005. Exception vs sealed class error trade-offs
006. Validated (accumulating errors)
007. Error mapping and recovery
008. Nested error handling
009. Coroutine exception patterns
010. Global exception handler setup
011-032. Error handling in real applications
```

#### 13 — Ktor (42 exercises)
```
001. Hello World Ktor server
002. Route parameters and query parameters
003. Request body parsing with kotlinx.serialization
004. Response types and status codes
005. Content negotiation setup
006. Authentication with JWT
007. WebSocket endpoint
008. File upload handling
009. Middleware (plugins/interceptors)
010. Ktor client: GET, POST, PUT, DELETE
011. Client retry and timeout configuration
012. Testing Ktor applications with testApplication
013. CORS and security headers
014. Rate limiting plugin
015-042. Building a complete REST API
```

#### 14 — Exposed (35 exercises)
```
001. Table definition and schema creation
002. Insert, select, update, delete operations
003. Type-safe joins
004. Transaction management
005. DAO vs DSL approach comparison
006. Aggregation functions
007. Pagination and sorting
008. Custom column types
009. Many-to-many relationships
010. Migrations with Flyway integration
011-035. Building a data access layer
```

#### 15 — Arrow (38 exercises)
```
001. Either basics: Left and Right
002. either {} builder (like for-comprehension)
003. Raise DSL for error handling
004. parZip for parallel operations
005. Resource management with resourceScope
006. Validated for error accumulation
007. Option as alternative to nullable
008. Lens for immutable data manipulation
009. Schedule for retry policies
010. Circuit breaker pattern
011-038. Functional architecture exercises
```

#### 16 — kotlinx.serialization (28 exercises)
```
001. Basic @Serializable class
002. @SerialName for field mapping
003. Custom serializer
004. Polymorphic serialization
005. Contextual serialization
006. JSON configuration options
007. Encoding/decoding sealed classes
008. Protobuf and CBOR formats
009. Generic serializer
010. Migration from Jackson/Gson
011-028. Real-world serialization scenarios
```

#### 17 — Testing (40 exercises)
```
001. Kotest StringSpec basics
002. Kotest FunSpec with context blocks
003. Kotest matchers: shouldBe, shouldThrow
004. Property-based testing with Arb generators
005. MockK: every, verify, slot
006. MockK: coEvery, coVerify for coroutines
007. MockK: spyk for partial mocking
008. Coroutine test with runTest
009. Testing Flow with turbine library
010. TestDispatcher: Standard vs Unconfined
011. Integration testing with Testcontainers
012. Ktor testApplication
013. Database testing with Exposed
014-040. Test suite design exercises
```

#### 18 — System Design & Architecture (32 exercises)
```
001. URL shortener design
002. Rate limiter implementation
003. Chat system with WebSockets + coroutines
004. Event-driven architecture with Kafka + Flow
005. CQRS pattern with Kotlin
006. Saga pattern for distributed transactions
007. API gateway with Ktor
008. Service discovery and load balancing
009. Circuit breaker implementation
010. Distributed cache design
011. Notification system
012. Real-time analytics pipeline
013-032. End-to-end system design scenarios
```

#### 19 — LeetCode in Kotlin (25 exercises)
```
001. Two Sum (#1)
002. Longest Substring Without Repeating (#3)
003. Three Sum (#15)
004. Valid Parentheses (#20)
005. Merge Two Sorted Lists (#21)
006. Group Anagrams (#49)
007. Maximum Subarray (#53)
008. Merge Intervals (#56)
009. Climbing Stairs (#70)
010. Validate BST (#98)
011. Binary Tree Level Order Traversal (#102)
012. Best Time to Buy and Sell Stock (#121)
013. Linked List Cycle (#141)
014. LRU Cache (#146)
015. House Robber (#198)
016. Number of Islands (#200)
017. Reverse Linked List (#206)
018. Course Schedule (#207)
019. Kth Largest Element (#215)
020. Invert Binary Tree (#226)
021. Lowest Common Ancestor (#236)
022. Product Except Self (#238)
023. Longest Increasing Subsequence (#300)
024. Coin Change (#322)
025. Top K Frequent Elements (#347)
```

#### Sample LeetCode Solutions in Kotlin
```kotlin
// #1 Two Sum — HashMap approach O(n)
fun twoSum(nums: IntArray, target: Int): IntArray {
    val seen = mutableMapOf<Int, Int>()
    for ((i, num) in nums.withIndex()) {
        val complement = target - num
        seen[complement]?.let { return intArrayOf(it, i) }
        seen[num] = i
    }
    throw IllegalArgumentException("No solution")
}

// #3 Longest Substring Without Repeating — Sliding window
fun lengthOfLongestSubstring(s: String): Int {
    val lastSeen = mutableMapOf<Char, Int>()
    var maxLen = 0
    var start = 0
    for ((i, c) in s.withIndex()) {
        lastSeen[c]?.let { start = maxOf(start, it + 1) }
        maxLen = maxOf(maxLen, i - start + 1)
        lastSeen[c] = i
    }
    return maxLen
}

// #20 Valid Parentheses — Stack
fun isValid(s: String): Boolean {
    val stack = ArrayDeque<Char>()
    val pairs = mapOf(')' to '(', ']' to '[', '}' to '{')
    for (c in s) {
        if (c in pairs.values) {
            stack.addLast(c)
        } else {
            if (stack.isEmpty() || stack.removeLast() != pairs[c]) return false
        }
    }
    return stack.isEmpty()
}

// #53 Maximum Subarray — Kadane's algorithm
fun maxSubArray(nums: IntArray): Int {
    var maxSum = nums[0]
    var currentSum = nums[0]
    for (i in 1 until nums.size) {
        currentSum = maxOf(nums[i], currentSum + nums[i])
        maxSum = maxOf(maxSum, currentSum)
    }
    return maxSum
}

// #146 LRU Cache — LinkedHashMap
class LRUCache(private val capacity: Int) {
    private val cache = object : LinkedHashMap<Int, Int>(capacity, 0.75f, true) {
        override fun removeEldestEntry(eldest: MutableMap.MutableEntry<Int, Int>?) =
            size > capacity
    }

    fun get(key: Int): Int = cache.getOrDefault(key, -1)

    fun put(key: Int, value: Int) {
        cache[key] = value
    }
}

// #200 Number of Islands — BFS
fun numIslands(grid: Array<CharArray>): Int {
    if (grid.isEmpty()) return 0
    val rows = grid.size
    val cols = grid[0].size
    var count = 0

    fun bfs(r: Int, c: Int) {
        val queue = ArrayDeque<Pair<Int, Int>>()
        queue.add(r to c)
        grid[r][c] = '0'
        val dirs = listOf(0 to 1, 0 to -1, 1 to 0, -1 to 0)
        while (queue.isNotEmpty()) {
            val (cr, cc) = queue.removeFirst()
            for ((dr, dc) in dirs) {
                val nr = cr + dr
                val nc = cc + dc
                if (nr in 0 until rows && nc in 0 until cols && grid[nr][nc] == '1') {
                    grid[nr][nc] = '0'
                    queue.add(nr to nc)
                }
            }
        }
    }

    for (r in 0 until rows) {
        for (c in 0 until cols) {
            if (grid[r][c] == '1') {
                count++
                bfs(r, c)
            }
        }
    }
    return count
}

// #206 Reverse Linked List — Iterative
fun reverseList(head: ListNode?): ListNode? {
    var prev: ListNode? = null
    var curr = head
    while (curr != null) {
        val next = curr.next
        curr.next = prev
        prev = curr
        curr = next
    }
    return prev
}

// #322 Coin Change — Dynamic Programming
fun coinChange(coins: IntArray, amount: Int): Int {
    val dp = IntArray(amount + 1) { amount + 1 }
    dp[0] = 0
    for (i in 1..amount) {
        for (coin in coins) {
            if (coin <= i) {
                dp[i] = minOf(dp[i], dp[i - coin] + 1)
            }
        }
    }
    return if (dp[amount] > amount) -1 else dp[amount]
}
```

---

**Last Updated**: March 17, 2026
