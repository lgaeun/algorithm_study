#include<stdio.h>
#include<string.h>



int main() {
	char str[100001];
	char reverse_str[100001];

	int idx = 0;
	int tag_flag = 0;
	int word_flag = 0;
	int word_start = 0;

	scanf("%[^\n]s", str);//공백 포함 문자열 입력
	int length = strlen(str);

	for (int i = 0; i < length; i++) {
		if (tag_flag == 1) {
			if (str[i] == '>') {
				tag_flag = 0;
			}//tag 끝
			reverse_str[idx] = str[i];
			idx++;
		}//tag인 경우
		else {
			if (str[i] == '<') {
				if (word_flag == 1) {
					for (int j = i - 1; j >= word_start; j--) {
						reverse_str[idx] = str[j];
						idx++;
					}
					word_flag = 0;
					tag_flag = 1;
					reverse_str[idx] = str[i];
					idx++;
				}//앞이 tag였던 경우
				else {
					tag_flag = 1;
					reverse_str[idx] = str[i];
					idx++;
				}//앞도 tag였던 경우
			}//tag 시작
			else if (word_flag == 1) {
				if (str[i] == ' ') {
					word_flag = 0;
					for (int j = i - 1; j >= word_start; j--) {
						reverse_str[idx] = str[j];
						idx++;
					}
					reverse_str[idx] = str[i];
					idx++;
				}//공백으로 word 구분
				else if (i == length - 1) {
					for (int j = i; j >= word_start; j--) {
						reverse_str[idx] = str[j];
						idx++;
					}
				}//입력 문자열의 끝
			}
			else {
				word_flag = 1;
				word_start = i;
			}//word 시작
		}//tag가 아닌 경우
	}
	reverse_str[length] = NULL;
	printf("%s\n", reverse_str);
}


/*
17413. 단어 뒤집기 2 
https://www.acmicpc.net/problem/17413
 
문제
문자열 S가 주어졌을 때, 이 문자열에서 단어만 뒤집으려고 한다.

먼저, 문자열 S는 아래와과 같은 규칙을 지킨다.

알파벳 소문자('a'-'z'), 숫자('0'-'9'), 공백(' '), 특수 문자('<', '>')로만 이루어져 있다.
문자열의 시작과 끝은 공백이 아니다.
'<'와 '>'가 문자열에 있는 경우 번갈아가면서 등장하며, '<'이 먼저 등장한다. 또, 두 문자의 개수는 같다.
태그는 '<'로 시작해서 '>'로 끝나는 길이가 3 이상인 부분 문자열이고, '<'와 '>' 사이에는 알파벳 소문자와 공백만 있다. 단어는 알파벳 소문자와 숫자로 이루어진 부분 문자열이고, 연속하는 두 단어는 공백 하나로 구분한다. 태그는 단어가 아니며, 태그와 단어 사이에는 공백이 없다.

입력
첫째 줄에 문자열 S가 주어진다. S의 길이는 100,000 이하이다.

출력
첫째 줄에 문자열 S의 단어를 뒤집어서 출력한다.

 등장하는 것은
 1.태그
 2.단어
 단어는 공백을 기준으로 분리
 태그는 그대로, 단어는 뒤집어서
 <가 나오면 태그
 >가 나오면 태그가 끝남

경우의 수
1. 태그-태그
2. 태그-단어
3. 단어-태그
4. 단어 공백 단어
5. 단어 끝
*/
