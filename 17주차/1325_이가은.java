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
			list[a].add(b); // 해킹되는 컴퓨터의 list (b해킹 -> a도 같이 해킹됌)
     			 //list[b].add(a); -> (처음 풀이 방식) 해킹하는 컴퓨터의 list, bfs -> 시간초과
		}
		
		for(int i = 1; i <= n; i++) {
			visit = new boolean[n+1];
			dfs(i);	//각 컴퓨터를 해킹시킬 수 있는 컴퓨터 찾아서 번호 증가 
		}
		
		int max = 0;
		for (int i = 1; i <= n; i++) max = Math.max(max, hack[i]); //최대로 해킹할 수 있는 컴퓨터의 max 구하기
		
		for(int i = 1; i <= n; i++) if(hack[i] == max) sb.append(i+" "); //max값과 같은 컴퓨터 번호 출력 
		
		System.out.println(sb.toString());
	}
	
	static void dfs(int start) {
		visit[start] = true;
		for(int v: list[start]) {
			if(!visit[v]) {
				hack[v]++; //v를 해킹시키는 컴퓨터의 번호 증가시킴 
				dfs(v);
			}
		}
	}
}
