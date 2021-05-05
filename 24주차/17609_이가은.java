import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		while(N-- >0) {
			int state = 0;
			String s = br.readLine();
			bw.write(check(s, 0, s.length()-1, state) +'0');
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
	
	static int check(String s, int start, int end, int state) {
		if(state == 2) return 2;
		
		if(start > end) return state; //홀수일 때, 중간 char인 경우 
		
		if(start == end) { 	//짝수 일 때, 중간 두 개인 경우 
			if(s.charAt(start) == s.charAt(end)) return state;
			else return 2;
		}
		
		if(s.charAt(start) == s.charAt(end)) return check(s, start+1, end-1, state);
		else {
			int left_out = check(s, start+1, end, state+1);
			int right_out = check(s, start, end-1, state+1);
			if(left_out == 1 || right_out == 1) return 1; //왼쪽과 오른쪽 지운 것들 중 하나라도 유사회문이면 1;
			else return 2;
		}
		
	}

}
