package problems.java.beakjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beakjun14503_로봇청소기 {
    private static int answer = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int ny = Integer.parseInt(st.nextToken());
        int nx = Integer.parseInt(st.nextToken());
        int d =  Integer.parseInt(st.nextToken());


        int[][] map = new int[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cleanUp(ny,nx,map,d);
        //map 확인
        /*for(int i = 0; i < n; i++){
            System.out.println();
            for(int j = 0; j < m; j++){
                System.out.print(map[i][j] + " ");
            }
        }*/

        System.out.println(answer);
    }
    private static void cleanUp(int y, int x, int[][]map, int d){
        /*int[] dy ={-1, 0, 1, 0};
        int[] dx = {0, -1, 0, 1};*/
        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};
        /*if(map[y][x] == 0) {
            map[y][x] = -1;
            answer++;
        }*/
        map[y][x] = -1;

        /*System.out.println("Y : " + (y + 1));
        System.out.println("X : " + (x + 1));
        System.out.println("d : " + d);
        System.out.println("answer : " + answer);
        printMap(map);*/

        for(int i = 0; i < 4; i++){
            d = (d+3) % 4;
            int ny = y + dy[d];
            int nx = x + dx[d];

            if( ny >=0 && ny < map.length && nx >= 0 && nx < map[ny].length && map[ny][nx] == 0){
                answer++;
                cleanUp(ny, nx, map, d);
                return;
            }

        }

        int back = (d + 2) % 4;
        int backY = y + dy[back];
        int backX = x + dx[back];
        if(backY >=0 && backY < map.length && backX >= 0 && backX < map[backY].length && map[backY][backX] != 1){
            cleanUp(backY, backX, map, d);
        }
    }

    private static void printMap(int[][] map){
        //map 확인
        for(int i = 0; i < map.length; i++){
            System.out.println();
            for(int j = 0; j < map[i].length; j++){
                System.out.print(map[i][j] + "    ");
            }
        }
        System.out.println();
    }
}
