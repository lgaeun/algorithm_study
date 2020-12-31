import java.io.*;
import java.util.*;

public class _1107 {
	
	static boolean[] broken = new boolean[10];
	static int target;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		target = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n ; i++) {
			broken[st.nextToken().charAt(0) - '0'] = true;
		}
		
		int count = 0;
		String Combination = "";
		String t = Integer.toString(target);
		// target의 각 자리수를 돌면서 안 고장난 버튼중에서 target과 가장 가까운 숫자 찾아서 combination에 더하기
		for(int i = 0; i < t.length(); i++) {
			Combination += findBtn(t.charAt(i)-'0');	
			count++;
		}
		
		if(Combination.equals(""))	// 아무버튼도 누르지 않았을 때 
			count = 0;
		else
			count += Math.abs(target - Integer.parseInt(Combination));
		
		System.out.println(count);
	
	}
	
	static String findBtn(int x) {
		int offset = 0;
		int min = Math.abs(100-target) ;
		int index = -1;
		
		for(int i = 0; i < 10; i++) {
			offset = Math.abs(x-i);
			if(!broken[i] && offset < min) {
				min = offset;
				index = i;		
			}
		}
		if (index == -1) return "";
		return Integer.toString(index);
	}

}