#include<stdio.h>

int col, row;
int mat[510][510];
int visit[510][510] = { 0, };
int cnt[300000] = { 0, };
int idx = 0;
int max = 0;

int vectX[4] = { 1,-1,0,0 };
int vectY[4] = { 0,0,-1,1 };

void DFS(int c, int r) {
	visit[c][r] = 1;
	cnt[idx]++;
	for (int i = 0; i < 4; i++) {
		int nextX = c + vectX[i];
		int nextY = r + vectY[i];
		if (mat[nextX][nextY] == 1 && visit[nextX][nextY] == 0) {
			DFS(nextX, nextY);
		}
	}
}


int main() {
	scanf("%d%d", &col, &row);
	for (int i = 1; i <= col; i++) {
		for (int j = 1; j <= row; j++)
			scanf("%d", &mat[i][j]);
	}
	for (int i = 1; i <= col; i++) {
		for (int j = 1; j <= row; j++) {
			if (mat[i][j] == 1 && visit[i][j] == 0) {
				idx++;
				DFS(i, j);
				if (max < cnt[idx]) max = cnt[idx];
			}
		}
	}
	printf("%d\n", idx);
	printf("%d\n", max);
}

/*
1926. 그림
https://www.acmicpc.net/problem/1926

문제
어떤 큰 도화지에 그림이 그려져 있을 때, 그 그림의 개수와, 그 그림 중 넓이가 가장 넓은 것의 넓이를 출력하여라. 단, 그림이라는 것은 1로 연결된 것을 한 그림이라고 정의하자. 가로나 세로로 연결된 것은 연결이 된 것이고 대각선으로 연결이 된 것은 떨어진 그림이다. 그림의 넓이란 그림에 포함된 1의 개수이다.

입력
첫째 줄에 도화지의 세로 크기 n(1 ≤ n ≤ 500)과 가로 크기 m(1 ≤ m ≤ 500)이 차례로 주어진다. 두 번째 줄부터 n+1 줄 까지 그림의 정보가 주어진다. (단 그림의 정보는 0과 1이 공백을 두고 주어지며, 0은 색칠이 안된 부분, 1은 색칠이 된 부분을 의미한다)

출력
첫째 줄에는 그림의 개수, 둘째 줄에는 그 중 가장 넓은 그림의 넓이를 출력하여라. 단, 그림이 하나도 없는 경우에는 가장 넓은 그림의 넓이는 0이다.

*/