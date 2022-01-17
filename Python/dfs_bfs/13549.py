# BOJ 숨바꼭질3
# 맨 처음 제출한 코드
# 0-1 bfs와는 다르게 큐에 순서대로 넣지만,
# 값을 큐에 넣기전에 if 조건검사를 하므로 문제없는듯..
from collections import deque
n,k = map(int,input().split())
MAX = 200001
d = [10e9]*MAX
d[n] = 0
q = deque()
q.append(n)
while q:
    now = q.popleft()
    if now == k:
        break
    for nt in (now-1,now+1):
        if 0 <= nt < MAX:
            if d[now]+1 < d[nt]:
                d[nt] = d[now]+1
                q.append(nt)
    if 0 <= now*2 < MAX:
        if d[now] < d[now*2]:
            d[now*2] = d[now]
            q.append(now*2)
print(d[k])

# --------------------------------------------------
# 0-1 bfs: 가장 효율적 O(V+E)
from collections import deque
n,k = map(int,input().split())
MAX = 200001
d = [10e9]*MAX
vis = [False]*MAX
d[n] = 0
q = deque()
q.append(n)
vis[n] = True
while q:
    now = q.popleft()
    if now == k:
        break
    if 0 <= now*2 < MAX and not vis[now*2]:
            d[now*2] = d[now]
            q.appendleft(now*2)
            vis[now*2] = True
    for nt in (now-1,now+1):
        if 0 <= nt < MAX and not vis[nt]:
            d[nt] = d[now]+1
            q.append(nt)
            vis[nt] = True
print(d[k])
#-----------------------------------------------------
# dijkstra
import heapq
n,k = map(int,input().split())
MAX = 200001
d = [10e9]*MAX

q = []
heapq.heappush(q,(0,n))
d[n] = 0
while q:
    dist,now = heapq.heappop(q)
    if d[now] < dist:
        continue
    for nt in (2*now,now+1,now-1):
        cost = dist + 1
        if nt == 2*now:
            cost = dist
        if 0 <= nt < MAX and cost < d[nt]:
            d[nt] = cost
            heapq.heappush(q,(cost,nt))
print(d[k])

