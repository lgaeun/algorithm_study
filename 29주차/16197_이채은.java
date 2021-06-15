import java.util.*;

public class Main{
    static class pair{
        int x, y;
        pair(int x, int y){
            this.x = x; this.y = y;
        }
    }
    static int N, M, min = 11;
    static char[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); M = sc.nextInt();
        ArrayList<pair> coin = new ArrayList<>();
        map = new char[N][M];
        for(int i=0; i<N; i++){
            char[] tmp = sc.next().toCharArray();
            for(int j=0; j<M; j++){
                map[i][j] = tmp[j];
                if(tmp[j]=='o') coin.add(new pair(i, j));
            }
        }
        dfs(coin.get(0), coin.get(1), 0);
        System.out.println(min==11 ? -1:min);
        sc.close();
    }
    
    public static void dfs(pair first, pair second, int cnt){
        if(cnt == 11) return;
        pair newPair1, newPair2;
        for(int i=0; i<4; i++){
        	newPair1 = new pair(first.x+dx[i], first.y+dy[i]);
        	newPair2 = new pair(second.x+dx[i], second.y+dy[i]);
            
            boolean fst = isValid(newPair1);
            boolean snd = isValid(newPair2);
            if(fst && snd){
            	if(map[newPair1.x][newPair1.y]=='#') {
            		newPair1 = first;
            	}
            	if(map[newPair2.x][newPair2.y]=='#') newPair2 = second;
                dfs(newPair1, newPair2, cnt+1);
            } else if(fst || snd){
                if(min > cnt) min = cnt+1;
            }
        }
    }
    
    public static boolean isValid(pair a){
        if(a.x >=0 && a.x < N & a.y >=0 && a.y < M)
            return true;
        return false;
    }
}
