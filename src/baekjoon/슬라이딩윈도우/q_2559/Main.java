package baekjoon.슬라이딩윈도우.q_2559;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bf.readLine());

        int totalDay = Integer.parseInt(stringTokenizer.nextToken());
        int part = Integer.parseInt(stringTokenizer.nextToken());

        int[] days = new int[totalDay];

        stringTokenizer = new StringTokenizer(bf.readLine());
        for(int i=0; i<totalDay; i++){
            days[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int maxValue = 0;
        for(int i=0; i<part; i++){
            maxValue += days[i];
        }

        int temp = maxValue;
        for(int i=part, j=0; i<totalDay; i++, j++){
            temp+=(days[j] * -1);
            temp+=days[i];

            maxValue = Math.max(maxValue, temp);
        }

        System.out.println(maxValue);
    }
}
