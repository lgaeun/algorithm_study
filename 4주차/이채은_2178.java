import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
	
	private static LinkedList<Integer> list = new LinkedList<Integer>();
	
	public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken()); 
        int M = Integer.parseInt(st.nextToken());
        int[][] maze = new int[N][M];

        for(int i=0; i<N; i++) {
        	String s = bf.readLine();
        	String[] arr = s.split("");
        	for(int j=0; j<M; j++)
        		maze[i][j] = Integer.parseInt(arr[j]);
        }
        
        path(maze, N, M, 0, 0);
        System.out.println(maze[N-1][M-1]); //거쳐온 지점 수 
    }
	
	public static void path(int[][] g, int N, int M, int currx, int curry) {
		
		if(currx != N || curry != M) {
			if(currx < N-1)
				search(g, 4, currx, curry);
			if(curry < M-1)
				search(g, 2, currx, curry);
			if(curry > 0)
				search(g, 1, currx, curry);
			if(currx > 0)
				search(g, 3, currx, curry);
    		
    		while(!list.isEmpty()) {
    			int x = list.remove();
    			path(g, N, M, x/1000, x%1000);
    		}
		} //(N,M)에 도달할 때까지 탐색

	}
    
    public static void search(int[][] g, int ver, int x, int y){
    	int n = g[x][y];
    	
        switch(ver){
            case 1://상
                if(g[x][y-1]==1 && !check(x, y-1)) {
                	list.add(x*1000+y-1);
                	g[x][y-1]=n+1;
                }
                break;
            case 2://하
                if(g[x][y+1]==1 && !check(x, y+1)) {
                	list.add(x*1000+y+1);
                	g[x][y+1]=n+1;
                }
                break;
            case 3://좌
                if(g[x-1][y]==1 && !check(x-1, y)) {
                	list.add((x-1)*1000+y);
                	g[x-1][y]=n+1;
                }
                break;
            case 4://우
                if(g[x+1][y]==1 && !check(x+1, y)) {
                	list.add((x+1)*1000+y);
                	g[x+1][y]=n+1;
                }
                break;
        }//움직일 때마다 움직인 횟수만큼의 값으로 
    }
    
    public static boolean check(int x, int y) {
    	if(list.contains(1000*x+y)) return true;
    	return false;
    } //스택에 이미 있는 값인지 체크
    
}
