import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int N = Integer.parseInt(tmp[0]);
        int Q = Integer.parseInt(tmp[1]);
        ArrayList<int[]>[] usado = new ArrayList[N+1];
        for(int i=1; i<N+1; i++)
        	usado[i] = new ArrayList<int[]>();
        
        for(int i=1; i<N; i++){
            tmp = br.readLine().split(" ");
            int p = Integer.parseInt(tmp[0]);
            int q = Integer.parseInt(tmp[1]);
            int r = Integer.parseInt(tmp[2]);
            usado[p].add(new int[] {q, r});
            usado[q].add(new int[] {p, r});
        }
        
        StringBuilder ans = new StringBuilder();
        for(int i=0; i<Q; i++) {
        	tmp = br.readLine().split(" ");
        	int k = Integer.parseInt(tmp[0]);
        	int v = Integer.parseInt(tmp[1]);
        	int cnt = 0;
        	Queue<Integer> q = new LinkedList<Integer>();
        	boolean[] visit = new boolean[N+1];
        	q.add(v);
        	visit[v] = true;
        	while(!q.isEmpty()) {
        		int t = q.poll();
        		for(int[] list : usado[t]) {
        			if(!visit[list[0]] && list[1]>=k) {
        				visit[list[0]] = true;
        				q.add(list[0]);
        				cnt++;
        			}
        		}
        	}
        	ans.append(cnt+"\n");
        }
        
        System.out.println(ans);
    }
}
