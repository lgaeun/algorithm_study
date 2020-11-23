import java.io.*;
import java.util.*;

public class _1946 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int Ntest = Integer.parseInt(br.readLine());
		int Nppl;
		int[][] rank = new int [100000][2];
		StringTokenizer st;
		
		for(int i = 0; i < Ntest; i++) {
			int count;
			Nppl = Integer.parseInt(br.readLine());
			
			// 등수 저장 
			for(int j = 0; j < Nppl; j++) {
				st = new StringTokenizer(br.readLine()," ");
				rank[j][0] = Integer.parseInt(st.nextToken());
				rank[j][1] = Integer.parseInt(st.nextToken());
			}

			//서류순으로 정렬
			Arrays.sort(rank,0,Nppl, new Comparator<int[]>() {
				
				@Override
				public int compare(int[] o1, int[] o2) { 
					return o1[0]-o2[0];
				}
			}
			);
			
			// 면접등수 비교
			int worst = rank[0][1]; // 서류1등의 면접등수  
			count = 1; //서류 1등은 자동 포함
			for(int j = 0; j < Nppl; j++) {
				
				if( worst > rank[j][1]) {
					worst = rank[j][1];
					count++;
				}
			}
			
			System.out.println(count);

		}
		
	}

}
