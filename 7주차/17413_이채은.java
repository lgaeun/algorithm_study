import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String x = br.readLine();
        StringTokenizer stk = new StringTokenizer(x, "<> ", true);
        while(stk.hasMoreTokens()){
            String temp = stk.nextToken();
            if(temp.equals("<")){
            	System.out.print(temp);
                while(true){
                    String s = stk.nextToken();
                    System.out.print(s);
                    if(s.equals(">"))
                    	break;
                }
            }
            else {
                String[] arr = temp.split("");
                for(int i=arr.length-1; i>=0; i--)
                    System.out.print(arr[i]);
            }
        }
    }
}
