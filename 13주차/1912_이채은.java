import java.io.*;
import java.util.StringTokenizer;

public class Main{
    static int n, max=-1001, sum=0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());
        while(stk.hasMoreTokens()){
            int tmp = Integer.parseInt(stk.nextToken());
            if(sum+tmp > 0){
                sum += tmp;
                max = (sum>max)? sum:max;
            } //이전까지의 합이 0이상일 경우에만 더함
            else {
                sum = 0;
                max = (tmp>max)? tmp:max;
            }
        }
        
        System.out.println(max);
    }
}
