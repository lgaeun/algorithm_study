#include <stdio.h>
#include <stdlib.h>

using namespace std;

int N, max = 0;
int arr[8], tmp[8];
bool chk[8] = { false, };

void calc() {
    int val = 0;
    for (int i = 0; i < N - 1; i++)
        val += abs(tmp[i] - tmp[i + 1]);
    if (max < val) max = val;
}

void solve(int cnt) {
    if (cnt == N) {
        calc(); return;
    }
    for (int i = 0; i < N; i++) {
        if (chk[i] == true) continue;
        tmp[cnt] = arr[i];
        chk[i] = true;
        solve(cnt + 1);
        chk[i] = false;
    }
}

int main() {
    scanf("%d", &N);
    for (int i = 0; i < N; i++)
        scanf("%d", &arr[i]);

    solve(0);
    printf("%d", max);
}
