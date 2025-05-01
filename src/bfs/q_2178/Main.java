package bfs.q_2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int[] moveX = {-1, 1, 0, 0};
    static int[] moveY = {0, 0, -1, 1};
    static Queue<Position> queue;

    static class Position{
        int y, x, depth;

        public Position(int y, int x, int depth){
            this.y = y;
            this.x = x;
            this.depth = depth;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];
        queue = new LinkedList<>();

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            String tokenStr = st.nextToken();
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(tokenStr.substring(j, j+1));
            }
        }

        queue.offer(new Position(0, 0, 1));
        int minDepth = Integer.MAX_VALUE;

        while(!queue.isEmpty()){
            Position posInfo = queue.poll();
            int y = posInfo.y;
            int x = posInfo.x;
            int depth = posInfo.depth;
            minDepth = depth;

            if(y == (n - 1) && x == (m - 1)) break;

            for(int i=0; i<4; i++){
                int targetY = posInfo.y + moveY[i];
                int targetX = posInfo.x + moveX[i];

                if(targetY < 0 || targetY >= n || targetX < 0 || targetX >= m) continue;

                if(!visited[targetY][targetX] && map[targetY][targetX] == 1){
                    visited[targetY][targetX] = true;
                    queue.offer(new Position(targetY, targetX, depth + 1));
                }
            }
        }

        System.out.println(minDepth);
    }
}