#include<stdio.h>
#include<vector>
#include<string>
#include<iostream>
#include<algorithm>

using namespace std;


int main() {
	int k;
	scanf("%d", &k);
	
	k += 1;
	string s = "";
	while (k > 1) {
		if (k % 2 == 0) s = '4' + s;
		else s = '7' + s;
		k /= 2;
	}
	cout << s << "\n";
}


/*
2877. 4와 7
https://www.acmicpc.net/problem/2877

문제
창영이는 4와 7로 이루어진 수를 좋아한다. 창영이가 좋아하는 수 중에 K번째 작은 수를 구해 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 K(1 ≤ K ≤ 109)가 주어진다.

출력
첫째 줄에 창영이가 좋아하는 숫자 중 K번째 작은 수를 출력한다.

*/