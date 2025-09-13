package problems.java.beakjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Beakjun7569_토마토 {
	static int H; // 높이
	static int M; // 가로
	static int N; //세로
	static int[][][] box;
	static boolean[][][] visited;
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N =  Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		box = new int[H][N][M];
		visited = new boolean[H][N][M];
		for(int i = 0; i < H; i++){
			for(int j = 0; j < N; j++){
				Arrays.fill(visited[i][j],false);
			}
		}
		for(int i = 0; i < H; i++){
			for(int j = 0; j < N; j++){
				st = new StringTokenizer(br.readLine());
				for(int k = 0; k < M; k++){
					box[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}
		if(!checkBox()){
			result = bfs();
			if(!checkBox()) System.out.println(-1);
			else System.out.println(result);
		}
		else System.out.println(0);
	}

	private static void dfs(int x, int y, int z, int day){
		int[] dx = {0, 0, 1, -1, 0, 0};
		int[] dy = {1, -1, 0, 0, 0, 0};
		int[] dz = {0, 0, 0, 0, 1, -1};

		if(x < 0 || y < 0 || z < 0 || x >= M || y >= N || z >= H) return ;
		if(box[z][y][x] == -1) return ;
		if(visited[z][y][x]) return ;

		int temp = box[z][y][x];

		box[z][y][x] = 1;
		visited[z][y][x] = true;
		result++;
		for(int i = 0; i < 6; i++){
			int nx = x + dx[i];
			int ny = y + dy[i];
			int nz = z + dz[i];

			dfs(nx, ny, nz, day + 1);
		}

	}
	private static int bfs(){
		Queue<Point> queue = new LinkedList<>();
		int[] dx = {0, 0, 1, -1, 0, 0};
		int[] dy = {1, -1, 0, 0, 0, 0};
		int[] dz = {0, 0, 0, 0, 1, -1};

		for(int z = 0; z < H; z++){
			for(int y = 0; y < N; y++){
				for(int x = 0; x <M; x++){
					if(box[z][y][x] == 1){
						Point p = new Point(x,y,z);
						queue.add(p);
					}
				}
			}
		}
		int day = -1;
		while (!queue.isEmpty()){
			int size = queue.size();
			for(int i = 0; i < size; i++){
				Point now = queue.poll();
				for(int j = 0; j < 6; j++){
					int nx = now.x + dx[j];
					int ny = now.y + dy[j];
					int nz = now.z + dz[j];

					if (nx >= 0 && ny >= 0 && nz >= 0 && nx < M && ny < N && nz < H) {
						if(!visited[nz][ny][nx] && box[nz][ny][nx] == 0){
							visited[nz][ny][nx] = true;
							box[nz][ny][nx] = 1;
							Point next = new Point(nx, ny, nz);
							queue.add(next);
						}
					}
				}
			}
			day++;
		}
		return day;
	}


	private static void printBox(int[][][] box){
		for(int i = 0; i < H; i++){
			for(int j = 0; j < N; j++){
				System.out.println();
				for(int k = 0; k < M; k++){
					System.out.print(box[i][j][k] + " ");
				}
			}
		}
	}

	private static boolean checkBox(){
		for(int i = 0; i < H; i++){
			for(int j = 0; j < N; j++){
				for(int k = 0; k < M; k++){
					if(box[i][j][k] == 0) return false;
				}
			}
		}
		return true;
	}

	private static class Point{
		int x;
		int y;
		int z;

		Point(int x, int y, int z){
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
}
