package graph;
import java.util.*;

public class _16953 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextInt();
		long b = sc.nextInt();
		
		System.out.print(bfs(a,b));
	}
	
	static long bfs(long a, long b) {
		Queue<Pair> q = new LinkedList(); 
		q.add(new Pair(a,1));
		
		
		while(!q.isEmpty()) {
			Pair now = q.poll();
			if(now.a == b) return now.cnt;
			
			if(now.a*2 <= b)
				q.add(new Pair(now.a*2, now.cnt+1));
			
			if(now.a*10+1 <= b)
				q.add(new Pair(now.a*10+1, now.cnt+1));
			
		}
		return -1;
	}
	
	static class Pair{
		long a;
		long cnt;
		
		public Pair(long a, long cnt) {
			this.a = a;
			this.cnt = cnt;
		}
	}

}

/*
 * 문제(1)해결: count가 queue에서 poll 할때마다 +1된다. depth가 +1될때만 +1 시키게 만들어야 한다. 
 * 각 노드마다 공통 count쓰면 자식만들때마다 +되니까, 각 노드마다 있는 변수로 바꾸기 -> 객체 만들어서 해결
 * 문제(2)해결: cnt++ -> cnt+1 (항상 원래 cnt+1=2만 답으로 나옴);
 * 문제(3)해결: int쓰면 연산결과(자식노드) 범위  ->long사용
*/
