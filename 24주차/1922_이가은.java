import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge>{
	int v, cost;
	public Edge(int v, int cost) {
		this.v = v;
		this.cost = cost;
	}
	@Override
	public int compareTo(Edge o) {
		return cost - o.cost;
	}
}
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int ans = 0, cnt = 0;
		
		boolean[] visit = new boolean[N];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		ArrayList<Edge>[] list = new ArrayList[N];
		for(int i = 0; i < N; i++) list[i] = new ArrayList<>();
		
		StringTokenizer st;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int cost = Integer.parseInt(st.nextToken());
			
			list[a].add(new Edge(b,cost));
			list[b].add(new Edge(a,cost));
		}//입력
		
		pq.add(new Edge(1,0)); //임의의 점부터 시작 (프림 알고리즘)
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			if(visit[edge.v]) continue;
			visit[edge.v] = true;
			
			ans += edge.cost;
			for(Edge next: list[edge.v]) {
				if(!visit[next.v]) 
					pq.add(next);
			}
			if(++cnt == N) break;
		}
		System.out.println(ans);
	}

}
