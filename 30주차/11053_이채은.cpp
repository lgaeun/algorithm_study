#include <stdio.h>

int N, ans = 0;
int A[1000], dp[1000] = { 0, };

int main() {
    scanf("%d", &N);
    for (int i = 0; i < N; i++)
        scanf("%d", &A[i]);

    for (int i = 0; i < N; i++) {
        int tmp = 0;
        for (int j = 0; j < i; j++) {
            if (A[i] > A[j]) {
                tmp = (tmp > dp[j]) ? tmp : dp[j];
            }
        }
        dp[i] = tmp + 1;
        ans = (ans > dp[i]) ? ans : dp[i];
    }
    printf("%d", ans);
}
