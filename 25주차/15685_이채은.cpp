#include <stdio.h>
#include <vector>

using namespace std;

int ans = 0;
bool map[101][101];
int dy[] = { 0, -1, 0, 1 };
int dx[] = { 1, 0, -1, 0 };

void check() {
    for (int i = 0; i < 100; i++) {
        for (int j = 0; j < 100; j++) {
            if (map[i][j] == true && map[i + 1][j] == true && map[i][j + 1] == true && map[i + 1][j + 1] == true)
                ans++;
        }
    }
}

void curve(int x, int y, int d, int g) {
    vector<int> stk;
    map[y][x] = true;
    y += dy[d];  x += dx[d];
    map[y][x] = true;
    stk.push_back(d);
    for (int i = 0; i < g; i++) {
        int size = stk.size();
        for (int j = size - 1; j >= 0; j--) {
            int dir = (stk[j] + 1) % 4;
            y = y+ dy[dir];
            x = x+ dx[dir];
            map[y][x] = true;
            stk.push_back(dir);
        }
    }
}

int main() {
    int N;
    scanf("%d", &N);
    for (int i = 0; i < N; i++) {
        int x, y, d, g;
        scanf("%d%d%d%d", &x, &y, &d, &g);
        curve(x, y, d, g);
    }

    check();
    printf("%d", ans);
}
