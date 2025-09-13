package problems.java.beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Beakjun11724_연결요소의개수 {
    static boolean[] visited;
    static List<List<Integer>> graph;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int result = 0;

        graph = new ArrayList<>();
        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        visited = new boolean[N + 1];
        Arrays.fill(visited, false);

        for(int i = 1; i <= N; i++){
            if(!visited[i]){
                dfs(i);
                result++;
            }
        }
        System.out.println(result);
    }
    private static void dfs(int now){
        if(visited[now]) return;

        visited[now] = true;

        for(int next : graph.get(now)){
            if(!visited[next]) dfs(next);
        }
    }
}
