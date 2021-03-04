import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        class point{
            int x, y, cnt;
            point(int x, int y, int cnt){
                this.x = x;
                this.y = y;
                this.cnt = cnt;
            }
        }
        
        int[] px = {2, 2, -2, -2, 1, 1, -1, -1};
        int[] py = {1, -1, 1, -1, 2, -2, 2, -2};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder("");
        
        for(int i=0; i<T; i++){
            int l = Integer.parseInt(br.readLine());
            boolean[][] visit = new boolean[l][l];
            StringTokenizer stk = new StringTokenizer(br.readLine());
            point cur = new point(Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()), 0);
            
            stk = new StringTokenizer(br.readLine());
            point res = new point(Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()), 0);
            if(cur.x == res.x && cur.y == res.y) {
            	sb.append("0\n");
            	continue;
            }
            
            Queue<point> q = new LinkedList<>();
            q.add(cur);
            visit[cur.x][cur.y] = true;
            int ans = 0;
            
            while(!q.isEmpty()){
                point tmp = q.poll();
                if(tmp.x==res.x && tmp.y==res.y) {
                	ans = tmp.cnt;
                	break;
                }
                
                for(int j=0; j<8; j++){
                    int nx = tmp.x + px[j];
                    int ny = tmp.y + py[j];
                    
                    if(nx>=0 && nx<l && ny>=0 && ny<l && visit[nx][ny] == false){
                        q.add(new point(nx, ny, tmp.cnt+1));
                        visit[nx][ny] = true;
                    }
                }

            }
            sb.append(ans+"\n");
        }
        System.out.println(sb);
    }
}
