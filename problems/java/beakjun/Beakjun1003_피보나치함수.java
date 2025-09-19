package problems.java.beakjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Beakjun1003_피보나치함수 {
    public static void main(String[] args) throws IOException {
        int[][] arr = new int[42][2];
        //0번
        arr[0][0] = 1;
        arr[0][1] = 0;
        //1번
        arr[1][0] = 0;
        arr[1][1] = 1;
        //2번
        arr[2][0] = 1;
        arr[2][1] = 1;

        for(int i = 3; i <= 41; i++){
            arr[i][0] = arr[i-1][0] + arr[i-2][0];
            arr[i][1] = arr[i-1][1] + arr[i-2][1];
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        int[] answers = new int[tc];
        for(int i = 0; i < tc; i++){
            answers[i] = Integer.parseInt(br.readLine());
        }
        for(int i : answers){
            System.out.println(arr[i][0] + " " + arr[i][1]);
        }
    }
}
