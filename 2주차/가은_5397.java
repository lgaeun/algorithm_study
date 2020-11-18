import java.util.*;

class Password{
	
	public LinkedList<Character> list = new LinkedList<Character>();
	private int cursor=0;
	
	public void show() {
		for(Character c : list)
			System.out.print(c);
		System.out.println();
	}
	
	public void key(char input) {
		switch(input) {
			case '<':
				if(cursor > 0)cursor--;		//커서가 맨 앞이 아닐때만 
				break;
				
			case '>':
				if(cursor < list.size()) cursor++; //커서가 맨 끝이 아닐때만 
				break;
				
			case '-':
				if(cursor > 0) cursor--;	//커서가 맨 앞이 아닐때만  
				list.remove(cursor);
				break;
				
			default:
				list.add(cursor, input);
				cursor++;			
		}				
	}	
}

public class _5397 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		Password[] pwd = new Password[num]; //객체 배열에 저장
		
		for(int i = 0; i < num; i++) {	
			pwd[i] = new Password();
			String L = sc.next();
			for(int j = 0; j < L.length(); j++) {
				char input = L.charAt(j);
				pwd[i].key(input);
			}
		}
		
		for(int i = 0; i < num; i++)	//출력  
			pwd[i].show();
	}
}