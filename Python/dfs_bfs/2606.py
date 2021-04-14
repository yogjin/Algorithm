import sys
from collections import deque
input = sys.stdin.readline

N = int(input()) #컴퓨터의 수
M = int(input()) #컴퓨터 쌍의 수
li = [[] for _ in range(N+1)] #연결리스트
vis = [False]*(N+1) # 컴퓨터 방문여부
for _ in range(M):
    a,b = map(int,input().split())
    li[a].append(b)
    li[b].append(a)
def dfs(v):
    global cnt
    vis[v] = True
    for com in li[v]:
        if not vis[com]:
            dfs(com)
            cnt += 1
def bfs(v):
    global cnt
    q = deque([v])
    vis[v] = True
    while q:
        v = q.popleft()
        for com in li[v]:
            if not vis[com]:
                q.append(com)
                vis[com] = True
                cnt += 1
cnt = 0 #바이러스에 걸린 컴퓨터 수
dfs(1)
bfs(1)
print(cnt)