import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int st = sc.nextInt();
        if(st == 1) System.out.println(sc.nextInt()); //계단이 하나라면 그대로 출력
        else { //계단이 여러 개
	        int[] arr = new int[st+1]; //계단 배열
	        arr[1] = sc.nextInt();
	        int pre = sc.nextInt();
	        arr[2] = arr[1]+pre;
	        
	        for(int i=3; i<=st; i++){
	            arr[i] = Math.max(arr[i-3]+pre, arr[i-2]); //Fn = max(Fn-1+An, Fn-2)
	            pre = sc.nextInt();
	            arr[i] += pre;
	        }
	        
	        System.out.println(arr[st]); //최종 결과 출력
        }
        sc.close();
    }
}
