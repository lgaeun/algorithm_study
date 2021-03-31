import java.io.*;
import java.util.*;

public class Main {

	static int[] dx = {0,-1,0,1}, dy = {1,0,-1,0};	//동,북,서,남 
	
	static int[][] map;
	static int[] cam_num = new int[8]; //카메라의 번호
	static int[][] cam_pos = new int[8][2]; //카메라의 위치 
	static int[][] dir;	//최종적으로 카메라가 바라보고 있는 방향
	
	static int n, m, cnt, blind, min; //카메라의 개수, 사각지대의 개수 
	
	static int[] switchDir = {4,2,4,4,1}; 	//i번째 카메라가 방향 회전시킬 수 있는 횟수 
	static int[][] cam1 = {{0},{1},{2},{3}}; //cam이 볼 수 있는 방향의 순서쌍의 집합 
	static int[][] cam2 = {{0,2},{1,3}};	
	static int[][] cam3 = {{0,1},{1,2},{2,3},{3,0}};	
	static int[][] cam4 = {{0,1,2},{1,2,3},{2,3,0},{3,0,1}};	
	static int[][] cam5 = {{0,1,2,3}};	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]>= 1 && map[i][j] <= 5) {
					cam_pos[cnt][0] = i;
					cam_pos[cnt][1] = j;
					cam_num[cnt] = map[i][j];
					cnt++;
				}
				if(map[i][j] == 0) blind++; //초기의 사각지대 개수 저장
			}
		}
		dir = new int[cnt][];  //dir배열에 카메라가 볼 방향을 선택해서 저장 
		min = blind;           //min은 비교해서 작은것으로 갱신되어야 하는 값이니까 blind != min
		
		setDir(0);
		System.out.println(min);
	}
	
	static void setDir(int depth) {
		if(depth == cnt) {
			min =  Math.min(min, watch());	
			return;
		}
		for(int j = 0; j < switchDir[cam_num[depth]-1]; j++) {  //switchDir에서 1번 카메라는 0번 index에 저장했기 때문에, switchDir[camN -1]
			switch(cam_num[depth]) {
			case 1: dir[depth] = cam1[j]; break;  //카메라가 회전할 수 있는 케이스에 대해서, 각 카메라가 감시할 수 있는 방향의 순서쌍을 고르기
			case 2: dir[depth] = cam2[j]; break;
			case 3: dir[depth] = cam3[j]; break;
			case 4: dir[depth] = cam4[j]; break;
			case 5: dir[depth] = cam5[j]; break;
			}
			setDir(depth+1);
		}	
	}
  
	static int watch() {
		int total = blind; //total 사각지대 개수에서 카메라로 볼 수 있는 구역은 빼면서 카운트 
		boolean[][] visit = new boolean[n][m];
		
		for(int i = 0; i < cnt; i++) { //i번째 카메라에 대해서 
			for(int j = 0; j < dir[i].length ; j++) {	// 감시할 수 있는 방향(curD)에 대해서
				int curD = dir[i][j];
				int nx = dx[curD] + cam_pos[i][0]; 
				int ny = dy[curD] + cam_pos[i][1];
				while(true) {
					if(nx < 0 || nx >= n || ny < 0 || ny >= m || map[nx][ny] == 6) break; //벽이든 캠이든 만나면 거기서 짤 
					if(!visit[nx][ny] && map[nx][ny] == 0) {   //중복으로 감시되는 것에 대해서는 visit으로 중복 제거
						visit[nx][ny] = true;
						total--;
					}
					nx += dx[curD];
					ny += dy[curD];
				}	
			}
		} return total;
	}

}
