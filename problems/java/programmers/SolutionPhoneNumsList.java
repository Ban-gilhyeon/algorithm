package problems.java.programmers;

import java.util.Arrays;

public class SolutionPhoneNumsList {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        String head = phone_book[0];
        int headSize = head.length();
        for (int i = 1; i < phone_book.length; i++) {
            if(headSize <= phone_book[i].length()) {
                String cut = phone_book[i].substring(0, headSize);
                if (head.equals(cut)) {
                    answer = false;
                    break;
                }
            }
        }
        return answer;
    }

    public boolean solution2(String[] phone_book){
        boolean answer = true;
        Arrays.sort(phone_book);
        for(int i = 0; i < phone_book.length; i++){
            if(phone_book[i + 1].startsWith(phone_book[i])){
                answer =false;
                break;
            }

        }
        return answer;
    }
}