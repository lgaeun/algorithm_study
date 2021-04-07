import java.util.*;
import java.io.*;

class XY{
	int x,y;
	public XY(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class _3190 {
	static int[][] map;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	int k = Integer.parseInt(br.readLine());
    	map = new int[n][n];
    	
    	Deque<XY> snake = new ArrayDeque<>();
    	snake.addFirst(new XY(0,0)); // 뱀의 머리 put
    	
    	for(int i = 0; i < k; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int x = Integer.parseInt(st.nextToken())-1;
    		int y = Integer.parseInt(st.nextToken())-1;
    		map[x][y] = 2; // 사과가 있는 곳 
    	}
    	map[0][0] = 1; // 뱀 있는 곳 
    	
    	int l = Integer.parseInt(br.readLine());
    	int dir = 0, prev = 0, time = 0;
    	
    	A:
    	for(int i = 0; i < l; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int X = Integer.parseInt(st.nextToken()); // 시간 
    		char C = st.nextToken().charAt(0);  //방향 
    		
    		for(int j=0; j < X-prev; j++) {
    			time++;
    			XY head = snake.peekFirst();
    			int nx = head.x + dx[dir];
    			int ny = head.y + dy[dir];

    			if(nx<0 || nx>=n || ny<0 || ny>=n || map[nx][ny] == 1) break A; // 벽이나 몸통에 부딪히는 경우  
    			
    			snake.addFirst(new XY(nx, ny)); // 1. 머리이동
    			
    			if(map[nx][ny] == 2) { //2.사과가 있다면, 사과(2)->뱀(1)으로 바꾸기 
    				map[nx][ny] = 1;
    			}else {		//3. 사과가 없다면, 사과없애고 꼬리 비우기(0)
    				map[nx][ny] = 1;
    				XY tail = snake.pollLast();
    				map[tail.x][tail.y] = 0;
    			}
      		}
    		prev = X;
    		dir = (C =='D')? (dir+1)%4 : (dir+3)%4;
    	}
    	
    	System.out.println(time);
	}
	
}
