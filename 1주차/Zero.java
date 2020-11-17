package week1;
import java.util.*;

public class Zero {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int k = sc.nextInt();
		int temp=0;
		
		Stack<Integer> stack = new Stack<>();
		for (int i=0; i<k;i++) {
			temp=sc.nextInt();
			if (temp==0) stack.pop();
			else stack.push(temp);
		}
		
		int sum=0;
		while(!stack.isEmpty()) {
			sum+=stack.pop();
		}
		System.out.println(sum);
		
	}

}
