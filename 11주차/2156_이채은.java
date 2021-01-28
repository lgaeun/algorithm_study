import java.io.*;

public class Main{
    static int n;
    static int[] wine;
    static int[] max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        wine = new int[n+1];
        max = new int[n+1];
        for(int i=1; i<=n; i++)
            wine[i] = Integer.parseInt(br.readLine());
        
        dp();
        
        System.out.println(max[n]);
    }
    
    public static void dp() {
    	max[1] = wine[1];
    	if(n==1) return;
    	
    	max[2] = wine[1]+wine[2];
    	if(n==2) return;
    	
    	for(int i=3; i<=n; i++) {
    		max[i] = maximum(max[i-2]+wine[i], max[i-3]+wine[i-1]+wine[i], max[i-1]);
    	}
    }
    
    public static int maximum(int a, int b, int c){
        int res = (a>b)? a:b;
        res = (res>c)? res:c;
        
        return res;
    }
}
