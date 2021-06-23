#include<stdio.h>
#include<string.h>
#define MAX_SIZE 1000

int main() {
	int n;
	scanf("%d",&n);
	int arr[MAX_SIZE];
	for (int i = 0; i < n; i++) {
		scanf("%d", &arr[i]);
	}
	int dp[MAX_SIZE];
	for (int i = 0; i < n; i++) {
		dp[i] = 1;
	}
	//init

	int min;
	int max = 0;
	if (n == 1) max = 1;
	else {
		for (int i = 0; i < n; i++) {
			min = 0;
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i] && min<dp[j]) {
					min = dp[j];
				}
				//start at arr[i], compare arr[i-1] .... arr[1]
				//length of longest increment subarray : dp[j]
			}
			dp[i] = min + 1;//add arr[i] -> min + 1
			if (max < dp[i])
				max = dp[i];
		}
	}
	printf("%d\n", max);
}

/*
11053. 가장 긴 증가하는 부분 수열
https://www.acmicpc.net/problem/11053

문제
수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열을 구하는 프로그램을 작성하시오.

예를 들어, 수열 A = {10, 20, 10, 30, 20, 50} 인 경우에 가장 긴 증가하는 부분 수열은 A = {10, 20, 10, 30, 20, 50} 이고, 길이는 4이다.

입력
첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000)이 주어진다.

둘째 줄에는 수열 A를 이루고 있는 Ai가 주어진다. (1 ≤ Ai ≤ 1,000)

출력
첫째 줄에 수열 A의 가장 긴 증가하는 부분 수열의 길이를 출력한다.
*/