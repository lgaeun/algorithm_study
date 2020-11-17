#include<stdio.h>
#include<malloc.h>
#include<string.h>

typedef struct Node {
	int data;
	struct Node *prev;
	struct Node *next;
}Node;

typedef struct DoublyLinkedList {
	Node *head;
	Node *tail;
	Node *cursor;
}List;

List list;
int front = 0;//head노드 앞을 가리킴

void init() {
	list.head = NULL;
	list.tail = NULL;
}

int isEmpty() {
	if (list.head == NULL && list.tail==NULL) return 1;
	else return 0;
}

void insert(char x) {
	Node *newNode = (Node*)malloc(sizeof(Node));
	newNode->data = x;
	if (isEmpty()) {
		list.head = newNode;
		list.tail = newNode;
		list.cursor = newNode;
		front = 0;
	}//첫노드
	else if (list.cursor == list.head && front==1) {
		list.head->prev = newNode;
		newNode->next = list.head;
		list.head = newNode;
		list.cursor = newNode;
		front = 0;
	}//head앞에 넣어줄 때
	else if (list.cursor == list.tail) {
		list.tail->next = newNode;
		newNode->prev = list.tail;
		list.tail = newNode;
		list.cursor = newNode;
	}//tail뒤에 넣어줄 때
	else {
		newNode->next = list.cursor->next;
		newNode->prev = list.cursor;
		list.cursor->next->prev = newNode;
		list.cursor->next = newNode;
		list.cursor = newNode;
	}//중간에 넣어줄 때
}

void remove() {
	if (isEmpty()) {
		return;
	}
	if (list.cursor == list.head && front == 1) {
		return;
	}
	if (list.cursor == list.head && list.cursor == list.tail) {
		list.head = NULL;
		list.tail = NULL;
	}//하나 남았을 때 삭제
	else if (list.cursor==list.head) {
		list.head = list.head->next;
		list.cursor = list.head;
		front = 1;
	}//맨앞에서 삭제
	else if (list.cursor==list.tail) {
		list.tail = list.cursor->prev;
		list.cursor = list.tail;
		list.tail->next = NULL;
	}//맨뒤에서 삭제
	else {
		list.cursor->prev->next = list.cursor->next;
		list.cursor->next->prev = list.cursor->prev;
		list.cursor = list.cursor->prev;
	}//중간에서 삭제
}


int main() {
	int n;
	scanf("%d", &n);
	while (n--) {
		init();
		char key[1000001];
		scanf(" %s", key);
		int len = strlen(key);
		for (int i = 0; i < len; i++) {
			char cmd = key[i];
			switch (cmd) {
			case '<':
				if (!isEmpty()) {
					if (list.cursor == list.head) front = 1;
					else list.cursor = list.cursor->prev;
				}
				break;
			case '>':
				if (!isEmpty()) {
					if (list.cursor == list.head && front == 1) front = 0;
					else if (list.cursor == list.tail);
					else list.cursor = list.cursor->next;
				}
				break;
			case '-':
				remove();
				break;
			default:
				insert(cmd);
			}
		}
		Node *temp = list.head;
		if (!isEmpty()) {
			while (temp != list.tail->next) {
				printf("%c", temp->data);
				temp = temp->next;
			}
		}
		printf("\n");
	}
}


/*
5397. 키로거
https://www.acmicpc.net/problem/5397

문제
창영이는 강산이의 비밀번호를 훔치기 위해서 강산이가 사용하는 컴퓨터에 키로거를 설치했다. 며칠을 기다린 끝에 창영이는 강산이가 비밀번호 창에 입력하는 글자를 얻어냈다.

키로거는 사용자가 키보드를 누른 명령을 모두 기록한다. 따라서, 강산이가 비밀번호를 입력할 때, 화살표나 백스페이스를 입력해도 정확한 비밀번호를 알아낼 수 있다.

강산이가 비밀번호 창에서 입력한 키가 주어졌을 때, 강산이의 비밀번호를 알아내는 프로그램을 작성하시오.

입력
첫째 줄에 테스트 케이스의 개수가 주어진다. 각 테스트 케이스는 한줄로 이루어져 있고, 강산이가 입력한 순서대로 길이가 L인 문자열이 주어진다. (1 ≤ L의 길이 ≤ 1,000,000) 강산이가 백스페이스를 입력했다면, '-'가 주어진다. 이때 커서의 바로 앞에 글자가 존재한다면, 그 글자를 지운다. 화살표의 입력은 '<'와 '>'로 주어진다. 이때는 커서의 위치를 움직일 수 있다면, 왼쪽 또는 오른쪽으로 1만큼 움직인다. 나머지 문자는 비밀번호의 일부이다. 물론, 나중에 백스페이스를 통해서 지울 수는 있다. 만약 커서의 위치가 줄의 마지막이 아니라면, 커서 및 커서 오른쪽에 있는 모든 문자는 오른쪽으로 한 칸 이동한다.

출력
각 테스트 케이스에 대해서, 강산이의 비밀번호를 출력한다. 비밀번호의 길이는 항상 0보다 크다.



*/