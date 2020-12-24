import java.util.Scanner;

public class Main{
    public static int A, B;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        A = sc.nextInt();
        B = sc.nextInt();
        
        int res = calc(B, 1);
        System.out.println(res);
        sc.close();
    }
    
    public static int calc(int num, int i){
        if(num == A) return i;
        else if(num < A) return -1;
        if(num%2 == 0){
            return calc(num/2, i+1);
        }
        else if(num%10 == 1){
            return calc((num-1)/10, i+1);
        }
        else return -1;
    }
    
    /* 초기에 이진 트리 형식으로 A->B 하려다가 오류 떠서 실패
    public static int calc(int num, int i){
        if(num == B){
            int res = 1;
            while(i != 1){
                i/=2;
                res++;
            }
            return res;
        }
        else if(num < B){
            int x = calc(num*2, i*2);
            int y = calc(num*10+1, i*2+1);
            
            if(x!=-1 && y!=-1)
            	if(x>y) return y;
            	else return x;
            else if (x!=-1) return x;
            else return y;
        }
        return -1;
    }
    */
}
