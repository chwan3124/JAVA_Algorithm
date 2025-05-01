package 그리디.q_1541;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();

        String[] expNums = exp.split("-");

        int sum = 0;
        for(int i=0; i<expNums.length; i++){
            int plusSum = getSum(expNums[i]);
            if(i==0){
                sum += plusSum;
            }else{
                sum -= plusSum;
            }
        }

        System.out.println(sum);
    }

    public static int getSum(String expStr){
        int[] nums = Arrays.stream(expStr.split("\\+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int sum = 0;

        for(int i : nums){
            sum+=i;
        }

        return sum;
    }
}
