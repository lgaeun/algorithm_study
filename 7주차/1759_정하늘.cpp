#include<stdio.h>

int L, C;
char arr[16];
char password[16] = "";

void sort() {
	char temp;
	for (int i = 0; i < C - 1; i++) {
		char min = arr[i];
		int idx = i;
		for (int j = i + 1; j < C; j++) {
			if (arr[j] < min) {
				min = arr[j];
				idx = j;
			}
		}
		temp = arr[i];
		arr[i] = arr[idx];
		arr[idx] = temp;
	}
}

int check() {
	int jaum = 0;
	int moum = 0;
	for (int i = 0; i < L; i++) {
		if (password[i] == 'a' || password[i] == 'e' || password[i] == 'i' || password[i] == 'o' || password[i] == 'u')
			moum++;
		else
			jaum++;
	}
	return (jaum >= 2 && moum >= 1);
}

void DFS(int start, int depth) {
	if (depth == L) {
		if (check() == 1) {
			printf("%s\n", password);
		}
	}
	else {
		for (int i = start; i < C; i++) {
			password[depth] = arr[i];
			DFS(i + 1, depth + 1);
		}
		//ex> depth가 1일 때 arr[0]~arr[C]까지 모두 호출하므로 모든 순열을 만들 수 있다
		//초기에 함수를 호출하면, DFS(1,1), DFS(2,1), DFS(3,1), DFS(4,1)... DFS(C,1) 까지 모두 호출하기 때문에 모든 순열을 만들 수 있는 것.
		//DFS(1,1)을 호출한 후, DFS(2,2), DFS(3,2), DFS(4,2)... DFS(C,2) 이렇게 호출.
		//DFS(1,1) -> DFS(2,2) -> DFS(3,3) ... 이런식으로 하고서 depth가 꽉차면
		//예를들어 depth max가 5인 상황에서는 DFS(4,4) 까지 하고 DFS(5,5), DFS(6,5)... DFS(C,5)를 해서 모든 순열을 본다.
		//그 후 recursive가 종료되어 DFS(5,4)를 호출하고 또 끝까지... 이것이 끝나면 또 DFS(6,4)... depth==4의 for문을 모두 끝내면 depth==3에서 for문...
	}
}

int main() {
	scanf("%d%d", &L,&C);
	for (int i = 0; i < C; i++){
		scanf(" %c", &arr[i]);
	}
	sort();
	DFS(0, 0);
}

/*
1759. 암호 만들기
https://www.acmicpc.net/problem/1759

문제
바로 어제 최백준 조교가 방 열쇠를 주머니에 넣은 채 깜빡하고 서울로 가 버리는 황당한 상황에 직면한 조교들은, 702호에 새로운 보안 시스템을 설치하기로 하였다. 이 보안 시스템은 열쇠가 아닌 암호로 동작하게 되어 있는 시스템이다.

암호는 서로 다른 L개의 알파벳 소문자들로 구성되며 최소 한 개의 모음(a, e, i, o, u)과 최소 두 개의 자음으로 구성되어 있다고 알려져 있다. 또한 정렬된 문자열을 선호하는 조교들의 성향으로 미루어 보아 암호를 이루는 알파벳이 암호에서 증가하는 순서로 배열되었을 것이라고 추측된다. 즉, abc는 가능성이 있는 암호이지만 bac는 그렇지 않다.

새 보안 시스템에서 조교들이 암호로 사용했을 법한 문자의 종류는 C가지가 있다고 한다. 이 알파벳을 입수한 민식, 영식 형제는 조교들의 방에 침투하기 위해 암호를 추측해 보려고 한다. C개의 문자들이 모두 주어졌을 때, 가능성 있는 암호들을 모두 구하는 프로그램을 작성하시오.

입력
첫째 줄에 두 정수 L, C가 주어진다. (3 ≤ L ≤ C ≤ 15) 다음 줄에는 C개의 문자들이 공백으로 구분되어 주어진다. 주어지는 문자들은 알파벳 소문자이며, 중복되는 것은 없다.

출력
각 줄에 하나씩, 사전식으로 가능성 있는 암호를 모두 출력한다.


Brute-Force
입력받은 알파벳을 정렬하는 함수
자음 모음의 개수가 조건을 만족하는지 체크하는 함수
depth가 정해진 모든 순열 구하기
*/
