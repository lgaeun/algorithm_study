import java.util.Scanner;

public class _2630 {
	
	static int[][] paper;
	static int white=0, blue=0;
	
	// 4등분하기 - size = block 길이, 시작좌표 (x, y) 
	static void divide(int size, int x, int y) {			
			
		if(check(size, x, y)){
			if (paper[x][y] == 1) blue++;
			else white++;
		}
		else {	
			divide(size/2, x, y);				
			divide(size/2, x, y + size/2);
			divide(size/2, x + size/2, y);
			divide(size/2, x + size/2, y + size/2);
		}
	}
	
	// block이 같은 숫자인지 확인
	static boolean check(int size, int x, int y) {
		for(int i = 0; i < size; i++)
			for(int j = 0; j < size; j++)
				if(paper[x+i][y+j] != paper[x][y]) 
					return false;
		
		return true;
	}
	
	// main
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
