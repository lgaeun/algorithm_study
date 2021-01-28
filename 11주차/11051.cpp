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



*/