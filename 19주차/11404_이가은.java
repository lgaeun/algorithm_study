// 출력초과.. ??모르겠음
import java.util.*;
import java.io.*;

public class Main{

	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	int n = Integer.parseInt(br.readLine()); 
    	int m = Integer.parseInt(br.readLine()); 
    	int[][] arr = new int[n+1][n+1];
    	int INF = 1000000001;
    	
    	for(int i = 1; i <= n; i++)
    		for(int j = 1; j <= n; j++) 
    			if(i != j) arr[i][j] = INF;
    
    	for(int i = 0; i < m; i++) {
    		String[] in = br.readLine().split(" ");
    		int from = Integer.parseInt(in[0]);
    		int to = Integer.parseInt(in[1]);
    		int cost = Integer.parseInt(in[2]);
    		arr[from][to] = Math.min(arr[from][to], cost);
    	}
    	
    	for(int k = 1; k <= n; k++)
    		for(int i = 1; i <= n; i++)
    			for(int j = 1; j <= n; j++)
    				if(arr[i][k]+arr[k][j] < arr[i][j])
    					arr[i][j] = arr[i][k]+arr[k][j];
    	
    	for(int i = 1; i <= n; i++) {
    		for(int j = 1; j <= n; j++){
    			if(arr[i][j] == INF) bw.write("0 ");
    			bw.write(Integer.toString(arr[i][j])+" ");
    		}
    		bw.write("\n");
    	}
    	bw.flush();
    	bw.close();
    } 
}
