import java.util.*;

public class Main{
    static class point{
        int x, y;
        point(int x, int y){
            this.x = x; this.y = y;
        }
    }
    static int N, M, max = 1;
    static int[][] map;
    static int[] dx = {0, 1, -1};
    static int[] dy = {0, 1, -1};
    static Queue<point> shark = new LinkedList<point>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); M = sc.nextInt();
        map = new int[N][M];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                map[i][j] = sc.nextInt();
                if(map[i][j]==1) shark.add(new point(i, j));
            }
        }
        
        bfs();
        
        for(int i=0; i<N; i++)
        	for(int j=0; j<M; j++)
        		max = Math.max(map[i][j], max);

        System.out.println(max-1);
        sc.close();
    }
    
    static void bfs() {
    	while(!shark.isEmpty()) {
    		point tmp = shark.poll();
    		for(int i=0; i<3; i++) {
    			for(int j=0; j<3; j++) {
    				if(i==0 && j==0) continue;
    				int nx = tmp.x+dx[i];
    				int ny = tmp.y+dy[j];
    				if(nx>=0 && nx<N && ny>=0 && ny<M && map[nx][ny]==0) {
    					map[nx][ny] = map[tmp.x][tmp.y]+1;
    					shark.add(new point(nx, ny));
    				}
    			}
    		}
    	}
    	
    }
}
