import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 int startTime = timeToSec(st.nextToken()), endTime = timeToSec(st.nextToken()), streamEndTime = timeToSec(st.nextToken());
		
		 HashSet<String> before = new HashSet<>();
		 HashSet<String> after = new HashSet<>();
		 String input = "";
		 int num = 0;
		 
		 while((input = br.readLine()) != null && input.length() != 0) {
			 st = new StringTokenizer(input);

			 int chatTime = timeToSec(st.nextToken());
			 String id = st.nextToken();
	
			 if(chatTime <= startTime) before.add(id);
			 else if(endTime <= chatTime && chatTime <= streamEndTime) {
				 if(before.contains(id) && !after.contains(id)) {
					 after.add(id);
					 num++;
				 }
			 }
		 }
		 
		System.out.println(num);
	}
	
	static int timeToSec(String str) {
		int[] parse = Arrays.stream(str.split(":")).mapToInt(Integer::parseInt).toArray();
		return parse[0] * 60 * 60 + parse[1] * 60; 
	}

}
