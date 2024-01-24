package org.shev4ik.coding.linkedlist

import scala.annotation.tailrec

object FindLastButOneElement extends App {

  //Some(lastButOne(1 :: 1 :: 2 :: 3 :: 5 :: 8 :: Nil)) foreach println

  def lastButOne(list: List[Int]): Int = {
    def inner(list: List[Int]): Int = {
      list match {
        case prev :: _ :: Nil ⇒ prev
        case _ :: tail        ⇒ inner(tail)
      }
    }
    inner(list)
  }

  def lastButOneIter(list: List[Int]): Int = {
    val length = list.length
    var counter = 0
    for (elem <- list){
      if (counter == length -2){
        return elem
      }
      counter+=1
    }
    -1
  }


  def lastButOneRecursive(list: List[Int]): Int = {
    @tailrec
    def inner(list: List[Int]): Int = {
      list match {
        case head::elem::Nil => head
        case h::t => inner(t)
      }
    }
    if (list.length >= 2) inner(list) else -1
  }


  println(lastButOneIter(1::2::3::Nil))
  println(lastButOneRecursive(3::Nil))

}
