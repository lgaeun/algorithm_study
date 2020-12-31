import java.io.*;
import java.util.*;

public class _1759 {
	
	static String[] alpha;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int l,c;

	public static void main(String[] args) throws IOException {
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		alpha = br.readLine().split(" ");

		Arrays.sort(alpha);
		
		find(0,"");
		bw.flush();

	}
	
	static void find(int idx, String pwd) throws IOException {
		// 길이가 l이고, 자음모음조건 만족하면 출력 
		if(pwd.length() == l && isValid(pwd)) {
			bw.write(pwd + "\n");
			return;
		}
		if(idx >= c) return;
		
		find(idx + 1, pwd + alpha[idx]);	//현재 알파벳 포함하는 경우 
		find(idx + 1, pwd);					//현재 알파벳 건너뛰는 경우
	
	}
	//문자열이 자음2, 모음1이상을 만족하는지 확인 
	static boolean isValid(String s) {
		int vowel = 0, consonant = 0;
		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if(ch =='a' || ch =='e' || ch =='i' || ch =='o' || ch =='u')
				vowel++;
			else
				consonant++;
		}
		return vowel >= 1 && consonant >= 2;
	}
	
}
