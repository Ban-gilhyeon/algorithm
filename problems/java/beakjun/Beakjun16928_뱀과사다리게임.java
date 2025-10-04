package problems.java.beakjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Beakjun16928_뱀과사다리게임 {
    public static void main(String[] args) throws IOException {
        int[] map = new int[101];
        boolean[] visited = new boolean[101];
        int[] answers = new int[101];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int ladders = Integer.parseInt(st.nextToken());
        int snakes = Integer.parseInt(st.nextToken());
        Arrays.fill(map, 0);
        Arrays.fill(visited, false);

        for(int i = 0; i < ladders; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            map[from] = to;
        }

        for(int i = 0; i < snakes; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            map[from] = to;
        }
        Queue<Integer> que = new LinkedList<>();
        que.add(0);
        int min = Integer.MAX_VALUE;
        int dice = 0;
        int answer = 0;

        while(!que.isEmpty()){
            int now = que.poll();
            for(int i = 1; i <= 6; i++){
                int next = now + i;
                if (next > 100) continue;
                if(map[next] != 0) next = map[next];
                if(!visited[next]){
                    visited[next] = true;
                    answers[next] = answers[now] + 1;
                    que.add(next);
                }
            }
        }
        System.out.println(answers[100]);



    }
}

