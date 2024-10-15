package problems.java.programmers;

import java.util.*;

public class SolutionEmergencyBoat {
    //1. 보트에 제일 가벼운 한명 싣기 people[0] -> sort(people) : people[i]
    //2. limit - people <= 40 이면 40 이하의 한명을 더 실기
    //3.
    public int solution(int[] people, int limit) {
        int answer = 0;
        Integer[] arr = Arrays.stream(people).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, Collections.reverseOrder());
        for(int i =0; i < arr.length; i++){
            int flag = 0;
           for(int j = i + 1; j < arr.length; j++){
               if(arr[i] + arr[j] <= limit){
                   if(arr[i] + arr[j] == limit){
                       answer++;
                       flag = 1;
                       i++;
                       break;
                   }
                    answer++;
                    flag = 1;
                    i++;
                    break;
               }
           }
           if(flag == 0) answer++;
        }
        return answer;
    }

    public int solution2(int[] people, int limit) {
        //가장 무거운 사람과 가장  가벼운 사람이 같이 단다면?
        int answer = 0;
        int size = people.length-1;
        Arrays.sort(people);
        for(int i = 0; i <= size; i++){
            if(people[i] + people[size] <= limit){
                answer++;
                size--;

            }
            else if(i < size && people[i] + people[i+1] <= limit){
                answer++;
                i++;
            }
            else answer++;
        }
        return answer;
    }

    public int solution3(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int index = 0;

        for (int i = people.length - 1; i >= index; i--) {
            if (people[i] + people[index] <= limit) {
                index++;
                answer++;
            }
            else {
                answer++;
            }
        }

        return answer;
    }
}
