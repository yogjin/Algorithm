# 2022.1.6
# BOJ 1699: 제곱수의 합
n = int(input())
d = [i for i in range(n + 1)]  # 초기화: 1 제곱으로만 만드는 개수
for i in range(1, n + 1):
    j = 1
    while j * j <= i:
        if d[i - j * j] + 1 < d[i]:
            d[i] = d[i - j * j] + 1
        j += 1
print(d[n])

