package 정렬.q_11399;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int swapIdx = 0;
        for(int idx=1; idx<N; idx++){
            swapIdx = 0;
            for(int j=idx - 1; j>=0; j--){
                if(arr[idx] < arr[j]){
                    swapIdx = j;
                }else{
                    break;
                }
            }

            if(arr[idx] < arr[swapIdx]){
                int targetNum = arr[idx];

                for(int k=idx - 1; k>=swapIdx; k--){
                    arr[k + 1] = arr[k];
                }

                arr[swapIdx] = targetNum;
            }
        }

        int prefixSum = 0;
        int[] prefixSumArr = new int[N];
        for(int i=0; i<N; i++){
            prefixSum += arr[i];
            prefixSumArr[i] += prefixSum;
        }

        System.out.println(Arrays.stream(prefixSumArr).sum());
    }
}
