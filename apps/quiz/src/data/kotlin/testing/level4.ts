import { Question } from '@/types/question';

const questions: Question[] = [
  {
    id: 'kotlin-testing-l4-001',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'MockK Advanced',
    question: 'How do you mock a top-level extension function in MockK?',
    codeSnippet: `mockkStatic("com.example.ExtensionsKt")
every { any<String>().myExtension() } returns "mocked"

val result = "hello".myExtension()

verify { any<String>().myExtension() }
unmockkStatic("com.example.ExtensionsKt")`,
    options: [
      'Use @MockkExtension annotation on the test class',
      'Use mockkStatic with the file class name (e.g., "ExtensionsKt") and then mock using any<ReceiverType>().extensionFn()',
      'Extension functions cannot be mocked with MockK',
      'Use mockkObject on the extension function directly',
    ],
    correctAnswer: 1,
    explanation: 'Top-level extension functions in Kotlin are compiled to static methods on a class named after the file (e.g., ExtensionsKt). MockK can mock them via mockkStatic with the fully qualified class name, then using any<ReceiverType>().extensionFn() to define the behavior.',
    tags: ['mockk', 'extension-functions', 'static-mocking'],
  },
  {
    id: 'kotlin-testing-l4-002',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'MockK Advanced',
    question: 'What is the purpose of MockK\'s coEvery and coVerify blocks?',
    codeSnippet: `val service = mockk<SuspendService>()

coEvery { service.fetchData() } returns listOf("a", "b")

runTest {
    val result = service.fetchData()
    result shouldBe listOf("a", "b")
}

coVerify { service.fetchData() }`,
    options: [
      'They run mocks concurrently for performance optimization',
      'They are aliases for every/verify with no difference',
      'They automatically wrap calls in runBlocking for JVM compatibility',
      'They provide coroutine-aware stubbing and verification for suspend functions',
    ],
    correctAnswer: 3,
    explanation: 'coEvery and coVerify are coroutine-aware versions of every and verify in MockK. They are required when mocking suspend functions because the lambda inside these blocks needs to be a suspend lambda to call suspend functions. Using every/verify with suspend functions will cause compilation errors.',
    tags: ['mockk', 'coroutines', 'suspend-functions'],
  },
  {
    id: 'kotlin-testing-l4-003',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'MockK Advanced',
    question: 'How does MockK\'s slot() capture mechanism work for verifying complex argument values?',
    codeSnippet: `val slot = slot<UserRequest>()
val service = mockk<UserService>()

every { service.createUser(capture(slot)) } returns User("1", "Alice")

service.createUser(UserRequest("Alice", "alice@test.com"))

slot.captured.name shouldBe "Alice"
slot.captured.email shouldBe "alice@test.com"`,
    options: [
      'slot() captures the argument passed to a mocked function into a CapturingSlot, accessible via slot.captured for assertions',
      'slot() serializes the argument to JSON for comparison',
      'slot() records all invocations and returns the last one via slot.all',
      'slot() creates a placeholder that defers argument matching to verification time',
    ],
    correctAnswer: 0,
    explanation: 'MockK\'s slot<T>() creates a CapturingSlot that, when used with capture(slot) inside every { }, captures the actual argument passed during invocation. The captured value is accessible via slot.captured, enabling detailed assertions on complex objects after the call.',
    tags: ['mockk', 'argument-capture', 'slot'],
  },
  {
    id: 'kotlin-testing-l4-004',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'MockK Advanced',
    question: 'What happens when you use MockK\'s answers block with custom logic?',
    codeSnippet: `val repo = mockk<Repository>()

every { repo.findById(any()) } answers {
    val id = firstArg<String>()
    if (id == "404") null
    else Entity(id, "Name-$id")
}`,
    options: [
      'The answers block requires explicit type declaration for the return value',
      'The answers block only works with primitive return types',
      'The answers block is evaluated once at mock setup time and the result is cached',
      'The answers block is evaluated lazily on each invocation, with access to call arguments via firstArg, secondArg, etc.',
    ],
    correctAnswer: 3,
    explanation: 'MockK\'s answers block provides dynamic stubbing where the lambda is evaluated on each invocation. Inside the block, you can access invocation arguments via firstArg<T>(), secondArg<T>(), lastArg<T>(), or args list. This enables conditional responses based on actual arguments passed at call time.',
    tags: ['mockk', 'answers', 'dynamic-stubbing'],
  },
  {
    id: 'kotlin-testing-l4-005',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'MockK Advanced',
    question: 'How do you verify invocation order across multiple mocks in MockK?',
    codeSnippet: `val auth = mockk<AuthService>(relaxed = true)
val repo = mockk<Repository>(relaxed = true)
val logger = mockk<Logger>(relaxed = true)

// ... perform operations ...

verifyOrder {
    auth.authenticate("user")
    repo.save(any())
    logger.log(any())
}`,
    options: [
      'Use verifySequence which verifies exact order and that no other calls occurred',
      'Use verifyAll which ensures all calls happened regardless of order',
      'Use verify with an ordered = true parameter',
      'Use verifyOrder which verifies these calls happened in this relative order, but allows other calls in between',
    ],
    correctAnswer: 3,
    explanation: 'verifyOrder checks that the specified calls happened in the given relative order, but permits other calls between them. In contrast, verifySequence checks exact order with no other calls allowed, and verifyAll checks that all specified calls occurred in any order. verifyOrder is most useful for testing workflows across multiple collaborators.',
    tags: ['mockk', 'verification', 'ordering'],
  },
  {
    id: 'kotlin-testing-l4-006',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'MockK Advanced',
    question: 'What is the difference between relaxed mocks and relaxUnitFun in MockK?',
    codeSnippet: `// Option A
val mock1 = mockk<Service>(relaxed = true)

// Option B
val mock2 = mockk<Service>(relaxUnitFun = true)`,
    options: [
      'relaxed = true returns default values for all functions; relaxUnitFun only auto-stubs Unit-returning functions, others still require explicit stubbing',
      'relaxed = true only relaxes Unit-returning functions; relaxUnitFun relaxes all functions',
      'relaxUnitFun makes the mock thread-safe while relaxed does not',
      'They are identical in behavior',
    ],
    correctAnswer: 0,
    explanation: 'relaxed = true makes MockK return default values (0, "", false, empty collections, child mocks) for all unstubbed calls. relaxUnitFun = true only auto-stubs functions returning Unit, requiring explicit stubbing for all other return types. relaxUnitFun is preferred when you want strict verification of non-Unit calls while avoiding boilerplate for void-like functions.',
    tags: ['mockk', 'relaxed', 'configuration'],
  },
  {
    id: 'kotlin-testing-l4-007',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'MockK Advanced',
    question: 'How do you mock a constructor call using MockK?',
    codeSnippet: `mockkConstructor(DatabaseConnection::class)

every {
    constructedWith<DatabaseConnection>(
        EqMatcher("jdbc:h2:mem:test")
    ).connect()
} returns mockConnection

val conn = DatabaseConnection("jdbc:h2:mem:test")
conn.connect() // returns mockConnection

unmockkConstructor(DatabaseConnection::class)`,
    options: [
      'Use @InjectMockKs annotation to replace constructors',
      'Use mockkNew() to intercept new instance creation',
      'Constructor mocking is not supported in MockK',
      'Use mockkConstructor to intercept constructor calls, then use constructedWith<T>() with matchers to define behavior on instances created with specific arguments',
    ],
    correctAnswer: 3,
    explanation: 'MockK supports constructor mocking via mockkConstructor(). Once activated, you can use constructedWith<T>() with argument matchers (like EqMatcher, AnyMatcher) to define behavior for instances created with matching constructor arguments. Always call unmockkConstructor() in cleanup to avoid test pollution.',
    tags: ['mockk', 'constructor-mocking', 'advanced'],
  },
  {
    id: 'kotlin-testing-l4-008',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'MockK Advanced',
    question: 'How can you create a custom MockK matcher for domain-specific argument matching?',
    codeSnippet: `fun MockKMatcherScope.validEmail() = match<String> {
    it.matches(Regex("^[\\\\w.]+@[\\\\w.]+\\\\.[a-zA-Z]{2,}$"))
}

every { service.sendEmail(validEmail(), any()) } returns true

service.sendEmail("user@test.com", "Hello") // matches
service.sendEmail("invalid", "Hello") // throws`,
    options: [
      'Use @CustomMatcher annotation on a function',
      'Use match<T> { predicate } inside a MockKMatcherScope extension function to create inline custom matchers',
      'Custom matchers are created by extending the Matcher<T> class and registering with MockK',
      'Custom matchers require a MockK plugin to be compiled',
    ],
    correctAnswer: 1,
    explanation: 'MockK allows creating custom matchers as extension functions on MockKMatcherScope using the match<T> { } function, which takes a predicate lambda. This provides a clean DSL for domain-specific matching logic. The matcher can be used anywhere a built-in matcher (like any(), eq()) would be used.',
    tags: ['mockk', 'custom-matchers', 'dsl'],
  },
  {
    id: 'kotlin-testing-l4-009',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'Kotest Advanced',
    question: 'How does Kotest\'s test factory pattern work for reusable parameterized test suites?',
    codeSnippet: `fun <T : Collection<*>> collectionBehavior(
    empty: T, nonEmpty: T
) = funSpec {
    test("empty collection should have size 0") {
        empty.size shouldBe 0
    }
    test("non-empty collection should not be empty") {
        nonEmpty.shouldNotBeEmpty()
    }
}

class ListTest : FunSpec({
    include(collectionBehavior(emptyList<Int>(), listOf(1, 2)))
})

class SetTest : FunSpec({
    include(collectionBehavior(emptySet<Int>(), setOf(1, 2)))
})`,
    options: [
      'Test factories require @TestFactory annotation from JUnit 5',
      'Test factories are functions returning TestFactory via spec builder functions (funSpec, stringSpec, etc.), includable in multiple test classes via include()',
      'Test factories create mock objects that produce tests at runtime',
      'Test factories are only available in the BehaviorSpec style',
    ],
    correctAnswer: 1,
    explanation: 'Kotest test factories allow you to define reusable test suites as functions returning a TestFactory. You create them using builder functions like funSpec { }, stringSpec { }, etc. Any spec class can include them via include(factory), enabling test reuse across different implementations of a shared contract.',
    tags: ['kotest', 'test-factory', 'reuse'],
  },
  {
    id: 'kotlin-testing-l4-010',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'Kotest Advanced',
    question: 'What are Kotest\'s isolation modes and how do they affect test execution?',
    codeSnippet: `class IsolationTest : FunSpec({
    isolationMode = IsolationMode.InstancePerLeaf

    var counter = 0

    test("first test") {
        counter++
        counter shouldBe 1
    }

    test("second test") {
        counter++
        counter shouldBe 1 // passes with InstancePerLeaf!
    }
})`,
    options: [
      'IsolationMode.SingleInstance runs all tests in one instance; InstancePerTest creates a fresh spec instance per test; InstancePerLeaf creates one per leaf test',
      'SingleInstance is the only available mode; other modes are deprecated',
      'Isolation modes control thread isolation for parallel tests',
      'Isolation modes determine whether tests run in the same JVM or separate processes',
    ],
    correctAnswer: 0,
    explanation: 'Kotest offers three isolation modes: SingleInstance (default) shares one spec instance across all tests, InstancePerTest creates a new instance for each test including parent contexts, and InstancePerLeaf creates a new instance for each leaf (terminal) test. InstancePerLeaf ensures each test gets fresh state, similar to JUnit\'s behavior.',
    tags: ['kotest', 'isolation-mode', 'test-lifecycle'],
  },
  {
    id: 'kotlin-testing-l4-011',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'Kotest Advanced',
    question: 'How do you implement custom Kotest extensions for cross-cutting test concerns?',
    codeSnippet: `class TimingExtension : BeforeTestListener, AfterTestListener {
    private val timings = mutableMapOf<String, Long>()

    override suspend fun beforeTest(testCase: TestCase) {
        timings[testCase.name.testName] = System.nanoTime()
    }

    override suspend fun afterTest(
        testCase: TestCase, result: TestResult
    ) {
        val elapsed = System.nanoTime() -
            (timings[testCase.name.testName] ?: 0)
        println("\${testCase.name.testName}: \${elapsed / 1_000_000}ms")
    }
}`,
    options: [
      'Create a JUnit @Rule and Kotest will automatically adapt it',
      'Implement specific listener interfaces (BeforeTestListener, AfterTestListener, etc.) and register via extensions() or @AutoScan',
      'Implement TestListener interface which handles all lifecycle events in a single method',
      'Extend AbstractKotestExtension and override the handle() method',
    ],
    correctAnswer: 1,
    explanation: 'Kotest extensions are created by implementing specific listener interfaces like BeforeTestListener, AfterTestListener, BeforeSpecListener, etc. They are registered per-spec via extensions(MyExtension()), globally in project config, or via @AutoScan annotation for classpath-scanned automatic registration. This modular design avoids monolithic listener interfaces.',
    tags: ['kotest', 'extensions', 'lifecycle'],
  },
  {
    id: 'kotlin-testing-l4-012',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'Kotest Advanced',
    question: 'How does Kotest\'s soft assertions feature work?',
    codeSnippet: `assertSoftly {
    "hello".length shouldBe 5
    "hello".uppercase() shouldBe "HELLO"
    "hello"[0] shouldBe 'h'
    "hello".reversed() shouldBe "olleh"
}`,
    options: [
      'Soft assertions retry failing assertions up to 3 times before reporting failure',
      'Soft assertions convert failures to warnings that appear in the test report',
      'Soft assertions catch the first failure and continue, reporting all failures at the end of the block',
      'assertSoftly collects all assertion failures within the block and reports them together when the block completes, instead of stopping at the first failure',
    ],
    correctAnswer: 3,
    explanation: 'assertSoftly runs all assertions within the block, collecting failures rather than throwing on the first one. When the block completes, if any assertions failed, it throws an AssertionError containing all failures. This is invaluable for data validation tests where you want to see all problems at once rather than fixing them one at a time.',
    tags: ['kotest', 'soft-assertions', 'assertions'],
  },
  {
    id: 'kotlin-testing-l4-013',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'Kotest Advanced',
    question: 'What is the purpose of Kotest\'s eventually() and continually() functions?',
    codeSnippet: `eventually(duration = 5.seconds, poll = 100.milliseconds) {
    service.getStatus() shouldBe "READY"
}

continually(duration = 3.seconds) {
    cache.get("key").shouldNotBeNull()
}`,
    options: [
      'Both functions are identical but eventually is deprecated in favor of continually',
      'eventually() is for async tests; continually() is for synchronous tests only',
      'eventually() delays test execution; continually() runs tests in a loop',
      'eventually() retries until the assertion passes within the duration; continually() asserts the condition holds true for the entire duration',
    ],
    correctAnswer: 3,
    explanation: 'eventually() repeatedly evaluates the assertion block, retrying on failure until it passes or the timeout expires. It is ideal for testing eventually-consistent systems. continually() is the inverse: it asserts that the condition remains true for the entire duration, failing immediately if the assertion breaks at any point. Both accept polling interval configuration.',
    tags: ['kotest', 'eventually', 'async-testing'],
  },
  {
    id: 'kotlin-testing-l4-014',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'Kotest Advanced',
    question: 'How do you configure test execution with Kotest\'s project-level configuration?',
    codeSnippet: `object ProjectConfig : AbstractProjectConfig() {
    override val parallelism = 4
    override val assertionMode = AssertionMode.Error
    override val isolationMode = IsolationMode.InstancePerLeaf
    override val timeout = 30.seconds

    override fun extensions() = listOf(
        TimingExtension(),
        DatabaseCleanupExtension()
    )

    override suspend fun beforeProject() {
        Database.migrate()
    }
}`,
    options: [
      'Use @KotestConfiguration annotation on any test class',
      'Project-level configuration is only possible via Gradle/Maven plugin configuration',
      'Add a kotest.properties file in src/test/resources',
      'Create a class extending AbstractProjectConfig with overrides for global settings, placed anywhere on the classpath',
    ],
    correctAnswer: 3,
    explanation: 'Kotest discovers AbstractProjectConfig subclasses on the classpath (or you can specify one explicitly). This allows setting global defaults for parallelism, timeouts, isolation mode, assertion mode, global extensions, and project-level lifecycle callbacks (beforeProject/afterProject). It provides centralized test infrastructure configuration.',
    tags: ['kotest', 'project-config', 'configuration'],
  },
  {
    id: 'kotlin-testing-l4-015',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'Coroutine Testing',
    question: 'What is the role of TestDispatcher in kotlinx-coroutines-test?',
    codeSnippet: `@Test
fun testWithVirtualTime() = runTest {
    val values = mutableListOf<Int>()

    launch {
        delay(1000)
        values.add(1)
        delay(1000)
        values.add(2)
    }

    advanceTimeBy(1000)
    values shouldBe listOf(1)

    advanceTimeBy(1000)
    values shouldBe listOf(1, 2)
}`,
    options: [
      'TestDispatcher runs coroutines on a separate test thread pool',
      'TestDispatcher ensures coroutines run sequentially even when launched concurrently',
      'TestDispatcher provides virtual time control, allowing tests to skip delay() calls and advance time programmatically without real waiting',
      'TestDispatcher replaces all dispatchers in the application with Dispatchers.Unconfined',
    ],
    correctAnswer: 2,
    explanation: 'TestDispatcher (used internally by runTest) provides a virtual time scheduler. delay() calls are paused rather than actually waiting, and tests can use advanceTimeBy(), advanceUntilIdle(), and runCurrent() to control time progression. This makes testing time-dependent coroutine code fast and deterministic.',
    tags: ['coroutines', 'test-dispatcher', 'virtual-time'],
  },
  {
    id: 'kotlin-testing-l4-016',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'Coroutine Testing',
    question: 'What is the difference between StandardTestDispatcher and UnconfinedTestDispatcher?',
    codeSnippet: `@Test
fun standardBehavior() = runTest(StandardTestDispatcher()) {
    var value = 0
    launch { value = 1 }
    // value is still 0 here
    value shouldBe 0
    advanceUntilIdle()
    value shouldBe 1
}

@Test
fun unconfinedBehavior() = runTest(UnconfinedTestDispatcher()) {
    var value = 0
    launch { value = 1 }
    // value is already 1
    value shouldBe 1
}`,
    options: [
      'They behave identically but UnconfinedTestDispatcher is faster',
      'StandardTestDispatcher is for unit tests; UnconfinedTestDispatcher is for integration tests',
      'StandardTestDispatcher runs on the main thread; UnconfinedTestDispatcher uses a thread pool',
      'StandardTestDispatcher requires explicit advancement (advanceUntilIdle, etc.); UnconfinedTestDispatcher eagerly executes coroutines at launch points',
    ],
    correctAnswer: 3,
    explanation: 'StandardTestDispatcher queues coroutines without executing them until the test explicitly advances the scheduler (advanceUntilIdle, advanceTimeBy, runCurrent). This gives fine-grained control over execution order. UnconfinedTestDispatcher eagerly starts coroutines at their launch point, which is simpler but provides less control. runTest uses StandardTestDispatcher by default.',
    tags: ['coroutines', 'dispatchers', 'test-dispatcher'],
  },
  {
    id: 'kotlin-testing-l4-017',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'Coroutine Testing',
    question: 'How do you test a ViewModel that uses viewModelScope with coroutine test utilities?',
    codeSnippet: `class MyViewModel(
    private val repo: Repository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {
    private val _state = MutableStateFlow<UiState>(UiState.Loading)
    val state: StateFlow<UiState> = _state

    fun loadData() {
        viewModelScope.launch(dispatcher) {
            _state.value = UiState.Success(repo.getData())
        }
    }
}

@Test
fun testViewModel() = runTest {
    val vm = MyViewModel(fakeRepo, StandardTestDispatcher(testScheduler))
    vm.loadData()
    advanceUntilIdle()
    vm.state.value shouldBe UiState.Success(expectedData)
}`,
    options: [
      'Use Dispatchers.Unconfined in production code for testability',
      'Mock viewModelScope entirely with MockK',
      'Replace Dispatchers.Main with a test dispatcher using Dispatchers.setMain() and inject the test dispatcher for other dispatchers',
      'Test ViewModels only through UI integration tests',
    ],
    correctAnswer: 2,
    explanation: 'The recommended approach is to inject dispatchers into the ViewModel (constructor injection) and use Dispatchers.setMain(testDispatcher) in test setup for viewModelScope (which uses Dispatchers.Main). Sharing the testScheduler between runTest and the injected dispatcher ensures virtual time is synchronized.',
    tags: ['coroutines', 'viewmodel', 'dispatchers-main'],
  },
  {
    id: 'kotlin-testing-l4-018',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'Coroutine Testing',
    question: 'How do you test exception handling in coroutines with runTest?',
    codeSnippet: `@Test
fun testExceptionInCoroutine() = runTest {
    val deferred = async {
        throw IllegalStateException("Something went wrong")
    }

    val exception = shouldThrow<IllegalStateException> {
        deferred.await()
    }
    exception.message shouldBe "Something went wrong"
}`,
    options: [
      'Use expectedException rule similar to JUnit 4',
      'Coroutine exceptions must be caught with a global CoroutineExceptionHandler',
      'Exceptions in coroutines are automatically caught by runTest and reported as test failures',
      'Use shouldThrow or assertThrows on the await() call of a deferred, or wrap the launch in a try-catch within the test',
    ],
    correctAnswer: 3,
    explanation: 'When testing coroutine exceptions, the approach depends on the builder. For async, the exception is deferred until await() is called, where you can assert on it. For launch, uncaught exceptions propagate to the parent scope; in runTest, they cause test failure. You can use shouldThrow (Kotest) or assertThrows (JUnit) to verify expected exceptions.',
    tags: ['coroutines', 'exception-handling', 'runTest'],
  },
  {
    id: 'kotlin-testing-l4-019',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'Coroutine Testing',
    question: 'How does Turbine library help test Kotlin Flows?',
    codeSnippet: `@Test
fun testFlow() = runTest {
    val flow = flow {
        emit("loading")
        delay(1000)
        emit("data")
        delay(1000)
        emit("done")
    }

    flow.test {
        awaitItem() shouldBe "loading"
        awaitItem() shouldBe "data"
        awaitItem() shouldBe "done"
        awaitComplete()
    }
}`,
    options: [
      'Turbine converts Flows to blocking sequences for simpler testing',
      'Turbine provides a test { } extension on Flow that offers awaitItem(), awaitComplete(), awaitError() for deterministic, sequential Flow testing',
      'Turbine records all emissions into a list for batch assertion',
      'Turbine mocks Flow internals to bypass actual emissions',
    ],
    correctAnswer: 1,
    explanation: 'Turbine is a testing library for Kotlin Flow that provides the test { } extension function. Inside the test block, you use awaitItem() to receive the next emission, awaitComplete() to assert completion, and awaitError() to assert errors. It integrates with runTest for virtual time support and provides clear error messages for unexpected events.',
    tags: ['turbine', 'flow', 'coroutine-testing'],
  },
  {
    id: 'kotlin-testing-l4-020',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'Coroutine Testing',
    question: 'How do you test a SharedFlow with Turbine when there are no subscribers initially?',
    codeSnippet: `@Test
fun testSharedFlow() = runTest {
    val sharedFlow = MutableSharedFlow<String>(replay = 1)

    sharedFlow.emit("first")

    sharedFlow.test {
        awaitItem() shouldBe "first" // received from replay cache

        sharedFlow.emit("second")
        awaitItem() shouldBe "second"

        cancelAndIgnoreRemainingEvents()
    }
}`,
    options: [
      'Always call sharedFlow.subscriptionCount.first { it > 0 } before emitting',
      'Set replay > 0 on the SharedFlow to ensure emissions before test {} subscription are captured; use cancelAndIgnoreRemainingEvents() to clean up',
      'Use testIn(scope) instead of test {} for SharedFlow',
      'SharedFlow cannot be tested with Turbine; use toList() instead',
    ],
    correctAnswer: 1,
    explanation: 'SharedFlow with replay = 0 does not buffer emissions for late subscribers. When testing with Turbine, using replay > 0 ensures emissions before the test {} block subscribes are available. For flows that never complete (like SharedFlow), use cancelAndIgnoreRemainingEvents() or cancel() to properly clean up the test subscriber.',
    tags: ['turbine', 'shared-flow', 'testing'],
  },
  {
    id: 'kotlin-testing-l4-021',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'Coroutine Testing',
    question: 'How do you test timeout behavior in coroutines?',
    codeSnippet: `@Test
fun testTimeout() = runTest {
    val result = withTimeoutOrNull(5000) {
        delay(3000)
        "completed"
    }
    result shouldBe "completed"

    val timedOut = withTimeoutOrNull(1000) {
        delay(3000)
        "completed"
    }
    timedOut shouldBe null
}`,
    options: [
      'runTest with virtual time makes withTimeout/withTimeoutOrNull execute instantly while respecting relative timing of delays vs timeouts',
      'Timeout behavior cannot be tested deterministically',
      'Use Thread.sleep() to simulate real timeouts in tests',
      'Use a custom TestTimeout annotation to control timeout values',
    ],
    correctAnswer: 0,
    explanation: 'In runTest, delay-based timeouts (withTimeout, withTimeoutOrNull) work with virtual time. The test scheduler tracks relative timing: if delay(3000) is inside withTimeout(5000), it completes because 3000 < 5000 in virtual time. If inside withTimeout(1000), it times out. No real time passes, making tests fast and deterministic.',
    tags: ['coroutines', 'timeout', 'virtual-time'],
  },
  {
    id: 'kotlin-testing-l4-022',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'Coroutine Testing',
    question: 'How do you verify that a coroutine scope is properly cancelled and cleaned up?',
    codeSnippet: `@Test
fun testCancellation() = runTest {
    var cleanedUp = false
    val job = launch {
        try {
            delay(Long.MAX_VALUE)
        } finally {
            cleanedUp = true
        }
    }

    advanceTimeBy(100)
    job.isActive shouldBe true

    job.cancelAndJoin()
    job.isCancelled shouldBe true
    cleanedUp shouldBe true
}`,
    options: [
      'Use Thread.interrupt() on the coroutine thread',
      'Set a timeout on the test and let it expire',
      'Call cancelAndJoin() on the Job and verify isCancelled is true and finally blocks executed',
      'Coroutine cancellation cannot be tested in unit tests',
    ],
    correctAnswer: 2,
    explanation: 'Coroutine cancellation is tested by calling cancel() or cancelAndJoin() on the Job reference, then asserting job.isCancelled. To verify cleanup, check that finally blocks or onCompletion handlers ran. cancelAndJoin() suspends until cancellation is complete, ensuring all cleanup logic has executed before assertions.',
    tags: ['coroutines', 'cancellation', 'job'],
  },
  {
    id: 'kotlin-testing-l4-023',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'Compose UI Testing',
    question: 'How does Compose UI testing with ComposeTestRule work?',
    codeSnippet: `class LoginScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun loginButton_displaysCorrectText() {
        composeTestRule.setContent {
            LoginScreen()
        }

        composeTestRule
            .onNodeWithText("Sign In")
            .assertIsDisplayed()
            .assertIsEnabled()
    }
}`,
    options: [
      'ComposeTestRule provides a test environment to render composables and query the semantic tree using matchers like onNodeWithText, onNodeWithTag, etc.',
      'ComposeTestRule converts Compose UI to traditional Android Views for testing',
      'ComposeTestRule launches the full Android activity and finds views by ID',
      'ComposeTestRule takes screenshots and compares them pixel by pixel',
    ],
    correctAnswer: 0,
    explanation: 'ComposeTestRule (createComposeRule or createAndroidComposeRule) hosts composables in a test environment. Tests interact with the semantic tree using finders (onNodeWithText, onNodeWithTag, onNodeWithContentDescription) and perform assertions (assertIsDisplayed, assertIsEnabled) or actions (performClick, performTextInput). No Activity is needed with createComposeRule.',
    tags: ['compose', 'ui-testing', 'compose-test-rule'],
  },
  {
    id: 'kotlin-testing-l4-024',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'Compose UI Testing',
    question: 'How do you test user interactions in Jetpack Compose?',
    codeSnippet: `@Test
fun loginFlow_submitsCredentials() {
    var submittedEmail = ""

    composeTestRule.setContent {
        LoginScreen(onSubmit = { email -> submittedEmail = email })
    }

    composeTestRule
        .onNodeWithTag("email_input")
        .performTextInput("user@test.com")

    composeTestRule
        .onNodeWithTag("submit_button")
        .performClick()

    submittedEmail shouldBe "user@test.com"
}`,
    options: [
      'Dispatch synthetic MotionEvents directly to the Compose runtime',
      'Use performClick(), performTextInput(), performScrollTo() etc. on semantic nodes found via testTag or text matchers',
      'Use Robolectric to simulate touches on Compose surfaces',
      'Use Espresso actions like ViewActions.click() on Compose nodes',
    ],
    correctAnswer: 1,
    explanation: 'Compose UI testing uses semantic actions on nodes found through the test API. performClick(), performTextInput(), performScrollTo(), performGesture() etc. simulate user interactions. Nodes are identified using testTag (set via Modifier.testTag()), text content, or content descriptions. Callbacks can be captured via lambda parameters to verify behavior.',
    tags: ['compose', 'ui-testing', 'interactions'],
  },
  {
    id: 'kotlin-testing-l4-025',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'Compose UI Testing',
    question: 'How do you test Compose state changes and recomposition?',
    codeSnippet: `@Test
fun counter_incrementsOnClick() {
    composeTestRule.setContent {
        CounterScreen()
    }

    composeTestRule
        .onNodeWithText("Count: 0")
        .assertIsDisplayed()

    composeTestRule
        .onNodeWithTag("increment_button")
        .performClick()

    composeTestRule
        .onNodeWithText("Count: 1")
        .assertIsDisplayed()

    composeTestRule
        .onNodeWithText("Count: 0")
        .assertDoesNotExist()
}`,
    options: [
      'Use a StateObserver to watch for recomposition events',
      'After performing actions that trigger state changes, the Compose test framework automatically waits for recomposition, then query the updated semantic tree with assertions',
      'Call composeTestRule.recompose() manually after state changes',
      'State changes cannot be tested; only initial composition is testable',
    ],
    correctAnswer: 1,
    explanation: 'The Compose test framework automatically synchronizes with the Compose runtime. After an action like performClick() triggers a state change, the framework waits for pending recompositions and frame rendering to complete before executing subsequent assertions. This means tests naturally verify the post-recomposition UI state.',
    tags: ['compose', 'state', 'recomposition'],
  },
  {
    id: 'kotlin-testing-l4-026',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'Compose UI Testing',
    question: 'How do you test lazy lists (LazyColumn/LazyRow) in Compose?',
    codeSnippet: `@Test
fun lazyColumn_scrollsToItem() {
    composeTestRule.setContent {
        LazyColumn(Modifier.testTag("list")) {
            items(100) { index ->
                Text("Item $index", Modifier.testTag("item_$index"))
            }
        }
    }

    composeTestRule
        .onNodeWithTag("item_0")
        .assertIsDisplayed()

    composeTestRule
        .onNodeWithTag("list")
        .performScrollToIndex(50)

    composeTestRule
        .onNodeWithTag("item_50")
        .assertIsDisplayed()
}`,
    options: [
      'Use performScrollToIndex() or performScrollToNode() on the lazy list node to scroll items into the composed range before asserting',
      'LazyColumn cannot be tested and must be replaced with Column in tests',
      'Use onAllNodesWithTag() which automatically scrolls through all items',
      'All items in a LazyColumn are always composed, so standard finders work',
    ],
    correctAnswer: 0,
    explanation: 'LazyColumn/LazyRow only compose visible items, so off-screen items do not exist in the semantic tree. performScrollToIndex(index) scrolls the list to bring a specific index into view, and performScrollToNode(matcher) scrolls until a matching node is found. Once scrolled into view, standard assertions work on the now-composed items.',
    tags: ['compose', 'lazy-list', 'scrolling'],
  },
  {
    id: 'kotlin-testing-l4-027',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'Compose UI Testing',
    question: 'How do you handle animations and asynchronous operations in Compose UI tests?',
    codeSnippet: `@Test
fun animatedVisibility_showsContent() {
    composeTestRule.mainClock.autoAdvance = false

    composeTestRule.setContent {
        AnimatedContent()
    }

    composeTestRule
        .onNodeWithTag("animated_panel")
        .assertDoesNotExist()

    composeTestRule
        .onNodeWithTag("show_button")
        .performClick()

    composeTestRule.mainClock.advanceTimeBy(500)

    composeTestRule
        .onNodeWithTag("animated_panel")
        .assertIsDisplayed()
}`,
    options: [
      'Set a global flag to disable all animations before tests run',
      'Use waitForIdle() which blocks until all animations complete',
      'Animations are automatically skipped in tests; no special handling needed',
      'Use composeTestRule.mainClock to control time manually by disabling autoAdvance and using advanceTimeBy() to step through animations',
    ],
    correctAnswer: 3,
    explanation: 'Compose test\'s mainClock controls the virtual clock. By default autoAdvance is true and the clock advances automatically. For precise animation testing, set autoAdvance = false and use advanceTimeBy(millis) to step through animation frames. Additionally, waitForIdle() can wait for composition to settle after asynchronous state updates.',
    tags: ['compose', 'animations', 'main-clock'],
  },
  {
    id: 'kotlin-testing-l4-028',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'TestContainers',
    question: 'How do you use Testcontainers with Kotlin to run integration tests against a real database?',
    codeSnippet: `class DatabaseIntegrationTest {
    companion object {
        @Container
        val postgres = PostgreSQLContainer("postgres:15")
            .withDatabaseName("testdb")
            .withUsername("test")
            .withPassword("test")

        @JvmStatic
        @DynamicPropertySource
        fun properties(registry: DynamicPropertyRegistry) {
            registry.add("spring.datasource.url", postgres::getJdbcUrl)
            registry.add("spring.datasource.username", postgres::getUsername)
            registry.add("spring.datasource.password", postgres::getPassword)
        }
    }
}`,
    options: [
      'Testcontainers mocks the database driver to simulate database responses',
      'Testcontainers connects to a shared remote test database server',
      'Testcontainers launches real Docker containers with actual databases, providing dynamic connection properties for true integration testing',
      'Testcontainers uses an embedded H2 database with PostgreSQL compatibility mode',
    ],
    correctAnswer: 2,
    explanation: 'Testcontainers manages Docker containers within the test lifecycle. PostgreSQLContainer starts an actual PostgreSQL instance in Docker, providing the real JDBC URL via getJdbcUrl(). @DynamicPropertySource (Spring) injects these dynamic properties. This ensures tests run against the real database engine with proper SQL dialect and behavior.',
    tags: ['testcontainers', 'database', 'integration-testing'],
  },
  {
    id: 'kotlin-testing-l4-029',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'TestContainers',
    question: 'How does the Testcontainers lifecycle work with JUnit 5?',
    codeSnippet: `@Testcontainers
class ServiceTest {
    companion object {
        @Container
        @JvmStatic
        val redis = GenericContainer("redis:7")
            .withExposedPorts(6379)
    }

    @Container
    val kafka = KafkaContainer(
        DockerImageName.parse("confluentinc/cp-kafka:7.4.0")
    )

    @Test
    fun testWithContainers() {
        redis.isRunning shouldBe true
        kafka.isRunning shouldBe true
    }
}`,
    options: [
      '@Container on companion (static) fields starts once per class; @Container on instance fields starts/stops per test method. @Testcontainers enables this lifecycle management.',
      'All containers start once before all tests and stop after all tests',
      '@Testcontainers starts containers in parallel regardless of field placement',
      'Containers are started lazily on first access and never stopped',
    ],
    correctAnswer: 0,
    explanation: '@Testcontainers integrates container lifecycle with JUnit 5. Static @Container fields (companion object with @JvmStatic) are started once before the first test and stopped after the last test in the class. Instance @Container fields are started before each test method and stopped after it. This allows choosing between shared and per-test containers.',
    tags: ['testcontainers', 'lifecycle', 'junit5'],
  },
  {
    id: 'kotlin-testing-l4-030',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'TestContainers',
    question: 'How do you create a reusable Testcontainers configuration with Docker Compose?',
    codeSnippet: `class FullStackTest {
    companion object {
        @Container
        @JvmStatic
        val environment = DockerComposeContainer(
            File("docker-compose-test.yml")
        )
            .withExposedService("postgres", 5432,
                Wait.forListeningPort())
            .withExposedService("redis", 6379,
                Wait.forListeningPort())
            .withExposedService("kafka", 9092,
                Wait.forLogMessage(".*started.*", 1))
    }

    private val pgHost get() =
        environment.getServiceHost("postgres", 5432)
    private val pgPort get() =
        environment.getServicePort("postgres", 5432)
}`,
    options: [
      'Docker Compose must be run manually before tests; Testcontainers only connects to existing services',
      'DockerComposeContainer only parses the YAML file to extract image names, then starts individual GenericContainers',
      'DockerComposeContainer starts all services defined in a docker-compose file, with configurable wait strategies and dynamic host/port resolution',
      'DockerComposeContainer requires Docker Compose v1 and does not support v2 syntax',
    ],
    correctAnswer: 2,
    explanation: 'DockerComposeContainer integrates with Docker Compose to start an entire service topology from a compose file. You configure wait strategies per service (port listening, log message patterns, HTTP health checks) and retrieve dynamic host/port mappings via getServiceHost/getServicePort. This enables testing multi-service architectures end-to-end.',
    tags: ['testcontainers', 'docker-compose', 'multi-service'],
  },
  {
    id: 'kotlin-testing-l4-031',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'TestContainers',
    question: 'What are Testcontainers wait strategies and why are they important?',
    codeSnippet: `val container = GenericContainer("my-service:latest")
    .withExposedPorts(8080)
    .waitingFor(
        Wait.forHttp("/health")
            .forStatusCode(200)
            .withStartupTimeout(Duration.ofSeconds(60))
    )

// Alternative strategies:
// Wait.forListeningPort()
// Wait.forLogMessage(".*Ready to accept connections.*", 1)
// Wait.forHealthcheck()`,
    options: [
      'Wait strategies configure retry logic for failed test assertions',
      'Wait strategies define conditions that must be met before the container is considered ready, preventing tests from running against partially-initialized services',
      'Wait strategies determine the order in which multiple containers start',
      'Wait strategies pause the test for a fixed duration to let the container initialize',
    ],
    correctAnswer: 1,
    explanation: 'Wait strategies ensure a container is fully ready before tests execute. forListeningPort() waits for TCP port availability, forHttp() polls an HTTP endpoint, forLogMessage() watches container logs for a pattern, and forHealthcheck() uses the Docker HEALTHCHECK. Without proper wait strategies, tests may fail intermittently due to race conditions with container startup.',
    tags: ['testcontainers', 'wait-strategies', 'reliability'],
  },
  {
    id: 'kotlin-testing-l4-032',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'Architecture Testing',
    question: 'How does ArchUnit work for enforcing architectural rules in Kotlin/JVM projects?',
    codeSnippet: `@AnalyzeClasses(packages = ["com.example.app"])
class ArchitectureTest {
    @ArchTest
    val layerRule: ArchRule = layeredArchitecture()
        .consideringAllDependencies()
        .layer("Controller").definedBy("..controller..")
        .layer("Service").definedBy("..service..")
        .layer("Repository").definedBy("..repository..")
        .whereLayer("Controller").mayNotBeAccessedByAnyLayer()
        .whereLayer("Service").mayOnlyBeAccessedByLayers("Controller")
        .whereLayer("Repository").mayOnlyBeAccessedByLayers("Service")
}`,
    options: [
      'ArchUnit requires a custom Gradle plugin to enforce rules at compile time',
      'ArchUnit inspects source code files with regex to find import violations',
      'ArchUnit analyzes compiled bytecode to verify architectural constraints like layer dependencies, naming conventions, and package structure as executable tests',
      'ArchUnit only supports Java and cannot analyze Kotlin bytecode',
    ],
    correctAnswer: 2,
    explanation: 'ArchUnit analyzes compiled JVM bytecode (.class files) to verify architectural rules. It works with Kotlin because Kotlin compiles to JVM bytecode. You can enforce layered architecture, check that classes in certain packages do not depend on others, verify naming conventions, annotation usage, and more. Rules are expressed as regular JUnit tests.',
    tags: ['archunit', 'architecture', 'layer-rules'],
  },
  {
    id: 'kotlin-testing-l4-033',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'Architecture Testing',
    question: 'How do you enforce that domain classes have no framework dependencies using ArchUnit?',
    codeSnippet: `@ArchTest
val domainShouldNotDependOnFrameworks: ArchRule =
    noClasses()
        .that().resideInAPackage("..domain..")
        .should().dependOnClassesThat()
        .resideInAnyPackage(
            "org.springframework..",
            "jakarta..",
            "io.ktor..",
            "org.jetbrains.exposed.."
        )
        .because("Domain layer must be framework-independent")`,
    options: [
      'This rule removes framework annotations from domain classes at compile time',
      'This rule ensures classes in the domain package have no compile-time dependencies on specified framework packages, enforcing clean architecture boundaries',
      'This rule only checks that domain classes do not extend framework classes',
      'This rule prevents domain classes from having any imports at all',
    ],
    correctAnswer: 1,
    explanation: 'This ArchUnit rule verifies that no class in the domain package has any dependency (field types, method parameters, return types, annotations, etc.) on specified framework packages. This enforces the dependency inversion principle of clean/hexagonal architecture, ensuring the domain layer remains portable and framework-agnostic.',
    tags: ['archunit', 'clean-architecture', 'dependencies'],
  },
  {
    id: 'kotlin-testing-l4-034',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'Architecture Testing',
    question: 'How can you use ArchUnit to enforce coding conventions across a Kotlin codebase?',
    codeSnippet: `@ArchTest
val repositoriesShouldBeInterfaces: ArchRule =
    classes()
        .that().haveNameMatching(".*Repository")
        .should().beInterfaces()

@ArchTest
val controllersShouldBeAnnotated: ArchRule =
    classes()
        .that().resideInAPackage("..controller..")
        .should().beAnnotatedWith(RestController::class.java)

@ArchTest
val noFieldInjection: ArchRule =
    noFields()
        .should().beAnnotatedWith(Autowired::class.java)
        .because("Use constructor injection instead")`,
    options: [
      'These rules run a linter on Kotlin source files',
      'These rules generate Kotlin source code that follows conventions',
      'These rules verify class-level conventions like naming patterns, required annotations, and forbidden patterns through bytecode analysis',
      'These rules modify the bytecode to add missing annotations',
    ],
    correctAnswer: 2,
    explanation: 'ArchUnit can enforce coding conventions by asserting on class characteristics: naming patterns (haveNameMatching), type constraints (beInterfaces), annotation requirements (beAnnotatedWith), and anti-patterns (no field injection). Since these are tests, they run in CI and fail the build on violations, providing automated governance of coding standards.',
    tags: ['archunit', 'conventions', 'enforcement'],
  },
  {
    id: 'kotlin-testing-l4-035',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'Architecture Testing',
    question: 'How do you test for cyclic dependencies between packages using ArchUnit?',
    codeSnippet: `@ArchTest
val noCyclicDependencies: ArchRule =
    slices()
        .matching("com.example.app.(*)..")
        .should().beFreeOfCycles()

@ArchTest
val noCyclesInModules: ArchRule =
    slices()
        .matching("com.example.app.(**)")
        .should().notDependOnEachOther()`,
    options: [
      'beFreeOfCycles() removes cyclic imports from the compiled bytecode',
      'beFreeOfCycles() performs a topological sort and fails if any cycle exists; notDependOnEachOther() ensures no two slices have mutual dependencies',
      'These rules check for recursive function calls within packages',
      'Cycle detection only works at the class level, not the package level',
    ],
    correctAnswer: 1,
    explanation: 'ArchUnit\'s slices API groups classes by package pattern. beFreeOfCycles() performs cycle detection across package slices and reports the exact cycle path on failure. notDependOnEachOther() is stricter, ensuring no slice depends on any other. These rules prevent the architecture from degrading into a tangled dependency mess over time.',
    tags: ['archunit', 'cyclic-dependencies', 'slices'],
  },
  {
    id: 'kotlin-testing-l4-036',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'Mutation Testing',
    question: 'What is mutation testing and how does Pitest work with Kotlin?',
    options: [
      'Mutation testing verifies that the code compiles after random modifications',
      'Mutation testing generates additional test cases to increase code coverage',
      'Mutation testing introduces small changes (mutations) to production code and checks if tests detect them; Pitest modifies bytecode and runs the test suite against each mutant',
      'Mutation testing randomly changes test inputs to find flaky tests',
    ],
    correctAnswer: 2,
    explanation: 'Mutation testing evaluates test suite quality by introducing small defects (mutants) into production code, such as changing operators, removing statements, or altering return values. If tests still pass after a mutation, it is a "surviving mutant" indicating weak test coverage for that logic. Pitest performs this at the bytecode level, making it compatible with Kotlin.',
    tags: ['mutation-testing', 'pitest', 'test-quality'],
  },
  {
    id: 'kotlin-testing-l4-037',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'Mutation Testing',
    question: 'What types of mutations does Pitest typically introduce?',
    codeSnippet: `// Original code:
fun isEligible(age: Int, score: Double): Boolean {
    return age >= 18 && score > 75.0
}

// Possible mutations:
// 1. age >= 18  ->  age > 18   (boundary)
// 2. age >= 18  ->  age < 18   (negation)
// 3. &&         ->  ||          (logical operator)
// 4. score > 75 ->  score >= 75 (boundary)
// 5. return true               (return value)`,
    options: [
      'Pitest only removes random lines of code',
      'Pitest changes all method visibility to private',
      'Pitest applies mutators like conditional boundary changes, negation, math operator replacement, return value alteration, and void method call removal',
      'Pitest only changes numeric constants to zero',
    ],
    correctAnswer: 2,
    explanation: 'Pitest provides multiple mutator groups: CONDITIONALS_BOUNDARY (>= to >), NEGATE_CONDITIONALS (> to <=), MATH (+ to -), RETURN_VALS (change returns), VOID_METHOD_CALLS (remove void calls), INCREMENTS (++ to --), and more. Each tests whether your test suite actually verifies the specific logic being mutated.',
    tags: ['pitest', 'mutators', 'mutation-types'],
  },
  {
    id: 'kotlin-testing-l4-038',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'Mutation Testing',
    question: 'How do you interpret Pitest mutation testing results?',
    options: [
      'Mutation score = (killed mutants / total mutants) x 100; higher scores indicate the test suite effectively detects code changes; surviving mutants highlight untested logic',
      'Mutation testing replaces the need for code coverage metrics entirely',
      'Surviving mutants are always false positives and can be ignored',
      'A mutation score of 100% means the code has no bugs',
    ],
    correctAnswer: 0,
    explanation: 'The mutation score represents the percentage of mutants killed (detected) by the test suite. A killed mutant means a test failed when the code was changed. A surviving mutant means no test caught the change, indicating a testing gap. Mutation score is a more meaningful quality metric than line/branch coverage because it measures test effectiveness, not just execution.',
    tags: ['pitest', 'mutation-score', 'analysis'],
  },
  {
    id: 'kotlin-testing-l4-039',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'Mutation Testing',
    question: 'How do you configure Pitest for a Kotlin project with Gradle?',
    codeSnippet: `plugins {
    id("info.solidsoft.pitest") version "1.15.0"
}

pitest {
    targetClasses.set(listOf("com.example.domain.*"))
    targetTests.set(listOf("com.example.domain.*Test"))
    mutators.set(listOf("DEFAULTS"))
    avoidCallsTo.set(listOf(
        "kotlin.jvm.internal",
        "kotlinx.coroutines"
    ))
    outputFormats.set(listOf("HTML", "XML"))
    timestampedReports.set(false)
    threads.set(4)
}`,
    options: [
      'Configure targetClasses for code to mutate, targetTests for test suite, avoidCallsTo to skip Kotlin internals, and mutators for mutation strategies',
      'Pitest only works with Maven, not Gradle, for Kotlin projects',
      'Use the kotlin-pitest plugin instead of the standard pitest plugin',
      'No configuration needed; Pitest auto-detects Kotlin code',
    ],
    correctAnswer: 0,
    explanation: 'Pitest configuration specifies which classes to mutate (targetClasses), which tests to run (targetTests), and which mutators to apply. For Kotlin, avoidCallsTo should include kotlin.jvm.internal to skip compiler-generated code. threads controls parallelism. The info.solidsoft.pitest Gradle plugin integrates Pitest into the build, generating HTML reports of mutation results.',
    tags: ['pitest', 'gradle', 'configuration'],
  },
  {
    id: 'kotlin-testing-l4-040',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'Integration Testing',
    question: 'How do you structure Spring Boot integration tests with @SpringBootTest in Kotlin?',
    codeSnippet: `@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@ActiveProfiles("test")
class OrderApiIntegrationTest @Autowired constructor(
    val restTemplate: TestRestTemplate,
    val orderRepository: OrderRepository
) {
    @BeforeEach
    fun setup() {
        orderRepository.deleteAll()
    }

    @Test
    fun \`create order returns 201\`() {
        val request = CreateOrderRequest("item-1", 2)
        val response = restTemplate.postForEntity(
            "/api/orders", request, OrderResponse::class.java
        )
        response.statusCode shouldBe HttpStatus.CREATED
        orderRepository.count() shouldBe 1
    }
}`,
    options: [
      '@SpringBootTest mocks all beans and does not start a real server',
      '@SpringBootTest only loads the web layer without the database',
      '@SpringBootTest with RANDOM_PORT starts the full application context with a real embedded server, enabling end-to-end HTTP testing with TestRestTemplate',
      '@SpringBootTest requires a running external application server',
    ],
    correctAnswer: 2,
    explanation: '@SpringBootTest with RANDOM_PORT starts the complete Spring application context including an embedded web server on a random available port. TestRestTemplate makes real HTTP requests. Combined with @ActiveProfiles("test") for test configuration and injected repositories for setup/verification, this enables true integration testing of the full request/response cycle.',
    tags: ['spring-boot', 'integration-testing', 'rest-api'],
  },
  {
    id: 'kotlin-testing-l4-041',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'Integration Testing',
    question: 'How do you test Ktor server applications with integration tests?',
    codeSnippet: `class ApiTest {
    @Test
    fun testGetUsers() = testApplication {
        application {
            configureSerialization()
            configureRouting()
        }

        val response = client.get("/api/users") {
            header(
                HttpHeaders.Accept,
                ContentType.Application.Json.toString()
            )
        }

        response.status shouldBe HttpStatusCode.OK
        val users = response.body<List<User>>()
        users.shouldNotBeEmpty()
    }
}`,
    options: [
      'Ktor tests require starting a real Netty server on a fixed port',
      'Ktor uses JUnit @Rule to start an embedded server',
      'testApplication only supports GET requests for testing',
      'testApplication { } creates an in-process test server without network binding, providing a client for HTTP-like calls through the engine directly',
    ],
    correctAnswer: 3,
    explanation: 'Ktor\'s testApplication DSL creates a test environment that processes requests through the engine pipeline without binding to a network port. The client property provides an HttpClient for making requests. You configure the application block with modules/plugins. This approach is fast (no TCP overhead) while testing the full request processing pipeline including routing, serialization, and middleware.',
    tags: ['ktor', 'integration-testing', 'test-application'],
  },
  {
    id: 'kotlin-testing-l4-042',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'Integration Testing',
    question: 'How do you test database migrations with Flyway or Liquibase in integration tests?',
    codeSnippet: `@Testcontainers
@SpringBootTest
class MigrationTest {
    companion object {
        @Container
        @JvmStatic
        val postgres = PostgreSQLContainer("postgres:15")
    }

    @Autowired lateinit var flyway: Flyway
    @Autowired lateinit var jdbcTemplate: JdbcTemplate

    @Test
    fun \`all migrations run successfully\`() {
        val info = flyway.info()
        info.pending().shouldBeEmpty()
        info.failed().shouldBeEmpty()
        info.applied().shouldNotBeEmpty()
    }

    @Test
    fun \`users table has correct schema\`() {
        val columns = jdbcTemplate.queryForList(
            """SELECT column_name
               FROM information_schema.columns
               WHERE table_name = 'users'"""
        )
        columns.map { it["column_name"] } shouldContainAll
            listOf("id", "email", "created_at")
    }
}`,
    options: [
      'Migration testing is unnecessary if you have unit tests for repositories',
      'Use Testcontainers to run migrations against a real database engine, then verify migration status and resulting schema structure',
      'Run migrations against H2 with compatibility mode only',
      'Only test migrations manually by inspecting the database after deployment',
    ],
    correctAnswer: 1,
    explanation: 'Database migration testing with Testcontainers ensures migrations run successfully against the actual database engine (not H2 with compatibility quirks). You can verify no pending/failed migrations exist, assert on resulting schema structure, and even test data migrations. This catches SQL dialect issues, constraint violations, and migration ordering problems before deployment.',
    tags: ['flyway', 'database', 'migration-testing'],
  },
  {
    id: 'kotlin-testing-l4-043',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'Integration Testing',
    question: 'How do you test Kafka message producers and consumers in integration tests?',
    codeSnippet: `@Testcontainers
class KafkaIntegrationTest {
    companion object {
        @Container
        @JvmStatic
        val kafka = KafkaContainer(
            DockerImageName.parse("confluentinc/cp-kafka:7.4.0")
        )
    }

    @Test
    fun \`producer sends and consumer receives\`() {
        val props = mapOf(
            BOOTSTRAP_SERVERS_CONFIG to kafka.bootstrapServers,
            KEY_SERIALIZER_CLASS_CONFIG to StringSerializer::class.java,
            VALUE_SERIALIZER_CLASS_CONFIG to StringSerializer::class.java
        )
        val producer = KafkaProducer<String, String>(props)
        producer.send(ProducerRecord("test-topic", "key", "value")).get()

        val consumer = createConsumer(kafka.bootstrapServers, "test-topic")
        val records = consumer.poll(Duration.ofSeconds(10))

        records.count() shouldBe 1
        records.first().value() shouldBe "value"
    }
}`,
    options: [
      'Use an embedded Kafka from Spring that does not require Docker',
      'Mock the KafkaTemplate and verify send() was called',
      'Use Testcontainers KafkaContainer to run a real Kafka broker, produce and consume messages, verifying end-to-end message flow',
      'Kafka cannot be tested in isolation; always test in staging',
    ],
    correctAnswer: 2,
    explanation: 'Testcontainers KafkaContainer runs a real Kafka broker in Docker. Tests can create producers and consumers with the dynamic bootstrapServers address, send messages, and verify consumption. This tests serialization, topic configuration, consumer group behavior, and message delivery guarantees with a real broker, catching issues that embedded or mocked Kafka would miss.',
    tags: ['kafka', 'testcontainers', 'messaging'],
  },
  {
    id: 'kotlin-testing-l4-044',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'Integration Testing',
    question: 'How do you test gRPC services in Kotlin?',
    codeSnippet: `class GreeterServiceTest {
    private lateinit var server: Server
    private lateinit var channel: ManagedChannel

    @BeforeEach
    fun setup() {
        server = ServerBuilder.forPort(0)
            .addService(GreeterServiceImpl())
            .build().start()

        channel = ManagedChannelBuilder
            .forAddress("localhost", server.port)
            .usePlaintext().build()
    }

    @Test
    fun \`greet returns personalized message\`() = runBlocking {
        val stub = GreeterGrpcKt.GreeterCoroutineStub(channel)
        val request = helloRequest { name = "World" }
        val response = stub.sayHello(request)
        response.message shouldBe "Hello, World!"
    }

    @AfterEach
    fun teardown() {
        channel.shutdown()
        server.shutdown()
    }
}`,
    options: [
      'gRPC testing requires a deployed server and cannot run locally',
      'Start an in-process gRPC server with the real service implementation, create a stub client, and make actual gRPC calls to verify responses',
      'Use MockK to mock the generated gRPC stubs',
      'gRPC services can only be tested via HTTP REST calls',
    ],
    correctAnswer: 1,
    explanation: 'gRPC integration tests start an in-process server on port 0 (random available port) with the real service implementation. A ManagedChannel connects to it, and a generated stub (CoroutineStub for Kotlin coroutines) makes real gRPC calls. This tests protobuf serialization, service logic, interceptors, and error handling with actual gRPC protocol mechanics.',
    tags: ['grpc', 'integration-testing', 'coroutines'],
  },
  {
    id: 'kotlin-testing-l4-045',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'Contract Testing',
    question: 'What is contract testing and how does Pact work for Kotlin services?',
    options: [
      'Contract testing verifies that consumer and provider services agree on API interaction formats; Pact generates contract files from consumer tests that the provider verifies',
      'Contract testing uses OpenAPI schemas to generate integration tests automatically',
      'Contract testing checks that legal/business contracts are correctly modeled in code',
      'Contract testing verifies that the code contracts (preconditions/postconditions) in function signatures are enforced',
    ],
    correctAnswer: 0,
    explanation: 'Contract testing (via Pact) ensures API compatibility between services. Consumer tests define expected interactions (request/response pairs) which generate contract files (pacts). Provider tests replay these interactions against the real provider, verifying it meets consumer expectations. This catches breaking API changes without requiring both services to be deployed together.',
    tags: ['pact', 'contract-testing', 'microservices'],
  },
  {
    id: 'kotlin-testing-l4-046',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'Contract Testing',
    question: 'How do you write a Pact consumer test in Kotlin?',
    codeSnippet: `@ExtendWith(PactConsumerTestExt::class)
class UserServiceConsumerTest {
    @Pact(consumer = "order-service", provider = "user-service")
    fun getUserPact(builder: PactDslWithProvider): V4Pact {
        return builder
            .given("user with id 1 exists")
            .uponReceiving("a request for user 1")
            .path("/api/users/1")
            .method("GET")
            .willRespondWith()
            .status(200)
            .headers(mapOf("Content-Type" to "application/json"))
            .body(PactDslJsonBody()
                .integerType("id", 1)
                .stringType("name", "Alice")
                .stringType("email", "alice@test.com"))
            .toPact(V4Pact::class.java)
    }

    @Test
    @PactTestFor(pactMethod = "getUserPact")
    fun \`fetches user by id\`(mockServer: MockServer) {
        val client = UserServiceClient(mockServer.getUrl())
        val user = client.getUser(1)
        user.name shouldBe "Alice"
    }
}`,
    options: [
      'The @Pact method defines the expected interaction; @PactTestFor runs the test against a Pact mock server that replays the defined response; the pact file is generated for provider verification',
      'The consumer test calls the real provider service and records the interaction',
      'Pact consumer tests require the provider to be running locally',
      'Consumer tests only validate request format without testing response handling',
    ],
    correctAnswer: 0,
    explanation: 'In a Pact consumer test, the @Pact method defines the expected request/response interaction using a DSL. @PactTestFor runs the test against a local mock server that returns the defined response. The test verifies the consumer can handle the response correctly. A pact file (JSON) is generated containing these interactions for later provider verification.',
    tags: ['pact', 'consumer-test', 'contract'],
  },
  {
    id: 'kotlin-testing-l4-047',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'Contract Testing',
    question: 'How do you write a Pact provider verification test in Kotlin?',
    codeSnippet: `@Provider("user-service")
@PactBroker(url = "https://pact-broker.example.com")
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class UserServiceProviderTest {
    @TestTemplate
    @ExtendWith(PactVerificationInvocationContextProvider::class)
    fun verifyPact(context: PactVerificationContext) {
        context.verifyInteraction()
    }

    @State("user with id 1 exists")
    fun setupUser() {
        userRepository.save(User(1, "Alice", "alice@test.com"))
    }

    @BeforeEach
    fun setup(context: PactVerificationContext) {
        context.target = HttpTestTarget("localhost", port)
    }
}`,
    options: [
      '@Provider and @PactBroker load consumer pacts; @State sets up required preconditions; @TestTemplate replays each interaction against the running provider and verifies the response matches',
      'Provider verification runs consumer tests against the provider directly',
      'Provider verification generates its own pact files and compares them with consumer pacts',
      'Provider tests only check that the API returns valid JSON',
    ],
    correctAnswer: 0,
    explanation: 'Provider verification loads pact files (from a broker or directory), sets up the provider state via @State methods that create required test data, then replays each consumer interaction as an HTTP request against the running provider. It verifies the actual response matches the pact\'s expected response (status, headers, body structure). This ensures the provider meets all consumer expectations.',
    tags: ['pact', 'provider-verification', 'contract'],
  },
  {
    id: 'kotlin-testing-l4-048',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'Contract Testing',
    question: 'How does Spring Cloud Contract work as an alternative to Pact for Kotlin services?',
    codeSnippet: `// contracts/shouldReturnUser.kts
import org.springframework.cloud.contract.spec.ContractDsl.Companion.contract

contract {
    request {
        method = GET
        url = url("/api/users/1")
    }
    response {
        status = OK
        headers {
            contentType = APPLICATION_JSON
        }
        body = body(mapOf(
            "id" to 1,
            "name" to value(
                producer(regex("[A-Za-z]+")),
                consumer("Alice")
            )
        ))
    }
}`,
    options: [
      'Spring Cloud Contract is identical to Pact but with Spring syntax',
      'Spring Cloud Contract requires both services to be in the same repository',
      'Spring Cloud Contract generates both provider tests and consumer stubs from a single contract DSL definition, using a provider-driven approach',
      'Spring Cloud Contract only generates API documentation, not tests',
    ],
    correctAnswer: 2,
    explanation: 'Spring Cloud Contract takes a provider-driven approach: contracts are defined in the provider project using a Kotlin/Groovy/YAML DSL. The framework auto-generates provider-side tests and a WireMock-based stub JAR. Consumers use the stub JAR for integration testing. This differs from Pact\'s consumer-driven approach but achieves the same goal of API compatibility verification.',
    tags: ['spring-cloud-contract', 'contract-testing', 'stubs'],
  },
  {
    id: 'kotlin-testing-l4-049',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'BDD',
    question: 'How does BDD (Behavior-Driven Development) testing work with Kotest BehaviorSpec?',
    codeSnippet: `class ShoppingCartSpec : BehaviorSpec({
    Given("an empty shopping cart") {
        val cart = ShoppingCart()

        When("adding a product with quantity 2") {
            cart.add(Product("Widget", 9.99), quantity = 2)

            Then("the cart should contain 1 item type") {
                cart.itemCount shouldBe 1
            }

            Then("the total should be 19.98") {
                cart.total shouldBe 19.98.toBigDecimal()
            }
        }

        When("checking out without items") {
            Then("it should throw EmptyCartException") {
                shouldThrow<EmptyCartException> {
                    ShoppingCart().checkout()
                }
            }
        }
    }
})`,
    options: [
      'BehaviorSpec requires a separate Gherkin file to define scenarios',
      'BehaviorSpec structures tests in Given/When/Then blocks that map to BDD scenarios, creating nested contexts where Given sets up preconditions, When performs actions, and Then verifies outcomes',
      'BehaviorSpec only supports a flat list of test cases with Given/When/Then prefixes',
      'BehaviorSpec uses Given/When/Then syntax for readability, but tests execute identically to FunSpec',
    ],
    correctAnswer: 1,
    explanation: 'BehaviorSpec organizes tests in a nested Given/When/Then structure that directly maps to BDD scenarios. Given establishes the context/preconditions, When describes the action or event, and Then specifies the expected outcome. The nesting creates a natural hierarchy where multiple When blocks can share a Given context, and multiple Then blocks can verify different aspects of a When action.',
    tags: ['bdd', 'kotest', 'behavior-spec'],
  },
  {
    id: 'kotlin-testing-l4-050',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'BDD',
    question: 'How do you implement BDD with Cucumber in Kotlin?',
    codeSnippet: `// feature file: login.feature
// Feature: User Login
//   Scenario: Successful login
//     Given a registered user with email "user@test.com"
//     When the user logs in with correct credentials
//     Then the response status should be 200
//     And the response should contain a valid JWT token

class LoginSteps {
    private lateinit var response: Response

    @Given("a registered user with email {string}")
    fun registerUser(email: String) {
        userRepository.save(
            User(email = email, password = hash("password"))
        )
    }

    @When("the user logs in with correct credentials")
    fun login() {
        response = client.post("/login",
            LoginRequest("user@test.com", "password"))
    }

    @Then("the response status should be {int}")
    fun verifyStatus(status: Int) {
        response.statusCode shouldBe status
    }
}`,
    options: [
      'Cucumber parses Gherkin feature files and matches Given/When/Then steps to annotated Kotlin functions that implement the test logic',
      'Cucumber automatically generates step definitions from feature files',
      'Cucumber requires all step definitions to be in Java, even for Kotlin projects',
      'Cucumber feature files are compiled into Kotlin test classes',
    ],
    correctAnswer: 0,
    explanation: 'Cucumber uses Gherkin syntax in .feature files to describe behavior in plain language. Step definition classes (in Kotlin) implement the actual test logic using @Given, @When, @Then, @And annotations. Cucumber matches each step in the feature file to the corresponding annotated method via regex or Cucumber expressions. This separates business-readable specs from technical implementation.',
    tags: ['cucumber', 'bdd', 'gherkin'],
  },
  {
    id: 'kotlin-testing-l4-051',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'BDD',
    question: 'How do you implement data-driven BDD scenarios with Cucumber Scenario Outlines?',
    codeSnippet: `# Feature: Price Calculation
#   Scenario Outline: Discount based on quantity
#     Given a product with base price <price>
#     When the customer orders <quantity> items
#     Then the discount should be <discount>%
#     And the total should be <total>
#
#     Examples:
#       | price | quantity | discount | total   |
#       | 100   | 1        | 0        | 100.00  |
#       | 100   | 10       | 5        | 950.00  |
#       | 100   | 50       | 10       | 4500.00 |
#       | 100   | 100      | 15       | 8500.00 |`,
    options: [
      'Scenario Outlines require separate step definitions for each row',
      'Scenario Outlines run the same scenario once with all values combined',
      'Scenario Outlines only work with numeric parameters',
      'Scenario Outlines are templates that execute once per row in the Examples table, substituting placeholder values, enabling data-driven BDD tests',
    ],
    correctAnswer: 3,
    explanation: 'Scenario Outlines are parameterized scenarios. Placeholders (<price>, <quantity>) are replaced with values from each row of the Examples table. The scenario executes once per row, using the same step definitions. This enables comprehensive data-driven testing while maintaining BDD readability. Each row appears as a separate test in the report.',
    tags: ['cucumber', 'bdd', 'scenario-outline'],
  },
  {
    id: 'kotlin-testing-l4-052',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'Custom Assertions',
    question: 'How do you create custom Kotest matchers for domain-specific assertions?',
    codeSnippet: `fun beValidEmail() = object : Matcher<String> {
    override fun test(value: String): MatcherResult {
        val regex = Regex("^[\\\\w.]+@[\\\\w.]+\\\\.[a-zA-Z]{2,}$")
        return MatcherResult(
            value.matches(regex),
            { "\\"$value\\" should be a valid email address" },
            { "\\"$value\\" should not be a valid email address" }
        )
    }
}

fun String.shouldBeValidEmail() = this should beValidEmail()
fun String.shouldNotBeValidEmail() = this shouldNot beValidEmail()

// Usage:
"user@test.com".shouldBeValidEmail()
"invalid".shouldNotBeValidEmail()`,
    options: [
      'Custom matchers are created by extending AbstractMatcher and overriding match()',
      'Create a class annotated with @CustomMatcher',
      'Custom matchers require a Kotest plugin to be registered',
      'Implement Matcher<T> with a test() method returning MatcherResult (pass/fail boolean + failure messages), then create shouldBe extension functions for DSL usage',
    ],
    correctAnswer: 3,
    explanation: 'Kotest custom matchers implement the Matcher<T> interface with a test() method that returns a MatcherResult containing: the boolean result, a failure message for positive assertions, and a failure message for negated assertions. Extension functions like shouldBeX() using should/shouldNot provide the idiomatic DSL. This enables expressive, domain-specific assertions.',
    tags: ['kotest', 'custom-matchers', 'assertions'],
  },
  {
    id: 'kotlin-testing-l4-053',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'Custom Assertions',
    question: 'How do you create composed matchers that combine multiple checks?',
    codeSnippet: `fun beAdult() = Matcher<User> { user ->
    MatcherResult(user.age >= 18,
        { "Expected age >= 18 but was \${user.age}" },
        { "Expected age < 18 but was \${user.age}" })
}

fun haveVerifiedEmail() = Matcher<User> { user ->
    MatcherResult(user.emailVerified,
        { "Expected verified email" },
        { "Expected unverified email" })
}

// Composing matchers with 'and' / 'or'
user should (beAdult() and haveVerifiedEmail())`,
    options: [
      'Use assertSoftly instead of matcher composition',
      'Kotest matchers support composition via and/or operators, combining multiple Matcher<T> instances into a single compound matcher with aggregated failure messages',
      'Matchers cannot be composed; each check must be a separate assertion',
      'Matcher composition requires a special ComposedMatcher wrapper class',
    ],
    correctAnswer: 1,
    explanation: 'Kotest matchers support infix composition with and/or operators. (matcherA and matcherB) creates a new matcher that passes only if both pass, with combined failure messages. (matcherA or matcherB) passes if either passes. This enables building complex domain assertions from simple, reusable building blocks while maintaining clear failure diagnostics.',
    tags: ['kotest', 'matcher-composition', 'assertions'],
  },
  {
    id: 'kotlin-testing-l4-054',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'Custom Assertions',
    question: 'How do you create custom assertions for collection types in Kotest?',
    codeSnippet: `fun <T> containExactlyInAnyOrderBy(
    expected: Collection<T>,
    selector: (T) -> Any?
) = object : Matcher<Collection<T>> {
    override fun test(value: Collection<T>): MatcherResult {
        val actualKeys = value.map(selector).toSet()
        val expectedKeys = expected.map(selector).toSet()
        val missing = expectedKeys - actualKeys
        val extra = actualKeys - expectedKeys
        return MatcherResult(
            missing.isEmpty() && extra.isEmpty(),
            { "Missing: $missing, Extra: $extra" },
            { "Collections should differ but match: $actualKeys" }
        )
    }
}

// Usage:
users should containExactlyInAnyOrderBy(expectedUsers) { it.id }`,
    options: [
      'Collection matchers require serializing both collections to JSON for comparison',
      'Collection matchers must operate on the entire collection as a single value',
      'Custom collection matchers use Matcher<Collection<T>> with generic type parameters, enabling key-based comparison and detailed diff reporting for missing/extra elements',
      'Kotest does not support generic custom matchers',
    ],
    correctAnswer: 2,
    explanation: 'Custom collection matchers in Kotest use Matcher<Collection<T>> with generics. The example compares collections by a selector (e.g., ID) rather than full equality, reporting specific missing and extra elements. This pattern is powerful for domain testing where you need semantic comparison (e.g., matching users by ID regardless of field updates) with clear failure diagnostics.',
    tags: ['kotest', 'collection-matchers', 'generics'],
  },
  {
    id: 'kotlin-testing-l4-055',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'Custom Assertions',
    question: 'How do you create assertion functions that provide structured failure output for complex objects?',
    codeSnippet: `fun OrderResponse.shouldMatchExpected(expected: ExpectedOrder) {
    assertSoftly(this) {
        status shouldBe expected.status
        items.shouldHaveSize(expected.itemCount)
        items.forEachIndexed { i, item ->
            withClue("Item[$i]") {
                item.productId shouldBe expected.items[i].productId
                item.quantity shouldBe expected.items[i].quantity
                item.price.shouldBeBetween(
                    expected.items[i].price * 0.99.toBigDecimal(),
                    expected.items[i].price * 1.01.toBigDecimal(),
                    2
                )
            }
        }
        total shouldBeGreaterThan BigDecimal.ZERO
    }
}`,
    options: [
      'Complex objects should only be compared by their hashCode',
      'Override toString() on test objects for better error messages',
      'Combine assertSoftly for collecting all failures, withClue for contextual error messages, and domain-specific extension functions for readable, comprehensive assertions on complex objects',
      'Use JSON comparison libraries to diff complex objects',
    ],
    correctAnswer: 2,
    explanation: 'For complex domain assertions, combine: assertSoftly to report all failures (not just the first), withClue("context") to add descriptive prefixes to failure messages, and extension functions on domain types for readability. This approach provides complete, actionable failure output showing exactly which fields differ and in what context (e.g., "Item[2]: expected quantity 5 but was 3").',
    tags: ['kotest', 'assertions', 'error-messages'],
  },
  {
    id: 'kotlin-testing-l4-056',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'MockK Advanced',
    question: 'How do you handle MockK\'s spyk for partial mocking in Kotlin?',
    codeSnippet: `class Calculator {
    fun add(a: Int, b: Int) = a + b
    fun multiply(a: Int, b: Int) = a * b
    fun complexCalculation(a: Int, b: Int): Int {
        return add(a, b) * multiply(a, b)
    }
}

val calc = spyk(Calculator())
every { calc.multiply(any(), any()) } returns 42

val result = calc.complexCalculation(2, 3)
// add(2,3) = 5 (real), multiply(2,3) = 42 (mocked)
// result = 5 * 42 = 210`,
    options: [
      'spyk creates a full mock that requires all methods to be stubbed',
      'spyk only works with interfaces, not concrete classes',
      'spyk records method calls but always executes the real implementation',
      'spyk creates a partial mock wrapping a real object: unstubbed methods delegate to the real implementation while stubbed methods return mocked values',
    ],
    correctAnswer: 3,
    explanation: 'spyk() (spy + mock) wraps a real object instance. By default, all method calls are delegated to the real implementation. You can selectively override specific methods with every { } while leaving others untouched. This is useful for testing classes where you want real behavior but need to control specific dependencies or side effects.',
    tags: ['mockk', 'spy', 'partial-mocking'],
  },
  {
    id: 'kotlin-testing-l4-057',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'MockK Advanced',
    question: 'How do you mock object declarations (singletons) in MockK?',
    codeSnippet: `object AppConfig {
    fun getApiUrl() = System.getenv("API_URL") ?: "https://api.prod.com"
    fun getTimeout() = 30_000L
}

class ApiClientTest {
    @Test
    fun testWithMockedConfig() {
        mockkObject(AppConfig)

        every { AppConfig.getApiUrl() } returns "https://test.local"
        every { AppConfig.getTimeout() } returns 1000L

        val client = ApiClient() // uses AppConfig internally
        client.baseUrl shouldBe "https://test.local"

        unmockkObject(AppConfig)
    }
}`,
    options: [
      'Use reflection to replace the INSTANCE field of the object',
      'Kotlin object declarations cannot be mocked',
      'Convert the object to a class with a companion object for testability',
      'mockkObject() enables mocking methods on Kotlin object declarations (singletons), allowing tests to override their behavior; use unmockkObject() to restore',
    ],
    correctAnswer: 3,
    explanation: 'MockK\'s mockkObject() instruments Kotlin object declarations (singletons) to allow method stubbing. Since objects are compiler-generated singletons, this modifies the single instance in-place. Always call unmockkObject() afterward to restore original behavior and prevent test pollution. This is essential for testing code that depends on singleton configuration or utility objects.',
    tags: ['mockk', 'object-mocking', 'singleton'],
  },
  {
    id: 'kotlin-testing-l4-058',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'Coroutine Testing',
    question: 'How do you test Flow operators like debounce, throttle, and distinctUntilChanged?',
    codeSnippet: `@Test
fun testDebouncedSearch() = runTest {
    val searchFlow = MutableSharedFlow<String>()

    val results = searchFlow
        .debounce(300)
        .distinctUntilChanged()
        .map { query -> searchApi.search(query) }

    results.test {
        searchFlow.emit("k")
        searchFlow.emit("ko")
        searchFlow.emit("kot")

        advanceTimeBy(300)
        awaitItem() shouldBe searchApi.search("kot")

        searchFlow.emit("kot") // same value
        advanceTimeBy(300)
        // no emission due to distinctUntilChanged

        expectNoEvents()
        cancelAndIgnoreRemainingEvents()
    }
}`,
    options: [
      'Mock the Flow operators themselves to remove timing',
      'Time-based Flow operators cannot be tested; use manual delays instead',
      'Use real delays with generous timeouts for time-based operator tests',
      'Use runTest with virtual time control (advanceTimeBy) combined with Turbine for deterministic testing of debounce/throttle/delay operators, and expectNoEvents() to verify filtered emissions',
    ],
    correctAnswer: 3,
    explanation: 'runTest provides virtual time that integrates with Flow\'s time-based operators. advanceTimeBy(300) progresses past the debounce window, causing buffered emissions to fire. Turbine\'s test { } receives emissions deterministically, and expectNoEvents() verifies that filtered values (like duplicates with distinctUntilChanged) produce no output. This combination enables fast, deterministic tests.',
    tags: ['flow', 'turbine', 'debounce', 'virtual-time'],
  },
  {
    id: 'kotlin-testing-l4-059',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'Integration Testing',
    question: 'How do you test WebSocket connections in Ktor?',
    codeSnippet: `@Test
fun testWebSocket() = testApplication {
    application {
        install(WebSockets)
        routing {
            webSocket("/chat") {
                for (frame in incoming) {
                    if (frame is Frame.Text) {
                        send(Frame.Text("Echo: \${frame.readText()}"))
                    }
                }
            }
        }
    }

    val client = createClient {
        install(io.ktor.client.plugins.websocket.WebSockets)
    }

    client.webSocket("/chat") {
        send(Frame.Text("Hello"))
        val response = (incoming.receive() as Frame.Text).readText()
        response shouldBe "Echo: Hello"
    }
}`,
    options: [
      'WebSocket tests must use Thread.sleep() to wait for messages',
      'Mock the WebSocket session instead of testing real frame exchange',
      'WebSocket testing requires a real network server and cannot use testApplication',
      'Use testApplication with a WebSocket-configured client to establish in-process WebSocket connections, send frames, and verify responses',
    ],
    correctAnswer: 3,
    explanation: 'Ktor\'s testApplication supports WebSocket testing. Install the WebSockets plugin on both server and client sides. The client.webSocket() block establishes an in-process WebSocket connection, where you can send frames, receive responses, and assert on the exchanged messages. No actual TCP connection is made, keeping tests fast and deterministic.',
    tags: ['ktor', 'websocket', 'integration-testing'],
  },
  {
    id: 'kotlin-testing-l4-060',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'TestContainers',
    question: 'How do you use Testcontainers with Kotlin\'s Exposed ORM for database testing?',
    codeSnippet: `@Testcontainers
class UserRepositoryTest {
    companion object {
        @Container
        @JvmStatic
        val postgres = PostgreSQLContainer("postgres:15")
    }

    @BeforeEach
    fun setup() {
        Database.connect(
            url = postgres.jdbcUrl,
            driver = postgres.driverClassName,
            user = postgres.username,
            password = postgres.password
        )
        transaction { SchemaUtils.create(UsersTable) }
    }

    @Test
    fun \`insert and query user\`() = transaction {
        UsersTable.insert {
            it[name] = "Alice"
            it[email] = "alice@test.com"
        }

        val user = UsersTable.selectAll()
            .where { UsersTable.name eq "Alice" }
            .single()

        user[UsersTable.email] shouldBe "alice@test.com"
    }
}`,
    options: [
      'Use mockkStatic to mock Exposed\'s transaction function',
      'Connect Exposed to the Testcontainers-provided JDBC URL, create schema in setup, and run queries in transaction blocks with assertions',
      'Exposed can only be tested with H2 in-memory databases',
      'Exposed ORM requires a special Testcontainers adapter',
    ],
    correctAnswer: 1,
    explanation: 'Testing Exposed with Testcontainers involves connecting Database.connect() to the container\'s dynamic JDBC URL, creating the schema with SchemaUtils.create(), and running test queries within transaction { } blocks. This tests actual SQL generation, type mapping, and query behavior against a real PostgreSQL instance, catching dialect-specific issues.',
    tags: ['testcontainers', 'exposed', 'database-testing'],
  },
  {
    id: 'kotlin-testing-l4-061',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'Compose UI Testing',
    question: 'How do you test accessibility in Jetpack Compose?',
    codeSnippet: `@Test
fun accessibilityTest() {
    composeTestRule.setContent {
        ProfileScreen(user = testUser)
    }

    // Verify content descriptions for screen readers
    composeTestRule
        .onNodeWithContentDescription("User profile picture")
        .assertIsDisplayed()

    // Verify semantic properties
    composeTestRule
        .onNodeWithTag("name_field")
        .assert(hasText("Alice"))
        .assert(hasContentDescription("User name: Alice"))

    // Check that buttons have click actions
    composeTestRule
        .onNodeWithText("Edit Profile")
        .assert(hasClickAction())
        .assertIsEnabled()

    // Verify heading semantics
    composeTestRule
        .onNode(hasTestTag("section_header") and isHeading())
        .assertIsDisplayed()
}`,
    options: [
      'Compose UI testing does not support accessibility testing',
      'Accessibility is automatically correct in Compose and does not need testing',
      'Use a separate accessibility testing framework like Espresso AccessibilityChecks',
      'Query nodes by contentDescription, verify semantic properties (headings, roles, click actions), and assert that accessibility metadata is correctly set for screen readers',
    ],
    correctAnswer: 3,
    explanation: 'Compose\'s test API directly accesses the semantic tree, which is the same tree used by accessibility services. You can verify content descriptions, heading semantics (isHeading()), click actions (hasClickAction()), and other semantic properties. Testing these ensures screen readers and other assistive technologies can properly interpret the UI.',
    tags: ['compose', 'accessibility', 'semantic-tree'],
  },
  {
    id: 'kotlin-testing-l4-062',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'Kotest Advanced',
    question: 'How do you use Kotest\'s data-driven testing with row-based parameters?',
    codeSnippet: `class MathSpec : FunSpec({
    context("isPrime") {
        withData(
            nameFn = { "\${it.first} should\${if (it.second) "" else " not"} be prime" },
            2 to true,
            3 to true,
            4 to false,
            17 to true,
            25 to false,
            97 to true,
            100 to false,
        ) { (number, expected) ->
            isPrime(number) shouldBe expected
        }
    }
})`,
    options: [
      'Data-driven tests always run sequentially and cannot be parallelized',
      'withData only supports primitive types as parameters',
      'withData requires a special DataRow class for each parameter combination',
      'withData generates a separate test case for each input, with customizable test naming via nameFn and destructured parameters in the test body',
    ],
    correctAnswer: 3,
    explanation: 'Kotest\'s withData creates individual test cases for each data row. Each appears as a separate named test in the report. nameFn customizes the test name per row. Parameters are destructured in the test lambda. This supports any type (data classes, pairs, custom types) and integrates with Kotest\'s parallel execution and reporting.',
    tags: ['kotest', 'data-driven', 'parameterized'],
  },
  {
    id: 'kotlin-testing-l4-063',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'Integration Testing',
    question: 'How do you test caching behavior with Redis using Testcontainers?',
    codeSnippet: `@Testcontainers
class CacheIntegrationTest {
    companion object {
        @Container
        @JvmStatic
        val redis = GenericContainer("redis:7-alpine")
            .withExposedPorts(6379)
    }

    private lateinit var jedis: Jedis

    @BeforeEach
    fun setup() {
        jedis = Jedis(redis.host, redis.getMappedPort(6379))
        jedis.flushAll()
    }

    @Test
    fun \`cache stores and retrieves with TTL\`() {
        val cache = RedisCache(jedis)
        cache.put("user:1", """{"name":"Alice"}""", ttlSeconds = 2)

        cache.get("user:1") shouldBe """{"name":"Alice"}"""

        Thread.sleep(2500)
        cache.get("user:1").shouldBeNull()
    }

    @Test
    fun \`cache eviction works correctly\`() {
        val cache = RedisCache(jedis, maxSize = 3)
        (1..5).forEach { cache.put("key:$it", "value:$it") }
        jedis.dbSize() shouldBe 3
    }
}`,
    options: [
      'Use GenericContainer with Redis image to test actual cache operations including TTL expiration, eviction policies, and data serialization against a real Redis instance',
      'Mock the Redis client to simulate caching behavior',
      'Redis cannot be tested with Testcontainers; use an embedded alternative',
      'Only test cache hits/misses; never test TTL or eviction',
    ],
    correctAnswer: 0,
    explanation: 'Using GenericContainer("redis:...") launches a real Redis server in Docker. Tests can verify actual caching behavior: storage/retrieval, TTL-based expiration, eviction policies, and serialization formats. flushAll() in @BeforeEach ensures test isolation. This catches real Redis behavior nuances like TTL precision and memory limits that mocks cannot reproduce.',
    tags: ['testcontainers', 'redis', 'caching'],
  },
  {
    id: 'kotlin-testing-l4-064',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'BDD',
    question: 'How do you implement scenario hooks and shared state in Cucumber with Kotlin?',
    codeSnippet: `class Hooks {
    @Before
    fun setupScenario(scenario: Scenario) {
        TestContext.reset()
        println("Starting: \${scenario.name}")
    }

    @After
    fun teardown(scenario: Scenario) {
        if (scenario.isFailed) {
            takeScreenshot(scenario.name)
        }
        TestContext.cleanup()
    }

    @Before("@database")
    fun setupDatabase() {
        testDatabase.migrate()
        testDatabase.seed()
    }
}

object TestContext {
    lateinit var currentUser: User
    lateinit var lastResponse: Response
    fun reset() { /* clear state */ }
    fun cleanup() { /* release resources */ }
}`,
    options: [
      '@Before/@After hooks run per scenario; tagged hooks (e.g., @Before("@database")) run only for matching scenarios; shared state is managed through injected objects or singleton contexts',
      'Hooks are not supported in Cucumber with Kotlin step definitions',
      'Cucumber hooks run only at the suite level, not per scenario',
      'Use JUnit @BeforeEach/@AfterEach instead of Cucumber hooks',
    ],
    correctAnswer: 0,
    explanation: 'Cucumber\'s @Before and @After hooks run before and after each scenario. Tagged hooks like @Before("@database") run only for scenarios with that tag. The Scenario parameter provides context (name, status, tags). Shared state between step definition classes is managed through dependency injection (cucumber-picocontainer, cucumber-spring) or singleton objects like TestContext.',
    tags: ['cucumber', 'hooks', 'shared-state'],
  },
  {
    id: 'kotlin-testing-l4-065',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'Mutation Testing',
    question: 'How do you handle equivalent mutants in mutation testing?',
    options: [
      'Equivalent mutants are mutations that change behavior but all tests still pass',
      'Equivalent mutants are mutations that produce semantically identical code (same behavior as original), artificially lowering the mutation score; they must be identified and excluded from the score calculation',
      'Pitest automatically detects and removes all equivalent mutants',
      'Equivalent mutants only occur in dead code',
    ],
    correctAnswer: 1,
    explanation: 'Equivalent mutants are code changes that do not alter program behavior (e.g., changing i++ to ++i when the return value is unused). Since no test can kill them, they inflate the surviving mutant count and lower the mutation score unfairly. While fully automatic detection is undecidable, Pitest uses heuristics to avoid some. Manual review and avoidCallsTo configuration help manage the rest.',
    tags: ['mutation-testing', 'equivalent-mutants', 'analysis'],
  },
  {
    id: 'kotlin-testing-l4-066',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'Architecture Testing',
    question: 'How do you enforce hexagonal architecture boundaries with ArchUnit?',
    codeSnippet: `@ArchTest
val hexagonalArchitecture: ArchRule = Architectures.onionArchitecture()
    .domainModels("..domain.model..")
    .domainServices("..domain.service..")
    .applicationServices("..application..")
    .adapter("persistence", "..adapter.persistence..")
    .adapter("web", "..adapter.web..")
    .adapter("messaging", "..adapter.messaging..")

@ArchTest
val portsAreInterfaces: ArchRule = classes()
    .that().resideInAPackage("..port..")
    .should().beInterfaces()`,
    options: [
      'Hexagonal architecture cannot be enforced with automated tests',
      'Use Spring @ComponentScan restrictions instead of ArchUnit',
      'Only manual code reviews can enforce hexagonal architecture',
      'ArchUnit\'s onionArchitecture() DSL enforces that domain has no outward dependencies, adapters depend inward through ports, and ports are interfaces in the correct packages',
    ],
    correctAnswer: 3,
    explanation: 'ArchUnit\'s onionArchitecture() (and custom rules) can enforce hexagonal architecture: domain models have no external dependencies, domain services only depend on models, application services orchestrate domain, and adapters implement port interfaces to connect to external systems. This automated enforcement prevents architectural erosion over time.',
    tags: ['archunit', 'hexagonal-architecture', 'ports-adapters'],
  },
  {
    id: 'kotlin-testing-l4-067',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'Coroutine Testing',
    question: 'How do you test structured concurrency and supervision in coroutines?',
    codeSnippet: `@Test
fun testSupervision() = runTest {
    val results = mutableListOf<String>()

    val supervisor = SupervisorJob()
    val scope = CoroutineScope(coroutineContext + supervisor)

    scope.launch {
        delay(100)
        results.add("child1")
    }

    scope.launch {
        delay(50)
        throw RuntimeException("child2 failed")
    }

    scope.launch {
        delay(200)
        results.add("child3")
    }

    advanceUntilIdle()

    // With SupervisorJob, child2's failure doesn't cancel siblings
    results shouldContainExactly listOf("child1", "child3")
    supervisor.children.count() shouldBe 0
}`,
    options: [
      'Test supervision by launching children under a SupervisorJob, intentionally failing one, and verifying that sibling coroutines complete successfully despite the failure',
      'Use try/catch in each child coroutine instead of testing supervision',
      'SupervisorJob prevents all exceptions and tests cannot observe them',
      'Supervision cannot be tested because child coroutine failures are non-deterministic',
    ],
    correctAnswer: 0,
    explanation: 'Structured concurrency with SupervisorJob allows sibling coroutines to continue when one fails. Testing this involves creating a supervised scope, launching children (some that fail), advancing virtual time, and asserting that non-failing children completed successfully. This verifies correct supervision behavior and error isolation in concurrent workflows.',
    tags: ['coroutines', 'supervision', 'structured-concurrency'],
  },
  {
    id: 'kotlin-testing-l4-068',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'Integration Testing',
    question: 'How do you test retry and circuit breaker patterns?',
    codeSnippet: `@Test
fun \`retry succeeds on third attempt\`() = runTest {
    var attempts = 0
    val service = mockk<ExternalService>()

    coEvery { service.call() } answers {
        attempts++
        if (attempts < 3) throw IOException("Connection failed")
        else "success"
    }

    val resilient = ResilientClient(
        service, maxRetries = 3, delayMs = 100
    )

    val result = resilient.execute()
    result shouldBe "success"
    attempts shouldBe 3
    coVerify(exactly = 3) { service.call() }
}

@Test
fun \`circuit breaker opens after failures\`() = runTest {
    val breaker = CircuitBreaker(failureThreshold = 3)

    repeat(3) {
        shouldThrow<IOException> {
            breaker.execute { throw IOException() }
        }
    }

    breaker.state shouldBe CircuitBreaker.State.OPEN

    shouldThrow<CircuitBreakerOpenException> {
        breaker.execute { "should not reach here" }
    }
}`,
    options: [
      'Retry and circuit breaker logic is too complex to unit test',
      'Resilience patterns should only be tested in production environments',
      'Use Thread.sleep() to simulate real network timeouts',
      'Use mocks that fail a configurable number of times to verify retry counts and delays, and verify circuit breaker state transitions through controlled failure sequences',
    ],
    correctAnswer: 3,
    explanation: 'Testing resilience patterns involves: for retries, use mocks with answers { } blocks that fail N times then succeed, verifying the exact number of attempts and delay behavior. For circuit breakers, drive controlled failure sequences and assert state transitions (CLOSED -> OPEN -> HALF_OPEN -> CLOSED). Virtual time in runTest handles delay-based retry without real waiting.',
    tags: ['resilience', 'retry', 'circuit-breaker'],
  },
  {
    id: 'kotlin-testing-l4-069',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'Contract Testing',
    question: 'How do you test event-driven contracts with Pact for message-based systems?',
    codeSnippet: `@ExtendWith(PactConsumerTestExt::class)
class OrderEventConsumerTest {
    @Pact(consumer = "notification-service", provider = "order-service")
    fun orderCreatedPact(builder: MessagePactBuilder): MessagePact {
        return builder
            .expectsToReceive("an order created event")
            .withContent(PactDslJsonBody()
                .stringType("orderId", "ord-123")
                .stringType("status", "CREATED")
                .decimalType("total", 99.99))
            .toPact()
    }

    @Test
    @PactTestFor(pactMethod = "orderCreatedPact")
    fun \`handles order created event\`(messages: List<Message>) {
        val event = objectMapper.readValue<OrderCreatedEvent>(
            messages[0].contentsAsString()
        )
        val result = eventHandler.handle(event)
        result.shouldBeSuccess()
    }
}`,
    options: [
      'MessagePactBuilder defines expected message formats; consumer tests verify deserialization and handling; provider tests verify that published messages match the pact',
      'Use Pact\'s HTTP proxy to intercept message broker traffic',
      'Message contracts are defined in a separate schema registry, not Pact',
      'Pact only supports HTTP contract testing, not messaging',
    ],
    correctAnswer: 0,
    explanation: 'Pact supports message-based contract testing via MessagePactBuilder on the consumer side and @MessageProvider on the provider side. Consumer tests define expected message structure and verify the consumer can deserialize and handle it. Provider tests verify that the actual published messages match the pact\'s structure. This ensures async service compatibility.',
    tags: ['pact', 'messaging', 'event-driven'],
  },
  {
    id: 'kotlin-testing-l4-070',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'Kotest Advanced',
    question: 'How do you implement test tagging and conditional execution in Kotest?',
    codeSnippet: `object IntegrationTest : Tag()
object Slow : Tag()
object Database : Tag()

class TaggedSpec : FunSpec({
    tags(IntegrationTest)

    test("fast test").config(tags = setOf()) {
        // runs always
    }

    test("database test").config(tags = setOf(Database)) {
        // only when Database tag is active
    }

    test("slow integration").config(tags = setOf(Slow, Database)) {
        // only when both Slow and Database are active
    }
})

// Run: gradle test -Dkotest.tags="Database & !Slow"`,
    options: [
      'Tags are applied through annotation processing at compile time',
      'Tags only work with JUnit categories, not Kotest native',
      'Define Tag objects, assign them to specs or tests via tags()/config(tags=), and filter at runtime using Kotest tag expressions with boolean operators (& | !)',
      'Tags are simple string labels with no filtering capability',
    ],
    correctAnswer: 2,
    explanation: 'Kotest tags are objects extending Tag(). Apply them at spec level via tags() or per-test via config(tags = setOf()). At runtime, filter using -Dkotest.tags with boolean expressions: "Database & !Slow" runs Database-tagged tests excluding Slow ones. "IntegrationTest | Database" runs either. This enables flexible test suite partitioning for CI pipelines.',
    tags: ['kotest', 'tags', 'test-filtering'],
  },
  {
    id: 'kotlin-testing-l4-071',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'MockK Advanced',
    question: 'How do you verify timeout behavior in MockK with coEvery and delay?',
    codeSnippet: `@Test
fun testTimeoutHandling() = runTest {
    val service = mockk<RemoteService>()

    coEvery { service.fetchData() } coAnswers {
        delay(5000)  // simulate slow response
        "data"
    }

    val result = withTimeoutOrNull(1000) {
        service.fetchData()
    }

    result shouldBe null  // timed out
    coVerify { service.fetchData() }
}`,
    options: [
      'Set a global timeout on MockK instead of per-function delays',
      'Use Thread.sleep() in MockK answers for timeout simulation',
      'Use coAnswers with delay() inside to simulate slow responses; runTest virtual time makes withTimeout evaluate correctly without real waiting',
      'MockK cannot simulate delays in suspend function responses',
    ],
    correctAnswer: 2,
    explanation: 'coAnswers { delay(ms) } simulates a slow suspend function response. Combined with runTest\'s virtual time, withTimeout/withTimeoutOrNull correctly evaluates the relative timing: if the mock\'s delay exceeds the timeout, the timeout triggers. No real time passes, making timeout behavior testing fast and deterministic.',
    tags: ['mockk', 'coroutines', 'timeout'],
  },
  {
    id: 'kotlin-testing-l4-072',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'Integration Testing',
    question: 'How do you test Spring Security-protected endpoints in integration tests?',
    codeSnippet: `@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class SecureEndpointTest @Autowired constructor(
    val restTemplate: TestRestTemplate
) {
    @Test
    fun \`protected endpoint returns 401 without auth\`() {
        val response = restTemplate.getForEntity(
            "/api/admin/users", String::class.java
        )
        response.statusCode shouldBe HttpStatus.UNAUTHORIZED
    }

    @Test
    fun \`endpoint accessible with JWT token\`() {
        val token = jwtTokenService.generateToken(
            "admin", listOf("ADMIN")
        )
        val headers = HttpHeaders().apply { setBearerAuth(token) }

        val response = restTemplate.exchange(
            "/api/admin/users", HttpMethod.GET,
            HttpEntity<Unit>(headers), String::class.java
        )
        response.statusCode shouldBe HttpStatus.OK
    }
}`,
    options: [
      'Security cannot be tested in integration tests',
      'Test both authenticated and unauthenticated scenarios: verify 401 without credentials, use @WithMockUser for MockMvc or real JWT tokens for TestRestTemplate to verify authorized access',
      'Use MockK to mock the SecurityContext for all endpoints',
      'Disable security entirely in test configuration',
    ],
    correctAnswer: 1,
    explanation: 'Security testing should verify both denial and access. Test unauthenticated requests return 401/403, @WithMockUser provides simulated authentication for MockMvc tests, and real JWT tokens test the full authentication flow with TestRestTemplate. This ensures security filters, role checks, and token validation work correctly end-to-end.',
    tags: ['spring-security', 'integration-testing', 'authentication'],
  },
  {
    id: 'kotlin-testing-l4-073',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'Custom Assertions',
    question: 'How do you create Kotest inspectors for asserting conditions on collection elements?',
    codeSnippet: `val users = listOf(
    User("Alice", 25, verified = true),
    User("Bob", 30, verified = true),
    User("Charlie", 22, verified = false),
)

// Inspectors: quantified assertions on collections
users.forAll { it.name.shouldNotBeBlank() }
users.forAtLeast(2) { it.verified shouldBe true }
users.forExactly(1) { it.verified shouldBe false }
users.forNone { it.age shouldBeLessThan 0 }
users.forSome { it.age shouldBeGreaterThan 25 }
users.forAtMost(1) { it.name shouldStartWith "C" }`,
    options: [
      'Inspectors are custom loops that replace forEach',
      'Kotest inspectors (forAll, forNone, forSome, forExactly, forAtLeast, forAtMost) apply quantified assertions across collection elements with specific count requirements and detailed failure reporting',
      'Inspectors only work with primitive collections like List<Int>',
      'Inspectors require implementing the Inspector<T> interface',
    ],
    correctAnswer: 1,
    explanation: 'Kotest inspectors provide quantified collection assertions: forAll (every element), forNone (no element), forSome (at least one), forExactly(n) (exactly n elements), forAtLeast(n), forAtMost(n). On failure, they report which elements passed/failed and the count mismatch, making collection testing expressive and debuggable.',
    tags: ['kotest', 'inspectors', 'collections'],
  },
  {
    id: 'kotlin-testing-l4-074',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'Compose UI Testing',
    question: 'How do you test navigation between screens in Jetpack Compose?',
    codeSnippet: `@Test
fun navigation_fromListToDetail() {
    val navController = TestNavHostController(
        ApplicationProvider.getApplicationContext()
    )

    composeTestRule.setContent {
        navController.navigatorProvider.addNavigator(
            ComposeNavigator()
        )
        AppNavHost(navController = navController)
    }

    // Verify starting destination
    navController.currentBackStackEntry
        ?.destination?.route shouldBe "list"

    // Navigate by clicking an item
    composeTestRule
        .onNodeWithText("Item 1")
        .performClick()

    // Verify navigation occurred
    navController.currentBackStackEntry
        ?.destination?.route shouldBe "detail/1"
}`,
    options: [
      'Mock the NavController and verify navigate() was called',
      'Navigation cannot be tested in Compose; test individual screens only',
      'Use Espresso intents to verify navigation between Compose screens',
      'Use TestNavHostController to observe navigation state, verify current route after user interactions, and test back stack behavior',
    ],
    correctAnswer: 3,
    explanation: 'TestNavHostController provides observable navigation state in tests. Set it up with ComposeNavigator, render the NavHost, perform UI actions that trigger navigation, and assert on currentBackStackEntry.destination.route. You can also test back navigation with popBackStack() and deep link handling. This verifies the complete navigation graph behavior.',
    tags: ['compose', 'navigation', 'testing'],
  },
  {
    id: 'kotlin-testing-l4-075',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'BDD',
    question: 'How do you implement Kotest\'s DescribeSpec for BDD-style feature testing?',
    codeSnippet: `class UserServiceSpec : DescribeSpec({
    describe("UserService") {
        val repo = mockk<UserRepository>(relaxed = true)
        val service = UserService(repo)

        describe("createUser") {
            it("should save user to repository") {
                val request = CreateUserRequest("Alice", "alice@test.com")
                service.createUser(request)
                verify { repo.save(match { it.name == "Alice" }) }
            }

            it("should throw on duplicate email") {
                every { repo.existsByEmail("dup@test.com") } returns true
                shouldThrow<DuplicateEmailException> {
                    service.createUser(
                        CreateUserRequest("Bob", "dup@test.com")
                    )
                }
            }

            context("when email validation is enabled") {
                it("should reject invalid emails") {
                    shouldThrow<InvalidEmailException> {
                        service.createUser(
                            CreateUserRequest("Eve", "invalid")
                        )
                    }
                }
            }
        }
    }
})`,
    options: [
      'DescribeSpec uses describe/context/it blocks inspired by RSpec/Jasmine, creating nested hierarchical test structures that read as specification documentation',
      'DescribeSpec is identical to FunSpec with different keywords',
      'DescribeSpec only supports single-level test nesting',
      'DescribeSpec requires external tooling to generate specification documents',
    ],
    correctAnswer: 0,
    explanation: 'DescribeSpec uses describe/context/it blocks familiar from JavaScript (Jasmine/Jest) and Ruby (RSpec) testing frameworks. describe groups related tests, context adds conditional sub-groups, and it defines individual test cases. The nesting creates a readable specification hierarchy that serves as living documentation of system behavior.',
    tags: ['kotest', 'describe-spec', 'bdd'],
  },
  {
    id: 'kotlin-testing-l4-076',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'Integration Testing',
    question: 'How do you test scheduled tasks and background jobs?',
    codeSnippet: `class ScheduledJobTest {
    private val clock = MutableClock(
        Instant.parse("2024-01-01T00:00:00Z")
    )

    @Test
    fun \`cleanup job removes expired sessions\`() = runTest {
        val repo = InMemorySessionRepository()
        repo.save(Session("s1",
            expiresAt = clock.instant().minusSeconds(3600)))
        repo.save(Session("s2",
            expiresAt = clock.instant().plusSeconds(3600)))

        val job = SessionCleanupJob(repo, clock)
        job.execute()

        repo.findAll().map { it.id } shouldBe listOf("s2")
    }

    @Test
    fun \`job respects schedule interval\`() = runTest {
        val scheduler = TestScheduler()
        val job = mockk<Job>(relaxed = true)

        scheduler.schedule(job, interval = 1.hours)
        scheduler.advanceTimeBy(2.5.hours)

        coVerify(exactly = 2) { job.execute() }
    }
}`,
    options: [
      'Inject a controllable clock for time-dependent logic, use TestScheduler for schedule verification, and test the job execution logic independently from the scheduling mechanism',
      'Scheduled tasks cannot be tested without waiting for real time to pass',
      'Only test scheduled tasks in staging environments',
      'Use Thread.sleep() to wait for the scheduler to trigger the job',
    ],
    correctAnswer: 0,
    explanation: 'Testing scheduled tasks involves separating concerns: test job logic independently using injected clocks and fake repositories, and test scheduling behavior separately with a TestScheduler that advances virtual time. This avoids flaky time-dependent tests while verifying both that the job works correctly and that the schedule triggers it appropriately.',
    tags: ['scheduled-tasks', 'testing', 'clock'],
  },
  {
    id: 'kotlin-testing-l4-077',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'MockK Advanced',
    question: 'How do you use MockK\'s clearMocks vs unmockkAll for test cleanup?',
    codeSnippet: `@AfterEach
fun cleanup() {
    // Option 1: Clear recorded calls and stubbing
    clearMocks(serviceMock, repositoryMock)

    // Option 2: Clear only recorded calls, keep stubbing
    clearMocks(serviceMock,
        answers = false, recordedCalls = true)

    // Option 3: Remove all mocking entirely
    unmockkAll()
}`,
    options: [
      'clearMocks removes the mock object; unmockkAll removes all objects',
      'clearMocks and unmockkAll are interchangeable',
      'clearMocks resets recorded calls and optionally stubbing on specific mocks; unmockkAll removes all mock instrumentation globally, restoring original class behavior',
      'clearMocks is for unit tests; unmockkAll is for integration tests',
    ],
    correctAnswer: 2,
    explanation: 'clearMocks(mock) resets a specific mock\'s recorded invocations and (optionally) its stubbed answers, allowing reuse with fresh state. unmockkAll() removes all MockK instrumentation globally (mocks, spies, static mocks, constructor mocks, object mocks), restoring original class behavior. Use clearMocks for per-test reset; unmockkAll in @AfterAll or when cleaning up static/object mocks.',
    tags: ['mockk', 'cleanup', 'test-isolation'],
  },
  {
    id: 'kotlin-testing-l4-078',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'TestContainers',
    question: 'How do you implement reusable Testcontainers with the Singleton pattern?',
    codeSnippet: `abstract class DatabaseTest {
    companion object {
        val postgres: PostgreSQLContainer<*> by lazy {
            PostgreSQLContainer("postgres:15")
                .withReuse(true)
                .apply { start() }
        }
    }
}

// In .testcontainers.properties:
// testcontainers.reuse.enable=true`,
    options: [
      'Use withReuse(true) combined with lazy initialization in a base class to share a single container across all test classes, surviving between test runs for faster feedback',
      'Singleton containers are not supported by Testcontainers',
      'Use Docker volume mounts to persist container state between tests',
      'Each test class must create its own container instance',
    ],
    correctAnswer: 0,
    explanation: 'The Singleton pattern uses lazy initialization in a companion object to start the container once and share it across all test classes. withReuse(true) with testcontainers.reuse.enable=true in properties even keeps the container running between test runs, dramatically speeding up repeated local test execution. The container is identified by its configuration fingerprint.',
    tags: ['testcontainers', 'singleton', 'performance'],
  },
  {
    id: 'kotlin-testing-l4-079',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'Coroutine Testing',
    question: 'How do you test a Channel-based producer-consumer pattern?',
    codeSnippet: `@Test
fun testProducerConsumer() = runTest {
    val channel = Channel<Int>(capacity = 5)

    val producer = launch {
        (1..5).forEach {
            channel.send(it)
            delay(100)
        }
        channel.close()
    }

    val results = mutableListOf<Int>()
    val consumer = launch {
        for (item in channel) {
            results.add(item * 2)
        }
    }

    advanceUntilIdle()

    results shouldBe listOf(2, 4, 6, 8, 10)
    producer.isCompleted shouldBe true
    consumer.isCompleted shouldBe true
    channel.isClosedForReceive shouldBe true
}`,
    options: [
      'Launch producer and consumer coroutines, use advanceUntilIdle() to process all items, then verify collected results and channel/job completion states',
      'Channel testing requires real threads and cannot use virtual time',
      'Use a blocking queue instead of Channel for testable code',
      'Channels must be replaced with Flows for testing',
    ],
    correctAnswer: 0,
    explanation: 'Channel testing in runTest involves launching producer and consumer coroutines, advancing virtual time so all sends/receives complete, and asserting on the collected results. Verify channel closure (isClosedForReceive), job completion states, and the final output. The virtual time scheduler handles the interleaving of send/receive operations deterministically.',
    tags: ['coroutines', 'channel', 'producer-consumer'],
  },
  {
    id: 'kotlin-testing-l4-080',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'Integration Testing',
    question: 'How do you test idempotency in API endpoints?',
    codeSnippet: `@Test
fun \`payment endpoint is idempotent\`() {
    val idempotencyKey = UUID.randomUUID().toString()
    val request = PaymentRequest(amount = 100.00, currency = "USD")
    val headers = HttpHeaders().apply {
        set("Idempotency-Key", idempotencyKey)
    }

    // First call creates payment
    val response1 = restTemplate.exchange(
        "/api/payments", HttpMethod.POST,
        HttpEntity(request, headers), PaymentResponse::class.java
    )
    response1.statusCode shouldBe HttpStatus.CREATED

    // Second call with same key returns same result
    val response2 = restTemplate.exchange(
        "/api/payments", HttpMethod.POST,
        HttpEntity(request, headers), PaymentResponse::class.java
    )
    response2.statusCode shouldBe HttpStatus.OK
    response2.body!!.paymentId shouldBe response1.body!!.paymentId

    // Verify only one payment was created
    paymentRepository.count() shouldBe 1
}`,
    options: [
      'Idempotency is a client-side concern and does not need server testing',
      'Idempotency testing requires concurrent requests from multiple threads',
      'Send the same request multiple times with the same idempotency key and verify: same response is returned, no duplicate side effects occur, and the database state reflects a single operation',
      'Test idempotency by verifying the endpoint returns 409 Conflict on duplicates',
    ],
    correctAnswer: 2,
    explanation: 'Idempotency testing verifies that repeating the same request (with the same idempotency key) produces identical results without duplicate side effects. Key assertions: same response body/ID on subsequent calls, correct status codes (201 first, 200 after), and database verification that only one record was created. This is critical for payment and order processing endpoints.',
    tags: ['idempotency', 'api-testing', 'integration'],
  },
  {
    id: 'kotlin-testing-l4-081',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'Custom Assertions',
    question: 'How do you implement assertion extensions for Arrow Kt Either types?',
    codeSnippet: `fun <L, R> Either<L, R>.shouldBeRight(): R {
    this should beRight()
    return (this as Either.Right).value
}

fun <L, R> Either<L, R>.shouldBeLeft(): L {
    this should beLeft()
    return (this as Either.Left).value
}

fun <L, R> Either<L, R>.shouldBeRight(expected: R) {
    this should beRight()
    (this as Either.Right).value shouldBe expected
}

// Usage:
val result: Either<Error, User> = userService.findUser("1")
val user = result.shouldBeRight()
user.name shouldBe "Alice"

val error: Either<Error, User> = userService.findUser("invalid")
val err = error.shouldBeLeft()
err shouldBe Error.NotFound`,
    options: [
      'Arrow types cannot have custom assertions because they are sealed classes',
      'Use Arrow\'s built-in test module which has all necessary assertions',
      'Create extension functions on Either<L, R> that assert on the type (Right/Left), extract the value for further assertions, and provide meaningful failure messages',
      'Convert Either to nullable types before asserting',
    ],
    correctAnswer: 2,
    explanation: 'Custom Either assertions combine type checking with value extraction. shouldBeRight() asserts the Either is Right and returns the value for chaining further assertions. shouldBeLeft() does the same for Left. This pattern works for any sealed/sum type (Option, Validated, Result) and integrates with Kotest\'s matcher system for consistent failure messages.',
    tags: ['arrow', 'either', 'custom-assertions'],
  },
  {
    id: 'kotlin-testing-l4-082',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'Architecture Testing',
    question: 'How do you test that exceptions follow project conventions using ArchUnit?',
    codeSnippet: `@ArchTest
val exceptionsShouldEndWithException: ArchRule =
    classes()
        .that().areAssignableTo(Exception::class.java)
        .should().haveSimpleNameEndingWith("Exception")

@ArchTest
val exceptionsShouldBeInPackage: ArchRule =
    classes()
        .that().areAssignableTo(RuntimeException::class.java)
        .and().doNotHaveSimpleName("RuntimeException")
        .should().resideInAPackage("..exception..")

@ArchTest
val domainExceptionsNoFrameworkDeps: ArchRule =
    classes()
        .that().resideInAPackage("..domain..exception..")
        .should().onlyDependOnClassesThat()
        .resideInAnyPackage("java..", "kotlin..", "..domain..")`,
    options: [
      'Exception conventions can only be enforced through code review',
      'Only linters can check naming conventions; ArchUnit is limited to dependency checks',
      'Exception testing requires catching them at runtime, not static analysis',
      'ArchUnit can verify exception naming conventions, package placement, inheritance hierarchy, and dependency constraints as automated architectural tests',
    ],
    correctAnswer: 3,
    explanation: 'ArchUnit rules can enforce exception conventions: naming patterns (ending with "Exception"), package structure (in ..exception.. packages), inheritance constraints (extend the right base class), and dependency rules (domain exceptions do not import framework types). This ensures consistency across a large codebase without relying on manual review.',
    tags: ['archunit', 'exceptions', 'conventions'],
  },
  {
    id: 'kotlin-testing-l4-083',
    language: 'kotlin',
    level: 'level4',
    category: 'Testing',
    subcategory: 'Integration Testing',
    question: 'How do you test event sourcing patterns with an event store?',
    codeSnippet: `@Test
fun \`aggregate rebuilds state from events\`() {
    val eventStore = InMemoryEventStore()
    val orderId = OrderId("ord-1")

    // Store events
    eventStore.append(orderId, listOf(
        OrderCreated(orderId, customerId = "cust-1", Instant.now()),
        ItemAdded(orderId, productId = "prod-1", quantity = 2),
        ItemAdded(orderId, productId = "prod-2", quantity = 1),
        OrderConfirmed(orderId, Instant.now())
    ))

    // Rebuild aggregate from events
    val events = eventStore.loadEvents(orderId)
    val order = Order.fromEvents(events)

    order.status shouldBe OrderStatus.CONFIRMED
    order.items shouldHaveSize 2
    order.items[0].quantity shouldBe 2

    // Test new command produces correct event
    val newEvents = order.handle(RemoveItem(orderId, "prod-2"))
    newEvents shouldHaveSize 1
    newEvents[0] shouldBeInstanceOf<ItemRemoved>()
}`,
    options: [
      'Use an in-memory event store to append events, rebuild aggregate state from event history, verify state correctness, and test that commands produce expected new events',
      'Mock the event store and only test command handlers',
      'Event sourcing tests should only verify the latest state, not event history',
      'Event sourcing can only be tested with a real database',
    ],
    correctAnswer: 0,
    explanation: 'Event sourcing tests verify: events can be stored and loaded, aggregates correctly rebuild state from event sequences, commands produce the right new events, and event ordering is preserved. Using an in-memory event store keeps tests fast while testing the core event sourcing mechanics. Test both the "left fold" (events -> state) and command handling (state + command -> new events).',
    tags: ['event-sourcing', 'cqrs', 'integration-testing'],
  },
];

export default questions;
