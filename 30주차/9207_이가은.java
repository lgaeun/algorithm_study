import java.io.*;
import java.util.*;

public class Main {
	
	static char[][] board;
	static int[] dx = {0,0,-1,1}, dy = {-1,1,0,0};
	static int pinResult, move;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		while(t-- >0) {
			board = new char[9][9];
			move = Integer.MAX_VALUE;
			int pin = 0;
			
			for(int i = 0; i < 5; i++) {
				String s = br.readLine();
				for(int j = 0; j < 9; j++) {
					board[i][j] = s.charAt(j);
					if(board[i][j] == 'o') {
						pin++;
					}
				}
			}
			pinResult = pin;
			
			for(int i = 0; i < 5; i++) {
				for(int j = 0; j < 9; j++) {
					if(board[i][j] == 'o') dfs(i,j,pin, 0);
				}
			}
			
			System.out.println(pinResult+" "+move);
			br.readLine();
		}

	}
	static void dfs(int x, int y, int pin, int depth) {
		if(pin <= pinResult) {
			pinResult = pin;
			move = depth;
		}

		for(int i = 0; i < 4; i++) { // 4방향에 대해 pin 있는지 확인 
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >= 0 && nx < 5 && ny >= 0 && ny < 9 && board[nx][ny]=='o') {
					int cx = nx + dx[i];
					int cy = ny + dy[i];
					
					if(cx >= 0 && cx < 5 && cy >= 0 && cy < 9 && board[cx][cy] == '.') {
						board[x][y] = '.';
						board[nx][ny] = '.';
						board[cx][cy] = 'o';
						
						for(int k = 0; k < 5; k++) {
							for(int j = 0; j < 9; j++) {
								if(board[k][j] == 'o') dfs(k, j, pin-1, depth+1);
							}
						}
						//복구
						board[x][y] = 'o';
						board[nx][ny] = 'o';
						board[cx][cy] = '.';
					
				}
			}
		}
	
	}
}
