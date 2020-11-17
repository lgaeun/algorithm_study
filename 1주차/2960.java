import java.util.*;
public class Main{
    public static void main(String[] args){
    	Scanner input=new Scanner(System.in);
    	int n=input.nextInt();
    	int k=input.nextInt();
    	int count=0;
    	int del=0;
    	int rem=0;
    	int size=n-1;
    	int flag=0;
    	LinkedList<Integer> eratos=new LinkedList<Integer>();
    	for(int i=2;i<=n;i++)
    		eratos.add(i);
    	while(count!=k) {
        	del=eratos.removeFirst();
        	count++;
        	size--;
        	if(count==k) {
        		flag=0;
        		break;
        	}
    		for(int i=0;i<size;i++) {
    			if(eratos.get(i)%del==0) {
    				rem=eratos.remove(i);
    				count++;
    				size--;
    			}
            	if(count==k) {
            		flag=1;
            		break;
            	}
    		}
    	}
    	if(flag==0) System.out.println(del);
    	else System.out.println(rem);
    }
}


/*
2960. 에라토스테네스의 체
https://www.acmicpc.net/problem/2960

문제
에라토스테네스의 체는 N보다 작거나 같은 모든 소수를 찾는 유명한 알고리즘이다.

이 알고리즘은 다음과 같다.

2부터 N까지 모든 정수를 적는다.
아직 지우지 않은 수 중 가장 작은 수를 찾는다. 이것을 P라고 하고, 이 수는 소수이다.
P를 지우고, 아직 지우지 않은 P의 배수를 크기 순서대로 지운다.
아직 모든 수를 지우지 않았다면, 다시 2번 단계로 간다.
N, K가 주어졌을 때, K번째 지우는 수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N과 K가 주어진다. (1 ≤ K < N, max(2, K) < N ≤ 1000)

출력
첫째 줄에 K번째 지워진 수를 출력한다.

*/