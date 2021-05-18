#include <stdio.h>
#include <stdlib.h>
#include <vector>
#include <queue>

using namespace std;

int N, M;
int map[201][201];
int group[201] = { 0, };

void check() {
	int cnt = 0;
	bool visit[201] = { false, };
	for (int i = 1; i < N + 1; i++) {
		if (visit[i]) continue;
		visit[i] = true;
		group[i] = ++cnt;
		queue<int> q;
		q.push(i);
		while (!q.empty()) {
			int tmp = q.front(); q.pop();
			for (int j = 1; j < N + 1; j++) {
				if (!visit[j] && map[tmp][j] == 1) {
					visit[j] = true;
					q.push(j);
					group[j] = cnt;
				}
			}
		}
	}
}

int main() {
	scanf("%d%d", &N, &M);
	for (int i = 1; i < N + 1; i++) {
		for (int j = 1; j < N + 1; j++) {
			scanf("%d", &map[i][j]);
		}
	}
	check();
	int pre, cur, link;
	scanf("%d", &pre);
	link = group[pre];
	if (link == 0) {
		printf("NO");
		exit(0);
	}
	for (int i = 0; i < M - 1; i++) {
		scanf("%d", &cur);
		pre = cur;
		if (group[cur] != link) {
			printf("NO");
			exit(0);
		}
	}
	printf("YES");
}
