package problems.java.beakjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class beakjun1106_호텔 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int goal = Integer.parseInt(st.nextToken());
        int city = Integer.parseInt(st.nextToken());

        for(int i = 0; i < city; i++){
            st = new StringTokenizer(br.readLine());
            int coast = Integer.parseInt(st.nextToken());
            int benefit = Integer.parseInt(st.nextToken());
        }

    }
}
