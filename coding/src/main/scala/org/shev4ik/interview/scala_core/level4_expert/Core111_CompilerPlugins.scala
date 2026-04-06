package org.shev4ik.interview.scala_core.level4_expert

object Core111_CompilerPlugins {

  // NOTE: Actual compiler plugins require implementing nsc.plugins.Plugin.
  // This file demonstrates the concepts by simulating plugin behavior.

  // Exercise 1: Compiler phase concept
  // TODO: Define a simplified model of compiler phases
  sealed trait CompilerPhase {
    def name: String
    def runsAfter: List[String]
  }

  case class CustomPhase(name: String, runsAfter: List[String], transform: String => String) extends CompilerPhase

  // TODO: Implement a pipeline that runs phases in order
  def runPipeline(input: String, phases: List[CustomPhase]): String = ???

  // Exercise 2: Plugin component concept
  // TODO: Simulate a plugin component that transforms code
  trait PluginComponent {
    def phaseName: String
    def transform(code: String): String
  }

  // TODO: Create a plugin that adds logging to all method definitions
  val loggingPlugin: PluginComponent = ???

  // Exercise 3: Tree transformation concept
  // TODO: Simulate AST tree transformation
  sealed trait SimpleTree
  case class SMethod(name: String, body: List[SimpleTree]) extends SimpleTree
  case class SPrint(message: String) extends SimpleTree
  case class SReturn(value: String) extends SimpleTree

  // TODO: Write a tree transformer that inserts logging
  def addLogging(tree: SimpleTree): SimpleTree = ???

  // Exercise 4: Annotation processing concept
  // TODO: Simulate annotation-driven code generation
  case class AnnotatedField(name: String, tpe: String, annotations: List[String])

  // TODO: Process annotations to generate validation code
  def processAnnotations(fields: List[AnnotatedField]): Map[String, String] = ???

  // Exercise 5: Plugin registration concept
  // TODO: Create a plugin registry system
  class PluginRegistry {
    private var plugins: List[PluginComponent] = Nil

    def register(plugin: PluginComponent): Unit = ???
    def getPlugins: List[PluginComponent] = ???
    def transformAll(code: String): String = ???
  }

  // Exercise 6: Custom phase ordering
  // TODO: Implement topological sort for phase ordering
  def orderPhases(phases: List[CustomPhase]): List[CustomPhase] = ???

  // Exercise 7: Plugin testing concept
  // TODO: Show how to test a plugin transformation
  def testPlugin(plugin: PluginComponent, input: String, expected: String): Boolean = ???

  // Exercise 8: Plugin deployment concept
  // TODO: Define a plugin descriptor
  case class PluginDescriptor(
    name: String,
    description: String,
    components: List[String],
    version: String
  ) {
    def toDescriptorString: String = ???
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val phases = List(
      CustomPhase("phase1", Nil, s => s"[$s]"),
      CustomPhase("phase2", List("phase1"), s => s.toUpperCase)
    )
    assert(runPipeline("hello", phases) == "[HELLO]" || runPipeline("hello", phases) == "[hello]".toUpperCase)

    // Exercise 2
    val result = loggingPlugin.transform("def foo(): Int = 42")
    assert(result.contains("log") || result.contains("LOG"))

    // Exercise 3
    val method = SMethod("foo", List(SReturn("42")))
    val logged = addLogging(method)
    assert(logged.isInstanceOf[SMethod])

    // Exercise 4
    val fields = List(
      AnnotatedField("name", "String", List("@NonEmpty")),
      AnnotatedField("age", "Int", List("@Positive"))
    )
    val validations = processAnnotations(fields)
    assert(validations.contains("name"))
    assert(validations("name").contains("NonEmpty") || validations("name").contains("empty"))

    // Exercise 5
    val registry = new PluginRegistry
    registry.register(loggingPlugin)
    assert(registry.getPlugins.length == 1)

    // Exercise 6
    val unordered = List(
      CustomPhase("c", List("b"), identity),
      CustomPhase("a", Nil, identity),
      CustomPhase("b", List("a"), identity)
    )
    val ordered = orderPhases(unordered)
    assert(ordered.map(_.name) == List("a", "b", "c"))

    // Exercise 7
    assert(testPlugin(loggingPlugin, "def foo(): Int = 42", loggingPlugin.transform("def foo(): Int = 42")))

    // Exercise 8
    val desc = PluginDescriptor("my-plugin", "A test plugin", List("phase1"), "1.0.0")
    assert(desc.toDescriptorString.contains("my-plugin"))

    println("All Core111_CompilerPlugins exercises passed!")
  }
}
