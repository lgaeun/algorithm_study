import java.util.Scanner;

public class _2630 {
	
	static int[][] paper;
	static int white=0, blue=0;
	
	static void divide(int n, int x, int y) {			
			
		if(check(n, x, y)){
			if (paper[x][y] == 1) blue++;
			else white++;
		}
		//4등분 
		else {	
			divide(n/2, x, y);				
			divide(n/2, x, y + n/2);
			divide(n/2, x + n/2, y);
			divide(n/2, x + n/2, y + n/2);
		}
		
	}
	
	// block의 시작 좌표 x,y 
	static boolean check(int size, int x, int y) {
		for(int i = 0; i < size; i++)
			for(int j = 0; j < size; j++)
				if(paper[x+i][y+j] != paper[x][y]) 
					return false;
		
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		paper = new int[N][N];
		
		for(int i = 0; i < N; i++)
			for(int j = 0 ; j < N; j++)
				paper[i][j] = sc.nextInt();
		
		divide(N, 0, 0);
		
		System.out.println(white);
		System.out.print(blue);

	}

}
