#include<stdio.h>

char color[101][101] = { 0, };
int visit_weak[101][101] = { 0, };
int visit_orig[101][101] = { 0, };

int n;
int count_weak = 0, count_orig = 0;

void color_weak(int x, int y) {
	visit_weak[x][y] = 1;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if ((color[x - 1][y] == color[x][y] || (color[x][y] == 'R' && color[x - 1][y] == 'G') || (color[x][y] == 'G' && color[x - 1][y] == 'R')) && visit_weak[x - 1][y] == 0) {
				color_weak(x - 1, y);
			}
			else if ((color[x + 1][y] == color[x][y] || (color[x][y] == 'R' && color[x + 1][y] == 'G') || (color[x][y] == 'G' && color[x + 1][y] == 'R')) && visit_weak[x + 1][y] == 0) {
				color_weak(x + 1, y);
			}
			else if ((color[x][y + 1] == color[x][y] || (color[x][y] == 'R' && color[x][y + 1] == 'G') || (color[x][y] == 'G' && color[x][y + 1] == 'R')) && visit_weak[x][y + 1] == 0) {
				color_weak(x, y + 1);
			}
			else if ((color[x][y - 1] == color[x][y] || (color[x][y] == 'R' && color[x][y - 1] == 'G') || (color[x][y] == 'G' && color[x][y - 1] == 'R')) && visit_weak[x][y - 1] == 0) {
				color_weak(x, y - 1);
			}
		}
	}
}


void color_orig(int x, int y) {
	visit_orig[x][y] = 1;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (color[x - 1][y] == color[x][y] && visit_orig[x - 1][y] == 0) {
				color_orig(x - 1, y);
			}
			else if (color[x + 1][y] == color[x][y] && visit_orig[x + 1][y] == 0) {
				color_orig(x + 1, y);
			}
			else if (color[x][y + 1] == color[x][y] && visit_orig[x][y + 1] == 0) {
				color_orig(x, y + 1);
			}
			else if (color[x][y - 1] == color[x][y] && visit_orig[x][y - 1] == 0) {
				color_orig(x, y - 1);
			}
		}
	}
}


int main() {
	scanf("%d", &n);
	for (int i = 0; i < n; i++)
		scanf(" %s", &color[i]);
	for (int i = 0; i < n; i++) {
		for(int j=0;j<n;j++)
			if (visit_weak[i][j]==0) {
				color_weak(i,j);
				count_weak++;
			}
	}
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++)
			if (visit_orig[i][j]==0) {
				color_orig(i, j);
				count_orig++;
			}
	}
	printf("%d %d\n", count_orig, count_weak);
}


/*
10026. 적록색약
https://www.acmicpc.net/problem/10026

문제
적록색약은 빨간색과 초록색의 차이를 거의 느끼지 못한다. 따라서, 적록색약인 사람이 보는 그림은 아닌 사람이 보는 그림과는 좀 다를 수 있다.

크기가 N×N인 그리드의 각 칸에 R(빨강), G(초록), B(파랑) 중 하나를 색칠한 그림이 있다. 그림은 몇 개의 구역으로 나뉘어져 있는데, 구역은 같은 색으로 이루어져 있다. 또, 같은 색상이 상하좌우로 인접해 있는 경우에 두 글자는 같은 구역에 속한다. (색상의 차이를 거의 느끼지 못하는 경우도 같은 색상이라 한다)

예를 들어, 그림이 아래와 같은 경우에

RRRBB
GGBBB
BBBRR
BBRRR
RRRRR
적록색약이 아닌 사람이 봤을 때 구역의 수는 총 4개이다. (빨강 2, 파랑 1, 초록 1) 하지만, 적록색약인 사람은 구역을 3개 볼 수 있다. (빨강-초록 2, 파랑 1)

그림이 입력으로 주어졌을 때, 적록색약인 사람이 봤을 때와 아닌 사람이 봤을 때 구역의 수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N이 주어진다. (1 ≤ N ≤ 100)

둘째 줄부터 N개 줄에는 그림이 주어진다.

출력
적록색약이 아닌 사람이 봤을 때의 구역의 개수와 적록색약인 사람이 봤을 때의 구역의 수를 공백으로 구분해 출력한다.

*/