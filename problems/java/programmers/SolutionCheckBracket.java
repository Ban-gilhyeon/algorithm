package problems.java.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class SolutionCheckBracket {
    public boolean solution(String s){
        boolean answer =true;
        Queue<String> que = new LinkedList<>();
        String str[] = s.split("");

        for(String item : str){
            if(str.length % 2 == 0){
                if(que.size() == 0 && item.equals(")")){
                    return false;
                }
                if(item.equals("(")){
                    que.add(item);
                }
                else que.remove();
            }
            else return false;
        }
        if(que.size() != 0) return false;
        return answer;
    }

    public boolean solutionCnt(String s){
        boolean answer = true;
        String [] str = s.split("");
        int cntL = 0; int cntR =0;
        for(String item : str){
            if(cntL == 0 && cntR == 0 && item.equals(")")) return false;
            if(cntL < cntR) return false;
            if(item.equals("(")) cntL++;
            else cntR++;

        }
        if(cntL != cntR) return false;
        return answer;
    }
}
