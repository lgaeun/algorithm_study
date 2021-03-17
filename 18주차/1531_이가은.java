import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 1000000;
        StringTokenizer subtraction = new StringTokenizer(br.readLine(), "-");  //1. "-"를 기준으로 수들을 나누고 
        
        while(subtraction.hasMoreTokens()) {
        	int temp = 0;
        	
        	StringTokenizer addition = new StringTokenizer (subtraction.nextToken(), "+"); //2. "+"를 기준으로 나눈 수들을 더한다음에
        	while(addition.hasMoreTokens()) {
        		temp += Integer.parseInt(addition.nextToken());
        	}
        	if(sum == 1000000) sum = temp; // 첫 번째 수인 경우
        	else sum -= temp;   //3. 그 수들을 뺀다 
        }
        System.out.println(sum);
    }
}
