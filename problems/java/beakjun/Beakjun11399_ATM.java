package problems.java.beakjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Beakjun11399_ATM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;
        int N = Integer.parseInt(st.nextToken());
        int[] waitPerson = new int [N];
        st=new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            waitPerson[i] = Integer.parseInt(st.nextToken());
        }

        int [] waitTime = new int[N];

        Arrays.sort(waitPerson);
        waitTime[0] = waitPerson[0];
        for(int i = 1; i < N; i++){
            waitTime[i] = waitTime[i-1] + waitPerson[i];
        }
        for(int i : waitTime){
            answer += i;
        }
        System.out.println(answer);
    }
}
