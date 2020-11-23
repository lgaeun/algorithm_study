import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1449 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int hole[] = new int[N]; 
		int count = 1;
		
		
		st = new StringTokenizer(br.readLine());	
		for(int i = 0; i < N; i++) {
			hole[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(hole);
		
		
		for(int i = 0; i < N-1; i++) {
			
			float left = (float) (L - 0.5);
			if(hole[i] + left < hole[i+1] + 0.5) {  //다음구멍까지 커버안되면 다음구멍에 붙이기 
				count++;
				left = (float)(L - 0.5);	 //새 테이프 사용 
				
			}
			else // 커버되면 
				left -= hole[i+1] - hole[i];	//남은 테이프길이 갱신
		}
		
		System.out.print(count);
	}

}
