import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int N, M, H, map[][];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H+1][N];   //(n~n+1사이의 가로선 의미), 0과 1사이의 가로선 => map[0][0] = 1, map[0][1] = -1
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			map[a][b] = 1;    
			map[a][b+1] = -1; 
		}
		if(searchOddNum() > 3) {	//라인에 연결 된 가로선이 3개초과이면 바로 리턴(한 라인에 연결된 가로선의 개수는 무조건 짝수개여야 함)
			System.out.println("-1");
			return;
		}
    		else {
			for(int i = 0; i <= 3; i++) { //최대 3개까지 더 추가할 수 있음
				if (dfs(0,0,0,i)) return;
			}
		}
		System.out.println("-1");
	}
	
	static boolean dfs(int x, int y, int cnt, int size ) { //dfs + backtracking
		if(cnt == size) {
			if(ladderCheck()) {
				System.out.println(size);
				return true;
			}
			return false;	
		}
		for(int i = x; i < H; i++) { 
			for(int j = y; j < N-1; j++) {
				if(map[i][j] != 0 && map[i][j+1] != 0) continue; // 연속으로 연결될 경우 패스 
				
				map[i][j] = 1;  //현재 위치에 가로선 추가하는 경우 
				map[i][j+1] = -1;
				if(dfs(i, j+2, cnt+1, size)) return true; //현재 위치에가로선을 추가한 경우, dfs를 돌렸을 때 true이면 return true.
				map[i][j] = 0;
				map[i][j+1] = 0;  //추가 안하는 경우
			}
			y = 0; //x다음 행 부터는 0부터 탐색 시작
		}
		return false;
	}
	
	static boolean ladderCheck() {
		for(int j = 0; j < N; j++) {
			int nx = 0, ny = j;
			
			while(nx <= H) {
				if(map[nx][ny] == 1) ny++; //오른쪽에 연결된 경우 오른쪽으로 이동
				else if(map[nx][ny] == -1) ny--; //왼쪽에 연결된 경우 왼쪽으로 이동
				nx++;
			}
			if(ny != j) return false;
		}
		return true;
	}
	
	static int searchOddNum() {
		int oddNum = 0;
		for(int j = 0; j < N-1; j++) {
			int cnt = 0;
			for(int i = 0; i < H; i++) //각 라인에 연결된 가로선의 개수 세기 
				if(map[i][j] == 1) cnt++;
			if(cnt % 2 == 1) oddNum++; // 홀수 개의 가로선이 연결된 라인이 홀수 개인 경우++
		}
		return oddNum;
	}
}

//참고: https://buddev.tistory.com/23
