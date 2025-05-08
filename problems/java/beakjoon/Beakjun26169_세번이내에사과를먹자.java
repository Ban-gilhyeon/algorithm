package problems.java.beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beakjun26169_세번이내에사과를먹자 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] map = new int[5][5];
        boolean[][] visited = new boolean[5][5];

        for(int i = 0; i < 5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j <5; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int y  = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int result = dfs(x,y, visited, map, 0,0);
        System.out.println(result);
    }

    private static int dfs(int x, int y, boolean[][] visited, int[][] map, int cnt, int apple){
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        if(x < 0 || y < 0 || x > 4 || y > 4) return 0;
        if(visited[y][x]) return 0;

        if(map[y][x] == -1) return 0;

        if(map[y][x] == 1) apple++;
        if(cnt > 3) return 0;
        if(apple >= 2) return 1;

        int temp = map[y][x];
        visited[y][x] = true;
        map[y][x] = -1;
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(dfs(nx, ny, visited, map, cnt + 1, apple) == 1) return 1;
        }
        visited[y][x] = false;
        map[y][x] = temp;
        return 0;
    }


}
