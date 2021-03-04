import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        class Node implements Comparable<Node>{
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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(stk.nextToken());
        int E = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(br.readLine());
        
        int[] dist = new int[V+1];
        boolean[] visit = new boolean[V+1];
        for(int i=0; i<V+1; i++)
            dist[i] = 2000001;
        
        ArrayList<Node>[] list = new ArrayList[V+1];
        for(int i=0; i<V+1; i++) {
            list[i] = new ArrayList<Node>();
        }
 
        for(int i=0; i<E; i++) {
            stk = new StringTokenizer(br.readLine());
            int tmp = Integer.parseInt(stk.nextToken());
            list[tmp].add(new Node(Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken())));
        }
 
        PriorityQueue<Node> q = new PriorityQueue<Node>();
        q.add(new Node(K, 0));
        dist[K] = 0;
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

        StringBuilder ans = new StringBuilder("");
        for(int i=1; i<V+1; i++) {
            if(dist[i] == 2000001)
                ans.append("INF\n");
            else
                ans.append(dist[i]+"\n");
        }
        System.out.println(ans);
    }
 
}
