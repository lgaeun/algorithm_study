import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				if(Math.abs(o1) != Math.abs(o2)) return Math.abs(o1)-Math.abs(o2);
				else return o1-o2;
			}
		});
		for(int i = 0; i < n; i++) {
			int input = Integer.parseInt(br.readLine());
			if(input == 0) {
				if(!pq.isEmpty()) sb.append(pq.poll() + "\n");
				else sb.append(0 + "\n");
			}
			else pq.add(input);
		}
		System.out.print(sb);
	
	}
}
