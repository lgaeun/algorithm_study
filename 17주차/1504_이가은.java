import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge>{
	public int v; 
	public long w;
	public Edge(int v, long dist) {
		this.v = v;
		this.w = dist;
	}
	@Override
	public int compareTo(Edge o) {
		return w < o.w? -1 : 1;
	}
}

public class _1753 {
	static final long INF = 2000000000;
	static long[] dist;	
	static ArrayList<Edge>[] graph;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());

		dist = new long[n+1];
		Arrays.fill(dist, INF);
		
		graph = new ArrayList[n+1];
	   	for (int i = 1; i <= n; i++) graph[i] = new ArrayList<Edge>();
		
		for(int i = 0; i < e; i++) {	
	    	st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph[u].add(new Edge(v,w));
			graph[v].add(new Edge(u,w)); //양방향 인접리스트 
	  	  }
		
		st = new StringTokenizer(br.readLine());	//반드시 거쳐야하는 정점들 
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		long res1 = dijkstra(1, a);		// 1->a->b->n
		res1 += dijkstra(a,b);
		res1 += dijkstra(b,n);
		
		long res2 = dijkstra(1, b);		// 1->b->a->n
		res2 += dijkstra(b,a);
		res2 += dijkstra(a,n);
		
		long answer = (res1>=INF && res2>=INF) ? -1 : Math.min(res1, res2);	// INF가 2000000000이기 때문에 res1,res2의 크기를 long
		System.out.println(answer);	
	}
	
	static long dijkstra(int start, int end) {
		Arrays.fill(dist, INF);
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		dist[start] = 0; //시작점-시작점 거리는 0
		pq.add(new Edge(start, 0));
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
	
			for(Edge next: graph[cur.v]) {
				if(dist[next.v] > dist[cur.v] + next.w) {
					dist[next.v] = dist[cur.v] + next.w;
					pq.add(new Edge(next.v, dist[next.v]));
				}
			}
		}
		return dist[end];
	}
}
