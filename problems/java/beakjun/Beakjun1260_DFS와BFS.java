package problems.java.beakjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Beakjun1260_DFS와BFS {

    public static void main(String[] args) throws IOException {
        int N;
        int M;
        int start;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        boolean[] visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for(int i = 0; i <=N; i++){
            Collections.sort(graph.get(i));
        }

        GraphTraversal graphTraversal = new GraphTraversal(N, M, graph);
        List<Integer> resultDfs = graphTraversal.dfs(visited, start);
        Arrays.fill(visited,false);
        List<Integer> resultBfs = graphTraversal.bfs(visited, start);
        for(int i = 0; i < resultDfs.size(); i++){
            System.out.print(resultDfs.get(i) + " ");
        }
        System.out.println(" ");
        for(int i = 0; i < resultBfs.size(); i++){
            System.out.print(resultBfs.get(i) + " ");
        }
    }

}

class GraphTraversal{
    int N;
    int M;
    List<List<Integer>> graph = new ArrayList<>();

    public GraphTraversal(int N, int M, List<List<Integer>> graph){
        this.N = N;
        this.M = M;
        this.graph = graph;
    }

    public List<Integer> dfs(boolean[] visited, int start){
        List<Integer> result = new ArrayList<>();

        visited[start] = true;
        result.add(start);

        for(int next : graph.get(start)){
            if(!visited[next]){
                result.addAll(dfs(visited,next));
            }
        }
        return result;
    }

    public List<Integer> bfs(boolean[] visited, int start){
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);

        while(!queue.isEmpty()){
            int now = queue.poll();
            result.add(now);

            for(int next : graph.get(now)){
                if(!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
        return result;
    }
}
