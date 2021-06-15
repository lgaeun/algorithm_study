import java.util.*;
import java.io.*;

public class Main{
    static class pair{
        int x, y;
        pair(int x, int y){
            this.x = x; this.y = y;
        }
    }
    static int R, C, end_x, end_y;
    static char[][] map;
    static int[][] copy;
    static boolean[][] visit;
    static Queue<pair> hog = new LinkedList<>();
    static Queue<pair> water = new LinkedList<>();
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        R = Integer.parseInt(tmp[0]);
        C = Integer.parseInt(tmp[1]);
        map = new char[R][C]; visit = new boolean[R][C]; copy = new int[R][C];
        for(int i=0; i<R; i++){;
            char[] row = br.readLine().toCharArray();
            for(int j=0; j<C; j++){
                map[i][j] = row[j];
                if(map[i][j] == '*') water.add(new pair(i, j));
                else if(map[i][j] == 'S') {
                	hog.add(new pair(i, j)); visit[i][j] = true;
                }
                else if(map[i][j] == 'D'){
                    end_x = i; end_y = j;
                }
            }
        }
        
        move();
        System.out.println(copy[end_x][end_y]==0 ? "KAKTUS":copy[end_x][end_y]);
    }
    
    public static void move(){
        while(!hog.isEmpty() && !visit[end_x][end_y]){
            spread();
            int size = hog.size();
            for(int i=0; i<size; i++){
                pair p = hog.poll();
                for(int j=0; j<4; j++) {
	                int nx = p.x + dx[j];
	                int ny = p.y + dy[j];
	                if(nx>=0 && nx<R && ny>=0 && ny<C && !visit[nx][ny] && map[nx][ny]!='*' && map[nx][ny]!='X'){
	                    hog.add(new pair(nx, ny));
	                    visit[nx][ny] = true;
	                    copy[nx][ny] = copy[p.x][p.y]+1;
	                }
                }
            }
        }
    }
    
    public static void spread(){
        int size = water.size();
        for(int i=0; i<size; i++){
            pair p = water.poll();
            for(int j=0; j<4; j++){
                int nx = p.x + dx[j];
                int ny = p.y + dy[j];
                if(nx>=0 && nx<R && ny>=0 && ny<C && map[nx][ny]!='X' && map[nx][ny]!='D'){
                	if(map[nx][ny]!='*') water.add(new pair(nx, ny));
                    map[nx][ny] = '*';
                }
            }
        }
    }
}
