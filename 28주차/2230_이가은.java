import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());
		Arrays.sort(arr);
		
		int front = 0, back = 1, min = Integer.MAX_VALUE;
		while(back < N) {
			int diff = arr[back] - arr[front];
			if(diff < M){
                back++;
                continue;
            } 
            if(diff == M) {
                min = M;
                break;
            }
			
			front++;
			if(diff < min) min = diff;
			
		}
		System.out.println(min);
	}
}
