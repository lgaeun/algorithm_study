import java.util.*;
import java.io.*;

public class Main{
	
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static int[][] map;
	static boolean[][] visit;
	static int n, min = 999999999;

	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visit = new boolean[n][n];
        
        for(int i = 0; i < n; i++) {
        	String[] in = br.readLine().split(" ");
        	for(int j = 0; j < n; j++) 
        		map[i][j] = Integer.parseInt(in[j]);	
        } 
       go(1,0,0);
       System.out.println(min);
    }
	static void go(int row, int depth, int sum) {
		if(depth == 3) {
			min = Math.min(min, sum);
			return;
		}
		for(int i = row; i < n-1; i++) {	//가장자리는 볼 필요 없으므로 
			for(int j = 1; j < n-1; j++) {
				if(visit[i][j] == true) continue;
				
				int tmp_cost = check(i,j);
				if(tmp_cost == -1) continue;
				
				visit[i][j] = true;
				for(int k = 0; k < 4; k++) visit[dx[k]+i][dy[k]+j] = true;
				
				go(i, depth+1, sum+tmp_cost);
				
				visit[i][j] = false;
				for(int k = 0; k < 4; k++) visit[dx[k]+i][dy[k]+j] = false;
			}
		}
	}
	 static int check(int x, int y) {
		 int cost = map[x][y]; 
		 for(int i = 0; i < 4; i++) {
			int nx = dx[i] + x;
     		int ny = dy[i] + y;
     		if(nx < 0 || nx >= n || ny < 0 || ny >=n || visit[nx][ny]) 
     			return -1;
     		else 
     			cost += map[nx][ny];
		 }
		 return cost; // 심을 수 없으면 -1, 있으면 cost를 반환
	 }
}