#include<stdio.h>

int n, sum, count = 0;
int arr[21] = { 0, };

void DFS(int idx, int S) {
	S += arr[idx];//idx==n일때, 0이기 때문에 문제없음
	if (idx == n) {
		if (S == sum) count++;
	}//끝까지 배열을 돌았을 때 일치하면 ++
	else {
		DFS(idx + 1, S - arr[idx]);//not include
		DFS(idx + 1, S);//inclue
	}
}

int main() {
	scanf("%d%d", &n,&sum);
	for (int i = 0; i < n; i++)
		scanf("%d", &arr[i]);
	DFS(0,0);
	if (sum == 0) count -= 1;//0인 경우, 공집합을 포함하기 때문에 -1
	printf("%d\n", count);
}

/*
1182. 부분수열의 합
https://www.acmicpc.net/problem/1182

문제
N개의 정수로 이루어진 수열이 있을 때, 크기가 양수인 부분수열 중에서 그 수열의 원소를 다 더한 값이 S가 되는 경우의 수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 정수의 개수를 나타내는 N과 정수 S가 주어진다. (1 ≤ N ≤ 20, |S| ≤ 1,000,000) 둘째 줄에 N개의 정수가 빈 칸을 사이에 두고 주어진다. 주어지는 정수의 절댓값은 100,000을 넘지 않는다.

출력
첫째 줄에 합이 S가 되는 부분수열의 개수를 출력한다.

*/