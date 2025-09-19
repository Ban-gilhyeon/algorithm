package problems.java.programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution_모음사전 {
    static List<String> list;
    static String[] words = {"A", "E", "I", "O", "U"};
    public static void main(String[] args) {
        String word = "EIO";
        list = new ArrayList<>();
        dfs("",0);
        int answer = 0;
        for(String s : list){
            answer++;
            if(s.equals(word)){
                break;
            }
        }
        System.out.println(answer);

    }

    private static void dfs(String str, int len){
        list.add(str);
        if(len == 5) return;
        for(int i = 0; i < 5; i++){
            dfs(str + words[i], len + 1);
        }
    }
}
