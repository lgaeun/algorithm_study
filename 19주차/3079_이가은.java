import java.util.*;
import java.io.*;

public class Main{

	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String[] len = br.readLine().split(" ");
    	int n = Integer.parseInt(len[0]); 
    	int m = Integer.parseInt(len[1]); 
    	
    	int[] t = new int[n];
    	long maxTime = 0;
    	for(int i = 0; i < n; i++) {
    		t[i] = Integer.parseInt(br.readLine());
    		maxTime = Math.max(maxTime, t[i]);
    	}
    	
    	long low = 0;
    	long high = m * maxTime;
    	long res = Long.MAX_VALUE; // 최종 걸린 시간을 안다면 몇명이 지나갈 수 있는지 계산 가능 
        while(low <= high) {
        	long mid = (low+high)/2;
        	
        	long total = 0;
        	for(int i = 0; i < n; i++) total += mid/t[i]; // mid 시간안에 지나갈 수 있는 사람 수 
        	
        	if(total >= m) {
        		res = Math.min(res, mid);
        		high = mid - 1;
        	}
        	else low = mid + 1;
       
        }
        System.out.println(res);
    } 
}
