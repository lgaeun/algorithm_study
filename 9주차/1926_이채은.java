import java.util.Scanner;

public class Main{
    static int n, m;
    static int[][] pic;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        pic = new int[n][m];
        visited = new boolean[n][m];
        for(int i=0; i<n; i++)
            for(int j=0; j<m; j++)
                pic[i][j] = sc.nextInt();
        
        int cnt=0, max=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(visited[i][j]==false && pic[i][j]==1){
                    cnt++;
                    int a = area(1, i, j);
                    if(a>max) max=a;
                }
            }
        }
        System.out.println(cnt);
        System.out.println(max);
        sc.close();
    }
    
    public static int area(int c, int x, int y){
        visited[x][y] = true;
        for(int i=0; i<4; i++){
            if(x+dx[i]>=0 && x+dx[i]<n && y+dy[i]>=0 && y+dy[i]<m){
                if(pic[x+dx[i]][y+dy[i]]==1 && visited[x+dx[i]][y+dy[i]]==false)
                	c+=area(1, x+dx[i], y+dy[i]);
            }
        }
        return c;
    }
}
