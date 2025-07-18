package problems.java.programmers;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_야근지수 {
    public static void main(String[] args) {
        int[] works = {4,3,5};
        int n = 4;
        System.out.println(solutaion(works,n));
    }
    private static long solutaion(int[] works, int n){
        long answer = 0;
        PriorityQueue<Integer> maxWorks = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i = 0; i < works.length; i++){
            maxWorks.add(works[i]);
        }
        while(n != 0){
            int temp = maxWorks.poll();
            maxWorks.add(temp - 1);
            n--;
        }

        for(int i = 0; i <= maxWorks.size(); i ++){
            if(maxWorks.poll() <= 0){
                answer += 0;
                maxWorks.poll();
            }
            else answer += square(maxWorks.poll());
        }

        return answer;
    }
    private static int square(int x ){
        return x * x;

    }
}
