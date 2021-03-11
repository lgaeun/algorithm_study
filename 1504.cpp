#include<stdio.h>
#include<queue>
#include<vector>

#define INF 100000000

using namespace std;

int v, e;
int v1, v2;
vector<pair<int, int>> vert[8001];//인접행렬
int dist[8001];


int min(int a, int b) {
	return a < b ? a : b;
}


void Dijkstra(int start) {
	priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
	pq.push(make_pair(0, start));//dist, 시작정점
	dist[start] = 0;

	while (!pq.empty()) {
		int cost = pq.top().first;
		int x = pq.top().second;
		pq.pop();
		if (dist[x] < cost) continue;
		for (int i = 0; i < vert[x].size(); i++) {//x에 연결된 모든 정점들에 대해 거리배열 갱신
			int nx = vert[x][i].second;//x에 연결된 다음 정점
			int nd = vert[x][i].first;//다음 정점까지의 거리
			if (cost + nd < dist[nx]) {
				dist[nx] = cost + nd;
				pq.push(make_pair(cost + nd, nx));
			}//dist에 저장된 값보다 작은 경우 최솟값으로 변경
		}
	}
}

int main() {
	scanf("%d%d", &v, &e);

	for (int i = 1; i <= e; i++) {
		int x, y, d;
		scanf("%d%d%d", &x, &y, &d);
		vert[x].push_back(make_pair(d, y));
		vert[y].push_back(make_pair(d, x));
	}

	scanf("%d%d", &v1, &v2);

	int D1v1, D1v2, Dv1v2, Dv1v, Dv2v;
	int flag1 = true, flag2 = true;

	for (int i = 1; i <= v; i++) {
		dist[i] = INF;
	}
	Dijkstra(1);
	D1v1 = dist[v1];
	D1v2 = dist[v2];
	if (D1v1 == INF) flag1 = false;
	if (D1v2 == INF) flag2 = false;


	for (int i = 1; i <= v; i++) {
		dist[i] = INF;
	}
	Dijkstra(v1);
	Dv1v2 = dist[v2];
	Dv1v = dist[v];
	if (Dv1v2 == INF) {
		flag1 = false;
		flag2 = false;
	}
	if (Dv1v == INF) flag2 = false;


	for (int i = 1; i <= v; i++) {
		dist[i] = INF;
	}
	Dijkstra(v2);
	Dv2v = dist[v];
	if (Dv2v == INF) flag1 = false;

	if (flag1 == false && flag2 == false) {
		printf("-1\n");
	}
	else if (flag1 == false) {
		printf("%d\n", D1v2 + Dv1v2 + Dv1v);
	}
	else if (flag2 == false) {
		printf("%d\n", D1v1 + Dv1v2 + Dv2v);
	}
	else {
		printf("%d\n", min(D1v2 + Dv1v2 + Dv1v, D1v1 + Dv1v2 + Dv2v));
	}
}



                                                 
/*
1504. 특정한 최단 경로
https://www.acmicpc.net/problem/1504

문제
방향성이 없는 그래프가 주어진다. 세준이는 1번 정점에서 N번 정점으로 최단 거리로 이동하려고 한다. 또한 세준이는 두 가지 조건을 만족하면서 이동하는 특정한 최단 경로를 구하고 싶은데, 그것은 바로 임의로 주어진 두 정점은 반드시 통과해야 한다는 것이다.

세준이는 한번 이동했던 정점은 물론, 한번 이동했던 간선도 다시 이동할 수 있다. 하지만 반드시 최단 경로로 이동해야 한다는 사실에 주의하라. 1번 정점에서 N번 정점으로 이동할 때, 주어진 두 정점을 반드시 거치면서 최단 경로로 이동하는 프로그램을 작성하시오.

입력
첫째 줄에 정점의 개수 N과 간선의 개수 E가 주어진다. (2 ≤ N ≤ 800, 0 ≤ E ≤ 200,000) 둘째 줄부터 E개의 줄에 걸쳐서 세 개의 정수 a, b, c가 주어지는데, a번 정점에서 b번 정점까지 양방향 길이 존재하며, 그 거리가 c라는 뜻이다. (1 ≤ c ≤ 1,000) 다음 줄에는 반드시 거쳐야 하는 두 개의 서로 다른 정점 번호 v1과 v2가 주어진다. (v1 ≠ v2, v1 ≠ N, v2 ≠ 1)

출력
첫째 줄에 두 개의 정점을 지나는 최단 경로의 길이를 출력한다. 그러한 경로가 없을 때에는 -1을 출력한다.

*/                      