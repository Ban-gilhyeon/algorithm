package problems.java.beakjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Beakjun1149_RGB거리 {
    static int[][] Coast;
    static int[][] Dp;
    static int Red = 0;
    static int Green = 1;
    static int Blue = 2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Coast = new int[n][3];
        Dp = new int[n][3];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            Coast[i][Red] = Integer.parseInt(st.nextToken());
            Coast[i][Green] = Integer.parseInt(st.nextToken());
            Coast[i][Blue] = Integer.parseInt(st.nextToken());
        }

        Dp[0][Red] = Coast[0][Red];
        Dp[0][Green] = Coast[0][Green];
        Dp[0][Blue] = Coast[0][Blue];

        for(int i = 1; i < n; i++){
            Dp[i][Red] = Coast[i][Red] + Math.min(Dp[i-1][Green], Dp[i-1][Blue]);
            Dp[i][Green] = Coast[i][Green] + Math.min(Dp[i-1][Red], Dp[i-1][Blue]);
            Dp[i][Blue] = Coast[i][Blue] + Math.min(Dp[i-1][Green], Dp[i-1][Red]);
        }
        int result = Math.min(Dp[n-1][Red], Math.min(Dp[n-1][Green],Dp[n-1][Blue]));
        System.out.println(result);
    }

}
