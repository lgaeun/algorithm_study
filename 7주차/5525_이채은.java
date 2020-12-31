import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();

        int res=0, i=0;
        while(i<M) {
        	if(S.charAt(i)=='I') {
        		int len = 0;
        		if(i+3<M) {
        			while(S.substring(i+1,i+3).equals("OI")) {
        				i+=2;
        				len++;
        				if(i+3>=M) break;
        			}
        			if(len>=N) res+=len-N+1;
        		}
        	}
        	i++;
        }
        System.out.println(res);
        br.close();
    }
}
