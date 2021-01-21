import java.util.Scanner;

public class Main{
    static int N;
    static int[] arr;
    static int[] LIS;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        LIS = new int[N];
        for(int i=0; i<N; i++)
            arr[i] = sc.nextInt();
        
        for(int i=0; i<N; i++) {
        	int num = arr[i];
        	int l = 1;
        	for(int j=0; j<i; j++)
        		if(arr[j]<num && l<=LIS[j])
        			l = LIS[j]+1;
        	LIS[i] = l;
        }
        
        int max = 0;
        for(int e : LIS)
        	max = (max > e)? max : e;
        
        System.out.println(N-max);
        sc.close();
    }
}
