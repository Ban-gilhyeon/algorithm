package problems.java.beakjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beakjun2579_계단오르기 {
    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] stares = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            stares[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = stares[1];
        dp[2] = stares[1] + stares[2];
        dp[3] = Math.max(stares[1] + stares[3], stares[2] + stares[3]);

        for(int i = 4; i <= n; i++){
            dp[i] = Math.max(
                    dp[i-2] + stares[i],
                    dp[i-3] + stares[i-1] + stares[i]
            );
        }
        System.out.println(dp[n]);
    }
}
