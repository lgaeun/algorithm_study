#include<stdio.h>
#include<vector>
#include<algorithm>

using namespace std;

int getMin(int x, int y) {
	return x <= y ? x : y;
}

int main() {
	int n, M;
	scanf("%d%d", &n, &M);
	vector<int> arr;

	for (int i = 0; i < n; i++) {
		int x;
		scanf("%d", &x);
		arr.push_back(x);
	}
	
	sort(arr.begin(), arr.end());

	int start = 0, end = 0;
	int ans = 1999999999;

	while (end < n) {
		int diff = arr[end] - arr[start];
		if (diff >= M) {
			ans = getMin(ans, diff);
		}
		if (diff == M) {
			break;
		}
		if (start == end) end++;
		else {
			if (diff > M) {
				start++;
			}
			else {
				end++;
			}//diff < M
		}
	}
	printf("%d\n", ans);
}


/*
2230. 수 고르기
https://www.acmicpc.net/problem/2230

문제
N(1≤N≤100,000)개의 수로 이루어진 수열 A[1], A[2], …, A[N]이 있다. 이 수열에서 두 수를 골랐을 때(같은 수일 수도 있다), 그 차이가 M 이상이면서 제일 작은 경우를 구하는 프로그램을 작성하시오.

예를 들어 수열이 {1, 2, 3, 4, 5}라고 하자. 만약 M=3일 경우, 1 4, 1 5, 2 5를 골랐을 때 그 차이가 M 이상이 된다. 이 중에서 차이가 가장 작은 경우는 1 4나 2 5를 골랐을 때의 3이 된다.

입력
첫째 줄에 두 정수 N, M(0≤M≤2,000,000,000)이 주어진다. 다음 N개의 줄에는 차례로 A[1], A[2], …, A[N]이 주어진다. 각각의 A[i]는 0 ≤ |A[i]| ≤ 1,000,000,000을 만족한다.

출력
첫째 줄에 M 이상이면서 가장 작은 차이를 출력한다. 항상 차이가 M이상인 두 수를 고를 수 있다.

*/