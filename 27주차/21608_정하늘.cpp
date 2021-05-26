#include<stdio.h>
#include<vector>
#include<algorithm>
#include<queue>
#include<string.h>

using namespace std;

int dx[4] = { 0,0,1,-1 };
int dy[4] = { 1,-1,0,0 };

int map[21][21];
int likemap[21][21];
vector< pair<int, int> > candSeat;
int like[401][4];//좋아하는 학생 정보

int n;

int getMax(int x, int y) {
	return x >= y ? x : y;
}

void findMaxEmpty(int stuNum) {
	sort(candSeat.begin(), candSeat.end());//행, 열 순으로 정렬
	vector<int> empty;
	int max = 0;
	int size = candSeat.size();
	for (int i = 0; i < size; i++) {
		int cnt = 0;
		for (int j = 0; j < 4; j++) {
			int nx = candSeat[i].first + dx[j];
			int ny = candSeat[i].second + dy[j];
			if (nx > 0 && nx <= n && ny > 0 && ny <= n && map[nx][ny] == 0) cnt++;
		}
		max = getMax(max, cnt);
		empty.push_back(cnt);
	}

	for (int i = 0; i < empty.size(); i++) {
		if (empty[i] == max) {
			map[candSeat[i].first][candSeat[i].second] = stuNum;
			return;
		}
	}
}


void findMaxLike(int stuNum) {
	int max = 0;
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			for (int k = 0; k < 4; k++) {
				if (map[i][j] != like[stuNum][k]) continue;
				for (int p = 0; p < 4; p++) {
					int nx = i + dx[p];
					int ny = j + dy[p];
					if (nx > 0 && nx <= n && ny > 0 && ny <= n && map[nx][ny] == 0) {
						likemap[nx][ny]++;
					}
				}
			}
		}
	}

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			max = getMax(max, likemap[i][j]);
		}
	}

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			if (max == likemap[i][j] && map[i][j] == 0) candSeat.push_back({ i,j });
		}
	}
}

int getSatisfied() {
	int score = 0;
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			int cnt = 0;
			for (int k = 0; k < 4; k++) {
				int nx = i + dx[k];
				int ny = j + dy[k];
				for (int p = 0; p < 4; p++) {
					if (map[nx][ny] == like[map[i][j]][p]) cnt++;
				}
			}
			if (cnt == 0) score += 0;
			else if (cnt == 1) score += 1;
			else if (cnt == 2) score += 10;
			else if (cnt == 3) score += 100;
			else score += 1000;
		}
	}
	return score;
}

int main() {
	scanf("%d", &n);


	for (int i = 0; i < n*n; i++) {
		//초기화
		memset(likemap, 0, sizeof(likemap));
		candSeat.clear();

		int st;
		scanf("%d", &st);
		for (int i = 0; i < 4; i++) {
			scanf("%d", &like[st][i]);
		}
		findMaxLike(st);
		findMaxEmpty(st);
	}
	printf("%d\n", getSatisfied());
}


