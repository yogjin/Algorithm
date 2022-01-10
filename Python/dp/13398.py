# BOJ 연속합2
n = int(input())
a = list(map(int,input().split()))
d = [0]*n
d2 = [0]*n

d[0] = a[0]
for i in range(1,n):
    d[i] = d[i-1] + a[i]
    if d[i] < a[i]:
        d[i] = a[i]
d2[-1] = a[-1]
for i in range(n-2,-1,-1):
    d2[i] = d2[i+1] + a[i]
    if d2[i] < a[i]:
        d2[i] = a[i]
ans = max(d)
for i in range(1,n-1):
    if ans < d[i-1]+d2[i+1]:
        ans = d[i-1]+d2[i+1]
print(ans)