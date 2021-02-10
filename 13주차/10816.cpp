#include<stdio.h>
#include<algorithm>

int n, m, x;

int arr[500000];


int partition(int left, int right) {
	int pivot = (left + right) / 2;
	int tmp = arr[left];
	arr[left] = arr[pivot];
	arr[pivot] = tmp;
	pivot = left;

	int low = left;
	int high = right + 1;

	do {
		do {
			low++;
		} while (low <= right && arr[pivot] > arr[low]);
		do {
			high--;
		} while (left <= high && arr[pivot] < arr[high]);
		if (low < high) {
			tmp = arr[low];
			arr[low] = arr[high];
			arr[high] = tmp;
		}
	} while (low < high);

	tmp = arr[left];
	arr[left] = arr[high];
	arr[high] = tmp;

	return high;
}

void quicksort(int low, int high) {
	if (low < high) {
		int pivot = partition(low, high);
		quicksort(low, pivot - 1);
		quicksort(pivot + 1, high);
	}
}


int l_bound(int l, int r) {
	while (l < r) {
		int mid = (l + r) / 2;
		if (arr[mid] < x)
			l = mid + 1;
		else
			r = mid;
	}
	return l;
}

int u_bound(int l, int r) {
	while (l < r) {
		int mid = (l + r) / 2;
		if (arr[mid] <= x)
			l = mid + 1;
		else
			r = mid;
	}
	return r; 
}

int main() {
	scanf("%d", &n);

	for (int i = 0; i < n; i++) {
		scanf("%d", &arr[i]);
	}//init

	quicksort(0, n-1);

	scanf("%d", &m);
	for (int i = 0; i < m; i++) {
		scanf("%d", &x);
		printf("%d ", u_bound(0, n) - l_bound(0, n));
	}
}

/*
10816. 숫자 카드2
https://www.acmicpc.net/problem/10816

문제
숫자 카드는 정수 하나가 적혀져 있는 카드이다. 상근이는 숫자 카드 N개를 가지고 있다. 정수 M개가 주어졌을 때, 이 수가 적혀있는 숫자 카드를 상근이가 몇 개 가지고 있는지 구하는 프로그램을 작성하시오.

입력
첫째 줄에 상근이가 가지고 있는 숫자 카드의 개수 N(1 ≤ N ≤ 500,000)이 주어진다. 둘째 줄에는 숫자 카드에 적혀있는 정수가 주어진다. 숫자 카드에 적혀있는 수는 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다.

셋째 줄에는 M(1 ≤ M ≤ 500,000)이 주어진다. 넷째 줄에는 상근이가 몇 개 가지고 있는 숫자 카드인지 구해야 할 M개의 정수가 주어지며, 이 수는 공백으로 구분되어져 있다. 이 수도 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다.

출력
첫째 줄에 입력으로 주어진 M개의 수에 대해서, 각 수가 적힌 숫자 카드를 상근이가 몇 개 가지고 있는지를 공백으로 구분해 출력한다.

정렬 후 이진탐색
lower bound 와 upper bound를 구함.
*/