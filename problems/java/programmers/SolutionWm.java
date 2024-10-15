package problems.java.programmers;

public class SolutionWm {
    public String solution(int n) {
        StringBuffer answer = new StringBuffer("수박");
        if(n == 1){ return "수";}
        else if(n == 2){ return"수박";}
        else if(n == 3){ return"수박수";}
        else if(n % 2 == 0){
            for(int i = 0; i < (n/2)-1; i++){
                answer.append("수박");
            }
        }
        else{
            for(int i = 0; i < (n/2)-1; i++){
                answer.append("수박");
            }
            answer.append("수");
        }
        return answer.toString();
    }
}
