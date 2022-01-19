# BOJ 배열 돌리기1
from collections import deque
n,m,r = map(int,input().split())
a = [list(map(int,input().split())) for _ in range(n)]
groupNum = min(n,m)//2
groups = deque()
for k in range(0,groupNum):
    group = []
    for j in range(k+1,m-k):
        group.append(a[k][j])
    for i in range(k+1,n-k):
        group.append(a[i][m-1-k])
    for j in range(m-k-2,k-1,-1):
        group.append(a[n-1-k][j])
    for i in range(n-k-2,k-1,-1):
        group.append(a[i][k])
    groups.append(group)
for k in range(0,groupNum):
    g = groups.popleft()
    idx = 0 # 인덱스
    length = len(g)
    for j in range(k+1,m-k):
        a[k][j] = g[(idx+r)%length]
        idx += 1
    for i in range(k+1,n-k):
        a[i][m-1-k] = g[(idx+r)%length]
        idx += 1
    for j in range(m-k-2,k-1,-1):
        a[n-1-k][j] = g[(idx+r)%length]
        idx += 1
    for i in range(n-k-2,k-1,-1):
        a[i][k] = g[(idx+r)%length]
        idx += 1
for i in a:
    print(" ".join(map(str,i)))