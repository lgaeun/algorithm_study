import java.util.LinkedList;
import java.util.Queue;
import java.io.*;

public class Main{
    static int N, M;
    static int[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static class pair{
        int x, y, wall;
        pair(int x, int y, int wall){
            this.x = x; this.y = y; this.wall = wall;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        N = Integer.parseInt(tmp[0]);
        M = Integer.parseInt(tmp[1]);
        map = new int[N][M];
        for(int i=0; i<N; i++){
            tmp = br.readLine().split("");
            for(int j=0; j<M; j++)
                map[i][j] = Integer.parseInt(tmp[j]);
        }
        
        bfs();
    }
    
    public static void bfs(){
        Queue<pair> q = new LinkedList<pair>();
        int[][][] visit = new int[N][M][2];
        q.add(new pair(0, 0, 0));
        visit[0][0][0] = 1;
        while(!q.isEmpty()){
            pair p = q.poll();
            if(p.x == N-1 && p.y == M-1){
                System.out.println(visit[N-1][M-1][p.wall]);
                return;
            }
            for(int i=0; i<4; i++){
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];
                if(nx>=0 && nx<N && ny>=0 && ny<M && visit[nx][ny][p.wall]==0){
                    if(map[nx][ny] == 0){
                        q.add(new pair(nx, ny, p.wall));
                        visit[nx][ny][p.wall] = visit[p.x][p.y][p.wall]+1;
                    }
                    else if(p.wall == 0){
                        q.add(new pair(nx, ny, p.wall+1));
                        visit[nx][ny][p.wall+1] = visit[p.x][p.y][p.wall]+1;
                    }
                }
            }
        }
        System.out.println(-1);
    }
}
