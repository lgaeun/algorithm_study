import java.io.*;
import java.util.*;

public class Main {
	static int[][] map;
	static int[] count = new int[3]; // -1,0,1의 개수 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n  = Integer.parseInt(br.readLine());
		map = new int[n][n];
		
		StringTokenizer st;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		go(0,0,n);
		for(int i = 0; i < 3; i++)	System.out.println(count[i]);
	}
	static void go(int x,int y, int len) {
		int base = check(x,y,len);
		if(base < 2) { // -1,0,1 중에 하나면 
			count[base+1]++;
			return;
		}
		else {
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
					go(x + i*len/3, y + j*len/3, len/3);
				}
			}
		}
		
	}
	static int check(int x, int y, int len) {
		for(int i = 0; i < len; i++) {
			for(int j = 0; j < len; j++) {
				if(map[x+i][y+j] != map[x][y]) return 2;
			}
		}
		return map[x][y];
	}

}
