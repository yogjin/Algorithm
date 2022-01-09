# 2022.1.9
# BOJ 정수 삼각형
n = int(input())
a = []
for _ in range(n):
    a.append(list(map(int, input().split())))
d = [[0] * i for i in range(1, n + 1)]
d[0][0] = a[0][0]

for i in range(1, n):
    for j in range(i + 1):
        if j-1 < 0:
            d[i][j] = d[i - 1][j] + a[i][j]
            continue
        if len(a[i-1]) <= j:
            d[i][j] = d[i - 1][j - 1] + a[i][j]
            continue
        d[i][j] = max(d[i - 1][j - 1], d[i - 1][j]) + a[i][j]
print(max(d[n - 1]))
