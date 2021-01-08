import java.util.Scanner;
 
public class Main {
    static int[][] best;
    
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0 ;
        best = new int[n + 1][n + 1];
 
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                best[i][j] = sc.nextInt();
                best[i][j] = Math.max(best[i - 1][j - 1], best[i - 1][j]) + best[i][j];
 
                if (sum < best[i][j])
                    sum = best[i][j];
            }
        }
        System.out.println(sum);
        
        sc.close();
 
    }
 
}
