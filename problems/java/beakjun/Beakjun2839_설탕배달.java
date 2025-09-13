package problems.java.beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beakjun2839_설탕배달 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int result = 0;
        while (N > 0){
            if(N % 5 == 0){
                result += N / 5;
                N = N % 5;
            } else if( N >= 3){
                N -= 3;
                result++;
            } else{
                break;
            }
        }
        if(N == 0) System.out.println(result);
        else System.out.println(-1);
    }
}
