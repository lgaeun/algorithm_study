#include<stdio.h>
#include<vector>
#include<string.h>

using namespace std;

#define MAX 1000010

int v, e;
int n = 0;
int ans = 0;
vector<pair<int, int>> graph[10001];
int dist[10001];
int contain[10001] = { 0, };//포함된 정점 체크

void cal_dist(int vertex) {
	contain[vertex] = 1;
	n++;
	for (int i = 0; i < graph[vertex].size(); i++) {
		int dst = graph[vertex][i].first;
		int w = graph[vertex][i].second;
		if (dist[dst] > w) dist[dst] = w;
	}
}//새롭게 포함된 정점을 기준으로 거리를 re-calculate

void Prim() {
	cal_dist(1);
	while (n < v) {
		int min = MAX;
		int min_idx = 0;
		for (int i = 1; i <= v; i++) {
			if (min > dist[i] && contain[i] == 0) {
				min = dist[i];
				min_idx = i;
			}//거리배열에서 최솟값 찾기
		}
		ans += min;
		cal_dist(min_idx);
	}
}

int main() {
	scanf("%d%d", &v, &e);
	for (int i = 0; i < e; i++) {
		int v1, v2, w;
		scanf("%d%d%d", &v1, &v2, &w);
		graph[v1].push_back({ v2, w });
		graph[v2].push_back({ v1, w });
	}

	memset(dist, MAX, sizeof(dist));
	Prim();
	printf("%d\n", ans);
}


/*
1197. 최소 스패닝 트리
https://www.acmicpc.net/problem/1197

문제
그래프가 주어졌을 때, 그 그래프의 최소 스패닝 트리를 구하는 프로그램을 작성하시오.

최소 스패닝 트리는, 주어진 그래프의 모든 정점들을 연결하는 부분 그래프 중에서 그 가중치의 합이 최소인 트리를 말한다.

입력
첫째 줄에 정점의 개수 V(1 ≤ V ≤ 10,000)와 간선의 개수 E(1 ≤ E ≤ 100,000)가 주어진다. 다음 E개의 줄에는 각 간선에 대한 정보를 나타내는 세 정수 A, B, C가 주어진다. 이는 A번 정점과 B번 정점이 가중치 C인 간선으로 연결되어 있다는 의미이다. C는 음수일 수도 있으며, 절댓값이 1,000,000을 넘지 않는다.

그래프의 정점은 1번부터 V번까지 번호가 매겨져 있고, 임의의 두 정점 사이에 경로가 있다. 최소 스패닝 트리의 가중치가 -2,147,483,648보다 크거나 같고, 2,147,483,647보다 작거나 같은 데이터만 입력으로 주어진다.

출력
첫째 줄에 최소 스패닝 트리의 가중치를 출력한다.

*/