/*
21608. 상어 초등학교
https://www.acmicpc.net/problem/21608

문제
상어 초등학교에는 교실이 하나 있고, 교실은 N×N 크기의 격자로 나타낼 수 있다. 학교에 다니는 학생의 수는 N2명이다. 오늘은 모든 학생의 자리를 정하는 날이다. 학생은 1번부터 N2번까지 번호가 매겨져 있고, (r, c)는 r행 c열을 의미한다. 교실의 가장 왼쪽 윗 칸은 (1, 1)이고, 가장 오른쪽 아랫 칸은 (N, N)이다.

선생님은 학생의 순서를 정했고, 각 학생이 좋아하는 학생 4명도 모두 조사했다. 이제 다음과 같은 규칙을 이용해 정해진 순서대로 학생의 자리를 정하려고 한다. 한 칸에는 학생 한 명의 자리만 있을 수 있고, |r1 - r2| + |c1 - c2| = 1을 만족하는 두 칸이 (r1, c1)과 (r2, c2)를 인접하다고 한다.

비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정한다.
1을 만족하는 칸이 여러 개이면, 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로 자리를 정한다.
2를 만족하는 칸도 여러 개인 경우에는 행의 번호가 가장 작은 칸으로, 그러한 칸도 여러 개이면 열의 번호가 가장 작은 칸으로 자리를 정한다.
예를 들어, N = 3이고, 학생 N2명의 순서와 각 학생이 좋아하는 학생이 다음과 같은 경우를 생각해보자.

학생의 번호	좋아하는 학생의 번호
4	2, 5, 1, 7
3	1, 9, 4, 5
9	8, 1, 2, 3
8	1, 9, 3, 4
7	2, 3, 4, 8
1	9, 2, 5, 7
6	5, 2, 3, 4
5	1, 9, 2, 8
2	9, 3, 1, 4
가장 먼저, 4번 학생의 자리를 정해야 한다. 현재 교실의 모든 칸은 빈 칸이다. 2번 조건에 의해 인접한 칸 중에서 비어있는 칸이 가장 많은 칸인 (2, 2)이 4번 학생의 자리가 된다.

 	 	 
 	4	 
 	 	 
다음 학생은 3번이다. 1번 조건을 만족하는 칸은 (1, 2), (2, 1), (2, 3), (3, 2) 이다. 이 칸은 모두 비어있는 인접한 칸이 2개이다. 따라서, 3번 조건에 의해 (1, 2)가 3번 학생의 자리가 된다.

 	3	 
 	4	 
 	 	 
다음은 9번 학생이다. 9번 학생이 좋아하는 학생의 번호는 8, 1, 2, 3이고, 이 중에 3은 자리에 앉아있다. 좋아하는 학생이 가장 많이 인접한 칸은 (1, 1), (1, 3)이다. 두 칸 모두 비어있는 인접한 칸이 1개이고, 행의 번호도 1이다. 따라서, 3번 조건에 의해 (1, 1)이 9번 학생의 자리가 된다.

9	3	 
 	4	 
 	 	 
이번에 자리를 정할 학생은 8번 학생이다. (2, 1)이 8번 학생이 좋아하는 학생과 가장 많이 인접한 칸이기 때문에, 여기가 그 학생의 자리이다.

9	3	 
8	4	 
 	 	 
7번 학생의 자리를 정해보자. 1번 조건을 만족하는 칸은 (1, 3), (2, 3), (3, 1), (3, 2)로 총 4개가 있고, 비어있는 칸과 가장 많이 인접한 칸은 (2, 3), (3, 2)이다. 행의 번호가 작은 (2, 3)이 7번 학생의 자리가 된다.

9	3	 
8	4	7
 	 	 
이런식으로 학생의 자리를 모두 정하면 다음과 같다.

9	3	2
8	4	7
5	6	1
이제 학생의 만족도를 구해야 한다. 학생의 만족도는 자리 배치가 모두 끝난 후에 구할 수 있다. 학생의 만족도를 구하려면 그 학생과 인접한 칸에 앉은 좋아하는 학생의 수를 구해야 한다. 그 값이 0이면 학생의 만족도는 0, 1이면 1, 2이면 10, 3이면 100, 4이면 1000이다.

학생의 만족도의 총 합을 구해보자.

입력
첫째 줄에 N이 주어진다. 둘째 줄부터 N2개의 줄에 학생의 번호와 그 학생이 좋아하는 학생 4명의 번호가 한 줄에 하나씩 선생님이 자리를 정할 순서대로 주어진다.

학생의 번호는 중복되지 않으며, 어떤 학생이 좋아하는 학생 4명은 모두 다른 학생으로 이루어져 있다. 입력으로 주어지는 학생의 번호, 좋아하는 학생의 번호는 N2보다 작거나 같은 자연수이다. 어떤 학생이 자기 자신을 좋아하는 경우는 없다.

출력
첫째 줄에 학생의 만족도의 총 합을 출력한다.
*/