#include<stdio.h>
#include<vector>
#include<iostream>
#include<string>
#include<algorithm>

using namespace std;


string str;
string ans_str = "";


int findSmaller(int idx) {
	int smaller = 101;
	for (int i = idx - 1; i >= 0; i--) {
		if (str[i] < str[idx]) {
			return i;
		}
	}
	return smaller;
}


int main() {
	int t;
	scanf("%d", &t);
	while (t--) {
		printf("\n");
		cin >> str;
		int flag = 0;
		for (int i = 0; i < str.size() - 1; i++) {
			if (str[i] < str[i + 1]) {
				flag = 1;
				break;
			}//내림차순 정렬이 아님
		}

		if (flag) {
			for (int idx = str.size() - 1; idx > 0; idx--) {
				int smaller = findSmaller(idx);
				if (smaller == 101) continue;//찾는 값보다 작은 값이 없는 경우
				else {
					swap(str[idx], str[smaller]);
					cout << "swap 후\n" << str << '\n';
					sort(str.begin() + smaller + 1, str.end());
					break;
				}//switch 후, 뒤는 정렬
				
			}
			cout << "정답\n" << str << '\n';
		}
		else cout << str << '\n';
	}
}


/*
17070. 
https://www.acmicpc.net/problem/17070

1
AZZZZBYYYYXXXXXXXXXXWWWWWWWWWWTTTTTTTTTTLLLLLLLLLLIIIIIIIIIIGGGGGGGGGGEEEEEEEEEECCCCCCCCCCBBBBBBBBBB


*/