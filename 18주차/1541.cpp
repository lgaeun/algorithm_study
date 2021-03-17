#include<stdio.h>
#include<stack>
#include<string.h>
#include<vector>

using namespace std;

stack<int> s;
vector<int> nums;

int flag = 0;//0은 +, 1은 -

void make_num() {
	int n = 0;
	int mux = 1;
	int len = s.size();
	for (int i = 0; i < len; i++) {
		n += mux * s.top();
		s.pop();
		mux *= 10;
	}
	if (flag == 1) n *= -1;
	nums.push_back(n);
}



int main() {
	char str[52] = "";
	scanf("%s", str);
	int len = strlen(str);
	for (int i = 0; i < len; i++) {
		if (str[i] >= '0' && str[i] <= '9') {
			s.push(str[i] - '0');
			if (i == len - 1) make_num();
		}
		else if (str[i] == '+' || str[i] == '-') {
			make_num();
			if (str[i] == '+') flag = 0;
			else flag = 1;
		}
	}

	int ans = 0;
	int m_flag = 0;
	for (int i = 0; i < nums.size(); i++) {
		if (nums[i] < 0) {
			ans += nums[i];
			m_flag = 1;
		}//음수인 경우
		else if (!m_flag) {
			ans += nums[i];
		}//음수가 나온 적 없는 경우
		else if (m_flag && nums[i]>0) {
			ans -= nums[i];
		}//음수가 나온 적 있고 양수인 경우
	}
	printf("%d\n", ans);
}



                                                 
/*
1541. 잃어버린 괄호
https://www.acmicpc.net/problem/1541

문제
세준이는 양수와 +, -, 그리고 괄호를 가지고 식을 만들었다. 그리고 나서 세준이는 괄호를 모두 지웠다.

그리고 나서 세준이는 괄호를 적절히 쳐서 이 식의 값을 최소로 만들려고 한다.

괄호를 적절히 쳐서 이 식의 값을 최소로 만드는 프로그램을 작성하시오.

입력
첫째 줄에 식이 주어진다. 식은 ‘0’~‘9’, ‘+’, 그리고 ‘-’만으로 이루어져 있고, 가장 처음과 마지막 문자는 숫자이다. 그리고 연속해서 두 개 이상의 연산자가 나타나지 않고, 5자리보다 많이 연속되는 숫자는 없다. 수는 0으로 시작할 수 있다. 입력으로 주어지는 식의 길이는 50보다 작거나 같다.

출력
첫째 줄에 정답을 출력한다.


음수가 나타난 순간부터 모든 수를 빼준다(양수의 경우)
음수의 경우 그대로 더함
*/                      