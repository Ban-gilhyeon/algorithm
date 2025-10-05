package problems.java.programmers;

import java.util.*;

public class Solution_프로세스 {

    public static void main(String[] args) {
        int[] priorities = {1, 1, 9, 1, 1, 1};
        //{2, 1, 3, 2};
        //{1, 1, 9, 1, 1, 1};
        int location = 0;
        Queue<int[]> que = new LinkedList<>();

        int idx = 0;
        int max = Integer.MAX_VALUE;

        for(int i = 0; i < priorities.length; i++){
            int[] tmp = new int[2];
            //tmp[0] 인덱스, tmp[1] 우선순위
            tmp[0] = i;
            tmp[1] = priorities[i];
            que.add(tmp);
        }
        int answer = 1;
        Integer[] arr = new Integer[priorities.length];
        int cnt = 0;
        for(Integer i : priorities){
            arr[cnt] = i;
            cnt++;
        }
        Arrays.sort(arr, Collections.reverseOrder());
        int index = 0;
        int i = 0;
        while(!que.isEmpty()){
            int[] tmp = que.poll();
            if(tmp[1] != arr[index]){
                que.add(tmp);
                continue;
            }
            if(tmp[0] == location){
                answer = index;
                break;
            }
            index++;
            i++;
        }
        System.out.println(answer);
    }
}
