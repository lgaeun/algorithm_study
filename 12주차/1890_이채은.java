import java.io.*;
import java.util.*;

public class Main{
    static int N;
    static int[][] map;
    static long[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dp = new long[N][N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
        
        System.out.println(dfs(0, 0));
    }
    
    public static long dfs(int x, int y){
        if(x==N-1 && y==N-1)
            return 1;
        
        if(dp[x][y] == -1){
            dp[x][y] = 0;
            int nx = x + map[x][y];
            if(nx >= 0 && nx < N)
                dp[x][y] += dfs(nx, y);
            int ny = y + map[x][y];
            if(ny >= 0 && ny < N)
                dp[x][y] += dfs(x, ny);
        }
        return dp[x][y];
    }
}
