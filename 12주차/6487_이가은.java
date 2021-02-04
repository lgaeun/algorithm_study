import java.io.*;
import java.util.*;

class Line{		
	public float grad, c; //Y= grad*X + c
	public boolean par_to_y = false; //y축과 평행한 경우 true
	
	Line(){}
	Line(float grad, float c) {
		this.grad = grad;
		this.c = c;
	}
}

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			float []l1 = new float[4];
			float []l2 = new float[4];
			
			for(int j = 0; j < 4; j++)
				l1[j] = (float)Integer.parseInt(st.nextToken());
			
			for(int j = 0; j < 4; j++)
				l2[j] = (float)Integer.parseInt(st.nextToken());
			
			Line la = new Line();
			Line lb = new Line();
			
			draw(la,l1[0],l1[1],l1[2],l1[3]); 
			draw(lb,l2[0],l2[1],l2[2],l2[3]); 
			check(la, lb);
		}	
	}
	//직선의 방정식계산해서 grad, c 값 넣는 함수
	static void draw(Line line, float x1, float y1, float x2, float y2) {
		if(x1 == x2) {// y축과 평행한 경우 
			line.par_to_y = true;
			line.c = x1; // x=c;
		}
		else { 
			line.grad = (y2-y1)/(x2-x1);
			line.c = y2 - x2*line.grad; //y=grad*x + c
		}
	}
    // 교차여부 확인하는 함수
	static void check(Line la, Line lb) {
		if(la.par_to_y) { //1.la: x=c 일 때 
			if(lb.par_to_y) sameGrad(la,lb); // la,lb둘 다 y축과 평행 = 기울기 같음 
			else cross(la,lb);
			return;    
		}
		else if(lb.par_to_y) { //2.lb: x=c일 때 
			if(la.par_to_y)	sameGrad(la,lb); // la,lb둘 다 y축과 평행 = 기울기 같음 
			else cross(la,lb);
			return;  
		}
		else if(la.grad == lb.grad)	sameGrad(la,lb); //3.두 선이 기울기가 같을 경우 
		else  cross(la,lb); //4.다 아닌경우, 무조건 교점있음 
	}
	//기울기가 같은 두 선에 대해 일치인지 평행인지 판단해 출력하는 함수 
	static void sameGrad(Line la, Line lb) {
		if(la.c == lb.c) 
			System.out.println("LINE"); // 일치 
		else 
			System.out.println("NONE"); //평행 
	}
	//교점 찾아서 출력하는 함수 
	static void cross(Line la, Line lb) {
		float x, y;
		if(la.par_to_y) { //la가 x축과 평행할 경우 
			x = la.c;
			y = lb.grad*x + lb.c;
		}else if(lb.par_to_y) { //lb가 x축과 평행할 경우 
			x = lb.c; 
			y = la.grad*x + la.c;
		}else {
			x = (lb.c-la.c)/(la.grad-lb.grad); // 아닌 경우 
			y = la.grad*x + la.c;
		}
		System.out.printf("POINT %.2f %.2f \n",x,y);
	}
}
