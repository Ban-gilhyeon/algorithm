package problems.java.programmers;

import java.util.*;

public class Solution_귤고르기 {
    public static void main(String[] args) {
        int [] tangerine = {1,3,2,5,4,5,2,3};
        int k = 6;
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        Arrays.sort(tangerine);
        int before = tangerine[0];
        int cnt = 1;
        for(int i : tangerine){
            if(i == before){
                hashMap.put(i, cnt++);
            }else{
                before = i;
                hashMap.put(i,1);
                cnt = 1;
                cnt++;
            }
        }
        List<Integer> counts = new ArrayList<>(hashMap.values());
        counts.sort(Comparator.reverseOrder());
        int picked = 0;
        int answer = 0;
        for(Integer i : counts){
            if(picked >= k) break;
            else{
                picked += i;
                answer++;
            }
        }
        System.out.println(answer);
    }
}
