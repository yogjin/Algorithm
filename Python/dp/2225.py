# 2022.1.6
# BOJ 합분해

n, k = map(int, input().split())
d = [[0] * (k + 1) for _ in range(n + 1)]
mod = 1000000000
# 초기화
for i in range(n + 1):  # k == 0일때 d[n][k] = 0
    d[i][0] = 0
for i in range(k + 1):  # n == 0이고 k >= 1 일때, d[n][k] = 1
    d[0][i] = 1

# i: 수
# j: 정수 사용개수
for i in range(1, n + 1):
    for j in range(1, k + 1):
        a = 0
        while a <= i:
            d[i][j] += d[i - a][j - 1]
            d[i][j] %= mod
            a += 1
print(d[n][k]%mod)
