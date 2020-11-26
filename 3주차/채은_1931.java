import java.util.Scanner;
import java.util.Arrays;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //회의 정보 개수 입력
        int[][] time = new int[N][2];
        for(int i=0; i<N; i++)
        	for(int j=0; j<2; j++)
        		time[i][j] = sc.nextInt(); //회의 정보 입력
   
        Arrays.sort(time, (num1, num2)->{
        	if(num1[1] == num2[1]) {
        		return Integer.compare(num1[0], num2[0]);
        	}
        	else {
        		return Integer.compare(num1[1], num2[1]);
        	}
        }); //종료 시간을 기준으로 timetable 정렬
       
        int least = time[0][1], maximum=1;
        
        for(int i=1; i<N; i++) {
        	if(time[i][0]>=least) {
        		least=time[i][1];
        		maximum++;
        	}
        } //시작시간과 가장 최근 회의 종료 시간 비교
        
        System.out.println(maximum); //최대 배정 가능 수 출력
        sc.close();
    }
}
