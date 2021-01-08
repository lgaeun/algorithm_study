import java.io.*;

public class Main{
	public static int n, r, front, back;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			String p = br.readLine();
			back = n = Integer.parseInt(br.readLine());
			r=0; front=0; String[] arr;
			if (n != 0) {
				String x = br.readLine().substring(1, n * 2);
				arr = x.split(",");
			}
			else {
				br.readLine();
				arr = null;
			}
			int len = p.length();
			for (int j = 0; j < len; j++) {
				char temp = p.charAt(j);
				if (temp == 'R')
					r++;
				else {
					if (r % 2 == 1)
						back--;
					else
						front++;
				}
			}
			show(arr); // 결과 프린트
		}
    }
    
    public static void show(String[] arr) {
    	int len = 0;
    	if (n!=0) len = arr.length;
    	
    	if(len-back+front > len) {
            System.out.println("error");
    		return;
    	}
        else{
        	System.out.print("[");
            if(r%2 == 1) {
                for(int i=back-1; i>=front; i--) {
                    System.out.print(arr[i]);
                    if(i!=front) System.out.print(","); 
                }
            }
            else {
                for(int i=front; i<back; i++) {
                    System.out.print(arr[i]);
                	if(i!=back-1) System.out.print(",");
                }
            }
            System.out.println("]");
            return;
        }
    }
}
