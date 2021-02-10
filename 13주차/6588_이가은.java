import java.io.BufferedReader;
import java.io.*;
import java.util.*;
public class Main {

	static StringBuilder sb = new StringBuilder("");
	static final int MAX = 1000000;
	static int arr[] = new int[MAX+1];
	
	public static void main(String[] args) throws IOException {
		
		for(int i = 2; i <= MAX; i++) { //에라토스테네스의 체: 소수이면 0, 아니면 -1로 표시 
			if(arr[i] != 0) continue; 
			for(int j = i+i; j <= MAX; j+=i) {
				arr[j] = -1; 
			}
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n == 0) break;
			find(n);
		}
		System.out.print(sb.toString());

	}
	static void find(int n) {
		int flag = 0;
		A:
		for(int i = 3; i <= n/2; i++) {
			if(arr[i] == 0 && arr[n-i] == 0) {
				flag = 1;
				String str = n+" = "+i+" + "+(n-i);
				sb.append(str+"\n");
				break A;	
			}
		}
		if(flag == 0) 
			sb.append("Goldbach's conjecture is wrong.\n");	
	}

}
