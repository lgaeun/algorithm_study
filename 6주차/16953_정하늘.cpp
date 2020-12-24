#include<stdio.h>

long long n, target;
long long ans = 9999999;

typedef struct oper {
	long long num;
	long long idx;
}oper;

oper queue[100001];//10001로 했다가 런타임 에러 났음
int front = 0;
int rear = 0;

void insert(long long x, long long idx) {
	queue[rear].num = x;
	queue[rear].idx = idx;
	rear++;
}

oper pop() {
	oper pop;
	pop.idx = queue[front].idx;
	pop.num = queue[front].num;
	front++;
	return pop;
}

void BFS(int start) {
	insert(start, 0);
	while (front < rear) {
		oper q = pop();
		if (q.num == target) {
			if (q.idx < ans) {
				ans = q.idx;
			}
		}
		else {
			if (q.num * 2 <= target) {
				insert(q.num * 2, q.idx + 1);
			}//원래 수에 *2한 수를 queue에 insert
			if (q.num * 10 + 1 <= target) {
				insert(q.num * 10 + 1, q.idx + 1);
			}//원래 수의 뒤에 1을 붙인 수를 queue에 insert
		}
	}
	if (ans == 9999999) ans = -2;
}

int main() {
	scanf("%lld%lld", &n, &target);
	BFS(n);
	printf("%lld\n", ans+1);
}


/*
16953. A → B
https://www.acmicpc.net/problem/16953
 
문제
정수 A를 B로 바꾸려고 한다. 가능한 연산은 다음과 같은 두 가지이다.

2를 곱한다.
1을 수의 가장 오른쪽에 추가한다. 
A를 B로 바꾸는데 필요한 연산의 최솟값을 구해보자.

입력
첫째 줄에 A, B (1 ≤ A < B ≤ 109)가 주어진다.

출력
A를 B로 바꾸는데 필요한 연산의 최솟값에 1을 더한 값을 출력한다. 만들 수 없는 경우에는 -1을 출력한다.
*/
