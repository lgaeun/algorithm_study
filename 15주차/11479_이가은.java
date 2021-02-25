import java.io.*;
import java.util.*;

public class nm {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
		int it = Integer.parseInt(br.readLine());
		
		while(it > 0) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = stoi(br.readLine().split(" "));
			
			Arrays.sort(arr); //1. 정렬 
			
			/*
			 * 2. 인접 수들 간의 차 계산 및 차의 최대값 구하기 
			 *    - 처음(0번): 1, 2번째가 인접수들 
			 *    - 마지막(n-1): n-2,n-3이 인접수들 
			 *    - 중간: 앞 뒤로 하나씩 건너 뛴 수가 인접수들 
			 */
			int max = arr[1]-arr[0];
			for(int i = 0; i < n-2 ; i++) {	
				max = Math.max(max, arr[i+2] - arr[i]);
			}
			max = Math.max(max, arr[n-1] - arr[n-2]); // 제일 마지막과 비교 
			bw.write(max+"\n");
			it--;
		}
		bw.flush();
		bw.close();
    
	}
	static int[] stoi(String[] arr) {
		int[] res = new int[arr.length];
		for(int i = 0; i < arr.length; i++) {
			res[i] = Integer.parseInt(arr[i]);
		}
		return res;
	}
}