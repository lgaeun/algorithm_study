import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
		Deque<String> res = new ArrayDeque<>();
		int n = Integer.parseInt(br.readLine());
		
		A: 
		for(int i = 0; i < n; i++) {
			String func = br.readLine();
			int len = Integer.parseInt(br.readLine());
			int flag = 1; // 앞은 1, 뒤는 -1
			
			String s = br.readLine();
			s = s.substring(1, s.length()-1);
			StringTokenizer st = new StringTokenizer(s,",");
			for(int j = 0; j < len; j++) 
				res.add(st.nextToken());
			
			for(int j = 0; j < func.length(); j++) {
				if(func.charAt(j) == 'R') flag = -flag;
				else 
					if(res.isEmpty()) {
						bw.write("error\n");
						continue A;
					}
					else
						if(flag == 1)
							res.remove();
						else if(flag == -1) 
							res.removeLast();	
			}
			
			bw.write("[");
			while(true) {
				if(flag == 1) bw.write(res.pollFirst());
				else	bw.write(res.pollLast());
				if(!res.isEmpty()) bw.write(",");
				else break;
			}
			bw.write("]\n");
			res.clear();
		}
		bw.close();
	}

}

/*
<조건>
1. 함수 R: 배열의 순서 뒤집기
2. 함수 D: 배열의 첫 번째 숫자 버리기 (빈 배열일 경우 error 출력)
3. 함수는 조합해서 한 번에 사용 가능 (ex. RDD = R->D->D)
4. 첫째줄: 전체 T(test case)개수, 최대 100개
5. 둘째줄: 1 ≤ p(수행할 함수)길이 ≤ 100,000 
6. 셋째줄: 배열의 크기 n (0 ≤ n ≤ 100,000 )
   넷째줄:[], 배열의 각 원소는 1이상 100이하
7. 전체 테스트케이스에 주어지는 p + n ≤ 700,000

배열 출력하면 [2,1]이 아니라 [2, 1]이 나와서 틀림
*/
