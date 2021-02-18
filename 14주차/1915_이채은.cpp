#include <stdio.h>

int n, m, max_size = 0;
int array[1000][1000];
int dp[1000][1000];

int min(int a, int b) {
    return (a > b) ? b : a;
}

int max(int a, int b) {
    return (a > b) ? a : b;
}

int main() {
    scanf("%d %d", &n, &m);
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            scanf("%1d", &array[i][j]);
            if (array[i][j] == 1) {
                dp[i][j] = 1;
                max_size = 1;
            }
        }
    }

    for (int i = 1; i < n; i++) {
        for (int j = 1; j < m; j++) {
            if (array[i-1][j] == 1 && array[i-1][j-1] == 1 && array[i][j-1] == 1) {
                dp[i][j] = min(dp[i - 1][j], dp[i - 1][j - 1]);
                dp[i][j] = min(dp[i][j], dp[i][j - 1]) + 1;
            }
            max_size = max(dp[i][j], max_size);
        }
    }

    printf("%d", max_size * max_size);
}
