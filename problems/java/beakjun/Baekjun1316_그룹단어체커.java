package problems.java.beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjun1316_그룹단어체커 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        int answer = 0;
        for(int i = 0; i < tc; i++){
            Stack<String> check = new Stack<>();
            String str = br.readLine();
            char[] words = str.toCharArray();
            String checkStr = "";
            for(char c : words){
                if(check.isEmpty() || check.peek().equals(String.valueOf(c)) || !checkStr.contains(String.valueOf(c))) {
                    check.add(String.valueOf(c));
                    checkStr += String.valueOf(c);
                } else{
                    checkStr += "0";
                }
            }
            if(!checkStr.contains("0")){
                answer++;
            }
        }
        System.out.println(answer);
    }
}
