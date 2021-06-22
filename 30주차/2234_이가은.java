import java.io.*;
import java.util.*;

public class _2234 {
	
	static int n,m;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = {0,-1,0,1}; //서, 북, 동, 남 
	static int[] dy = {-1,0,1,0};
	static ArrayList<HashSet<Integer>> edge = new ArrayList<>(); //방(노드)간의 연결관계 hashset으로 표시

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[m][n];
		visit = new boolean[m][n];
		ArrayList<Integer> sizes = new ArrayList<>();
    
    		for(int i = 0; i < n*m; i++) edge.add(new HashSet<>()); //hashset 초기화
    
		int maxSize = 0, roomCnt = 0, maxCombine = 0;
		int roomIdx = 0;
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}//입력
		
		for(int i = 0; i < m; i++) {	//bfs 돌면서 방크기, 개수 저장
			for(int j = 0; j < n; j++) {
				if(!visit[i][j]) {
					int tmp = bfs(i,j, roomIdx++);
					sizes.add(tmp);
					maxSize = Math.max(maxSize, tmp);
					roomCnt++;
				}
			}
		}
		
		//엣지로 연결된 두 노드의 합 중 최대값 구하기
		for(int i = 0; i < sizes.size()/2 + 1; i++) {
            	Iterator<Integer> iter = edge.get(i).iterator(); //hashset iterator 
	        while( iter.hasNext() ){
	            maxCombine = Math.max(maxCombine, sizes.get(i) + sizes.get(iter.next()) );
	        }
        }
        
		System.out.println(roomCnt+"\n" + maxSize +"\n" + maxCombine);
	}
	
	static int bfs(int x, int y, int node) {
		visit[x][y] = true;
		int size = 1;
		Queue<XY> q = new LinkedList<>();
		q.add(new XY (x,y));
		
		while(!q.isEmpty()) {
			XY cur = q.poll();
			int val = map[cur.x][cur.y];
			map[cur.x][cur.y] = node; //벽의개수 -> 노드 번호로 치환 
			
			for(int i = 0; i < 4; i++) {
				int nx = dx[i] + cur.x;
				int ny = dy[i] + cur.y;
				if(val % 2 == 0) {  //이진수변환 -> '0'인 것만 탐색
					if(nx >= 0 && nx < m && ny >= 0 && ny < n && !visit[nx][ny]) {
						visit[nx][ny] = true;
						size++;
						q.add(new XY(nx,ny));
					}
				}
				else {
					if(nx >= 0 && nx < m && ny >= 0 && ny < n && visit[nx][ny] && map[nx][ny] != node) { //이미 라벨링한 것(visit) 중에서, 내 방이아닌 것(=인접한 다른 방) 
						int next = map[nx][ny];
						if(!edge.get(node).contains(next)) {	//이미 라벨링된 그 방만 set에 연결 표시 
							edge.get(next).add(node);
						}
					}
				}
				val /= 2;
			}
		}
		return size;	
	}
}
class XY{
	int x, y;
	public XY(int x, int y) {
		this.x = x; this.y = y;
	}
}
