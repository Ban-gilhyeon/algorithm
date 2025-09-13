package problems.java.beakjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Beakjun2667_단지번호붙이기 {
    static boolean[][] visited;
    static int [][] map;
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        visited = new boolean[N][N];
        for(int i= 0; i < visited.length; i++){
            Arrays.fill(visited[i],false);
        }

        for(int i =0; i < N; i++){
            String line = br.readLine();
            for(int j = 0; j < N; j++){
                map[i][j] =  Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }

        List<Integer> result = new ArrayList<>();

        for(int y =0; y < N; y++){
            for(int x = 0; x < N; x++){
                if(map[y][x] == 1 && !visited[y][x]){
                    //result.add(dfs(x,y));
                    result.add(bfs(x,y));
                }
            }

        }

        System.out.println(result.size());
        Collections.sort(result);
        for(int i : result){
            System.out.println(i);
        }

    }

    private static int dfs(int x, int y){

        if(x < 0 || y < 0 || x >= N || y >= N ) return 0;
        if(map[y][x] == 0 || visited[y][x]) return 0;

        visited[y][x] = true;
        int address = 1;
        address += dfs(x-1,y);
        address += dfs(x+1,y);
        address += dfs(x,y+1);
        address += dfs(x,y-1);

        return address;
    }

    private static int bfs(int x, int y){
        int[] dx = {-1, 1 ,0 ,0};
        int[] dy = {0, 0, 1,-1};
        Queue<Point> queue = new LinkedList<>();
        int cnt = 1;
        visited[y][x] = true;
        queue.add(new Point(x,y));

        while (!queue.isEmpty()){
            Point p = queue.poll();

            for(int i = 0; i < 4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx>=0 && ny >= 0 && nx < N && ny < N){
                    if(map[ny][nx] == 1 && !visited[ny][nx]){
                        visited[ny][nx] = true;
                        cnt++;
                        queue.add(new Point(nx,ny));
                    }
                }
            }
        }
        return cnt;
    }
    private static class Point{
        int x;
        int y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
