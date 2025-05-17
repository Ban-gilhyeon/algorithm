package problems.java.programmers;

import java.util.*;

public class Solution_우선순위큐 {
    public static void main(String[] args) {
        String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        PriorityQueue<Integer> minQue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQue = new PriorityQueue<>(Collections.reverseOrder());
        int[] answer = new int [2];
        for(String str : operations){
            StringTokenizer st = new StringTokenizer(str);
            String command = st.nextToken();
            int x = Integer.parseInt(st.nextToken());

            switch(command){
                case "I" :
                    minQue.add(x);
                    maxQue.add(x);
                    break;
                case "D" :
                    if(x == 1){
                        minQue.remove(maxQue.peek());
                        maxQue.poll();
                        break;
                    }else {
                        maxQue.remove(minQue.peek());
                        minQue.poll();
                        break;
                    }
            }
            if(minQue.isEmpty()){
                answer[0] = 0;
                answer[1] = 0;
            }else {
                answer[0] = maxQue.poll();
                answer[1] = minQue.poll();
            }
        }
    }

    private static void I(int x){

    }
}
