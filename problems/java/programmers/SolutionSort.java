package problems.java.programmers;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

public class SolutionSort {
    public long solution(long n) {
        long answer = 0;
        long[] arr = Stream.of(String.valueOf(n).split("")).mapToLong(Integer::parseInt).toArray();
        Long[] temp = Arrays.stream(arr).boxed().toArray(Long[]::new);
        Arrays.sort(temp,Collections.reverseOrder());
        for(long digit : temp){
            answer *= 10;
            answer += digit;
        }
        return answer;
    }
}
