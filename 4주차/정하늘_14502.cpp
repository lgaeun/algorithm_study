#include<stdio.h>

int col, row;
int cnt = 0;
int safe = 0;
int max = 0;
int wall[10][10];
int comb[4] = { 0, };
int blank[65] = { 0, };
int visit[65] = { 0, };


void DFS(int c, int r, int vst[10][10]) {
	vst[c][r] = 1;
	if (vst[c][r + 1] == 0 && wall[c][r + 1] == 0) {
		safe--;
		DFS(c, r + 1, vst);
	}//오
	if (vst[c][r - 1] == 0 && wall[c][r - 1] == 0) {
		safe--;
		DFS(c, r - 1, vst);
	}//왼
	if (vst[c - 1][r] == 0 && wall[c - 1][r] == 0) {
		safe--;
		DFS(c - 1, r, vst);
	}//위
	if (vst[c + 1][r] == 0 && wall[c + 1][r] == 0) {
		safe--;
		DFS(c + 1, r, vst);
	}//아래
	//처음 DFS가 호출된 곳이 바이러스가 있는 곳이므로 0인 곳이 2로 바뀜
}


void permutation(int n, int depth) {
	comb[depth] = blank[n];
	if (depth == 3) {
		int vst[10][10] = { 0, };
		for (int i = 1; i < 4; i++) {
			if (comb[i] % row == 0) {
				wall[comb[i] / row][row] = 1;
			}
			else {
				wall[comb[i] / row + 1][comb[i] % row] = 1;
			}
		}//선택한 세개의 숫자에 맞는 위치에 벽을 세움
		safe = cnt - 3;//벽으로 세울 세개를 제외하고 시작
		for (int i = 1; i <= col; i++) {
			for (int j = 1; j <= row; j++) {
				if (vst[i][j] == 0 && wall[i][j] == 2) {
					DFS(i, j, vst);
				}//방문한적 없고 바이러스가 있으면 DFS
			}
		}
		for (int i = 1; i < 4; i++) {
			if (comb[i] % row == 0) {
				wall[comb[i] / row][row] = 0;
			}
			else {
				wall[comb[i] / row + 1][comb[i] % row] = 0;
			}
		}//선택했던 곳에 벽 지움
		if (safe > max) max = safe;
	}//comb값에서 0을 1로 바꿔주고 DFS를 호출함. 끝나면 다시 그부분 0
	else {
		for (int i = n + 1; i < cnt; i++) {
			if (visit[blank[i]] == 0) {
				visit[blank[i]] = 1;
				permutation(i, depth + 1);
				visit[blank[i]] = 0;
			}
		}
	}//blank 배열에서 숫자 세개를 선택하는 부분
}

int main() {
	scanf("%d%d", &col, &row);
	for (int i = 0; i < 10; i++) {
		for (int j = 0; j < 10; j++) {
			wall[i][j] = 1;
		}
	}
	for (int i = 1; i <= col; i++) {
		for (int j = 1; j <= row; j++) {
			scanf("%d", &wall[i][j]);
			if (wall[i][j] == 0) {
				blank[cnt] = (i - 1)*row + j;
				cnt++;
			}//0인 곳에 blank로 배열을 따로 만들어줌. cnt는 0의 개수
		}
	}
	permutation(-1, 0);
	printf("%d\n", max);
}


/*
14502. 연구소
https://www.acmicpc.net/problem/14502
 
문제
인체에 치명적인 바이러스를 연구하던 연구소에서 바이러스가 유출되었다. 다행히 바이러스는 아직 퍼지지 않았고, 바이러스의 확산을 막기 위해서 연구소에 벽을 세우려고 한다.

연구소는 크기가 N×M인 직사각형으로 나타낼 수 있으며, 직사각형은 1×1 크기의 정사각형으로 나누어져 있다. 연구소는 빈 칸, 벽으로 이루어져 있으며, 벽은 칸 하나를 가득 차지한다. 

일부 칸은 바이러스가 존재하며, 이 바이러스는 상하좌우로 인접한 빈 칸으로 모두 퍼져나갈 수 있다. 새로 세울 수 있는 벽의 개수는 3개이며, 꼭 3개를 세워야 한다.

예를 들어, 아래와 같이 연구소가 생긴 경우를 살펴보자.

2 0 0 0 1 1 0
0 0 1 0 1 2 0
0 1 1 0 1 0 0
0 1 0 0 0 0 0
0 0 0 0 0 1 1
0 1 0 0 0 0 0
0 1 0 0 0 0 0
이때, 0은 빈 칸, 1은 벽, 2는 바이러스가 있는 곳이다. 아무런 벽을 세우지 않는다면, 바이러스는 모든 빈 칸으로 퍼져나갈 수 있다.

2행 1열, 1행 2열, 4행 6열에 벽을 세운다면 지도의 모양은 아래와 같아지게 된다.

2 1 0 0 1 1 0
1 0 1 0 1 2 0
0 1 1 0 1 0 0
0 1 0 0 0 1 0
0 0 0 0 0 1 1
0 1 0 0 0 0 0
0 1 0 0 0 0 0
바이러스가 퍼진 뒤의 모습은 아래와 같아진다.

2 1 0 0 1 1 2
1 0 1 0 1 2 2
0 1 1 0 1 2 2
0 1 0 0 0 1 2
0 0 0 0 0 1 1
0 1 0 0 0 0 0
0 1 0 0 0 0 0
벽을 3개 세운 뒤, 바이러스가 퍼질 수 없는 곳을 안전 영역이라고 한다. 위의 지도에서 안전 영역의 크기는 27이다.

연구소의 지도가 주어졌을 때 얻을 수 있는 안전 영역 크기의 최댓값을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 지도의 세로 크기 N과 가로 크기 M이 주어진다. (3 ≤ N, M ≤ 8)

둘째 줄부터 N개의 줄에 지도의 모양이 주어진다. 0은 빈 칸, 1은 벽, 2는 바이러스가 있는 위치이다. 2의 개수는 2보다 크거나 같고, 10보다 작거나 같은 자연수이다.

빈 칸의 개수는 3개 이상이다.

출력
첫째 줄에 얻을 수 있는 안전 영역의 최대 크기를 출력한다.


 col * row 범위 내에서 0인 것만 배열을 따로 만들어서 그 중 숫자 세개를 선택
 그래서 이제 2가 있으면 위아래에 1이 아닌 경우 2로 바꿈
 다 바꾸고 0의 개수를 셈

*/
