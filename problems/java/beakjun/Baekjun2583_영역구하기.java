package problems.java.beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjun2583_영역구하기 {
    static int M; // 가로
    static int N; // 세로
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = 0;

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                map[i][j] = 0;
                visited[i][j] = false;
            }
        }


        for(int i = 0 ; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int leftX = Integer.parseInt(st.nextToken());
            int leftY = Integer.parseInt(st.nextToken());
            int rightX = Integer.parseInt(st.nextToken());
            int rightY = Integer.parseInt(st.nextToken());

            leftY = N - leftY - 1;
            rightY = N - rightY - 1;

            for(int j = leftY; j > rightY; j--){
                for(int k = leftX; k < rightX; k++){
                    if(j < N && k < M) map[j][k] = 1;
                }
            }
        }

        ArrayList<Integer> answers = new ArrayList<>();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 0 && !visited[i][j]){
                    int cnt = 0;
                    cnt += dfs(j, i, map);
                    answers.add(cnt);
                }
            }
        }
        System.out.println(answers.size());
        Collections.sort(answers);
        for(int i = 0; i < answers.size(); i++){
            System.out.print(answers.get(i) + " ");
        }

    }
    static int dfs(int x, int y, int[][] map){
        int[] dx = {0,0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        if(visited[y][x] || map[y][x] == 1) return 0;
        int cnt = 1;
        visited[y][x] = true;
        for(int i = 0; i < 4; i++){
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if(nx >= 0 && nx < M && ny >= 0 && ny < N){
                cnt += dfs(nx, ny, map);
            }
        }
        return cnt;
    }

    static void printMap(int [][] map){
        for(int i = 0; i < map.length; i++){
            System.out.println();
            for(int j = 0; j < map[0].length; j++){
                System.out.print(map[i][j] + " ");
            }
        }
    }

    static void printVisited(boolean [][] map){
        for(int i = 0; i < map.length; i++){
            System.out.println();
            for(int j = 0; j < map[0].length; j++){
                System.out.print(map[i][j] + " ");
            }
        }
    }
}
