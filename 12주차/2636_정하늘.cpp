#include<stdio.h>
#include<queue>
#include<string.h>

using namespace std;

int col, row;
int ans = 0, left = 0;
int cheeze[101][101];
int check[101][101];
int vectX[4] = { 1,-1,0,0 };
int vectY[4] = { 0,0,-1,1 };

typedef struct ch {
	int x, y;
}ch;

void bfs() {
	memset(check, 0, sizeof(check));//매번 초기화 해줘야해서 memset 활용
	queue<ch> q;
	q.push({ 0, 0 });
	check[0][0] = 1;
	while (!q.empty()) {
		int x = q.front().x;
		int y = q.front().y;
		q.pop();
		for (int i = 0; i < 4; i++) {
			int nextX = x + vectX[i];
			int nextY = y + vectY[i];
			if (nextX < 0 || nextX >= col || nextY < 0 || nextY >= row) continue;//범위를 벗어나면 pass
			if (check[nextX][nextY]) continue;//방문했으면 pass
			if (cheeze[nextX][nextY] >= 1) {
				cheeze[nextX][nextY] += 1;
				continue;
			}//cheeze가 있는 경우 +1, 외부 공기가 아니므로 큐에 삽입하지 않고 continue 
			q.push({ nextX, nextY });
			check[nextX][nextY] = 1;
		}
	}
}

int melt() {
	bool melted = false;
	int cnt = 0;
	for (int i = 0; i < col; i++) {
		for (int j = 0; j < row; j++) {
			if (cheeze[i][j] >= 2) {//기본적으로 cheeze는 1이고, 외부와 맞닿은 치즈는 +1이 되어있으므로 2이상
				cheeze[i][j] = 0;
				melted = 1;
				cnt += 1;
			}
		}
	}
	if (cnt != 0) left = cnt;
	return melted;
}


int main() {
	scanf("%d%d", &col, &row);
	for (int i = 0; i < col; i++) {
		for (int j = 0; j < row; j++) {
			scanf("%d", &cheeze[i][j]);
		}
	}
	while (1) {
		bfs();
		if (melt()) ans++;
		else break;
	}
	printf("%d\n%d\n", ans, left);

}


/*
2636. 치즈
https://www.acmicpc.net/problem/2636

문제
아래 <그림 1>과 같이 정사각형 칸들로 이루어진 사각형 모양의 판이 있고, 그 위에 얇은 치즈(회색으로 표시된 부분)가 놓여 있다. 판의 가장자리(<그림 1>에서 네모 칸에 X친 부분)에는 치즈가 놓여 있지 않으며 치즈에는 하나 이상의 구멍이 있을 수 있다.

이 치즈를 공기 중에 놓으면 녹게 되는데 공기와 접촉된 칸은 한 시간이 지나면 녹아 없어진다. 치즈의 구멍 속에는 공기가 없지만 구멍을 둘러싼 치즈가 녹아서 구멍이 열리면 구멍 속으로 공기가 들어가게 된다. <그림 1>의 경우, 치즈의 구멍을 둘러싼 치즈는 녹지 않고 ‘c’로 표시된 부분만 한 시간 후에 녹아 없어져서 <그림 2>와 같이 된다.



다시 한 시간 후에는 <그림 2>에서 ‘c’로 표시된 부분이 녹아 없어져서 <그림 3>과 같이 된다.



<그림 3>은 원래 치즈의 두 시간 후 모양을 나타내고 있으며, 남은 조각들은 한 시간이 더 지나면 모두 녹아 없어진다. 그러므로 처음 치즈가 모두 녹아 없어지는 데는 세 시간이 걸린다. <그림 3>과 같이 치즈가 녹는 과정에서 여러 조각으로 나누어 질 수도 있다.

입력으로 사각형 모양의 판의 크기와 한 조각의 치즈가 판 위에 주어졌을 때, 공기 중에서 치즈가 모두 녹아 없어지는 데 걸리는 시간과 모두 녹기 한 시간 전에 남아있는 치즈조각이 놓여 있는 칸의 개수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에는 사각형 모양 판의 세로와 가로의 길이가 양의 정수로 주어진다. 세로와 가로의 길이는 최대 100이다. 판의 각 가로줄의 모양이 윗 줄부터 차례로 둘째 줄부터 마지막 줄까지 주어진다. 치즈가 없는 칸은 0, 치즈가 있는 칸은 1로 주어지며 각 숫자 사이에는 빈칸이 하나씩 있다.

출력
첫째 줄에는 치즈가 모두 녹아서 없어지는 데 걸리는 시간을 출력하고, 둘째 줄에는 모두 녹기 한 시간 전에 남아있는 치즈조각이 놓여 있는 칸의 개수를 출력한다.

*/
