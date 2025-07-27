package baekjoon.DP.q_1904;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        if(N == 1){
            System.out.println(1);
            return;
        }

        if(N == 2){
            System.out.println(2);
            return;
        }

        int a = 1;
        int b = 2;
        int result = 0;

        for (int i = 3; i <= N; i++) {
            result = (a + b) % 15746;
            a = b;
            b = result;
        }

        System.out.println(result);
    }
}
