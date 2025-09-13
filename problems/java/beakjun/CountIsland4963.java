package problems.java.beakjun;

import java.util.Scanner;

public class CountIsland4963 {
    //백준 4963
    public static void main(String[] args) {
        //여러개의 테스트 케이스로 이루어져 있다..?
        // wide, hight 가 0 0 이 들어모면 종료
        while(true) {
            Scanner sc = new Scanner(System.in);
            int answer = 0;
            //입력
            int wide = sc.nextInt();
            int height = sc.nextInt();

            //종료 조건
            if(wide == 0 && height == 0) break;

            int[][] map = new int[height][wide];
            boolean[][] visited = new boolean[height][wide];
            //지도 설정 , visited false로 초기화
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < wide; j++) {
                    map[i][j] = sc.nextInt();
                    visited[i][j] = false;
                }
            }

            //탐색
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < wide; j++) {
                    if (map[i][j] == 1 && visited[i][j] == false) {
                        visited[i][j] = true;
                        dfs(i, j, height, wide, map, visited);
                        answer++;
                    }
                }
            }
            System.out.println("answer : " + answer);
        }
    }

    public static void dfs(int nowi, int nowj, int hight, int wide, int[][] map, boolean[][] visited) {
        int[] di = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dj = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < di.length; i++) {
            visited[nowi][nowj] = true;
            int nexti = nowi + di[i];
            int nextj = nowj + dj[i];
            if (nexti >= 0 && nexti < hight && nextj >= 0 && nextj < wide && map[nexti][nextj] == 1 && visited[nexti][nextj] == false) {
                dfs(nexti, nextj, hight, wide, map, visited);
            }
        }

    }
}
