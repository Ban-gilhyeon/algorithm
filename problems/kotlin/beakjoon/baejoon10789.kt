package problems.kotlin.beakjoon

fun main() {
    var arr = Array(5,{CharArray(15,{' '})})
    var input =""
    var result = ""

    for(i in 0 until 5){
        input = readLine().toString()
        arr[i] = input.toCharArray()
    }

    for(i in 0 until 15){
        for(j in 0 until 5){
            if(arr[j].getOrNull(i) == null){
                continue
            }
            result += arr[j][i]
        }
    }
    print(result)
}