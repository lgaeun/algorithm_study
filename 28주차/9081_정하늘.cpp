#include<stdio.h>
#include<vector>
#include<iostream>
#include<string>
#include<algorithm>

using namespace std;


int main() {
	int t;
	scanf("%d", &t);
	while (t--) {
		string str;
		cin >> str;
		string ans = str;
		int flag = next_permutation(str.begin(), str.end());
		if (flag) {
			cout << str << '\n';
		}
		else {
			cout << ans << '\n';
		}
	}
}


/*
17070. 
https://www.acmicpc.net/problem/17070





5 6 7 8 9
5 6 7 9 8
5 6 8 9 7 -> 5 6 8 7 9
5 6 8 9 7

5 7 8 9 6 -> 5 7 6 8 9        ( 5 6 9 7 8 )





*/
