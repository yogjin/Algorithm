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
            #tuple 형식으로 이동방식을 넣어준다!
            for nt in ((now-1),(now+1),(now*2)):
                if 0 <= nt <= 100000:
                    if not vis[nt]:
                        q.append(nt)
                        vis[nt] = True
                        s[nt] = s[now]+1
                        if nt == K:
                            return s[now]+1
print(solve(N,K))
