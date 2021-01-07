a = [x for x in input()]
b = [x for x in input()]

alen = len(a)
blen = len(b)

dp = [[0]*(alen+1) for _ in range(blen+1)]

for i in range(1, blen + 1) :
    for j in range( 1, alen + 1) :
        dp[i][j] = max(dp[i][j-1], dp[i-1][j], dp[i-1][j-1] + (a[j-1]==b[i-1]))

print(dp[blen][alen])
