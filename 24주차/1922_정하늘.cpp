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
1922. 네트워크 연결
https://www.acmicpc.net/problem/1922

문제
도현이는 컴퓨터와 컴퓨터를 모두 연결하는 네트워크를 구축하려 한다. 하지만 아쉽게도 허브가 있지 않아 컴퓨터와 컴퓨터를 직접 연결하여야 한다. 그런데 모두가 자료를 공유하기 위해서는 모든 컴퓨터가 연결이 되어 있어야 한다. (a와 b가 연결이 되어 있다는 말은 a에서 b로의 경로가 존재한다는 것을 의미한다. a에서 b를 연결하는 선이 있고, b와 c를 연결하는 선이 있으면 a와 c는 연결이 되어 있다.)

그런데 이왕이면 컴퓨터를 연결하는 비용을 최소로 하여야 컴퓨터를 연결하는 비용 외에 다른 곳에 돈을 더 쓸 수 있을 것이다. 이제 각 컴퓨터를 연결하는데 필요한 비용이 주어졌을 때 모든 컴퓨터를 연결하는데 필요한 최소비용을 출력하라. 모든 컴퓨터를 연결할 수 없는 경우는 없다.

입력
첫째 줄에 컴퓨터의 수 N (1 ≤ N ≤ 1000)가 주어진다.

둘째 줄에는 연결할 수 있는 선의 수 M (1 ≤ M ≤ 100,000)가 주어진다.

셋째 줄부터 M+2번째 줄까지 총 M개의 줄에 각 컴퓨터를 연결하는데 드는 비용이 주어진다. 이 비용의 정보는 세 개의 정수로 주어지는데, 만약에 a b c 가 주어져 있다고 하면 a컴퓨터와 b컴퓨터를 연결하는데 비용이 c (1 ≤ c ≤ 10,000) 만큼 든다는 것을 의미한다. a와 b는 같을 수도 있다.

출력
모든 컴퓨터를 연결하는데 필요한 최소비용을 첫째 줄에 출력한다.
*/