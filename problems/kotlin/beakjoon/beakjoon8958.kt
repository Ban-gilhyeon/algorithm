package problems.kotlin.beakjoon

fun main() {
    var n = readLine()!!.toInt()
    var answer = 0
    var result = ""
    var cnt = 0

    for(i in 0 ..< n) {
        result = readLine().toString()
        cnt = 0
        answer = 0
        for(j in 0..<result.length) {
            if(result[j] == 'O'){
                cnt++
                answer += cnt;
            }
            else cnt = 0
        }
        println(answer)
    }
}