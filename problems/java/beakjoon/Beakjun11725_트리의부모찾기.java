package problems.java.beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Beakjun11725_트리의부모찾기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int node = Integer.parseInt(st.nextToken());

        List<List<Integer>> tree = new ArrayList<>();
        for(int i = 0; i <= node; i++){
            tree.add(new ArrayList<>());
        }

        boolean[] visited = new boolean[node + 1];
        int[] parents = new int[node + 1];

        for(int i = 0; i < node; i++){
            st = new StringTokenizer(br.readLine());

        }
    }
}
