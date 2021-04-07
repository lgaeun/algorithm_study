#include <stdio.h>

int N, cnt1 = 0, cnt2 = 0, cnt3 = 0;
int paper[2187][2187];

int check(int x, int y, int size) {
    int num = paper[x][y];
    for (int i = x; i < x + size; i++)
        for (int j = y; j < y + size; j++)
            if (paper[i][j] != num) return 0;
    return 1;
}

void divide(int x, int y, int size) {
    if (size == 1 || check(x, y, size) == 1) {
        switch (paper[x][y]) {
        case -1: cnt1++; break;
        case 0: cnt2++; break;
        case 1: cnt3++;
        }
        return;
    }
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            divide(x + i * size / 3, y + j * size / 3, size / 3);
        }
    }
}

int main() {
    scanf("%d", &N);
    for (int i = 0; i < N; i++)
        for (int j = 0; j < N; j++)
            scanf("%d", &paper[i][j]);

    divide(0, 0, N);
    printf("%d\n%d\n%d", cnt1, cnt2, cnt3);
}
