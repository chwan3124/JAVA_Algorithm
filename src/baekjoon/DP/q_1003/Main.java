package baekjoon.DP.q_1003;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] T = new int[N];

        for(int i=0; i<N; i++){
            T[i] = sc.nextInt();
        }

        int[] dp1 = new int[41];
        int[] dp2 = new int[41];

        dp1[0] = 1;
        dp2[0] = 0;

        dp1[1] = 0;
        dp2[1] = 1;

        dp1[2] = 1;
        dp2[2] = 1;

        for(int i=3; i<=40; i++){
            dp1[i] = dp1[i-1] + dp1[i-2];
            dp2[i] = dp2[i-1] + dp2[i-2];
        }

        for(int i : T){
            System.out.println(dp1[i] + " " + dp2[i]);
        }
    }
}
