package problems.java.programmers;

import java.util.*;

public class Solution_전력망둘로나누기 {
    public static void main(String[] args) {

        int [][] wires = {{1,2}, {2,7}, {3,7}, {3,4}, {4,5}, {6,7}};
        int n = 7;
        int answer = Integer.MAX_VALUE;
        List<Set<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            graph.add(new HashSet<>());
        }

        for(int[] wire : wires){
            int a = wire[0];
            int b = wire[1];

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        boolean[] visited = new boolean[n + 1];
        Arrays.fill(visited, false);

        int cnt = 0;
        for(int i = 0; i < wires.length; i++){
            int a = wires[i][0];
            int b = wires[i][1];

            graph.get(a).remove((Integer) b);
            graph.get(b).remove((Integer) a);

            cnt = dfs(a, visited, graph);

            graph.get(a).add(b);
            graph.get(b).add(a);

            answer = Math.min(answer, Math.abs(n - 2 * cnt));
            Arrays.fill(visited,false);
        }
        System.out.println(answer);
    }

    private static int dfs(int start, boolean[] visited, List<Set<Integer>> graph){
        if(visited[start]) return 0;

        visited[start] = true;
        int cnt = 1;

        for(int next : graph.get(start)){
            cnt += dfs(next, visited, graph);
        }
        return cnt;
    }
}
