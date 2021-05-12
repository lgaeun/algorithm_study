package week25;

import java.io.*;
import java.util.*;

class XY{
    int x, y, dist, drill; //거리, 벽 부순 횟수 
    public XY(int x, int y, int dist, int drill){
        this.x = x; 
        this.y = y;
        this.dist = dist;
        this.drill = drill;
    }
}

public class _15685 {
	static int[][] map, visit;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static int n,m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	map = new int[n][m];
    	visit = new int[n][m];
    	
    	for(int i = 0; i < n; i++) {
    		String str = br.readLine();
    		for(int j = 0; j < m; j++) {
    			map[i][j] =  str.charAt(j)-'0';
    		}
    	}
    	
    	System.out.println(bfs(0,0));
	}
	static int bfs(int x, int y) {
		visit[x][y] = 0;
		Queue<XY> q = new LinkedList<>();
		q.add(new XY(x,y,0,0));
		
		while(!q.isEmpty()) {
			XY cur = q.poll();
			
			if(cur.x == n-1 && cur.y == m-1) { 
				return cur.dist;
			}
			
			for(int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if(nx<0 || nx>= n || ny < 0 || ny >= m) continue;
				if(visit[nx][ny] <= cur.drill) continue;
					
				if(map[nx][ny] == 0) { //벽이 아닐 때 
					visit[nx][ny] = cur.drill;
					q.add(new XY(nx,ny,cur.dist+1, cur.drill));
				}else {
					if(cur.drill == 0) { // 벽인데, 한 번도 안부쉈다면 
						visit[nx][ny] = cur.drill +1;
						q.add(new XY(nx,ny, cur.dist+1, cur.drill+1));
					}
				}
			}
		}
		
		return -1;
	}

}
