# 2021.04.11
# Park_YeongJin
# 특정 거리의 도시 찾기
# BOJ18352
import sys
from collections import deque

input = sys.stdin.readline
#도시개수,도로개수,거리정보,출발도시번호
n,m,k,x = map(int,input().split())

road = [[] for _ in range(n+1)]
for _ in range(m):
    a,b = map(int,input().split())
    road[a].append(b)# a->b 도로존재

#x부터 각 도시까지의 거리:초기값 -1
dist = [-1]*(n+1)
dist[x] = 0 #자기자신은 0

vis = [False]*(n+1)
vis[x] = True
q = deque([x])
while q:
    now = q.popleft()
    for i in road[now]:
        if not vis[i]:
            q.append(i)
            vis[i] = True
            dist[i] = dist[now]+1
result = []
for i in range(1,n+1):
    if dist[i] == k:
        result.append(i)
if len(result) == 0:
    print(-1)
else:
    result.sort()
    for i in result:
        print(i)



