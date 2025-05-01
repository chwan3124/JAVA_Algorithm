package 이진탐색.q_1920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numLen = Integer.parseInt(st.nextToken());

        int[] nums = new int[numLen];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<numLen; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        st = new StringTokenizer(br.readLine());
        int searchCnt = Integer.parseInt(st.nextToken());

        int[] searchNums = new int[searchCnt];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<searchCnt; i++){
            searchNums[i] = Integer.parseInt(st.nextToken());
        }

        for(int searchNum: searchNums){
            int start = 0;
            int end = nums.length - 1;
            int mid = 0;
            while(start <= end){
                mid = (start + end) / 2;

                if(nums[mid] > searchNum){
                    end = mid - 1;
                }else if (nums[mid] < searchNum){
                    start = mid + 1;
                }else{
                    break;
                }
            }

            System.out.println(nums[mid] == searchNum ? 1 : 0);
        }
    }
}
