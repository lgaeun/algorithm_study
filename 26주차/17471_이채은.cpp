#include <stdio.h>
#include <stdlib.h>
#include <vector>
#include <queue>

using namespace std;

int N, res = 1111;
int ppl[11];
bool check[11] = { false, };
vector<vector<int>> adj(11, vector<int>(11, 0));

void min() {
    int sum1 = 0, sum2 = 0;
    for (int i = 1; i <= N; i++) {
        if (check[i]) sum1 += ppl[i];
        else sum2 += ppl[i];
    }
    if (abs(sum1 - sum2) < res) res = abs(sum1 - sum2);
}

bool connection(bool f) {
    int start;
    bool visit[11] = { false, };
    for (int i = 1; i <= N; i++) {
        if (check[i] == f) {
            start = i; visit[start] = true; break;
        }
    }

    queue<int> q; q.push(start);
    while (!q.empty()) {
        int tmp = q.front(); q.pop();
        for (int i = 0; i < adj[tmp].size(); i++) {
            int num = adj[tmp][i];
            if (visit[num] == false && check[num] == f) {
                q.push(num);
                visit[num] = true;
            }
        }
    }

    for (int i = 1; i <= N; i++)
        if (check[i] == f && !visit[i]) return false;

    return true;
}

void group(int cnt, int start) {
    if (cnt > N + 1) return;

    for (int i = start; i <= N; i++) {
        check[i] = true;
        if (connection(true) && connection(false)) {
            min();
        }
        group(cnt + 1, i + 1);
        check[i] = false;
    }
}

int main() {
    scanf("%d", &N);
    for (int i = 1; i <= N; i++)
        scanf("%d", &ppl[i]);
    for (int i = 1; i <= N; i++) {
        int num; scanf("%d", &num);
        for (int j = 0; j < num; j++) {
            int c; scanf("%d", &c);
            adj[i].push_back(c);
        }
    }

    group(1, 1);
 
    printf("%d", (res == 1111) ? -1 : res);
}
