package problems.java.programmers;

import java.util.Arrays;

public class Solution_삼각달팽이 {
    static private int cnt = 1;
    private  static int[] solution(int n){
        int [] answer = {};

        int[][] map = new int[n][];
        for(int i = n; i > 0; i--){
            map[i] = new int[n];
        }
        for(int i = 0; i <= n; i++){
            map[i][0]++;
        }

        for(int i = 0; i <= n; i++){
            for(int j = 0; j < map[i].length; j++){
                System.out.println(map[i][j]);
            }
        }
        return answer;
    }
    private static void fillArray(int x, int y, int[][] map, boolean[][] visited, int limit, int n){
        if(limit < cnt) return;
        if(x < 0 || y < 0 || y >= n || x > map[y].length -1) return;
        if(visited[y][x]) return;

        map[y][x] = cnt++;
        visited[y][x] = true;

        int[] dy = {1,0,-1};
        int[] dx = {0, 1, -1};

    }
    public static void main(String[] args) {
        int n = 4;
        int[][] map = new int[n][];
        boolean[][] visited = new boolean[n][];
        int cnt = 1;
        int cal = 1;
        int limit = 0;
        for(int i = 0 ; i < n; i++){
            map[i] = new int[cal];
            Arrays.fill(map[i], 0);
            limit += cal;
            cal++;
        }
        int x = 0;
        int y = 0;
        int dir = 0;
        while(limit >= cnt){
            map[y][x] = cnt++;

            int[] dy = {1, 0, -1};
            int[] dx = {0, 1, -1};
            int ny = y + dy[dir];
            int nx = x + dx[dir];
            if( nx < 0 || ny < 0 || ny >= n || nx >= map[y].length || map[ny][nx] != 0){
                dir = (dir + 1) % 3;
                ny = y + dy[dir];
                nx = x + dx[dir];
            }
            x = nx;
            y = ny;
        }

        for(int i = 0; i < n; i++){
            System.out.println("");
            for(int j = 0; j < map[i].length; j++){
                System.out.print(map[i][j] +", ");
            }
        }

    }
}
