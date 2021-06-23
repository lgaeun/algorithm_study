#include<stdio.h>
#include<iostream>
#include<vector>
#include<string>
#include<bitset>
#include<queue>

using namespace std;


int n, m;
int map[51][51];
string bit_map[51][51];//비트로 변환한 벽 정보

int room[51][51];//각 칸이 어느 방에 해당하는지
int room_num[2501] = { 0, };//각 방 별로 몇칸씩 있는지
vector<int> adj[2501];//방 번호마다 인접한지
int room_cnt = 0;//방 개수
int max_num = 0;

int visit[51][51];
int bfs_visit[51][51];

int dx[4] = { 1,0,-1,0 };//남동북서
int dy[4] = { 0,1,0,-1 };//남동북서

int getMax(int x, int y) {
	return x > y ? x : y;
}

void DFS(int x, int y) {
	room[x][y] = room_cnt;
	room_num[room_cnt]++;
	for (int i = 0; i < 4; i++) {
		int nx = x + dx[i];
		int ny = y + dy[i];
		if (nx < n && nx >= 0 && ny < m && ny >= 0 ){
			if (bit_map[x][y][i] == '0' && !visit[nx][ny]) {
				visit[nx][ny] = 1;
				DFS(nx, ny);
			}
		}//범위에 해당하고 벽이 없는 경우
	}
}


int main() {
	scanf("%d%d", &m, &n);
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			scanf("%d", &map[i][j]);
		}
	}
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			bitset<4> bs(map[i][j]);
			bit_map[i][j] = bs.to_string();
		}
	}//bit로 변환 -> 11은 1011 (남동북서)

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (!visit[i][j]) {
				visit[i][j] = 1;			
				DFS(i, j);				
				max_num = getMax(max_num, room_num[room_cnt]);
				room_cnt++;
			}
		}
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			for (int k = 0; k < 4; k++) {
				int room_n = room[i][j];
				int nx = i + dx[k];
				int ny = j + dy[k];
				if (nx < n && nx >= 0 && ny < m && ny >= 0) {
					if (room_n != room[nx][ny]) {
						adj[room_n].push_back(room[nx][ny]);
						adj[room[nx][ny]].push_back(room_n);
					}
				}
			}
		}
	}

	int broke = max_num;

	for (int i = 0; i < room_cnt; i++) {
		int size = adj[i].size();
		for (int j = 0; j < size; j++) {
			broke = getMax(broke, room_num[i] + room_num[adj[i][j]]);
		}
	}

	printf("%d\n", room_cnt);
	printf("%d\n", max_num);
	printf("%d\n", broke);
}



/*
2234. 성곽
https://www.acmicpc.net/problem/2234

문제


대략 위의 그림과 같이 생긴 성곽이 있다. 굵은 선은 벽을 나타내고, 점선은 벽이 없어서 지나다닐 수 있는 통로를 나타낸다. 이러한 형태의 성의 지도를 입력받아서 다음을 계산하는 프로그램을 작성하시오.

이 성에 있는 방의 개수
가장 넓은 방의 넓이
하나의 벽을 제거하여 얻을 수 있는 가장 넓은 방의 크기
위의 예에서는 방은 5개고, 가장 큰 방은 9개의 칸으로 이루어져 있으며, 위의 그림에서 화살표가 가리키는 벽을 제거하면 16인 크기의 방을 얻을 수 있다.

성은 m×n(1 ≤ m, n ≤ 50)개의 정사각형 칸으로 이루어진다. 성에는 최소 두 개의 방이 있어서, 항상 하나의 벽을 제거하여 두 방을 합치는 경우가 있다.

입력
첫째 줄에 두 정수 n, m이 주어진다. 다음 m개의 줄에는 n개의 정수로 벽에 대한 정보가 주어진다. 벽에 대한 정보는 한 정수로 주어지는데, 서쪽에 벽이 있을 때는 1을, 북쪽에 벽이 있을 때는 2를, 동쪽에 벽이 있을 때는 4를, 남쪽에 벽이 있을 때는 8을 더한 값이 주어진다. 참고로 이진수의 각 비트를 생각하면 쉽다. 따라서 이 값은 0부터 15까지의 범위 안에 있다.

출력
첫째 줄에 1의 답을, 둘째 줄에 2의 답을, 셋째 줄에 3의 답을 출력한다.

*/
