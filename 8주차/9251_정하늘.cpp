#include<stdio.h>
#include<string.h>

int getMax(int a, int b) {
	return a < b ? b : a;
}

int main() {
	char str1[1001];
	char str2[1001];
	int dp[1001][1001] = { 0, };

	scanf("%s%s", str1, str2);
	
	int str1_len = strlen(str1);
	int str2_len = strlen(str2);

	for (int i = 0; i < str1_len; i++) {
		for (int j = 0; j < str2_len; j++) {
			if (str1[i] == str2[j]) {
				dp[i + 1][j + 1] = dp[i][j] + 1;
			}//일치할 경우 이전것에서 +1
			else {
				dp[i + 1][j + 1] = getMax(dp[i + 1][j], dp[i][j + 1]);
			}//다를 경우 str1, str2 중에서 하나 앞의 index의 값 중 더 큰 것을 저장
			printf("dp[%d][%d]: %d\n", i+1, j+1, dp[i+1][j+1]);
		}
	}//dp로 문자열을 비교해나감. 
	printf("%d\n", dp[str1_len][str2_len]);
}

/*
9251. LCS
https://www.acmicpc.net/problem/9251

문제
LCS(Longest Common Subsequence, 최장 공통 부분 수열)문제는 두 수열이 주어졌을 때, 모두의 부분 수열이 되는 수열 중 가장 긴 것을 찾는 문제이다.

예를 들어, ACAYKP와 CAPCAK의 LCS는 ACAK가 된다.

입력
첫째 줄과 둘째 줄에 두 문자열이 주어진다. 문자열은 알파벳 대문자로만 이루어져 있으며, 최대 1000글자로 이루어져 있다.

출력
첫째 줄에 입력으로 주어진 두 문자열의 LCS의 길이를 출력한다.

*/
