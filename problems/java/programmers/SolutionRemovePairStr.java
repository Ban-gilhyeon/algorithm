package problems.java.programmers;

import java.util.Stack;

public class SolutionRemovePairStr {
    Stack<String> st = new Stack<>();

    public int removePair(char[] arr){
        for(int i = 0; i < arr.length; i++){
            if((i != arr.length-1 && arr[i] != arr[i+1])||i == arr.length-1){
                if( st.size() >= 1 && st.peek().equals(String.valueOf(arr[i]))){
                    st.pop();
                }
                else st.add(arr[i]+"");
            }
            else ++i;
        }
        if(st.empty()) return 1;
        return 0;
    }
    public int solution(String s){
        int answer = -1;
        char[] arr = s.toCharArray();
        answer = removePair(arr);
        return answer;
    }
}
