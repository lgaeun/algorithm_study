import java.util.*;

public class Main{
    public static void main(String[] args){
    	class node{
    		int num, cnt;
    		node(int num, int cnt){
    			this.num = num;
    			this.cnt = cnt;
    		}
    	}
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int ans = 0;
        Queue<node> list = new LinkedList<>();
        list.add(new node(N, 0));
        while(!list.isEmpty()){
            node x = list.poll();
            if(x.num==1) {
                ans = x.cnt;
                break;
            }
            if(x.num %3 ==0) list.add(new node(x.num/3, x.cnt+1));
            if(x.num %2 ==0) list.add(new node(x.num/2, x.cnt+1));
            list.add(new node(x.num-1, x.cnt+1));
        }
        System.out.println(ans);
        sc.close();
    }
}
