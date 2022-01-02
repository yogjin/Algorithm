# 2022.1.2
# BOJ 11052 카드 구매하기
n = int(input())
d = [0] * (n+1) # i개 샀을때 최대 금액
p = [0]
p += list(map(int,input().split()))
for i in range(1,n+1):
    for j in range(1,i+1):
        d[i] = max(d[i],d[i-j]+p[j])
print(d[n])
# O(N^2)