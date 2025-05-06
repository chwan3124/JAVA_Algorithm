package baekjoon.그리디.q_11047;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int[] tokens = new int[N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(bufferedReader.readLine());
            tokens[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;

        for(int i=N-1; i>=0; i--){
            if(target == 0) break;

            if(tokens[i] <= target){
                cnt += target / tokens[i];
                target = target % tokens[i];
            }
        }

        System.out.println(cnt);
    }
}
