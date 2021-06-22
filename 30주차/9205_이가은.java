import java.io.*;
import java.util.*;

public class _9205 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		while(t-->0) {
			int n = Integer.parseInt(br.readLine());
			int[][] map = new int[n+2][2];	//(편의점 + 시작점 + 도착점)의 좌표 
			boolean[] visit = new boolean[n+2]; 
			Queue<int[]> q = new LinkedList<>();
			
			for(int i = 0; i < n+2; i++) {
				String[] line = br.readLine().split(" ");
				map[i][0] = Integer.parseInt(line[0]);
				map[i][1] = Integer.parseInt(line[1]);
			}//입력 
			
			int end_x = map[n+1][0], end_y = map[n+1][1]; //도착좌표 따로 저장
			boolean ishappy = false;
			q.add(map[0]);
			while(!q.isEmpty()) {
				int[] cur = q.poll();
				
				if(cur[0] == end_x && cur[1] == end_y) {
					ishappy = true;
					break;
				}
				//모든 노드에 대해서 거리가 1000이하일 경우에만 큐에 삽입 
				for(int i = 1; i < n+2; i++) {
					if(!visit[i] && Math.abs(cur[0] - map[i][0]) + Math.abs(cur[1] - map[i][1]) <= 1000) {
						q.add(map[i]);
						visit[i] = true;
					}
				}
			}
			
			System.out.println(ishappy ? "happy" : "sad");	
		}


	}

}
