package dfs.q_11724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());

        visited = new boolean[node + 1];
        A = new ArrayList[node+1];
        for(int i=1; i<node+1; i++){
            A[i] = new ArrayList<>();
        }

        for(int i=0; i<edge; i++){
            st = new StringTokenizer(br.readLine());
            int startEdge = Integer.parseInt(st.nextToken());
            int endEdge = Integer.parseInt(st.nextToken());
            A[startEdge].add(endEdge);
            A[endEdge].add(startEdge);
        }

        int count = 0;
        for(int i=1; i<node+1; i++){
            if(!visited[i]){
                count++;
                depthFirstSearch(i);
            }
        }
        System.out.println(count);
    }

    private static void depthFirstSearch(int v) {
        if(visited[v]) {
            return;
        }

        visited[v] = true;
        for(int i : A[v]){
            if(!visited[i]){
                depthFirstSearch(i);
            }
        }
    }
}
