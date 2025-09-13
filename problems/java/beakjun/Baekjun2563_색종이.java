package problems.java.beakjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjun2563_색종이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;
        int cnt = 0;
        int tc = Integer.parseInt(st.nextToken());
        int[][] map = new int[100][100];
        for(int[] i : map){
            Arrays.fill(i, 0);
        }
        for(int i = 0; i < tc; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            y = 100 - y;
           for(int row = 0; row < 10; row++){
               y--;
               if(y >= 0){
                   for(int col = x; col < x + 10; col++){
                       if(col >= 0 && col < 100) {
                           map[y][col]++;
                           if(map[y][col] >= 2){
                               cnt++;
                           }
                       }
                   }
               }
           }
        }
        //printMap(map);
        answer = tc * 100 - cnt;
        System.out.println(answer);
    }

    static void printMap(int [][] map){
        for(int i = 0; i < map.length; i++){
            System.out.println();
            for(int j = 0; j < map[0].length; j++){
                System.out.print(map[i][j] + " ");
            }
        }
    }
}
