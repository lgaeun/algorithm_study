import java.util.*;
import java.io.*;

class Edge{
	int usado, v;
	public Edge(int v, int usado) {
		this.usado = usado;
		this.v = v;
	}
}
public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	String[] in = br.readLine().split(" ");
    	int n = Integer.parseInt(in[0]);
    	int t = Integer.parseInt(in[1]);
    	
    	ArrayList<Edge>[] list = new ArrayList [n+1]; //mootube 간의 관계 list 
    	for(int i = 1; i <= n; i++) {
    		list[i] = new ArrayList<>();
    	}
    	
    	for(int i = 0; i < n-1; i++) {
    		String[] edge = br.readLine().split(" ");
    		int p = Integer.parseInt(edge[0]);
    		int q = Integer.parseInt(edge[1]);
    		int r = Integer.parseInt(edge[2]);	//usado
    		list[p].add(new Edge(q, r));  //방향없는 그래프니까 양쪽에 넣음
    		list[q].add(new Edge(p, r));
    	}
    	
    	while(t-- > 0) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int K = Integer.parseInt(st.nextToken());
    		int V = Integer.parseInt(st.nextToken());
    		
    		int cnt = 0;
            boolean[] visit = new boolean[n+1];
    		Queue<Edge> q = new LinkedList<>();
    		
    		q.add(new Edge(V, 0));  //유사도를 비교할 노드 큐에 삽입 
    		visit[V] = true;
    		
    		while(!q.isEmpty()) {
    			for(Edge edge: list[q.poll().v]) {
    				if(visit[edge.v]) continue;   //이미 방문한 노드이면 건너뛰기
    				if(edge.usado < K) continue;  // 유사도가 K보다 작으면 건너뛰기, 두 노드를 연결하는 엣지는 하나밖에 없다고 했으니 한 번 비교하고 끝
    				
    				visit[edge.v] = true;
    				cnt++;
    				q.add(new Edge(edge.v, edge.usado));	
    			}
    		}
    		bw.write(cnt+"\n");
        
    	}
    	bw.flush();
    	bw.close();
    }
}
