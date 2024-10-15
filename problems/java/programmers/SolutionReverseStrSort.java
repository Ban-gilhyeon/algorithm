package problems.java.programmers;

import java.util.Arrays;
import java.util.Collections;

public class SolutionReverseStrSort {
    public String solution(String str) {
        String answer = "";
        String[] words = str.split("");
        Arrays.sort(words, Collections.reverseOrder());
        for(String word : words){
            answer += word;
        }
        return answer;
    }
}
