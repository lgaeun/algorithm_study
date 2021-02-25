import java.io.*;
import java.util.*;

public class Main {
	
	static int n, min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;
	static int[] arr, op;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		op = new int[4];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) 
			arr[i] = Integer.parseInt(st.nextToken());	
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++)
			op[i] = Integer.parseInt(st.nextToken());
		
		select(arr[0], 1);
		System.out.println(max+"\n"+min);
		
	}
	static void select(int sum, int depth) {
		if(depth == n) {
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}
		for(int i = 0; i < 4; i++) {
			if(op[i] > 0) {
				--op[i];
				switch(i) {
				case 0: select(sum + arr[depth] ,depth+1); break;
				case 1: select(sum - arr[depth] ,depth+1); break;
				case 2: select(sum * arr[depth] ,depth+1); break;
				case 3: select(sum / arr[depth] ,depth+1);
				}
				++op[i];
			}
		}
	}
}
	