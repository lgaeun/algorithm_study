import java.util.Scanner;
import java.util.Arrays;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int L = sc.nextInt();
        int[] location = new int[N];
        for(int i=0; i<N; i++)
            location[i] = sc.nextInt();
        Arrays.sort(location);
        
        int num=0;
        double check=location[0]; //마지막으로 붙여진 테이프 끝부분 위치
        for(int i : location){
            if(i < check) continue;
            num++;
            check = i+L-0.5;
        }
        
        System.out.println(num);
        sc.close();
    }
}
