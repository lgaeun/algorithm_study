import java.util.*;
import java.io.*;

public class Main {
	static ArrayList<Integer>[] list;
	static boolean[] visit;
	static int[] hack;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		hack = new int[n+1];
		list = new ArrayList[n+1];
		
		for(int i = 1; i <= n ; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < m; i++) { // 간선 입력 
			input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			list[a].add(b); // b해킹 -> a도 같이 해킹됌 
      //list[b].add(a);
		}
		
		for(int i = 1; i <= n; i++) {
			visit = new boolean[n+1];
			dfs(i);
		}
		
		int max = 0;
		for (int i = 1; i <= n; i++) {
			max = Math.max(max, hack[i]);
		}
		
		for(int i = 1; i <= n; i++) 
			if(hack[i] == max) sb.append(i+" ");
		System.out.println(sb.toString());
	}
	
	static void dfs(int start) {
		visit[start] = true;
		for(int v: list[start]) {
			if(!visit[v]) {
				hack[v]++; 
				dfs(v);
			}
		}
	}
}
