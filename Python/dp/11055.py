# BOJ
n = int(input())
a = list(map(int,input().split()))
d = [0] * (n)
d[0] = a[0] # 초기화
for i in range(1,n):
    c = 0 # 가장큰 값
    for j in range(i):
        if c < d[j] and a[i] > a[j]:
            c = d[j]
    d[i] = c + a[i]
print(max(d))