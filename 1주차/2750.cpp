#include<stdio.h>

int n;
int arr[1001];

void SWAP(int index1, int index2) {
	int temp = arr[index1];
	arr[index1] = arr[index2];
	arr[index2] = temp;
}

void insertion_sort() {
	for (int i = 0; i < n - 1; i++) {
		int min = arr[i];
		int min_index = i;
		for (int j = i + 1; j < n; j++) {
			if (min > arr[j]) {
				min = arr[j];
				min_index = j;
			}
		}
		SWAP(i, min_index);
	}
}

int main() {
	scanf("%d", &n);
	for (int i = 0; i < n; i++)
		scanf("%d", &arr[i]);
	insertion_sort();
	for (int i = 0; i < n; i++)
		printf("%d\n", arr[i]);
}


/*
2750. 수 정렬하기
https://www.acmicpc.net/problem/2750

문제
N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

입력
첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 숫자가 주어진다. 이 수는 절댓값이 1,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.

출력
첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.

*/