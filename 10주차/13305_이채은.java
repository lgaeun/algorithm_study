import java.io.*;
import java.util.StringTokenizer;

public class Main{
    static int[] distance;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        distance = new int[N];
        StringTokenizer s = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<N; i++)
            distance[i] = Integer.parseInt(s.nextToken());
        
        s = new StringTokenizer(br.readLine(), " ");
        long minR = 0, minP = 1000000001; //int로 하면 오류
        for(int i=1; i<N; i++){
            int price = Integer.parseInt(s.nextToken());
            minP = (price>minP)? minP:price; //기존 기름값 중 최소
            minR += minP*(long)distance[i]; //총 최소 비용
        }
        
        System.out.println(minR);
    }
}
