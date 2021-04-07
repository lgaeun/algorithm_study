import java.io.*;
import java.util.*;

public class Main {
	
	static int[] dx = { 0,  0, -1, 1}, dy =  { 1, -1, 0,  0};  //동,서,북,남 
	static int[][] map;
	static int n, m;
	static int[] dice = new int[7]; //1은위면, 6은 아랫면, 2345는 북동남서
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	n = Integer.parseInt(st.nextToken()); 
    	m = Integer.parseInt(st.nextToken()); 
    	int x = Integer.parseInt(st.nextToken()); 
    	int y = Integer.parseInt(st.nextToken()); 
    	int it = Integer.parseInt(st.nextToken()); 

    	map = new int [n][m];
    	for(int i = 0; i < n ; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 0; j < m; j++) {
    			map[i][j] = Integer.parseInt(st.nextToken()); 
    		}
    	}
    	
    	st = new StringTokenizer(br.readLine());
    	for(int i = 0; i < it; i++) {
    		int dir = Integer.parseInt(st.nextToken());
    		
    		if( !check(x+dx[dir-1],y+dy[dir-1]) ) continue;
    		
    		x += dx[dir-1];
    		y += dy[dir-1];
    		
    		roll(dir);
    		copy(x,y);
    		sb.append(dice[1]+"\n"); //윗면 
    	}
    	System.out.print(sb.toString());
    }
	
	static boolean check(int x, int y) {
		return x>=0 && x<n && y>=0 && y<m;
	}
	
	static void copy(int x, int y) {
		if(map[x][y] == 0) {
			map[x][y] = dice[6];
		}else {
			dice[6] = map[x][y];
			map[x][y] = 0;
		}
	}
	
	static void roll(int dir) {
		int[] temp  = dice.clone(); // 객체 복사
		if(dir == 1) { // 동
			dice[1] = temp[5];
			dice[3] = temp[1];
			dice[6] = temp[3];
			dice[5] = temp[6];
		}else if(dir ==2) { //서 
			dice[1] = temp[3];
			dice[5] = temp[1];
			dice[6] = temp[5];
			dice[3] = temp[6];
		}else if(dir == 3) { // 북 
			dice[1] = temp[4];
			dice[2] = temp[1];
			dice[6] = temp[2];
			dice[4] = temp[6];
		}else if (dir == 4) { // 남 
			dice[1] = temp[2];
			dice[4] = temp[1];
			dice[6] = temp[4];
			dice[2] = temp[6];
		}
		
	}
}
	
