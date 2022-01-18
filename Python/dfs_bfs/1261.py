# BOJ 알고스팟
from collections import deque

m, n = map(int, input().split())  # 가로 세로
li = []
for _ in range(n):
    li.append(list(map(int, input())))
vis = [[False] * m for _ in range(n)]
dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]
q = deque()
q.append((0, 0, 0))  # 벽 부순횟수, x, y
vis[0][0] = True
while q:
    cnt, x, y = q.popleft()
    if x == n - 1 and y == m - 1:
        print(cnt)
        break
    for i in range(4):
        nx, ny = x + dx[i], y + dy[i]
        if 0 <= nx < n and 0 <= ny < m:
            if not vis[nx][ny]:
                if li[nx][ny] == 1:
                    q.append((cnt + 1, nx, ny))
                else:
                    q.appendleft((cnt, nx, ny))
                vis[nx][ny] = True


