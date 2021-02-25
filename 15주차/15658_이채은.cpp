#include <stdio.h>

int N;
int Arr[100] = {0, };
int max = -1000000000, min = 1000000000;

void calc(int num, int p, int m, int mul, int d, int cnt) {
    if (cnt == N) {
        if (num < min) min = num;
        if (num > max) max = num;
        return;
    }

    if (p != 0)
        calc(num + Arr[cnt], p - 1, m, mul, d, cnt + 1);
    if (m != 0)
        calc(num - Arr[cnt], p, m - 1, mul, d, cnt + 1);
    if (mul != 0)
        calc(num * Arr[cnt], p, m, mul - 1, d, cnt + 1);
    if (d != 0)
        calc(num / Arr[cnt], p, m, mul, d - 1, cnt + 1);
}

int main() {
    int oper[4] = {0, };
    scanf("%d", &N);
    for (int i = 0; i < N; i++)
        scanf("%d", &Arr[i]);
    scanf("%d %d %d %d", &oper[0], &oper[1], &oper[2], &oper[3]);

    calc(Arr[0], oper[0], oper[1], oper[2], oper[3], 1);
    printf("%d\n%d", max, min);
}
