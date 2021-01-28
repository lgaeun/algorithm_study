import java.util.Scanner;

public class Main{
    static int N, S, cnt = 0;
    static int[] arr;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();
        arr = new int[N];
        for(int i=0; i<N; i++)
            arr[i] = sc.nextInt();
        
        bf(0, 0);
        System.out.println(cnt);
        sc.close();
    }
    
    static void bf(int idx, int sum){
        if(sum+arr[idx] == S)
            cnt++;
        
        if(idx+1<N) {
        	bf(idx+1, sum);
            bf(idx+1, sum+arr[idx]);
        }
    }
}
