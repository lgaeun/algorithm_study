import java.util.*;
import java.io.*;

public class simple {
 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		PriorityQueue<Long> heap = new PriorityQueue<>();
		
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			long x = Integer.parseInt(br.readLine());
			if(x > 0) 
				heap.add(x);
			else {
				if(!heap.isEmpty()) 
					bw.write(heap.poll().toString()+"\n");
				else bw.write("0\n");
			}
		}
		bw.flush();
		bw.close();		
	}
	
}