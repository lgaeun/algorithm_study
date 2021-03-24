import java.io.*;

public class Main{
    static int N, min = Integer.MAX_VALUE;
    static int[][] cost;
    static boolean[][] visited;
    static int dx[] = {0, 0, 0, 1, -1};
    static int dy[] = {0, 1, -1, 0, 0};
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cost = new int[N][N];
        visited = new boolean[N][N];
        for(int i=0; i<N; i++){
        	String[] tmp = br.readLine().split(" ");
            for(int j=0; j<N; j++)
                cost[i][j] = Integer.parseInt(tmp[j]);
        }
        
        solve(0, 0, 1);
        System.out.println(min);
    }
    
    static void solve(int cnt, int sum, int x) {
        if(cnt == 3) {
            min = Math.min(min, sum);
        } else {
	        for(int i=x; i<N; i++) {
	            for (int j=0; j<N; j++) {
	                if(!isPossible(i, j)) continue;
	                
	                int tmp = 0;
	                for(int k=0; k<5; k++) {
	                	visited[i+dx[k]][j+dy[k]] = true;
	                	tmp += cost[i+dx[k]][j+dy[k]];
	                }
	                
	                solve(cnt+1, sum+tmp, i);
	                
	                for(int k=0; k<5; k++)
	                    visited[i+dx[k]][j+dy[k]] = false;
	            }
	        }
        }
    }
    
    static boolean isPossible(int x, int y) {
    	if(visited[x][y])
    		return false;
    	
    	for(int i=1; i<5; i++) {
    		int nx = x+dx[i];
    		int ny = y+dy[i];
    		if(nx<0 || ny<0 || nx>=N || ny>=N || visited[nx][ny])
    			return false;
    	}
    	
    	return true;
    }
}
