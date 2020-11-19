import java.io.*;
import java.util.Stack;

//수정 : Scanner, 객체배열, Linkedlist (시간초과) -> BufferedReaer, StringBuilder, stack 사용 

public class _5397 {
	
	static String getPwd(String pwd) {
		
		StringBuilder sb = new StringBuilder();
		Stack<Character> pre = new Stack<>();
		Stack<Character> post = new Stack<>();
		char input;
		
		for(int i = 0; i < pwd.length(); i++) {
			input = pwd.charAt(i);
			
			switch(input) {
			case '<':
				if(!pre.isEmpty()) post.push(pre.pop());	//커서가 맨 앞이 아닐때만 
				break;
			case '>':
				if(!post.isEmpty()) pre.push(post.pop()); //커서가 맨 끝이 아닐때만 
				break;
			case '-':		
				if(!pre.isEmpty()) pre.pop(); 		//커서가 맨 앞이 아닐때만 	 
				break;
			default:
				pre.push(input);
				break;				
			}				
		}
		while (!post.isEmpty()) { 
			pre.push(post.pop()); 
		} 
		for (int i = 0; i < pre.size(); i++) {
			sb.append(pre.elementAt(i)); 
		} 
		return sb.toString();

		
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		String L;
		
		for(int i = 0; i < num; i++) {
			L = br.readLine();
			String pwd = getPwd(L);
			System.out.println(pwd);
		}
		
		
	}
}