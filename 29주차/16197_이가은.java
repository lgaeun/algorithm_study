import java.io.*;
import java.util.*;

public class Main {
	
	static char[][] map;
	static int r, c, min = 11;
	static int[] dx = {0,0,-1,1}, dy = {-1,1,0,0};
	static ArrayList<int[]> coins = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		map = new char[r][c];
		for(int i = 0; i < r; i++) {
			String line = br.readLine();
			for(int j = 0; j < c; j++) {
				map[i][j] = line.charAt(j);
				if(map[i][j] == 'o') coins.add(new int[] {i,j});
			}
		}
		dfs(coins.get(0), coins.get(1), 0);
		
		if(min == 11) System.out.println("-1");
		else System.out.println(min);
	}
	
	static void dfs(int[] front, int[] back, int depth) {
		if(depth == 10) return;
		
		for(int i = 0; i < 4; i++) {
			int[] n1 = {front[0] + dx[i], front[1] + dy[i]}; // 새로운 좌표로 이동 
			int[] n2 = {back[0] + dx[i], back[1] + dy[i]};
			
			boolean fst = check(n1);
			boolean snd = check(n2);
			
			if(fst && snd) { //둘 다 이동할 수 있는 경우에만 
				if(map[n1[0]][n1[1]] == '#') n1 = front; // 새로운 좌표로 이동 취소 
				if(map[n2[0]][n2[1]] == '#') n2 = back;
				
				dfs(n1,n2,depth+1);
			}
			else if(fst || snd) {	// 둘 중 하나만 true이면 (=동전 하나만 떨어짐) 
				min = Math.min(min, depth+1);
			}
			
			// fst, snd로 check 한 번 만 해두고 이용하는 것이 더 효율적. 논리연산 위가 더 
// 			if(fst && map[n1[0]][n1[1]] == '#') n1 = front;	// coin 이동 
// 			if(snd && map[n2[0]][n2[1]] == '#') n2 = back;	
// 			if((fst && !snd) || (!fst && snd)) min = Math.min(min, depth+1); //둘 중 하나만 true(=하나만 떨어짐) 
// 			else if(fst && snd)dfs(n1,n2,depth+1);
		}
	
	}
	
	static boolean check(int[] xy) {
		return xy[0] >= 0 && xy[0] < r && xy[1] >= 0 && xy[1] < c;
	}

}
