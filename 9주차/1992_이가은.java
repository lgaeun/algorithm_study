import java.io.*;
import java.util.*;

public class Main {
	
	static int [][] map;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws Exception{

		int n = Integer.parseInt(br.readLine());
		map = new int [n][n];
		
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			for(int j = 0; j < n; j++)
				map[i][j] = s.charAt(j); 
		}
		// s.charAt(j)-'0'으로하고 bw로하면 출력에 괄호빼고 아무것도 안나옴. 
		// BufferedWriter bw는 String문자로 출력하므로 int를 String으로 변환하여 아스키 코드로 출력함. 
		// 따라서 int를 출력으로 넣어도 아스키 코드에 해당하는 문자가 출력. 아스키코드 0~32까지는 공백과 제어문이므로 출력으로 나타나지 않음.
		// 굳이 하고 싶다면 String으로 출력하거나, +'0'해주거나..등등 (bw.write(String.valueOf(flag));) 

		divide(0,0,n);
		bw.flush();
		bw.close();
	}
	
	static void divide(int x, int y, int size) throws IOException{
		int flag = map[x][y];
		
		//flag 표시: 전체 숫자가 동일하면 그 숫자로 표시, 아니면 -1
		A: 	
		for(int i = x ; i < x+size; i++) { 			
			for(int j = y; j < y+size; j++) 
				if(flag != map[i][j]) {
					flag = -1;
					break A;
				}
		}	
		//전체숫자가 동일하면 그 숫자 적고, 아니면 괄호 씌우고 4분할	
		if(flag != -1) 
			bw.write(flag);	
		else {							 
			size = size/2;
			bw.write("(");
			for(int i = 0; i < 2; i++)
				for(int j = 0; j < 2; j++)
					divide(x + size*i, y + size*j, size);
			bw.write(")");	
		}				
	}

}
