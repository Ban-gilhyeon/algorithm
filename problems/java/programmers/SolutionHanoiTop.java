package problems.java.programmers;
import java.util.ArrayList;
import java.util.List;
//솔직히 잘 모르겠다..
public class SolutionHanoiTop {
    private List<int[]> arr;

    public void dfs(int n, int start, int mid, int end){
        //n-1 이 mid
        // 나머지 1 start -> end
        //짝수 mid , 홀수 end
        if(n == 1) {
            arr.add(new int[]{start, end});
            return;
        }

        dfs(n-1, start ,end, mid);
        arr.add(new int[]{start, end});
        dfs(n-1,mid, start ,end);
    }
    public int [][] solution(int n){
        this.arr = new ArrayList<>();
        dfs(n,1,2,3);

        int [][] answer = new int[arr.size()][];
        for(int i = 0; i < arr.size(); i++){
            answer[i] = arr.get(i);
        }
        return answer;
    }
}
