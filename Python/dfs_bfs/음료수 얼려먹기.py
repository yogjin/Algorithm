# 2021.04.10
# Park_YeongJin
# 음료수 얼려먹기
# 이코테 p149
n,m = map(int,input().split())

board = []
vis = [[False]*m for _ in range(n)]
for _ in range(n):
    board.append(list(map(int,input())))
dx = [0,0,1,-1]
dy = [1,-1,0,0]
def dfs(board,vis,x,y):
    vis[x][y] = True
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if(0 <= nx and nx < n and 0 <= ny and ny < n):
            if not vis[nx][ny]:
                dfs(board,vis,nx,ny)
x,y = 0,0
cnt = 0
for i in range(n):
    for j in range(m):
        if board[i][j] == 0 and not vis[i][j]:
            dfs(board,vis,x,y)
            cnt += 1
print(cnt)

'''
input:
4 5
00110
00011
11111
00000
output: 3
'''