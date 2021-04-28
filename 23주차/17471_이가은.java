import java.io.*;
import java.util.*;

public class Main {
	static int pop[], li [][], area[]; 
	static boolean[] visit;
	static int N, min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		pop = new int[N+1]; //인구수 
		li = new int[N+1][N+1]; //연결여부 
		area = new int[N+1]; //선거구 표시 
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) pop[i] = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			for(int j = 1; j <= n; j++) {
				int val = Integer.parseInt(st.nextToken());
				li[i][val] = 1;
				li[val][i] = 1;
			}
		}//입력 
		
		dfs(1);
		System.out.println(min==Integer.MAX_VALUE? -1 : min);
	
	}
	static void dfs(int cnt) {
		if(cnt == N) {
			int sumA = 0, sumB = 0;
			for(int i = 1; i <= N; i++) {
				if(area[i] == 1) sumA += pop[i];
				else sumB += pop[i];
			}//같은 선거구라고 마크된 지역들의 인구수 합 구하기 
			
			visit = new boolean[N+1];
			int num = 0;
			for(int i =1; i <= N; i++) {
				if(!visit[i]) {
					checkConnection(i, area[i]); //실제로 같은 선거구 내에 속하는지(연결) 체크 
					num++;
				}
			}
			//선거구가 2개로 나뉘어진 경우에만 min값과 비교(num>=3이면 선거구 지역이 끊긴 경우)
			if(num == 2) min = Math.min(min, Math.abs(sumA-sumB));
			return;
		}
		
		area[cnt] = 1;
		dfs(cnt+1);
		
		area[cnt] = 2;
		dfs(cnt+1);
	}
	
	static void checkConnection(int idx, int num) {
		visit[idx] = true;
		for(int i = 1; i <= N; i++) {
			 //연결돼있고, 아직방문X, 같은 선거구일 경우 그 연결된 구역에 대해 선거구 체크 
			if(li[idx][i] == 1 && !visit[i] && area[i] == num)
				checkConnection(i, num);
		}
	}

}
