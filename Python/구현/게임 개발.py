# 2021.04.06
# Park_YeongJin
# 게임 개발
# 이코테 p118

n,m = map(int,input().split()) #세로,가로
x,y,d = map(int,input().split()) #캐릭터위치 x,y (세로,가로) 방향 d

board = [] #육지:0 바다:1
for _ in range(n):
  line = list(map(int,input().split()))
  board.append(line)

#방문여부
vis = [[0]*n for _ in range(m)]
vis[x][y] = 1
#d 방향 0:북 1:동 2:남 3:서 기준 직진하는 dx,dy
dx = [-1,0,1,0]
dy = [0,1,0,-1]
#왼쪽으로 회전
def turn_left():
  global d
  if d == 0:
    d = 3
  else:
    d -= 1
turn_cnt = 0 #회전횟수
result = 1 #방문한 칸의 수(처음에 위치한 칸은 항상 육지)
while True:
  turn_left()
  nx = x + dx[d]
  ny = y + dy[d]
  #앞칸이 육지이고 방문하지 않았다면 직진
  if board[nx][ny] == 0 and vis[nx][ny] == 0:
    vis[nx][ny] = 1 #방문처리
    x,y = nx,ny
    turn_cnt = 0 #회전횟수 초기화 
    result += 1
  #왼쪽방향으로 회전만 수행
  else:
    turn_cnt += 1
  #네칸 다 못가는 경우 후진
  if turn_cnt == 4:
    nx = x - dx[d]
    ny = y - dy[d]
    #뒤쪽이 바다면 움직임을 멈춘다
    if board[nx][ny] == 1:
      break
    x,y = nx,ny
    turn_cnt = 0
print(result)

'''
input:
4 4
1 1 0
1 1 1 1
1 0 0 1
1 1 0 1
1 1 1 1

output : 3
'''