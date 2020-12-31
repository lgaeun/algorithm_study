import java.util.*;
import java.io.*;

public class simple {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String word = br.readLine(); 
		boolean tag = false;
		Stack<Character> stk = new Stack<>();
		
		for(int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			//태그인 경우
			if(ch == '<') {	//태그 시작
				while(!stk.isEmpty()) bw.write(stk.pop());
				tag = true;
				bw.write(ch);
			}
			else if(ch == '>') { //태그 끝
				tag = false;
				bw.write(ch);
			}
			else if(tag) {	//태그 내부
				bw.write(ch);
			}

			//태그 밖인 경우
			else {
				if(ch == ' ') {  //공백일때 
					while(!stk.isEmpty()) bw.write(stk.pop());
					bw.write(" ");
				}
				else		//알파벳일때
					stk.push(ch);
			}
		}
		while(!stk.isEmpty()) bw.write(stk.pop());
		bw.flush();
		bw.write(" ");	
		bw.close();
	
	}

}
