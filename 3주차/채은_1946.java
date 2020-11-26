import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            int N = Integer.parseInt(br.readLine());
            int[][] rank = new int[N][2];
            
            for(int j=0; j<N; j++){
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                rank[j][0] = Integer.parseInt(st.nextToken());
                rank[j][1] = Integer.parseInt(st.nextToken());
            }
            int max=1; //최대로 뽑을 수 있는 신입사원 수
            
            Arrays.sort(rank, Comparator.comparingInt(num->num[0]));
            if(rank[0][1] == 1);
            else{
                int least = rank[0][1];
                for(int j=0; j<N; j++)
                    if(least>rank[j][1]) {
                    	max++;
                    	least = rank[j][1]; //더 높은 등수 있을 경우 최소 갱신
                    }
            }
                    
            System.out.println(max);
        }
        br.close();
    }
}
