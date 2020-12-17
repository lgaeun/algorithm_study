package dynamic;

import java.io.*;

public class _4811 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n==0) break;
			
			
			System.out.println(pill(n,0));
		}
	}
	
	static long pill(int w, int h) {
		long ans;
		long[][] pill = new long[31][31];		//[W][H]개수 
		
		if(w<0) return 0;
		
		if(w==0 && h==0) return 1;  //다 반쪽인 알약뿐임 
		
		if(pill[w][h] != 0) return pill[w][h];	//저장되어있으면 사용 
		
		pill[w][h] = pill[w-1][h+1] + pill[w][h-1]; //p(w,h) = p(w-1,h+1) + p(w, h-1)
		
		return pill[w][h];
	}

}
//미완성