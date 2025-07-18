package problems.java.programmers;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution_단어변환{
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) {
       String begin = "hit";
       //String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        String[] words = {"hot", "dot", "dog", "lot", "log"};
       String target = "cog";

       boolean[] visited = new boolean[words.length];
        Arrays.fill(visited, false);
        dfs(begin, target, words, visited, 0);
        if(answer == Integer.MAX_VALUE){
            answer = 0;
        }
        System.out.println(answer);
    }

    private static void dfs(String begin, String target, String[] words, boolean[] visited, int cnt){
        if(begin.equals(target)){
            answer = Math.min(answer, cnt);
            return;
        }

        for(int i = 0; i < words.length; i++){
            if(checkTransform(begin, words[i]) && !visited[i]){
                begin = words[i];
                visited[i] = true;
                dfs(begin, target, words,visited ,cnt+1);
            }
        }

    }

    private static boolean checkTransform(String begin, String word){
        int result = 0;
        for(int i = 0; i < begin.length(); i++){
            char beginChar = begin.charAt(i);
            char wordChar = word.charAt(i);
            if(beginChar != wordChar) result++;
        }
        if(result == 1) return true;
        return false;
    }
}
