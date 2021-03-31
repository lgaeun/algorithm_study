import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int N, M, H, ans;
	static int[][] ladder;
	static boolean flag = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		ladder = new int[H + 1][N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			ladder[x][y] = 1;
			ladder[x][y + 1] = 2;
		}
		for (int i = 0; i <= 3; i++) {
			ans = i;
			dfs(1, 0);
			if(flag)
				break;
		}
		System.out.println((flag) ? ans : -1);
	}

	static void dfs(int x, int count) {
		if (flag)
			return;
		if (ans == count) {
			if (check())
				flag = true;
			return;
		}
		for (int i = x; i < H + 1; i++) {
			for (int j = 1; j < N; j++) {
				if (ladder[i][j] == 0 && ladder[i][j + 1] == 0) {
					ladder[i][j] = 1;
					ladder[i][j + 1] = 2;
					dfs(i, count + 1);
					ladder[i][j] = ladder[i][j + 1] = 0;
				}
			}
		}
	}

	static boolean check() {
		for (int i = 1; i <= N; i++) {
			int x = 1, y = i;
			for (int j = 0; j < H; j++) {
				if (ladder[x][y] == 1) y++;
				else if (ladder[x][y] == 2) y--;
				x++;
			}
			if (y != i)
				return false;
		}
		return true;
	}
}
