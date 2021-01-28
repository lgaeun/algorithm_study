#include<stdio.h>

#define mod 10007

int main() {
	int n, k;
	scanf("%d%d", &n, &k);
	if (n - k <= n / 2) k = n - k;
	int dp[1001][1001] = { 0, };
	for (int i = 0; i <= n; i++) {
		dp[i][0] = 1;
		dp[i][1] = i;
		dp[i][i] = 1;
	}
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < k; j++) {
			dp[i + 1][j + 1] = (dp[i][j] + dp[i][j + 1]) % mod;
		}
	}
	printf("%d\n", dp[n][k]);
}


/*
11051. 이항 계수 2
https://www.acmicpc.net/problem/11051

문제
자연수 과 정수 가 주어졌을 때 이항 계수 
를 10,007로 나눈 나머지를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 과 가 주어진다. (1 ≤  ≤ 1,000, 0 ≤  ≤ )

출력
 
를 10,007로 나눈 나머지를 출력한다.

*/
