import java.util.*;

public class Main{
    static int min = 10;
    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {1, -1, 0, 0};
    static char[][] map;
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in); //BufferedReader로 개행 무시하는 방법이ㅠㅠ..?
        int N = sc.nextInt();
        for(int i=0; i<N; i++){
            map = new char[5][9];
            int pin = 0; //핀 총 개수
            for(int j=0; j<5; j++){
                char[] tmp = sc.next().toCharArray();
                for(int k=0; k<9; k++){
                    map[j][k] = tmp[k];
                    if(map[j][k]=='o') pin++;
                }
            }
            for(int j=0; j<5; j++)
                for(int k=0; k<9; k++)
                    if(map[j][k]=='o') move(); //dfs
            System.out.println(min+" "+(pin-min));
            min = 10; //최소 초기화
        }
        sc.close();
    }
    
    public static void move(){
    	boolean flag = false;
        for(int i=0; i<5; i++){
            for(int j=0; j<9; j++){
                if(map[i][j]=='o'){
                    for(int k=0; k<4; k++){
                        int nx = i+dx[k];
                        int ny = j+dy[k];
                        if(nx>=0 && nx<5 && ny>=0 && ny<9 && map[nx][ny]=='o'){
                            int tx = nx + dx[k];
                            int ty = ny + dy[k];
                            if(tx>=0 && tx<5 && ty>=0 && ty<9 && map[tx][ty]=='.'){
                            	flag = true;
                                map[i][j] = '.'; map[tx][ty] = 'o'; map[nx][ny] = '.';
                                move();
                                map[i][j] = 'o'; map[tx][ty] = '.'; map[nx][ny] = 'o';
                            }
                        }
                    }
                }
            }
        }
        if(!flag) {
        	int cnt = 0;
        	for(int i=0; i<5; i++)
        		for(int j=0; j<9; j++)
        			if(map[i][j]=='o') cnt++; //핀 개수
        	if(cnt<min) min = cnt;
        }
    }
}
