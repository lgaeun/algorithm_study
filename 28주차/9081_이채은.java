import java.io.*;

public class Main{
	public static StringBuilder sb = new StringBuilder("");
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            next_permutation(br.readLine());
        }
        System.out.println(sb);
    }
    
    public static void next_permutation(String tmp){
    	char[] s = tmp.toCharArray();
        int size = s.length, k = -1;
        
        for(int i=0; i<size-1; i++) {
        	if(s[i]<s[i+1]) k = i;
        }
        if(k==-1) {
        	sb.append(tmp); return;
        }
        
        for(int i=size-1; i>=k; i--) {
        	if(s[i]>s[k]) {
        		swap(s, i, k);
            	for(int j=k+1; j<(size+k+1)/2; j++)
            		swap(s, j, size-(j-k));
            	break;
        	}
        }
        
        for(int i=0; i<size; i++)
        	sb.append(s[i]);
        sb.append("\n");
    }
    
    public static void swap(char[] tmp, int i, int j) {
    	char x = tmp[i];
    	tmp[i] = tmp[j];
    	tmp[j] = x;
    }
}
