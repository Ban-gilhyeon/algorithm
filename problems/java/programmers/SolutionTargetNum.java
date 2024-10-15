package problems.java.programmers;
import java.util.LinkedList;
import java.util.Queue;
public class SolutionTargetNum {
    int answer;
    int [] numbers;
    int target;
    public void dfs(int index, int sum){
        //탈출
        if(index == numbers.length){
            if(sum == target) answer ++;
            return;
        }
        //수행
        dfs(index+1,sum + numbers[index]);
        dfs(index+1, sum - numbers[index]);

    }
    public int solution(int [] numbers, int target){
        this.numbers = numbers;
        this.target = target;
        dfs(0,0);

        return answer;
    }

    public int bfs(int target){
        int start = 0;
        int answer = 0;
        Queue<Integer> que = new LinkedList<>();
        int size = numbers.length;
        que.add(start);
        for(int i = 0; i < size; i++){
            int len = que.size();
            for(int j = 0; j < len; j++){
                int val = que.remove();

                que.add(val + numbers[i]);
                que.add(val - numbers[i]);
            }
        }

        while(!que.isEmpty()){
            int val = que.remove();
            if(val == target) answer++;
        }
        return answer;
    }

    public int solutionBfs(int [] numbers, int target ){
        this.numbers = numbers;
        this.target = target;
        int answer = bfs(target);
        return answer;
    }
}
