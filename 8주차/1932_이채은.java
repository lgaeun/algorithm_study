import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Queue<Integer> tri = new LinkedList<Integer>(); //삼각형의 각 행 저장하는 큐
        int n = sc.nextInt();
        tri.add(sc.nextInt());
        for(int i=1; i<n; i++){
            for(int j=0; j<=i; j++){
                int e = sc.nextInt();
                if(j == 0)
                    e += tri.peek(); //행의 첫번째 수는 오른쪽 위 숫자를 더해줌
                else if(j == i) {
                    e += tri.poll(); //행의 마지막 수는 왼쪽 위 숫자를 더해줌
                }
                else{
                    int temp = tri.poll();
                    int m = (temp > tri.peek())? temp : tri.peek(); //왼쪽 위와 오른쪽 위 중 큰 수
                    e += m; //큰 수와 입력된 정수를 더함
                }                  
                tri.add(e); //다시 큐에 저장
            }
        }
        
        int max = 0;
        for(int i=0; i<n; i++){
            int chk = tri.poll();
            max = (max > chk)? max : chk;
        } //마지막행에서 가장 큰 수
        
        System.out.println(max);
        sc.close();
    }
}
