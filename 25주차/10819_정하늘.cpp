#include<stdio.h>
#include<math.h>
#define SWAP(a,b){int tmp = a; a = b; b = tmp;}


int n,max=0;
int arr[9] = { 0 };


int getValue() {
	int val = 0;
	for (int i = 1; i < n; i++) {
		val += abs(arr[i]-arr[i-1]);
	}
	return val;
}

void permutations(int start, int end) {
	if (start == end) {
		int value = getValue();
		if (max < value) max = value;
	}
	else {
		for (int i = start; i <= end; i++) {
			SWAP(arr[start], arr[i]);
			permutations(start + 1, end);
			SWAP(arr[start], arr[i]);
		}
	}
}

int main() {

	scanf("%d", &n);
	for (int i = 0; i < n; i++)
		scanf("%d", &arr[i]);

	permutations(0, n - 1);
	printf("%d\n", max);
}

/*
10819. 차이를 최대로 
https://www.acmicpc.net/problem/10819

문제
N개의 정수로 이루어진 배열 A가 주어진다. 이때, 배열에 들어있는 정수의 순서를 적절히 바꿔서 다음 식의 최댓값을 구하는 프로그램을 작성하시오.

|A[0] - A[1]| + |A[1] - A[2]| + ... + |A[N-2] - A[N-1]|

입력
첫째 줄에 N (3 ≤ N ≤ 8)이 주어진다. 둘째 줄에는 배열 A에 들어있는 정수가 주어진다. 배열에 들어있는 정수는 -100보다 크거나 같고, 100보다 작거나 같다.

출력
첫째 줄에 배열에 들어있는 수의 순서를 적절히 바꿔서 얻을 수 있는 식의 최댓값을 출력한다.


permutations(순열)을 이용한 문제 풀이. 최대가 8이기 때문에 8^8이더라도 시간복잡도가 괜찮음.

permutation에서 arr[0]이 n1일 때,  arr[1]에 대해 permutation.
이런식으로 arr[0]이 n1일 때 재귀호출로 순열을 만들고,
다음으로 arr[0]이 n2일 때 ...
이것을 for문으로 0~n 까지 반복해서 모든 순열을 만든다. 각 순열에 대해 value를 check하여 max를 구함.

*/