import java.io.*;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringBuilder sb = new StringBuilder("");
		Stack<Character> stk = new Stack<>();
		
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			//1. 피연산자를 만나면 바로 출력한다 
			if(c >= 'A' && c <= 'Z') sb.append(c);
			//2. 연산자를 만나면 스택에서 우선순위가 같거나 높은것은 pop한 뒤, 자신을 스택에 넣는다 
			else if( c == '+' || c == '-') {
				while(!stk.isEmpty()) {
					if(stk.peek() == '*' || stk.peek() == '/' || stk.peek() == '-' || stk.peek() == '+') 
						sb.append(stk.pop());
					else break;
				}
				stk.push(c);
			}
			else if(c == '/' || c == '*') {
				while(!stk.isEmpty()) {
					if(stk.peek() == '*' || stk.peek() == '/') sb.append(stk.pop());
					else break;
				}
				stk.push(c);
			}
			//3. '('를 만나면 스택에 바로 넣는다.
			else if( c == '(') stk.push(c);
			//4. ')'를 만나면 '('가 스택에서 나올 때 까지 pop한다. 
			else if( c == ')') {
				while(!stk.isEmpty()) {
					if(stk.peek() == '(') {
						stk.pop();
						break;
					}else {
						sb.append(stk.pop());
					}
				}
			}
		}
		while(!stk.isEmpty()) 
            sb.append(stk.pop()); //스택에 남은거 출력 
		System.out.println(sb.toString());
	}

}
