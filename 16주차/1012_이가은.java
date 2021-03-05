import java.io.*;
import java.util.*;
public class Main {
	
	static int[][] map;
	static int w,h;
	static boolean[][] visit;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");
		int t = Integer.parseInt(br.readLine());
		
		while(t-- > 0) {
			String[] input = br.readLine().split(" ");
			
			w = Integer.parseInt(input[0]);
			h = Integer.parseInt(input[1]);
			int num = Integer.parseInt(input[2]);
			
			map = new int[h][w];
			visit = new boolean[h][w];
			
			for(int i = 0; i < num; i++) {
				input = br.readLine().split(" ");
				int x = Integer.parseInt(input[0]);
				int y = Integer.parseInt(input[1]);
				map[y][x] = 1;		//입력 -> map 주의
			}
			int count = 0;
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					if(map[i][j] == 1 && !visit[i][j]) {
						count++;
						dfs(i,j);
					}
				}
			}sb.append(count+"\n");
		}
		System.out.println(sb);
	}
  
	static void dfs(int x, int y) {
		visit[x][y] = true;
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >= h || nx < 0  || ny >= w || ny < 0) continue;
			if(!visit[nx][ny] && map[nx][ny] == 1) 
				dfs(nx,ny);
		}
	}
}
