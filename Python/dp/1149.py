# 2022.1.7
# BOJ
n = int(input())
# d[i][j]: i번집을 j번째 색으로 칠했을때 0~i번째 집을 칠하는 최소비용
d = [[0]*3 for _ in range(n+1)]
a = [] # i번째 집의 RGB 비용
for _ in range(n):
    a.append(list(map(int,input().split())))

# 초기화
d[0][0] = a[0][0]
d[0][1] = a[0][1]
d[0][2] = a[0][2]
for i in range(1,n):
    d[i][0] = min(d[i-1][1],d[i-1][2]) + a[i][0]
    d[i][1] = min(d[i-1][0],d[i-1][2]) + a[i][1]
    d[i][2] = min(d[i-1][0],d[i-1][1]) + a[i][2]
print(min(d[n-1]))