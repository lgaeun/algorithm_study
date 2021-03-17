import java.util.*;
import java.io.*;

public class Main {
	
	static int P,Q;
	static HashMap<Long,Long> map = new HashMap<>();	//Hashmap을 이용해 dp 구현. (N <= 10의 12승 & N/Q, N/P 연속적X)
	
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String[] in = br.readLine().split(" ");
    	long N = Long.parseLong(in[0]);
    	P = Integer.parseInt(in[1]);
    	Q = Integer.parseInt(in[2]);
    	
    	System.out.println(find(N));
    }
    static long find(long n) {
    	if(n == 0) return 1;
    	
    	if(map.containsKey(n)) return map.get(n);
    	
    	map.put(n, find(n/P) + find(n/Q));
    	
    	return map.get(n);	
    }
}
