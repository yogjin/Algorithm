#2022.1.7
# BOJ 오르막수
n = int(input())
d = [[0]*10 for _ in range(1001)] # d[i][j]: j로 끝나고 자릿수가 i인 오르막수
for j in range(10):
    d[0][j] = 1
for i in range(1,n):
    for j in range(10):
        for k in range(0,j+1):
            d[i][j] += d[i-1][k]
print(sum(d[n-1]))