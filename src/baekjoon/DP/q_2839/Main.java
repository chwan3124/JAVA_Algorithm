package baekjoon.DP.q_2839;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        if(N == 3 || N == 5) {
            System.out.println(1);
            return;
        }
        if(N <= 4) {
            System.out.println(-1);
            return;
        }

        int[] dp = new int[N+1];

        dp[3] = 1;
        dp[5] = 1;

        for(int i=6; i<=N; i++){
            if (dp[i-3] == 0 && dp[i-5] == 0) continue;

            if (dp[i - 3] == 0) {
                dp[i] = dp[i - 5] + 1;
            } else if (dp[i - 5] == 0) {
                dp[i] = dp[i - 3] + 1;
            } else {
                dp[i] = Math.min(dp[i - 3], dp[i - 5]) + 1;
            }
        }

        System.out.println(dp[N] > 0 ? dp[N] : -1);
    }
}
