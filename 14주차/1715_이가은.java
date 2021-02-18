import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Long> pq = new PriorityQueue<>();
		
		for(int i = 0; i < n; i++) 
			pq.add(Long.parseLong(br.readLine()));
		
		long temp = 0;
		while(pq.size() > 1) {
			temp += pq.poll() + pq.poll();
			pq.add(temp);
		}
		System.out.print(pq.poll());
    
	}
}