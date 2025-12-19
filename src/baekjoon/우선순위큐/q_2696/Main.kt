package baekjoon.우선순위큐.q_2696

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue
import kotlin.math.ceil

class Main {
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            val br = BufferedReader(InputStreamReader(System.`in`))
            val t = br.readLine().toInt()
            val numArrList = ArrayList<ArrayList<Int>>()

            /* 테스트 케이스 수만큼 수열 입력 받기 */
            repeat(t){
                // 수열의 개수
                val cnt = br.readLine().toInt()
                // 수열 리스트
                val nums = ArrayList<Int>()
                // 하나의 수열 당 10개씩 입력 받기
                repeat((cnt + 9) / 10) {
                    nums.addAll(br.readLine().split(" ")
                        .map { it.toInt() }
                        .take(cnt - nums.size)) // 더 읽어야할 개수
                }
                numArrList.add(nums)
            }

            /*
            * 중앙 값을 구하기 즉시 위해 최대힙, 최소힙 사용.(배열을 통해 저장될때마다 정렬하기엔 성능 이슈가 존재)
            *  */
            // 최대 힙
            val maxHeap = PriorityQueue<Int>(){a, b -> b-a} // 왼쪽 상자(작은 값, 중앙값 포함) 3, 2, 1
            // 최소 힙
            val minHeap = PriorityQueue<Int>() // 오른쪽 상자(큰값) 4, 5
            // 중앙값 저장할 배열
            val mids = ArrayList<Int>()
            for((idx, list) in numArrList.withIndex()){
                // 수열에서 존재하는 홀수번째 숫자 개수
                println((list.size + 1) / 2)

                for (i in list.indices) {
                    // maxHeap은 항상 minHeap보다 같거나 1개 더 많다
                    // maxHeap의 제일 큰 값은 minHeap의 제일 작은 값보다 작거나 같아야 한다.

                    // 왼쪽 상자가 비어있거나 현재 중앙값보다 작거나 같으면 왼쪽에 넣음
                    if(maxHeap.isEmpty() || list[i] <= maxHeap.peek()){
                        maxHeap.add(list[i])
                    } else { // 크면 오른쪽에 넣는다
                        minHeap.add(list[i])
                    }

                    // 왼쪽이 너무 많으면 가장 큰 애를 오른쪽으로 이동
                    // 왼쪽은 중앙값도 가지고 있어도 되기 때문에 오른쪽보다 한개 더 많아도 된다
                    if(maxHeap.size > minHeap.size + 1){
                        minHeap.add(maxHeap.poll())
                    } else if(minHeap.size > maxHeap.size){ // 오른쪽이 너무 많으면 가장 작은 애를 왼쪽으로 이동
                        maxHeap.add(minHeap.poll())
                    }

                    // i는 0부터 시작이므로 2를 나눴을때 나머지가 0이면 홀수번째
                    if(i % 2 == 0) mids.add(maxHeap.peek())
                }

                // 중앙값 전체 순회
                for (i in mids.indices) { 
                    print("${mids[i]} ") 
                    // 10번 출력할 때마다 줄바꿈
                    if ((i + 1) % 10 == 0) println() 
                }

                mids.clear()
                minHeap.clear()
                maxHeap.clear()

                // 마지막 수열이 아니면 줄바꿈
                if(idx != numArrList.lastIndex) println()
            }
        }
    }
}