import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int C = sc.nextInt();
		int res = 0;
		
		int[] house = new int[N];
		for(int i=0; i<N; i++)
			house[i] = sc.nextInt();
		Arrays.sort(house);
		
		int left = 1;
		int right = house[N-1] - house[0], mid;
		
		while(left <= right) {
			int cnt = 1;
			int pre = house[0];
			mid = (left + right)/2;
			
			for(int h : house) {
				if(h-pre >= mid) {
					cnt++;
					pre = h;
				}
			}
			
			if(cnt >= C) {
				res = mid;
				left = mid + 1;
			}
			
			else
				right = mid - 1;
		}
		
		System.out.print(res);
		sc.close();
	}
}
