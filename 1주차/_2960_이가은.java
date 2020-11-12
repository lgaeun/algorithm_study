package 구현;
import java.util.*;

public class _2960 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n+1];
		int k = sc.nextInt();
		int count = 0;
		
		for(int i = 1; i <= n; i++)
			arr[i] = i;
		A: 
		for(int i = 2; i <= n; i++) {
			for(int j = i+1; j <= n; j ++)
			{	
				if(arr[j] == 0) continue;
				
				if(arr[j] % i == 0 ) arr[j] = 0;
				else{
					count++;
					
					if(count == k) System.out.print(arr[j]);
				}
			}
		}
	}

}
