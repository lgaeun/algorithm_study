import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		boolean[] occupied = new boolean[n*2];
		int[] a = new int[n*2];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n*2; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		int up = 0, down =n-1, cnt = 0, step = 0; //cur: 마지막 칸에 초기화 
		while(cnt < k) {
			step++;
			up = (up+n*2-1)%(n*2);	 //컨베이어벨트 한 칸 회전 : up,down 한 칸 뒤로 이동 
			down = (down+n*2-1)%(n*2);
			
			if(occupied[down]) occupied[down] = false; //컨베이어가 회전해서 내려가는 위치가 된 로봇 내리기 
			
			int oldest = (up+n*2-1)%(n*2); // 가장 먼저 올라간 로봇부터 이동 
			for(int i = 0; i < n*2-1; i++) { //(n*2)-1 번 확인, for문은 그냥 반복회수만 세는 용도 
				int nxt = (oldest+1)%(n*2);
				if(occupied[oldest] && !occupied[nxt] && a[nxt] > 0) {
					occupied[oldest] = false;
					occupied[nxt] = true;
					if(--a[nxt] == 0) cnt++;
				}
				oldest = (oldest+n*2-1)%(n*2); //하나 뒤의 것을 다음에 탐색하도록 
			}
			if(occupied[down]) occupied[down] = false; //이동해서 내려가는 위치가 된 로봇 내리기
			if(!occupied[up] && a[up] > 0) { //로봇 올리기 
				occupied[up] = true;
				if(--a[up] == 0) cnt++;
			}
		}
        
		System.out.println(step);
	}
}
