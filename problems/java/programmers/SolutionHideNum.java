package problems.java.programmers;

public class SolutionHideNum {
    public String solution(String phone_number) {
        String answer = "";
        char[] numbers = new char[phone_number.length()];
        for(int i = 0; i < numbers.length; i++){
            numbers[i] = phone_number.charAt(i);
            if(i < numbers.length-4)
            numbers[i] = '*';
        }
        answer = new String(numbers);
        return answer;
    }
}
