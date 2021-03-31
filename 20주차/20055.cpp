#include<stdio.h>
#include<queue>

using namespace std;

int n, k;
int dur[202];//내구도
int robot[202] = { 0, };//로봇 유무
int on, off;//올라가는, 내려가는 위치의 idx
queue<int> belt;


int main() {
	scanf("%d%d", &n, &k);
	for (int i = 1; i <= 2 * n; i++) {
		scanf("%d", &dur[i]);
	}
	on = 1, off = n;
	int ans = 0;
	
	int cnt = 0;
	while (cnt < k) {
		ans++;

		on--;
		off--;
		if (on < 1) on = 2 * n;
		if (off < 1) off = 2 * n;
		//1. 벨트 회전

		int size = belt.size();
		for (int i = 0; i < size; i++) {
			int now = belt.front();
			belt.pop();
			robot[now] = false;

			if (now == off) continue;

			int next = now + 1;
			if (next > 2 * n) next = 1;

			if (dur[next] >= 1 && !robot[next]) {
				dur[next]--;
				if (dur[next] == 0) cnt++;//내구도가 0이면 k감소
				if (next == off) continue;//내려가는 위치인 경우 내려가기 때문에 로봇 없어짐
				robot[next] = true;
				belt.push(next);
			}//다음 위치에 <내구도 1 이상, 로봇이 없을 경우> 로봇 이동
			else {
				robot[now] = true;
				belt.push(now);
			}//이동할 수 없는 경우
		}
		//2. 로봇 이동

		if (!robot[on] && dur[on] >= 1) {
			robot[on] = true;
			dur[on]--;
			belt.push(on);

			if (dur[on] == 0) cnt++;
		}
		//3. 시작 지점에 로봇 올리기
	}
	printf("%d\n", ans);
}

/*
20055. 컨베이어 벨트 위의 로봇
https://www.acmicpc.net/problem/20055

문제
길이가 N인 컨베이어 벨트가 있고, 길이가 2N인 벨트가 이 컨베이어 벨트를 위아래로 감싸며 돌고 있다. 벨트는 길이 1 간격으로 2N개의 칸으로 나뉘어져 있으며, 각 칸에는 아래 그림과 같이 1부터 2N까지의 번호가 매겨져 있다.



벨트가 한 칸 회전하면 1번부터 2N-1번까지의 칸은 다음 번호의 칸이 있는 위치로 이동하고, 2N번 칸은 1번 칸의 위치로 이동한다. i번 칸의 내구도는 Ai이다. 위의 그림에서 1번 칸이 있는 위치를 "올라가는 위치", N번 칸이 있는 위치를 "내려가는 위치"라고 한다.

컨베이어 벨트에 박스 모양 로봇을 하나씩 올리려고 한다. 로봇은 올라가는 위치에만 땅에서 올라가고, 내려가는 위치에서만 땅으로 내려갈 수 있다. 내려가는 위치에 로봇이 있는 경우 로봇은 반드시 땅으로 내려가야 한다. 로봇이 어떤 칸에 올라가거나 이동하면 그 칸의 내구도는 즉시 1만큼 감소한다. 내구도가 0인 칸에는 로봇이 올라갈 수 없다.

로봇은 컨베이어 벨트 위에서 스스로 이동할 수 있다.

컨베이어 벨트를 이용해 로봇들을 건너편으로 옮기려고 한다. 로봇을 옮기는 과정에서는 아래와 같은 일이 순서대로 일어난다.

벨트가 한 칸 회전한다.
가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다. 만약 이동할 수 없다면 가만히 있는다.
로봇이 이동하기 위해서는 이동하려는 칸에 로봇이 없으며, 그 칸의 내구도가 1 이상 남아 있어야 한다.
올라가는 위치에 로봇이 없다면 로봇을 하나 올린다.
내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료한다. 그렇지 않다면 1번으로 돌아간다.
종료되었을 때 몇 번째 단계가 진행 중이었는지 구해보자. 가장 처음 수행되는 단계는 1번째 단계이다.

입력
첫째 줄에 N, K가 주어진다. 둘째 줄에는 A1, A2, ..., A2N이 주어진다.

출력
몇 번째 단계가 진행 중일때 종료되었는지 출력한다.

cnt로 개수를 세면 시간초과 x, k--로 k 개수를 감소시키면 시간초과
*/                      