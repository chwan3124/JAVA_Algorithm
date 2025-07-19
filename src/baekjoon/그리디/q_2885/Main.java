package baekjoon.그리디.q_2885;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt(); // 먹어야하는 초콜릿 개수

        int A = 1; // 구매할 최소 개수의 정사각형인 초콜릿
        for(int D=1; A<=K; D*=2){
            A=D;
            if(A>=K) break;
        }

        int divCnt = 0;
        int tmp = A;
        while(true){
            if(A == K) break;
            tmp = tmp / 2;
            divCnt++;

            if(K % tmp==0) {
                break;
            }
        }

        System.out.print(A + " " + divCnt);
    }
}
