import java.util.Scanner;
import java.util.Arrays;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] arr = new String[N];
        for(int i=0; i<N; i++){
            arr[i] = sc.next();
        }
        int[] count = new int[10]; //각 알파벳 자릿수 배열
        char[] al = new char[10]; //알파벳 배열
        int alsize = 0; //알파벳 개수
        
        for(int i=0; i<N; i++){
            char[] temp = arr[i].toCharArray();
            for(int j=0; j<arr[i].length(); j++){
                int k = check(al, temp[j]);
                if(k == 10){
                	al[alsize] = temp[j];
                	count[alsize] += power(10, temp.length-j-1);
                	alsize++;
                }
                else count[k] += power(10, temp.length-j-1);
                
            }
        }
        Arrays.sort(count);
        int sum=0, num=9;
        
        for(int i=9; i>9-alsize; i--) {
        	sum += count[i]*num;
        	num--;
        } //count 배열에서 큰 수부터 9, 8, 7, ... 순으로 배열
        System.out.println(sum);
    }
    
    public static int check(char[] arr, char c){
        for(int i=0; i<arr.length; i++){
            if(arr[i] == c) return i;
        }
        return arr.length;
    } //배열 안에 문자가 있는지 확인한 후 index 리턴
    
    public static int power(int b, int e){
    	int num=1;
        for(int i=0; i<e; i++)
            num *= b;
        return num;
    } //b의 e승 거듭제곱
}
