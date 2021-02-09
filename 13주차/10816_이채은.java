import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer card = new StringTokenizer(br.readLine());
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(int i=0; i<N; i++){
            String tmp = card.nextToken();
            int num = 1;
            if(map.containsKey(tmp))
            	num += map.get(tmp);
            map.put(tmp, num);
        } //해쉬맵에 키가 있을 경우 value를 1 증가, 없을 경우 추가
        int M = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());
        StringBuilder res = new StringBuilder("");
        for(int i=0; i<M; i++){
            String temp = stk.nextToken();
            if(map.containsKey(temp))
                res.append(map.get(temp)+" ");
            else res.append("0 ");
        } //해쉬맵에서 순서대로 값을 가져옴
        
        System.out.println(res);
    }
}
