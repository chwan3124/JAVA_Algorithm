package baekjoon.우선순위큐.q_1927

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue

class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val pq = PriorityQueue<Int>()
            val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
            val n = bufferedReader.readLine().toInt()

            repeat(n){
                val input = bufferedReader.readLine().toInt()

                if(input == 0){
                    println(if(pq.isEmpty()) 0 else pq.poll())
                } else{
                    pq.add(input)
                }
            }
        }
    }
}