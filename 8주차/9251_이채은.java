import java.util.Scanner;

public class Main{
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	String st1 = sc.next();
    	String st2 = sc.next();
    	String[] A = st1.split("");
    	String[] B = st2.split("");
    	
    	int len1 = A.length;
    	int len2 = B.length;
    	int[][] sol = new int[len1+1][len2+1]; //LCS 체크하는 2차원 배열

    	for(int i=1; i<=len1; i++) {
    		for(int j=1; j<=len2; j++) {
    			if(A[i-1].equals(B[j-1])) {
    				sol[i][j]=sol[i-1][j-1]+1; //같다면 더함
    			}
    			else {
    				sol[i][j] = Math.max(sol[i-1][j], sol[i][j-1]); //왼,위 중 큰 수
    			}
    		}
    	}
    	
    	System.out.println(sol[len1][len2]); //LCS 출력
    	sc.close();
    }
 
}
