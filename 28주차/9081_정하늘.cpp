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
			}//�������� ������ �ƴ�
		}

		if (flag) {
			for (int idx = str.size() - 1; idx > 0; idx--) {
				int smaller = findSmaller(idx);
				if (smaller == 101) continue;//ã�� ������ ���� ���� ���� ���
				else {
					swap(str[idx], str[smaller]);
					cout << "swap ��\n" << str << '\n';
					sort(str.begin() + smaller + 1, str.end());
					break;
				}//switch ��, �ڴ� ����
				
			}
			cout << "����\n" << str << '\n';
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