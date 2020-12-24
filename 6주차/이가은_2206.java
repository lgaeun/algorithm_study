package graph;
import java.io.*;
import java.util.*;

public class _2206 {

	static ArrayList<Integer> walls = new ArrayList<>(); 
	static int[][] graph;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int n,m;
	
	//main
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n  = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		graph = new int[n][m];
		visited = new boolean[n][m];
		
		//graph와 벽의 위치 저장 
		for(int i = 0; i < n; i++) {
			String s= br.readLine();
			for(int j = 0; j < m; j++) {
				graph[i][j] = s.charAt(j)-'0';	
				if(graph[i][j] == 1) 
					walls.add(m*i+j);
			}
		}
		
		System.out.print(bfs(0,0));
	}
	
	static int bfs(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(0,0));
		visited[x][y] = true;
	
		int count = 0;
		for(int wall : walls) {
			graph[wall/m][wall%m] = 0;	//벽 하나씩 부시기 
		
			while(!q.isEmpty()) {
				Point p = q.poll();
				if(p.x == n && p.y == m) return count;
				
				count++;
				
				for(int i = 0; i < 4; i++) {	
					int nx = p.x + dx[i];			
					int ny = p.y + dy[i];
				
					if(nx>=0 && nx<n && ny>=0 && ny<m) {
						if(!visited[nx][ny] && graph[nx][ny] == 0) {  // 주변 = 0 인경우에만 갈 수 있음 
							q.offer(new Point(nx, ny));
							visited[nx][ny] = true;
						}
					}
				}
			}
			graph[wall/m][wall%m] = 1; //다시 벽 되돌려놓기 
		}
		
		return -1;
		
	}
	
	static class Point{
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}

/*
 * 벽 하나씩 다 부시는거 비효율적인 거 같음
 */