import java.util.*;
import java.io.*;

public class Main {
	
	static int map[][];
	static boolean visit[][];
	static int m,n,size;
	static int []dx = {0, 0, 1, -1};
	static int []dy = {1, -1, 0, 0};
 
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken()); //가로  
		n = Integer.parseInt(st.nextToken()); //세로  
		int k = Integer.parseInt(st.nextToken());
		
		map = new int[m][n];
		visit = new boolean[m][n];
		PriorityQueue<Integer> sizelist = new PriorityQueue<>();
		
		//입력받기 (최대 1,000,000)
		for(int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			// col = x, row = y
			for(int col = x1; col < x2; col++)
				for(int row = y1; row < y2; row++) 
					if(map[row][col] == 0) 
						map[row][col] = 1;	
		}
		//dfs로 면적, 개수 구하기
		int count = 0;
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				size = 1;
				if(!visit[i][j] && map[i][j] == 0) {
					count++;
					dfs(i,j);
					sizelist.add(size);
				}
			}
		}
		//출력
		System.out.println(count);
		while(!sizelist.isEmpty())
			System.out.print(sizelist.poll()+" ");
		
	}
	static void dfs(int x, int y) {
		visit[x][y] = true;
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(isValid(nx,ny)) {
				if(!visit[nx][ny] && map[nx][ny] == 0) { 
					dfs(nx,ny);
					size++;
				}
			}
		}
	}
	static boolean isValid(int x, int y) {
		return x < m && x >=0 && y < n && y >=0;
	}
	
}