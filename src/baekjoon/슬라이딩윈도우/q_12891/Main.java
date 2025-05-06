package baekjoon.슬라이딩윈도우.q_12891;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] currentCount = new int[4]; // 현재 윈도우 내 문자 개수
    static int[] requiredCount = new int[4]; // 필요한 최소 문자 개수
    static int validCharCount = 0; // 조건을 만족하는 문자 개수

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int S = Integer.parseInt(st.nextToken()); // DNA 문자열 길이
        int P = Integer.parseInt(st.nextToken()); // 부분 문자열 길이
        int result = 0;

        char[] dna = bf.readLine().toCharArray();
        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < 4; i++) {
            requiredCount[i] = Integer.parseInt(st.nextToken());
            if (requiredCount[i] == 0) validCharCount++; // 요구 개수가 0이면 처음부터 만족
        }

        // 초기 윈도우 설정
        for (int i = 0; i < P; i++) {
            add(dna[i]);
        }
        if (validCharCount == 4) result++;

        // 슬라이딩 윈도우 적용
        for (int i = P; i < S; i++) {
            int j = i - P;
            add(dna[i]);
            remove(dna[j]);
            if (validCharCount == 4) result++;
        }

        System.out.println(result);
        bf.close();
    }

    private static void add(char c) {
        int index = getIndex(c);
        currentCount[index]++;
        if (currentCount[index] == requiredCount[index]) {
            validCharCount++;
        }
    }

    private static void remove(char c) {
        int index = getIndex(c);
        if (currentCount[index] == requiredCount[index]) {
            validCharCount--;
        }
        currentCount[index]--;
    }

    private static int getIndex(char c) {
        switch (c) {
            case 'A' :
                return 0;
            case 'C' :
                return 1;
            case 'G' :
                return 2;
            case 'T' :
                return 3;
            default :
                return -1;
        }
    }
}
