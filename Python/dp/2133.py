# BOJ 타일 채우기
n = int(input())
d = [0] * 31
d[2] = 3
d[4] = 11
for i in range(6, 31, 2):
    d[i] = d[i - 2] * 3
    for j in range(i - 4, 0, -2):
        d[i] += d[j] * 2
    d[i] += 2
print(d[n])
