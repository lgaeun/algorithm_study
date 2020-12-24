import java.util.*;
import java.io.*;

public class _10026 {
	
	static char[][] graph;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int n;
	static int count1=0,count2=0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		graph = new char[n][n];
		visited = new boolean[n][n];
		boolean normal = true;
		
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			for(int j = 0; j < n; j++) {
				graph[i][j] = s.charAt(j);
			}
		}
		
		//정상일 때 
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(visited[i][j] == false) {
					count1++;
					dfs(i,j,normal);
				}
			}
		}
		//초기화 
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				visited[i][j] = false;
		
		//색약일 때 
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(visited[i][j] == false) {
					count2++;
					dfs(i,j,!normal);
				}
			}
		}
		System.out.print(count1+" "+count2);
	}
	

	static void dfs(int x, int y, boolean isnormal) {
		
		visited[x][y] = true;
	
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			//범위 내에 있고 아직 방문하지 않은 노드일 경우, 재귀적으로 인접노드 찾는다
			if(nx>=0 && nx<n && ny >=0 && ny<n) { 
				if(visited[nx][ny] == false && section_check(x,y,nx,ny,isnormal))
					dfs(nx,ny,isnormal);
			}
		}return;
	}
	
	// 색약or정상에 따라 같은 색으로 인식하는 범위 다르게 하기 위함 
	static boolean section_check(int x, int y, int nx, int ny, boolean normal) {
		char pivot = graph[x][y];
		
		if(normal)  //정상일 떄, pivot과 같은색만 같은 구역
			return (graph[nx][ny] == pivot);
		else {  // 색약일 때 
			if(pivot == 'B') return graph[nx][ny] == 'B';
			else 
				return (graph[nx][ny] == 'R' || graph[nx][ny] == 'G'); // R,G는 같은 색으로 인식 
		}
	}
}

/*
 * 런타임에러 해결: 맨 위에 패키지를 넣으면 에러남
 */