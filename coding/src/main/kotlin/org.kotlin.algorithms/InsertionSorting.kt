package org.kotlin.algorithms

fun main(args: Array<String>){
    val arr = arrayOf(2,1,3,5,4)
    for(i in 1.until(arr.size)) {
        val elem = arr[i]
        var index = i - 1
        while(index >= 0 && elem < arr[index]){
            arr[index+1] = arr[index]
            index--
        }
        arr[index + 1] = elem
    }
    arr.forEach { i -> println(i) }
    doWorld()

}


suspend fun doWorld() = coroutineScope {
    launch {
        delay(1000L)
        println("World")
    }
    println("Hello")
}