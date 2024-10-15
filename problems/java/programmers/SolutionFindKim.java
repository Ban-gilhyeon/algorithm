package problems.java.programmers;

import java.util.Arrays;

public class SolutionFindKim {
    public String solution(String[] seoul) { //굳이 배열을 List로 다시 바꾸기 때문에 메모리 낭비
        String answer = "";
        int index =0;
        index = Arrays.asList(seoul).indexOf("Kim");
        answer = "김서방은 "+ index + "에 있다.";
        return answer;
    }

    public String solution2(String[] seoul){
        String answer = "";
        for(int i =0; i<seoul.length; i++){
            if(seoul[i].equals("Kim")){
                return "김서방은" + i +"에 있다";
            }
        }
        return answer;
    }
}
