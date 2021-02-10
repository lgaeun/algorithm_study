#include<stdio.h>
#define MAX_SIZE 100000

int main() {
	int n;
	scanf("%d",&n);
	int arr[MAX_SIZE];
	for (int i = 0; i < n; i++) {
		scanf("%d", &arr[i]);
	}

	int max = arr[0];
	int sum = 0;
	if (n == 1) max = arr[0];
	else {
		for (int i = 0; i < n; i++) {
			sum += arr[i];
			if (sum > max) max = sum;
			if (sum < 0) sum = 0;
		}
	}
	printf("%d\n", max);
}

/*
1912. 연속합
https://www.acmicpc.net/problem/1912

문제
n개의 정수로 이루어진 임의의 수열이 주어진다. 우리는 이 중 연속된 몇 개의 수를 선택해서 구할 수 있는 합 중 가장 큰 합을 구하려고 한다. 단, 수는 한 개 이상 선택해야 한다.

예를 들어서 10, -4, 3, 1, 5, 6, -35, 12, 21, -1 이라는 수열이 주어졌다고 하자. 여기서 정답은 12+21인 33이 정답이 된다.

입력
첫째 줄에 정수 n(1 ≤ n ≤ 100,000)이 주어지고 둘째 줄에는 n개의 정수로 이루어진 수열이 주어진다. 수는 -1,000보다 크거나 같고, 1,000보다 작거나 같은 정수이다.

출력
첫째 줄에 답을 출력한다.

max를 arr[0]으로 설정하고, max보다 sum이 클 경우 교체
sum이 음수가 될 경우 그 앞은 버린다는 의미로 0으로 reset

*/