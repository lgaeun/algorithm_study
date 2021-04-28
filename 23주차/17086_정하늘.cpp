#include<stdio.h>
#include<string.h>
#include<queue>

using namespace std;

int n, m;
int map[51][51];
int dx[8] = { -1,-1,0,1,1,1,0,-1 };//북쪽부터 시계방향으로
int dy[8] = { 0,1,1,1,0,-1,-1,-1 };

int visit[51][51] = { 0, };
int ans = 0;

queue< pair< int, pair<int, int>> > q;//idx, xy좌표

int max(int x, int y) {
	return x > y ? x : y;
}

int min(int x, int y) {
	return x < y ? x : y;
}

int check(int x, int y) {
	if (x < 0 || x > n - 1 || y < 0 || y > m - 1) return 0;
	if (visit[x][y] == 1) return 0;
	return 1;
}


void BFS(int x, int y) {
	visit[x][y] = 1;
	int distance = 100;
	q.push({ 0, { x, y } });
	while (!q.empty()) {
		pair< int, pair<int, int> > p = q.front();
		q.pop();
		if (map[p.second.first][p.second.second]) {
			distance = min(distance, p.first);//최단 안전거리
			ans = max(distance, ans);
		}//상어를 만난 경우
		for (int i = 0; i < 8; i++) {
			int nx = p.second.first + dx[i];
			int ny = p.second.second + dy[i];
			if (check(nx, ny)) {
				q.push({ p.first + 1,{ nx,ny } });
				visit[nx][ny] = 1;
			}
		}
	}
}


int main() {
	scanf("%d%d", &n, &m);
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			scanf("%d", &map[i][j]);
		}
	}
	
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (map[i][j] == 0) BFS(i, j);
			memset(visit, 0, sizeof(map));
		}
	}
	printf("%d\n", ans);
}



/*
17086. 아기 상어 2
https://www.acmicpc.net/problem/17086

문제
N×M 크기의 공간에 아기 상어 여러 마리가 있다. 공간은 1×1 크기의 정사각형 칸으로 나누어져 있다. 한 칸에는 아기 상어가 최대 1마리 존재한다.

어떤 칸의 안전 거리는 그 칸과 가장 거리가 가까운 아기 상어와의 거리이다. 두 칸의 거리는 하나의 칸에서 다른 칸으로 가기 위해서 지나야 하는 칸의 수이고, 이동은 인접한 8방향(대각선 포함)이 가능하다.

안전 거리가 가장 큰 칸을 구해보자. 

입력
첫째 줄에 공간의 크기 N과 M(2 ≤ N, M ≤ 50)이 주어진다. 둘째 줄부터 N개의 줄에 공간의 상태가 주어지며, 0은 빈 칸, 1은 아기 상어가 있는 칸이다. 빈 칸의 개수가 한 개 이상인 입력만 주어진다.

출력
첫째 줄에 안전 거리의 최댓값을 출력한다.

*/
