import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            check(br.readLine().split(""));
        }
    }
    
    public static void check(String[] s){
        int size = s.length;
        int p1 = 0, p2 = size-1, cnt = 0;
        while(p1<=p2){
            if(s[p1].equals(s[p2])){
                p1++; p2--;
            }
            else if(!s[p1+1].equals(s[p2]) && !s[p1].equals(s[p2-1])){
                cnt = 2; break;
            }
            else {
                int t1, t2;
                boolean palindrome = false; //유사회문 체크
                if(s[p1+1].equals(s[p2])) {
                	t1 = p1+2; t2 = p2-1;
                	palindrome = true;
	                while(t1<=t2){
	                    if(s[t1].equals(s[t2])){
	                        t1++; t2--;
	                        palindrome = true;
	                    }
	                    else{
	                    	palindrome = false;
	                    	break;
	                    }
	                }
                }
                if(!palindrome && s[p1].equals(s[p2-1])){
                    t1 = p1+1; t2 = p2-2;
                    palindrome = true;
                    while(t1<=t2){
                    	if(s[t1].equals(s[t2])){
                    		t1++; t2--;
                    		palindrome = true;
                    	}
                    	else{
                    		palindrome = false;
                    		break;
                    	}
                    }
                }
                
                cnt = palindrome? 1:2;
                break;
            }
        }
        System.out.println(cnt);
    }
}
