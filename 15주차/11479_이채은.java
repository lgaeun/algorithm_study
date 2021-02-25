import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++)
                arr[j] = Integer.parseInt(stk.nextToken());
            
            Arrays.sort(arr);
            int max = arr[1] - arr[0];
            for(int j=0; j<N-2; j+=2)
                max = Math.max(max, arr[j+2]-arr[j]);
            for(int j=1; j<N-2; j+=2)
                max = Math.max(max, arr[j+2]-arr[j]);
            System.out.println(max);
        }
    }
}
