import java.io.*;
import java.util.*;

public class Main {
	static int M, N;
	static int[][] map;
	static boolean[][] visited;
	static int ch;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[M][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited = new boolean[M][N];

		int time=0;
		while(chk()) {
			for(int i=0; i<M; i++)
				for(int j=0; j<N; j++)
					visited[i][j] = false;
			
			visited[0][0] = true;
			ch = 0;
			DFS(0, 0);
			time++;
		}

		System.out.println(time);
		System.out.println(ch);
		br.close();
	}

	public static boolean chk() {
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == -1) {
					map[i][j] = 0;
				}
			}
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					return true;
				}
			}
		}

		return false;
	}

	public static void DFS(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if(nx >= 0 && ny >= 0 && nx < M && ny < N && visited[nx][ny] == false) {
				visited[nx][ny] = true;
				if (map[nx][ny] == 1) {
					map[nx][ny] = -1;
					ch++;
				}
				else {
					DFS(nx, ny);
				}
			}

			
		}
	}

}
