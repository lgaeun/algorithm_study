import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {
	
	static int n,m, startNode, endNode;
	static ArrayList<Point>[] list; //Point(x,y)는 (도착점,중량) 
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[n+1];
		for(int i = 0; i < n+1; i++) {	//arraylist의 배열 
			list[i] = new ArrayList<>();
		}
		
		int low = 1000000001, high = 0; //전체 다리 중량 중에서 최소/최대값 
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[x].add(new Point(y,w));
			list[y].add(new Point(x,w));
			low = Math.min(low, w);
			high = Math.max(high, w);
		}
		st = new StringTokenizer(br.readLine());
		startNode = Integer.parseInt(st.nextToken());
		endNode = Integer.parseInt(st.nextToken());
		
		int ans = 0;
		while(low <= high) {	//전체 다리 이분탐색 + bfs
			visit = new boolean[n+1];
			int mid = (low+high)/2;
			if(bfs(mid)) {
				ans = mid;
				low = mid + 1;
			}
			else
				high = mid - 1;	
		}
		System.out.println(ans);

	}
	static boolean bfs(int weight) {	//중량제한을 견딜 수 있는 다리만 이용해서 endNode에 도착가능한지 체크 
		Queue<Integer> q = new LinkedList<>();
		q.add(startNode);
		visit[startNode] = true;
		while(!q.isEmpty()) {
			int cur = q.poll();
			if(cur == endNode) return true;
			
			for(Point next : list[cur]) {
				if(!visit[next.x] && next.y >= weight) {
					q.add(next.x);
					visit[next.x] = true;
				}
			}
		}
		return false;
	}
}