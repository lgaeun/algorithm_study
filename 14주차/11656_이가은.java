import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
		String[] arr = new String[input.length()];

		for(int i = 0; i < input.length(); i++) {
			arr[i] = input.substring(i);
		}
		Arrays.sort(arr);
		for(String s : arr) {
			bw.append(s+"\n");
		}
		bw.flush();
		bw.close();   
	}
}