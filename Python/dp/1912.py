# 2022.1.5
# BOJ 1912
n = int(input())
a = list(map(int,input().split()))
d = [-10e9] * n

for i in range(0,n):
    d[i] = max(d[i-1]+a[i], a[i])
print(max(d))