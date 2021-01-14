#include<stdio.h>

typedef struct Heap {
	int heap[100010];
	int size;
}Heap;

int n;
Heap heap;

void insert(int x) {
	heap.size++;
	int idx = heap.size;

	while ((idx != 1) && (x < heap.heap[idx / 2])) {
		heap.heap[idx] = heap.heap[idx / 2];
		idx /= 2;
	}//아래에서부터 자신보다 작은 것이 나올 때의 idx를 찾음
	heap.heap[idx] = x;
}

void delete_() {
	int q = heap.heap[1];//root
	int last = heap.heap[heap.size--];//마지막 노드
	int parent = 1;
	int child = 2;
	while (child <= heap.size) {
		if ((child < heap.size) && (heap.heap[child] > heap.heap[child + 1])) child++;
		if (last <= heap.heap[child]) break;
		else {
			heap.heap[parent] = heap.heap[child];
			parent = child;
			child *= 2;
		}
	}
	heap.heap[parent] = last;
	printf("%d\n", q);
}


int main() {

	heap.size = 0;

	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		int cmd;
		scanf("%d", &cmd);
		if (heap.size == 0 && cmd==0) {
			printf("0\n");
		}
		else if (cmd == 0) {
			delete_();
		}
		else insert(cmd);
	}
}

/*
1927. 최소 힙
https://www.acmicpc.net/problem/1927

문제
널리 잘 알려진 자료구조 중 최소 힙이 있다. 최소 힙을 이용하여 다음과 같은 연산을 지원하는 프로그램을 작성하시오.

배열에 자연수 x를 넣는다.
배열에서 가장 작은 값을 출력하고, 그 값을 배열에서 제거한다.
프로그램은 처음에 비어있는 배열에서 시작하게 된다.

입력
첫째 줄에 연산의 개수 N(1 ≤ N ≤ 100,000)이 주어진다. 다음 N개의 줄에는 연산에 대한 정보를 나타내는 정수 x가 주어진다. 만약 x가 자연수라면 배열에 x라는 값을 넣는(추가하는) 연산이고, x가 0이라면 배열에서 가장 작은 값을 출력하고 그 값을 배열에서 제거하는 경우이다. 입력되는 자연수는 231보다 작다.

출력
입력에서 0이 주어진 회수만큼 답을 출력한다. 만약 배열이 비어 있는 경우인데 가장 작은 값을 출력하라고 한 경우에는 0을 출력하면 된다.
*/