#include <stdio.h>

int n, m;
int adj[1001][1001] = { 0, };
int visit[1001] = { 0, };


void DFS(int v, int vertice) {
	visit[v] = 1;
	for (int i = 1; i <= vertice; i++) {
		if (adj[v][i] == 1 && visit[i] == 0) {
			DFS(i, vertice);
		}
	}
	return;
}


int main(void) {

	scanf("%d%d", &n, &m);

	for (int i = 1; i <= m; i++) {
		int a, b;
		scanf("%d%d", &a, &b);
		adj[a][b] = 1;
		adj[b][a] = 1;
	}
	int chk = 0;
	int comp = 0;
	int v = 1;
	while (chk == 0) {
		chk = 1;
		DFS(v, n);//새로운 정점에 DFS를 실행하면 comp++
		comp++;
		for (int i = 1; i <= n; i++) {
			if (visit[i] == 0) {
				chk = 0;
				v = i;
				break;
			}//방문 안 된 정점이 있으면 해당 정점으로 DFS
		}
	}//모든 정점이 방문될 때까지 반복
	printf("%d\n", comp);
}


/*
11724. 연결 요소의 개수
https://www.acmicpc.net/problem/11724

문제
방향 없는 그래프가 주어졌을 때, 연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다. (1 ≤ N ≤ 1,000, 0 ≤ M ≤ N×(N-1)/2) 둘째 줄부터 M개의 줄에 간선의 양 끝점 u와 v가 주어진다. (1 ≤ u, v ≤ N, u ≠ v) 같은 간선은 한 번만 주어진다.

출력
첫째 줄에 연결 요소의 개수를 출력한다.

*/
