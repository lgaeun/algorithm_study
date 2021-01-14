import java.io.*;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        int[] budget = new int[N];
        int sum = 0;
        for(int i=0; i<N; i++){
            budget[i] = Integer.parseInt(arr[i]);
            sum += budget[i];
        }
        Arrays.sort(budget);
        int M = Integer.parseInt(br.readLine());
        
        if(sum > M){
            int d = sum - M;
            int i=0, x=0;
            while(true){
            	i++;
                x+=budget[N-i];
                if(i == N || (x-d)/i >= budget[N-i-1]) break; 
            }
            System.out.println((x-d)/i);
        } //예산이 많을 경우
        else
            System.out.println(budget[N-1]); //아닐 때에는 가장 큰 값
    }
}
