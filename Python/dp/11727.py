# 2022.1.1
# BOJ 11727
n = int(input())
d = [0]*1001
d[0] = 1
d[1] = 3
for i in range(2,n):
    d[i] = d[i-2]*2 + d[i-1]
print(d[n-1]%10007)