package week1;
import java.util.*;

public class Eratosthenes {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc. nextInt();
		int k =sc.nextInt();
		 
		int count=0;
		int base=2;
		int temp=0;
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		 
		for (int i=2; i<=n; i++) {
			list.add(i);
		}
	
		int j=0;
		while(count<k) {
			j=0;
			while(j<list.size()) {
				temp=list.get(j);
				if (temp%base==0) {
					list.remove(j);
					count++;
				}
				else j++;
				
				if (count==k) break;
			}
			if (!list.isEmpty()) base=list.get(0);
		}
		
		System.out.println(temp);
		 
		 
	}

}
