package problems.java.beakjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Baekjun2468_안전영역 {
    static int [][] map;
    static boolean [][] visted;
    static int max;
    static int N;

    public static void main(String[] args) {
        List<Integer> answers = new ArrayList<>();
        int answer = 0;
        Scanner sc = new Scanner(System.in);
        // 사용자 입력
        N = sc.nextInt();
        map = new int [N][N];
        visted = new boolean [N][N];

        for(int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < N ; j++) {
                map[i][j] = sc.nextInt();
                visted[i][j] = false;
            }
        }

        setMax(N);
        //System.out.println("max : " + max);
        //map의 max 만큼 반복
        for(int i = 0 ; i < max; i++) {
            int cnt = 0;
            for(int j = 0 ; j < N; j++) {
                for(int k = 0 ; k < N ; k++) {
                    if(map[j][k] > 0 && !visted[j][k]){
                        visted[j][k] = true;
                        cnt++;
                        dfs(j, k);
                    }

                }
            }
            answers.add(cnt);

            for(int j = 0 ; j < N ; j++) {
                for(int k = 0 ; k < N ; k++) {
                    map[j][k] -= 1;
                    visted[j][k] = false;
                    if(map[j][k] <= 0) {
                        map[j][k] = 0;
                    }
                   // System.out.print(map[j][k] + " ");
                }
                //System.out.println("");
            }
            //System.out.println("-----------답 : "+ cnt +  "---------"   );
        }
        answer = Collections.max(answers);
        System.out.println(answer);
    }

    static void setMax(int N){
        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < N ; j++) {
                if(max < map[i][j]) {
                    max = map[i][j];
                }
            }
        }
    }

    static void dfs(int nowi, int nowj){
        int[] di = {-1, 0, 1, 0};
        int[] dj = {0, -1, 0, 1};

        for(int i = 0 ; i < di.length ; i++) {
            visted[nowi][nowj] = true;
            int nexti = nowi + di[i];
            int nextj = nowj + dj[i];

            if(nexti >= 0 && nextj >= 0 && nexti < N && nextj < N && map[nexti][nextj] > 0 && !visted[nexti][nextj] ) {
                dfs(nexti, nextj);
            }
        }
    }
}

