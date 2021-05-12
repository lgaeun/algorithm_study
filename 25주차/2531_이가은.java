import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int d = Integer.parseInt(st.nextToken()); //초밥 종류 
    	int k = Integer.parseInt(st.nextToken()); //연속해 먹는 개수 
    	int c = Integer.parseInt(st.nextToken()); //coupon 번호 
    	
    	int[] arr = new int[N];
    	int[] visit = new int[d+1];
    	
    	for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());
    	
    	int max = 0, cnt = 0;
    	for(int i = 0; i < k; i++) {
    		if(visit[arr[i]] == 0) cnt++;
    		visit[arr[i]]++;
    	}//초기화 
    	
    	for(int i = 1; i < N; i++) { 
    		if(max <= cnt) { //Max 갱신할 필요 있을 때 
    			if(visit[c] == 0) max = cnt+1;
    			else max = cnt;
    		}
    		visit[arr[i-1]]--; //제일 앞 초밥 내려놓기 
    		if(visit[arr[i-1]] == 0) cnt--;
    		
    		if(visit[arr[(i + k - 1) % N]] == 0) cnt++; //제일 뒷초밥 올리기 
    		visit[arr[(i + k - 1) % N]]++;
    	}
    	
    	System.out.println(max);
	}

}
