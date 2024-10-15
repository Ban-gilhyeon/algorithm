package problems.java.programmers;

public class SolutionMidChar {
    public String solution(String s) {
        String answer = "";
        int half = s.length() / 2;
        if(s.length() % 2 == 0){
            answer = s.substring(half-1,half+1) ;
        }
        else{
            answer = String.valueOf(s.charAt(half)) ;
        }
        return answer;
    }
}
