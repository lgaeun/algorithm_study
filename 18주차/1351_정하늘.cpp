#include<stdio.h>
#include<map>

using namespace std;

long long n, p, q;
map<long long, long long > m;//idx, value

long long recur(long long num) {
	if (m.count(num) > 0) {
		return m[num];
	}
	else return m[num] = recur(num / p) + recur(num / q);
}


int main() {
	scanf("%lld%lld%lld", &n, &p, &q);
	m[0] = 1;
	printf("%lld\n", recur(n));
}



                                                 
/*
1351. 무한 수열
https://www.acmicpc.net/problem/1351

문제
무한 수열 A는 다음과 같다.

A0 = 1
Ai = A⌊i/P⌋ + A⌊i/Q⌋ (i ≥ 1)
N, P와 Q가 주어질 때, AN을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 3개의 정수 N, P, Q가 주어진다.

출력
첫째 줄에 AN을 출력한다.

제한
0 ≤ N ≤ 1012
2 ≤ P, Q ≤ 109

*/                      
