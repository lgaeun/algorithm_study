import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = {-2,-1,1,2,-1,-2, 1, 2};
	static int[] dy = {-1,-2,2,1, 2, 1,-2,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int Tcase  = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < Tcase; i++) {
			int n = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int ex = Integer.parseInt(st.nextToken());
			int ey = Integer.parseInt(st.nextToken());
			
			bw.write(search(n,sx,sy,ex,ey)+"\n");
		}
		bw.flush();
		bw.close();	
	}
	static int search(int n, int x, int y,int ex, int ey) {
		int[][] visit = new int[n][n];
		for(int j = 0; j < n; j++) Arrays.fill(visit[j], -1);
		visit[x][y] = 0;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x,y});
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			if(cur[0] == ex && cur[1] == ey) break;
			for(int i = 0; i < 8; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				if(nx >= 0 && nx < n && ny >= 0 && ny < n && visit[nx][ny] == -1) {
					visit[nx][ny] = visit[cur[0]][cur[1]] + 1;
					q.add(new int[] {nx,ny});	
				}
			}	
		}
		return visit[ex][ey];
	}
}
