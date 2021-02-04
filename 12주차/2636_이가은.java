import java.io.*;
import java.util.*;

public class Main {
	
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int h,w, cheeze, hour, cnt;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		map = new int[h][w];
		
		for(int i = 0; i < h; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < w; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1) 
					cheeze++; //전체 치즈 개수 세기
			}
		}

		while(cheeze!=0) {
			hour++;
			cnt = cheeze; // 남아있는 치즈 개수 
			bfs();	//가장자리 치즈 찾아내서 녹이기 
		}
		System.out.println(hour+"\n"+cnt);	
	}
	
	static void bfs() {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(0,0));
		visit = new boolean[h][w];	//탐색한 부분 표시(공기, 가장자리 치즈 표시) 
		visit[0][0] = true;
		while(!q.isEmpty()) {
			Pair idx = q.poll();
			for(int i = 0; i < 4; i++) {
				int nx = idx.x+ dx[i];
				int ny = idx.y+ dy[i];	
				if( nx<0 || nx>=h || ny<0 || ny>=w || visit[nx][ny])	
					continue;
				
				if(map[nx][ny] == 1) {
					map[nx][ny] = 0;	//치즈 녹이기 
					cheeze--;
				}
				else if(map[nx][ny] == 0) {
					q.offer(new Pair(nx,ny));
				}
				visit[nx][ny] = true;
			}
		}
	}
	
	static class Pair{
		private int x,y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
}