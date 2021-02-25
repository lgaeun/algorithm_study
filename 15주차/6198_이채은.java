import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> list = new Stack<Integer>();
        int N = Integer.parseInt(br.readLine());
        long ans = 0;
        for(int i=0; i<N; i++){
            int cur = Integer.parseInt(br.readLine());
            while(!list.isEmpty() && list.peek()<=cur){
                list.pop();
            }
            ans += (long) list.size();
            list.push(cur);
        }
        
        System.out.println(ans);
    }
}
