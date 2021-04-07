import java.util.*;
import java.io.*;

public class Main{
	
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};

	static int[][] visit, map;
	static int n,m,max;

	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	n = Integer.parseInt(st.nextToken()); 
    	m = Integer.parseInt(st.nextToken());
    	
    	visit = new int[n][m];
    	map = new int[n][m];
    	
    	for(int i =0; i < n; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 0; j < m; j++)
    			map[i][j] = Integer.parseInt(st.nextToken()); 
    	} //입력 

    	for(int i = 0; i < n; i++) {
    		for(int j = 0; j < m; j++) {
    			check_else(i,j);	//ㅜ에 대해 check
    			dfs(i,j,0,0); 		//나머지 모양들에 대해 check 
    		}
    	}
    	System.out.println(max);
	}
	
	static void dfs(int x, int y, int sum, int length) { 
		if(length == 4) {
			max = Math.max(max, sum);
			return;
		}
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx<0 || nx>=n || ny<0 || ny>=m || visit[nx][ny] == 1) continue;
			
			visit[nx][ny] = 1;
			dfs(nx,ny,sum+map[nx][ny], length+1);
			visit[nx][ny] = 0;
		}
	}
	static void check_else(int x, int y) { // 이 코드 비효율적임,,
		int sum = map[x][y];
		boolean flag = false; int wings = 0;
		
		for(int i = 0; i < 4; i++) {
			flag = false; // ㅜ가 네모판 위에 들어오는지 
			wings = 0;
			for(int j = 0; j < 4; j++) {
				if(j == i) continue; // 한 wing만 제외하고 
				int nx = x + dx[j];
				int ny = y + dy[j];
				if( nx<0 || nx>=n || ny<0 || ny>=m) {
					flag = true;
					break;
				}
				wings += map[nx][ny];
			}
			if(!flag) max = Math.max(max, sum + wings);
		}
	}
}
