# 2022.1.7
# BOJ
mod = 1000000009
d = [0] * 1000001
d[0] = 1  # 초기화
for i in range(1, 1000001):
    if i - 1 >= 0:
        d[i] += d[i - 1]
    if i - 2 >= 0:
        d[i] += d[i - 2]
    if i - 3 >= 0:
        d[i] += d[i - 3]
    d[i] %= mod
t = int(input())
for _ in range(t):
    n = int(input())
    print(d[n])
