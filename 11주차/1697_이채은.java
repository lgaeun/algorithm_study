import java.util.*;

public class Main{
    static Queue<Integer> q = new LinkedList<Integer>();
    static boolean[] visited = new boolean[100001];
    static int N, K;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        
        int time = BFS(N);
        
        System.out.println(time);
        sc.close();
    }
    
    public static int BFS(int pos){
        int time = 0;
        q.add(pos);
        visited[pos] = true;
        
        while(true){
            int size = q.size();
            
            for(int i=0; i<size; i++){
            	int e = q.poll();
            	if(e == K)
            		return time;
	            if(e > 0 && visited[e-1] == false){
	                q.add(e-1);
	                visited[e-1] = true;
	            }
	            if(e < 100000 && visited[e+1] == false){
	                q.add(e+1);
	                visited[e+1] = true;
	            }
	            if(e <= 50000 && visited[e*2] == false){
	                q.add(e*2);
	                visited[e*2] = true;
	            }
            }
            time++;
        }
        
    }
}
