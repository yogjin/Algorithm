# BOJ 이분그래프
from collections import deque
import sys
input = sys.stdin.readline
k = int(input())
for _ in range(k):
    v, e = map(int, input().split())
    li = [[] for _ in range(v + 1)]
    vis = [0] * (v + 1)  # 0: 방문x 1: A집합 2: B집합
    for _ in range(e):
        a, b = map(int, input().split())
        li[a].append(b)
        li[b].append(a)
    ans = "YES"
    for i in range(1, v + 1):
        if not vis[i]:
            q = deque()
            q.append(i)
            vis[i] = 1
            while q:
                now = q.popleft()
                for nt in li[now]:
                    if vis[nt] == vis[now]:
                        ans = "NO"
                        break
                for nt in li[now]:
                    if not vis[nt]:
                        q.append(nt)
                        if vis[now] == 1:
                            vis[nt] = 2
                        else:
                            vis[nt] = 1
    print(ans)

