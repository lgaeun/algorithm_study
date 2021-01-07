import java.io.*;
import java.util.StringTokenizer;

public class Main{
    static int M, N;
    static int[][] map;
    static int max=0;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        for(int i=0; i<M; i++){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        
        search(0, 0);
        System.out.println(max);
    }
    
    public static void search(int x, int y){
        if(x==M-1 && y==N-1)
        	max++;
        
        for(int i=0; i<4; i++){
        	int currx = x+dx[i];
            int curry = y+dy[i];
            if(currx>=0 && currx<M && curry>=0 && curry<N){
                if(map[currx][curry]<map[x][y]){
                    search(currx, curry);
                }
            }
        }
    }
}
