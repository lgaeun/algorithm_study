#include<stdio.h>
#include<vector>
#include<algorithm>

using namespace std;

int n, k;

int main() {
	scanf("%d%d", &n, &k);
	if (k > (n / 2)*(n / 2 + n % 2)) {
		printf("-1\n");
	}//최댓값을 넘어가는 경우
	else if (k == 0) {
		for (int i = 0; i < n - 1; i++) {
			printf("B");
		}
		printf("A\n");
	}
	else {
		int sum = 0;//pair의 수
		int a = 1;//a의 개수
		for (int i = 0; i < n; i++) {
			if (n - a - i > 0 && sum + n - a - i <= k) {
				printf("A");
				sum += n - a - i;
				a++;
			}
			else printf("B");
		}//index
	}
}


/*
12970. AB
https://www.acmicpc.net/problem/12970

문제
정수 N과 K가 주어졌을 때, 다음 두 조건을 만족하는 문자열 S를 찾는 프로그램을 작성하시오.

문자열 S의 길이는 N이고, 'A', 'B'로 이루어져 있다.
문자열 S에는 0 ≤ i < j < N 이면서 s[i] == 'A' && s[j] == 'B'를 만족하는 (i, j) 쌍이 K개가 있다.
입력
첫째 줄에 N과 K가 주어진다. (2 ≤ N ≤ 50, 0 ≤ K ≤ N(N-1)/2)

출력
첫째 줄에 문제의 조건을 만족하는 문자열 S를 출력한다. 가능한 S가 여러 가지라면, 아무거나 출력한다. 만약, 그러한 S가 존재하지 않는 경우에는 -1을 출력한다.



A뒤에 오는 B의 개수 = 총 pair의 수
*/