# 2022.1.3
# BOJ 15990: 1,2,3 더하기 5
d = [[0] * 4 for _ in range(100001)]
mod = 1000000009
# d[i][1]: i를 만들 때 1로 끝난 수의 개수
d[1][1] = 1 # 1일때 1로 끝난수는 1개
d[2][2] = 1 # 2일때 2로 끝난수는 1개
d[3][3] = 1
for i in range(100001):
    if i > 1:
        d[i][1] = d[i - 1][2] + d[i - 1][3]
    if i > 2:
        d[i][2] = d[i - 2][1] + d[i - 2][3]
    if i > 3:
        d[i][3] = d[i - 3][1] + d[i - 3][2]
    d[i][1] %= mod
    d[i][2] %= mod
    d[i][3] %= mod
t = int(input())
for _ in range(t):
    n = int(input())
    ans = (d[n][1]+d[n][2]+d[n][3]) % mod
    print(ans)