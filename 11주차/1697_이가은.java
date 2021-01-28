public class Main {
	
	static int n, k;
	static int[] visit=new int [100001];
	static Queue<Integer> q = new LinkedList<>();
	
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		
		bfs(n);
		System.out.print(visit[k]);
		
	}
	static void bfs(int cur) {
		q.offer(cur);
		while(!q.isEmpty()) {
			int tmp = q.poll();
			if( tmp == k) break;
			go(tmp, tmp-1); 
			go(tmp, tmp+1); 
			go(tmp, tmp*2); 
		}
	}
	static void go(int tmp, int idx) { 
		if(idx >=0 && idx < visit.length && visit[idx] == 0) { //범위 내에 있고, 아직 방문X 
			q.offer(idx);
			visit[idx] = visit[tmp] + 1;
		}
	}

}