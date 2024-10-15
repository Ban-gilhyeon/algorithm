package problems.java.programmers;

public class SolutionRefeatWord {
    public String solution(String my_string, int n) {
        String answer = "";
        String [] word = my_string.split("");
        for(int i = 0; i < word.length; i++){
            for(int j = 0; j < n; j++){
                answer = answer + word[i];
            }
        }
        return answer;
    }
}
