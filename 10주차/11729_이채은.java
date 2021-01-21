import java.util.Scanner;
import java.io.*;

public class Main{
    static int N;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        int cnt = 1;
        for(int i=0; i<N-1; i++)
        	cnt = cnt*2 + 1;
        bw.write(Integer.toString(cnt)+"\n");
        hanoi(N, "1", "2", "3");
        bw.flush();
        bw.close();
        sc.close();
    }
    
    static void hanoi(int num, String from, String tmp, String to) throws IOException{
        if(num==1){
            bw.write(from+" "+to+"\n");
            return;
        }
        hanoi(num-1, from, to, tmp);
        bw.write(from+" "+to+"\n");
        hanoi(num-1, tmp, from, to);
    }
}
