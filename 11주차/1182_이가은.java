import java.util.*;

public class Main {
	
	static int s,n, cnt=0;
	static int[] arr;
	
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		s = sc.nextInt();
		arr = new int[n];	
		
		for(int i = 0; i < n; i++) 
            arr[i] =  sc.nextInt();
		
		Arrays.sort(arr);
		dfs(0,0);
		System.out.print(s == 0? --cnt : cnt);	//cnt=0인경우 공집합도 포함되므로	
	}
	static void dfs(int idx, int sum) {
		if(idx == n) {
			if(sum == s) cnt++;
			return;
		}
		dfs(idx+1, sum + arr[idx]); //현재 원소를 포함하는 경우 
		dfs(idx+1, sum); //현재 원소를 포함하지 않는 경우
	}
}