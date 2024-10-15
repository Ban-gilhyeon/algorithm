package problems.java.programmers;

public class SolutionAnt {
    //greed
    public int solution(int hp) { //반복문을 사용할 필요 X
        int answer = 0;
        int antGen = 5;
        int antSol = 3;
        while(hp > 0){
            if(hp >= antGen){
                answer = answer + (hp/antGen);
                hp = hp % antGen;
            }
            else if(hp >= antSol){
                answer = answer + (hp/antSol);
                hp = hp % antSol;
            }
            else{
                answer = answer + hp;
                break;
            }
        }

        return answer;
    }
}
