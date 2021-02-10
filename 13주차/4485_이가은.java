import java.io.*;
import java.util.*;

public class Main {
	
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static StringBuilder sb = new StringBuilder("");

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int cnt = 1;
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n==0) break;
			
			map = new int[n][n];
			visit = new boolean[n][n];
			
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			go(0,0,n,cnt);
			cnt++;
		}
		System.out.print(sb.toString());
	}
	static void go(int x, int y, int n, int cnt) { 
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(x,y));  //start node 
		visit[x][y] = true;
		int INF = Integer.MAX_VALUE;
		int dist[][] = new int[n][n];  //최단거리 
		for(int[] row : dist) {
			Arrays.fill(row, INF);	//거리 무한으로 초기화 
		}
		dist[x][y] = map[x][y];
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			for(int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if(nx<0 || nx>=n || ny<0 || ny>=n) continue;
				if(visit[nx][ny]) continue;
				
				if(dist[nx][ny] > dist[cur.x][cur.y] + map[nx][ny]) {
					dist[nx][ny] = dist[cur.x][cur.y] + map[nx][ny];
					pq.add(new Node(nx,ny));
				}
			}
		}
		sb.append("Problem "+Integer.toString(cnt)+": "+Integer.toString(dist[n-1][n-1])+"\n");
	}
	static class Node implements Comparable<Node>{
		public int x,y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(Node o) {
			return map[this.x][this.y] - map[o.x][o.y];
		}
	}	

}
