package problems.java.beakjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class beakJun12904_A와B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String target = br.readLine();

        int answer = backTracking(s,target);
        System.out.println(answer);

    }

    private static int backTracking(String s, String target){
        //문자열 뒤에 A를 뺀다
        // 문자열을 뒤집고 뒤에 B뺀다
        if(s.equals(target)) return 1;
        if(target.length() < s.length()) return 0;

        if(target.endsWith("A")){
            String next = target.substring(0,target.length() - 1);
            if(backTracking(s,next)==1) return 1;
        }
        if(target.endsWith("B")){
            StringBuffer sb = new StringBuffer(target);
            String reverse = sb.reverse().toString();
            String next = reverse.substring(1);
            if(backTracking(s,next)==1) return 1;
        }
        return 0;
    }
}
