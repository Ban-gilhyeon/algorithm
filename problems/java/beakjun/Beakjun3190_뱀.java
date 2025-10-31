package problems.java.beakjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Beakjun3190_뱀 {
    public static void main(String[] args) throws IOException {
        Integer[] head = new Integer[2];
        Integer[] tail = new Integer[2];
        int size = 2;
        tail[0] = 0;
        tail[1] = 0;
        head[0] = 0;
        head[1] = 0;
        int dir = 0;

        //1.map 배열 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        for(int i = 0; i < N; i++){
            Arrays.fill(map[i],0);
        }
        map[0][0] = -1;

        //2. 사과 좌표에 사과 선언
        int apple = Integer.parseInt(br.readLine());
        for(int i = 0; i < apple; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            //맵이 0,0 시작이기 때문에 좌표 값 맞추기
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;

            map[y][x] = 1;
        }


        //3. 뱀의 방향 변환 횟수
        int L = Integer.parseInt(br.readLine());
        Map<Integer,String> movements = new HashMap<>();
        // 정수 X 초 뒤에 문자 C (왼쪽 L, 오른쪽 D ) 90도 방향 회전
        for(int i = 0; i < L; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            String c = st.nextToken();
            movements.put(x, c);
        }


        //4. 방향 횟수를 근거로 시뮬레이션
        int time = 0;
        int[] dy = {0, 1, 0, -1}; // 동, 남, 서, 북
        int[] dx = {1, 0, -1, 0};
        Queue<Integer[]> que = new LinkedList<>();
        que.add(tail);
        while(true) {
            int ny = head[0] + dy[dir];
            int nx = head[1] + dx[dir];
            //머리가 벽(밖으로)에 닿으면 끝
            if (ny < 0 || ny >= N || nx < 0 || nx >= N) {
                time++;
                break;
            }
            //머리가 꼬리나 몸을 물면 끝
            if (map[ny][nx] == -1) {
                time++;
                break;
            }

            //사과면 길이 증가
            if(map[ny][nx] == 1) size++;
            else{
                Integer[] temp = que.poll();
                map[temp[0]][temp[1]] = 0;
            }

            map[ny][nx] = -1;
            que.add(new Integer[]{ny, nx});
            time++;
            head[0] = ny;
            head[1] = nx;

            //해당하는 시간에 명령이 있다면 명령 받기
            if(movements.containsKey(time)){
                switch (movements.get(time)){
                    case "D" : {
                        dir = (dir + 1) % 4;
                        break;
                    }
                    case "L" : {
                        dir = (dir + 3) % 4;
                        break;
                    }
                }
            }
        }
        System.out.println(time);
    }
}


