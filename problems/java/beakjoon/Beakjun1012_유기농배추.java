package problems.java.beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Beakjun1012_유기농배추 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        int [][] map;
        boolean [][] visited;

        for(int i = 0; i < testCase; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int cal = Integer.parseInt(st.nextToken());
            int total = Integer.parseInt(st.nextToken());

            map = new int[cal][row];
            visited = new boolean[cal][row];

            map = fillMap(map, cal);
            visited = fillVisited(visited, cal);

            for(int j = 0; j < total; j++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
            }

            //checkMap(map, visited);
            System.out.println(traversal(map, visited));

        }

    }
    private static int traversal(int [][] map, boolean[][] visited){
        int result = 0;
        for(int y = 0; y < map.length; y++){
            for(int x = 0; x < map[0].length; x++){
                if(map[y][x] == 1 && !visited[y][x]){
                    dfs(map, visited, x, y);
                    result++;
                }
            }
        }
        return result;
    }

    private static void dfs(int [][] map, boolean[][] visited,int x, int y){
        int [] dx = {-1, 1, 0, 0};
        int [] dy = {0, 0, -1, 1};

        if(x < 0 || y < 0 || x >= map[0].length || y >= map.length) return;
        if(map[y][x] == 0 || visited[y][x]) return;

        visited[y][x] = true;

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            dfs(map,visited,nx, ny);
        }
    }

    private static void checkMap(int [][] map, boolean[][] visited){
        for(int i = 0; i < map.length; i++){
            System.out.println();
            for(int j = 0; j < map[i].length; j++){
                System.out.print(map[i][j] + " ");
            }
        }

        for(int i = 0; i < map.length; i++){
            System.out.println();
            for(int j = 0; j < map[i].length; j++){
                System.out.print(visited[i][j] + " ");
            }
        }
    }

    private static int[][] fillMap(int[][] map, int cal){
        for(int i = 0; i < cal; i++){
            Arrays.fill(map[i],0);
        }
        return map;
    }

    private static boolean[][] fillVisited(boolean[][] visited, int cal){
        for(int i = 0; i < cal; i++){
            Arrays.fill(visited[i],false);
        }
        return visited;
    }

}
