package baekjoon.투포인터.q_1940;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int resourceCnt = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int targetNum = Integer.parseInt(st.nextToken());


        int[] resourceArr = new int[resourceCnt];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<resourceCnt; i++){
            resourceArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(resourceArr);

        int startIdx = 0;
        int endIdx = resourceCnt - 1;
        int cnt = 0;

        while(startIdx < endIdx){
            int calcSum = resourceArr[startIdx] + resourceArr[endIdx];
            if(calcSum == targetNum){
                endIdx--;
                cnt++;
            }else if(calcSum > targetNum){
                endIdx--;
            }else{
                startIdx++;
            }
        }

        System.out.println(cnt);
    }
}