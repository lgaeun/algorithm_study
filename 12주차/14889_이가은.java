import java.io.*;
import java.util.*;

public class Main {
	
	static int[][] map;
	static boolean[] visit;
	static int n;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visit = new boolean[n];
		
		StringTokenizer st;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j  = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		set(0, 0); //스타트팀 뽑기, 카운트 
		System.out.print(min);

	}
	static void set(int x, int cnt) { // 팀 나누기 
		
		if(cnt == n/2) { 	// 팀짜는거 완료되면 두 팀의 능력치 및 차 계산하고, min 갱신 
			int sum1 = 0, sum2 = 0;
			for(int i = 0; i < n-1; i++) {	
				for(int j = i+1; j < n; j++) {
					if(visit[i] && visit[j]) //team start sum 
						sum1 += (map[i][j] + map[j][i]);
					
					if(!visit[i] && !visit[j]) 	//team link sum 
						sum2 += (map[i][j]  + map[j][i]);
				}
			}	
			min = Math.min(min, Math.abs(sum1-sum2));
			return;
		}

		for(int i = x; i < n; i++) {
			if(!visit[i]) {
				visit[i] = true;
				set(i+1, cnt+1);
				visit[i] = false;
			}
		}
	}

}