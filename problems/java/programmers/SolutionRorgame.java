package problems.java.programmers;

import java.util.LinkedList;
import java.util.Queue;
public class SolutionRorgame {
    int [][] maps;
    int [][] visit;

    //2. 이동이 가능한 곳으로 이동
    public boolean check(int y, int x){
        //양 벽일 때
        if(y < 0 || y > maps.length - 1 || x < 0 || x > maps[0].length - 1 ){
            return false;
        }
        //maps에서 벽일 때
        if(maps[y][x] == 0){
            return false;
        }
        //길일 때만 true
        if(visit[y][x] == 1) return false;
        return true;
    }
    public int bfs(){
        int qx = 0;
        int qy = 0;
        int qcnt = 0;
        visit = new int[maps.length][maps[0].length];

        Queue<int[]> now = new LinkedList<>();
        Queue<Integer>qc = new LinkedList<>();
        now.add(new  int[]{qy,qx});
        qc.add(1);

        while(!now.isEmpty()){
            int cx = now.peek()[1];
            int cy = now.peek()[0];
            int cc = qc.peek();
            now.remove();
            qc.remove();

            if(visit[cy][cx] == 1) continue;
            visit[cy][cx] = 1;

            //목적지 도착
            if(cy == maps.length -1  && cx == maps[0].length -1 ){
                return cc;
            }
            //상
            if(check(cy -1, cx)) {
                now.add(new int[]{cy-1,cx});
                qc.add(cc+1);
            }
            //하
            if(check(cy+1, cx)){
                now.add(new int[]{cy+1,cx});
                qc.add(cc+1);
            }
            //좌
            if(check(cy,cx-1)){
                now.add(new int[]{cy,cx-1});
                qc.add(cc+1);
            }
            //우
            if(check(cy,cx+1)){
                now.add(new int[]{cy,cx+1});
                qc.add(cc+1);
            }
        }
        return -1;
    }
    public int solution(int[][] maps) {
        // maps = 1, 이동가능 = 0, 벽
        int answer= 0;
        this.maps = maps;
        // 1. 목적지 까지 도달할 수 있는 맵인지 확인
        answer = bfs();
        return answer;
    }
}
