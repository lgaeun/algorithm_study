import java.util.Scanner;

public class _2447 {
	
	static int N;
	static char [][]star;

	//시작점의 좌표 x,y 
	static void divide(int x, int y, int length) {
		//종료조건 
		if(length == 1) {
			star[x][y] = '*';
			return;
		}
		else {
			int size = length / 3;
			
			//9등분 
			for(int i = 0; i < 3; i ++) {
				for(int j = 0; j < 3; j ++) {
					//정가운데 block일 경우 
					if( i == 1 && j == 1 )
						blank(x + (i * size), y + (j * size), size); // 공백채우기 
					else
						//아니면 분할 
						divide(x + (i * size), y + (j * size), size);
				}
			}
		}
		 	
	}
	// 공백으로 채우기 
	static void blank(int x, int y, int length) {
		for(int i = x ; i < x + length; i++)
			for(int j = y; j < y + length; j++)
				star[i][j] =  ' ';
	}
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		star = new char [N][N];
		
		divide(0, 0, N);
		
		for(int i = 0 ; i < N; i++) {
			for( int j = 0; j < N; j++) {
				System.out.print(star[i][j]);
			}
			System.out.println();
		}
		
	}

}
