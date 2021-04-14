#include <stdio.h>
#include <queue>

using namespace std;

int gear[4][8];
int p[4] = { 0, };
int rotation[2] = { 1, -1 };

int move(int num, int dir) {
    switch (num) {
    case 1:
        if (dir == -1) p[0] = (p[0] + 7) % 8;
        else p[0] = (p[0] + 1) % 8;
        break;
    case 2:
        if (dir == -1) p[1] = (p[1] + 7) % 8;
        else p[1] = (p[1] + 1) % 8;
        break;
    case 3:
        if (dir == -1) p[2] = (p[2] + 7) % 8;
        else p[2] = (p[2] + 1) % 8;
        break;
    case 4:
        if (dir == -1) p[3] = (p[3] + 7) % 8;
        else p[3] = (p[3] + 1) % 8;
        break;
    }
}

int score() {
    int sum = 0;
    if (gear[0][p[0]] == 1) sum += 1;
    if (gear[1][p[1]] == 1) sum += 2;
    if (gear[2][p[2]] == 1) sum += 4;
    if (gear[3][p[3]] == 1) sum += 8;
    return sum;
}

int main() {
    int K;
    for (int i = 0; i < 4; i++)
        for (int j = 0; j < 8; j++)
            scanf("%1d", &gear[i][j]);

    scanf("%d", &K);
    for (int i = 0; i < K; i++) {
        int num, dir;
        int chk[4] = { 0, };
        scanf("%d%d", &num, &dir);
        chk[num - 1] = dir;
        queue<pair<int, int>> q;
        q.push(pair<int, int>(num, dir));

        while (!q.empty()) {
            pair <int, int> pair = q.front();
            q.pop();
            for (int j = 0; j < 2; j++) {
                int n = rotation[j] + pair.first;
                if (n >= 0 && n < 4 && chk[n] == 0) {
                    int s = (n > pair.first) ? pair.first : n;
                    int b = (n > pair.first) ? n : pair.first;
                    if (gear[s - 1][2] == gear[b - 1][6]) continue;
                    chk[]
                }
            }
        }
        for (int j = 0; j < 4; j++) {
            if (chk[j] != 0)
                move(j + 1, chk[j]);
        }
    }

    printf("%d", score());
}
