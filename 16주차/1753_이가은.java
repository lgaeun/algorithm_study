import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge>{
	public int v,w;
	public Edge(int v, int w) {
		this.v = v;
		this.w = w;
	}
	@Override
	public int compareTo(Edge o) {
		return w - o.w;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		
		boolean[] visit = new boolean[n+1];
		int[] dist = new int[n+1];
		Arrays.fill(dist, Integer.MAX_VALUE); // INF로 초기화 
		
		ArrayList<Edge>[] graph = new ArrayList[n+1];
	    for (int i = 1; i <= n; i++) graph[i] = new ArrayList<Edge>();
		
		while(!st.hasMoreElements()) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph[u].add(new Edge(v,w));
		}
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		dist[start] = 0; //시작점-시작점 거리는 0
		pq.offer(new Edge(start, 0));
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			
			if(visit[cur.v] == true) continue;
			visit[cur.v] = true;
		
			for(Edge next: graph[cur.v]) {
				if(dist[next.v] > dist[cur.v] + next.w) {
					dist[next.v] = dist[cur.v] + next.w;
					pq.add(new Edge(next.v, dist[next.w]));
				}
			}
		}
		for(int i = 1; i <= n; i++) {
			if(dist[i] != Integer.MAX_VALUE) 
				sb.append(dist[i]+"\n");
			else sb.append("INF");
		}
		System.out.println(sb);
	}
}
