import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
	static int[] num;
	static int[] op;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		num = new int[n];
		op = new int[4];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++) {
			op[i] += Integer.parseInt(st.nextToken());
		}
		calc(0,num[0]);
		System.out.println(max+"\n"+min);
	}
  
	static void calc(int depth,int sum) {
		if(depth == n-1) {
			min = Math.min(min, sum);
			max = Math.max(max, sum);
			return;
		}
		for(int i = 0; i < 4; i++) {
			if(op[i] > 0) {
				op[i]--;
				switch(i) {
				case 0: calc(depth+1, sum + num[depth+1]); break;
				case 1: calc(depth+1, sum - num[depth+1]); break;
				case 2: calc(depth+1, sum * num[depth+1]); break;
				case 3: calc(depth+1, sum / num[depth+1]); break;
				}
				op[i]++;
			}
		}
	}

}
