#include <stdio.h>
#include <stdbool.h>
#include <algorithm>
#include <vector>
#include <utility>

using namespace std;

int N, K, L, ans = 0;
int map[101][101];
int dx[] = { 0, 1, 0, -1};
int dy[] = { 1, 0, -1, 0};
vector<pair<int, int>> snake;
vector<pair<int, char>> dir;

void simul() {
    int d = 0;
    snake.push_back(pair<int, int>(1, 1));
    map[1][1] = 2;
    while (true) {
        ans++;
        pair<int, int> p = snake[snake.size()-1];
        int nx = p.first + dx[d];
        int ny = p.second + dy[d];
        if (map[nx][ny] == 2 || nx<1 || nx>N || ny<1 || ny>N) return;
        if (map[nx][ny] == 0) {
            map[snake.begin()->first][snake.begin()->second] = 0;
            snake.erase(snake.begin());
        }
        map[nx][ny] = 2;
        snake.push_back(pair<int, int>(nx, ny));
        if (!dir.empty() && dir[0].first == ans) {
            switch (dir[0].second) {
            case 'D':
                d = (d + 1) % 4;
                break;
            case 'L':
                if (d == 0)
                    d = 3;
                else d--;
            }
            dir.erase(dir.begin());
        }
    }
}

int main() {
    scanf("%d%d", &N, &K);
    for (int i = 0; i < K; i++) {
        int r, c;
        scanf("%d %d", &r, &c);
        map[r][c] = 1;
    }
    scanf("%d", &L);
    for (int i = 0; i < L; i++) {
        int time; char d;
        scanf("%d %c", &time, &d);
        dir.push_back(pair<int, char>(time, d));
    }
    sort(dir.begin(), dir.end());
    simul();
    printf("%d", ans);
}
