#include<stdio.h>
#include<queue>
#include<string.h>

using namespace std;

int vectX[8] = { -2, -1, 1, 2, 2, 1, -1, -2 };
int vectY[8] = { 1, 2, 2, 1, -1, -2, -2, -1 };
//map[x][y] x가 세로

int n;
int x, y;
int tx, ty;
int visit[310][310] = { 0, };

int min;

void bfs() {
	queue<pair<int, int>> q;
	q.push(make_pair(x, y));
	while (!q.empty()) {
		int px = q.front().first;
		int py = q.front().second;
		q.pop();
		if (x == tx && y == ty) break;
		for (int i = 0; i < 8; i++) {
			int nextX = px + vectX[i];
			int nextY = py + vectY[i];
			if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n) {
				if (visit[nextX][nextY] == -1) {
					q.push(make_pair(nextX, nextY));
					visit[nextX][nextY] = visit[px][py] + 1;
				}
			}
		}
	}
}

int main() {
	int t;
	scanf("%d", &t);
	while (t--) {
		memset(visit, -1, sizeof(visit));
		scanf("%d", &n);
		scanf("%d%d", &x, &y);//현재위치
		scanf("%d%d", &tx, &ty);//목표위치
		bfs();
		printf("%d\n", visit[tx][ty] + 1);
	}
}




/*
7562. 나이트의 이동
https://www.acmicpc.net/problem/7562

문제
체스판 위에 한 나이트가 놓여져 있다. 나이트가 한 번에 이동할 수 있는 칸은 아래 그림에 나와있다. 나이트가 이동하려고 하는 칸이 주어진다. 나이트는 몇 번 움직이면 이 칸으로 이동할 수 있을까?



입력
입력의 첫째 줄에는 테스트 케이스의 개수가 주어진다.

각 테스트 케이스는 세 줄로 이루어져 있다. 첫째 줄에는 체스판의 한 변의 길이 l(4 ≤ l ≤ 300)이 주어진다. 체스판의 크기는 l × l이다. 체스판의 각 칸은 두 수의 쌍 {0, ..., l-1} × {0, ..., l-1}로 나타낼 수 있다. 둘째 줄과 셋째 줄에는 나이트가 현재 있는 칸, 나이트가 이동하려고 하는 칸이 주어진다.

출력
각 테스트 케이스마다 나이트가 최소 몇 번만에 이동할 수 있는지 출력한다.

*/