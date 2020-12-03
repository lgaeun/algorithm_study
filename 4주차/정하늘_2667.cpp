#include<stdio.h>

int arr[27][27] = { 0, };
int visited[27][27] = { 0, };
int result[315] = { 0, };
int count=0;
int n;


void sort() {
	for (int i = 1; i < count; i++) {
		int idx = i;
		int min = result[i];
		for (int j = i + 1; j <= count; j++) {
			if (result[j] < min) {
				min = result[j];
				idx = j;
			}
		}
		int temp = result[i];
		result[i] = result[idx];
		result[idx] = temp;
	}
}//sorting

void DFS(int x, int y) {
	visited[x][y] = 1;
	result[count]++;
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			if (arr[x - 1][y] == 1 && visited[x - 1][y] == 0) {
				DFS(x - 1, y);
			}
			else if (arr[x + 1][y] == 1 && visited[x + 1][y] == 0) {
				DFS(x + 1, y);
			}
			else if (arr[x][y+1] == 1 && visited[x ][y+1] == 0) {
				DFS(x, y+1);
			}
			else if (arr[x][y - 1] == 1 && visited[x][y - 1] == 0) {
				DFS(x, y - 1);
			}
		}//상하좌우에 방문하지 않은 집이 있다면 DFS 수행
	}
}

int main()
{
	char str[27];
	scanf("%d", &n);
	for (int i = 1; i <= n; i++) {
		scanf(" %s", str);
		for (int j = 1; j <= n; j++) {
			arr[i][j] = (int)str[j - 1] - 48;
		}
	}
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			if (arr[i][j] == 1 && visited[i][j] == 0) {
				count++;
				DFS(i, j);//한 단지가 끝나면 다른 단지에 대해 DFS
			}
		}
	}

	sort();
	printf("%d\n", count);
	for (int i = 1; i <= count; i++)
		printf("%d\n", result[i]);
}


/*
2667. 단지번호붙이기
https://www.acmicpc.net/problem/2667

문제
<그림 1>과 같이 정사각형 모양의 지도가 있다. 1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다. 철수는 이 지도를 가지고 연결된 집들의 모임인 단지를 정의하고, 단지에 번호를 붙이려 한다. 여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다. 대각선상에 집이 있는 경우는 연결된 것이 아니다. <그림 2>는 <그림 1>을 단지별로 번호를 붙인 것이다. 지도를 입력하여 단지수를 출력하고, 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오.



입력
첫 번째 줄에는 지도의 크기 N(정사각형이므로 가로와 세로의 크기는 같으며 5≤N≤25)이 입력되고, 그 다음 N줄에는 각각 N개의 자료(0혹은 1)가 입력된다.

출력
첫 번째 줄에는 총 단지수를 출력하시오. 그리고 각 단지내 집의 수를 오름차순으로 정렬하여 한 줄에 하나씩 출력하시오.

*/
