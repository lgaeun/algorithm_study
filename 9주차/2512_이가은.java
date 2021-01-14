import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int sum = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum+= arr[i];
		}
		int limit = Integer.parseInt(br.readLine()); // 입력 끝 
		
		Arrays.sort(arr); //정렬
		
		if(sum <= limit)	//요청예산을 다 줄 수 있으면 준다
			System.out.print(arr[n-1]);
		else {			
			int max = 0;	//그렇지 않으면 적어도 1개이상의 도시는 max값을 받아야함. 뒤에서부터 하나씩 빼보면서 확인
			for(int i = n-1; i >= 0; i--) {
				sum -= arr[i];
				int temp = (int) Math.floor((limit - sum)/(n-i));
				
				if(temp > max)
					max = temp;	
			}
			System.out.print(max);
		}	
		
	}
}
