import java.io.*;
import java.util.*;

public class _2468 {
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static int[][] map;
	static boolean[][] visit, visit_tmp;
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		int max_rain = 0;
		int ans = 0;
		
		map = new int[n][n];
		visit = new boolean[n][n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(max_rain < map[i][j]) {
					max_rain = map[i][j];
				}
			}
		}
		
		// 아무지역도 물에 잠기지 않을 수 있다(비가 안 올 때)
		for(int k = 0; k <= max_rain; k++) {
			int area = 0;
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(map[i][j] == k)
						visit[i][j] = true; // 1. 비에 잠긴 부분 visit true 처리 
				}
			} 
			
			visit_tmp = deepCopy(visit); //2. visit 배열의 값만 복사 
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(map[i][j] > k && !visit_tmp[i][j]) {
						dfs(i,j,k);         //3. dfs한 개수만큼 area 더하기 
						area += 1; 
					}
				}
			}
			ans = Math.max(ans, area);
		}	
		System.out.println(ans);	
	}
  
	static void dfs(int x, int y, int rain) { // visit_tmp에 visit 처리
		visit_tmp[x][y] = true;
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx<0 || nx>=n || ny<0 || ny>=n) continue;
			if(!visit_tmp[nx][ny] && map[nx][ny] > rain)
				dfs(nx,ny,rain);
		}
	}
	
	static boolean[][] deepCopy(boolean[][] a){
		int n = a.length;
		boolean[][] res = new boolean[n][n];
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				res[i][j] = a[i][j];
	
		return res;
		
	}
	
}
