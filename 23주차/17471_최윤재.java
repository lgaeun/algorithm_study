package tmp;
import java.io.*;
import java.util.*;
public class _17471_최윤재_게리맨더링 {

	static int area;
	static boolean[][] adj;
	static boolean[] visited;
	static int[] population;
	static int min = 1000;
	static int total_population;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		area = Integer.parseInt(br.readLine());
		adj = new boolean[area][area];
		visited = new boolean[area];
		population = new int[area];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<area; i++) {
			population[i] = Integer.parseInt(st.nextToken());
			total_population += population[i];
		}
		for(int i=0; i<area; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			for(int j=0; j<num; j++) adj[i][Integer.parseInt(st.nextToken())-1] = true;
		}
		
		for(int i=1; i<area/2+1; i++) {
			for(int j=0; j<area-i; j++) {
				dfs(j, i, 1, 0);
			}
		}
		if(min==1000) System.out.println(-1);
		else System.out.println(min);
	}
	public static void dfs(int cur_area, int limit, int depth, int sum_pop) {
		visited[cur_area] = true;
		if(depth == limit) {
			sum_pop += population[cur_area];
			is_valid(sum_pop, limit);
			visited[cur_area] = false;
			return;
		}
		for(int next_area=0; next_area<area; next_area++) {
			if(adj[cur_area][next_area] && !visited[next_area]) dfs(next_area, limit, depth+1, sum_pop+population[cur_area]);
		}
		visited[cur_area] = false;
	}
	
	public static void is_valid(int pop, int num) {
		int cnt = area-num;
		for(int i=0; i<area; i++) {
			if(!visited[i]) {
				if (!dfs_for_check(i, cnt, 1)) return;
			}
		}
		min = Math.min(min, Math.abs(total_population-pop-pop));
	}
	
	public static boolean dfs_for_check(int start, int limit, int depth) {
		boolean flag = false;
		if(depth==limit) return true;
		visited[start]=true;
		int j=1;
		for(int i=0; i<area; i++) {
			if(!visited[i] && adj[start][i]) flag = flag || dfs_for_check(i, limit, depth+j++);
		}
		visited[start]=false;
		return flag;
	}
}