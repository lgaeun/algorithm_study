#include<stdio.h>

int n, m;
char str[1000001] = "";

int main() {
	scanf("%d%d", &n, &m);
	scanf(" %s", str);
	int ans = 0;
	for (int i = 0; i < m; i++) {
		int cnt = 0;
		if (str[i] == 'O');
		else {
			while (1) {
				if (str[i + 1] == 'O' && str[i + 2] == 'I') {
					cnt++;
					i += 2;
				}
				else {
					break;
				}
			}//OI가 반복되는 개수를 셈
			if (cnt >= n) {
				ans += cnt - n + 1;
			}//ex) OIOIOI인 경우, n이 1일 때 cnt=3이고 3-1+1개만큼 IOI가 있음 
		}//I로 시작하는 경우
	}
	printf("%d\n", ans);
}

/*
5525. IOIOI
https://www.acmicpc.net/problem/5525



*/
