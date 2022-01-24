# 숨바꼭질2
from collections import deque
n,k = map(int,input().split())
c = [False]*100001
q = deque()
q.append((n,0))
cnt = 0
ans = 10e9
while q:
    now,t = q.popleft()
    c[now] = True
    if t > ans:
        break
    if now == k:
        ans = t
        cnt += 1
    for nt in (now-1,now+1,2*now):
        if 0 <= nt <= 100000 and not c[nt]:
            q.append((nt,t+1))
print(ans)
print(cnt)