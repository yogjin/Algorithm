import sys
input = sys.stdin.readline

def turn(C):
    global d
    if C == 'L':
        if d == 0: d = 3
        else: d -= 1
    else:
        if d == 3: d = 0
        else: d += 1
            
n = int(input()) # 보드의 크기
k = int(input()) # 사과의 개수

board = [[0]*n for _ in range(n)]

#사과 놓기
for _ in range(k):
    x,y = map(int,input().split()) #사과위치
    board[x-1][y-1] = 2
#뱀의 방향 변환 정보
l = int(input())
turn_info = []
for _ in range(l):
    X,C = input().split()
    X = int(X)
    turn_info.append((X,C))
    
x,y = 0,0 #뱀위치
d = 0 #뱀은 처음에 오른쪽을 향한다.
snake = []#뱀이 차지하는 공간을 좌표로 저장
snake.append((x,y))
dx = [0,1,0,-1] #동남서북 
dy = [1,0,-1,0]
sec = 0 #게임시작후 흐른시간
turn_index = 0
while True:
    nx,ny = x+dx[d],y+dy[d]
    if 0 <= nx and nx <= n-1 and 0 <= ny and ny <= n-1 and board[nx][ny] != 1:
        if board[nx][ny] == 2 : #사과가 있다면
            board[nx][ny] = 0
        else:#사과가 없다면 뱀꼬리 자르기
            previous = snake.pop(0) #뱀의 꼬리
            px,py = previous[0],previous[1]
            board[px][py] = 0
        snake.append((nx,ny))
        board[nx][ny] = 1
        x,y = nx,ny
    else:
        break
    sec += 1
    if turn_index < len(turn_info): #뱀의 회전
        if turn_info[turn_index][0] == sec:
            C = turn_info[turn_index][1]
            turn(C)
            turn_index += 1
print(sec+1)


    