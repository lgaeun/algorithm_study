package tmp;
import java.io.*;
import java.util.*;
public class _11048_최윤재_이동하기 {
	
	static int height;			
	static int width;
	static int[][] map;
	static int[][] dp;		//dp배열
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		map = new int[height+1][width+1];
		dp = new int[height+1][width+1];
		for(int i=1; i<height+1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=1; j<width+1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		////////////////////////////////////////////////////////입력
		for(int i=1; i<height+1; i++) {
			for(int j=1; j<width+1; j++) {
				dp[i][j] = Math.max(dp[i-1][j-1], Math.max(dp[i][j-1], dp[i-1][j])) + map[i][j];	//좌, 위, 대각선 위 왼쪽 중 가장 큰 값 가져오기
			}
		}		
		System.out.println(dp[height][width]);
	}
}
