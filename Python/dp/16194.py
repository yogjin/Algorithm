# 2022.1.2
# BOJ 16194 카드 구매하기2
n = int(input())
p = [0]
p += list(map(int,input().split()))
d = [10e9] * (n+1) # 큰 값으로 초기화
d[0] = 0 # 0개사는 비용은 0으로.

for i in range(1,n+1):
    for j in range(1,n+1):
        d[i] = min(d[i], d[i-j] + p[j])
print(d[n])