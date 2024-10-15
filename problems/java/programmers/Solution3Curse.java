package problems.java.programmers;

public class Solution3Curse {
    public int solution(int n) {
      int answer =0 ;
      int [] arr = new int[n+1];
      int cnt = 1;
      String num = Integer.toString(n);
      for(int i = 1; i<= n; i++){
        while(cnt % 3 == 0 || Integer.toString(cnt).contains("3")){
            cnt++;
        }
        arr[i] = cnt++;
      }
      answer = arr[n];
      return answer;
    }
}
