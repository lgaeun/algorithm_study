#include<stdio.h>
#include<iostream>
#include<vector>
#include<string>
#include<bitset>
#include<queue>

using namespace std;


int n, m;
int map[51][51];
string bit_map[51][51];//��Ʈ�� ��ȯ�� �� ����

int room[51][51];//�� ĭ�� ��� �濡 �ش��ϴ���
int room_num[51] = { 0, };//�� �� ���� ��ĭ�� �ִ���
int adj[51][51];//�� ��ȣ���� ��������
int room_cnt = 0;//�� ����
int max_num = 0;

int visit[51][51];
int bfs_visit[51][51];

int dx[4] = { 1,0,-1,0 };//�����ϼ�
int dy[4] = { 0,1,0,-1 };//�����ϼ�

int getMax(int x, int y) {
	return x > y ? x : y;
}

void BFS(int x, int y) {
	queue< pair< int, pair<int, int> > >q;
	q.push({ room[x][y], { x,y } });//�� ��ȣ, x, y ��ǥ
	while (!q.empty()) {
		pair<int, pair<int, int> > p = q.front();
		q.pop();

		for (int i = 0; i < 4; i++) {
			int room_n = p.first;
			int nx = p.second.first + dx[i];
			int ny = p.second.second + dy[i];
			
			if (nx < n && nx >= 0 && ny < m && ny >= 0 && !bfs_visit[nx][ny]) {
				bfs_visit[nx][ny] = 1;
				if (room[nx][ny] != room_n) {
					adj[room_n][room[nx][ny]] = 1;
					adj[room[nx][ny]][room_n] = 1;
				}
				q.push({ room[nx][ny], {nx,ny} });
				
			}//������ �ش��ϰ� ���� ���� ���
		}
	}
}//������ ���� ã�� ��

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
		}//������ �ش��ϰ� ���� ���� ���
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
	}//bit�� ��ȯ -> 11�� 1011 (�����ϼ�)

	/*
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cout << bit_map[i][j] << ' ';
		}
		printf("\n");
	}
	*/

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (!visit[i][j]) {
				visit[i][j] = 1;
				DFS(i, j);
				max_num = getMax(max_num, room_num[room_cnt]);
				room_cnt++;
				/*
				for (int c = 0; c < n; c++) {
					for (int r = 0; r < m; r++) {
						printf("%d ", visit[c][r]);
					}
					printf("\n");
				}
				*/
			}
		}
	}

	BFS(0, 0);
	int broke = 0;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (adj[i][j] == 1) {
				broke = getMax(broke, room_num[i] + room_num[j]);
			}
		}
	}

	printf("%d\n", room_cnt);
	printf("%d\n", max_num);
	printf("%d\n", broke);


}



/*
2234. ����
https://www.acmicpc.net/problem/2234



*/
