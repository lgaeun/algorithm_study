package week29;

import java.io.*;
import java.util.StringTokenizer;

public class _1303 {
	
	static char[][] map;
	static boolean[][] visit;
	static int n,m;
	static int[] dx = {0,0,-1,1}, dy = {1,-1,0,0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());  m = Integer.parseInt(st.nextToken());
		map = new char[m][n];
		visit = new boolean[m][n];
		int Wcnt = 0, Bcnt = 0;
		
		for(int i = 0; i < m; i++) {
			String line = br.readLine();
			for(int j = 0; j < n; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(!visit[i][j]) {
					if(map[i][j] == 'W') Wcnt += Math.pow(dfs(i,j,'W'), 2);
					else Bcnt += Math.pow(dfs(i,j, 'B'), 2);
				}
			}
		}
		
		System.out.println(Wcnt+" "+Bcnt);

	}
	static int dfs(int x, int y, char c) {
		visit[x][y] = true;
		int count = 1;
		
		for(int i = 0; i < 4; i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			if(nx < 0 || nx >= m || ny < 0 || ny >= n || visit[nx][ny]) continue;
			if(map[nx][ny] == c) {
				visit[nx][ny] = true;
				count += dfs(nx,ny,c);
			}
		}
		return count;
	}

}
