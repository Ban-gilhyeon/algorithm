package problems.java.beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BeakJun1987_알파벳 {
    static int result = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        int R;
        int C;
        int cnt = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        char[][] map = new char[R][C];
        boolean[][] visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            map[i] = st.nextToken().toCharArray();
        }
        for(int i = 0; i < R; i++){
            Arrays.fill(visited[i],false);
        }
        dfs(0,0,map,visited,"");
        System.out.println(result + 1);
    }
    private static void printMap(boolean[][] map){
        for(int i = 0; i < map.length; i++){
            System.out.println();
            for(int j = 0; j < map[i].length; j++){
                System.out.print(map[i][j] + " ");
            }
        }
    }

    private static void dfs(int y, int x, char[][] map, boolean[][] visited, String visitedWord){
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        if(visited[y][x] == true) return;
        if(visitedWord.contains(String.valueOf(map[y][x]))) return;
        result = Math.max(result, visitedWord.length());
        visited[y][x] = true;
        visitedWord = visitedWord+map[y][x];

        for(int i = 0 ; i < 4; i++){
            int nx  = x + dx[i];
            int ny = y + dy[i];
            if(ny >= 0 && nx >= 0 && ny < map.length && nx < map[0].length){
                dfs(ny, nx, map, visited, visitedWord);
            }
        }
        visited[y][x] = false;
    }
}
