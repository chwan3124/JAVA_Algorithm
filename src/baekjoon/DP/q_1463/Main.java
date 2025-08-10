package baekjoon.DP.q_1463;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] dp = new int[N+1];
        if(N == 1) {
            System.out.println(0);
            return;
        }else if(N >= 2 && N <= 3){
            System.out.println(1);
            return;
        }

        dp[2] = 1;
        dp[3] = 1;

        for(int i=4; i<=N; i++){
            dp[i] = Math.min(i % 3 == 0 ? dp[i / 3] + 1 : Integer.MAX_VALUE,  Math.min(dp[i-1] + 1, i % 2 == 0 ? dp[i / 2] + 1 : Integer.MAX_VALUE));
        }

        System.out.println(dp[N]);
    }
}

/*
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] dp = new int[N + 1];
        dp[1] = 0; // 1은 연산 필요 없음

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1; // 기본: 1 빼기 연산

            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }

        System.out.println(dp[N]);
    }
}
 */
