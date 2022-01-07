# 2022.1.7
# BOJ 동물원
n = int(int(input()))
mod = 9901
d = [[0]*3 for _ in range(n)] # 배치방법 0,1,2
# 초기화
d[0][0] = 1
d[0][1] = 1
d[0][2] = 1
for i in range(1,n):
    d[i][0] = d[i-1][1] + d[i-1][2]
    d[i][1] = d[i-1][0] + d[i-1][2]
    d[i][2] = d[i-1][0] + d[i-1][1] + d[i-1][2]
    d[i][0] %= mod
    d[i][1] %= mod
    d[i][2] %= mod
print(sum(d[n-1])%mod)