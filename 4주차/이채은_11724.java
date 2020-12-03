import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
	
	static LinkedList<Integer> list = new LinkedList<Integer>();
	
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); 
        String s = bf.readLine();
        StringTokenizer st = new StringTokenizer(s);
        
        int N = Integer.parseInt(st.nextToken()); //vertex
        int M = Integer.parseInt(st.nextToken()); //edge
        int num = 0;
        int[][] Graph = new int[N][N];
        
        for(int i=0; i<N; i++)
            for(int j=0; j<N; j++)
                Graph[i][j] = 0;
        
        for(int i=0; i<M; i++){
            s = bf.readLine();
            st = new StringTokenizer(s);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            Graph[a-1][b-1] = 1;
            Graph[b-1][a-1] = 1;
        }
        
       for(int i=0; i<N; i++){
           if(!list.contains(i+1)){
               DFS(Graph, N, i+1);
               num++;
           }
       } //DFS 수행하지 않은 수에 대하여 DFS 수행
       
       System.out.println(num);
    }
    
    public static void DFS(int[][] g, int N, int V) {
    	list.add(V);
		
    	for(int i=0; i<N; i++) {
    		if(g[V-1][i] == 1 && !list.contains(i+1)) {
    			DFS(g, N, i+1);
    		}
    	}
    } //DFS 수행 완료한 node를 list에 저장
    
}
