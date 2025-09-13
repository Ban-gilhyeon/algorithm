package problems.java.beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Beakjun15686_치킨배달{
    static int N;
    static int M;
    static int [][] city;
    static boolean [][] visited;
    static int minDistance = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        city = new int[N][N ];
        visited = new boolean[N][N];

        for(int i = 0; i < visited.length; i++){
            Arrays.fill(visited[i], false);
        }

        for(int i = 0; i< N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                city[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        List<Point> houses = new ArrayList<>();
        List<Point> chickenMarkets = new ArrayList<>();
        for(int y = 0; y < N; y++){
            for(int x = 0; x < N; x++){
                if(city[y][x] == 1){
                    Point house = new Point(x,y);
                    houses.add(house);
                }
                if(city[y][x] == 2){
                    Point chickenMarket = new Point(x,y);
                    chickenMarkets.add(chickenMarket);
                }
            }
        }
        List<Point> selected = new ArrayList<>();
        combination(0, selected, chickenMarkets, houses);
        System.out.println(minDistance);

    }

    private static void combination(int start, List<Point> selected, List<Point> chickenMarkets, List<Point> houses) {
        if(selected.size() == M){
            int result = 0;
            for(Point house : houses){
                int min = Integer.MAX_VALUE;
                for(Point chicken : selected){
                    min = Math.min(min,Point.getDistance(house, chicken));
                }
                result += min;
            }
            minDistance = Math.min(minDistance, result);
            return;
        }

        for(int i = start; i < chickenMarkets.size(); i++){
            selected.add(chickenMarkets.get(i));
            combination(i + 1, selected, chickenMarkets, houses);
            selected.remove(selected.size() -1);
        }
    }


    private static class Point{
        int x;
        int y;
        int chickenDistance;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        void setChickenDistance(int distance){
            this.chickenDistance = distance;
        }
        static int getDistance(Point p1, Point p2){
            return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
        }
        int getChickenDistance(){
            return this.chickenDistance;
        }
    }
}
