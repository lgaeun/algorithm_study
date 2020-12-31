import java.util.Scanner;
import java.util.ArrayList;

public class Main{
    static int k;
    static String[] arr;
    static boolean[] chk = new boolean[10];
    static ArrayList<String> list = new ArrayList<String>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        arr = new String[k];
        for(int i=0; i<k; i++)
            arr[i] = sc.next();
        
        search(0, "");
        
        System.out.println(list.get(0));
        System.out.println(list.get(list.size()-1));
    }
    
    public static void search(int idx, String num){
        if(idx == k+1){
            list.add(num);
            return;
        }
        if(idx == 0) { //첫 순서일 경우
        	 for(int i=9; i>=0; i--){
                 if(chk[i]==false){
                     chk[i]=true;
                     search(idx+1, num+Integer.toString(i));
                     chk[i]=false;
                 }
             }
        }
        else{
        	String sign = arr[idx-1];
        	switch(sign){ //각 부등호의 조건에 맞게
            case ">":
                for(int i=9; i>=0; i--){
                    if(chk[i]==false && num.charAt(idx-1)>(char)(i+'0')){
                        chk[i]=true;
                        search(idx+1, num+Integer.toString(i));
                        chk[i]=false;
                    }
                }
                break;
            case "<":
                for(int i=9; i>=0; i--){
                    if(chk[i]==false &&  num.charAt(idx-1)<(char)(i+'0')){
                        chk[i]=true;
                        search(idx+1, num+i);
                        chk[i]=false;
                    }
                }
                break;
        }
        }
        
    }
}
