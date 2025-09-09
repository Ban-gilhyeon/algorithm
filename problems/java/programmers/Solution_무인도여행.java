package problems.java.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution_무인도여행 {
    private static int dfs(int x, int y, List<List<Integer>> map, boolean[][] visited){
        if(map.get(y).get(x) == -1) return 0;
        if( y < 0 || y >= map.size() || x < 0 || x >= map.get(y).size()) return 0;
        if(visited[y][x]) return 0;

        int sum = map.get(y).get(x);
        visited[y][x] = true;

        int[] dy = {1, 0, 0, -1};
        int[] dx = {0, 1, -1, 0};
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny >= 0 && ny < map.size() && nx >= 0 && nx <map.get(ny).size()) sum += dfs( nx,ny, map, visited);
        }
        return sum;
    }

    public static void main(String[] args) {
        List<Integer> answer = new ArrayList<>();
        String[] strArr = {"X591X","X1X5X","X231X", "1XXX1"};
        List<List<Integer>> map = new ArrayList<>();
        boolean[][] visited = new boolean[strArr.length][];

        for(int i = 0; i < strArr.length; i++){
            map.add(new ArrayList<>());
            char[] chars = strArr[i].toCharArray();
            visited[i] = new boolean[chars.length];
            Arrays.fill(visited[i], false);
            for(char c : chars){
                if(c == 'X'){
                    map.get(i).add(-1);
                }else{
                    map.get(i).add(c - '0');
                }
            }
        }
        for(int i = 0; i < map.size(); i++){
            for(int j = 0; j < map.get(i).size(); j++){
                if(map.get(i).get(j) != -1 && !visited[i][j]){
                    answer.add(dfs(j,i,map,visited));
                }
            }
        }
        if(answer.isEmpty()) answer.add(-1);
        else Collections.sort(answer);

        System.out.println(answer.size());
        for(int i = 0; i <answer.size(); i++){
            System.out.print(answer.get(i) + ", ");
        }
        for(int i = 0; i < map.size(); i++){
            System.out.println("");
            for(int j = 0; j < map.get(i).size(); j++){
                System.out.print(map.get(i).get(j) + ", ");
            }
        }
    }
}
