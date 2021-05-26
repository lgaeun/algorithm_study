import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        
        StringBuilder sb = new StringBuilder();
        for(int i=n; i>=0; i--){
            int A = i;
            int B = n - i;
            
            if(A * B < k) continue;
            int cnt = 0;
            int temp = k;
            
            for(int j=B; j>=0; j--){
                for(int a=i; a>=0; a--){
                    if(tmp > a*j){
                        tmp -= a*j;
                        for(int t=0; t < a; t++){
                            sb.append("A");
                            cnt++;
                        }
                        sb.append("B");
                        cnt++;
                        break;
                    } else if(tmp == a*j){
                        tmp -= a*j;
                        for(int t=0; t < a; t++){
                            sb.append("A");
                            cnt++;
                        }
                        for(int t=0; t < j; t++){
                            sb.append("B");
                            cnt++;
                        }
                        break;
                    }
                }

                if(tmp == 0) {
                    while(cnt < n){
                        sb.append("A"); cnt++;
                    }
                    System.out.println(sb);
                    return;
                }
            }
        }
        System.out.println(-1);
    }
}
