# BOJ 숨바꼭질 4
from collections import deque
n,k = map(int,input().split())
dist = [0]*100001
his = [-1]*100001 # 이전좌표
dist[n] = 1 # 초기화
q = deque()
q.append(n)
while q:
    now = q.popleft()
    if now == k:
        break
    for nt in (now-1,now+1,now*2):
        if 0 <= nt <= 100000 and dist[nt] == 0:
            q.append(nt)
            dist[nt] = dist[now]+1
            his[nt] = now
ans = deque()
i = k
while his[i] != -1:
    ans.appendleft(i)
    i = his[i]
ans.appendleft(n)
print(dist[k]-1)
print(" ".join(map(str,ans)))


