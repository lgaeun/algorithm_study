import java.util.*;
import java.io.*;

public class Main {
 
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int size = 0, n, m;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean[n][m];
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(!visited[i][j] && map[i][j] == 1){
					dfs(i,j);
					list.add(size);
					size = 0;	//초기화 
				}
			}
		}
		System.out.println(list.size());
		if(list.isEmpty()) System.out.print(0);
		else System.out.println(Collections.max(list));
	}
	
	static void dfs(int x, int y) {
		visited[x][y] = true;
		size++;
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(isValid(nx,ny) && !visited[nx][ny] && map[nx][ny] == 1)
				dfs(nx,ny);
		}
	}
	static boolean isValid(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < m;
	}
	
}
