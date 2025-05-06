package baekjoon.dfs.q_2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int[] moveX = {-1, 1, 0, 0};
    static int[] moveY = {0, 0, -1, 1};

    static HashMap<Integer, Integer> estateMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int len = Integer.parseInt(st.nextToken());
        estateMap = new HashMap<Integer, Integer>();
        map = new int[len][len];
        visited = new boolean[len][len];

        for(int i=0; i<len; i++){
            st = new StringTokenizer(br.readLine());
            String tokenStr = st.nextToken();
            for(int j=0; j<len; j++){
                map[i][j] = Integer.parseInt(tokenStr.substring(j, j+1));
            }
        }

        int estateId = 0;

        for(int i=0; i<len; i++){
            for(int j=0; j<len; j++){
                if(!visited[i][j] && map[i][j] == 1){
                    estateId++;
                    estateMap.put(estateId, 1);
                    dfs(estateId, i, j);
                }
            }
        }

        List<Integer> keySet = new ArrayList<>(estateMap.keySet());
        keySet.sort(Comparator.comparing(o -> estateMap.get(o)));

        for(int key: keySet){
            System.out.println(estateMap.get(key));
        }
    }

    private static void dfs(int estateId, int posY, int posX){
        if(visited[posY][posX]) return;

        visited[posY][posX] = true;
        for(int i=0; i<4; i++){
            int targetY = posY + moveY[i];
            int targetX = posX + moveX[i];
            if(targetY < 0 || targetY >= map.length || targetX < 0 || targetX >= map.length) continue;

            if(map[targetY][targetX] == 1 && !visited[targetY][targetX]){
                estateMap.put(estateId, estateMap.getOrDefault(estateId, 0) + 1);
                dfs(estateId, targetY, targetX);
            }
        }
    }
}