import java.io.*;
import java.util.*;

public class Main {
	static int N, M, cnt = 0, min = 2147483647;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int[][] map;
	static boolean[] check;
	static ArrayList<point> chicken = new ArrayList<point>();
	static ArrayList<point> house = new ArrayList<point>();

	static class point {
		int x, y;

		point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
				if(map[i][j] == 1) {
					house.add(new point(i, j));
				}
				else if (map[i][j] == 2) {
					cnt++;
					chicken.add(new point(i, j));
				}
			}
		} //입력 받을 때 치킨집의 위치와 가정집의 위치 각각 저장해둠
		
		check = new boolean[cnt];
		if (cnt == M) { //폐업할 치킨집이 없을 경우
			calc();
			System.out.println(min);
		} else { //하나라도 폐업해야 할 경우
			for (int i = 0; i < cnt; i++) {
				point p = chicken.get(i);
				map[p.x][p.y] = 0;
				check[i] = true;
				close(i, 1);
				check[i] = false;
				map[p.x][p.y] = 2;
			}

			System.out.println(min);
		}
	}

	public static void close(int num, int clz) {
		if (clz == cnt - M) {
			calc();
			return;
		}

		for (int i = num + 1; i < cnt; i++) {
			point tmp = chicken.get(i);
			map[tmp.x][tmp.y] = 0;
			check[i] = true;
			close(i, clz + 1);
			check[i] = false;
			map[tmp.x][tmp.y] = 2;
		}
	}

	public static void calc() {
		Queue<point> q = new LinkedList<point>();
		int chk = 0;
		for (point it : house) {
			q.add(it);
			int tmp = 10000;
			for(int i=0; i<cnt; i++) {
				if(check[i] == true) continue;
				point p = chicken.get(i);
				int d = Math.abs(p.x - it.x) + Math.abs(p.y - it.y);
				tmp = (tmp<d)? tmp:d;
			}
			chk += tmp;
		}

		min = (min < chk) ? min : chk;
	}
} //BFS로 가까운 치킨집 찾아 거리 계산할 경우 시간 초과
