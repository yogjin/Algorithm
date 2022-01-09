# BOJ
n = int(input())
a = list(map(int,input().split()))

# 초기화
ad = [1]*n
bd = [1]*n

for i in range(0,n): # 증가
    for j in range(i):
        if a[i] > a[j]:
            if ad[i] < ad[j]+1:
                ad[i] = ad[j]+1
for i in range(n-1,-1,-1):
    for j in range(i+1,n):
        if a[i] > a[j]:
            if bd[i] < bd[j]+1:
                bd[i] = bd[j]+1

ans = 0
for i in range(n):
    if ans < ad[i]+bd[i]-1:
        ans = ad[i]+bd[i]-1
print(ans)