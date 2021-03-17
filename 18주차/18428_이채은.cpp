#include <stdio.h>

typedef struct point {
    int x, y;
} point;

int N, T = 0, X = 0;
bool ans = false;
char map[6][6];
int dx[4] = { 0, 0, 1, -1 };
int dy[4] = { 1, -1, 0, 0 };
point teacher[5], nth[36];

void check() {
    for (int j = 0; j < T; j++) {
        point tc = teacher[j];
        for (int i = 0; i < 4; i++) {
            int xi = tc.x;
            int yi = tc.y;
            while (true) {
                xi += dx[i]; yi += dy[i];
                if (xi < 0 || yi < 0 || xi >= N || yi >= N || map[xi][yi] == 'O') {
                    break;
                }
                else if (map[xi][yi] == 'S') {
                    return;
                }
            }
        }
    }

    ans = true;
}

void checking() {
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            printf("%c ", map[i][j]);
        }
        printf("\n");
    }
    printf("\n");
}

void obstacle(int idx, int num) {
    if (num == 3) {
        check();
        checking();
        return;
    }

    for (int i = idx; i < X; i++) {
        point tmp = nth[idx];
        if (map[tmp.x][tmp.y] == 'X') {
            map[tmp.x][tmp.y] = 'O';
            printf("%d %d %c\n", tmp.x, tmp.y, map[tmp.x][tmp.y]);
            obstacle(i + 1, num + 1);
            map[tmp.x][tmp.y] = 'X';
        }
    }
}

int main() {
    scanf("%d", &N);
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            scanf(" %c", &map[i][j]);
            if (map[i][j] == 'T') {
                point tc;
                tc.x = i; tc.y = j;
                teacher[T] = tc;
                T++;
            }
            else if (map[i][j] == 'X') {
                point pt;
                pt.x = i; pt.y = j;
                nth[X] = pt;
                X++;
            }
        }
    }

    for(int i=0; i<X; i++)
        obstacle(i, 1);

    if (ans == true) printf("YES");
    else printf("NO");
}
