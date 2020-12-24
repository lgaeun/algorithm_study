#include<stdio.h>

int col, row;
int map[1010][1010] = { 0, };//입력


typedef struct dist {
	int row;
	int col;
	int distance;
}dist;

dist queue[10001];
int front = 0;
int rear = 0;

void insert(int c, int r, int distance) {
	queue[rear].col = c;
	queue[rear].row = r;
	queue[rear].distance = distance;
	rear++;
}

dist pop() {
	dist pop = queue[front];
	front++;
	return pop;
}


int BFS(int c, int r, int visit[1010][1010]) {
	insert(1, 1, 1);
	map[c][r] = 0;
	while (front < rear) {
		dist q = pop();
		visit[q.col][q.row] = q.distance;
		if (q.col < col && map[q.col + 1][q.row] == 0 && (visit[q.col + 1][q.row] == 0 || visit[q.col + 1][q.row] > q.distance + 1)) {
			insert(q.col + 1, q.row, q.distance + 1);
		}//상
		if (q.col > 1 && map[q.col - 1][q.row] == 0 && (visit[q.col - 1][q.row] == 0 || visit[q.col - 1][q.row] > q.distance + 1)) {
			insert(q.col - 1, q.row, q.distance + 1);
		}//하
		if (q.row > 1 && map[q.col][q.row - 1] == 0 && (visit[q.col][q.row - 1] == 0 || visit[q.col][q.row - 1] > q.distance + 1)) {
			insert(q.col, q.row - 1, q.distance + 1);
		}//좌
		if (q.row < row && map[q.col][q.row + 1] == 0 && (visit[q.col][q.row + 1] == 0 || visit[q.col][q.row + 1] > q.distance + 1)) {
			insert(q.col, q.row + 1, q.distance + 1);
		}//우
	}
	map[c][r] = 1;
	return visit[col][row];
}

int main() {
	scanf("%d%d", &col, &row);

	char str[1010];
	for (int i = 1; i <= col; i++) {
		scanf("%s", str);
		for (int j = 0; j < row; j++) {
			map[i][j + 1] = str[j] - '0';
		}
	}

	for (int i = 0; i <= row; i++) {
		map[0][i] = 1;
		map[col + 1][i] = 1;
	}
	for (int i = 0; i <= col; i++) {
		map[i][0] = 1;
		map[i][row + 1] = 1;
	}
	//테두리 벽으로 막음

	int ans = 999999;
	for (int i = 1; i <= col; i++) {
		for (int j = 1; j <= row; j++) {
			if (map[i][j] == 1) {
				int visit[1010][1010] = { 0, };//벽뚫은 거리
				int val = BFS(i, j, visit);
				if (val == 0);
				else {
					if (ans > val) {
						ans = val;
					}
				}
			}//벽이 있는 곳마다 BFS를 돌려봄
		}
	}
	if (ans == 999999) {
		ans = -1;
	}
	printf("%d\n", ans);
}


/*
2206.  
https://www.acmicpc.net/problem/2206
 
 3차원 배열을 쓴다는거 자체가. 모든 1이라는 벽에 대해서 부수기를 해본다는 거잖아?
 그러니까 어느 벽을 부술 지. 만약 이게 1이라면, 그거에 해당하는 BFS를 해보는거지

*/