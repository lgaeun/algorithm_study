import java.util.Scanner;

public class Main {
    static int[][] map;
    static int white = 0;
    static int blue = 0;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        map = new int[N][N];
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        divide(N, 0, 0);
        System.out.println(white);
        System.out.println(blue);
    }

    private static void divide(int n, int x, int y) {
        if(n == 1) {
            if (map[x][y] == 0) white++;
            else blue++;
            return;
        }
        if (check(n, x, y) == true) {
            if (map[x][y] == 0) white+=1;
            else blue+=1;
            return;
        }
        divide(n/2, x, y);
        divide(n/2, x+n/2, y);
        divide(n/2, x, y+n/2);
        divide(n/2, x+n/2, y+n/2);
    }

    public static boolean check(int size, int x, int y) {
        int value = map[x][y];
        for(int i=x; i<x+size; i++) {
            for (int j=y; j<y+size; j++) {
                if(value != map[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

}
