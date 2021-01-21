import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main{
    static int M, N, K;
    static int[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        K = sc.nextInt();
        map = new int[M][N];
        for(int i=0; i<K; i++){
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            for(int j=y1; j<y2; j++)
                for(int k=x1; k<x2; k++)
                    map[j][k] = 1;
        } //직사각형 입력 받으면서 그림에 표시
        
        int cnt=0;
        ArrayList<Integer> area = new ArrayList<Integer>();
        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j]==0) {
                	cnt++;
                	area.add(DFS(1, i, j));
                }
            }
        } //빈 영역 개수 세면서 area에 면적 저장
        
        System.out.println(cnt);
        Collections.sort(area);
        while(!area.isEmpty()) {
        	System.out.print(area.remove(0)+" ");
        }
        
    }
    
    public static int DFS(int ar, int y, int x){
        map[y][x] = 2;
        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>=0 && nx<N && ny>=0 && ny<M && map[ny][nx]==0)
                ar+=DFS(1, ny, nx);
        }
        return ar;
    }
}
