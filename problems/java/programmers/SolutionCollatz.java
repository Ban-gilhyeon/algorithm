package problems.java.programmers;

public class SolutionCollatz {
    private int answer = 0;
    public int solution(int num) {
        if (num == 1){
            return answer;
        }
        else if(answer >=500 || num < 0) {
            return -1;
        }
        if (num % 2 == 0) num /= 2;
        else if (num % 2 != 0) num = (num * 3) + 1;
        answer++;
        System.out.println(answer+"번째 : "+num);
        return solution(num);
    }
}
