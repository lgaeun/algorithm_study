import java.io.*;

public class Main {
	static int N, M, x, y, K;
	static int[] dice = new int[7];
	static int[][] map;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inp = br.readLine().split(" ");
		N = Integer.parseInt(inp[0]);
		M = Integer.parseInt(inp[1]);
		x = Integer.parseInt(inp[2]);
		y = Integer.parseInt(inp[3]);
		K = Integer.parseInt(inp[4]);

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			inp = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(inp[j]);
			}
		}

		inp = br.readLine().split(" ");
		for (int i = 0; i < K; i++) {
			int c = Integer.parseInt(inp[i]);
			int nx = x + dx[c - 1];
			int ny = y + dy[c - 1];

			if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
				roll(c);
				if (map[nx][ny] == 0)
					map[nx][ny] = dice[6];
				else {
					dice[6] = map[nx][ny];
					map[nx][ny] = 0;
				}
				x = nx; y = ny;
				System.out.println(dice[1]);
			}
		}
	}

	public static void roll(int d) {
		int[] tmp = dice.clone();
		if (d == 1) {
			dice[1] = tmp[4];
			dice[3] = tmp[1];
			dice[4] = tmp[6];
			dice[6] = tmp[3];
		}
		else if (d == 2) {
			dice[1] = tmp[3];
			dice[3] = tmp[6];
			dice[4] = tmp[1];
			dice[6] = tmp[4];
		}
		else if (d == 3) {
			dice[1] = tmp[5];
			dice[2] = tmp[1];
			dice[5] = tmp[6];
			dice[6] = tmp[2];
		}
		else {
			dice[1] = tmp[2];
			dice[2] = tmp[6];
			dice[5] = tmp[1];
			dice[6] = tmp[5];
		}
	}
}
