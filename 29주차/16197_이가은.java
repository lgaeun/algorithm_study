package week29;

import java.io.*;
import java.util.*;

public class _16197 {
	
	static char[][] map;
	static int r, c, cnt = 11;
	static int[] dx = {0,0,-1,1}, dy = {-1,1,0,0};
	static ArrayList<int[]> coins = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		map = new char[r][c];
		for(int i = 0; i < r; i++) {
			String line = br.readLine();
			for(int j = 0; j < c; j++) {
				map[i][j] = line.charAt(j);
				if(map[i][j] == 'o') coins.add(new int[] {i,j});
			}
		}
		move(coins.get(0), coins.get(1), 0);
		
		if(cnt == 11) System.out.println("-1");
		else System.out.println(cnt);
	}
	
	static void move(int[] front, int[] back, int depth) {
		if(depth == 10) return;
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 2; j++) { 
				int[] c = coins.get(j);
				int nx = c[0] + dx[i];
				int ny = c[1] + dy[i];
				if(!check(new int[] {nx,ny}) && map[nx][ny] == '#') continue; //벽이면 그대로, 
				else { //벽이 아니면 이동 
					coins.get(j)[0] = nx; 
					coins.get(j)[1] = ny;
				}
			}
			
			if((check(coins.get(0)) && !check(coins.get(1))) || (check(coins.get(1))) && !check(coins.get(1))) {
				cnt = Math.min(cnt, depth+1);
				return;
			}
		}
	
	}
	
	static boolean check(int[] xy) {
		return (xy[0] < 0 || xy[0] >= r || xy[1] < 0 || xy[1] >= c);
	}

}
