#include<stdio.h>
#include<string.h>

int stack[100];
int stk_rear = 0;

int num_arr[100001];
int idx = 0;

void make_num() {
	int num = 0;
	int mux = 1;
	for (int i = stk_rear - 1; i >= 0; i--) {
		num += stack[i] * mux;
		mux *= 10;
	}
	stk_rear = 0;
	num_arr[idx] = num;
	idx++;
}

int main() {
	int t;
	scanf("%d", &t);
	while (t--) {
		char cmd[100001];
		int n;
		scanf(" %s%d", cmd, &n);

		char c;
		scanf(" %c", &c);
		while (1) {
			if (c == ',') {
				make_num();
			}//stk에 있는 것들 수로 만들기
			else if (c == '[');
			else if (c == ']') {
				make_num();
				break;
			}//입력 끝
			else {
				stack[stk_rear] = c - '0';
				stk_rear++;
			}//수가 들어왔음. 스택에 넣기
			scanf(" %c", &c);
		}//수 배열 만들기

		int reverse_flag = 0;

		int len = strlen(cmd);
		int front = 0;
		int rear = n - 1;
		int end_flag = 0;
		for (int i = 0; i < len; i++) {
			if (cmd[i] == 'R') {
				if (reverse_flag == 1) reverse_flag = 0;
				else reverse_flag = 1;
			}
			else if (cmd[i] == 'D') {
				if (front <= rear) {
					if (reverse_flag == 0) {
						front++;
					}//똑바로 된 경우
					else {
						rear--;
					}//뒤집어진 경우
				}//수가 있음
				else {
					printf("error\n");
					end_flag = 1;
				}//수가 없음
			}
			if (end_flag == 1) break;
		}//명령 수행

		if (end_flag == 0) {
			if (reverse_flag == 0) {
				printf("[");
				for (int i = front; i < rear; i++) {
					printf("%d,", num_arr[i]);
				}
				if (front <= rear) printf("%d", num_arr[rear]);
				printf("]\n");
			}
			else {
				printf("[");
				for (int i = rear; i > front; i--) {
					printf("%d,", num_arr[i]);
				}
				if (front <= rear) printf("%d", num_arr[front]);
				printf("]\n");
			}
		}//결과 출력
		idx = 0;
	}
}

/*
빈 배열인 경우
원소가 하나인 경우 등의 케이스 처리
입력이 문자열로 들어오기 때문에 일일히 수로 만들어주는 작업
*/


/*
5430. AC
https://www.acmicpc.net/problem/5430

문제
선영이는 주말에 할 일이 없어서 새로운 언어 AC를 만들었다. AC는 정수 배열에 연산을 하기 위해 만든 언어이다. 이 언어에는 두 가지 함수 R(뒤집기)과 D(버리기)가 있다.

함수 R은 배열에 있는 숫자의 순서를 뒤집는 함수이고, D는 첫 번째 숫자를 버리는 함수이다. 배열이 비어있는데 D를 사용한 경우에는 에러가 발생한다.

함수는 조합해서 한 번에 사용할 수 있다. 예를 들어, "AB"는 A를 수행한 다음에 바로 이어서 B를 수행하는 함수이다. 예를 들어, "RDD"는 배열을 뒤집은 다음 처음 두 숫자를 버리는 함수이다.

배열의 초기값과 수행할 함수가 주어졌을 때, 최종 결과를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 테스트 케이스의 개수 T가 주어진다. T는 최대 100이다.

각 테스트 케이스의 첫째 줄에는 수행할 함수 p가 주어진다. p의 길이는 1보다 크거나 같고, 100,000보다 작거나 같다.

다음 줄에는 배열에 들어있는 수의 개수 n이 주어진다. (0 ≤ n ≤ 100,000)

다음 줄에는 [x1,...,xn]과 같은 형태로 배열에 들어있는 수가 주어진다. (1 ≤ xi ≤ 100)

전체 테스트 케이스에 주어지는 p의 길이의 합과 n의 합은 70만을 넘지 않는다.

출력
각 테스트 케이스에 대해서, 입력으로 주어진 정수 배열에 함수를 수행한 결과를 출력한다. 만약, 에러가 발생한 경우에는 error를 출력한다.

*/