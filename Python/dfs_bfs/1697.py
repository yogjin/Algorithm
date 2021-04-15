import sys
from collections import deque
input = sys.stdin.readline

#수빈위치,동생위치
N,K = map(int,input().split())

def solve(N,K):
    if N == K:
        return 0
    elif K < N:
        return N-K
    else:
        vis = [False] * 100001
        s = [0] * 100001
        q = deque()
        q.append(N)
        vis[N] = True
        while q:
            now = q.popleft()
            if 0 <= now-1 <= 100000:
                if not vis[now-1]:
                    vis[now-1] = True
                    q.append(now-1)
                    s[now-1] = s[now]+1
            if 0 <= now+1 <= 100000:
                if not vis[now+1]:
                    vis[now+1] = True
                    q.append(now+1)
                    s[now+1] = s[now]+1
            if 0 <= now*2 <= 100000:
                if not vis[now*2]:
                    vis[now*2] = True
                    q.append(now*2)
                    s[now*2] = s[now]+1
            if now+1 == K or now*2 == K or now-1 == K:
                return s[now]+1
print(solve(N,K))
