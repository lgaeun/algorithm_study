import java.io.*;
import java.util.*;


public class _1339 {

	public static void main(String[] args) throws IOException {
		
		int[] coeff = new int[26]; 	// 알파벳의 계수 저장 
		int sum = 0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			String input = br.readLine();
			int len = input.length();
			for(int j = 0; j < len; j++) {
				int alphabet = (int)(input.charAt(j)-65);			 
				coeff[alphabet] += (int) Math.pow(10, len-1-j);	 //계수 = 10의자리수만큼 더한 값  
			}
		}
		
		Arrays.sort(coeff);
		
		int i = 25, num = 9;
		while(coeff[i]!=0) {		//큰 계수 순으로 9부터 차례로 곱해나가기 
			sum += coeff[i] * num;
			i--;
			num--;	
		}
		System.out.print(sum);
	}

}