import java.util.*;
import java.io.*;

public class Main{
	static int N;
	static ArrayList<Node>[] list;
	static class Node implements Comparable<Node>{
        int e, val;
        Node(int e, int val) {
            this.e = e;
            this.val = val;
        }

        @Override
        public int compareTo(Node o) {
        	return val - o.val;
        }
    }
	
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        N = Integer.parseInt(arr[0]);
        int E = Integer.parseInt(arr[1]);
        
        list = new ArrayList[N+1];
        for(int i=0; i<N+1; i++)
            list[i] = new ArrayList<Node>();
        
        for(int i=0; i<E; i++){
            arr = br.readLine().split(" ");
            int a = Integer.parseInt(arr[0]);
            int b = Integer.parseInt(arr[1]);
            int c = Integer.parseInt(arr[2]);
            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }
        
        arr = br.readLine().split(" ");
        int fst = Integer.parseInt(arr[0]);
        int snd = Integer.parseInt(arr[1]);
        int[] ans = new int[5];
        
        ans[0] = dijkstra(1, fst);
        ans[1] = dijkstra(1, snd);
        ans[2] = dijkstra(fst, snd);
        ans[3] = dijkstra(fst, N);
        ans[4] = dijkstra(snd, N);
        
        int res = -1;
        if(ans[2] == Integer.MAX_VALUE) {	
        } else if(ans[0] != Integer.MAX_VALUE && ans[1] != Integer.MAX_VALUE &&
        		ans[2] != Integer.MAX_VALUE && ans[3] != Integer.MAX_VALUE) {
        	res = Math.min(ans[0]+ans[4]+ans[2], ans[1]+ans[3]+ans[2]);
        } else if(ans[0] != Integer.MAX_VALUE && ans[2] != Integer.MAX_VALUE) {
        	res = ans[0] + ans[4] + ans[2];
        } else if(ans[1] != Integer.MAX_VALUE && ans[3] != Integer.MAX_VALUE) {
        	res = ans[1] + ans[3] + ans[2];
        }
        
        System.out.println(res);
    }
    
    public static int dijkstra(int start, int end) {
    	PriorityQueue<Node> q = new PriorityQueue<Node>();
        int[] dist = new int[N+1];
        boolean[] visit = new boolean[N+1];
        for(int i=1; i<=N; i++)
        	dist[i] = Integer.MAX_VALUE;
        
        q.add(new Node(start, 0));
        dist[start] = 0;
        while(!q.isEmpty()) {
            Node curr = q.poll();
            int num = curr.e;
            
            if(visit[num]) continue;
            visit[num] = true;
            
            for(Node n:list[num]) {
                if (dist[n.e] > dist[num]+n.val) {
                    dist[n.e] = n.val+dist[num];
                    q.add(new Node(n.e, dist[n.e]));
                }
            }
        }
        
        return dist[end];
    }
}
