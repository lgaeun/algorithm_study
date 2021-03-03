#include<stdio.h>
#include<queue>
#include<vector>

#define INF 100000000

using namespace std;

int v, e, k;
vector<pair<int, int>> vert[20001];//인접행렬
int dist[20001];


int main() {
	scanf("%d%d%d", &v, &e, &k);

	for (int i = 1; i <= e; i++) {
		int x, y, d;
		scanf("%d%d%d", &x, &y, &d);
		vert[x].push_back(make_pair(d, y));
	}

	for (int i = 1; i <= v; i++) {
			dist[i] = INF;
	}

	priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
	pq.push(make_pair(0, k));
	dist[k] = 0;

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

	for (int i = 1; i <= v; i++) {
		if (dist[i] == INF) printf("INF\n");
		else printf("%d\n", dist[i]);
	}
}


                                                 
/*
1753. 최단경로
https://www.acmicpc.net/problem/1753

문제
방향그래프가 주어지면 주어진 시작점에서 다른 모든 정점으로의 최단 경로를 구하는 프로그램을 작성하시오. 단, 모든 간선의 가중치는 10 이하의 자연수이다.

입력
첫째 줄에 정점의 개수 V와 간선의 개수 E가 주어진다. (1≤V≤20,000, 1≤E≤300,000) 모든 정점에는 1부터 V까지 번호가 매겨져 있다고 가정한다. 둘째 줄에는 시작 정점의 번호 K(1≤K≤V)가 주어진다. 셋째 줄부터 E개의 줄에 걸쳐 각 간선을 나타내는 세 개의 정수 (u, v, w)가 순서대로 주어진다. 이는 u에서 v로 가는 가중치 w인 간선이 존재한다는 뜻이다. u와 v는 서로 다르며 w는 10 이하의 자연수이다. 서로 다른 두 정점 사이에 여러 개의 간선이 존재할 수도 있음에 유의한다.

출력
첫째 줄부터 V개의 줄에 걸쳐, i번째 줄에 i번 정점으로의 최단 경로의 경로값을 출력한다. 시작점 자신은 0으로 출력하고, 경로가 존재하지 않는 경우에는 INF를 출력하면 된다.

*/                      
