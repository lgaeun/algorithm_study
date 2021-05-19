#include <string>
#include <vector>
#include <iostream>

using namespace std;


string solution(string play_time, string adv_time, vector<string> logs) {
	string answer = "";
	int end_time = 0;
	end_time += (play_time[0] - '0') * 10 * 60 * 60 + (play_time[1] - '0') * 60 * 60;//시
	end_time += (play_time[3] - '0') * 10 * 60 + (play_time[4] - '0') * 60;//분
	end_time += (play_time[6] - '0') * 10 + (play_time[7] - '0');//초

	int ad_time = 0;
	ad_time += (adv_time[0] - '0') * 10 * 60 * 60 + (adv_time[1] - '0') * 60 * 60;//시
	ad_time += (adv_time[3] - '0') * 10 * 60 + (adv_time[4] - '0') * 60;//분
	ad_time += (adv_time[6] - '0') * 10 + (adv_time[7] - '0');//초

	//동시 viewer
	long long see[360000] = { 0, };
	int size = logs.size();
	for (int i = 0; i < size; i++) {
		int start = 0;
		start += (logs[i][0] - '0') * 10 * 60 * 60 + (logs[i][1] - '0') * 60 * 60;//시
		start += (logs[i][3] - '0') * 10 * 60 + (logs[i][4] - '0') * 60;//분
		start += (logs[i][6] - '0') * 10 + (logs[i][7] - '0');//초
		int end = 0;
		end += (logs[i][9] - '0') * 10 * 60 * 60 + (logs[i][10] - '0') * 60 * 60;//시
		end += (logs[i][12] - '0') * 10 * 60 + (logs[i][13] - '0') * 60;//분
		end += (logs[i][15] - '0') * 10 + (logs[i][16] - '0');//초

		for (int i = start; i < end; i++) {
			see[i]++;
		}
	}

	long long cum_time = see[0];
	for (int i = 1; i < ad_time; i++) {
		cum_time += see[i];
	}
	long long max = cum_time;
	int start_time = 0;

	int cnt = 0;

	for (int i = ad_time; i < end_time; i++) {
		cum_time -= see[cnt];
		cnt++;
		cum_time += see[i];
		if (max < cum_time) {
			start_time = cnt;
			max = cum_time;
		}
	}

	//변환
	int hour_1 = start_time / 36000;
	start_time -= hour_1 * 36000;

	int hour_2 = start_time / 3600;
	start_time -= hour_2 * 3600;

	int minute_1 = start_time / 600;
	start_time -= minute_1 * 600;

	int minute_2 = start_time / 60;
	start_time -= minute_2 * 60;

	int second_1 = start_time / 10;
	start_time -= second_1 * 10;

	int second_2 = start_time;

	answer += to_string(hour_1) + to_string(hour_2) + ":";
	answer += to_string(minute_1) + to_string(minute_2) + ":";
	answer += to_string(second_1) + to_string(second_2);
	return answer;
}

int main() {
	string play_time = "02:03:55";
	string adv_time = "00:14:15";
	vector<string> logs = { "01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30" };

	cout << solution(play_time, adv_time, logs) << "\n";
}
