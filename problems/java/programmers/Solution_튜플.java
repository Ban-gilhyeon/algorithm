package problems.java.programmers;

import java.util.*;

public class Solution_튜플 {
    public static void main(String[] args) {
        String s = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
        //String s = "{{123}}";
        
        /*s = s.replaceAll("[{}]", "");
        String[] arr = s.split(",");*/
        String[] arr = s.split("},");
        arr[arr.length - 1] = arr[arr.length - 1].replaceAll("}}", "}");
        Arrays.sort(arr, (String s1, String s2) -> s1.length() - s2.length());
        HashMap<Integer, Integer> hashMap = new LinkedHashMap<>();
        for(String tmp : arr){
            char[] chars = tmp.toCharArray();
            String num = "";
            for(int i = 0; i < chars.length; i++){
                char now = chars[i];
                if(now == ','){
                    hashMap.put(Integer.parseInt(num),0);
                    num = "";
                }
                else if(now != '{' && now !='}'){
                    num += chars[i];
                }
                if(i == chars.length - 1&& !num.isEmpty()){
                    hashMap.put(Integer.parseInt(num),0);
                    num = "";
                }
            }
        }
        int[] answer = new int[hashMap.keySet().size()];
        int i = 0;
        for(int key : hashMap.keySet()){
            answer[i] = key;
            System.out.print(answer[i] + ", ");
            i++;
        }
    }
}
