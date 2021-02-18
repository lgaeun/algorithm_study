import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int[] arr = new int[m];
		
		for(int i = 0; i < m; i++) //입력받기 
			arr[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(arr); //정렬
		
		int ans = 0;
		int left = 1, right = arr[m-1] - arr[0]; //가능한 최소거리와 최대거리 
		
		while(left <= right) {
			int mid = (left + right) / 2;
			int cnt = 1;
			int start = arr[0];
			
			for(int i = 1; i < m; i++) {
				if(arr[i] - start >= mid) { //설정한 간격 >= mid이면 공유기 설치
					cnt++;
					start = arr[i];
				}
			}
			if(cnt >= n) { //공유기가 더 많이 설치되면 간격늘리기 
				ans = mid;
				left = mid + 1;
			}else {
				right = mid -1;
			}	
		}
		System.out.println(ans); 
	}
}