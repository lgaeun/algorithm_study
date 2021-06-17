package week29;

import java.io.*;
import java.util.*;

public class _3055 {
	
	static char[][] map;
	static int r, c;
	static int[] dx = {0,0,-1,1}, dy = {-1,1,0,0};
	static Queue<int[]> hedge = new LinkedList<>();
	static Queue<int[]> water = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		int time = 0;
		
		map = new char[r][c];
		for(int i = 0; i < r; i++) {
			String line = br.readLine();
			for(int j = 0; j < c; j++) {
				map[i][j] = line.charAt(j);
				if(map[i][j] == '*') water.add(new int[] {i,j});
				if(map[i][j] == 'S') hedge.add(new int[] {i,j});
			}
		}
		
		while(true) {
			time++;
			moveWater();
			if(moveHedge()) {
				System.out.println(time);
				break;
			}
			if(hedge.size() == 0) { 
				System.out.println("KACTUS");
				break;
			}
		}
	
	}
	
	static void moveWater() {
		int size = water.size();
		
		for(int i = 0; i < size; i++) { //퍼져간 물의 크기만큼 반복 
			int[] cur = water.poll();
			
			for(int j = 0; j < 4; j++) {
				int nx = cur[0] + dx[j];
				int ny = cur[1] + dy[j];
				
				if(nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
				if(map[nx][ny] == '.' || map[nx][ny] == 'S') { //돌이나 도착지가 아니면 이동할 수 있음.
					map[nx][ny] = '*';
					water.add(new int[] {nx,ny});
				}
			}
		}
		
	}
	//true: 도착함, false: 절대 도착할 수 없음 
	static boolean moveHedge() {
		int size = hedge.size();
		
		for(int i = 0; i < size; i++) { //두더지가 이동할 수 있는 경로만큼 반복 
			int[] cur = hedge.poll();
			
			for(int j = 0; j < 4; j++) {
				int nx = cur[0] + dx[j];
				int ny = cur[1] + dy[j];
				
				if(nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
				if(map[nx][ny] == 'D') {
					hedge.add(new int[] {nx,ny});	//물이 다 퍼졌지만 도착한 경우(hedge.size 가 1이어야 함) 
					return true;
				}
				if(map[nx][ny] == '.') {
					map[nx][ny] = 'S';
					hedge.add(new int[] {nx,ny});
				}
			}
		}
		return false;
	}

}
