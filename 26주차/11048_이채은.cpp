#include <stdio.h>
#include <algorithm>

using namespace std;

int N, M;
int maze[1001][1001] = { 0, };

int main() {
    scanf("%d%d", &N, &M);
    for (int i = 1; i < N + 1; i++) {
        for (int j = 1; j < M + 1; j++) {
            scanf("%d", &maze[i][j]);
        }
    }
    for (int i = 1; i < N + 1; i++) {
        for (int j = 1; j < M + 1; j++) {
            maze[i][j] = max(maze[i - 1][j], maze[i][j - 1]) + maze[i][j];
        }
    }
    printf("%d", maze[N][M]);
}
