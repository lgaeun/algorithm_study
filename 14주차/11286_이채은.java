import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> Heap = new PriorityQueue<Integer>((o1, o2)-> {
			int a = Math.abs(o1);
			int b = Math.abs(o2);
			
			if(a == b) return (o1 > o2)? 1:-1;
			return a - b;
		});
		StringBuilder ans = new StringBuilder("");
		int cnt = 0;
		for(int i=0; i<N; i++) {
			int tmp = Integer.parseInt(br.readLine());
			if(tmp == 0) {
				if(cnt == 0)
					ans.append("0\n");
				else {
					ans.append(Heap.poll()+"\n");
					cnt--;
				}
			}
			else {
				Heap.add(tmp);
				cnt++;
			}
		}
		System.out.println(ans);
	}
}
