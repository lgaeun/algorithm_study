#include <stdio.h>
#include <queue>
#include <utility>

using namespace std;

int N, M, w = 0, b = 0;
int dx[] = { 1, -1, 0, 0 };
int dy[] = { 0, 0, 1, -1 };
char map[100][100];
bool visit[100][100] = { false, };

void bfs(int x, int y) {
    int cnt = 0;
    queue<pair<int, int>> q;
    q.push({ x, y }); visit[x][y] = true;
    while (!q.empty()) {
        pair<int, int> p = q.front(); q.pop(); cnt++;
        for (int i = 0; i < 4; i++) {
            int nx = p.first + dx[i];
            int ny = p.second + dy[i];
            if (nx >= 0 && nx < M && ny >= 0 && ny < N && !visit[nx][ny] && map[nx][ny] == map[p.first][p.second]) {
                q.push({ nx, ny }); visit[nx][ny] = true;
            }
        }
    }

    if (map[x][y] == 'W') w += cnt * cnt;
    else b += cnt * cnt;
}

int main() {
    scanf("%d%d", &N, &M);
    for (int i = 0; i < M; i++)
        for (int j = 0; j < N; j++)
            scanf(" %c", &map[i][j]);

    for (int i = 0; i < M; i++)
        for (int j = 0; j < N; j++)
            if (visit[i][j] == false) bfs(i, j);

    printf("%d %d", w, b);
}
