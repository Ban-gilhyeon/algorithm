package problems.java.programmers;

import java.util.HashMap;

public class SolutionClothes {
    int sum = 0;
    //clothes [의상의 이름][의상의 종류] 3 2
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String,Integer> parts = new HashMap<>();
        for(int i = 0; i < clothes.length; i++){
            parts.put(clothes[i][1],parts.getOrDefault(clothes[i][1],0)+1);
        }
        for(String item : parts.keySet()){
            answer *= parts.get(item) +1;
        }
        answer -=1;
        return answer;
    }

    public int factorial(int n){
        if(n <= 0) return sum;
        else sum += n;
        return factorial(n-1);
    }
}
