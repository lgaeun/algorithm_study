#include <stdio.h>
#include <map>

using namespace std;

long long N, P, Q;
map<long long, long long> m;

long long value(long long num) {

    if (m.count(num) != 0)
        return m[num];

    else {
        m[num] = value(num / P) + value(num / Q);
        return m[num];
    }
}

int main() {
    scanf("%llu %llu %llu", &N, &P, &Q);
    m[0] = 1;
    value(N);
    printf("%llu", m[N]);
}
