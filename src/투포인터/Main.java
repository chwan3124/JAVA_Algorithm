package 투포인터;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int startIdx = 1;
        int endIdx = 1;
        int sum = 1;
        int cnt = 1;

        while(endIdx != n){
            if(sum == n){
                cnt++;
                endIdx++;
                sum += endIdx;
            }else if(sum > n){
                sum -= startIdx;
                startIdx++;
            }else {
                endIdx++;
                sum += endIdx;
            }
        }

        System.out.println(cnt);
    }
}
