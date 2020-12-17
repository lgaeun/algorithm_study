package dynamic;
import java.io.*;
import java.util.StringTokenizer;

public class _1149 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); 
		int[][] cost = new int[N][3];
		
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < 3; j++) {
				st = new StringTokenizer(br.readLine());
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
			
		for(int i = 1; i < N; i++) {
			cost[i][0] += min(cost[i-1][1], cost[i-1][2]);	  //R일때 
			cost[i][1] += min(cost[i-1][0], cost[i-1][2]);    //G일때 
			cost[i][2] += min(cost[i-1][0], cost[i-1][1]); 	  //B일때 
		}
		System.out.println(min(min(cost[N][0],cost[N][1]),cost[N][2]));
	}
	
	public static int min(int a, int b) {
		return a < b ? a : b;
	}

}