import java.util.Scanner;

public class Main{
    static int M;
    static int[] broke;
    static int[] channel;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String N = sc.next();
        M = sc.nextInt();
        broke = new int[M];
        for(int i=0; i<M; i++)
            broke[i] = sc.nextInt();
        String[] temp = N.split("");
        channel = new int[temp.length];
        for(int i=0; i<temp.length; i++)
        	channel[i] = Integer.parseInt(temp[i]);
        
        int num = Integer.parseInt(N);
        int min = Math.min(Math.abs(up()-num), Math.abs(num-down()));
        System.out.println(Math.min(min, Math.abs(num-100)));
    }
    public static boolean chk(int num) {
    	for(int i:broke)
    		if(num == i) return false;
    	
    	return true;
    } //고장난 번호인지 확인
    
    public static int up(){
    	int res=0;
        for(int i=0; i< channel.length; i++) {
        	int num = channel[i];
        	while(!chk(num)) {
    			if(num!=9) num++;
    			else num=0;
    		}
        	res = res*10+num;
        }
        System.out.println("res: "+res);
        return res;
    }//원래 채널보다 큰 수
    
    public static int down() {
    	int res=0;
        for(int i=0; i< channel.length; i++) {
        	int num = channel[i];
        	while(chk(num)) {
    			if(num!=0) num--;
    			else num=9;
    		}
        	res = res*10+num;
        }
        return res;
    } //원래 채널보다 작은 수
}
