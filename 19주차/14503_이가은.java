import java.util.*;
import java.io.*;

public class Main{
	
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[][] map;
	static int cnt=1;

	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String[] len = br.readLine().split(" ");
    	int r = Integer.parseInt(len[0]); 
    	int c = Integer.parseInt(len[1]); 
    	
    	String[] p = br.readLine().split(" ");	//청소기의 위치 
    	int x = Integer.parseInt(p[0]);
    	int y = Integer.parseInt(p[1]);
    	int d = Integer.parseInt(p[2]);
    	
        map = new int[r][c];
        
        for(int i = 0; i < r; i++) {
        	String[] in = br.readLine().split(" ");
        	for(int j = 0; j < c; j++) map[i][j] = Integer.parseInt(in[j]);	
        }
        dfs(x,y,d);
        System.out.println(cnt);
    }
	
	 static void dfs(int x, int y, int d) { 
	 	map[x][y] = 2; // 청소했음표시 
		int dir = d;
		for(int i = 0; i < 4; i++) {
			dir = (dir+3)%4;
			int nx = dx[dir] + x;
			int ny = dy[dir] + y;
			 
			if(map[nx][ny] == 0) { 
				cnt++;
				dfs(nx, ny, dir);
				return;
			 }
		 }
		// 여기까지 왔다는 건 네 방향 다 갈 수 없다는 의미이므로, 뒤가 벽이 아니면 후진 
		int nx = x - dx[d];
		int ny = y - dy[d];
		if(map[nx][ny] != 1) {
			dfs(nx, ny, d);
		}
	 }	 
}


