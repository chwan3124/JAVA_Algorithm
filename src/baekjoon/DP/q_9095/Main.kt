package baekjoon.DP.q_9095

import java.io.BufferedReader
import java.io.InputStreamReader

class Main {
    companion object{
        @JvmStatic
        fun main(args: Array<String>){
            val br = BufferedReader(InputStreamReader(System.`in`))
            val t = br.readLine().toInt()

            val n = IntArray(t)
            for(i in  0 until t){
                n[i] = br.readLine().toInt()
            }

            val dp = IntArray(11)
            dp[1] = 1
            dp[2] = 2
            dp[3] = 4

            for(i in 4..10){
                dp[i] = dp[i-3] + dp[i-2] + dp[i-1]
            }

            for(num in n){
                println(dp[num])
            }
        }
    }
}