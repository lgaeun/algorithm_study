package week1;
import java.util.*;

public class Rope {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		int tmp=0;
		int max=0;
		
		for (int i=0; i<n; i++) {
			arr[i]=sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		
		for (int i=0; i<n;i++) {
			tmp=(n-i)*arr[i];
			if (max<tmp) max=tmp;
		}
		
		
		System.out.println(max);
		
	}
	
}
