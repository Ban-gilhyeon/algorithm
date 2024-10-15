package problems.java.programmers;

import java.util.Arrays;

public class SolutionMinDelete {
    public int[] solution(int[] arr) { // 오름차순 정렬 -> 배열 0번 삭제 = 배열의 순서가 바뀌여서 실패
        Arrays.sort(arr);
        int [] answer = Arrays.copyOfRange(arr,1,arr.length);
        return answer;
    }

    public int [] solution2(int[] arr){ // Math클래스의 min 메소드 이용 -> min 값 찾고 그 인덱스 -> 빼고 배열 카피 리턴
        int min = Arrays.stream(arr).min().getAsInt();
        int answer[] = {-1};
        int cnt = 0;
        if(arr.length > 1) {
            answer = new int[arr.length - 1];
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != min) {
                    answer[cnt] = arr[i];
                    cnt++;
                }
            }
        }
        return answer;
    }
}
