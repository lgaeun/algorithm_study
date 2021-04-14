import java.util.*;

public class Main {
    static char[][] map = new char[5][9];
    static boolean[] visited = new boolean[13];
    static class Node{
        int x, y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static ArrayList<Node> list = new ArrayList<>();
    static int[][][] p = {
            {{0,4},{1,3},{2,2},{3,1}},
            {{3,1},{3,3},{3,5},{3,7}},
            {{0,4},{1,5},{2,6},{3,7}},
            {{1,1},{1,3},{1,5},{1,7}},
            {{1,1},{2,2},{3,3},{4,4}},
            {{4,4},{3,5},{2,6},{1,7}}
    };
    static int size;
    static boolean flag;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            String tmp = sc.next();
            for (int j = 0; j < 9; j++) {
                map[i][j] = tmp.charAt(j);
                if(map[i][j] =='x') list.add(new Node(i, j));
                else if(tmp.charAt(j) != '.'){
                    visited[tmp.charAt(j)-'A'+1] = true;
                }
            }
        }
        size = list.size();
        
        solve(0,0);
        sc.close();
    }
    
    static void solve(int cnt, int idx) {
        if(flag == true) return;
        
        if(cnt == size && check()) {
            flag = true;
            for (int i = 0; i < 5; i++) {
                System.out.println(map[i]);
            }
            return;
        }
        
        for (int j = 1; j <= 12; j++) {
            if(visited[j]) continue;
            Node cur = list.get(idx);
            visited[j] = true;
            map[cur.x][cur.y] = (char)(j+64);
            solve(cnt+1, idx+1);
            visited[j] = false;
            map[cur.x][cur.y] = 'x';
        }
    }
            
    static boolean check() { 
        for (int i=0; i<6; i++) {
            int sum = 0;
            for (int j=0; j<4; j++) {
                sum += (map[p[i][j][0]][p[i][j][1]] -'A'+1);
            }
            if(sum != 26) return false;
        }
        return true;
    }
}
