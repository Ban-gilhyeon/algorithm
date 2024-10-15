package problems.java.programmers;

import java.util.Arrays;

public class SolutionMaxNum {
    public String solution(int[] numbers) {
        String answer = "";
        String [] temp = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            temp[i] = Integer.toString(numbers[i]);
        }
        //Arrays.sort(temp, Collections.reverseOrder());
        Arrays.sort(temp, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        for(String item : temp){
            answer += item;
        }
        return answer;
    }

    public String solution2(int[] numbers) {
        String[] arr = new String[numbers.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        if (arr[0].equals("0")) {
            return "0";
        }
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            answer.append(arr[i]);
        }
        return answer.toString();
    }
}
