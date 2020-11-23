import java.io.*;
import java.util.*;

public class _1931 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];
		
		for(int i = 0; i < n ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			
		}
		
		// 종료시간 기준으로 정렬하기 위해 compare() override
		Arrays.sort(arr, new Comparator<int[]>() {
			
			@Override
			public int compare(int[] o1, int[] o2) {
				
				//종료시간 같으면 시작시간으로 오름차순 정렬
				if(o1[1] == o2[1])
					return o1[0]-o2[0];
				
				return o1[1]-o2[1];
			}		
		}
		);
		
		int count = 0;
		int prev_end = 0;	
		
		for(int i = 0; i < n; i++) {
			if(prev_end <= arr[i][0]) {	//직전회의 종료시간이 다음회의 시작시간보다 작거나같으면 
				count++;						//회의추가, 회의종료시간 갱신 
				prev_end = arr[i][1];					
			}
			
		}
		System.out.print(count);
			
	}

}
