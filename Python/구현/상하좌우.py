# 2021.04.05
# Park_YeongJin
# 상하좌우
# 이코테 p110

n = int(input())#공간의 크기. nxn
x,y = 1,1 #좌표
plans = input().split()
# L, R, U, D 순서
dx = [0,0,-1,1]
dy = [-1,1,0,0]
move_types = ['L','R','U','D']

for plan in plans:
  i = move_types.index(plan)
  nx = x+dx[i]
  ny = y+dy[i]
  if nx < 1 or ny < 1 or n < nx or n < ny: #범위무시
    continue
  x,y = nx,ny #이동
print(x,y)