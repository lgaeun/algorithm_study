import java.util.Scanner;

public class Main{
    public static int N;
    public static String[][] map;
    public static int[] dx = {0, 0, 1, 1};
    public static int[] dy = {0, 1, 0, 1};
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new String[N][N];
        for(int i=0; i<N; i++){
            String row = sc.next();
            map[i] = row.split("");
        }
        compress(N, 0, 0);
        sc.close();
	}

	public static void compress(int size, int x, int y) {

		if (size == 1 || check(size, x, y)) {
			System.out.print(map[x][y]);
		}
		else {
			System.out.print("(");
			for (int i = 0; i < 4; i++) {
				compress(size / 2, x + dx[i] * size / 2, y + dy[i] * size / 2);
			}
			System.out.print(")");
		}
	}

    public static boolean check(int size, int x, int y){
        String num = map[x][y];
        for(int i=x; i<x+size; i++){
            for(int j=y; j<y+size; j++){
                if(!map[i][j].equals(num)) return false;
            }
        }
        return true;
    }
}
