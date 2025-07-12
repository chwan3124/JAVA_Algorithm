package baekjoon.그리디.q_2012;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] expectedRanks = new int[N];
        for(int i=0; i<N; i++){
            expectedRanks[i] = sc.nextInt();
        }

        Arrays.sort(expectedRanks);
        long totalDiscontent = 0;
        int rankCnt = 1;

        for(int expectedRank : expectedRanks){
            totalDiscontent += Math.abs(rankCnt - expectedRank);
            rankCnt++;
        }

        System.out.println(totalDiscontent);
    }
}
