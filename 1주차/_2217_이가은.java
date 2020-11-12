package 구현;
import java.util.Arrays;
import java.util.Scanner;

public class _2217 {
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] r = new int[n];
		int min = 1000001 , w = 0;
		
		for(int i = 0; i < n; i++) {
			r[i] = sc.nextInt();
		}
		Arrays.sort(r);
		
		for(int i = 0; i < n; i++) 
			min = min < r[i]?  min : r[i];
		
		System.out.print(min*n);
			
		

	}

}
