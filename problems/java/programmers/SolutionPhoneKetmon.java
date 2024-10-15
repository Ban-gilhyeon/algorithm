package problems.java.programmers;

import java.util.HashMap;

public class SolutionPhoneKetmon {
    // nums의 배열의 숫자를 리스트로 만들고 그 리스트에 nums에 들어있는 비중을 넣으면 (value) 가장큰 Value를 가지는 Key
    public int solution(int[] nums) {
        int cnt = 0;
        HashMap<Integer, Integer> dic = new HashMap<Integer, Integer>();
        int answer = 0;
        for(int i = 0; i< nums.length; i++){
            if(dic.containsKey(nums[i])){
                dic.put(nums[i],dic.get(nums[i]) + 1);
            }
            else{
                dic.put(nums[i],0);
            }
        }
        if(dic.size() > nums.length/2){
            answer = nums.length/2;
        }
        else{
            answer = dic.size();
        }
        return answer;
    }
}
