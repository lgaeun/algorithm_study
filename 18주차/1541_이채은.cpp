#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main() {
    char str[50];
    int size, pre = 0, ans = 0, flag = 0;
    scanf("%s", str);
    size = strlen(str);
    for (int i = 0; i < size; i++) {
        if (str[i] == '+') {
            if (flag == 0)
                ans += pre;
            else
                ans -= pre;

            pre = 0;
        }
        else if (str[i] == '-') {
            if (flag == 0) ans += pre;
            else ans -= pre;
            pre = 0;
            flag = 1;
        }
        else {
            pre = pre * 10 + str[i] - '0';
        }
    }

    if (flag == 0) ans += pre;
    else ans -= pre;
    printf("%d", ans);
}
