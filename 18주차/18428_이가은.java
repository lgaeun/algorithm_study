import java.util.*;
import java.io.*;

public class Main {
	static char[][] map;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static int n;
	static boolean flag = false;
	static ArrayList<int[]> teacher = new ArrayList<>(); //선생님의 위치(x,y)
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	n = Integer.parseInt(br.readLine());
    	map = new char[n][n];
    	
    	for(int i = 0; i < n; i++) {  //입력 
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		for(int j = 0;  j < n; j++) {
    			map[i][j] = st.nextToken().charAt(0);
    			if(map[i][j] == 'T') 
    				teacher.add(new int[] {i,j}); //입력받으며, 선생님 위치 저장
    		}
    	}
    	choose(0,0,0);
      
    	if(flag) System.out.println("YES");
    	else System.out.println("NO");
    }
  
    static void choose(int x, int y, int depth) {   //백트래킹 - 장애물 놓을 위치 고르기 
    	if(flag) return;  //flag가 true로 바뀐 케이스가 있으면, 다른 경우는 살펴볼 필요가 없으므로 다른 경우들에 대해서 종료
    	
    	if(depth == 3) {
    		if(check()) flag = true;
    		return;
    	}
    	for(int i = x; i < n; i++) { 	
    		int y_start = (i==x) ? y : 0;	//같은 row에 대해서:y-0 까지, 그 아래의 row들에 대해서:0-n 까지 y선택 가능 
    		for(int j = y_start; j < n; j++) {
    			if(map[i][j] == 'X') {
    				map[i][j] = 'O';
    				choose(i,j+1,depth+1);
    				map[i][j] = 'X';
    			}
    		}
    	}
    }
    static boolean check() {
    	for(int[] loc : teacher) {
    		for(int i = 0; i < 4; i++) { //상하좌우 방향에 대해서, while문 이용 각 방향으로 끝/장애물에 다다를때 까지 쭉 확인 
    			int x = dx[i] + loc[0];
    			int y = dy[i] + loc[1];
    			
    			while(true) {
    				if(x<0 || x>=n || y <0 || y>=n || map[x][y] == 'O' ) break;	//끝에 다다르거나, 장애물을 만나면 더 확인할 필요가 없으므로 break 
    				if(map[x][y] == 'S') return false; //학생이 보이면 false 반환 
    				
    				x += dx[i];
    				y += dy[i];
    			}
    		}
    	}
    	return true;
    }
}
