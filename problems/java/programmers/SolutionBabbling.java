package problems.java.programmers;

public class SolutionBabbling {
    public int solution(String[] babbling){
        int answer = 0;
        String[] strs = { "aya", "ye", "woo", "ma" };
        String[] check = {"1", "11", "111", "1111"};
        //bfs?
        for(String word : babbling){
            for(int i = 0; i < strs.length; i++){
                if(word.contains(strs[i])){
                    word = word.replace(strs[i], "1");
                }
                if(word.equals(check[0]) || word.equals(check[1])|| word.equals(check[2])|| word.equals(check[3])){
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}
