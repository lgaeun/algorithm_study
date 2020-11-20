#include<stdio.h>
#include<algorithm>

using namespace std;

typedef struct confer {
	int start;
	int end;
}confer;

confer conf[100001];

bool cmp(const confer &a, const confer &b) {
	if (a.end < b.end) return true;
	else if (a.end == b.end) {
		if (a.start < b.start) return true;
		else return false;
	}
	else return false;
}//끝나는 시간에 따라 정렬. 끝나는 시간이 같을 경우 시작 시간을 기준으로 정렬

int main() {
	int n, count = 1;//첫번째 회의는 반드시 포함되므로 1에서 시작
	scanf("%d", &n);
	for (int i = 0; i < n; i++)
		scanf("%d%d", &conf[i].start, &conf[i].end);
	sort(conf, conf + n, cmp);
	int end_time = conf[0].end;
	for (int i = 1; i < n; i++) {
		if (conf[i].start >= end_time) {
			count++;
			end_time = conf[i].end;
		}//이전 회의가 끝난 시간보다 시작시간이 같거나 크다면 회의 
	}
	printf("%d\n", count);
}


/*
1931. 회의실배정
https://www.acmicpc.net/problem/1931

문제
한 개의 회의실이 있는데 이를 사용하고자 하는 N개의 회의에 대하여 회의실 사용표를 만들려고 한다. 각 회의 I에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 회의의 최대 개수를 찾아보자. 단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다. 회의의 시작시간과 끝나는 시간이 같을 수도 있다. 이 경우에는 시작하자마자 끝나는 것으로 생각하면 된다.

입력
첫째 줄에 회의의 수 N(1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N+1 줄까지 각 회의의 정보가 주어지는데 이것은 공백을 사이에 두고 회의의 시작시간과 끝나는 시간이 주어진다. 시작 시간과 끝나는 시간은 231-1보다 작거나 같은 자연수 또는 0이다.

출력
첫째 줄에 최대 사용할 수 있는 회의의 최대 개수를 출력한다.

*/
