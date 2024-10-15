package problems.java.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionDiv {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0) {
                list.add(arr[i]);
            }
        }
        if(list.isEmpty()) list.add(-1);
        answer = list.stream().mapToInt(i -> i).toArray();
        return answer;
    }

}