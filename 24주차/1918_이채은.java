import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder("");
        Stack<Character> stk = new Stack<Character>();
        char[] infix = sc.next().toCharArray();
        for(char c:infix){
            if(c-'A'>=0 && c-'Z'<=0){
                sb.append(c);
            } else if(c=='('){
                stk.push(c);
            } else if(c==')'){
                while(!stk.isEmpty()){
                	char tmp = stk.pop();
                	if(tmp=='(') break;
                    sb.append(tmp);
                }
            } else{
                while(!stk.isEmpty() && check(stk.peek())>=check(c)){
                  //여기서 while문을 !stk.isEmpty()로만 돌리고 check를 따로 뺐더니 틀리게 나옴
                    sb.append(stk.pop());
                }
                stk.push(c);
            }
        }
        
        while(!stk.isEmpty())
        	sb.append(stk.pop());
        
        System.out.println(sb);
        sc.close();
    }
    
    public static int check(char c) {
    	if(c=='('||c==')') return 0;
    	if(c=='+'||c=='-') return 1;
    	return 2;
    }
}
