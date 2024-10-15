package problems.java.programmers;

import java.util.Arrays;

public class SolutionChangeBinary {
    int cnt = 0; int i = 0;
    int size;
    int [] answer = new int[2];

    public int[] solution(String s){
        int tempCnt = 0;
        this.size = s.length();
        if(size == 1) {
            answer[0] = i;
            answer[1] = cnt;
            return answer;
        }
        String str[] = s.split("");
        Arrays.sort(str);
        for(String item : str){
            if(item.equals("0")){
                cnt++;
                tempCnt++;
            }
            else{
                size -=  tempCnt;
                break;
            }
        }
        s = Integer.toBinaryString(size);
        System.out.println(s);
        i++;
        return solution(s);
    }
}
