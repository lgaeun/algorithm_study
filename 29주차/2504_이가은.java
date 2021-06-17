package week29;

import java.io.*;
import java.util.*;

public class _2504 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stk = new Stack<>();
		int ans = 0, tmp = 1;
		boolean isFalse = false;
		
		String line = br.readLine();
		for(int i = 0; i < line.length(); i++) {
			char c = line.charAt(i);
			if(c == '(') {
				stk.push(c);
				tmp *= 2; 
			}
			else if(c == '[' ) {
				stk.push(c);
				tmp *= 3;
			}
			else if(c == ')') {
				if(!stk.isEmpty() && stk.peek() == '(') {
					if(line.charAt(i-1) == '(') ans += tmp;	
				}else {
					isFalse = true;	// 맨 마지막에 ) 오는 경우를 위해 isFalse check
					break;
				}
				stk.pop();
				tmp /= 2;
			}
			else if(c == ']') {
				if(!stk.isEmpty() && stk.peek() == '[') {
					if(line.charAt(i-1) == '[') ans += tmp;
				}else {
					isFalse = true; // 맨 마지막에 ] 오는 경우를 위해 isFalse check
					break;
				}
				stk.pop();
				tmp /= 3;
			}
	
		}
		
		if(!stk.isEmpty() || isFalse) System.out.println(0);
		else System.out.println(ans);

	}

}
