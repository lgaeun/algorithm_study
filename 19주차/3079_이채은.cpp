#include <stdio.h>

long long time[1000001];

int main() {
    int N, M;
    long long max = 0;
    scanf("%d %d", &N, &M);

    for (int i = 0; i < N; i++) {
        scanf("%lld", &time[i]);
        if (max < time[i])
            max = time[i];
    }

    long long l = 1, r = max * M;
    long long res = max * M;
    while (l <= r) {
        long long mid = (l + r) / 2;
        long long sum = 0;
        for (int i = 0; i < N; i++)
            sum += mid / time[i];

        if (sum < M) {
            l = mid + 1;
        }
        else {
            if (res > mid) res = mid;
            r = mid - 1;
        }
    }
    printf("%lld\n", res);
}
