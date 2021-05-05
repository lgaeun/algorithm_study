#include <stdio.h>

int D, K;
int fibonacci[30] = { 1, 1, 0, };

void set() {
    for (int i = 2; i < 30; i++)
        fibonacci[i] = fibonacci[i - 2] + fibonacci[i - 1];
}

void solve(int D, int K) {
    int x = fibonacci[D - 2], y = fibonacci[D - 3];
    for (int i = 1; i < K / y; i++) {
        if ((K - y * i) % x == 0) {
            int ans = (K - y * i) / x;
            printf("%d\n%d", i, ans);
            return;
        }
    }
}

int main() {
    int D, K;
    scanf("%d %d", &D, &K);
    set();
    solve(D, K);
}
