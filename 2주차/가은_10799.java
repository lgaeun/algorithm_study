import java.util.*;

public class _10799 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Character> stk = new Stack<>();
		String stick = sc.next();
		int count = 0;
			
		for(int i = 0; i < stick.length(); i++) 
		{
			char curr = stick.charAt(i);
			if(curr == '(') stk.push(curr);	// '('이면 스택에 넣기 
			else 
			{
				if(stick.charAt(i-1) =='(') {		// ray 일 때 
					stk.pop(); 				// ray빼고 잘린막대기 카운트 
					count += stk.size();
				}
				else {						// 막대기 끝 일 때
					count ++;				
					stk.pop();
				}
			}
		}
		System.out.print(count);
		
	}
}
