package problems.java.beakjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Beakjun1561_놀이공원 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] waitTime = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            waitTime[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        int[] realTime = new int[m];

        Arrays.fill(realTime,0);
        while(n > 0){
            for(int i = 0; i < m; i++){
                if (realTime[i] == 0){
                    n--;
                    realTime[i] = waitTime[i];
                    if(n == 0) answer = i+1;
                }else{
                    realTime[i]--;
                }
            }
        }
        System.out.println(answer);
    }
}
