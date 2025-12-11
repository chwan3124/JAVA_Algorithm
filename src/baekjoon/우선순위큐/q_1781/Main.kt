package baekjoon.우선순위큐.q_1781

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

data class Problem(val d: Int, val ramen: Int)

/*
    각 데드라인까지 그 시간 안에 해결할 수 있는 문제들 중,
    라면을 최대로 받을 수 있도록 문제를 골라서 푸는 것
 */
class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val br= BufferedReader(InputStreamReader(System.`in`))
            val n = br.readLine().toInt()
            val problems: MutableList<Problem> = mutableListOf()
            val pq = PriorityQueue<Int>()

            /*for(i in 0..n-1) {
                val item = br.readLine().split(" ").map{ it.toInt() }
                problems.add(Problem(item[0], item[1]))
            }*/

            repeat(n) {
                val (d, ramen) = br.readLine().split(" ").map { it.toInt() }
                problems.add(Problem(d, ramen))
            }

            val sorted = problems.sortedBy { it.d }

            sorted.forEach { problem ->
                pq.add(problem.ramen)

                //현재까지 선택한 문제 개수가
                //이 문제의 데드라인까지 가능한 최대 개수를 넘었는가?
                if(pq.size > problem.d) {
                    pq.poll()
                }
            }

            println(pq.sum())
        }
    }
}