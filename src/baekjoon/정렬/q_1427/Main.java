package baekjoon.정렬.q_1427;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String numStr = sc.next();
        int len =  numStr.length();

        int[] A = new int[len];
        for(int i=0; i< len; i++){
            A[i] = Integer.parseInt(numStr.substring(i, i+1));
        }

        int max = 0;
        for(int i=0; i<len; i++){
            max = i;

            for(int j=i + 1; j<len; j++){
                if(A[j] > A[max]){
                    max = j;
                }
            }

            if(A[i] < A[max]){
                int temp = A[i];
                A[i] = A[max];
                A[max] = temp;
            }
        }

        for(int n : A){
            System.out.print(n);
        }
    }
}
