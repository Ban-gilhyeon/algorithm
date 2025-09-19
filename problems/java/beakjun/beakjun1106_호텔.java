package problems.java.beakjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static problems.java.beakjun.Baekjun2468_안전영역.max;

public class beakjun1106_호텔 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int goal = Integer.parseInt(st.nextToken());
        int city = Integer.parseInt(st.nextToken());
        int[] adFees = new int[city];
        int[] customers = new int[city];
        int[] dp = new int[10000];
        dp[1] = 1;
        for(int i = 0; i < city; i++){
            st = new StringTokenizer(br.readLine());
            adFees[i] = Integer.parseInt(st.nextToken());
            customers[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < city; i++){
            for(int coast = adFees[i]; coast < dp.length; coast++){
                if(coast == goal) break;
                dp[coast] = Integer.max(dp[coast], dp[coast - adFees[i] + customers[i]]);
            }
        }

        for(int i : dp) System.out.println(i + ", ");
    }
}
