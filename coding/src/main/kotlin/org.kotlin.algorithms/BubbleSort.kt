package org.kotlin.algorithms

import java.time.LocalDate

fun main(args: Array<String>){
    val array = arrayOf(* 1.rangeTo(100000).toList().toTypedArray())
    val size = array.size
    val startTime = LocalDate.now()
    var countSwaps = 0
    var countCycles = 0
    var isSwapped = false
    for(i in array.indices){
        for (j in (1 until size-i)){
            if (array[j-1] > array[j]){
                val temp = array[j-1]
                array[j-1] = array[j]
                array[j] = temp
                isSwapped = true
                countSwaps++
            }
        }
        countCycles++
        //if (!isSwapped) break
    }

    array.forEach { e ->  println(e) }

    val endTime = LocalDate.now()

    println("Execution time is " + (endTime.toEpochDay().minus(startTime.toEpochDay())))
    println("Swaps $countSwaps")
    println("Cycles $countCycles")


}
