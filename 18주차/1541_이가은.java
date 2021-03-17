import java.util.*;

public class Main {
	
	static Stack<Integer> stk = new Stack<>(); // 숫자 쌓기 위한 스택 
	
	static int calc() {
		int res = 0, k = 0;
		while(!stk.isEmpty()) {
			res += stk.pop() * Math.pow(10, k);
			k++;
		  };
		return res;
    } 
		
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        ArrayList<Integer> list = new ArrayList<>();
    	
    	int sum = 0; //더하기 통해 커지는 값, '-'뒤에 큰 값이 올수록 최소값이 되므로, '-'뒤에 '+'가 오면 계속 더함
    	char last = ' ';
        for(int i = 0; i < s.length(); i++) {
        	char ch = s.charAt(i);  
        	if(ch == '-') {
        		sum += calc();
        		list.add(sum);
        		sum = 0; 	//sum 초기화 
        		last = ch;	//마지막 연산 표시 
        	}
        	else if(ch == '+') {
        		sum += calc();
        		last = ch;	//마지막 연산 표시 
        	}
        	else stk.push(ch - '0');
        }
        if(last == '+') list.add(sum += calc());  //마지막 연산이 '+' 였으면 
        else list.add(calc());
        
        int ans = list.get(0);
        for(int i = 1; i < list.size(); i++) ans -= list.get(i); 
        
        System.out.println(ans);
    }
}
