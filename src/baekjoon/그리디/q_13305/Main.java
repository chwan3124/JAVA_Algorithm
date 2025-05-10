package baekjoon.그리디.q_13305;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long[] distance = new long[N-1];
        int[] city = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N-1; i++){
            distance[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            city[i] = Integer.parseInt(st.nextToken());
        }

        int min_price = city[0];
        long total_price = 0;
        for(int i=0; i<N-1; i++){
            if (city[i] < min_price) {
                min_price = city[i];
            }
            total_price += min_price * distance[i];
        }

        System.out.println(total_price);
    }
}