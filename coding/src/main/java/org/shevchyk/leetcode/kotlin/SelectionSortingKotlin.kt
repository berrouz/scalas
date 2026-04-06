
fun main(args: Array<String>) {
    var arr = intArrayOf(5, 2, 1, 4, 3)
    var times = 0
    for (i in arr.indices) {
        for (j in arr.indices) {

            if (arr[i] < arr[j]) {
                val temp = arr[j]
                arr[j] = arr[i]
                arr[i] = temp
            }
            times++
        }
    }
    println("Count is $times")
    println(arr.contentToString())
}


