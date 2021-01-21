import java.util.*;
import java.io.*;

public class Main {
	
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		bw.write((int) Math.pow(2, n) - 1+ "\n");
		
		Hanoi(n, 1, 2, 3); //n개 원판을 1->2->3으로 이동
		bw.flush();
		bw.close();
	}
	
	static void Hanoi(int n, int start, int mid, int to) throws IOException {
		
		if(n == 1) {
			bw.write(start+" "+ to +"\n");
			return;
		}
		
		Hanoi(n-1, start, to, mid); //n-1개 원판을 start에서 mid로 이동  
		bw.write(start+" "+to+"\n"); // 원판 한 개 옮기는 과정 출력 
		Hanoi(n-1, mid, start, to); // n-1개 원판을 mid에서 to로 이동 
		
	}	
}

