#include<stdio.h>
#include<algorithm>

using namespace std;

int house[200001];

//공유기 두 개 사이의 거리가 x 이상이 되게 할 수 있는가?
int binarySearch(int n, int c) {
	int r = house[n - 1];
	int l = 1; 
	int ans = 0;
	while (l <= r) {
		int cnt = 1;
		int mid = (r + l) / 2;
		int start = house[0];
		for (int i = 1; i < n; i++)
			if (house[i] - start >= mid) {
				start = house[i];
				cnt++;
			}
		if (cnt >= c) {
			ans = mid;//x 이상이 되게 할 때 설치한 공유기의 수가 넘어갈 경우 -> 더 간격이 커져도 됨.
			l = mid + 1;
		}
		else r = mid - 1;//x 이상이 되게 할 때 설치 공유기가 모자랄 경우 -> 더 간격이 좁아져야 함.
	}
	return ans;
}



int main() {
	int n, gongu;
	scanf("%d%d", &n, &gongu);

	for (int i = 0; i < n; i++) {
		scanf("%d", &house[i]);
	}
	sort(house, house + n);
	printf("%d\n", binarySearch(n, gongu));
	
}




/*
2110. 공유기 설치
https://www.acmicpc.net/problem/2110

문제
도현이의 집 N개가 수직선 위에 있다. 각각의 집의 좌표는 x1, ..., xN이고, 집 여러개가 같은 좌표를 가지는 일은 없다.

도현이는 언제 어디서나 와이파이를 즐기기 위해서 집에 공유기 C개를 설치하려고 한다. 최대한 많은 곳에서 와이파이를 사용하려고 하기 때문에, 한 집에는 공유기를 하나만 설치할 수 있고, 가장 인접한 두 공유기 사이의 거리를 가능한 크게 하여 설치하려고 한다.

C개의 공유기를 N개의 집에 적당히 설치해서, 가장 인접한 두 공유기 사이의 거리를 최대로 하는 프로그램을 작성하시오.

입력
첫째 줄에 집의 개수 N (2 ≤ N ≤ 200,000)과 공유기의 개수 C (2 ≤ C ≤ N)이 하나 이상의 빈 칸을 사이에 두고 주어진다. 둘째 줄부터 N개의 줄에는 집의 좌표를 나타내는 xi (0 ≤ xi ≤ 1,000,000,000)가 한 줄에 하나씩 주어진다.

출력
첫째 줄에 가장 인접한 두 공유기 사이의 최대 거리를 출력한다.

*/