import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");
		int n = Integer.parseInt(br.readLine());
		TreeMap<Integer, Long> map = new TreeMap<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			int card = Integer.parseInt(st.nextToken());
			if(map.containsKey(card)) 
				map.put(card, map.get(card) + 1);
			else
				map.put(card, (long) 1);
		}
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++) {
			int cur = Integer.parseInt(st.nextToken());
			if(map.containsKey(cur))
				sb.append(Long.toString(map.get(cur))+" ");
			else
				sb.append("0 ");
		}
		System.out.print(sb.toString());	
	}

}
