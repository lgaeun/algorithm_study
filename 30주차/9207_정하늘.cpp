#include<stdio.h>
#include<iostream>
#include<vector>
#include<string>


using namespace std;

char map[6][10];
int dx[4] = { 1,-1,0,0 };
int dy[4] = { 0,0,1,-1 };

int pin_cnt, move_cnt;

int getMin(int a, int b) {
	return a >= b ? a : b;
}


void DFS(int depth, int cnt) {
	for (int i = 0; i < 5; i++) {
		for (int j = 0; j < 9; j++) {
			if (map[i][j] == 'o') {
				for (int k = 0; k < 4; k++) {
					int nx = i + dx[k];
					int ny = j + dy[k];
					//인접한 다음 칸
					if (nx >= 0 && nx < 5 && ny >= 0 && ny < 9 && map[nx][ny] == 'o') {
						int nnx = nx + dx[k];
						int nny = ny + dy[k];
						// 한 칸 건너뛴 다음 칸
						if (nnx >= 0 && nnx < 5 && nny >= 0 && nny < 9 && map[nnx][nny] == '.') {
							map[i][j] = '.';//현재칸
							map[nx][ny] = '.';//인접한 다음칸
							map[nnx][nny] = 'o';//이동할 칸
							DFS(depth + 1, cnt - 1);
							map[nnx][nny] = '.';
							map[nx][ny] = 'o';
							map[i][j] = 'o';
						}//빈 칸이어야 핀으로 바꿀 수 있음
					}
				}
			}
		}
	}//map 전체를 돌면서 장애물이 있는 곳에 대해 dfs
	if (cnt <= pin_cnt) {
		if (cnt == pin_cnt) move_cnt = getMin(depth, move_cnt);
		else move_cnt = depth;
		pin_cnt = cnt;
	}//최솟값으로 갱신
}


int main() {
	int t;

	scanf("%d", &t);
	while (t--) {	
		int cnt = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 9; j++) {
				scanf(" %c", &map[i][j]);
				if (map[i][j] == 'o') cnt++;
			}
		}

		pin_cnt = cnt, move_cnt = 0;//초기화
		DFS(0, cnt);
		printf("%d %d\n", pin_cnt, move_cnt);
	}
}



/*
9207. 페그 솔리테어
https://www.acmicpc.net/problem/9207

문제
페그 솔리테어는 구멍이 뚫려있는 이차원 게임판에서 하는 게임이다. 각 구멍에는 핀을 하나 꽂을 수 있다.

핀은 수평, 수직 방향으로 인접한 핀을 뛰어넘어서 그 핀의 다음 칸으로 이동하는 것만 허용된다. 인접한 핀의 다음 칸은 비어있어야 하고 그 인접한 핀은 제거된다.

현재 게임판에 꽂혀있는 핀의 상태가 주어진다. 이때, 핀을 적절히 움직여서 게임판에 남아있는 핀의 개수를 최소로 하려고 한다. 또, 그렇게 남기기 위해 필요한 최소 이동횟수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 테스트 케이스의 개수 1 ≤ N ≤ 100이 주어진다. 각 테스트 케이스는 게임판의 초기 상태이다.

게임판은 모두 같은 모양을 가진다. (예제 참고) '.'는 빈 칸, 'o'는 핀이 꽂혀있는 칸, '#'는 구멍이 없는 칸이다. 핀의 개수는 최대 8이며, 각 테스트 케이스는 빈 줄로 구분되어져 있다.

출력
각 테스트 케이스에 대해서, 핀을 움직여서 남길 수 있는 핀의 최소 개수와 그 개수를 만들기 위해 필요한 최소 이동 횟수를 출력한다.

*/
