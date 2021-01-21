import java.util.*;
import java.io.*;

public class simple {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] dist = stoi(br.readLine().split(" "));
		int[] cost = stoi(br.readLine().split(" "));
	
		long sum = 0;
		int min = cost[0]; // 이전까지 중 최소 주유비

		//현재 도시의 주유비 이전 주유비보다 쌀 경우 min 갱신
		for(int i = 0; i < n-1; i++) {
			if(cost[i] < min) {
				min = cost[i];
			}
			sum += (min * dist[i]); //누적 합 
		}
		
		System.out.print(sum);
	
	}
	
	static int[] stoi(String str[]) {
		int[] result = new int[str.length];
		for(int i = 0; i < str.length; i++) 
			result[i] = Integer.parseInt(str[i]);
		
		return result;
	}
	
}

