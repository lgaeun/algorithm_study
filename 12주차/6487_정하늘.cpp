#include<stdio.h>

typedef struct point {
	int x;
	int y;
}point;


int main() {
	int t;
	scanf("%d", &t);
	while (t--) {
		point p[4];
		float m1, n1;//y=mx+n
		float m2, n2;
		int horizon_flag1 = 0, horizon_flag2 = 0;
		for (int i = 0; i < 4; i++) {
			scanf("%d%d", &p[i].x, &p[i].y);
		}
		if (p[1].x != p[0].x) {
			m1 = (float)(p[1].y - p[0].y) / (p[1].x - p[0].x);
			n1 = p[0].y - (float)(p[1].y - p[0].y) / (p[1].x - p[0].x)*p[0].x;
		}//x=? 이 아님(세로선이 아님)
		else horizon_flag1 = 1;
		if (p[3].x != p[2].x) {
			m2 = (float)(p[3].y - p[2].y) / (p[3].x - p[2].x);
			n2 = p[2].y - (float)(p[3].y - p[2].y) / (p[3].x - p[2].x)*p[2].x;
		}//x=? 이 아님(세로선이 아님)
		else horizon_flag2 = 1;


		if (horizon_flag1 == 1 && horizon_flag2 == 1) {
			if (p[0].x == p[2].x) printf("LINE\n");//일치
			else printf("NONE\n");//평행
		}//둘 다 세로선
		else if (horizon_flag1 == 1 || horizon_flag2 == 1) {
			if (horizon_flag1) {
				float x = p[0].x;
				printf("POINT %.2f %.2f\n", x, m2*x + n2);
			}
			else if (horizon_flag2) {
				float x = p[1].x;
				printf("POINT %.2f %.2f\n", x, m1*x + n1);
			}
		}//둘 중 하나가 세로선
		else {
			if (m1 == m2) {
				if (n1 == n2) {
					printf("LINE\n");
				}
				else printf("NONE\n");
			}//기울기가 같을 때
			else {
				float x = (float)(n2 - n1) / (m1 - m2);
				printf("POINT %.2f %.2f\n", x, m1*x + n1);
			}
		}
	}
}


/*
6487. 두 직선의 교차 여부
https://www.acmicpc.net/problem/6487

문제
두 개의 직선을 나타내는 4개의 점이 입력으로 주어질 때, 두 직선이 만나는지를 확인하는 프로그램을 작성하시오.

입력
입력의 첫 번째 줄에는 테스트 케이스의 개수 N이 주어진다. (N <= 10)

다음 N개의 줄에는 각각 8개의 정수 x1, y1, x2, y2, x3, y3, x4, y4가 주어진다. 이는 두 직선 (x1, y1)-(x2, y2)와 (x3, y3)-(x4, y4)를 나타낸다.

(x1, y1)과 (x2, y2)는 서로 다른 점이며, (x3, y3)와 (x4, y4)는 서로 다른 점임이 보장된다.

모든 x와 y는 [-1000, 1000] 범위 내의 정수이다.

출력
각각의 테스트 케이스에 대해, 다음과 같이 출력한다.

두 직선이 정확히 한 점에서 만난다면, POINT x y의 꼴로 출력한다. 이는 두 직선이 (x,y)에서 교차함을 의미한다. x와 y는 정확히 소숫점 아래 둘째 자리까지 출력한다.
두 직선이 만나지 않는다면, NONE을 출력한다.
두 직선이 무한히 많은 점에서 만난다면,  LINE을 출력한다.
원문에 있는 INTERSECTING LINES OUTPUT/END OF OUTPUT 등은 출력하지 않는다.

*/
