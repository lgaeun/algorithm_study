#include <stdio.h>
#include <stdbool.h>
#include <queue>
#include <utility>

using namespace std;

int N, L, R, cnt = 0, flag = 1;
int map[50][50];
int dx[] = { 0, 0, 1, -1 };
int dy[] = { 1, -1, 0, 0 };

int abs(int num) {
    return (num > 0) ? num : 0-num;
}

void move() {
    queue<pair<int, int>> q;
    bool check[50][50] = { false, };
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            if (check[i][j] == true) continue;
            queue<pair<int, int>> inc;
            q.push(pair<int, int>(i, j));
            check[i][j] = true;
            inc.push(pair<int, int>(i, j));
            int sum = map[i][j], c = 1;
            while (q.empty() != true) {
                pair<int, int> p = q.front();
                q.pop();
                for (int k = 0; k < 4; k++) {
                    int nx = p.first + dx[k];
                    int ny = p.second + dy[k];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < N && check[nx][ny] == false) {
                        int nxt = map[nx][ny];
                        int fst = map[i][j];
                        if (L <= abs(nxt - fst) && R >= abs(nxt - fst)) {
                            flag = true;
                            q.push(pair<int, int>(nx, ny));
                            check[nx][ny] = true;
                            inc.push(pair<int, int>(nx, ny));
                            sum += map[nx][ny];
                            c++;
                        }
                    }
                }
            }
            int ppl = sum / c;
            if (inc.size() > 1) {
                cnt++;
                for (int i = 0; i < c; i++) {
                    pair<int, int> tmp = inc.front();
                    inc.pop();
                    map[tmp.first][tmp.second] = ppl;
                }
            }
            else flag = 0;
        }
    }
}

void printing() {
    printf("\n");
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            printf("%d ", map[i][j]);
        }
        printf("\n");
    }
    printf("\n");
}

int main() {
    scanf("%d %d %d", &N, &L, &R);
    for (int i = 0; i < N; i++)
        for (int j = 0; j < N; j++)
            scanf("%d", &map[i][j]);

    while (flag == 1) {
        printing();
        move();
    }
    printf("%d", cnt);
}
