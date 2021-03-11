import java.io.*;
import java.util.*;

public class Main{
	static int N, M;
	static int ans[];
	static boolean[] chk;
	static ArrayList<Integer>[] com;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        N = Integer.parseInt(arr[0]);
        M = Integer.parseInt(arr[1]);
        com = new ArrayList[N+1];
        ans = new int[N+1];
        for(int i=1; i<=N; i++)
            com[i] = new ArrayList<Integer>();
        
        for(int i=0; i<M; i++){
            arr = br.readLine().split(" ");
            com[Integer.parseInt(arr[0])].add(Integer.parseInt(arr[1]));
        }
        
        int max = 0;
        for(int i=1; i<=N; i++) {
        	chk = new boolean[N+1];
        	search(i);
        }
        
        for(int i=1; i<=N; i++)
        	if(max < ans[i])
        		max = ans[i];
        
        StringBuilder res = new StringBuilder("");
        for(int i=1; i<=N; i++)
        	if(ans[i] == max) res.append(i+" ");
        
        System.out.println(res);
    }
    
    static void search(int num) {
    	chk[num] = true;
    	for(int e:com[num]) {
    		if(!chk[e]) {
    			ans[e]++;
    			search(e);
    		}
    	}
    }
}
