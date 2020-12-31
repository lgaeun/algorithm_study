import java.util.*;
import java.io.*;

public class simple {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		String s = br.readLine();
		int cnt = 0;
		int pattern = 0;  // 'IOI'의 개수 
		
		//단순히 IOI개수 세기(n=1일때 1개, n=2일때 2개, n=3일때 3개,...이므로)
		for(int i = 1; i < m-1; i++) {
			if(s.charAt(i-1) == 'I' && s.charAt(i) == 'O' && s.charAt(i+1) == 'I') {
				pattern++;
				if(pattern == n) {	
					pattern--;
					cnt++;
				}
				i++;	// IOI찾았으면 O뒤는 I니까 건너뛰기
			}
			else	pattern = 0;
		}

		System.out.print(cnt);
	}

}