package problems.java.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class SolutionBestAlbum {

    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        HashMap<Integer, String> hashMap = new HashMap<>();
        HashMap<String, Integer> playNum = new HashMap<>();
        HashMap<Integer,Integer> idxPlay = new HashMap<>();
        for(int i = 0; i < genres.length; i++){
            //hashmap [플레이 횟수, 장르] 저장
            hashMap.put(plays[i], genres[i]);
            //playNum [장르, 장르별 총 플레이 횟수] 저장
           /* if(playNum.containsKey(genres[i])){
                playNum.put(genres[i],playNum.get(genres[i])+plays[i]);
            }
            else playNum.put(genres[i],plays[i]);*/
            playNum.put(genres[i],playNum.getOrDefault(genres[i],0)+plays[i]);
            //idxPlay [ 고유 번호 , 플레이 횟수]
            idxPlay.put(i,plays[i]);
        }
        //playNum의 value Max key값 도출 -> playNum을 Value값 기준으로 내림차순 정렬 후 위 2개만 사용
        List<String> keySet = new ArrayList<>(playNum.keySet());
        //Collections.sort(valSet,Collections.reverseOrder());
        keySet.sort(((o1, o2) -> playNum.get(o2).compareTo(playNum.get(o1))));
        for(String key : keySet){
            System.out.println("Key : " + key);
            System.out.println("Value : " + playNum.get(key));
        }

        return answer;
    }

    public int[] solution2(String[] genres, int[] plays) {
        int[] answer = {};
        HashMap<String, Integer> num = new HashMap<>();
        HashMap<String, HashMap<Integer, Integer>> music = new HashMap<>();
        HashMap<Integer, Integer> temp = new HashMap<>();
        for(int i = 0; i < genres.length; i++){
            if(!num.containsKey(genres[i])){
                temp.put(i,plays[i]);
                music.put(genres[i],temp);
                num.put(genres[i],plays[i]);
            }
            else{
                music.get(genres[i]).put(i,plays[i]);
                num.put(genres[i],num.get(genres[i]) + plays[i]);
            }
        }

        List<String> keySet = new ArrayList<>(num.keySet());
        Collections.sort(keySet,(s1,s2) -> num.get(s2) - num.get(s1));

        for(String key : keySet){

        }
        return answer;
    }
}
