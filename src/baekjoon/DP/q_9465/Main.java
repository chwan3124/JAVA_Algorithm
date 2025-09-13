package baekjoon.DP.q_9465;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());  // 테스트 케이스 개수

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());  // 열 개수
            int[][] arr = new int[2][n];

            // 위쪽 줄
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[0][i] = Integer.parseInt(st.nextToken());
            }

            // 아래쪽 줄
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[1][i] = Integer.parseInt(st.nextToken());
            }

            sb.append(solve(arr, n)).append("\n");
        }

        System.out.print(sb);
    }

    private static int solve(int[][] arr, int n) {
        int[][] dp = new int[3][n];

        dp[0][0] = arr[0][0]; // 첫 열 위
        dp[1][0] = arr[1][0]; // 첫 열 아래
        dp[2][0] = 0;         // 첫 열 안 뗌

        for (int i = 1; i < n; i++) {
            dp[0][i] = Math.max(dp[1][i-1], dp[2][i-1]) + arr[0][i];
            dp[1][i] = Math.max(dp[0][i-1], dp[2][i-1]) + arr[1][i];
            dp[2][i] = Math.max(Math.max(dp[0][i-1], dp[1][i-1]), dp[2][i-1]);
        }

        return Math.max(Math.max(dp[0][n-1], dp[1][n-1]), dp[2][n-1]);
    }
}