package problems.java.programmers;

import java.util.HashMap;

public class SolutionNotCompletion {
    /*
   */
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String,Integer> map = new HashMap<>();

        for(int i = 0; i < completion.length; i++){ // 해쉬 맵에 완주한 선수 입력
            map.put(completion[i],0);
        }

        for(int i = 0; i < participant.length; i++){
            if(map.containsKey(participant[i])) { // containsKey가 오래걸림 => 반복 한 번인듯?
                if(map.get(participant[i]) == 0){ //해시맵에 선수가 있다면 value 값을 1로 변경
                    map.replace(participant[i],1);
                }
                else {
                    answer = participant[i];
                    break;
                }
            }
            else {
                answer = participant[i];
                break;
            }
        }
        return answer;
    }

    public String solution2(String[] participant, String[] completion) {
       String answer = "";
       HashMap<String,Integer> hashMap = new HashMap<>();
       for(String item : participant){
           hashMap.put(item,hashMap.getOrDefault(item,0)+1);
       }
       for(String item : completion) {
           hashMap.put(item,hashMap.get(item)-1);
       }

       for(String key : hashMap.keySet()){
           if(hashMap.get(key) != 0){
               answer = key;
           }
       }
       return answer;
    }
}
