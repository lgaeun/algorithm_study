import java.util.Scanner;
import java.util.LinkedList;

public class Main{
	
	private static int max=0;
	private static LinkedList<Pair> list = new LinkedList<Pair>();
	private static int N;
	private static int M;
	
	private static class Pair{
    	int x;
    	int y;
    	
    	public Pair(int x, int y){
    		this.x = x;
    		this.y = y;
    	}
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        int[][] map = new int[N][M];
        int[][] exmap = new int[N][M];
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                map[i][j] = sc.nextInt();
                if(map[i][j] == 2) {
                	list.add(new Pair(i, j));
                }
            }
        }
        
        wall(map, exmap, 0, 0);
        
        System.out.println(max);
        sc.close();
    }
    
    public static void copy(int[][] arr1, int[][] arr2) {
    	
    	for(int i=0; i<N; i++)
    		for(int j=0; j<M; j++)
    			arr2[i][j] = arr1[i][j];
    	
    }
    
    public static void wall(int[][] map, int[][] exmap, int s, int count) {
    	if(count == 3) {
    		copy(map, exmap);
    		for(Pair p : list) {
    			virus(exmap, p.x, p.y);
    		}
    		int res = safe(exmap);
    		if(res > max) max = res;
    	}
    	
    	else {
    		for(int i=s; i<N*M; i++) {
    			int x = i/M;
    			int y = i%M;
    				if(exmap[x][y] == 0) {
    					exmap[x][y] = 1;
    					wall(map, exmap, s+1, count+1);
    					exmap[x][y] = 0;
    				}
    			}
    		}
    	
    }
    
    public static void virus(int[][] map, int x, int y){
    	 if(map[x][y] == 0) {
    		if(y < M-1) {
    			map[x][y] = 2;
    		    virus(map, x, y+1);
    		    
    		}
            if(x < N-1) {
            	map[x][y] = 2;
                virus(map, x+1, y);

            }
            if(x > 0) {
            	map[x][y] = 2;
                virus(map, x-1, y);

            }
            if(y > 0) {
            	map[x][y] = 2;
                virus(map, x, y-1);
            }
    	 }

            
    }
    
    
    public static int safe(int[][] map) {
    	int safe=0;
    	
    	for(int i=0; i<N; i++)
            for(int j=0; j<M; j++)
                if(map[i][j] == 0) safe++;
    	
    	return safe;
    }
    
    
}
