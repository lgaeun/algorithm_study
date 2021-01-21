import java.io.*;

public class Main{
    static int[] coin;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int k = Integer.parseInt(tmp[1]);
        coin = new int[n];
        for(int i=0; i<n; i++){
            coin[i] = Integer.parseInt(br.readLine());
        }
        
        int[] dp = new int[k+1];
        dp[0] = 1;
        for(int i=0; i<n; i++){
            if(coin[i]>k) continue;
            for(int j=coin[i]; j<=k; j++)
                dp[j] += dp[j-coin[i]];
        } //각 코인으로 만들 수 있는 경우의 수 차례로 추가
        System.out.println(dp[k]);
    }
}
