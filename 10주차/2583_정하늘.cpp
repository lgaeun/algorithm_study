#include<stdio.h>
#include<algorithm>

using namespace std;

int n, m;
int t;
int map[101][101] = { 0, };
int visited[101][101] = { 0, };
int result[5000] = { 0, };

int cnt;

int vectX[4] = { 1,-1,0,0 }; 
int vectY[4] = { 0,0,-1,1 };

typedef struct square {
	int left_x, left_y;
	int right_x, right_y;
}square;

square arr[101];

void DFS(int c, int r) {
	visited[c][r] = 1;
	result[cnt]++;
	for (int i = 0; i < 4; i++) {
		int nextX = c + vectX[i];
		int nextY = r + vectY[i];
		if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m) {//���� ���� ���� ��ǥ���� üũ
			if (map[nextX][nextY] == 0 && visited[nextX][nextY] == 0) {
				DFS(nextX, nextY);
			}
		}
	}
}


int main() {
	scanf("%d%d%d", &n, &m, &t);
	for (int i = 0; i < t; i++) {
		scanf("%d%d%d%d", &arr[i].left_x, &arr[i].left_y, &arr[i].right_x, &arr[i].right_y);
		arr[i].left_y = n - arr[i].left_y;
		arr[i].right_y = n - arr[i].right_y;
	}//좌표 재설정

	for (int i = 0; i < t; i++) {
		for (int j = arr[i].left_x; j < arr[i].right_x; j++) {
			for (int k = arr[i].right_y; k < arr[i].left_y; k++) {
				map[k][j] = 1;
			}
		}
	}//map에 벽 세우기

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (visited[i][j] == 0 && map[i][j] == 0) {
				DFS(i, j);
				cnt++;
			}
		}
	}

	sort(result, result + cnt);

	printf("%d\n", cnt);
	for (int i = 0; i < cnt - 1; i++)
		printf("%d ", result[i]);
	printf("%d\n", result[cnt - 1]);
}

/*
2583. 영역 구하기
https://www.acmicpc.net/problem/2583

문제
눈금의 간격이 1인 M×N(M,N≤100)크기의 모눈종이가 있다. 이 모눈종이 위에 눈금에 맞추어 K개의 직사각형을 그릴 때, 이들 K개의 직사각형의 내부를 제외한 나머지 부분이 몇 개의 분리된 영역으로 나누어진다.

예를 들어 M=5, N=7 인 모눈종이 위에 <그림 1>과 같이 직사각형 3개를 그렸다면, 그 나머지 영역은 <그림 2>와 같이 3개의 분리된 영역으로 나누어지게 된다.



<그림 2>와 같이 분리된 세 영역의 넓이는 각각 1, 7, 13이 된다.

M, N과 K 그리고 K개의 직사각형의 좌표가 주어질 때, K개의 직사각형 내부를 제외한 나머지 부분이 몇 개의 분리된 영역으로 나누어지는지, 그리고 분리된 각 영역의 넓이가 얼마인지를 구하여 이를 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 M과 N, 그리고 K가 빈칸을 사이에 두고 차례로 주어진다. M, N, K는 모두 100 이하의 자연수이다. 둘째 줄부터 K개의 줄에는 한 줄에 하나씩 직사각형의 왼쪽 아래 꼭짓점의 x, y좌표값과 오른쪽 위 꼭짓점의 x, y좌표값이 빈칸을 사이에 두고 차례로 주어진다. 모눈종이의 왼쪽 아래 꼭짓점의 좌표는 (0,0)이고, 오른쪽 위 꼭짓점의 좌표는(N,M)이다. 입력되는 K개의 직사각형들이 모눈종이 전체를 채우는 경우는 없다.

출력
첫째 줄에 분리되어 나누어지는 영역의 개수를 출력한다. 둘째 줄에는 각 영역의 넓이를 오름차순으로 정렬하여 빈칸을 사이에 두고 출력한다.

*/
