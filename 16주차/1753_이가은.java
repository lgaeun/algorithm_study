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

		int[] dist = new int[n+1];
		Arrays.fill(dist, 99999999); // INF로 초기화 
		
		ArrayList<Edge>[] graph = new ArrayList[n+1];
	   	for (int i = 1; i <= n; i++) graph[i] = new ArrayList<Edge>();
		
	    	String line = "";    // 구글링한 bufferedReader EOF 코드,??? 근데 이렇게 하면 입력시 마지막줄 공백을 줘야 동작함
//		while(( line = br.readLine() ) != null) {
//			st = new StringTokenizer(line);
//			int u = Integer.parseInt(st.nextToken());
//			int v = Integer.parseInt(st.nextToken());
//			int w = Integer.parseInt(st.nextToken());
//			graph[u].add(new Edge(v,w));
//		} 
		
		for(int i = 0; i < e; i++) {
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
	
			for(Edge next: graph[cur.v]) {
				if(dist[next.v] > dist[cur.v] + next.w) {
					dist[next.v] = dist[cur.v] + next.w;
					pq.add(new Edge(next.v, dist[next.v]));
				}
			}
		}
		for(int i = 1; i <= n; i++) {
			if(dist[i] != 99999999) 
				sb.append(dist[i]+"\n");
			else sb.append("INF"+"\n");
		}
		System.out.println(sb);
	}
}

/* 틀렸습니다 원인
1. input 문제  - 32줄: StringTokenzier로 EOF(end of line) 할 수 업음
   해결 1) BufferedReader: 빈 string을 만들어 br.readline 이 null인지 체크.(br은 더 이상 읽을 게 없으면 null을 반환) 
   해결 2) for 문 e 수 만큼 돌리기
2. visit[]배열 사용할 필요 없음: 55번째 줄에서 거리가 최소보다 큰 것(이미 지나온 경우)은 걸러지기 때문
3. 우선순위 큐에서 Integer.MAX_VALUE를 쓰면 시간 초과가 날 수 있기 때문에, 대신 충분히 큰 수를 사용할 것
4. output 형식 - 57줄: INF뒤에 줄바꿈을 추가할 것
*/
