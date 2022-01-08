# 2022.1.8
# BOJ 포도주 시식
n = int(input())
a = [0]
for i in range(n):
    a.append(int(input()))
d = [0]*(n+1)
d[1] = a[1]
if n >= 2:
    d[2] = a[1]+a[2]
for i in range(3,n+1):
    d[i] = d[i-1] # a[i]를 안마심
    if d[i] < d[i-2]+a[i]:
        d[i] = d[i-2]+a[i]
    if d[i] < d[i-3] + a[i-1]+a[i]:
        d[i] = d[i-3] + a[i-1]+a[i]
print(d[n])