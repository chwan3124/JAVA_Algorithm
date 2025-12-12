package baekjoon.우선순위큐.q_11279

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue

class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>){
            // 우선순위 큐 배열 정수 내림차순
            // PriorityQueue는 내부적으로 '완전이진트리(힙)' 구조로 동작함
            // 새로운 값이 들어오면 일단 배열의 마지막(트리의 맨 아래)에 삽입됨
            // 그 후, 부모 노드와 비교(q.peek() 같은 순서가 아님)하며 자리(힙 성질)를 맞출 때까지 bubble-up 수행함
            // Comparator { a, b -> b - a } 는 두 값을 비교할 때:
            //   - b > a 이면 양수 → b가 더 우선순위가 높다고 판단
            //   즉, 큰 숫자가 부모 쪽(위쪽)에 올라가는 '내림차순(Max-Heap)' 동작을 하게 됨
            val pq = PriorityQueue<Int>() {a, b -> b - a}
            // 연산 개수 입력
            val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
            val n = bufferedReader.readLine().toInt()

            // n 만큼 반복
            repeat(n){
                val input = bufferedReader.readLine().toInt()

                // input이 0이면
                if(input == 0){
                    // pq가 비어있으면 0 출력, 비어있지 않으면 최대값 출력
                    println(if(pq.isEmpty()) 0 else pq.poll())
                } else{
                    // pq 값 삽입
                    pq.add(input)
                }
            }
        }
    }
}