import java.util.Scanner;

public class Main{
    private static int[][] graph;
    private static int[] bacon;
    private static int N, M;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        graph = new int[N+1][N+1];
        bacon = new int[N+1];
        for(int i=0; i<M; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph[x][y] = 1;
            graph[y][x] = 1;
        }
        
        search();
        
        for(int i=1; i<N+1; i++)
            for(int j=1; j<N+1; j++)
                bacon[i]+=graph[i][j];
        
        int min = 1;
        for(int i=2; i<N+1; i++)
            min = (bacon[min]>bacon[i])? i:min;
        
        System.out.println(min);
        sc.close();
    }
    

    public static void search(){
        
        for (int i=1; i<N+1; i++) { 
            for (int j=1; j<N+1; j++) {
                for (int k=1; k<N+1; k++) { 
                    if(j == k) continue;
                    if (graph[i][k] != 0 && graph[k][j] != 0) {
                    	int t = graph[i][k] + graph[k][j];
                    	
                        if(graph[i][j] != 0 && t>graph[i][j]);
                        else graph[i][j] = t;
                    }
                }
            }
        }
    }
}
