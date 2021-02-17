#include<stdio.h>
#include<string.h>
#include<malloc.h>


int main() {
	char str[1001];
	scanf("%s", str);
	char **suffix;
	suffix = (char**)malloc(sizeof(char*) * 1001);
	for (int i = 0; i < strlen(str); i++) {
		suffix[i] = (char *)malloc(sizeof(char)*1001);
		strcpy(suffix[i], str + i);
	}
	char temp[1001];
	int n=0;
	for (int i = 0; i < strlen(str); i++) {
		n = i;
		for (int j = i + 1; j < strlen(str); j++) {
			if (strcmp(suffix[n], suffix[j]) > 0)
				n = j;
		}
		strcpy(temp, suffix[i]);
		strcpy(suffix[i], suffix[n]);
		strcpy(suffix[n], temp);
	}
	for (int i = 0; i < strlen(str); i++) {
		printf("%s\n", suffix[i]);
	}
}

/*
11656. 접미사 배열
https://www.acmicpc.net/problem/11656

문제
접미사 배열은 문자열 S의 모든 접미사를 사전순으로 정렬해 놓은 배열이다.

baekjoon의 접미사는 baekjoon, aekjoon, ekjoon, kjoon, joon, oon, on, n 으로 총 8가지가 있고, 이를 사전순으로 정렬하면, aekjoon, baekjoon, ekjoon, joon, kjoon, n, on, oon이 된다.

문자열 S가 주어졌을 때, 모든 접미사를 사전순으로 정렬한 다음 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 문자열 S가 주어진다. S는 알파벳 소문자로만 이루어져 있고, 길이는 1,000보다 작거나 같다.

출력
첫째 줄부터 S의 접미사를 사전순으로 한 줄에 하나씩 출력한다.

based on selection sort
!!!!! use strcmp !!!!!

*/