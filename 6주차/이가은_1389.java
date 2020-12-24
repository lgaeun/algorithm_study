package graph;
import java.io.*;
import java.util.*;

public class _1389 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());	
		
		final int INF = 100000000;
		int[][] graph = new int[n+1][n+1];
		
		//초기화 
		for(int i = 1; i <= n; i++) 
			for(int j = 1; j <= n; j++) 
				if(i!=j) graph[i][j] = INF;
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			graph[x][y] = 1;
			graph[y][x] = 1;
		}

		//플로이드와샬 알고리즘
		for(int k = 1; k <= n; k++) {
			for(int i = 1; i <= n; i++) {
				for(int j = 1; j <= n; j++) {
					if(graph[i][k]+graph[k][j] < graph[i][j])
						graph[i][j] = graph[i][k]+graph[k][j];
				}
			}	
		}
		
		int sum = 0, index = 0, min = INF;
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) 	//각 유저의 베이컨 수 합 구하기
				sum += graph[i][j];
			
			if(sum < min) {				//min같이 계산
				min = sum;
				index = i;
			}
			sum=0;	//초기화
		}
		
		System.out.print(index);
	}
}
/*
 * 마지막에 sum을 초기화 안시켜서 계속 유저 1만 답으로 나왔었음. 각 유저의 sum구한 후에 꼭 초기화시키기
 */
