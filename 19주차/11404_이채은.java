import java.io.*;

public class Main{
	static int n, m;
	static int[][] cost;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        cost = new int[n+1][n+1];
        for(int i=1; i<n+1; i++)
        	for(int j=1; j<n+1; j++)
        		if(i != j) cost[i][j] = 10000000;
        
        for(int i=0; i<m; i++){
            String[] tmp = br.readLine().split(" ");
            int a = Integer.parseInt(tmp[0]);
            int b = Integer.parseInt(tmp[1]);
            int c = Integer.parseInt(tmp[2]);
            cost[a][b] = Math.min(cost[a][b], c);
        }
        
        floydWarshall();
        StringBuilder ans = new StringBuilder("");
        for(int i=1; i<n+1; i++) {
        	for(int j=1; j<n+1; j++) {
        		if(cost[i][j] == 10000000)
        			ans.append("0 ");
        		else
        			ans.append(cost[i][j]+" ");
        	}
        	ans.append("\n");
        }
        
        System.out.println(ans);
    }
    
    static void floydWarshall() {
    	for(int i=1; i<n+1; i++) {
    		for(int j=1; j<n+1; j++) {
    			for(int k=1; k<n+1; k++) {
    				if(cost[j][i]+cost[i][k] < cost[j][k])
    					cost[j][k] = cost[j][i] + cost[i][k];
    			}
    		}
    	}
    }
}
