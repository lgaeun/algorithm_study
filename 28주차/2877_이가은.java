import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String bin = Integer.toBinaryString(sc.nextInt()+1);
		StringBuilder sb = new StringBuilder("");
		
		for(int i = 1; i < bin.length(); i++) sb.append(bin.charAt(i) == '0' ? 4+"" : 7+"");
		System.out.println(sb.toString());
	}

}
