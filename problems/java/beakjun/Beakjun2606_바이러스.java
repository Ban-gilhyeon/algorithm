package problems.java.beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Beakjun2606_바이러스 {
    static List<List<Integer>> graph;
    static boolean[] visited;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int com = Integer.parseInt(br.readLine());
        int network = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for(int i = 0; i <= com; i++){
            graph.add(new ArrayList<>());
        }
        visited = new boolean[com + 1];

        for(int i = 0; i < network; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        dfs(1);
        System.out.println(result-1);
    }

    private static void dfs(int now){

        if(visited[now]) return;
        result++;
        visited[now] = true;
        for(int next : graph.get(now)){
            if(!visited[next]){
                dfs(next);
            }
        }
    }
}
