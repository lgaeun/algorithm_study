package week1;
import java.util.*;

public class Rope {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		int[] greedy= new int[n];
		int max=0;
		
		for (int i=0; i<n; i++) {
			arr[i]=sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		
		for (int i=0; i<n;i++) {
			greedy[n-i-1]=arr[n-i-1]*(i+1);
		}
		
		for(int i=0; i<n;i++) {
			if (greedy[i]>max)
				max=greedy[i];
		}
		
		System.out.println(max);
		
	}
	
}
