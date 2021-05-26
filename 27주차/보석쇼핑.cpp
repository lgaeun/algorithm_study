#include <string>
#include <vector>
#include <map>

using namespace std;


vector<int> solution(vector<string> gems) {
	vector<int> answer;
	map<string, int> m;
	int gem_size = gems.size();
	for (int i = 0; i < gem_size; i++) {
		if (m[gems[i]] == 0)
			m[gems[i]]++;
	}
	int gem_kind = m.size();
	m.clear();

	int left,right;
	int ans_left = 0, ans_right = 0;
	int distance = gem_size;
	left = right = 0;
	m[gems[0]]++;
	while (right < gem_size) {
		if (m.size() == gem_kind) {
			if (distance > right - left) {
				distance = right - left;
				ans_left = left + 1;
				ans_right = right + 1;
			}
			m[gems[left]]--;
			if (m[gems[left]] == 0) m.erase(gems[left]);
			left++;
		}
		else {
			right++;
			if (right >= gem_size) continue;
			m[gems[right]]++;
		}
	}
	answer.push_back(ans_left);
	answer.push_back(ans_right);
	return answer;
}

int main() {
	vector<string> gems = { "DIA", "RUBY","RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA" };
	vector<int> ans = solution(gems);
	printf("%d %d\n", ans[0], ans[1]);
}


/*
투포인터 방식 활용.
left, right를 두고 모든 보석이 포함될때까지 right를 증가시킴.
모든 보석이 포함되면, left를 증가시키면서,
삭제되는 보석이 생긴다면 map에서 보석 삭제

보석이 삭제되었다면 다시 right를 증가시킬 것이고,
보석이 삭제되지 않았다면 left를 증가시킴.
이 과정을 모두 반복하며 최단 구간을 구함.
*/
