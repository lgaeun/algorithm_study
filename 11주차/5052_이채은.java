import java.util.*;
import java.io.*;
 
public class Main {    
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in)); //문자스트림
        int n = Integer.parseInt(br.readLine());
        
        for(int i=0; i<n; i++) {
            int t = Integer.parseInt(br.readLine()); 
            String[] arr= new String[t];
            boolean flag = false;        
            
            for(int j=0;j<t;j++) {
                arr[j]=br.readLine();
            }
            
            Arrays.sort(arr, new Comparator<String>() {
            	@Override
                public int compare(String s1, String s2) {
                    return s1.compareTo(s2);                    
                }
            });
            
            for(int j=1;j<t;j++) {
                if(arr[j].startsWith(arr[j-1])) {
                    flag = true;
                    break;
                }
            }
            System.out.println((flag == false)? "YES":"NO");
        }
    }
}
