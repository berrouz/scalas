import { Question } from '@/types/question';

const questions: Question[] = [
  {
    id: 'kotlin-testing-l2-001',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: 'MockK',
    question: 'What is a captured slot in MockK and how is it used?',
    codeSnippet: `val slot = slot<User>()
every { repo.save(capture(slot)) } just Runs
service.createUser("John")
assertEquals("John", slot.captured.name)`,
    options: [
      'A slot captures the argument passed to a mocked method',
      'A slot stores the return value of a mock',
      'A slot is a placeholder for test data',
      'A slot delays mock execution',
    ],
    correctAnswer: 0,
    explanation: 'A slot in MockK captures arguments passed to mocked methods. You create it with slot<T>(), use capture(slot) in the every block, and access the captured value via slot.captured. This is useful for verifying complex arguments.',
    tags: ['mockk', 'slot', 'capture'],
  },
  {
    id: 'kotlin-testing-l2-002',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: 'MockK',
    question: 'How do you capture multiple arguments in MockK?',
    codeSnippet: `val slots = mutableListOf<String>()
every { logger.log(capture(slots)) } just Runs
service.process()
// slots now contains all captured arguments`,
    options: [
      'Use slot<T>() for each call',
      'Use captureAll<T>()',
      'Use multiSlot<T>()',
      'Use a MutableList<T> with capture()',
    ],
    correctAnswer: 3,
    explanation: 'To capture multiple arguments across multiple calls, pass a MutableList<T> to capture() instead of a slot. Each call appends the argument to the list.',
    tags: ['mockk', 'slot', 'capture'],
  },
  {
    id: 'kotlin-testing-l2-003',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: 'MockK',
    question: 'What is the difference between verify and confirmVerified in MockK?',
    options: [
      'verify checks specific calls; confirmVerified ensures no unexpected calls were made',
      'confirmVerified is for suspend functions only',
      'They are identical',
      'verify is deprecated in favor of confirmVerified',
    ],
    correctAnswer: 0,
    explanation: 'verify checks that specific methods were called. confirmVerified(mock) additionally checks that all calls to the mock have been verified, ensuring there were no unexpected interactions.',
    tags: ['mockk', 'verify', 'confirmVerified'],
  },
  {
    id: 'kotlin-testing-l2-004',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: 'MockK',
    question: 'How do you verify the order of method calls in MockK?',
    codeSnippet: `// Which approach verifies call order?`,
    options: [
      'verify { mock.first(); mock.second() }',
      'verifyOrder { mock.first(); mock.second() }',
      'verifySequential { mock.first(); mock.second() }',
      'verify(ordered = true) { mock.first(); mock.second() }',
    ],
    correctAnswer: 1,
    explanation: 'verifyOrder { } checks that the specified calls happened in the given order, but allows other calls in between. For strict sequence with no other calls, use verifySequence { }.',
    tags: ['mockk', 'verify', 'ordering'],
  },
  {
    id: 'kotlin-testing-l2-005',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: 'MockK',
    question: 'What is the difference between verifyOrder and verifySequence in MockK?',
    options: [
      'verifyOrder is for coroutines; verifySequence is for regular functions',
      'They are identical',
      'verifyOrder allows other calls between verified calls; verifySequence requires exact sequence',
      'verifySequence allows other calls; verifyOrder requires exact sequence',
    ],
    correctAnswer: 2,
    explanation: 'verifyOrder checks that calls happened in order but allows other calls in between. verifySequence checks that calls happened in exact order with no other calls to the mock in between.',
    tags: ['mockk', 'verify', 'ordering'],
  },
  {
    id: 'kotlin-testing-l2-006',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: 'MockK',
    question: 'How do you mock a companion object method in MockK?',
    codeSnippet: `class MyClass {
    companion object {
        fun create(): MyClass = MyClass()
    }
}`,
    options: [
      'mockkObject(MyClass) and then every { MyClass.create() } returns ...',
      'mockk<MyClass.Companion>()',
      'mockk<MyClass>(companionMock = true)',
      'mockkStatic(MyClass::class)',
    ],
    correctAnswer: 0,
    explanation: 'To mock companion object methods, use mockkObject(MyClass). Kotlin companion objects are singleton objects, so mockkObject is the correct approach. Then use every { } to define behavior.',
    tags: ['mockk', 'companion-object', 'intermediate'],
  },
  {
    id: 'kotlin-testing-l2-007',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: 'MockK',
    question: 'How do you mock a top-level (extension) function in MockK?',
    codeSnippet: `// File: StringExtensions.kt
fun String.isValidEmail(): Boolean = this.contains("@")`,
    options: [
      'mockkFun(::isValidEmail)',
      'mockkStatic("com.example.StringExtensionsKt")',
      'mockkExtension(String::isValidEmail)',
      'mockk<String>()',
    ],
    correctAnswer: 1,
    explanation: 'Top-level and extension functions are compiled to static methods in a class named <FileName>Kt. Use mockkStatic() with the fully qualified class name to mock them. Always call unmockkStatic() in cleanup.',
    tags: ['mockk', 'extension-functions', 'static'],
  },
  {
    id: 'kotlin-testing-l2-008',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: 'MockK',
    question: 'How do you mock a constructor call in MockK?',
    codeSnippet: `// How to mock: val user = User("John")`,
    options: [
      'mockkConstructor(User::class)',
      'mockk<User>(constructor = true)',
      'mockkNew(User::class)',
      'mockk<User>(interceptNew = true)',
    ],
    correctAnswer: 0,
    explanation: 'mockkConstructor(User::class) intercepts constructor calls for the given class. Then use every { constructedWith<User>(MatcherScope) } to define behavior for the constructed object.',
    tags: ['mockk', 'constructor', 'intermediate'],
  },
  {
    id: 'kotlin-testing-l2-009',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: 'Coroutine Testing',
    question: 'What is the correct way to test a suspend function in Kotlin?',
    codeSnippet: `suspend fun fetchUser(id: Int): User { ... }`,
    options: [
      'Use runBlocking { } in the test',
      'Use runTest { } from kotlinx-coroutines-test',
      'Use launch { } in the test',
      'Call the function directly without any wrapper',
    ],
    correctAnswer: 1,
    explanation: 'runTest from kotlinx-coroutines-test is the recommended way to test suspend functions. It provides a TestCoroutineScheduler that auto-advances virtual time, making delay-based tests fast and deterministic.',
    tags: ['coroutines', 'runTest', 'suspend'],
  },
  {
    id: 'kotlin-testing-l2-010',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: 'Coroutine Testing',
    question: 'What advantage does runTest have over runBlocking for testing coroutines?',
    options: [
      'runTest provides better error messages',
      'runTest supports more assertion types',
      'runTest auto-advances virtual time, making delay-based tests instant',
      'runTest runs tests in parallel',
    ],
    correctAnswer: 2,
    explanation: 'runTest uses a TestCoroutineScheduler that automatically advances virtual time past delays, so tests with delay() calls complete instantly instead of waiting. runBlocking would actually wait for the delays.',
    tags: ['coroutines', 'runTest', 'virtual-time'],
  },
  {
    id: 'kotlin-testing-l2-011',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: 'MockK',
    question: 'How do you mock a suspend function in MockK?',
    codeSnippet: `interface ApiService {
    suspend fun getData(): List<String>
}`,
    options: [
      'asyncEvery { service.getData() } returns listOf("a")',
      'suspendEvery { service.getData() } returns listOf("a")',
      'coEvery { service.getData() } returns listOf("a")',
      'every { service.getData() } returns listOf("a")',
    ],
    correctAnswer: 2,
    explanation: 'coEvery is the coroutine-aware version of every in MockK. It must be used for suspend functions. Similarly, coVerify is used to verify suspend function calls.',
    tags: ['mockk', 'coEvery', 'coroutines'],
  },
  {
    id: 'kotlin-testing-l2-012',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: 'MockK',
    question: 'How do you verify a suspend function call in MockK?',
    options: [
      'suspendVerify { service.getData() }',
      'coVerify { service.getData() }',
      'awaitVerify { service.getData() }',
      'verify { service.getData() }',
    ],
    correctAnswer: 1,
    explanation: 'coVerify is the coroutine-aware version of verify. It must be used for verifying calls to suspend functions. Using regular verify with suspend functions will cause compilation errors.',
    tags: ['mockk', 'coVerify', 'coroutines'],
  },
  {
    id: 'kotlin-testing-l2-013',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: '@ParameterizedTest',
    question: 'How do you use @MethodSource in Kotlin with JUnit 5?',
    codeSnippet: `class CalculatorTest {
    companion object {
        @JvmStatic
        fun additionProvider(): Stream<Arguments> = Stream.of(
            Arguments.of(1, 2, 3),
            Arguments.of(0, 0, 0)
        )
    }

    @ParameterizedTest
    @MethodSource("additionProvider")
    fun testAdd(a: Int, b: Int, expected: Int) {
        assertEquals(expected, a + b)
    }
}`,
    options: [
      'The method source must be an extension function',
      'The method source must be in a separate file',
      'The method source must be in a companion object with @JvmStatic',
      'The method source must return a List',
    ],
    correctAnswer: 2,
    explanation: 'In Kotlin, @MethodSource methods must be static. Since Kotlin does not have static methods, they go in a companion object with @JvmStatic. Alternatively, use @TestInstance(PER_CLASS) to avoid this requirement.',
    tags: ['junit5', 'parameterized', 'methodsource'],
  },
  {
    id: 'kotlin-testing-l2-014',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: '@ParameterizedTest',
    question: 'What does @EnumSource do in JUnit 5?',
    codeSnippet: `@ParameterizedTest
@EnumSource(Season::class)
fun testSeason(season: Season) {
    assertNotNull(season.name)
}`,
    options: [
      'Creates enum values at runtime',
      'Converts strings to enum values',
      'Tests only the first enum value',
      'Uses all values of an enum as test arguments',
    ],
    correctAnswer: 3,
    explanation: '@EnumSource uses enum constants as test arguments. By default it uses all values, but you can filter with names and mode parameters (INCLUDE, EXCLUDE, MATCH_ALL, MATCH_ANY).',
    tags: ['junit5', 'parameterized', 'enumsource'],
  },
  {
    id: 'kotlin-testing-l2-015',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: '@Nested',
    question: 'Can @Nested test classes access @BeforeEach setup from the outer class?',
    codeSnippet: `class OuterTest {
    private lateinit var calculator: Calculator

    @BeforeEach
    fun setup() { calculator = Calculator() }

    @Nested
    inner class AdditionTests {
        @Test
        fun \`should add correctly\`() {
            assertEquals(3, calculator.add(1, 2))
        }
    }
}`,
    options: [
      'Yes, inner classes can access the outer class members and lifecycle',
      'Only with @InheritSetup annotation',
      'Only if @BeforeEach is public',
      'No, nested classes have their own isolated context',
    ],
    correctAnswer: 0,
    explanation: 'Because @Nested classes in Kotlin are inner classes, they have access to the outer class instance including its properties and @BeforeEach/@AfterEach lifecycle methods. The outer setup runs before the inner setup.',
    tags: ['junit5', 'nested', 'lifecycle'],
  },
  {
    id: 'kotlin-testing-l2-016',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: 'Kotest',
    question: 'How do you set up and tear down resources in Kotest specs?',
    codeSnippet: `class MyTest : FunSpec({
    beforeEach { /* setup */ }
    afterEach { /* teardown */ }

    test("my test") { ... }
})`,
    options: [
      'Using beforeEach/afterEach listener functions inside the spec',
      'Using setup/teardown methods',
      'Using @BeforeEach annotations',
      'Using init blocks only',
    ],
    correctAnswer: 0,
    explanation: 'Kotest provides beforeEach, afterEach, beforeSpec, afterSpec, beforeTest, and afterTest listener functions that can be called inside the spec constructor. They replace JUnit lifecycle annotations.',
    tags: ['kotest', 'lifecycle', 'listeners'],
  },
  {
    id: 'kotlin-testing-l2-017',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: 'Kotest',
    question: 'What is the difference between beforeEach and beforeTest in Kotest?',
    options: [
      'beforeEach is for FunSpec; beforeTest is for StringSpec',
      'beforeEach runs before leaf tests only; beforeTest runs before all tests including containers',
      'beforeTest runs before leaf tests only; beforeEach runs before all tests',
      'They are identical',
    ],
    correctAnswer: 1,
    explanation: 'beforeEach runs only before leaf test cases (actual tests). beforeTest runs before every test node, including container tests (describe, context blocks). For most cases, beforeEach is what you want.',
    tags: ['kotest', 'lifecycle', 'listeners'],
  },
  {
    id: 'kotlin-testing-l2-018',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: 'Kotest',
    question: 'How do you run Kotest tests with Gradle?',
    options: [
      'Add a special Kotest Gradle plugin',
      'Kotest works with the standard JUnit Platform via useJUnitPlatform()',
      'Kotest requires its own build system',
      'Use a custom Kotest test runner task',
    ],
    correctAnswer: 1,
    explanation: 'Kotest provides a JUnit Platform engine, so it integrates with standard Gradle test tasks using useJUnitPlatform(). You just need the kotest-runner-junit5 dependency.',
    tags: ['kotest', 'gradle', 'setup'],
  },
  {
    id: 'kotlin-testing-l2-019',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: 'Kotest',
    question: 'What Kotest matcher checks that a map contains a specific key?',
    codeSnippet: `val map = mapOf("name" to "John", "age" to 30)`,
    options: [
      'map shouldIncludeKey "name"',
      'map shouldContainKey "name"',
      'map shouldHave "name"',
      'map.hasKey("name")',
    ],
    correctAnswer: 1,
    explanation: 'shouldContainKey checks that a map contains the specified key. Kotest also provides shouldContainValue, shouldContain (key-value pair), and shouldContainAll.',
    tags: ['kotest', 'matchers', 'maps'],
  },
  {
    id: 'kotlin-testing-l2-020',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: 'Kotest',
    question: 'How do you check that a collection contains exactly the specified elements in any order?',
    options: [
      'list shouldContainExactlyInAnyOrder listOf(1, 2, 3)',
      'list shouldContain listOf(1, 2, 3)',
      'list shouldHaveAll listOf(1, 2, 3)',
      'list shouldMatchUnordered listOf(1, 2, 3)',
    ],
    correctAnswer: 0,
    explanation: 'shouldContainExactlyInAnyOrder checks that the collection contains exactly the specified elements regardless of order, with no extra elements. shouldContainExactly requires the same order.',
    tags: ['kotest', 'matchers', 'collections'],
  },
  {
    id: 'kotlin-testing-l2-021',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: 'Kotest',
    question: 'How do you write a data-driven test in Kotest?',
    codeSnippet: `class AddTest : FunSpec({
    withData(
        TestCase(1, 2, 3),
        TestCase(0, 0, 0),
        TestCase(-1, 1, 0),
    ) { (a, b, expected) ->
        calculator.add(a, b) shouldBe expected
    }
})`,
    options: [
      'Using testCases collection',
      'Using @ParameterizedTest annotation',
      'Using withData function in the spec',
      'Using forAll with generators',
    ],
    correctAnswer: 2,
    explanation: 'withData is Kotest\'s data-driven testing feature. It takes a collection of test data and creates individual test cases for each entry. The data class name is used in the test name.',
    tags: ['kotest', 'data-driven', 'intermediate'],
  },
  {
    id: 'kotlin-testing-l2-022',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: 'MockK',
    question: 'How do you mock a property getter in MockK?',
    codeSnippet: `class Config {
    val baseUrl: String get() = "https://api.example.com"
}`,
    options: [
      'stub { config.baseUrl = "http://localhost" }',
      'mockkProperty(config::baseUrl, "http://localhost")',
      'every { config getProperty "baseUrl" } returns "http://localhost"',
      'every { config.baseUrl } returns "http://localhost"',
    ],
    correctAnswer: 3,
    explanation: 'In MockK, property getters are mocked the same way as method calls: every { mock.property } returns value. MockK intercepts the property getter call transparently.',
    tags: ['mockk', 'properties', 'intermediate'],
  },
  {
    id: 'kotlin-testing-l2-023',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: 'MockK',
    question: 'How do you mock a property setter in MockK?',
    codeSnippet: `class Config {
    var timeout: Int = 30
}`,
    options: [
      'every { config.setTimeout(any()) } just Runs',
      'every { config setProperty "timeout" value any<Int>() } just Runs',
      'mockSetter(config::timeout)',
      'every { config.timeout = any() } just Runs',
    ],
    correctAnswer: 3,
    explanation: 'Property setters in MockK can be mocked with every { mock.property = value } just Runs. You use any() to match any value being set.',
    tags: ['mockk', 'properties', 'intermediate'],
  },
  {
    id: 'kotlin-testing-l2-024',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: 'MockK',
    question: 'What does answers in MockK allow you to do?',
    codeSnippet: `every { calculator.add(any(), any()) } answers {
    firstArg<Int>() + secondArg<Int>()
}`,
    options: [
      'Record the return value for later verification',
      'Provide custom logic to compute the return value based on arguments',
      'Log the method call details',
      'Delay the mock response',
    ],
    correctAnswer: 1,
    explanation: 'answers { } allows you to provide a custom lambda to compute the return value. Inside the lambda, you can access firstArg(), secondArg(), args, etc. to base the return value on the input arguments.',
    tags: ['mockk', 'answers', 'intermediate'],
  },
  {
    id: 'kotlin-testing-l2-025',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: 'Coroutine Testing',
    question: 'What does advanceTimeBy do in coroutine testing?',
    codeSnippet: `@Test
fun testDelayedOperation() = runTest {
    launch { delay(1000); result = "done" }
    advanceTimeBy(1000)
    assertEquals("done", result)
}`,
    options: [
      'Advances virtual time by the specified amount without real waiting',
      'Sets a timeout for the test',
      'Pauses the test for the specified duration',
      'Speeds up real time execution',
    ],
    correctAnswer: 0,
    explanation: 'advanceTimeBy advances the virtual time in the TestCoroutineScheduler by the specified milliseconds. Coroutines with delay() that are waiting will resume without actual waiting, making tests fast.',
    tags: ['coroutines', 'virtual-time', 'advanceTimeBy'],
  },
  {
    id: 'kotlin-testing-l2-026',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: 'Coroutine Testing',
    question: 'What does advanceUntilIdle do in coroutine testing?',
    options: [
      'Advances virtual time until all pending coroutines have completed',
      'Waits for a specific coroutine to become idle',
      'Pauses until all coroutines complete naturally',
      'Cancels all idle coroutines',
    ],
    correctAnswer: 0,
    explanation: 'advanceUntilIdle advances virtual time until there are no more pending tasks. All delays are skipped, and all scheduled coroutines run to completion. This is useful when you want everything to finish.',
    tags: ['coroutines', 'virtual-time', 'advanceUntilIdle'],
  },
  {
    id: 'kotlin-testing-l2-027',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: 'JUnit 5',
    question: 'How do you use @TestInstance(PER_CLASS) to simplify Kotlin test classes?',
    codeSnippet: `@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MyTest {
    @BeforeAll
    fun setup() { /* no companion object needed */ }
}`,
    options: [
      'It makes tests run faster',
      'It allows using var properties shared across tests',
      'It enables parallel test execution',
      'It eliminates the need for companion object and @JvmStatic for @BeforeAll/@AfterAll',
    ],
    correctAnswer: 3,
    explanation: 'With PER_CLASS lifecycle, the test class is instantiated once, so @BeforeAll/@AfterAll methods can be instance methods instead of requiring companion object + @JvmStatic. This is the idiomatic approach in Kotlin.',
    tags: ['junit5', 'per-class', 'kotlin'],
  },
  {
    id: 'kotlin-testing-l2-028',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: 'JUnit 5',
    question: 'How do you create a custom JUnit 5 extension in Kotlin?',
    codeSnippet: `class TimingExtension : BeforeEachCallback, AfterEachCallback {
    override fun beforeEach(context: ExtensionContext) { ... }
    override fun afterEach(context: ExtensionContext) { ... }
}`,
    options: [
      'Implement specific callback interfaces like BeforeEachCallback',
      'Extend the AbstractExtension class',
      'Implement the Extension interface only',
      'Use @Extension annotation on a function',
    ],
    correctAnswer: 0,
    explanation: 'JUnit 5 extensions implement specific callback interfaces: BeforeEachCallback, AfterEachCallback, BeforeAllCallback, ParameterResolver, TestExecutionExceptionHandler, etc. You register them with @ExtendWith.',
    tags: ['junit5', 'extensions', 'intermediate'],
  },
  {
    id: 'kotlin-testing-l2-029',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: 'JUnit 5',
    question: 'How do you register a JUnit 5 extension on a test class?',
    options: [
      '@Plugin(MyExtension::class)',
      '@UseExtension(MyExtension::class)',
      '@ExtendWith(MyExtension::class)',
      '@RegisterExtension(MyExtension::class)',
    ],
    correctAnswer: 2,
    explanation: '@ExtendWith is the declarative way to register extensions in JUnit 5. For programmatic registration with more control, use @RegisterExtension with a field.',
    tags: ['junit5', 'extensions', 'annotations'],
  },
  {
    id: 'kotlin-testing-l2-030',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: 'JUnit 5',
    question: 'What does @TempDir do in JUnit 5?',
    codeSnippet: `@Test
fun testFileOperation(@TempDir tempDir: Path) {
    val file = tempDir.resolve("test.txt")
    Files.writeString(file, "hello")
    assertEquals("hello", Files.readString(file))
}`,
    options: [
      'Creates a permanent directory for test outputs',
      'Mocks the file system',
      'Provides a temporary directory that is cleaned up after the test',
      'Creates a directory in the project root',
    ],
    correctAnswer: 2,
    explanation: '@TempDir injects a temporary directory that is automatically created before and deleted after the test. It works as a parameter or field annotation and supports both Path and File types.',
    tags: ['junit5', 'tempdir', 'file-testing'],
  },
  {
    id: 'kotlin-testing-l2-031',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: 'Kotest',
    question: 'What does shouldBeIn check in Kotest?',
    codeSnippet: `"apple" shouldBeIn listOf("apple", "banana", "cherry")`,
    options: [
      'That the value is one of the elements in the collection',
      'That the collection type matches the value type',
      'That the list contains the string as a substring',
      'That the value is the first element',
    ],
    correctAnswer: 0,
    explanation: 'shouldBeIn asserts that the value is contained within the given collection. It is the inverse of shouldContain - instead of checking the collection contains X, it checks X is in the collection.',
    tags: ['kotest', 'matchers', 'collections'],
  },
  {
    id: 'kotlin-testing-l2-032',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: 'Kotest',
    question: 'How do you use Kotest\'s DescribeSpec?',
    codeSnippet: `class MyTest : DescribeSpec({
    describe("Calculator") {
        it("should add two numbers") {
            Calculator().add(1, 2) shouldBe 3
        }
    }
})`,
    options: [
      'It uses test() function calls',
      'It uses describe/it blocks similar to JavaScript testing frameworks',
      'It uses should() blocks',
      'It uses given/when/then blocks',
    ],
    correctAnswer: 1,
    explanation: 'DescribeSpec uses describe/context/it blocks, similar to Jasmine, Mocha, or RSpec. describe groups related tests, context adds nested grouping, and it defines individual test cases.',
    tags: ['kotest', 'describespec', 'styles'],
  },
  {
    id: 'kotlin-testing-l2-033',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: 'Kotest',
    question: 'How do you make a Kotest test focus (run only that test)?',
    codeSnippet: `class MyTest : StringSpec({
    "test 1" { ... }
    "f:test 2" { ... }
    "test 3" { ... }
})`,
    options: [
      'Use the focus = true parameter',
      'Prefix the test name with "f:" to focus on it',
      'Use .only() after the test block',
      'Use @Focus annotation',
    ],
    correctAnswer: 1,
    explanation: 'In Kotest, prefixing a test name with "f:" focuses on that test, causing only focused tests to run. Similarly, "x:" prefix disables/ignores a test. This is convenient for debugging.',
    tags: ['kotest', 'focus', 'debugging'],
  },
  {
    id: 'kotlin-testing-l2-034',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: 'Kotest',
    question: 'How do you ignore/skip a test in Kotest?',
    options: [
      'Prefix the test name with "x:" to disable it',
      'Comment out the test',
      'Remove the test body',
      'Use @Disabled annotation',
    ],
    correctAnswer: 0,
    explanation: 'Prefixing a test name with "x:" in Kotest disables/ignores that test. It will be reported as ignored in the test results. You can also use xtest(), xdescribe(), etc. for the same effect.',
    tags: ['kotest', 'ignore', 'skip'],
  },
  {
    id: 'kotlin-testing-l2-035',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: 'Kotest',
    question: 'What is a Kotest test listener?',
    codeSnippet: `class MyListener : TestListener {
    override suspend fun beforeTest(testCase: TestCase) { ... }
    override suspend fun afterTest(testCase: TestCase, result: TestResult) { ... }
}`,
    options: [
      'A tool for monitoring test performance',
      'A logger for test output',
      'A callback interface for hooking into test lifecycle events',
      'A filter for selecting which tests to run',
    ],
    correctAnswer: 2,
    explanation: 'Kotest TestListener is an interface that provides callbacks for various test lifecycle events (beforeTest, afterTest, beforeSpec, afterSpec, etc.). Listeners can be registered per-spec or globally.',
    tags: ['kotest', 'listeners', 'lifecycle'],
  },
  {
    id: 'kotlin-testing-l2-036',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: 'MockK',
    question: 'What is the difference between mockk and mockkClass in MockK?',
    options: [
      'mockkClass creates relaxed mocks only',
      'mockk is inline/reified; mockkClass takes KClass parameter for non-reified contexts',
      'mockkClass is for Java classes; mockk is for Kotlin classes',
      'They are identical',
    ],
    correctAnswer: 1,
    explanation: 'mockk<T>() uses reified generics and is the standard way. mockkClass(MyClass::class) takes a KClass parameter and is used when the type is not known at compile time or in non-reified contexts.',
    tags: ['mockk', 'creation', 'intermediate'],
  },
  {
    id: 'kotlin-testing-l2-037',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: 'MockK',
    question: 'How do you use MockK annotations with JUnit 5?',
    codeSnippet: `@ExtendWith(MockKExtension::class)
class MyTest {
    @MockK
    lateinit var service: UserService

    @InjectMockKs
    lateinit var controller: UserController
}`,
    options: [
      'Use @Mockk and @Inject with MockKRunner',
      'Use @MockK and @InjectMockKs with MockKExtension',
      'Annotation-based mocking is not supported in MockK',
      'Use @Mock and @InjectMocks like Mockito',
    ],
    correctAnswer: 1,
    explanation: 'MockK provides @MockK, @SpyK, @RelaxedMockK, and @InjectMockKs annotations. Register MockKExtension with @ExtendWith to automatically initialize annotated mocks before each test.',
    tags: ['mockk', 'annotations', 'junit5'],
  },
  {
    id: 'kotlin-testing-l2-038',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: 'MockK',
    question: 'What does @InjectMockKs do in MockK?',
    options: [
      'Creates a spy of the annotated class',
      'Creates an instance of the class with @MockK dependencies automatically injected',
      'Injects real implementations instead of mocks',
      'Creates mock instances for all fields',
    ],
    correctAnswer: 1,
    explanation: '@InjectMockKs creates an instance of the annotated class and automatically injects the @MockK and @SpyK mocks as constructor or property dependencies, similar to Mockito\'s @InjectMocks.',
    tags: ['mockk', 'inject', 'annotations'],
  },
  {
    id: 'kotlin-testing-l2-039',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: 'Kotest',
    question: 'How do you assert that a map contains a specific key-value pair in Kotest?',
    codeSnippet: `val map = mapOf("name" to "John", "age" to 30)`,
    options: [
      'map shouldInclude ("name" to "John")',
      'map shouldMatch ("name" to "John")',
      'map shouldHave ("name" to "John")',
      'map shouldContain ("name" to "John")',
    ],
    correctAnswer: 3,
    explanation: 'shouldContain with a Pair checks that the map contains the specified key-value pair. You can use the "to" infix function to create a Pair for readable assertions.',
    tags: ['kotest', 'matchers', 'maps'],
  },
  {
    id: 'kotlin-testing-l2-040',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: 'Kotest',
    question: 'What does shouldMatchEach do in Kotest?',
    codeSnippet: `listOf(1, 2, 3) shouldMatchEach listOf(
    { it shouldBeGreaterThan 0 },
    { it shouldBeGreaterThan 1 },
    { it shouldBeGreaterThan 2 },
)`,
    options: [
      'Applies individual matchers to each element by position',
      'Checks that all elements match a single predicate',
      'Filters the collection by each predicate',
      'Checks that elements match a regex pattern',
    ],
    correctAnswer: 0,
    explanation: 'shouldMatchEach applies a list of individual matchers to the collection, one per element by position. It verifies that the collection has the expected size and each element satisfies its corresponding matcher.',
    tags: ['kotest', 'matchers', 'collections'],
  },
  {
    id: 'kotlin-testing-l2-041',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: 'JUnit 5',
    question: 'How do you use assumptions in JUnit 5?',
    codeSnippet: `@Test
fun testOnlyOnLinux() {
    assumeTrue(System.getProperty("os.name").contains("Linux"))
    // test code runs only on Linux
}`,
    options: [
      'Assumptions abort the test (mark as skipped) if not met',
      'Assumptions log a warning if not met',
      'Assumptions throw an exception if not met',
      'Assumptions fail the test if not met',
    ],
    correctAnswer: 0,
    explanation: 'Assumptions in JUnit 5 (assumeTrue, assumeFalse, assumingThat) abort the test if the condition is not met. The test is reported as skipped/aborted rather than failed.',
    tags: ['junit5', 'assumptions', 'conditional'],
  },
  {
    id: 'kotlin-testing-l2-042',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: '@ParameterizedTest',
    question: 'What does @CsvFileSource do in JUnit 5?',
    options: [
      'Connects to a CSV database',
      'Creates a CSV file with test results',
      'Converts test output to CSV format',
      'Reads test arguments from an external CSV file',
    ],
    correctAnswer: 3,
    explanation: '@CsvFileSource reads test arguments from external CSV files in the classpath. This is useful when you have many test cases or want to manage test data separately from test code.',
    tags: ['junit5', 'parameterized', 'csvfilesource'],
  },
  {
    id: 'kotlin-testing-l2-043',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: '@ParameterizedTest',
    question: 'How do you use @ArgumentsSource for custom argument providers?',
    codeSnippet: `class MyArgumentsProvider : ArgumentsProvider {
    override fun provideArguments(context: ExtensionContext): Stream<Arguments> {
        return Stream.of(Arguments.of("a", 1), Arguments.of("b", 2))
    }
}

@ParameterizedTest
@ArgumentsSource(MyArgumentsProvider::class)
fun test(str: String, num: Int) { ... }`,
    options: [
      'Implement ArgumentsProvider interface and reference it with @ArgumentsSource',
      'Create a companion object that provides arguments',
      'Use @CustomSource annotation',
      'Extend ArgumentsSource class',
    ],
    correctAnswer: 0,
    explanation: '@ArgumentsSource references a custom class implementing ArgumentsProvider. This gives full control over how test arguments are generated, including loading from databases, APIs, or complex computations.',
    tags: ['junit5', 'parameterized', 'custom-source'],
  },
  {
    id: 'kotlin-testing-l2-044',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: 'Coroutine Testing',
    question: 'How do you test a Flow in Kotlin?',
    codeSnippet: `val flow = flowOf(1, 2, 3)
// How to test?`,
    options: [
      'Use flow.toList() in runTest and assert on the list',
      'Use flow.collect() in runBlocking',
      'Use flow.test() from Turbine',
      'Both B and C are valid approaches',
    ],
    correctAnswer: 3,
    explanation: 'You can test Flows by collecting to a list with toList() in runTest, or use the Turbine library which provides flow.test { } for more fine-grained control over emissions, completion, and errors.',
    tags: ['coroutines', 'flow', 'testing'],
  },
  {
    id: 'kotlin-testing-l2-045',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: 'Coroutine Testing',
    question: 'What is Turbine used for in Kotlin testing?',
    options: [
      'Performance benchmarking',
      'Testing Kotlin Flows with fine-grained emission control',
      'Generating test data',
      'Testing network requests',
    ],
    correctAnswer: 1,
    explanation: 'Turbine is a small testing library for Kotlin Flows. It provides the test { } extension on Flow for asserting emissions, errors, and completion in a sequential and readable manner.',
    tags: ['turbine', 'flow', 'testing'],
  },
  {
    id: 'kotlin-testing-l2-046',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: 'Coroutine Testing',
    question: 'How do you use Turbine to test Flow emissions?',
    codeSnippet: `@Test
fun testFlow() = runTest {
    flowOf(1, 2, 3).test {
        assertEquals(1, awaitItem())
        assertEquals(2, awaitItem())
        assertEquals(3, awaitItem())
        awaitComplete()
    }
}`,
    options: [
      'awaitItem() cancels the flow',
      'awaitItem() returns the next emitted value',
      'awaitItem() waits for the flow to complete',
      'awaitItem() skips the next emission',
    ],
    correctAnswer: 1,
    explanation: 'In Turbine, awaitItem() suspends until the next value is emitted and returns it. awaitComplete() asserts the flow completes. awaitError() asserts an error is thrown. This gives precise control over Flow testing.',
    tags: ['turbine', 'flow', 'awaitItem'],
  },
  {
    id: 'kotlin-testing-l2-047',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: 'MockK',
    question: 'How do you use andThen to chain mock behaviors in MockK?',
    codeSnippet: `every { mock.getValue() } returns 1 andThen 2 andThen 3`,
    options: [
      'Returns all values at once as a list',
      'Returns a random value from 1, 2, 3',
      'Returns 1 on first call, 2 on second, 3 on third',
      'Returns the sum of 1, 2, 3',
    ],
    correctAnswer: 2,
    explanation: 'andThen chains return values for consecutive calls. The first call returns 1, the second returns 2, the third returns 3. Subsequent calls continue to return the last value (3).',
    tags: ['mockk', 'andThen', 'chaining'],
  },
  {
    id: 'kotlin-testing-l2-048',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: 'MockK',
    question: 'What is the purpose of unmockkAll() in MockK?',
    options: [
      'Resets verification counters',
      'Deletes all mock instances',
      'Removes all mock behavior definitions',
      'Restores all mocked static functions, objects, and constructors to their original state',
    ],
    correctAnswer: 3,
    explanation: 'unmockkAll() restores all mocked static methods (mockkStatic), objects (mockkObject), and constructors (mockkConstructor) to their original implementations. It is important for cleanup after tests.',
    tags: ['mockk', 'cleanup', 'unmock'],
  },
  {
    id: 'kotlin-testing-l2-049',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: 'Kotest',
    question: 'How do you configure test timeouts in Kotest?',
    codeSnippet: `class MyTest : StringSpec({
    "slow test".config(timeout = 10.seconds) {
        // test code
    }
})`,
    options: [
      'Both B and C are valid approaches',
      'Using @Timeout annotation',
      'Setting a global timeout in a properties file',
      'Using .config(timeout = ...) on individual tests',
    ],
    correctAnswer: 0,
    explanation: 'Kotest supports test timeouts both per-test via .config(timeout = ...) and globally via kotest.framework.timeout in AbstractProjectConfig or kotest.properties file.',
    tags: ['kotest', 'timeout', 'configuration'],
  },
  {
    id: 'kotlin-testing-l2-050',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: 'Kotest',
    question: 'How do you retry flaky tests in Kotest?',
    codeSnippet: `class MyTest : StringSpec({
    "flaky test".config(invocations = 3, invocationTimeout = 5.seconds) {
        // test code
    }
})`,
    options: [
      'Using config(invocations = n) to run the test multiple times',
      'Using @Retry annotation',
      'Using the kotest-retry plugin',
      'Wrapping the test in a retry loop',
    ],
    correctAnswer: 0,
    explanation: 'Kotest allows running a test multiple times with config(invocations = n). The test passes if all invocations pass. You can also use config(retries = n) which retries only on failure.',
    tags: ['kotest', 'retry', 'flaky-tests'],
  },
  {
    id: 'kotlin-testing-l2-051',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: 'Kotest',
    question: 'What does shouldBeBetween check in Kotest?',
    codeSnippet: `val result = calculateScore()
result.shouldBeBetween(0, 100)`,
    options: [
      'That the value is between two other values (exclusive)',
      'That the value is between two types',
      'That the value is in a list between two elements',
      'That the value was modified between two calls',
    ],
    correctAnswer: 0,
    explanation: 'shouldBeBetween checks that a comparable value falls between two bounds. By default the bounds are inclusive, but you can specify exclusivity. This is useful for range validation.',
    tags: ['kotest', 'matchers', 'numeric'],
  },
  {
    id: 'kotlin-testing-l2-052',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: 'JUnit 5',
    question: 'What is @TestMethodOrder used for in JUnit 5?',
    codeSnippet: `@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
class OrderedTest {
    @Test @Order(1) fun first() { }
    @Test @Order(2) fun second() { }
}`,
    options: [
      'Controls the execution order of test methods',
      'Sorts test results in the report',
      'Orders test classes in a suite',
      'Groups tests by category',
    ],
    correctAnswer: 0,
    explanation: '@TestMethodOrder specifies how test methods should be ordered. Options include OrderAnnotation (explicit @Order), DisplayName (alphabetical by display name), MethodName (alphabetical by method name), and Random.',
    tags: ['junit5', 'ordering', 'annotations'],
  },
  {
    id: 'kotlin-testing-l2-053',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: 'Kotest',
    question: 'What is the Kotest matcher for checking string regex patterns?',
    codeSnippet: `"user@email.com" shouldMatch ".*@.*\\\\..*"`,
    options: [
      'shouldMatch',
      'shouldFitPattern',
      'shouldMatchRegex',
      'shouldConformTo',
    ],
    correctAnswer: 0,
    explanation: 'shouldMatch checks that a string matches a regular expression pattern. The pattern is provided as a String. Kotest also provides shouldNotMatch for the inverse check.',
    tags: ['kotest', 'matchers', 'regex'],
  },
  {
    id: 'kotlin-testing-l2-054',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: 'Coroutine Testing',
    question: 'How do you test coroutine exception handling?',
    codeSnippet: `@Test
fun testExceptionHandling() = runTest {
    val result = runCatching { fetchData() }
    assertTrue(result.isFailure)
    assertIs<NetworkException>(result.exceptionOrNull())
}`,
    options: [
      'Use try-catch blocks only',
      'Use CoroutineExceptionHandler in the test',
      'Exceptions cannot be tested in coroutines',
      'Use runCatching or assertThrows within runTest',
    ],
    correctAnswer: 3,
    explanation: 'You can test coroutine exceptions using runCatching { } to safely capture the result, or use assertThrows/shouldThrow within runTest. Both approaches work well for verifying exception behavior in suspend functions.',
    tags: ['coroutines', 'exceptions', 'testing'],
  },
  {
    id: 'kotlin-testing-l2-055',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: 'MockK',
    question: 'How do you mock an object declaration (Kotlin singleton) in MockK?',
    codeSnippet: `object AppConfig {
    val apiKey: String = "secret"
    fun isDebug(): Boolean = false
}`,
    options: [
      'mockkObject(AppConfig)',
      'mockk<AppConfig>()',
      'mockkStatic(AppConfig::class)',
      'mockkSingleton(AppConfig::class)',
    ],
    correctAnswer: 0,
    explanation: 'mockkObject is used to mock Kotlin object declarations (singletons). After calling mockkObject(AppConfig), you can use every { } to override its properties and methods. Always call unmockkObject in cleanup.',
    tags: ['mockk', 'object', 'singleton'],
  },
  {
    id: 'kotlin-testing-l2-056',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: 'Kotest',
    question: 'How do you use test tags in Kotest?',
    codeSnippet: `object SlowTag : Tag()
object IntegrationTag : Tag()

class MyTest : StringSpec({
    "slow test".config(tags = setOf(SlowTag)) {
        // test code
    }
})`,
    options: [
      'Using test name prefixes',
      'Using @Tag annotation like JUnit 5',
      'Using Tag objects and .config(tags = setOf(...))',
      'Using string labels on tests',
    ],
    correctAnswer: 2,
    explanation: 'Kotest uses Tag objects for test filtering. You define tag objects and assign them to tests via .config(tags = ...). Then configure which tags to include/exclude via system properties or project config.',
    tags: ['kotest', 'tags', 'filtering'],
  },
  {
    id: 'kotlin-testing-l2-057',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: 'JUnit 5',
    question: 'What does assertDoesNotThrow do in JUnit 5?',
    codeSnippet: `assertDoesNotThrow {
    parseInput("valid input")
}`,
    options: [
      'Returns null if an exception is thrown',
      'Catches and ignores any exception',
      'Converts exceptions to assertion failures',
      'Asserts that the block completes without throwing any exception',
    ],
    correctAnswer: 3,
    explanation: 'assertDoesNotThrow explicitly asserts that the given block completes without throwing any exception. While tests fail on unexpected exceptions anyway, this makes the intent explicit and self-documenting.',
    tags: ['junit5', 'assertions', 'exceptions'],
  },
  {
    id: 'kotlin-testing-l2-058',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: 'Kotest',
    question: 'What is Kotest\'s FreeSpec style?',
    codeSnippet: `class MyTest : FreeSpec({
    "String.length" - {
        "should return the length" {
            "hello".length shouldBe 5
        }
        "should return 0 for empty string" {
            "".length shouldBe 0
        }
    }
})`,
    options: [
      'Tests defined with strings and minus operator for nesting',
      'Tests that can be written in any language',
      'Tests defined with free-form function names',
      'Tests that run without any framework',
    ],
    correctAnswer: 0,
    explanation: 'FreeSpec allows arbitrary nesting using the - (minus) operator. Intermediate levels (with -) are containers, and leaf levels (without -) are actual test cases. This allows very flexible test organization.',
    tags: ['kotest', 'freespec', 'styles'],
  },
  {
    id: 'kotlin-testing-l2-059',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: 'MockK',
    question: 'How do you use match { } argument matcher in MockK?',
    codeSnippet: `every { repo.findUsers(match { it.age > 18 }) } returns adults`,
    options: [
      'match { } applies a custom predicate to the argument',
      'match { } checks for null values',
      'match { } matches against a regex pattern',
      'match { } checks if the argument is a specific type',
    ],
    correctAnswer: 0,
    explanation: 'match { } is a custom argument matcher in MockK that takes a predicate lambda. The mock behavior is triggered only when the actual argument satisfies the predicate. This is useful for complex matching logic.',
    tags: ['mockk', 'matchers', 'custom'],
  },
  {
    id: 'kotlin-testing-l2-060',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: 'MockK',
    question: 'How do you verify that a method was never called in MockK?',
    options: [
      'verifyNot { mock.method() }',
      'verify(never = true) { mock.method() }',
      'verify(exactly = 0) { mock.method() }',
      'verify(called = false) { mock.method() }',
    ],
    correctAnswer: 2,
    explanation: 'verify(exactly = 0) { } checks that the method was never called. This is important for negative testing - verifying that certain side effects did NOT happen.',
    tags: ['mockk', 'verify', 'negative-testing'],
  },
  {
    id: 'kotlin-testing-l2-061',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: 'Kotest',
    question: 'What does shouldHaveMessage do in Kotest?',
    codeSnippet: `val exception = shouldThrow<IllegalArgumentException> {
    validate(-1)
}
exception shouldHaveMessage "Value must be positive"`,
    options: [
      'Checks that a log contains the message',
      'Checks that an exception has the specified message',
      'Checks that a string equals the message',
      'Sends a message to the test reporter',
    ],
    correctAnswer: 1,
    explanation: 'shouldHaveMessage is an exception matcher that checks the exception message property. It is commonly used after shouldThrow to verify both the exception type and its message.',
    tags: ['kotest', 'matchers', 'exceptions'],
  },
  {
    id: 'kotlin-testing-l2-062',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: 'Kotest',
    question: 'How do you create a custom Kotest matcher?',
    codeSnippet: `fun beEven() = Matcher<Int> { value ->
    MatcherResult(
        value % 2 == 0,
        { "$value should be even" },
        { "$value should not be even" },
    )
}

4 should beEven()`,
    options: [
      'Create a function that returns a Matcher<T> instance',
      'Use @CustomMatcher annotation',
      'Implement the Matchable interface',
      'Extend the Matcher class',
    ],
    correctAnswer: 0,
    explanation: 'Custom matchers in Kotest are functions that return a Matcher<T>. The Matcher contains a test function returning MatcherResult with the match result, failure message, and negated failure message.',
    tags: ['kotest', 'matchers', 'custom'],
  },
  {
    id: 'kotlin-testing-l2-063',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: 'Coroutine Testing',
    question: 'What is the purpose of TestCoroutineScheduler?',
    options: [
      'To schedule tests for later execution',
      'To manage thread pools in tests',
      'To control virtual time in coroutine tests',
      'To run tests in parallel',
    ],
    correctAnswer: 2,
    explanation: 'TestCoroutineScheduler controls virtual time for coroutine tests. It is used by runTest internally and provides methods like advanceTimeBy, advanceUntilIdle, and currentTime to control time-based behavior.',
    tags: ['coroutines', 'scheduler', 'virtual-time'],
  },
  {
    id: 'kotlin-testing-l2-064',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: 'Coroutine Testing',
    question: 'How do you test a StateFlow?',
    codeSnippet: `class ViewModel {
    private val _state = MutableStateFlow(0)
    val state: StateFlow<Int> = _state.asStateFlow()
    fun increment() { _state.value++ }
}`,
    options: [
      'Directly read the value property after operations',
      'StateFlows cannot be tested',
      'Both A and B work depending on the scenario',
      'Use flow.test { } from Turbine for emission assertions',
    ],
    correctAnswer: 2,
    explanation: 'Simple state changes can be tested by reading .value directly. For testing emission sequences or more complex scenarios, use Turbine\'s flow.test { }. Both approaches have their place.',
    tags: ['coroutines', 'stateflow', 'testing'],
  },
  {
    id: 'kotlin-testing-l2-065',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: 'testApplication',
    question: 'How do you test a Ktor server application?',
    codeSnippet: `@Test
fun testRoot() = testApplication {
    application { configureRouting() }
    val response = client.get("/")
    assertEquals(HttpStatusCode.OK, response.status)
}`,
    options: [
      'Use testApplication { } which creates an in-memory test server',
      'Use mockk to mock the Application class',
      'Start a real server and make HTTP calls',
      'Use JUnit HttpClient to call endpoints',
    ],
    correctAnswer: 0,
    explanation: 'Ktor provides testApplication { } that creates an in-memory test server without starting a real network server. This is fast and allows testing routes, plugins, and responses without network overhead.',
    tags: ['ktor', 'testApplication', 'server-testing'],
  },
  {
    id: 'kotlin-testing-l2-066',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: 'testApplication',
    question: 'How do you send a POST request with JSON body in Ktor test?',
    codeSnippet: `@Test
fun testCreateUser() = testApplication {
    application { configureRouting() }
    val response = client.post("/users") {
        contentType(ContentType.Application.Json)
        setBody("""{"name":"John"}""")
    }
    assertEquals(HttpStatusCode.Created, response.status)
}`,
    options: [
      'Use client.send(POST, "/users", body)',
      'Use client.post() with contentType and setBody',
      'Use HttpPost("/users").body(json)',
      'Use client.request(Method.POST)',
    ],
    correctAnswer: 1,
    explanation: 'In Ktor test client, you use client.post(url) { } with contentType() and setBody() inside the builder lambda. This mirrors the real Ktor client API.',
    tags: ['ktor', 'testApplication', 'post-request'],
  },
  {
    id: 'kotlin-testing-l2-067',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: 'JUnit 5',
    question: 'What is the purpose of @ExtendWith in JUnit 5?',
    options: [
      'To extend the test class with additional methods',
      'To add extra assertions to the test',
      'To register extensions that can hook into test lifecycle and provide additional functionality',
      'To extend the timeout of tests',
    ],
    correctAnswer: 2,
    explanation: '@ExtendWith registers JUnit 5 extensions on a test class. Extensions can provide parameter injection, lifecycle callbacks, conditional execution, and more. Multiple extensions can be registered.',
    tags: ['junit5', 'extensions', 'annotations'],
  },
  {
    id: 'kotlin-testing-l2-068',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: 'Kotest',
    question: 'How do you configure Kotest globally with a project config?',
    codeSnippet: `class ProjectConfig : AbstractProjectConfig() {
    override val parallelism = 4
    override fun extensions() = listOf(MyExtension())
}`,
    options: [
      'Use a Gradle plugin configuration',
      'Create a class extending AbstractProjectConfig in the test source root',
      'Set system properties in the test task',
      'Create a kotest.properties file',
    ],
    correctAnswer: 1,
    explanation: 'Kotest discovers a class extending AbstractProjectConfig in the test classpath. It allows global configuration of parallelism, default timeout, extensions, listeners, and other settings.',
    tags: ['kotest', 'configuration', 'project-config'],
  },
  {
    id: 'kotlin-testing-l2-069',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: 'Assertions',
    question: 'What does assertInstanceOf do in JUnit 5?',
    codeSnippet: `val result: Any = getResult()
val str = assertInstanceOf(String::class.java, result)
// str is now typed as String`,
    options: [
      'Creates a new instance of the specified type',
      'Checks if the value is not null',
      'Checks if two instances are equal',
      'Checks the type and returns the value cast to that type',
    ],
    correctAnswer: 3,
    explanation: 'assertInstanceOf checks that the value is an instance of the specified type AND returns it cast to that type. This is useful for both type assertion and smart casting in subsequent assertions.',
    tags: ['junit5', 'assertions', 'type-checking'],
  },
  {
    id: 'kotlin-testing-l2-070',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: 'MockK',
    question: 'How does MockK handle generic types in mocking?',
    codeSnippet: `val repo = mockk<Repository<User>>()`,
    options: [
      'You must use raw types',
      'Generic types cannot be mocked',
      'MockK uses reified generics and inline functions to preserve type information',
      'You must provide a TypeReference',
    ],
    correctAnswer: 2,
    explanation: 'MockK leverages Kotlin\'s reified generics (inline functions) to preserve type information at runtime. This means mockk<Repository<User>>() works correctly, unlike Java libraries that suffer from type erasure.',
    tags: ['mockk', 'generics', 'intermediate'],
  },
  {
    id: 'kotlin-testing-l2-071',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: 'Kotest',
    question: 'What are Kotest soft assertions?',
    codeSnippet: `assertSoftly {
    "hello".length shouldBe 5
    "hello" shouldStartWith "h"
    "hello" shouldEndWith "o"
}`,
    options: [
      'Assertions that never fail',
      'Assertions that collect all failures before reporting, similar to JUnit 5 assertAll',
      'Assertions that print warnings instead of failing',
      'Assertions with lenient matching',
    ],
    correctAnswer: 1,
    explanation: 'assertSoftly collects all assertion failures within the block and reports them together at the end. This is similar to JUnit 5\'s assertAll and helps identify all issues in a single test run.',
    tags: ['kotest', 'soft-assertions', 'intermediate'],
  },
  {
    id: 'kotlin-testing-l2-072',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: 'Kotest',
    question: 'What does shouldContainAll check in Kotest?',
    codeSnippet: `listOf(1, 2, 3, 4, 5) shouldContainAll listOf(1, 3, 5)`,
    options: [
      'That the collection contains all specified elements (and possibly others)',
      'That the collection has no duplicates',
      'That the collection contains exactly the specified elements',
      'That all elements match a predicate',
    ],
    correctAnswer: 0,
    explanation: 'shouldContainAll checks that the collection contains all of the specified elements, but may also contain additional elements. For exact matching, use shouldContainExactly.',
    tags: ['kotest', 'matchers', 'collections'],
  },
  {
    id: 'kotlin-testing-l2-073',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: 'JUnit 5',
    question: 'How do you create a JUnit 5 dynamic test in Kotlin?',
    codeSnippet: `@TestFactory
fun dynamicTests(): List<DynamicTest> {
    return listOf(1 to 2, 3 to 4).map { (input, expected) ->
        dynamicTest("test $input -> $expected") {
            assertEquals(expected, input + 1)
        }
    }
}`,
    options: [
      'Return a List<DynamicTest> from a @TestFactory method',
      'Return a Stream<TestCase> from a @TestFactory method',
      'Return a TestSuite from a @TestFactory method',
      'Return a List<Test> from a @TestFactory method',
    ],
    correctAnswer: 0,
    explanation: '@TestFactory methods return collections of DynamicTest (or DynamicContainer, DynamicNode) instances. Each DynamicTest has a display name and an executable. This is powerful for data-driven test generation.',
    tags: ['junit5', 'dynamic-tests', 'testfactory'],
  },
  {
    id: 'kotlin-testing-l2-074',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: 'MockK',
    question: 'How do you verify at least n calls in MockK?',
    options: [
      'verify(minimum = 2) { mock.method() }',
      'verify(atLeast = 2) { mock.method() }',
      'verify(from = 2) { mock.method() }',
      'verify(min = 2) { mock.method() }',
    ],
    correctAnswer: 1,
    explanation: 'verify(atLeast = n) { } checks that the method was called at least n times. You can also use atMost for upper bounds, and combine both: verify(atLeast = 2, atMost = 5) { }.',
    tags: ['mockk', 'verify', 'cardinality'],
  },
  {
    id: 'kotlin-testing-l2-075',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: 'Kotest',
    question: 'How do you test with eventual consistency in Kotest?',
    codeSnippet: `eventually(5.seconds) {
    service.getStatus() shouldBe "ready"
}`,
    options: [
      'Use CompletableFuture.get()',
      'Use Thread.sleep() before assertions',
      'Use eventually { } which retries assertions until they pass or timeout',
      'Use awaitility library only',
    ],
    correctAnswer: 2,
    explanation: 'eventually { } in Kotest repeatedly evaluates the assertion block until it passes or the timeout expires. This is perfect for testing asynchronous operations or eventual consistency scenarios.',
    tags: ['kotest', 'eventually', 'async'],
  },
  {
    id: 'kotlin-testing-l2-076',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: 'Kotest',
    question: 'What does continually do in Kotest?',
    codeSnippet: `continually(5.seconds) {
    service.getStatus() shouldBe "stable"
}`,
    options: [
      'Asserts that the condition remains true for the entire duration',
      'Runs the block once and waits',
      'Repeats the test continuously forever',
      'Schedules the test for repeated execution',
    ],
    correctAnswer: 0,
    explanation: 'continually is the inverse of eventually. It asserts that a condition holds true consistently for the entire specified duration. If the assertion fails at any point, the test fails.',
    tags: ['kotest', 'continually', 'async'],
  },
  {
    id: 'kotlin-testing-l2-077',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: 'MockK',
    question: 'How do you mock a function with default parameters in MockK?',
    codeSnippet: `interface Service {
    fun query(page: Int = 1, size: Int = 10): List<Item>
}`,
    options: [
      'Use @DefaultParams annotation',
      'Default parameters cannot be mocked',
      'MockK handles default parameters transparently - just mock as usual',
      'You must specify all parameters explicitly',
    ],
    correctAnswer: 2,
    explanation: 'MockK handles Kotlin default parameters natively. You can stub the method with specific values or any() matchers. When the caller uses default values, MockK matches them correctly.',
    tags: ['mockk', 'default-parameters', 'kotlin'],
  },
  {
    id: 'kotlin-testing-l2-078',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: 'Coroutine Testing',
    question: 'How do you test a coroutine with a timeout?',
    codeSnippet: `@Test
fun testWithTimeout() = runTest {
    val result = withTimeout(1000) {
        fetchData()
    }
    assertEquals("data", result)
}`,
    options: [
      'withTimeout in runTest uses virtual time, so it completes instantly',
      'withTimeout is replaced by a mock in tests',
      'withTimeout cannot be used in runTest',
      'withTimeout always waits real time in tests',
    ],
    correctAnswer: 0,
    explanation: 'Inside runTest, withTimeout uses the virtual time clock. If the coroutine inside withTimeout uses only delay-based timing, it completes instantly. The timeout is evaluated against virtual time.',
    tags: ['coroutines', 'timeout', 'virtual-time'],
  },
  {
    id: 'kotlin-testing-l2-079',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: 'Kotest',
    question: 'How do you test for expected exceptions with a specific message in Kotest?',
    codeSnippet: `val ex = shouldThrow<IllegalArgumentException> {
    validate(-1)
}
ex.message shouldBe "Value must be positive"`,
    options: [
      'Neither approach works in Kotest',
      'Use shouldThrowWithMessage<ExceptionType>("message") { }',
      'Both A and B are valid approaches',
      'Use shouldThrow and then check the message separately',
    ],
    correctAnswer: 2,
    explanation: 'Both approaches work. shouldThrow<T> { } returns the exception for further assertions. shouldThrowWithMessage combines both checks. shouldThrowExactly can be used to disallow subclass matches.',
    tags: ['kotest', 'exceptions', 'matchers'],
  },
  {
    id: 'kotlin-testing-l2-080',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: 'MockK',
    question: 'How do you use MockK with coroutine Flows?',
    codeSnippet: `interface DataSource {
    fun getItems(): Flow<Item>
}
val source = mockk<DataSource>()
every { source.getItems() } returns flowOf(item1, item2)`,
    options: [
      'Flows cannot be mocked with MockK',
      'Use every with flowOf() since getItems() is not a suspend function',
      'Use mockFlow<Item>() to create a mock Flow',
      'Use coEvery for all Flow methods',
    ],
    correctAnswer: 1,
    explanation: 'A function returning Flow is not a suspend function itself (even though collecting the Flow requires a coroutine). So you use regular every { } and return a Flow created with flowOf() or flow { }.',
    tags: ['mockk', 'flow', 'coroutines'],
  },
  {
    id: 'kotlin-testing-l2-081',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: 'Kotest',
    question: 'What does shouldBeCloseTo check in Kotest?',
    codeSnippet: `3.14159.shouldBeCloseTo(3.14, 2)`,
    options: [
      'That two numbers are within an absolute delta',
      'That a double matches to the specified number of decimal places',
      'That two values are of the same type',
      'That a number rounds to the given value',
    ],
    correctAnswer: 1,
    explanation: 'shouldBeCloseTo compares doubles with a given number of decimal places of precision. The second parameter specifies how many decimal places should match.',
    tags: ['kotest', 'matchers', 'floating-point'],
  },
  {
    id: 'kotlin-testing-l2-082',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: 'JUnit 5',
    question: 'What is a ParameterResolver extension in JUnit 5?',
    codeSnippet: `class RandomNumberResolver : ParameterResolver {
    override fun supportsParameter(paramCtx: ParameterContext, extCtx: ExtensionContext) =
        paramCtx.parameter.type == Int::class.java

    override fun resolveParameter(paramCtx: ParameterContext, extCtx: ExtensionContext) =
        Random.nextInt()
}`,
    options: [
      'An extension that resolves configuration parameters',
      'An extension that resolves command-line arguments',
      'An extension that resolves generic type parameters',
      'An extension that injects parameters into test methods and lifecycle methods',
    ],
    correctAnswer: 3,
    explanation: 'ParameterResolver is a JUnit 5 extension interface that allows injecting custom parameters into test methods, @BeforeEach, @AfterEach, and other lifecycle methods. It checks if it supports the parameter type and provides the value.',
    tags: ['junit5', 'extensions', 'parameter-resolver'],
  },
  {
    id: 'kotlin-testing-l2-083',
    language: 'kotlin',
    level: 'level2',
    category: 'Testing',
    subcategory: 'Coroutine Testing',
    question: 'What happens with unhandled exceptions in runTest?',
    options: [
      'They cause the test to fail with the uncaught exception',
      'They are collected and reported after the test completes',
      'They are silently ignored',
      'They crash the JVM',
    ],
    correctAnswer: 0,
    explanation: 'runTest installs an exception handler that catches uncaught exceptions from child coroutines. If any child coroutine throws an unhandled exception, runTest rethrows it after completion, causing the test to fail.',
    tags: ['coroutines', 'runTest', 'exceptions'],
  },
];

export default questions;
