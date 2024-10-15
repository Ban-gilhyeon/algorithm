package problems.java.programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SolutionLeastCommonMuliple {

    public Queue<Integer> primeFac(int [] arr){
        Queue<Integer> que = new LinkedList<>();
        int min = arr[0];
        int i = 0;
        while(min != 1){
            if(min % 2 == 0){
                min = min / 2;
                que.add(2);
                i++;
            }
            else if(min % 3 == 0){
                min = min / 3;
                que.add(3);
                i++;
            }
            else if(min % 5 == 0){
                min = min / 5;
                que.add(5);
                i++;
            }
            else if(min % 7 == 0){
                min = min / 7;
                que.add(7);
                i++;
            }
        }

        return que;
    }
    public int solution(int[] arr){
        int answer = 1;
        Arrays.sort(arr);
        Queue<Integer> fac = primeFac(arr);
        for(int i = 0; i < arr.length; i++){
            if( arr[i]%fac.peek()==0){
                arr[i] = arr[i]/ fac.peek();
            }
        }
        for(int i : arr){
            answer *= i;
        }
        return answer;
    }
}
