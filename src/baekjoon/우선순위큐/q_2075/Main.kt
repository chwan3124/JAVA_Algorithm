package baekjoon.우선순위큐.q_2075

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue

class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val pq = PriorityQueue<Long>()
            val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
            val n = bufferedReader.readLine().toInt()

            repeat(n){
                val nums = bufferedReader.readLine().split(" ").map { it.toLong() }
                for(num in nums){
                    pq.add(num)
                    if(pq.size > n){
                        pq.poll()
                    }
                }
            }

            println(pq.toArray()[0])
        }
    }
}