#include <string>
#include <vector>
#include <map>

using namespace std;

map<long long, long long> m;

long long getNextEmpty(long long num) {
	if (m[num] == 0) return num;
	return m[num] = getNextEmpty(m[num]);
}

vector<long long> solution(long long k, vector<long long> room_number) {
	vector<long long> answer;
	int size = room_number.size();
	for (int i = 0; i < size; i++) {
		long long room = getNextEmpty(room_number[i]);
		m[room] = room + 1;//�θ��� ����
		answer.push_back(room);
	}
	return answer;
}

int main() {
	long long k = 10;
	vector<long long> room_number = { 1,3,4,1,3,1 };
	vector<long long> answer = solution(k, room_number);
	for (int i = 0; i < answer.size(); i++) {
		printf("%lld\n", answer[i]);
	}
}

/*
ã�� �� : �� ��ȣ. target number�� ���� ��, �������� ���� ���̸鼭 target number���� ū ���� ���� ��

*/