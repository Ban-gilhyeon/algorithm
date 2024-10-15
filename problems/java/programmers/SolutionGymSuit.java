package problems.java.programmers;

public class SolutionGymSuit {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int [] arr = new int[n];

        for(int i : reserve){
            arr[i] = 2;
        }
        for(int i : lost){
            if(arr[i] == 2){
                arr[i] =1;
            }
            else arr[i] = 0;
        }

        return answer;
    }
}
