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
		StringTokenizer st;
    	int n = Integer.parseInt(br.readLine());
    	int k = Integer.parseInt(br.readLine());
    	map = new int[n][n];
    	
    	Deque<XY> snake = new ArrayDeque<>();
    	snake.addFirst(new XY(0,0)); // 뱀의 머리 put
    	
    	for(int i = 0; i < k; i++) {
    		st = new StringTokenizer(br.readLine());
    		int x = Integer.parseInt(st.nextToken())-1;
    		int y = Integer.parseInt(st.nextToken())-1;
    		map[x][y] = 2; // 사과가 있는 곳 
    	}
    	map[0][0] = 1; // 뱀 있는 곳 
    	
    	int l = Integer.parseInt(br.readLine());
    	
    	st = new StringTokenizer(br.readLine());
		int X = Integer.parseInt(st.nextToken()); // 첫입력 시간 
		char C = st.nextToken().charAt(0);  //첫 입력 방향 
    	int dir = 0, time = 0, idx=1;
    	
    	/*
    	 * 오답분석: 기존코드에서 시간이 입력되지 않으면 for문이 돌아가지 않아서 뱀이 움직이지 않음 
    	 * 시간과 방향은 한 번에 입력되지만, 방향이 실제로 변경되는 건 그 시간이 지난 이후이기 때문에 엇박임
    	 * 입력의 갯수로 뱀을 움직이는 for문을 돌리면, 마지막 입력에 따른 방향 변경이 되지 않아서 오류.
    	 * 따라서 for -> while 로 변경, while문 마지막에 direction 변경하고 입력 받기 
    	 */
    	while(true) {
    		time++;
    		XY head = snake.peekFirst();
    		int nx = head.x + dx[dir];
			int ny = head.y + dy[dir];
			
			if(nx<0 || nx>=n || ny<0 || ny>=n || map[nx][ny] == 1) break; // 벽이나 몸통에 부딪히는 경우 
			
			snake.addFirst(new XY(nx, ny)); // 1. 머리이동
			
			if(map[nx][ny] == 2) { //2.사과가 있다면, 사과(2)->뱀(1)으로 바꾸기 
				map[nx][ny] = 1;
			}else {		//3. 사과가 없다면, 사과없애고 꼬리 비우기(0)
				map[nx][ny] = 1;
				XY tail = snake.pollLast();
				map[tail.x][tail.y] = 0;
			}
			
			if(time == X) {
				if(C =='D')	
					dir = (dir+1)%4; //오른쪽으로 돌기 
				else 
					dir = (dir+3)%4; // 왼쪽으로 돌기 
				
				if(idx < l) { // 입력된 명령어의 개수만큼만 X,C받기 
					st = new StringTokenizer(br.readLine());
					X = Integer.parseInt(st.nextToken()); // 시간 
					C = st.nextToken().charAt(0);  //방향 
				}
				idx++;
			}
    	}
    	
    	System.out.println(time);
	}
	
}
