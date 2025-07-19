package baekjoon.DP.q_12865;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());

        int[] weight = new int[N];
        int[] value = new int[N];

        for(int i=0; i<N; i++){
            stringTokenizer = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(stringTokenizer.nextToken());
            value[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int[] dp = new int[K + 1];

        for (int i = 0; i < N; i++) {
            int w = weight[i];
            int v = value[i];

            for (int j = K; j >= w; j--) {
                dp[j] = Math.max(dp[j], dp[j - w] + v);
            }
        }
        System.out.println(dp[K]);
    }
}
