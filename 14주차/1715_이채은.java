import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> card = new PriorityQueue<Integer>();
        for(int i=0; i<N; i++)
            card.add(Integer.parseInt(br.readLine()));
        
        int sum = 0;
        for(int i=0; i<N-1; i++) {
            int x = card.poll();
            int y = card.poll();
            sum += x+y;
            card.add(x+y);
        }
        
        System.out.println(sum);
    }
}
