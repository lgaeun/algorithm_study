#include<stdio.h>
#include<vector>
#include<queue>

using namespace std;

int n, m;
int map[1001][1001];
int visit[1001][1001][2] = { 0, };//x,y,block 여부
int dx[4] = { 0,0,1,-1 };
int dy[4] = { 1,-1,0,0 };

int BFS() {
	queue< pair< pair<int, int>, pair<int, int> > > q;
	q.push({ {0,0},{0,1} });//시작점, 벽 뚫은 여부, cnt
	visit[0][0][0] = 1;//방문 체크

	while (!q.empty()) {
		int x = q.front().first.first;
		int y = q.front().first.second;
		int block = q.front().second.first;
		int cnt = q.front().second.second;
		q.pop();

		if (x == n - 1 && y == m - 1) {
			return cnt;
		}
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (0 <= nx && nx < n && 0 <= ny && ny < m) {
				if (map[nx][ny] == 1 && block == 0) {
					visit[nx][ny][block + 1] = 1;
					q.push({ { nx,ny }, { block + 1 , cnt + 1 } });
				}//벽이 있고, 뚫을 수 있다면				
				else if (map[nx][ny] == 0 && visit[nx][ny][block] == 0) {
					visit[nx][ny][block] = 1;
					q.push({ { nx,ny }, { block,cnt + 1 } });
				}
			}

		}
	}
	return -1;
}


int main() {
	scanf("%d%d", &n, &m);
	for (int i = 0; i < n; i++) {
		char s[1001];
		scanf(" %s", s);
		for (int j = 0; j < m; j++) {
			map[i][j] = s[j] - '0';
		}
	}
	printf("%d\n", BFS());
}


/*
2206. 벽 부수고 이동하기
https://www.acmicpc.net/problem/2206

문제
N×M의 행렬로 표현되는 맵이 있다. 맵에서 0은 이동할 수 있는 곳을 나타내고, 1은 이동할 수 없는 벽이 있는 곳을 나타낸다. 당신은 (1, 1)에서 (N, M)의 위치까지 이동하려 하는데, 이때 최단 경로로 이동하려 한다. 최단경로는 맵에서 가장 적은 개수의 칸을 지나는 경로를 말하는데, 이때 시작하는 칸과 끝나는 칸도 포함해서 센다.

만약에 이동하는 도중에 한 개의 벽을 부수고 이동하는 것이 좀 더 경로가 짧아진다면, 벽을 한 개 까지 부수고 이동하여도 된다.

한 칸에서 이동할 수 있는 칸은 상하좌우로 인접한 칸이다.

맵이 주어졌을 때, 최단 경로를 구해 내는 프로그램을 작성하시오.

입력
첫째 줄에 N(1 ≤ N ≤ 1,000), M(1 ≤ M ≤ 1,000)이 주어진다. 다음 N개의 줄에 M개의 숫자로 맵이 주어진다. (1, 1)과 (N, M)은 항상 0이라고 가정하자.

출력
첫째 줄에 최단 거리를 출력한다. 불가능할 때는 -1을 출력한다.

*/