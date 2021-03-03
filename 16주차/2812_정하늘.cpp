#include<stdio.h>
#include<string.h>
#include<deque>

using namespace std;

int main() {
	int n, k;
	char num[500001] = "";
	scanf("%d%d", &n, &k);
	scanf(" %s", num);

	deque<char> dq;
	int len = strlen(num);
	for (int i = 0; i < len; i++) { 
		while (k && !dq.empty() && dq.back() < num[i]) { 
			dq.pop_back(); 
			k--;
		}//이전까지 들어갔던 원소중에 자신 이상인 것이 나올 때까지 원소를 삭제
		//삭제해야하는 수를 만족시켰다면 남은 수는 모두 삽입
		dq.push_back(num[i]);
	} 
	for (int i = 0; i < dq.size() - k; i++) { 
		printf("%c",dq[i]); 
	} 
	printf("\n");
}


                                                 
/*
2812. 크게 만들기
https://www.acmicpc.net/problem/2812

문제
N자리 숫자가 주어졌을 때, 여기서 숫자 K개를 지워서 얻을 수 있는 가장 큰 수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N과 K가 주어진다. (1 ≤ K < N ≤ 500,000)

둘째 줄에 N자리 숫자가 주어진다. 이 수는 0으로 시작하지 않는다.

출력
입력으로 주어진 숫자에서 K개를 지웠을 때 얻을 수 있는 가장 큰 수를 출력한다.

*/                      
