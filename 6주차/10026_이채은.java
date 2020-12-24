import java.io.*;

public class Main{
    
    private static int N;
    private static char[][] map;
    private static int[][] map2;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        map2 = new int[N][N];
        int RGB = 0; int RB = 0;

        for(int i=0; i<N; i++) {
        	char[] arr = br.readLine().toCharArray();
        	for(int j=0; j<N; j++) {
        		map[i][j] = arr[j];
        	}
        }
        
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map2[i][j] == 0){
                	RGB++;
                	findRGB(map[i][j], i, j);
                }
            }
        }
        
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                map2[i][j] = 0;
            }
        }
        
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map2[i][j] == 0){
                	RB++;
                	findRB(map[i][j], i, j);
                }
            }
        }
        
        System.out.println(RGB+" "+RB);
        br.close();
    }
    
    public static void findRGB(char s, int x, int y) {
    	char val = map[x][y];
    	if(map2[x][y] == 0 && val == s) {
    		map2[x][y] = 1;
            for(int i=0; i<4; i++){
            	if(x+dx[i]>-1 && y+dy[i]>-1 && x+dx[i]<N && y+dy[i]<N)
            		findRGB(val, x+dx[i], y+dy[i]);
            }
    	}	
    }
    
    public static void findRB(char s, int x, int y) {
    	char val = map[x][y];
    	if(map2[x][y] == 0) {
            if(val == s){
    		    map2[x][y] = 1;
                for(int i=0; i<4; i++){
                	if(x+dx[i]>-1 && y+dy[i]>-1 && x+dx[i]<N && y+dy[i]<N)
                		findRB(val, x+dx[i], y+dy[i]);
                }
            }
            else if(val != 'B' && s != 'B'){
                map2[x][y] = 1;
                for(int i=0; i<4; i++){
                	if(x+dx[i]>-1 && y+dy[i]>-1 && x+dx[i]<N && y+dy[i]<N)
                		findRB(val, x+dx[i], y+dy[i]);
                }
            }
    	}
    }
}
