import sys
from collections import deque
input = sys.stdin.readline

t = int(input())
def bfs(board,l,x,y,fx,fy):
    dx = [-2,-1,1,2,2,1,-1,-2]
    dy = [1,2,2,1,-1,-2,-2,-1]
    q = deque()
    q.append((x,y))
    board[x][y] = 1
    while q:
        x,y = q.popleft()
        if x == fx and y == fy:
            return board[x][y]-1
        for i in range(8):
            nx,ny = x+dx[i],y+dy[i]
            if 0 <= nx < l and 0 <= ny < l:
                if board[nx][ny] == 0:
                    board[nx][ny] = board[x][y] + 1
                    q.append((nx,ny))
    print(board)    
for _ in range(t):
    l = int(input())#체스판의 한 변의 길이
    board = [[0]*l for _ in range(l)]
    x,y = map(int,input().split()) #현재 있는 칸
    fx,fy = map(int,input().split()) #나이트가 이동하려는 칸
    print(bfs(board,l,x,y,fx,fy))
        