#include <stdio.h>
#include <stdbool.h>

int N, d, k, c;
int arr[30000];

int main() {
    scanf("%d%d%d%d", &N, &d, &k, &c);
    for (int i = 0; i < N; i++)
        scanf("%d", &arr[i]);

    int max = 0;
    for (int i = 0; i < N; i++) {
        bool sushi[3001] = { false, };
        int cur = k + 1;
        for (int j = i; j < i + k; j++) {
            int num = arr[j % N];
            if (sushi[num] == true) {
                cur--; continue;
            }
            sushi[num] = true;
            if (num == c) cur--;
        }
        if (cur > max) max = cur;
    }
    printf("%d", max);
}
