package problems.java.programmers;

import java.util.Arrays;

public class SolutionKNum {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];;
        int temp [] = {};
        int i = 0; int j = 0; int k = 0; int cnt = 0;

        for(int[] item : commands){
            i = item[0] -1;
            j = item[1] -1;
            k = item[2] -1 ;
            temp = new int[(j-i)+1];
            for(int a = 0; a <= j; a++) {
                if(i > j)  break;
                else temp[a] = array[i++];
            }

            Arrays.sort(temp);
            answer[cnt++] = temp[k];
        }
        return answer;
    }
}
