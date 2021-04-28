#include<stdio.h>
#include<queue>

using namespace std;

int n, w, L;
int truck[1001];
queue< pair<int,int> > onBridge;//트럭 idx, 몇번째 칸인지

int main() {
	scanf("%d%d%d", &n, &w, &L);

	for (int i = 0; i < n; i++) {
		scanf("%d", &truck[i]);
	}

	int nowWeight = 0;
	int cnt = 0;//다리를 건넌 트럭 수. 다음에 올라가야 하는 트럭의 idx
	int ans = 0;

	while (1) {
		ans++;
		if (!onBridge.empty()) {
			int size = onBridge.size();
			for (int i = 0; i < size; i++) {
				pair<int, int> trk = onBridge.front();
				onBridge.pop();
				if (trk.second + 1 == w) {
					nowWeight -= truck[trk.first];
				}
				else {
					onBridge.push({ trk.first,trk.second + 1 });
				}
			}
		}//다리 위의 트럭을 한칸씩 이동시켜줌. 만약 끝까지 도달했으면 내려줌

		if (nowWeight + truck[cnt] <= L && onBridge.size() < w && cnt < n) {
			nowWeight += truck[cnt];
			onBridge.push({ cnt,0 });
			cnt++;
		}//올릴 수 있을 경우
		if (cnt >= n && onBridge.empty()) break;//다리에 다 올라갔고, 큐에 들어간 트럭이 없는 경우
	}
	printf("%d\n", ans);
}


/*
13335. 트럭
https://www.acmicpc.net/problem/13335

문제
강을 가로지르는 하나의 차선으로 된 다리가 하나 있다. 이 다리를 n 개의 트럭이 건너가려고 한다. 트럭의 순서는 바꿀 수 없으며, 트럭의 무게는 서로 같지 않을 수 있다. 다리 위에는 단지 w 대의 트럭만 동시에 올라갈 수 있다. 다리의 길이는 w 단위길이(unit distance)이며, 각 트럭들은 하나의 단위시간(unit time)에 하나의 단위길이만큼만 이동할 수 있다고 가정한다. 동시에 다리 위에 올라가 있는 트럭들의 무게의 합은 다리의 최대하중인 L보다 작거나 같아야 한다. 참고로, 다리 위에 완전히 올라가지 못한 트럭의 무게는 다리 위의 트럭들의 무게의 합을 계산할 때 포함하지 않는다고 가정한다.

예를 들어, 다리의 길이 w는 2, 다리의 최대하중 L은 10, 다리를 건너려는 트럭이 트럭의 무게가 [7, 4, 5, 6]인 순서대로 다리를 오른쪽에서 왼쪽으로 건넌다고 하자. 이 경우 모든 트럭이 다리를 건너는 최단시간은 아래의 그림에서 보는 것과 같이 8 이다.



Figure 1. 본문의 예에 대해 트럭들이 다리를 건너는 과정.

다리의 길이와 다리의 최대하중, 그리고 다리를 건너려는 트럭들의 무게가 순서대로 주어졌을 때, 모든 트럭이 다리를 건너는 최단시간을 구하는 프로그램을 작성하라.

입력
입력 데이터는 표준입력을 사용한다. 입력은 두 줄로 이루어진다. 입력의 첫 번째 줄에는 세 개의 정수 n (1 ≤ n ≤ 1,000) , w (1 ≤ w ≤ 100) and L (10 ≤ L ≤ 1,000)이 주어지는데, n은 다리를 건너는 트럭의 수, w는 다리의 길이, 그리고 L은 다리의 최대하중을 나타낸다. 입력의 두 번째 줄에는 n개의 정수 a1, a2, ⋯ , an (1 ≤ ai ≤ 10)가 주어지는데, ai는 i번째 트럭의 무게를 나타낸다.

출력
출력은 표준출력을 사용한다. 모든 트럭들이 다리를 건너는 최단시간을 출력하라.
*/
