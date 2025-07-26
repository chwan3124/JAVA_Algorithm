package baekjoon.DP.q_2579;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] stairs = new int[N];
        int[] dp = new int[N];

        for(int i=0; i<N; i++){
            stairs[i] = sc.nextInt();
        }

        if (N == 1) {
            System.out.println(stairs[0]);
            return;
        }

        if (N == 2) {
            System.out.println(stairs[0] + stairs[1]);
            return;
        }

        dp[0] = stairs[0];
        dp[1] = stairs[0] + stairs[1];
        dp[2] = Math.max(stairs[0] + stairs[2], stairs[1] + stairs[2]);

        for(int i=3; i<N; i++){
            dp[i] = Math.max(
                    dp[i-2] + stairs[i],
                    dp[i-3] + stairs[i-1] + stairs[i]
            );
        }

        System.out.println(dp[N-1]);
    }
}
