import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		Stack<Integer> stk = new Stack<>();
		int n = Integer.parseInt(br.readLine());
		long cnt=0;
		
		for(int i = 0; i < n; i++) {
			int next = Integer.parseInt(br.readLine());
			
			while(!stk.isEmpty()) {
				if(next >= stk.peek()){
					stk.pop();	
				}
				else break;
			}
			cnt += (long)stk.size(); //자신보다 큰 빌딩의 수 더하기 
			stk.push(next);
		}
		System.out.println(cnt);
		
	}
}