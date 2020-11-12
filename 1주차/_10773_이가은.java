package 구현;
import java.util.Scanner;
import java.util.Stack;

public class _10773 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cur, sum=0;
		Stack<Integer> stk = new Stack<Integer>();
		
		for(int i = 0; i < n; i++) {
			cur = sc.nextInt();
			if(cur != 0) stk.push(cur);
			else stk.pop();
		}
		
		while(!stk.isEmpty()) {
			sum += stk.peek();
			stk.pop();
		}

		System.out.print(sum);
		

	}

}
