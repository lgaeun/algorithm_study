import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < t; i ++) {	//test case
			int n = Integer.parseInt(br.readLine());
			String[] str = new String[n];
			boolean flag = true;
			
			for(int j = 0; j < n; j ++) 
				str[j] = br.readLine();
			
			Arrays.sort(str); //정렬 
			
			for(int j = 0; j < n-1 && flag; j++)
				flag = !str[j+1].startsWith(str[j]);
			
			bw.write(flag? "YES\n" : "NO\n");
		}
		bw.flush();
		bw.close();
	}

}




