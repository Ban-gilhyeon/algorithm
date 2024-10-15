package problems.java.programmers;

import java.util.Arrays;

public class SolutionMaxMin {
    public String solution(String s) {
        StringBuffer answer = new StringBuffer();
        int i = 0;
        //int []arr = new int[배열 사이즈 선언]
        //공백을 기준으로 String s 자르기
        String str[] = s.split(" ");
        int []arr = new int[str.length];

        for(String item : str){
            arr[i] = Integer.parseInt(item);
            i++;
            //arr = Integer.valueof(item);
        }
        Arrays.sort(arr);
        answer.append(arr[0]);
        answer.append(" ");
        answer.append(arr[arr.length-1]);
        return answer.toString();
    }
}
