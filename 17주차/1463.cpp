#include<stdio.h>
#include<string.h>
#include<malloc.h>

int *arr;

int check(int n) {
	int result = 0;
	if (n == 1) return result;
	if (arr[n] > 0) return arr[n];

	if (n > 1) {
		result = check(n - 1) + 1;
		arr[n] = result;
	}
	if (n % 3 == 0) {
		result = check(n / 3) + 1;
		if (arr[n] > result) arr[n] = result;
	}
	if (n % 2 == 0) {
		result = check(n / 2) + 1;
		if (arr[n] > result) arr[n] = result;
	}
	return arr[n];
}

int main() {
	int n;
	scanf("%d", &n);
	arr = (int *)malloc(sizeof(int *)*(n + 1));
	check(n);
	printf("%d\n", arr[n]);
}

/*
1463. 1로 만들기
https://www.acmicpc.net/problem/1463

문제
정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.

X가 3으로 나누어 떨어지면, 3으로 나눈다.
X가 2로 나누어 떨어지면, 2로 나눈다.
1을 뺀다.
정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.

입력
첫째 줄에 1보다 크거나 같고, 106보다 작거나 같은 정수 N이 주어진다.

출력
첫째 줄에 연산을 하는 횟수의 최솟값을 출력한다.

init!!

3 case :
i) -1 -> check(n-1)+1
ii) /3 -> check(n/3)+1
iii) /2 -> check(n/2)+1
arr[n] = min of three

*/