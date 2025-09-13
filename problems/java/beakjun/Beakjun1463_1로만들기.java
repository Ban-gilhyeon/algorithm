package problems.java.beakjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Beakjun1463_1로만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());

        System.out.println(bfs(x));
    }
    private static int bfs(int x){
        Queue<Integer> que = new LinkedList<>();

        que.add(x);
        int cnt = 0;

        while(!que.isEmpty()){
            int size = que.size();
            boolean[] visited = new boolean[x + 1];
            for(int i = 0; i < size; i++){
                x = que.poll();
                if(x == 1) return cnt;

                if(x % 3 == 0){
                    int temp = x / 3;
                    que.add(temp);
                }
                if(x % 2 == 0){
                    int temp = x / 2;
                    que.add(temp);
                }
                if(x != 1){
                    int temp = x -1;
                    que.add(temp);
                }
            }
            cnt++;
        }
        return cnt;
    }
}
