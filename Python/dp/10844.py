# 2022.1.4
# BOJ 10844: 쉬운 계단 수
mod = 1000000000
d = [[0]*10 for _ in range(101)]
d[1][0] = 0
for j in range(1,10):
    d[1][j] = 1
d[2][0] = 1
d[2][1] = 1
for j in range(2,9):
    d[2][j] = 2
d[2][9] = 1
for i in range(3,101):
    for j in range(10):
        if j == 0:
            d[i][j] = d[i-1][1]
        elif j == 9:
            d[i][j] = d[i-1][8]
        else:
            d[i][j] = d[i-1][j-1] + d[i-1][j+1]
        d[i][j] %= mod
n = int(input())
ans = sum(d[n])%mod
print(ans)