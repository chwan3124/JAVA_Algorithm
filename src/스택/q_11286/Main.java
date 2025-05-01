package 스택.q_11286;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            int abs1 = Math.abs(o1);
            int abs2 = Math.abs(o2);

            if (abs1 == abs2) {
                return o1 - o2;
            }
            return abs1 - abs2;
        } );
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            int input = sc.nextInt();

            if(input == 0){
                Integer extract = queue.poll();
                sb.append(extract == null ? 0 : extract);
                if(i != (N - 1)){
                    sb.append("\n");
                }
            }else{
                queue.offer(input);
            }
        }
        System.out.println(sb);
    }
}
