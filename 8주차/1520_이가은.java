import java.util.*;
import java.io.*;

public class simple {
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0 , 1, -1};
	static int[][] map;
	static int[][] dp;
	static int n, m;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int [n][m];
		dp = new int[n][m];
		
		for(int i= 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		
		dfs(0,0);
		System.out.print(dp[n-1][m-1]);
		
	}
	
	static int dfs(int x, int y) {
		
		dp[x][y] = 0;
		
//		if(x == n-1 && y == m-1) {
//			return;
//		}
	
		for(int i =0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			//범위 안 벗어나고, 내리막이면 
			if(dp[nx][ny] >= 0) {
				if(isValid(nx,ny) && map[x][y] > map[nx][ny] && ) {	
					dp[x][y] += dfs(nx,ny);
				}
			}		
		}
		return dp[x][y];
	}
	
	static boolean isValid(int x, int y){
		if(x<0 || x>=n || y<0 || y>=m) return false;
		return true;
	}

}
