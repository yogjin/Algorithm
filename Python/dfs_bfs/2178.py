import sys
from collections import deque

input = sys.stdin.readline

n,m = map(int,input().split())
board = [list(map(int,input().rstrip())) for _ in range(n)]
x,y = 0,0 #시작위치
vis = [[False]*m for _ in range(n)]

q = deque()
q.append((x,y))
vis[x][y] = True
dx = [-1,1,0,0]
dy = [0,0,-1,1]
while q:
    x,y = q.popleft()
    for i in range(4):
        nx,ny = x+dx[i],y+dy[i]
        if 0 <= nx < n and 0 <= ny < m:
            if not vis[nx][ny] and board[nx][ny] != 0:
                board[nx][ny] = board[x][y] + 1
                q.append((nx,ny))
                vis[nx][ny] = True
print(board[n-1][m-1])
    