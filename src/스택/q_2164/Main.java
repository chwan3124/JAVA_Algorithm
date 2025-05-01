package 스택.q_2164;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for(int i=1; i<=N; i++){
            queue.offer(i);
        }

        while(queue.size() > 1){
            queue.poll();

            Integer recentCard = queue.poll();
            queue.offer(recentCard);
        }

        System.out.println(queue.poll());
    }
}
