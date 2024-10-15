package problems.java.programmers;

import java.util.stream.Stream;

public class SolutionHoshade {
    public boolean solution(int x) {
        boolean answer = true;
        int totall =0;
        int arr[] = Stream.of(String.valueOf(x).split("")).mapToInt(Integer::parseInt).toArray();
        for(int i =0; i<arr.length;i++){
            totall += arr[i];
        }
        if(x%totall != 0){
            answer = false;
        }
        return answer;
    }
    public boolean solution2(int x){
        int sum = String.valueOf(x).chars().map(ch -> ch - '0').sum();
        return x % sum == 0;
    }
}
