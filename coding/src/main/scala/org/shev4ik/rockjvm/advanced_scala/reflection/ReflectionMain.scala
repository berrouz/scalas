package org.shev4ik.rockjvm.advanced_scala.reflection

object ReflectionMain extends App {


  // reflection - inspect and invoke methods at runtime


  case class Person(name: String) {
    def sayMyName(): Unit = println(s"Hi, my name is $name")
  }

  import scala.reflect.runtime.{universe => ru}

  // 1 - Mirror

  val m = ru.runtimeMirror(getClass.getClassLoader)

  // 2 - create a class Object

  val clazz = m.staticClass("org.shev4ik.rockjvm.advanced_scala.reflection.ReflectionMain.Person")

  // 3 - create a reflected mirror

  val cm = m.reflectClass(clazz)

  // 4 - get the constructor
  val constructor = clazz.primaryConstructor.asMethod

  // 5 - reflect the constructor
  val constructorMirror = cm.reflectConstructor(constructor)

  // 6 - invoke the constructor
  val instance = constructorMirror.apply("John")
  println(instance)


  val p = Person("Mary")

  val methodName = "sayMyName"

  val reflected = m.reflect(p)

  val methodSymbol = ru.typeOf[Person].decl(ru.TermName(methodName)).asMethod

  val method = reflected.reflectMethod(methodSymbol)

  method.apply()


}
