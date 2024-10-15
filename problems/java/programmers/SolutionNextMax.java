package problems.java.programmers;

import java.util.Arrays;
import java.util.Collections;

public class SolutionNextMax {

    public int cntBinaryOne(int n ){
        int cnt = 0;
        //n의 이진수 1의 갯수
        String binary [] = Integer.toBinaryString(n).split("");
        Arrays.sort(binary,Collections.reverseOrder());
        for(String c : binary){
            if(c.equals("1")) {
                cnt++;
            }
            else break;
        }
        return cnt;
    }
    public int solution(int n){ //시간 초과
        int answer = 0;
        int cntN = cntBinaryOne(n);

        for(int i = 1; i < n; i++){
            int temp = n + i;
            int cntNext = cntBinaryOne(temp);
            if(cntN == cntNext){
                answer = temp;
                break;
            }
        }
        return answer;
    }
    public int solution2(int n ){
        int answer = 0;
        // 1. n을 2진수 변환.
        String str = Integer.toBinaryString(n);
        // 2. n의 1인 비트의 수를 저장하는 변수.
        int cnt =0;
        // 3. 1인 비트의 수를 카운팅.
        for(int i = 0;i<str.length();i++){
            if(str.charAt(i) == '1') cnt++;
        }
        // 4. n+1부터 반복.
        for(int i =n+1;i<1000000;i++){
            // 5. 위 과정을 반복.
            String temp = Integer.toBinaryString(i);
            int temp_cnt = 0;
            for(int j =0;j<temp.length();j++){
                if(temp.charAt(j) == '1') temp_cnt++;
            }
            // 6. 1인 비트의 수가 일치하면 해당 수를 담아 반복문 종료.
            if(temp_cnt == cnt) {
                answer = i;
                break;
            }
        }

        return answer;
    }
}
