#include<stdio.h>

int n;
int minus = 0, zero = 0, plus = 0;
int arr[2200][2200];

int check(int width, int row, int col) {
	int flag = 1;
	for (int i = col; i < col + width; i++) {
		for (int j = row; j < row + width; j++) {
			if (arr[col][row] != arr[i][j]) {
				flag = 0;
				break;
			}
		}
		if (flag == 0) break;
	}
	return flag;
}

void recur(int width, int row, int col) {
	if (check(width, row, col)) {
		if (arr[col][row] == -1) minus++;
		else if (arr[col][row] == 0) zero++;
		else plus++;
	}
	else {
		for (int i = row; i < row + width; i += width / 3) {
			for (int j = col; j < col + width; j += width / 3)
				recur(width / 3, i, j);
		}
	}
}

int main() {
	scanf("%d", &n);
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++)
			scanf("%d", &arr[i][j]);
	}
	recur(n, 1, 1);
	printf("%d\n%d\n%d\n", minus, zero, plus);

}

/*
1780. 종이의 개수
https://www.acmicpc.net/problem/1780

문제
N×N크기의 행렬로 표현되는 종이가 있다. 종이의 각 칸에는 -1, 0, 1의 세 값 중 하나가 저장되어 있다. 우리는 이 행렬을 적절한 크기로 자르려고 하는데, 이때 다음의 규칙에 따라 자르려고 한다.

만약 종이가 모두 같은 수로 되어 있다면 이 종이를 그대로 사용한다.
(1)이 아닌 경우에는 종이를 같은 크기의 9개의 종이로 자르고, 각각의 잘린 종이에 대해서 (1)의 과정을 반복한다.
이와 같이 종이를 잘랐을 때, -1로만 채워진 종이의 개수, 0으로만 채워진 종이의 개수, 1로만 채워진 종이의 개수를 구해내는 프로그램을 작성하시오.

입력
첫째 줄에 N(1≤N≤3^7, N은 3^k 꼴)이 주어진다. 다음 N개의 줄에는 N개의 정수로 행렬이 주어진다.

출력
첫째 줄에 -1로만 채워진 종이의 개수를, 둘째 줄에 0으로만 채워진 종이의 개수를, 셋째 줄에 1로만 채워진 종이의 개수를 출력한다.

*/