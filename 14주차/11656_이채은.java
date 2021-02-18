import java.util.Scanner;
import java.util.Arrays;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        int size = word.length();
        String[] suffix = new String[size];
        for(int i=0; i<size; i++)
            suffix[i] = word.substring(i, size);
        
        Arrays.sort(suffix);
        for(String s:suffix)
            System.out.println(s);
        sc.close();
    }
}
