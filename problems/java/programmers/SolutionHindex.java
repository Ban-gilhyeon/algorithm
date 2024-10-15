package problems.java.programmers;

import java.util.Arrays;

public class SolutionHindex {
    public int solution(int[] citations) {
        /*[0] 0
          [3, 4] 2
          [1, 2, 3, 5, 6, 7, 10, 11] 5
          [3, 5, 11, 6, 1, 5, 3, 3, 1, 41] 5 [1, 1, 3, 3, 3, 5, 5, 6, 11, 41]
          [1, 11, 111, 1111] 3*/
       int answer = 0; int half = 0;
       Arrays.sort(citations);
       for(int i = 0; i < citations.length; i++){
           int h = citations.length - i;
           if(citations[i] >= h){
               answer = h;
               break;
           }
       }
       return answer;
    }
}
