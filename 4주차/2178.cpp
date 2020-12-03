#include <stdio.h>

typedef struct n {
	int x;
	int y;
}q;

q queue[1000000];
int front = 0;
int rear = 0;

int map[101][101];
int visit[101][101];
int sizeX, sizeY;

void insert(int _y, int _x) {
	queue[rear].x = _x;
	queue[rear].y = _y;
	rear = rear + 1;
}

q pop() {
	q temp;
	temp.x = queue[front].x;
	temp.y = queue[front].y;
	front++;
	return temp;
}

int isEmpty() {
	if (rear == front)
		return 0;
	else
		return 1;
}

int m, n, i, j;
int vectX[4] = { 1,-1,0,0 };//동서남북 
int vectY[4] = { 0,0,-1,1 };//동서남북 
//X,Y 좌표 이동을 위한 X,Y vertor 배열

void bfs() {
	int y, x;
	int nextX;
	int nextY;
	while (isEmpty()) {
		q temp = pop();//1인 칸

		for (i = 0; i < 4; i++) {
			nextX = temp.x + vectX[i];
			nextY = temp.y + vectY[i];
			if (nextX > 0 && nextX <= sizeX && nextY > 0 && nextY <= sizeY) {//적정 범위 내의 좌표인지 체크
				if (map[nextY][nextX] == 1) {
					if (visit[nextY][nextX] == 0) {
						visit[nextY][nextX] = visit[temp.y][temp.x] + 1;//map[x][y]는 1인 칸이고, 거기까지 가는데 걸린 것을 측정해야 하기 때문에 +1을 함. +1은 이동 1칸
						insert(nextY, nextX);//다시 큐에 삽입
					}
					if (nextX == sizeX && nextY == sizeY) return;
				}
			}
		}
	}
}
int main() {
	scanf("%d %d", &sizeY, &sizeX);
	for (i = 1; i <= sizeY; i++) {
		char str[101];
		scanf(" %s", str);
		for (j = 1; j <= sizeX; j++) {
			map[i][j] = (int)str[j - 1] - 48;
		}
	}
	visit[1][1] = 1;
	insert(1, 1);

	bfs();
	printf("%d\n", visit[sizeY][sizeX]);
}


/*
2178. 미로 탐색
https://www.acmicpc.net/problem/2178

문제
N×M크기의 배열로 표현되는 미로가 있다.

1	0	1	1	1	1
1	0	1	0	1	0
1	0	1	0	1	1
1	1	1	0	1	1
미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다. 이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오. 한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.

위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.

입력
첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)이 주어진다. 다음 N개의 줄에는 M개의 정수로 미로가 주어진다. 각각의 수들은 붙어서 입력으로 주어진다.

출력
첫째 줄에 지나야 하는 최소의 칸 수를 출력한다. 항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다.

*/