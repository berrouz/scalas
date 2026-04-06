package org.shev4ik.interview.scala_core.level3_advanced

object Core075_Reflection {

  import scala.reflect.runtime.universe._
  import scala.reflect.runtime.{universe => ru}

  case class Person(name: String, age: Int) {
    def greet(): String = s"Hello, I'm $name"
    def add(a: Int, b: Int): Int = a + b
  }

  // Exercise 1: Runtime reflection - get type members
  // TODO: Write a method that returns the list of method names of a given type T
  def methodNames[T: TypeTag]: List[String] = ???

  // Exercise 2: Mirror
  // TODO: Write a method that creates an instance mirror for a given object
  //       and returns the runtime mirror and instance mirror
  def createInstanceMirror(obj: Any): ru.InstanceMirror = ???

  // Exercise 3: MethodMirror
  // TODO: Write a method that invokes a no-arg method by name on an object using reflection
  //       For example, invoking "greet" on a Person instance
  def invokeNoArgMethod(obj: Any, methodName: String): Any = ???

  // Exercise 4: FieldMirror
  // TODO: Write a method that reads a field value by name from an object using reflection
  def readField(obj: Any, fieldName: String): Any = ???

  // Exercise 5: Type member access
  // TODO: Write a method that returns all val/var member names (not methods) of type T
  def fieldNames[T: TypeTag]: List[String] = ???

  // Exercise 6: Method invocation with args
  // TODO: Write a method that invokes a method with arguments using reflection
  //       Takes an object, method name, and list of arguments
  def invokeMethod(obj: Any, methodName: String, args: Any*): Any = ???

  // Exercise 7: Runtime class info
  // TODO: Write a method that returns the class name, number of fields, and number of methods
  //       for a given object using reflection
  def classInfo(obj: Any): (String, Int, Int) = ???

  // Exercise 8: Reflection performance
  // TODO: Write a method that caches the method mirror for repeated invocations.
  //       Return a function that can be called multiple times efficiently.
  def cachedInvoker(obj: Any, methodName: String): () => Any = ???

  def main(args: Array[String]): Unit = {
    val alice = Person("Alice", 30)

    // Exercise 1
    val methods = methodNames[Person]
    assert(methods.contains("greet"))
    assert(methods.contains("add"))

    // Exercise 2
    val im = createInstanceMirror(alice)
    assert(im != null)

    // Exercise 3
    val greeting = invokeNoArgMethod(alice, "greet")
    assert(greeting == "Hello, I'm Alice")

    // Exercise 4
    val name = readField(alice, "name")
    assert(name == "Alice")
    val age = readField(alice, "age")
    assert(age == 30)

    // Exercise 5
    val fields = fieldNames[Person]
    assert(fields.contains("name"))
    assert(fields.contains("age"))

    // Exercise 6
    val sum = invokeMethod(alice, "add", 3, 4)
    assert(sum == 7)

    // Exercise 7
    val (className, numFields, numMethods) = classInfo(alice)
    assert(className.contains("Person"))
    assert(numFields >= 2)

    // Exercise 8
    val cachedGreet = cachedInvoker(alice, "greet")
    assert(cachedGreet() == "Hello, I'm Alice")
    assert(cachedGreet() == "Hello, I'm Alice")

    println("All Core075_Reflection exercises passed!")
  }
}
