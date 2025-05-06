package baekjoon.투포인터.q_3273;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int i = 0;
        int j = arr.length - 1;
        int cnt = 0;
        // for loop condition i >= j
        // x > arr[i] + [arr[j] = i++
        // x < arr[i] + [arr[j] = j--
        // x == arr[i] + [arr[j] = i++
        while(i < j){
            if(x > arr[i] + arr[j]){
                i++;
            }else if(x < arr[i] + arr[j]){
                j--;
            }else{
                cnt++;
                i++;
            }
        }

        System.out.println(cnt);
    }
}
