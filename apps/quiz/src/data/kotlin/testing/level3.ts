import { Question } from '@/types/question';

const questions: Question[] = [
  {
    id: 'kotlin-testing-l3-001',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'Property-based Testing',
    question: 'What is property-based testing?',
    options: [
      'Testing configuration properties files',
      'Testing that general properties/invariants hold for randomly generated inputs',
      'Testing CSS properties in UI',
      'Testing object properties and fields',
    ],
    correctAnswer: 1,
    explanation: 'Property-based testing verifies that certain properties or invariants hold for a wide range of randomly generated inputs, rather than specific example-based test cases. This finds edge cases humans might miss.',
    tags: ['property-testing', 'concepts', 'advanced'],
  },
  {
    id: 'kotlin-testing-l3-002',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'Property-based Testing',
    question: 'How do you write a property-based test in Kotest?',
    codeSnippet: `class PropertyTest : StringSpec({
    "string reverse reverse is identity" {
        checkAll<String> { str ->
            str.reversed().reversed() shouldBe str
        }
    }
})`,
    options: [
      'Use checkAll which generates random inputs and verifies the property',
      'Use forAll with generators',
      'Use @Property annotation',
      'Use randomTest { } blocks',
    ],
    correctAnswer: 0,
    explanation: 'Kotest provides checkAll (and forAll) for property-based testing. checkAll generates random values of the specified type and runs the property check for each. It uses built-in generators for common types.',
    tags: ['kotest', 'property-testing', 'checkAll'],
  },
  {
    id: 'kotlin-testing-l3-003',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'Kotest Generators',
    question: 'What is a generator (Arb) in Kotest property testing?',
    options: [
      'A source of random values for property-based testing',
      'A mock object factory',
      'A test report generator',
      'A code generation tool',
    ],
    correctAnswer: 0,
    explanation: 'Arb (Arbitrary) is Kotest\'s generator type that produces random values for property-based testing. Kotest provides built-in Arbs for common types (Arb.int(), Arb.string(), etc.) and you can compose custom ones.',
    tags: ['kotest', 'generators', 'arb'],
  },
  {
    id: 'kotlin-testing-l3-004',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'Kotest Generators',
    question: 'How do you create a custom Arb generator in Kotest?',
    codeSnippet: `val emailArb = Arb.bind(
    Arb.string(5..10, Codepoint.alphanumeric()),
    Arb.string(3..8, Codepoint.alphanumeric()),
    Arb.of("com", "org", "net")
) { user, domain, tld -> "$user@$domain.$tld" }`,
    options: [
      'Use @Generator annotation',
      'Implement the Arbitrary interface',
      'Use Arb.bind to combine multiple Arbs into a custom generator',
      'Extend the Generator class',
    ],
    correctAnswer: 2,
    explanation: 'Arb.bind combines multiple Arbs into a custom generator by applying a function to their generated values. You can also use Arb.create { } for more control, or compose with map and flatMap.',
    tags: ['kotest', 'generators', 'custom-arb'],
  },
  {
    id: 'kotlin-testing-l3-005',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'Kotest Generators',
    question: 'What are edge cases in Kotest property testing?',
    codeSnippet: `Arb.int().edgecases() // includes: 0, 1, -1, Int.MIN_VALUE, Int.MAX_VALUE`,
    options: [
      'Random extreme values',
      'Predefined boundary values that generators include to catch common bugs',
      'Test cases that run on the edge of timeouts',
      'Tests for edge computing scenarios',
    ],
    correctAnswer: 1,
    explanation: 'Kotest generators include predefined edge cases (boundary values) alongside random values. For Int, these include 0, 1, -1, MIN_VALUE, MAX_VALUE. These help catch off-by-one errors and overflow bugs.',
    tags: ['kotest', 'generators', 'edge-cases'],
  },
  {
    id: 'kotlin-testing-l3-006',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'Property-based Testing',
    question: 'What is the difference between forAll and checkAll in Kotest?',
    options: [
      'forAll is for collections; checkAll is for single values',
      'forAll returns a Boolean property result; checkAll uses assertions inside the block',
      'checkAll is deprecated in favor of forAll',
      'They are identical',
    ],
    correctAnswer: 1,
    explanation: 'forAll expects the block to return a Boolean - true means the property holds. checkAll lets you use regular assertions (shouldBe, etc.) inside the block. checkAll is more flexible and commonly used.',
    tags: ['kotest', 'property-testing', 'forAll-vs-checkAll'],
  },
  {
    id: 'kotlin-testing-l3-007',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'Kotest Generators',
    question: 'How do you generate values from a specific range in Kotest?',
    codeSnippet: `checkAll(Arb.int(1..100)) { n ->
    n shouldBeGreaterThan 0
    n shouldBeLessThanOrEqual 100
}`,
    options: [
      'Use Arb.int().filter { it in 1..100 }',
      'Use Arb.range(1, 100)',
      'Use Arb.int(1..100) with an IntRange parameter',
      'Use Arb.between(1, 100)',
    ],
    correctAnswer: 2,
    explanation: 'Arb.int(range) accepts an IntRange to constrain generated values. Most numeric Arbs accept ranges. While filter() also works, it is less efficient as it discards non-matching values.',
    tags: ['kotest', 'generators', 'ranges'],
  },
  {
    id: 'kotlin-testing-l3-008',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'Kotest Generators',
    question: 'How do you transform generated values with Arb.map?',
    codeSnippet: `val positiveEvenArb = Arb.int(1..1000).map { it * 2 }`,
    options: [
      'map filters values that match the transformation',
      'map creates a Map from the generated values',
      'map runs the generator multiple times',
      'map applies the transformation to each generated value',
    ],
    correctAnswer: 3,
    explanation: 'Arb.map transforms each generated value using the provided function, creating a new Arb. In this example, every generated integer is doubled, ensuring all values are positive even numbers.',
    tags: ['kotest', 'generators', 'map'],
  },
  {
    id: 'kotlin-testing-l3-009',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'Property-based Testing',
    question: 'How do you control the number of iterations in a property test?',
    codeSnippet: `checkAll(iterations = 10000, Arb.int()) { n ->
    (n + 0) shouldBe n
}`,
    options: [
      'Set a global configuration',
      'Pass the iterations parameter to checkAll/forAll',
      'Use @Repeat annotation',
      'Override the default in AbstractProjectConfig',
    ],
    correctAnswer: 1,
    explanation: 'checkAll and forAll accept an iterations parameter that controls how many random inputs to test. The default is typically 1000. Increasing iterations gives more confidence but takes longer.',
    tags: ['kotest', 'property-testing', 'iterations'],
  },
  {
    id: 'kotlin-testing-l3-010',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'Kotest Generators',
    question: 'How do you generate a list of random items in Kotest?',
    codeSnippet: `val listArb = Arb.list(Arb.int(1..100), range = 1..10)`,
    options: [
      'Use Arb.list(elementArb, range) to generate lists of specified size range',
      'Use Arb.collection(Arb.int())',
      'Use listOf(Arb.int())',
      'Use Arb.int().toList()',
    ],
    correctAnswer: 0,
    explanation: 'Arb.list(elementArb, range) generates lists where elements come from the element Arb and the list size is within the specified range. Similar functions exist for Set, Map, and other collections.',
    tags: ['kotest', 'generators', 'collections'],
  },
  {
    id: 'kotlin-testing-l3-011',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'Coroutine Testing',
    question: 'How do you test a coroutine that uses Dispatchers.IO?',
    codeSnippet: `class Repository(private val dispatcher: CoroutineDispatcher = Dispatchers.IO) {
    suspend fun fetchData(): String = withContext(dispatcher) {
        // IO operation
        "data"
    }
}`,
    options: [
      'Use Dispatchers.setIO() to override',
      'Use @TestDispatcher annotation',
      'Inject the dispatcher and replace with StandardTestDispatcher in tests',
      'Replace Dispatchers.IO with Dispatchers.Unconfined in tests',
    ],
    correctAnswer: 2,
    explanation: 'The recommended approach is constructor injection of CoroutineDispatcher. In tests, inject StandardTestDispatcher (from runTest) to use virtual time. This keeps code testable and avoids Dispatchers.setMain() hacks.',
    tags: ['coroutines', 'dispatchers', 'dependency-injection'],
  },
  {
    id: 'kotlin-testing-l3-012',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'Coroutine Testing',
    question: 'What is the difference between StandardTestDispatcher and UnconfinedTestDispatcher?',
    options: [
      'They are identical',
      'StandardTestDispatcher is for suspend functions; UnconfinedTestDispatcher is for Flows',
      'UnconfinedTestDispatcher uses real threads; StandardTestDispatcher uses virtual threads',
      'StandardTestDispatcher requires explicit advancement; UnconfinedTestDispatcher executes eagerly',
    ],
    correctAnswer: 3,
    explanation: 'StandardTestDispatcher queues coroutines and requires explicit time advancement (advanceUntilIdle, etc.). UnconfinedTestDispatcher starts coroutines eagerly and runs them immediately. StandardTestDispatcher gives more control for precise testing.',
    tags: ['coroutines', 'dispatchers', 'test-dispatchers'],
  },
  {
    id: 'kotlin-testing-l3-013',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'Coroutine Testing',
    question: 'How do you test Dispatchers.Main in unit tests (Android)?',
    codeSnippet: `@Before
fun setup() {
    Dispatchers.setMain(StandardTestDispatcher())
}

@After
fun tearDown() {
    Dispatchers.resetMain()
}`,
    options: [
      'Use Dispatchers.setMain() to replace Main with a test dispatcher',
      'Use @MainDispatcher annotation',
      'Dispatchers.Main cannot be tested',
      'Mock Dispatchers.Main with MockK',
    ],
    correctAnswer: 0,
    explanation: 'Dispatchers.setMain() replaces the Main dispatcher with a test dispatcher. This is essential for Android testing since Dispatchers.Main requires the Android main looper. Always call resetMain() in teardown.',
    tags: ['coroutines', 'dispatchers-main', 'android'],
  },
  {
    id: 'kotlin-testing-l3-014',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'Coroutine Testing',
    question: 'How do you test a SharedFlow with Turbine?',
    codeSnippet: `@Test
fun testSharedFlow() = runTest {
    val sharedFlow = MutableSharedFlow<String>()
    sharedFlow.test {
        sharedFlow.emit("hello")
        assertEquals("hello", awaitItem())
        cancelAndConsumeRemainingEvents()
    }
}`,
    options: [
      'Convert SharedFlow to StateFlow first',
      'Use sharedFlow.collect { } in a separate coroutine',
      'SharedFlows cannot be tested with Turbine',
      'Use .test { } and emit values, then awaitItem to receive them',
    ],
    correctAnswer: 3,
    explanation: 'Turbine works with SharedFlow. Inside test { }, you can emit values and use awaitItem() to receive them. cancelAndConsumeRemainingEvents() cleanly ends the test by cancelling the collection.',
    tags: ['turbine', 'sharedflow', 'coroutines'],
  },
  {
    id: 'kotlin-testing-l3-015',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'Coroutine Testing',
    question: 'What does Turbine\'s expectNoEvents() do?',
    codeSnippet: `flow.test {
    expectNoEvents()
    // ... trigger action
    assertEquals("result", awaitItem())
}`,
    options: [
      'Skips all pending events',
      'Pauses the test for a duration',
      'Asserts that no items, errors, or completion have occurred',
      'Waits until events stop arriving',
    ],
    correctAnswer: 2,
    explanation: 'expectNoEvents() asserts that no events (items, errors, or completion) have been emitted at the current point. This is useful for verifying that nothing happens until a specific action is triggered.',
    tags: ['turbine', 'expectNoEvents', 'flow'],
  },
  {
    id: 'kotlin-testing-l3-016',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'Coroutine Testing',
    question: 'How do you handle Turbine\'s awaitComplete() for infinite flows?',
    codeSnippet: `// Testing an infinite SharedFlow
sharedFlow.test {
    sharedFlow.emit("a")
    assertEquals("a", awaitItem())
    cancelAndConsumeRemainingEvents()
}`,
    options: [
      'Use cancelAndConsumeRemainingEvents() to cleanly end the test',
      'Use awaitComplete() which works for infinite flows',
      'Infinite flows cannot be tested with Turbine',
      'Use timeout() to stop after a duration',
    ],
    correctAnswer: 0,
    explanation: 'For infinite flows (SharedFlow, channels), use cancelAndConsumeRemainingEvents() instead of awaitComplete(). This cancels the collection and consumes any remaining events, preventing test hangs.',
    tags: ['turbine', 'infinite-flow', 'cancel'],
  },
  {
    id: 'kotlin-testing-l3-017',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'TestContainers',
    question: 'What is TestContainers?',
    options: [
      'A library that provides disposable Docker containers for integration testing',
      'A container for storing test data',
      'A Kotlin dependency injection framework',
      'A test isolation mechanism using JVM containers',
    ],
    correctAnswer: 0,
    explanation: 'TestContainers is a Java/Kotlin library that provides lightweight, disposable Docker containers for integration tests. It supports databases (PostgreSQL, MySQL), message brokers (Kafka), and more.',
    tags: ['testcontainers', 'docker', 'integration'],
  },
  {
    id: 'kotlin-testing-l3-018',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'TestContainers',
    question: 'How do you use TestContainers with JUnit 5?',
    codeSnippet: `@Testcontainers
class DatabaseTest {
    companion object {
        @Container
        @JvmStatic
        val postgres = PostgreSQLContainer("postgres:15")
    }

    @Test
    fun testQuery() {
        val url = postgres.jdbcUrl
        // use the database
    }
}`,
    options: [
      'Manually start/stop containers in @BeforeAll/@AfterAll',
      'Use @Testcontainers and @Container annotations with JUnit 5 extension',
      'Use @DockerTest annotation',
      'Use a special TestContainers test runner',
    ],
    correctAnswer: 1,
    explanation: '@Testcontainers is a JUnit 5 extension that automatically manages container lifecycle. @Container marks container fields. Containers in companion object are shared (started once), instance fields are per-test.',
    tags: ['testcontainers', 'junit5', 'integration'],
  },
  {
    id: 'kotlin-testing-l3-019',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'TestContainers',
    question: 'How do you use TestContainers with Kotest?',
    codeSnippet: `class DatabaseTest : FunSpec({
    val postgres = install(ContainerExtension(PostgreSQLContainer("postgres:15")))

    test("should query database") {
        val url = postgres.jdbcUrl
        // use the database
    }
})`,
    options: [
      'Use beforeSpec/afterSpec to manually start/stop',
      'Use @Testcontainers annotation',
      'TestContainers does not work with Kotest',
      'Use the Kotest ContainerExtension or install function',
    ],
    correctAnswer: 3,
    explanation: 'Kotest provides kotest-extensions-testcontainers which includes ContainerExtension. Use install() to register it within the spec. The container is started before the spec and stopped after.',
    tags: ['testcontainers', 'kotest', 'integration'],
  },
  {
    id: 'kotlin-testing-l3-020',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'TestContainers',
    question: 'What is the benefit of using @Container on a companion object field vs instance field?',
    options: [
      'Instance containers are shared; companion containers are per-test',
      'No difference',
      'Companion object containers run in Docker; instance containers run locally',
      'Companion object containers are shared across all tests (started once); instance containers are per-test',
    ],
    correctAnswer: 3,
    explanation: 'Container fields in the companion object (static) are started once before all tests and shared. Instance container fields are created and started fresh for each test method, providing stronger isolation but slower execution.',
    tags: ['testcontainers', 'lifecycle', 'shared-vs-per-test'],
  },
  {
    id: 'kotlin-testing-l3-021',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'MockK',
    question: 'How do you mock a coroutine scope in MockK for testing?',
    codeSnippet: `class ViewModel(private val scope: CoroutineScope) {
    fun loadData() {
        scope.launch { /* ... */ }
    }
}`,
    options: [
      'Mock CoroutineScope with mockk',
      'Use TestScope from kotlinx-coroutines-test as the scope',
      'Use GlobalScope in tests',
      'Use runBlocking as the scope',
    ],
    correctAnswer: 1,
    explanation: 'TestScope (created by runTest) provides a controlled coroutine scope with virtual time support. Inject it as the CoroutineScope dependency for testable code that launches coroutines.',
    tags: ['coroutines', 'testscope', 'viewmodel'],
  },
  {
    id: 'kotlin-testing-l3-022',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'MockK',
    question: 'How do you use MockK\'s coAnswers for suspend function behavior?',
    codeSnippet: `coEvery { api.fetchUser(any()) } coAnswers {
    delay(100)
    User(firstArg<Int>(), "User \${firstArg<Int>()}")
}`,
    options: [
      'coAnswers records answers for later playback',
      'coAnswers automatically converts blocking calls to suspend calls',
      'coAnswers is not a valid MockK function',
      'coAnswers provides a suspend lambda for computing return values of suspend functions',
    ],
    correctAnswer: 3,
    explanation: 'coAnswers provides a suspend lambda for computing return values, allowing use of suspend functions like delay inside the answer block. It is the coroutine-aware version of answers.',
    tags: ['mockk', 'coAnswers', 'coroutines'],
  },
  {
    id: 'kotlin-testing-l3-023',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'MockK',
    question: 'How do you use MockK to mock private methods?',
    codeSnippet: `class Service {
    fun process(): String {
        return internalLogic()
    }
    private fun internalLogic(): String = "real"
}`,
    options: [
      'Use spyk with every { spy["internalLogic"]() } returns "mocked"',
      'Use reflection to make it public first',
      'Use mockk(relaxPrivate = true)',
      'Private methods cannot be mocked',
    ],
    correctAnswer: 0,
    explanation: 'MockK can mock private methods on spies using the string-based API: every { spy["methodName"](args) } returns value. The method is accessed by name as a string index operator.',
    tags: ['mockk', 'private-methods', 'advanced'],
  },
  {
    id: 'kotlin-testing-l3-024',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'Android Testing',
    question: 'What is Robolectric used for?',
    options: [
      'Generating Android UI screenshots',
      'UI automation testing on real devices',
      'Testing Android network calls',
      'Running Android tests on the JVM without an emulator or device',
    ],
    correctAnswer: 3,
    explanation: 'Robolectric simulates the Android framework on the JVM, allowing you to run Android unit tests without an emulator or device. This makes tests faster and suitable for CI environments.',
    tags: ['android', 'robolectric', 'jvm-testing'],
  },
  {
    id: 'kotlin-testing-l3-025',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'Android Testing',
    question: 'How do you configure Robolectric with JUnit 5 for Kotlin Android tests?',
    codeSnippet: `@ExtendWith(RobolectricExtension::class)
class MyActivityTest {
    @Test
    fun testActivity() {
        val activity = Robolectric.buildActivity(MyActivity::class.java)
            .create().resume().get()
        assertNotNull(activity)
    }
}`,
    options: [
      'No configuration needed, it auto-detects',
      'Use @RunWith(RobolectricTestRunner::class)',
      'Use @Robolectric annotation',
      'Use @ExtendWith(RobolectricExtension::class) for JUnit 5',
    ],
    correctAnswer: 3,
    explanation: 'For JUnit 5, use @ExtendWith(RobolectricExtension::class) from the robolectric-junit5 extension. The older @RunWith(RobolectricTestRunner::class) is for JUnit 4.',
    tags: ['android', 'robolectric', 'junit5'],
  },
  {
    id: 'kotlin-testing-l3-026',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'Android Testing',
    question: 'What is Espresso used for in Android testing?',
    options: [
      'Network request mocking',
      'Performance benchmarking',
      'Unit testing business logic',
      'Automated UI testing that interacts with views on a device/emulator',
    ],
    correctAnswer: 3,
    explanation: 'Espresso is Android\'s UI testing framework for writing automated tests that interact with the app UI on a real device or emulator. It provides APIs to find views, perform actions, and check assertions.',
    tags: ['android', 'espresso', 'ui-testing'],
  },
  {
    id: 'kotlin-testing-l3-027',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'Android Testing',
    question: 'What is the basic Espresso test pattern?',
    codeSnippet: `onView(withId(R.id.username_input))
    .perform(typeText("john"))
    .check(matches(isDisplayed()))`,
    options: [
      'view(id).action(type).expect(state)',
      'onView(matcher).perform(action).check(assertion)',
      'select(view).do(action).assert(condition)',
      'find -> click -> verify',
    ],
    correctAnswer: 1,
    explanation: 'Espresso follows the pattern: onView(viewMatcher) to find a view, .perform(viewAction) to interact with it, and .check(viewAssertion) to verify its state. This is a fluent, readable API.',
    tags: ['android', 'espresso', 'pattern'],
  },
  {
    id: 'kotlin-testing-l3-028',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'Android Testing',
    question: 'How do you test Jetpack Compose UI?',
    codeSnippet: `@get:Rule
val composeTestRule = createComposeRule()

@Test
fun testGreeting() {
    composeTestRule.setContent { Greeting("World") }
    composeTestRule.onNodeWithText("Hello, World!")
        .assertIsDisplayed()
}`,
    options: [
      'Use Espresso\'s onView',
      'Compose cannot be unit tested',
      'Use ComposeTestRule with semantic matchers like onNodeWithText',
      'Use Robolectric only',
    ],
    correctAnswer: 2,
    explanation: 'Jetpack Compose has its own testing API using ComposeTestRule. It uses semantic tree nodes instead of View hierarchy. onNodeWithText, onNodeWithTag, etc. find composable nodes for assertions and interactions.',
    tags: ['android', 'compose', 'ui-testing'],
  },
  {
    id: 'kotlin-testing-l3-029',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'Android Testing',
    question: 'What is the difference between createComposeRule and createAndroidComposeRule?',
    options: [
      'createAndroidComposeRule is for JUnit 4; createComposeRule is for JUnit 5',
      'createComposeRule provides a standalone Compose context; createAndroidComposeRule launches a real Activity',
      'They are identical',
      'createComposeRule requires an emulator; createAndroidComposeRule does not',
    ],
    correctAnswer: 1,
    explanation: 'createComposeRule() creates a standalone Compose test environment. createAndroidComposeRule<Activity>() launches a real Activity, useful when testing Compose integrated with Android components.',
    tags: ['android', 'compose', 'test-rules'],
  },
  {
    id: 'kotlin-testing-l3-030',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'testApplication',
    question: 'How do you test authentication in Ktor testApplication?',
    codeSnippet: `@Test
fun testProtectedRoute() = testApplication {
    application { configureSecurity(); configureRouting() }
    val response = client.get("/protected") {
        bearerAuth("valid-token")
    }
    assertEquals(HttpStatusCode.OK, response.status)
}`,
    options: [
      'Use a special test authentication mode',
      'Disable authentication in tests',
      'Use bearerAuth(), basicAuth(), or header() to provide credentials in requests',
      'Mock the authentication plugin',
    ],
    correctAnswer: 2,
    explanation: 'Ktor test client supports all standard authentication methods. Use bearerAuth(), basicAuth(), or manually set headers. You can also configure a test-specific authentication provider that accepts test tokens.',
    tags: ['ktor', 'testApplication', 'authentication'],
  },
  {
    id: 'kotlin-testing-l3-031',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'testApplication',
    question: 'How do you test WebSocket endpoints in Ktor?',
    codeSnippet: `@Test
fun testWebSocket() = testApplication {
    application { configureWebSockets() }
    val client = createClient {
        install(WebSockets)
    }
    client.webSocket("/ws") {
        send("hello")
        val response = (incoming.receive() as Frame.Text).readText()
        assertEquals("echo: hello", response)
    }
}`,
    options: [
      'Mock the WebSocket connection',
      'Create a WebSocket-enabled client and use webSocket { } to test',
      'WebSockets cannot be tested with testApplication',
      'Use a separate WebSocket testing library',
    ],
    correctAnswer: 1,
    explanation: 'Ktor testApplication supports WebSocket testing. Create a client with WebSockets plugin installed, then use client.webSocket(path) { } to send frames and receive responses.',
    tags: ['ktor', 'websocket', 'testApplication'],
  },
  {
    id: 'kotlin-testing-l3-032',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'testApplication',
    question: 'How do you configure test-specific dependencies in Ktor testApplication?',
    codeSnippet: `@Test
fun testWithMock() = testApplication {
    application {
        install(Koin) {
            modules(module {
                single<UserService> { mockk(relaxed = true) }
            })
        }
        configureRouting()
    }
}`,
    options: [
      'Override dependencies in the application { } block using DI framework',
      'Use @TestConfiguration annotation',
      'Modify the production configuration file',
      'Dependencies cannot be overridden in tests',
    ],
    correctAnswer: 0,
    explanation: 'In testApplication, you configure the application block with test-specific dependencies. Using a DI framework like Koin, you can provide mock implementations that replace production services.',
    tags: ['ktor', 'testApplication', 'dependency-injection'],
  },
  {
    id: 'kotlin-testing-l3-033',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'MockK',
    question: 'How do you verify interactions with captured arguments in MockK?',
    codeSnippet: `val emailSlot = slot<Email>()
verify { emailService.send(capture(emailSlot)) }
with(emailSlot.captured) {
    to shouldBe "user@example.com"
    subject shouldContain "Welcome"
}`,
    options: [
      'Use argumentCaptor from Mockito',
      'Capture inside every { } and verify after the test',
      'Use verifyCapture { } block',
      'Capture inside verify { } and assert on slot.captured properties',
    ],
    correctAnswer: 3,
    explanation: 'You can use capture() inside verify { } blocks as well. After verification, access slot.captured to inspect the argument. This combines verification and argument inspection in one step.',
    tags: ['mockk', 'capture', 'verify'],
  },
  {
    id: 'kotlin-testing-l3-034',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'Kotest Generators',
    question: 'How do you use Arb.flatMap for dependent generators?',
    codeSnippet: `val pairArb = Arb.int(1..10).flatMap { size ->
    Arb.list(Arb.string(), range = size..size).map { list ->
        size to list
    }
}`,
    options: [
      'flatMap is the same as map',
      'flatMap flattens nested lists',
      'flatMap chains generators independently',
      'flatMap creates a generator that depends on the output of another generator',
    ],
    correctAnswer: 3,
    explanation: 'Arb.flatMap creates dependent generators where the second generator depends on the value produced by the first. In this example, the list size depends on the generated integer.',
    tags: ['kotest', 'generators', 'flatMap'],
  },
  {
    id: 'kotlin-testing-l3-035',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'Property-based Testing',
    question: 'What is shrinking in property-based testing?',
    options: [
      'Reducing test execution time',
      'Reducing the number of test iterations',
      'Automatically finding the minimal failing input when a property test fails',
      'Compressing test output',
    ],
    correctAnswer: 2,
    explanation: 'When a property test fails, shrinking attempts to find the smallest/simplest input that still triggers the failure. This makes debugging much easier by eliminating irrelevant complexity from the failing case.',
    tags: ['property-testing', 'shrinking', 'debugging'],
  },
  {
    id: 'kotlin-testing-l3-036',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'Kotest Generators',
    question: 'How do you use Arb.choose for weighted random generation?',
    codeSnippet: `val statusArb = Arb.choose(
    7 to Arb.of("success"),
    2 to Arb.of("pending"),
    1 to Arb.of("failure")
)`,
    options: [
      'choose selects generators with weighted probability based on the int weights',
      'choose selects one generator at random with equal probability',
      'choose runs all generators and picks the best result',
      'choose picks the generator with the highest weight',
    ],
    correctAnswer: 0,
    explanation: 'Arb.choose takes pairs of weight-to-Arb. The weight determines the probability of each generator being selected. In this example, "success" appears ~70% of the time, "pending" ~20%, "failure" ~10%.',
    tags: ['kotest', 'generators', 'weighted'],
  },
  {
    id: 'kotlin-testing-l3-037',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'Kotest Generators',
    question: 'What is Arb.of used for in Kotest?',
    codeSnippet: `val colorArb = Arb.of("red", "green", "blue")`,
    options: [
      'Creates an Arb that randomly selects from a fixed set of values',
      'Creates an Arb from an existing collection',
      'Creates an Arb that generates values of a specific type',
      'Creates an Arb from a factory function',
    ],
    correctAnswer: 0,
    explanation: 'Arb.of creates a generator that randomly selects from a fixed set of provided values. Each value has equal probability of being selected. This is useful for enum-like domains.',
    tags: ['kotest', 'generators', 'of'],
  },
  {
    id: 'kotlin-testing-l3-038',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'MockK',
    question: 'How do you mock enum classes in MockK?',
    options: [
      'Use mockkStatic to mock enum valueOf or entries',
      'Use mockk<MyEnum>()',
      'Enums cannot be mocked in MockK',
      'Use enumMock<MyEnum>()',
    ],
    correctAnswer: 2,
    explanation: 'Enum classes cannot be directly mocked in MockK (or most mocking frameworks) because they are final with a fixed set of instances. Instead, use interfaces or wrapper classes that can be mocked.',
    tags: ['mockk', 'enums', 'limitations'],
  },
  {
    id: 'kotlin-testing-l3-039',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'MockK',
    question: 'What is mockkStatic used for in MockK?',
    codeSnippet: `mockkStatic(Instant::class)
every { Instant.now() } returns fixedInstant`,
    options: [
      'Mocking companion objects',
      'Mocking static Java methods and Kotlin top-level functions',
      'Preventing mock state from changing',
      'Creating static mock instances',
    ],
    correctAnswer: 1,
    explanation: 'mockkStatic mocks static methods (Java) and top-level/extension functions (Kotlin). It intercepts calls at the class level. Always call unmockkStatic in cleanup to restore original behavior.',
    tags: ['mockk', 'static', 'advanced'],
  },
  {
    id: 'kotlin-testing-l3-040',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'JUnit 5',
    question: 'How do you implement a custom JUnit 5 TestExecutionExceptionHandler?',
    codeSnippet: `class RetryOnFailure : TestExecutionExceptionHandler {
    override fun handleTestExecutionException(
        context: ExtensionContext,
        throwable: Throwable
    ) {
        if (throwable is TransientException) {
            // retry logic
        } else {
            throw throwable
        }
    }
}`,
    options: [
      'Override the handleException method',
      'Extend AbstractExceptionHandler',
      'Implement TestExecutionExceptionHandler to intercept and handle test failures',
      'Use @ExceptionHandler annotation',
    ],
    correctAnswer: 2,
    explanation: 'TestExecutionExceptionHandler is a JUnit 5 extension interface that intercepts exceptions thrown during test execution. You can retry, log, or transform exceptions. Rethrowing the exception causes the test to fail normally.',
    tags: ['junit5', 'extensions', 'exception-handling'],
  },
  {
    id: 'kotlin-testing-l3-041',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'Coroutine Testing',
    question: 'How do you test coroutine cancellation?',
    codeSnippet: `@Test
fun testCancellation() = runTest {
    val job = launch {
        try {
            delay(Long.MAX_VALUE)
        } finally {
            // cleanup code
        }
    }
    job.cancelAndJoin()
    assertTrue(job.isCancelled)
}`,
    options: [
      'Use a CancellationTestRule',
      'Cancellation cannot be tested',
      'Launch the coroutine, cancel it, and verify the cancellation state and cleanup',
      'Use assertCancelled { }',
    ],
    correctAnswer: 2,
    explanation: 'Test cancellation by launching a coroutine, calling cancel() or cancelAndJoin(), and verifying the job state (isCancelled) and any cleanup behavior in finally blocks.',
    tags: ['coroutines', 'cancellation', 'testing'],
  },
  {
    id: 'kotlin-testing-l3-042',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'Coroutine Testing',
    question: 'How do you test a coroutine that collects from multiple Flows?',
    codeSnippet: `class ViewModel(val repo: Repository) {
    val combined = combine(repo.users, repo.settings) { users, settings ->
        UiState(users, settings)
    }.stateIn(viewModelScope, SharingStarted.Lazily, UiState.Loading)
}`,
    options: [
      'Combined Flows cannot be tested',
      'Test each Flow separately',
      'Test only the final StateFlow',
      'Mock the source Flows and test the combined output using Turbine or value assertions',
    ],
    correctAnswer: 3,
    explanation: 'Mock the source Flows (e.g., return flowOf(...) from mocked repositories), then test the combined Flow using Turbine or by reading the StateFlow value. This verifies the combination logic.',
    tags: ['coroutines', 'flow', 'combine'],
  },
  {
    id: 'kotlin-testing-l3-043',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'TestContainers',
    question: 'How do you use GenericContainer for custom Docker images in TestContainers?',
    codeSnippet: `val redis = GenericContainer("redis:7-alpine")
    .withExposedPorts(6379)
    .waitingFor(Wait.forListeningPort())`,
    options: [
      'Use DockerContainer class',
      'Use CustomContainer class',
      'Use GenericContainer with the image name and configure ports/wait strategies',
      'Write a Dockerfile in the test',
    ],
    correctAnswer: 2,
    explanation: 'GenericContainer is the base TestContainers class for any Docker image. Configure exposed ports with withExposedPorts() and wait strategies with waitingFor() to ensure the container is ready before tests.',
    tags: ['testcontainers', 'generic-container', 'docker'],
  },
  {
    id: 'kotlin-testing-l3-044',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'TestContainers',
    question: 'What is a wait strategy in TestContainers?',
    options: [
      'A strategy to determine when a container is ready to accept connections',
      'A strategy for retry timing between tests',
      'How long to wait before starting the container',
      'How long to wait after tests complete',
    ],
    correctAnswer: 0,
    explanation: 'Wait strategies determine when a container is ready for testing. Options include Wait.forListeningPort() (TCP port), Wait.forHttp("/health") (HTTP endpoint), Wait.forLogMessage() (log output), and more.',
    tags: ['testcontainers', 'wait-strategy', 'readiness'],
  },
  {
    id: 'kotlin-testing-l3-045',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'TestContainers',
    question: 'How do you access mapped ports in TestContainers?',
    codeSnippet: `val postgres = PostgreSQLContainer("postgres:15")
    .withExposedPorts(5432)

postgres.start()
val host = postgres.host
val port = postgres.getMappedPort(5432)`,
    options: [
      'Use getPort() method',
      'Use getMappedPort() to get the randomly assigned host port',
      'Ports are always the same as specified',
      'Use the original port number directly',
    ],
    correctAnswer: 1,
    explanation: 'TestContainers maps container ports to random host ports to avoid conflicts. Use getMappedPort(containerPort) to get the actual host port, and .host for the host address. The JDBC URL helpers handle this automatically.',
    tags: ['testcontainers', 'ports', 'networking'],
  },
  {
    id: 'kotlin-testing-l3-046',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'Kotest',
    question: 'How do you configure test parallelism in Kotest?',
    codeSnippet: `class ProjectConfig : AbstractProjectConfig() {
    override val parallelism = Runtime.getRuntime().availableProcessors()
}`,
    options: [
      'Use Gradle\'s maxParallelForks',
      'Both A and B, but they control different levels of parallelism',
      'Override parallelism in AbstractProjectConfig',
      'Tests always run sequentially in Kotest',
    ],
    correctAnswer: 1,
    explanation: 'Gradle maxParallelForks controls JVM-level parallelism (how many test JVMs). Kotest parallelism controls how many specs run concurrently within a single JVM. Both can be combined for maximum parallelism.',
    tags: ['kotest', 'parallelism', 'performance'],
  },
  {
    id: 'kotlin-testing-l3-047',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'Kotest',
    question: 'What isolation modes does Kotest support?',
    codeSnippet: `class MyTest : FunSpec({
    isolationMode = IsolationMode.InstancePerLeaf
    // ...
})`,
    options: [
      'SingleInstance, InstancePerTest, and InstancePerLeaf',
      'SingleInstance only',
      'Isolated and NonIsolated',
      'PerClass and PerMethod',
    ],
    correctAnswer: 0,
    explanation: 'Kotest has three isolation modes: SingleInstance (one spec instance, shared state), InstancePerTest (new instance for every test including containers), InstancePerLeaf (new instance for each leaf test only).',
    tags: ['kotest', 'isolation', 'modes'],
  },
  {
    id: 'kotlin-testing-l3-048',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'Kotest',
    question: 'How do you use Kotest\'s arb for composing generators?',
    codeSnippet: `data class Address(val street: String, val city: String, val zip: String)

val addressArb = arbitrary {
    Address(
        street = Arb.string(10..30).bind(),
        city = Arb.of("New York", "London", "Tokyo").bind(),
        zip = Arb.string(5..5, Codepoint.digit()).bind()
    )
}`,
    options: [
      'Use data class constructor directly with Arb values',
      'Use @GenerateWith annotation',
      'Use Arb.create { } with manual random calls',
      'Use arbitrary { } builder with .bind() to compose multiple Arbs',
    ],
    correctAnswer: 3,
    explanation: 'The arbitrary { } builder provides a coroutine-like syntax for composing generators. .bind() extracts a value from an Arb inside the builder. This is the cleanest way to create complex generators.',
    tags: ['kotest', 'generators', 'arbitrary-builder'],
  },
  {
    id: 'kotlin-testing-l3-049',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'Property-based Testing',
    question: 'What property should a serialization/deserialization roundtrip satisfy?',
    codeSnippet: `checkAll<User> { user ->
    val json = serialize(user)
    val deserialized = deserialize(json)
    deserialized shouldBe user
}`,
    options: [
      'Commutativity: serialize and deserialize can be applied in any order',
      'Associativity: grouping of operations does not matter',
      'Roundtrip: deserialize(serialize(x)) == x for all x',
      'Idempotency: serializing twice gives the same result',
    ],
    correctAnswer: 2,
    explanation: 'The roundtrip property states that serializing then deserializing any value should produce the original value. This is a fundamental property for testing serialization correctness with property-based testing.',
    tags: ['property-testing', 'roundtrip', 'serialization'],
  },
  {
    id: 'kotlin-testing-l3-050',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'JUnit 5',
    question: 'How do you implement parallel test execution in JUnit 5?',
    codeSnippet: `# junit-platform.properties
junit.jupiter.execution.parallel.enabled=true
junit.jupiter.execution.parallel.mode.default=concurrent`,
    options: [
      'Use @Execution(CONCURRENT) on each test',
      'Use @Parallel annotation on test classes',
      'Both B and C, with properties for defaults and annotation for overrides',
      'Configure parallel execution in junit-platform.properties',
    ],
    correctAnswer: 2,
    explanation: 'Enable parallel execution in junit-platform.properties (global default) and optionally override per-class with @Execution(CONCURRENT) or @Execution(SAME_THREAD). Use @ResourceLock for shared resource synchronization.',
    tags: ['junit5', 'parallel', 'performance'],
  },
  {
    id: 'kotlin-testing-l3-051',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'JUnit 5',
    question: 'What does @ResourceLock do in JUnit 5 parallel testing?',
    codeSnippet: `@Execution(ExecutionMode.CONCURRENT)
class SharedResourceTest {
    @Test
    @ResourceLock("database")
    fun testA() { ... }

    @Test
    @ResourceLock("database")
    fun testB() { ... }
}`,
    options: [
      'Acquires a database lock',
      'Locks the test from being disabled',
      'Locks a file resource',
      'Ensures tests with the same resource lock do not run concurrently',
    ],
    correctAnswer: 3,
    explanation: '@ResourceLock declares that a test uses a shared resource. Tests with the same resource lock value are synchronized - they will not run at the same time even when parallel execution is enabled.',
    tags: ['junit5', 'parallel', 'resource-lock'],
  },
  {
    id: 'kotlin-testing-l3-052',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'MockK',
    question: 'How do you use MockK with coroutine channels?',
    codeSnippet: `interface EventBus {
    suspend fun send(event: Event)
    fun subscribe(): ReceiveChannel<Event>
}`,
    options: [
      'Use channelMock<Event>()',
      'Channels cannot be tested with MockK',
      'Mock the Channel directly',
      'Use coEvery for send, return Channel() from subscribe, and send test events',
    ],
    correctAnswer: 3,
    explanation: 'Mock suspend functions with coEvery and return real Channel instances for testing. Create a Channel<Event>(), return it from the mock, and send test events through it to simulate real behavior.',
    tags: ['mockk', 'channels', 'coroutines'],
  },
  {
    id: 'kotlin-testing-l3-053',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'Kotest',
    question: 'How do you use Kotest extensions for Spring Boot testing?',
    codeSnippet: `@SpringBootTest
class UserServiceTest : FunSpec() {
    override fun extensions() = listOf(SpringExtension)

    @Autowired
    lateinit var userService: UserService

    init {
        test("should find user") {
            userService.findById(1) shouldNotBe null
        }
    }
}`,
    options: [
      'Use @ExtendWith(SpringExtension::class)',
      'Use @SpringKotest annotation',
      'Override extensions() to include SpringExtension from kotest-extensions-spring',
      'Spring Boot does not work with Kotest',
    ],
    correctAnswer: 2,
    explanation: 'Kotest provides kotest-extensions-spring that integrates with Spring Boot. Override extensions() in your spec and include SpringExtension. Then use @SpringBootTest and @Autowired as usual.',
    tags: ['kotest', 'spring-boot', 'extensions'],
  },
  {
    id: 'kotlin-testing-l3-054',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'Android Testing',
    question: 'How do you test ViewModel with SavedStateHandle in Android?',
    codeSnippet: `class MyViewModelTest {
    @Test
    fun testWithSavedState() {
        val savedState = SavedStateHandle(mapOf("userId" to 42))
        val viewModel = MyViewModel(savedState, mockk())
        // test viewModel
    }
}`,
    options: [
      'Create a real SavedStateHandle with initial state map',
      'Mock SavedStateHandle with MockK',
      'Use @SavedState annotation',
      'SavedStateHandle cannot be tested',
    ],
    correctAnswer: 0,
    explanation: 'SavedStateHandle can be created directly with a map of initial values. No mocking needed since it is a simple class. This lets you test ViewModels that depend on SavedStateHandle easily.',
    tags: ['android', 'viewmodel', 'saved-state'],
  },
  {
    id: 'kotlin-testing-l3-055',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'Android Testing',
    question: 'How do you test Navigation in Jetpack Compose?',
    codeSnippet: `@Test
fun testNavigation() {
    val navController = TestNavHostController(ApplicationProvider.getApplicationContext())
    composeTestRule.setContent {
        NavHost(navController = navController, startDestination = "home") {
            composable("home") { HomeScreen() }
            composable("detail") { DetailScreen() }
        }
    }
    composeTestRule.onNodeWithText("Go to Detail").performClick()
    assertEquals("detail", navController.currentDestination?.route)
}`,
    options: [
      'Navigation cannot be tested',
      'Use TestNavHostController to track navigation changes',
      'Mock the NavController',
      'Use a real NavController',
    ],
    correctAnswer: 1,
    explanation: 'TestNavHostController is a testing variant that tracks navigation changes. After performing UI actions, you can assert the current destination route to verify navigation behavior.',
    tags: ['android', 'compose', 'navigation'],
  },
  {
    id: 'kotlin-testing-l3-056',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'Kotest',
    question: 'How do you use forNone in Kotest property testing?',
    codeSnippet: `forNone<Int> { n ->
    isPrime(n * n + n) // should never be prime for any n > 1
}`,
    options: [
      'forNone skips all tests',
      'forNone checks that no exception is thrown',
      'forNone checks that the property holds for no generated value',
      'forNone generates zero values',
    ],
    correctAnswer: 2,
    explanation: 'forNone is the inverse of forAll. It asserts that the property (returns true) holds for NONE of the generated values. If any generated value makes the property true, the test fails.',
    tags: ['kotest', 'property-testing', 'forNone'],
  },
  {
    id: 'kotlin-testing-l3-057',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'Kotest Generators',
    question: 'How do you use Exhaustive generators in Kotest?',
    codeSnippet: `checkAll(Exhaustive.ints(1..5)) { n ->
    n shouldBeGreaterThan 0
    n shouldBeLessThanOrEqual 5
}`,
    options: [
      'Exhaustive generates all possible values instead of random sampling',
      'Exhaustive is an alias for Arb',
      'Exhaustive generates the maximum number of random values',
      'Exhaustive runs until a failure is found',
    ],
    correctAnswer: 0,
    explanation: 'Exhaustive generators enumerate ALL possible values in a finite domain. Unlike Arb which randomly samples, Exhaustive guarantees complete coverage. Useful for small enums, booleans, or small ranges.',
    tags: ['kotest', 'exhaustive', 'generators'],
  },
  {
    id: 'kotlin-testing-l3-058',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'Kotest Generators',
    question: 'How do you generate valid email addresses for testing?',
    codeSnippet: `val emailArb = Arb.email()`,
    options: [
      'Use Arb.email() which is a built-in Kotest generator',
      'Use Arb.string() and hope for valid emails',
      'Email generators are not available in Kotest',
      'Write a custom regex-based generator',
    ],
    correctAnswer: 0,
    explanation: 'Kotest provides Arb.email() as a built-in generator that produces valid email addresses. Kotest has many domain-specific generators including Arb.uuid(), Arb.domain(), etc.',
    tags: ['kotest', 'generators', 'email'],
  },
  {
    id: 'kotlin-testing-l3-059',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'testApplication',
    question: 'How do you test Ktor content negotiation and serialization?',
    codeSnippet: `@Test
fun testJsonResponse() = testApplication {
    application {
        install(ContentNegotiation) { json() }
        configureRouting()
    }
    val client = createClient {
        install(io.ktor.client.plugins.contentnegotiation.ContentNegotiation) { json() }
    }
    val user = client.get("/users/1").body<User>()
    assertEquals("John", user.name)
}`,
    options: [
      'Install ContentNegotiation on both server and test client for automatic serialization',
      'Parse JSON manually in the test',
      'Content negotiation is skipped in tests',
      'Use a separate JSON testing library',
    ],
    correctAnswer: 0,
    explanation: 'Install ContentNegotiation on both the server (application block) and the test client (createClient block). The client can then deserialize responses automatically using body<T>().',
    tags: ['ktor', 'testApplication', 'serialization'],
  },
  {
    id: 'kotlin-testing-l3-060',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'MockK',
    question: 'How do you use MockK withArg for inline argument verification?',
    codeSnippet: `verify {
    service.saveUser(withArg {
        it.name shouldBe "John"
        it.age shouldBe 30
    })
}`,
    options: [
      'withArg creates a new argument matcher',
      'withArg captures the argument for later inspection',
      'withArg provides inline assertions on the argument during verification',
      'withArg converts the argument type',
    ],
    correctAnswer: 2,
    explanation: 'withArg { } in MockK allows inline assertions on arguments during verification. The lambda receives the actual argument, and you can make assertions on it directly. Failures inside withArg fail the verify.',
    tags: ['mockk', 'withArg', 'verification'],
  },
  {
    id: 'kotlin-testing-l3-061',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'Coroutine Testing',
    question: 'How do you test a debounced Flow?',
    codeSnippet: `fun <T> Flow<T>.debounce(timeoutMillis: Long): Flow<T>

@Test
fun testDebounce() = runTest {
    val source = MutableSharedFlow<String>()
    val debounced = source.debounce(500)
    debounced.test {
        source.emit("a")
        source.emit("b")
        source.emit("c")
        advanceTimeBy(600)
        assertEquals("c", awaitItem())
    }
}`,
    options: [
      'Debounced flows cannot be tested deterministically',
      'Use a real timer',
      'Use Thread.sleep to simulate delays',
      'Use virtual time with advanceTimeBy in runTest to skip debounce delays',
    ],
    correctAnswer: 3,
    explanation: 'runTest\'s virtual time makes debounce testing deterministic. Emit values quickly, then advance time past the debounce window with advanceTimeBy. Only the last value within the debounce window is emitted.',
    tags: ['coroutines', 'flow', 'debounce'],
  },
  {
    id: 'kotlin-testing-l3-062',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'TestContainers',
    question: 'How do you use Docker Compose with TestContainers?',
    codeSnippet: `val compose = DockerComposeContainer(File("docker-compose-test.yml"))
    .withExposedService("api", 8080)
    .waitingFor("api", Wait.forHttp("/health"))`,
    options: [
      'Convert compose file to individual containers',
      'Use DockerComposeContainer with a compose file',
      'Use ComposeTestRule',
      'TestContainers does not support Docker Compose',
    ],
    correctAnswer: 1,
    explanation: 'DockerComposeContainer can start a full Docker Compose environment. Specify exposed services and wait strategies for each. This is useful for testing complex multi-service architectures.',
    tags: ['testcontainers', 'docker-compose', 'integration'],
  },
  {
    id: 'kotlin-testing-l3-063',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'MockK',
    question: 'What is the difference between clearMocks and unmockkAll in MockK?',
    options: [
      'clearMocks resets stubbing/recording for specific mocks; unmockkAll restores original classes',
      'unmockkAll clears mocks; clearMocks removes them from memory',
      'clearMocks is for mocks; unmockkAll is for spies',
      'They are identical',
    ],
    correctAnswer: 0,
    explanation: 'clearMocks(mock) resets recorded calls and stubbing for specific mock instances. unmockkAll() restores original implementations for mockkStatic, mockkObject, and mockkConstructor. They serve different purposes.',
    tags: ['mockk', 'cleanup', 'clear-vs-unmockk'],
  },
  {
    id: 'kotlin-testing-l3-064',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'Kotest',
    question: 'How do you use Kotest\'s checkAll with multiple generators?',
    codeSnippet: `checkAll(Arb.int(1..100), Arb.int(1..100)) { a, b ->
    (a + b) shouldBeGreaterThanOrEqual a
    (a + b) shouldBeGreaterThanOrEqual b
}`,
    options: [
      'Call checkAll multiple times',
      'Create a combined generator first',
      'Pass multiple Arbs as parameters and destructure in the lambda',
      'Use Pair generator',
    ],
    correctAnswer: 2,
    explanation: 'checkAll accepts up to multiple Arb parameters and generates values for all of them. The lambda receives all generated values as parameters. Kotest generates all combinations.',
    tags: ['kotest', 'property-testing', 'multiple-generators'],
  },
  {
    id: 'kotlin-testing-l3-065',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'JUnit 5',
    question: 'How do you implement a custom @TestTemplate extension?',
    codeSnippet: `class RepeatExtension : TestTemplateInvocationContextProvider {
    override fun supportsTestTemplate(context: ExtensionContext) = true
    override fun provideTestTemplateInvocationContexts(context: ExtensionContext):
        Stream<TestTemplateInvocationContext> {
        return Stream.of(context1, context2, context3)
    }
}`,
    options: [
      'Extend AbstractTestTemplate',
      'Override TestTemplate interface',
      'Implement TestTemplateInvocationContextProvider',
      'Use @Template annotation',
    ],
    correctAnswer: 2,
    explanation: 'TestTemplateInvocationContextProvider is the JUnit 5 extension interface for @TestTemplate. It provides multiple invocation contexts, each defining how the test template is invoked (with parameters, display names, etc.).',
    tags: ['junit5', 'extensions', 'test-template'],
  },
  {
    id: 'kotlin-testing-l3-066',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'Kotest',
    question: 'What is Kotest\'s Spec ordering feature?',
    codeSnippet: `class ProjectConfig : AbstractProjectConfig() {
    override val specExecutionOrder = SpecExecutionOrder.Annotated
}`,
    options: [
      'Orders tests within a single spec',
      'Controls the order in which spec classes are executed',
      'Orders test output in reports',
      'Sorts test results alphabetically',
    ],
    correctAnswer: 1,
    explanation: 'specExecutionOrder controls the order in which spec classes run. Options: Undefined (default), Lexicographic, Random, Annotated (using @Order), and FailureFirst (failed specs from last run go first).',
    tags: ['kotest', 'ordering', 'spec-execution'],
  },
  {
    id: 'kotlin-testing-l3-067',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'Coroutine Testing',
    question: 'How do you test a SupervisorJob-based scope?',
    codeSnippet: `class WorkerManager(private val scope: CoroutineScope) {
    fun startWorker(name: String) = scope.launch {
        // work that might fail
    }
}`,
    options: [
      'Use supervisorTest { } block',
      'Replace SupervisorJob with regular Job in tests',
      'Use TestScope and verify that child failures do not cancel siblings',
      'SupervisorJob scopes cannot be tested',
    ],
    correctAnswer: 2,
    explanation: 'Inject TestScope as the CoroutineScope. Launch multiple workers, let one fail, and verify that other workers continue running. This tests the supervisor behavior where child failures are isolated.',
    tags: ['coroutines', 'supervisor', 'testing'],
  },
  {
    id: 'kotlin-testing-l3-068',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'TestContainers',
    question: 'How do you use TestContainers with Kafka?',
    codeSnippet: `val kafka = KafkaContainer(DockerImageName.parse("confluentinc/cp-kafka:7.4.0"))

@Test
fun testKafkaProducer() {
    kafka.start()
    val bootstrapServers = kafka.bootstrapServers
    // create producer with bootstrapServers and test
}`,
    options: [
      'Use Kafka test utilities only',
      'Use an embedded Kafka library',
      'Use KafkaContainer which provides a ready-to-use Kafka broker',
      'Mock Kafka with MockK',
    ],
    correctAnswer: 2,
    explanation: 'TestContainers provides KafkaContainer that starts a real Kafka broker in Docker. It provides bootstrapServers for connecting producers and consumers, enabling realistic integration tests.',
    tags: ['testcontainers', 'kafka', 'integration'],
  },
  {
    id: 'kotlin-testing-l3-069',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'MockK',
    question: 'How do you handle vararg parameters in MockK mocking?',
    codeSnippet: `interface Logger {
    fun log(level: String, vararg args: Any)
}`,
    options: [
      'Varargs cannot be mocked',
      'Use any() for varargs',
      'Use varargAll { }, varargAny { }, or specific matchers for vararg parameters',
      'Pass an array with arrayOf()',
    ],
    correctAnswer: 2,
    explanation: 'MockK provides varargAll { predicate } (all args match) and varargAny { predicate } (at least one matches) for vararg parameters. You can also use specific matchers or any() for individual vararg elements.',
    tags: ['mockk', 'varargs', 'advanced'],
  },
  {
    id: 'kotlin-testing-l3-070',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'Kotest',
    question: 'How do you use Kotest\'s shouldBeRight and shouldBeLeft for Arrow Either?',
    codeSnippet: `val result: Either<Error, User> = service.getUser(1)
result.shouldBeRight()
result.shouldBeRight().name shouldBe "John"`,
    options: [
      'Use when expression to check Either',
      'Arrow types cannot be tested with Kotest',
      'Use standard shouldBe with pattern matching',
      'Use kotest-assertions-arrow which provides shouldBeRight/shouldBeLeft matchers',
    ],
    correctAnswer: 3,
    explanation: 'kotest-assertions-arrow provides Arrow-specific matchers: shouldBeRight() for Right values, shouldBeLeft() for Left values, shouldBeSome()/shouldBeNone() for Option, etc. They also return the unwrapped value.',
    tags: ['kotest', 'arrow', 'functional'],
  },
  {
    id: 'kotlin-testing-l3-071',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'JUnit 5',
    question: 'How do you implement a custom condition for @EnabledIf?',
    codeSnippet: `class DatabaseAvailableCondition : ExecutionCondition {
    override fun evaluateExecutionCondition(
        context: ExtensionContext
    ): ConditionEvaluationResult {
        return if (isDatabaseAvailable())
            ConditionEvaluationResult.enabled("DB available")
        else
            ConditionEvaluationResult.disabled("DB unavailable")
    }
}`,
    options: [
      'Implement ExecutionCondition interface and register as extension',
      'Use @ConditionalOn annotation',
      'Implement Condition interface',
      'Override canExecute method',
    ],
    correctAnswer: 0,
    explanation: 'ExecutionCondition is a JUnit 5 extension interface for programmatic conditional test execution. Return ConditionEvaluationResult.enabled() or .disabled() based on your condition logic.',
    tags: ['junit5', 'extensions', 'conditional'],
  },
  {
    id: 'kotlin-testing-l3-072',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'Kotest',
    question: 'How do you use Kotest\'s inspectors?',
    codeSnippet: `val people = listOf(Person("Alice", 30), Person("Bob", 25))

people.forAll { it.age shouldBeGreaterThan 0 }
people.forAtLeastOne { it.name shouldBe "Alice" }
people.forExactly(1) { it.age shouldBe 25 }`,
    options: [
      'Inspectors debug test failures',
      'Inspectors iterate collections with built-in assertion quantifiers',
      'Inspectors validate collection types',
      'Inspectors log collection contents',
    ],
    correctAnswer: 1,
    explanation: 'Kotest inspectors (forAll, forNone, forAtLeastOne, forExactly, forAtMost) apply assertions to collection elements with quantifiers. They provide rich failure messages showing which elements failed.',
    tags: ['kotest', 'inspectors', 'collections'],
  },
  {
    id: 'kotlin-testing-l3-073',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'Coroutine Testing',
    question: 'How do you test retry logic with coroutines?',
    codeSnippet: `@Test
fun testRetry() = runTest {
    var attempts = 0
    coEvery { api.call() } answers {
        attempts++
        if (attempts < 3) throw IOException("fail")
        else "success"
    }
    val result = retryWithDelay(maxRetries = 3, delay = 1000) {
        api.call()
    }
    assertEquals("success", result)
    assertEquals(3, attempts)
}`,
    options: [
      'Retry logic cannot be tested deterministically',
      'Use runTest virtual time so retry delays are instant, and configure mock to fail then succeed',
      'Use Thread.sleep between retries',
      'Retry logic must use real delays',
    ],
    correctAnswer: 1,
    explanation: 'runTest virtual time makes retry delays instant. Configure the mock to fail for the first N calls then succeed. This allows testing retry logic quickly and deterministically.',
    tags: ['coroutines', 'retry', 'testing'],
  },
  {
    id: 'kotlin-testing-l3-074',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'testApplication',
    question: 'How do you test Ktor server-sent events (SSE)?',
    codeSnippet: `@Test
fun testSSE() = testApplication {
    application { configureSSE() }
    val response = client.get("/events") {
        header(HttpHeaders.Accept, "text/event-stream")
    }
    val events = response.bodyAsChannel()
        .readRemaining().readText()
    assertTrue(events.contains("data: "))
}`,
    options: [
      'Make a GET request and read the response body as a channel or text stream',
      'Use a special SSE test client',
      'SSE cannot be tested with testApplication',
      'Use a WebSocket client for SSE',
    ],
    correctAnswer: 0,
    explanation: 'Test SSE by making a standard GET request with the Accept: text/event-stream header. Read the response body and parse the events. The testApplication handles streaming responses.',
    tags: ['ktor', 'sse', 'testApplication'],
  },
  {
    id: 'kotlin-testing-l3-075',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'Property-based Testing',
    question: 'How do you seed a property test for reproducibility?',
    codeSnippet: `checkAll(PropTestConfig(seed = 12345L), Arb.int()) { n ->
    // test with reproducible random values
}`,
    options: [
      'Use Random.setSeed() globally',
      'Property tests are always deterministic',
      'Pass a seed via PropTestConfig to make the random sequence reproducible',
      'Use @Seed annotation',
    ],
    correctAnswer: 2,
    explanation: 'PropTestConfig(seed = value) fixes the random seed for reproducible test runs. When a property test fails, Kotest reports the seed so you can replay the exact same sequence to debug.',
    tags: ['kotest', 'property-testing', 'seed'],
  },
  {
    id: 'kotlin-testing-l3-076',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'MockK',
    question: 'How does MockK handle inline classes (value classes)?',
    codeSnippet: `@JvmInline
value class UserId(val value: Long)

interface UserRepo {
    fun findById(id: UserId): User?
}`,
    options: [
      'Inline classes cannot be used with MockK',
      'MockK handles inline classes transparently in recent versions',
      'Use @MockKInline annotation',
      'You must unwrap the value manually',
    ],
    correctAnswer: 1,
    explanation: 'Recent versions of MockK support inline (value) classes transparently. You can mock functions that accept or return value classes without any special handling. Use every { repo.findById(any()) } returns user as usual.',
    tags: ['mockk', 'inline-class', 'value-class'],
  },
  {
    id: 'kotlin-testing-l3-077',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'Kotest',
    question: 'How do you use Kotest\'s clue function for better error messages?',
    codeSnippet: `withClue("Checking user after registration") {
    user.isActive shouldBe true
    user.email shouldNotBe null
}`,
    options: [
      'withClue provides additional context in assertion failure messages',
      'clue adds a test description',
      'clue creates a test report entry',
      'withClue logs debugging information',
    ],
    correctAnswer: 0,
    explanation: 'withClue wraps assertions with additional context that appears in failure messages. When an assertion fails inside withClue, the clue message is prepended to the error, making debugging easier.',
    tags: ['kotest', 'clue', 'debugging'],
  },
  {
    id: 'kotlin-testing-l3-078',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'TestContainers',
    question: 'How do you reuse TestContainers across multiple test classes?',
    codeSnippet: `object SharedContainers {
    val postgres = PostgreSQLContainer("postgres:15").apply { start() }
}`,
    options: [
      'Use @Container on shared companion objects',
      'Use singleton objects or TestContainers\' reusable containers feature',
      'Use @SharedContainer annotation',
      'Containers must be per-class',
    ],
    correctAnswer: 1,
    explanation: 'Share containers via Kotlin object declarations (singletons) that start the container once. TestContainers also supports .withReuse(true) with testcontainers.reuse.enable=true in .testcontainers.properties.',
    tags: ['testcontainers', 'reuse', 'performance'],
  },
  {
    id: 'kotlin-testing-l3-079',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'Android Testing',
    question: 'What is the purpose of IdlingResource in Espresso testing?',
    options: [
      'To pause tests when the app is idle',
      'To synchronize tests with asynchronous operations',
      'To make tests run slower',
      'To detect idle CPU usage',
    ],
    correctAnswer: 1,
    explanation: 'IdlingResource tells Espresso when the app is idle or busy. Espresso waits for all registered IdlingResources to be idle before performing actions or assertions, preventing flaky tests due to async operations.',
    tags: ['android', 'espresso', 'idling-resource'],
  },
  {
    id: 'kotlin-testing-l3-080',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'Kotest',
    question: 'How do you use Kotest\'s non-deterministic testing utilities?',
    codeSnippet: `until(10.seconds) {
    service.isReady()
}`,
    options: [
      'Use Thread.sleep in a loop',
      'Use CompletableDeferred',
      'Use until { }, eventually { }, and continually { } for non-deterministic assertions',
      'Use Future.get()',
    ],
    correctAnswer: 2,
    explanation: 'Kotest provides until (poll until condition is true), eventually (retry assertion until it passes), and continually (assert condition holds for duration) for non-deterministic testing scenarios.',
    tags: ['kotest', 'non-deterministic', 'async'],
  },
  {
    id: 'kotlin-testing-l3-081',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'JUnit 5',
    question: 'How do you use @ParameterizedTest with @NullSource and @EmptySource?',
    codeSnippet: `@ParameterizedTest
@NullAndEmptySource
@ValueSource(strings = ["  ", "\\t"])
fun testBlankStrings(input: String?) {
    assertTrue(input.isNullOrBlank())
}`,
    options: [
      'They provide null and empty values as additional test arguments',
      'They skip tests with null or empty inputs',
      'They filter out null and empty values',
      'They replace null and empty values with defaults',
    ],
    correctAnswer: 0,
    explanation: '@NullSource adds a null argument, @EmptySource adds an empty string/collection/array. @NullAndEmptySource combines both. They can be combined with @ValueSource for comprehensive edge case testing.',
    tags: ['junit5', 'parameterized', 'null-source'],
  },
  {
    id: 'kotlin-testing-l3-082',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'Kotest Generators',
    question: 'How do you filter generated values in Kotest?',
    codeSnippet: `val positiveOddArb = Arb.int(1..1000).filter { it % 2 != 0 }`,
    options: [
      'Use Arb.takeIf { }',
      'Use Arb.select { }',
      'Use Arb.where { }',
      'Use Arb.filter { } to keep only values matching the predicate',
    ],
    correctAnswer: 3,
    explanation: 'Arb.filter { } discards generated values that do not match the predicate. Be careful with very restrictive filters as they can slow down generation. Prefer constrained ranges when possible.',
    tags: ['kotest', 'generators', 'filter'],
  },
  {
    id: 'kotlin-testing-l3-083',
    language: 'kotlin',
    level: 'level3',
    category: 'Testing',
    subcategory: 'MockK',
    question: 'How do you mock a sealed class hierarchy in MockK?',
    codeSnippet: `sealed class Result {
    data class Success(val data: String) : Result()
    data class Error(val message: String) : Result()
}`,
    options: [
      'Create real instances of the sealed class subclasses for testing - no mocking needed',
      'Mock the sealed class directly with mockk<Result>()',
      'Use sealedMock<Result>()',
      'Sealed classes require special MockK configuration',
    ],
    correctAnswer: 0,
    explanation: 'Sealed classes with data class subclasses are best tested by creating real instances: Result.Success("data") or Result.Error("oops"). Mocking is unnecessary since these are simple value objects.',
    tags: ['mockk', 'sealed-class', 'best-practices'],
  },
];

export default questions;
