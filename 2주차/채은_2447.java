import java.util.Scanner;

public class Main {
    private static char[][] star;

    public static void main(String args[]) {
    	Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        star = new char[N][N];

        for(int i=0; i<N; i++) {
        	for(int j=0; j<N; j++) {
            	star[i][j] = ' ';
        	}
        }
        
        fill(0, 0, N);
        for(int i=0; i<N; i++) {
        	System.out.println(star[i]);
        }
    }

    public static void fill (int x, int y, int n) {
        if (n == 1){
            star[x][y] = '*';
            return;
        }
        int m = n/3;
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                if (i==1 && j==1){
                	continue;
                }
                fill(x+m*i, y+m*j, m);
            }
        }
    }
}
