import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long[] arr = new long[31];
		arr[0] = 1; arr[1] = 1; arr[2] = 2;
		
		for(int i=3; i<=30; i++) {
			long temp = 0;
			for(int j=0; j<i; j++) {
				temp+=arr[j]*arr[i-1-j];
			}
			arr[i] = temp;
		}
		
		while(true) {
			int N = sc.nextInt();
			if(N==0) break;
			System.out.println(arr[N]);
		}
		sc.close();
	}
}
