import java.util.Scanner;

public class Main{
    static int N, min = 400000;
    static int[][] stat;
    static int[] tm;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        stat = new int[N][N];
        tm = new int[N];
        for(int i=0; i<N; i++)
            for(int j=0; j<N; j++)
                stat[i][j] = sc.nextInt();
        
        team(0, 0);
        System.out.println(min);
        sc.close();
    }
    
    public static void team(int num, int p){
        tm[p] = 1;
        
        if(num == N/2-1){
            calc();
            return;
        }
            
        else{
            for(int i=p+1; i<N; i++) {
                team(num+1, i);
                tm[i] = 0;
            }
        }
    }
    
    public static void calc() {
    	int[] start = new int[N/2];
    	int[] link = new int[N/2];
    	int s = 0, l = 0;
    	for(int i=0; i<N; i++) {
    		if(tm[i]==0)
    			start[s++] = i;
    		else
    			link[l++] = i;
    	}
    	
    	int s1=0, s2=0;
    	for(int i=1; i<N/2; i++) {
    		for(int j=0; j<i; j++) {
    			s1 += (stat[start[i]][start[j]]+stat[start[j]][start[i]]);
    			s2 += (stat[link[i]][link[j]]+stat[link[j]][link[i]]);
    		}
    	}
    	
    	int d = Math.abs(s1-s2);
    	min = (d<min)? d:min;
    }
}
