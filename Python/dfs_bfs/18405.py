import sys
import copy
from collections import deque
from itertools import combinations

input = sys.stdin.readline

n,k = map(int,input().split())
board = []
for _ in range(n):
    line = list(map(int,input().split()))
    board.append(line)
#S초 뒤에 X,Y에 존재하는 바이러스 종류 출력
S,X,Y = map(int,input().split())

virus = []#바이러스 종류 : (번호,i,j,sec)
for i in range(n):
    for j in range(n):
        if board[i][j] > 0:
            virus.append((board[i][j],i,j,0))
virus.sort()
q = deque()
for v in virus:
    q.append(v)
sec = 0#바이러스가 생성될때 시간
#상하좌우
dx = [1,-1,0,0]
dy = [0,0,-1,1]
while q:
    now = q.popleft()
    vi_num = now[0] #현재 바이러스 번호
    x,y = now[1],now[2] #현재 바이러스 좌표
    sec_now = now[3]
    if sec_now == S:
        print(board[X-1][Y-1])
        break
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if nx < 0 or n <= nx or ny < 0 or n <= ny:#범위초과
            continue
        if board[nx][ny] > 0:#이미 바이러스가 있는경우
            continue
        board[nx][ny] = vi_num
        q.append((vi_num,nx,ny,sec_now+1))
# 주어진시간이 지나기 전에 바이러스가 다 퍼지는 경우
if sec_now < S:
    print(board[X-1][Y-1])
