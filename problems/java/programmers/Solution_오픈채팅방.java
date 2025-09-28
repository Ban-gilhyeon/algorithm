package problems.java.programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution_오픈채팅방 {
    public static  void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        String[] result = new String[record.length];
        List<String> answer = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
        for(int i = 0; i < record.length; i++){
            String[] tmp = record[i].split(" ");
            String action = tmp[0];
            String id = tmp[1];
            String nickname = "";
            if(tmp.length == 3) {
                nickname = tmp[2];
            }
            map.put(id, nickname);
            result[i] = id + "," +action;
        }

        for(String s : result){
            String[] tmp = s.split(",");
            String nickname = map.get(tmp[0]);
            String action = "";
            if(tmp[1].equals("Enter")){
                action = "들어왔습니다.";
                answer.add(nickname +"님이 " + action);
            }
            if(tmp[1].equals("Leave")) {
                action = "나갔습니다.";
                answer.add(nickname +"님이 " + action);
            }
        }
        for(String s : answer){
            System.out.println(s);
        }
    }
}
