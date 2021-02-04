import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int x1, y1, x2, y2, x3, y3, x4, y4;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			x3 = Integer.parseInt(st.nextToken());
			y3 = Integer.parseInt(st.nextToken());
			x4 = Integer.parseInt(st.nextToken());
			y4 = Integer.parseInt(st.nextToken());
			System.out.println(result());
		}
		br.close();
    }
    
    public static String result(){
        float a1=0, a2=0, b1=0, b2=0;
        float px=0, py=0;

        if(x1==x2){
            px = x1;
        }
        else{
            a1 = (float) (y2-y1)/(x2-x1);
            b1 = (float) y1 - a1*x1;
        }
        
        if(x3==x4){
            px = x3;
        }
        else{
            a2 = (float) (y4-y3)/(x4-x3);
            b2 = (float) y3 - a2*x3;
        }
        
        if(x1==x2 && x3==x4){
            if(x1==x3) return "LINE";
            else return "NONE";
        }
        else if(x1==x2){
            py = a2*px+b2;
            return "POINT "+String.format("%.2f",px)+" "+String.format("%.2f",py);
        }
        else if(x3==x4){
            py = a1*px+b1;
            return "POINT "+String.format("%.2f",px)+" "+String.format("%.2f",py);
        }
        else{
            if(a1==a2){
                if(b1==b2) return "LINE";
                else return "NONE";
            }
            else{
                px = -(b1-b2)/(a1-a2);
                py = a1*px+b1;
                return "POINT "+String.format("%.2f",px)+" "+String.format("%.2f",py);
            }
        }
    }
}
