# BOJ 이모티콘
from collections import deque
import sys
input = sys.stdin.readline
n = int(input())
d = [[-1]*(n+1) for _ in range(n+1)]
d[1][0] = 0 # s,c == 개수,클립보드
q = deque()
q.append((1,0)) # (이모티콘개수, 클립보드내용)

while q:
    s,c = q.popleft()
    if d[s][s] == -1:
        d[s][s] = d[s][c]+1
        q.append((s,s))
    if s+c <= n and d[s+c][c] == -1:
        d[s+c][c] = d[s][c]+1
        q.append((s+c,c))
    if s-1 >= 0 and d[s-1][c] == -1:
        d[s-1][c] = d[s][c]+1
        q.append((s-1,c))
ans = [i for i in d[n] if i != -1]
print(min(ans))
