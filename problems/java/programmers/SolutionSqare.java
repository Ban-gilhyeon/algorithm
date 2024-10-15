package problems.java.programmers;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class SolutionSqare {
    public long solution(long n) {
        long answer = 0;
        double s1 = sqrt(n);
        int s2 = (int)sqrt(n);
        System.out.println(s2);
        if(s1 == s2){
            answer = (long)pow(s1+1,2);
        }
        else return -1;
        return answer;
    }
}
