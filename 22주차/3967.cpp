#include<stdio.h>
#include<vector>
#include<stdlib.h>

using namespace std;


int cnt = 0;//맞춰야 하는 수의 개수
int given[12];
char MagicStar[5][9];
vector<pair <int, int> > num;


int check() {
	if ((MagicStar[0][4] - 'A' + 1) + (MagicStar[1][3] - 'A' + 1) + (MagicStar[2][2] - 'A' + 1) + (MagicStar[3][1] - 'A' + 1) != 26) return 0;
	if ((MagicStar[0][4] - 'A' + 1) + (MagicStar[1][5] - 'A' + 1) + (MagicStar[2][6] - 'A' + 1) + (MagicStar[3][7] - 'A' + 1) != 26) return 0;
	if ((MagicStar[1][1] - 'A' + 1) + (MagicStar[1][3] - 'A' + 1) + (MagicStar[1][5] - 'A' + 1) + (MagicStar[1][7] - 'A' + 1) != 26) return 0;
	if ((MagicStar[3][1] - 'A' + 1) + (MagicStar[3][3] - 'A' + 1) + (MagicStar[3][5] - 'A' + 1) + (MagicStar[3][7] - 'A' + 1) != 26) return 0;
	if ((MagicStar[4][4] - 'A' + 1) + (MagicStar[3][3] - 'A' + 1) + (MagicStar[2][2] - 'A' + 1) + (MagicStar[1][1] - 'A' + 1) != 26) return 0;
	if ((MagicStar[4][4] - 'A' + 1) + (MagicStar[3][5] - 'A' + 1) + (MagicStar[2][6] - 'A' + 1) + (MagicStar[1][7] - 'A' + 1) != 26) return 0;

	return 1;
}

void DFS(int idx, int depth) {
	if (depth == cnt) {
		if (check()) {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 9; j++) {
					printf("%c", MagicStar[i][j]);
				}
				printf("\n");
			}
			exit(0);
		}
		return;
	}
	
	for (int i = 0; i < 12; i++) {
		if (!given[i]) {
			given[i] = 1;
			MagicStar[num[idx].first][num[idx].second] = i + 'A';
			DFS(idx + 1, depth + 1);
			MagicStar[num[idx].first][num[idx].second] = 'x';
			given[i] = 0;
		}
	}
}

int main() {
	for (int i = 0; i < 5; i++) {
		for (int j = 0; j < 9; j++) {
			scanf(" %c", &MagicStar[i][j]);
			if ('A' <= MagicStar[i][j] && MagicStar[i][j] <= 'L') {
				given[MagicStar[i][j] - 'A'] = 1;
			}
			else if (MagicStar[i][j] == 'x') {
				num.push_back({ i, j });//채워넣어야 하는 수의 위치
				cnt++;
			}
		}
	}

	DFS(0, 0);
}



/*
3967. 매직 스타
https://www.acmicpc.net/problem/3967

문제
매직 스타는 1부터 12까지 숫자가 헥사그램(hexagram)에 채워져 있는 모양으로 이루어져 있다.



매직 스타의 이름에 매직이 들어가는 이유는 숫자 네 개로 이루어진 줄의 숫자를 모두 합하면 26이 되기 때문이다. 위의 그림의 여섯 줄에 쓰여 있는 숫자는 다음과 같다.

1 + 4 + 10 + 11
11 + 5 + 3 + 7
7 + 6 + 12 + 1
2 + 10 + 5 + 9
9 + 3 + 6 + 8
8 + 12 + 4 + 2
매직 스타를 채우는 방법은 여러 가지가 있다. 일부만 채워진 매직 스타가 주어졌을 때, 수를 전부 다 채워서 매직 스타를 만드는 프로그램을 작성하시오.

입력
매직 스타의 모양이 주어진다. 수가 채워져 있지 않은 곳은 x로, 채워져 있는 곳은 'A'부터 'L'까지 알파벳으로 채워져 있다. i번째 알파벳은 숫자 i를 의미한다. '.'는 매직 스타의 형태를 만들기 위해서 사용하는 문자이다. 모든 입력은 예제 입력과 같은 형태로 주어진다.

출력
매직 스타를 만들 수 있는 방법 중에 사전 순으로 가장 앞서는 방법을 출력한다. (모든 줄을 순서대로 붙여서 하나의 문자열로 만든 뒤, 사전 순으로 비교한다.) 항상 정답이 존재하는 경우만 입력으로 주어진다.

*/