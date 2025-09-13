package problems.java.beakjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Beakjun11725_트리의부모찾기 {
    static boolean[] visited;
    static int[] parents;
    static List<List<Integer>> tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int node = Integer.parseInt(st.nextToken());

        tree = new ArrayList<>();
        for(int i = 0; i <= node+1; i++){
            tree.add(new ArrayList<>());
        }

        visited = new boolean[node + 1];
        parents = new int[node + 1];

        for(int i = 0; i <node -1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        for(int i = 1; i <= node; i++){
            if(!visited[i]){
                dfs(i);
            }
        }
        for(int i = 2; i <= node; i++){
            System.out.println(parents[i]);
        }
    }

    private static void dfs(int now){
        if(visited[now]) return;

        visited[now] = true;
        for(int next : tree.get(now)){
            if(!visited[next]){
                parents[next] = now;
                dfs(next);
            }
        }
    }
}
