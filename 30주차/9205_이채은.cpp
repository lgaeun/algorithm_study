#include <stdio.h>
#include <stdlib.h>
#include <vector>
#include <utility>

using namespace std;

bool flag = false;
int ex, ey, beer = 20;
vector<pair<int, int>> pos; //실제로 이동한 위치
vector<pair<int, int>> conv; //편의점 위치

int main() {
    int t;
    scanf("%d", &t);
    for (int i = 0; i < t; i++) {
        int n, x, y;
        bool visit[100] = { false, };
        scanf("%d", &n);
        scanf("%d %d", &x, &y); pos.push_back({ x, y });
        for (int j = 0; j < n; j++) {
            scanf("%d %d", &x, &y);
            conv.push_back({ x, y });
        }
        scanf("%d %d", &ex, &ey);
        while (!pos.empty()) {
            pair<int, int> p = pos.back(); pos.pop_back();
            int dist = abs(p.first - ex) + abs(p.second - ey);
            if (dist <= beer * 50) {
                flag = true; break; //도달할 수 있을 때
            }
            for (int j = 0; j < n; j++) {
                if (visit[j]) continue;
                pair<int, int> next = conv[j];
                int move = abs(next.first - p.first) + abs(next.second - p.second);
                if (move > beer * 50) continue;
                pos.push_back(next);
                visit[j] = true;
            }
        }
        if (flag) printf("happy\n");
        else printf("sad\n");
        flag = false; pos.clear(); conv.clear(); //초기화
    }
}
