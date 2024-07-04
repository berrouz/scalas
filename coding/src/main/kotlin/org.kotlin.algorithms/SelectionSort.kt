package org.kotlin.algorithms

fun main(){

    val arr = arrayOf(3,5,2,1,6,7,4)

    for(i in arr.indices){
        var minIndex = i
        for(j in (i+1).until(arr.size)){
            if (arr[j] < arr[minIndex]) {
                minIndex = j
            }
        }
        val temp = arr[i]
        arr[i] = arr[minIndex]
        arr[minIndex] = temp
    }


    for(index in arr.indices){
        println(arr[index])
    }


}