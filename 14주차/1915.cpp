#include <stdio.h>

int n, m;
int map[1001][1001] = { 0, };

int min(int a, int b) {
	return a <= b ? a : b;
}


int main() {
	scanf("%d%d", &n, &m);
	for (int i = 1; i <= n; i++) {
		char num[1001];
		scanf("%s", num);
		for (int j = 0; j < m; j++) {
			map[i][j + 1] = num[j] - '0';
		}
	}

	int ans = 0; //한 변의 최대 길이

	for (int i = 1; i <= n; i++) {  
		for (int j = 1; j <= m; j++) {
			if (map[i][j] != 0) {
				map[i][j] = min(map[i - 1][j - 1], min(map[i - 1][j], map[i][j - 1])) + 1;
				if (ans < map[i][j]) ans = map[i][j];
			}
		}
	}

	printf("%d\n", ans*ans);
}



//왼, 왼위, 위 세 곳 보기

/*
1915. 가장 큰 정사각형
https://www.acmicpc.net/problem/1915

문제
n×m의 0, 1로 된 배열이 있다. 이 배열에서 1로 된 가장 큰 정사각형의 크기를 구하는 프로그램을 작성하시오.

0	1	0	0
0	1	1	1
1	1	1	0
0	0	1	0
위와 같은 예제에서는 가운데의 2×2 배열이 가장 큰 정사각형이다. 

입력
첫째 줄에 n, m(1 ≤ n, m ≤ 1,000)이 주어진다. 다음 n개의 줄에는 m개의 숫자로 배열이 주어진다.

출력
첫째 줄에 가장 큰 정사각형의 넓이를 출력한다.

*/