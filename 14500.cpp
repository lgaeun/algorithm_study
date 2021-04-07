#include<stdio.h>

int n, m;
int mat[501][501];
int visit[501][501] = { 0, };

int dx[4] = { 0,0,1,-1 };//동서남북
int dy[4] = { 1,-1,0,0 };

int h_shape_x[4][3] = {
	{0, 0, -1},
	{0, 0, 1},
	{-1, 1, 0},
	{-1, 1, 0}}; //ㅗ ㅜ ㅏ ㅓ

int h_shape_y[4][3] = {
	{-1, 1, 0},
	{-1, 1, 0},
	{0, 0, 1},
	{0, 0, -1}};

int ans = 0;

void DFS(int x, int y, int depth, int sum) {
	if (depth == 4) {
		if (ans < sum) ans = sum;
		return;
	}
	for (int i = 0; i < 4; i++) {
		int nx = x + dx[i];
		int ny = y + dy[i];
		if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visit[nx][ny]) {
			visit[nx][ny] = 1;
			DFS(nx, ny, depth + 1, mat[nx][ny] + sum);
			visit[nx][ny] = 0;
		}
	}
}

void hshape(int x, int y) {
	for (int i = 0; i < 4; i++) {//ㅗ ㅜ ㅏ ㅓ
		int h = mat[x][y];
		int flag = 0;
		for (int j = 0; j < 3; j++) {
			int nx = x + h_shape_x[i][j];
			int ny = y + h_shape_y[i][j];
			if (nx < 0 || nx > n - 1 || ny < 0 || ny > m - 1) {
				flag = 1;
				break;
			}
			h += mat[nx][ny];
		}
		if (ans < h && !flag) ans = h;
	}
}//ㅗ 모양을 사방으로 검사

int main() {
	scanf("%d%d", &n, &m);
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++)
			scanf("%d", &mat[i][j]);
	}
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			visit[i][j] = 1;
			DFS(i, j, 1, mat[i][j]);
			hshape(i, j);
			visit[i][j] = 0;
		}
	}
	printf("%d\n", ans);
}


/*
14500. 테트로미노
https://www.acmicpc.net/problem/14500

문제
폴리오미노란 크기가 1×1인 정사각형을 여러 개 이어서 붙인 도형이며, 다음과 같은 조건을 만족해야 한다.

정사각형은 서로 겹치면 안 된다.
도형은 모두 연결되어 있어야 한다.
정사각형의 변끼리 연결되어 있어야 한다. 즉, 꼭짓점과 꼭짓점만 맞닿아 있으면 안 된다.
정사각형 4개를 이어 붙인 폴리오미노는 테트로미노라고 하며, 다음과 같은 5가지가 있다.



아름이는 크기가 N×M인 종이 위에 테트로미노 하나를 놓으려고 한다. 종이는 1×1 크기의 칸으로 나누어져 있으며, 각각의 칸에는 정수가 하나 쓰여 있다.

테트로미노 하나를 적절히 놓아서 테트로미노가 놓인 칸에 쓰여 있는 수들의 합을 최대로 하는 프로그램을 작성하시오.

테트로미노는 반드시 한 정사각형이 정확히 하나의 칸을 포함하도록 놓아야 하며, 회전이나 대칭을 시켜도 된다.

입력
첫째 줄에 종이의 세로 크기 N과 가로 크기 M이 주어진다. (4 ≤ N, M ≤ 500)

둘째 줄부터 N개의 줄에 종이에 쓰여 있는 수가 주어진다. i번째 줄의 j번째 수는 위에서부터 i번째 칸, 왼쪽에서부터 j번째 칸에 쓰여 있는 수이다. 입력으로 주어지는 수는 1,000을 넘지 않는 자연수이다.

출력
첫째 줄에 테트로미노가 놓인 칸에 쓰인 수들의 합의 최댓값을 출력한다.

*/