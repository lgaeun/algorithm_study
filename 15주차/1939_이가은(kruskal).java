import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {
	static class Edge implements Comparable<Edge> {
		int u,v,weight;

		Edge(int u, int v, int weight){
			this.u = u; this.v = v; this.weight = weight;
		}
		
		public int compareTo(Edge o) {
			if(this.weight < o.weight) return -1;
			else if (this.weight == o.weight) return 0;
			else return 1;
		}
	}
	static void union(int v1, int v2) {
		v1 = find(v1);
		v2 = find(v2);
		parent[v2] = v1;
	}
	static int find(int v) {
		if(v == parent[v]) return v;
		return parent[v] = find(parent[v]);
	}
    static int[] parent;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		ArrayList<Edge> list = new ArrayList<>(); 
		
		parent = new int[n+1];
		for(int i = 1; i <= n; i++) parent[i] = i;
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list.add(new Edge(x,y,w));
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		Collections.sort(list); 	//중량을 기준으로 정렬
		
		//Kruskal
		int cost = 0;
		for(Edge edge: list) {
			union(edge.u, edge.v); 
			if(find(start) == find(end)) cost = edge.weight;	
		}
		System.out.println(cost);
	}

}
