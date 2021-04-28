import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int n = Integer.parseInt(st.nextToken());
    	int m = Integer.parseInt(st.nextToken());
    	int[][] map = new int[n][m];
    	Queue<int[]> q = new LinkedList<>();
    	
    	for(int i = 0; i < n; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 0;  j < m; j++) {
    			map[i][j] = Integer.parseInt(st.nextToken());
    			if(map[i][j] == 1) q.add(new int[] {i,j});
    		}
    	}
    	int max = 0;
    	while(!q.isEmpty()) {
    		int[] pos = q.poll();
   			for(int i = -1; i <= 1 ; i++) { //8방향에 대해서 
   				for(int j = -1; j <= 1; j++) {
    				int nx = pos[0] + i;
    				int ny = pos[1] + j;
    				if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
    				if(map[nx][ny] == 0) { 
    					map[nx][ny] = map[pos[0]][pos[1]] + 1;
    					max = map[nx][ny];
    					q.add(new int[] {nx,ny});
    				}
    			}
    		}
    	}
    	System.out.println(max-1); //상어는 1부터 시작했으므로 -1
	}

}
