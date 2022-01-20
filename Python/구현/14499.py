# BOJ 주사위구현
from collections import deque

n, m, x, y, k = map(int, input().split())
a = []
for _ in range(n):
    a.append(list(map(int, input().split())))
q = list(map(int, input().split()))
dx = [0, 0, 0, -1, 1]
dy = [0, 1, -1, 0, 0]
dice = [0, 0, 0, 0, 0, 0, 0]


def go(dice, cmd):
    tmp = [0] * 7
    if cmd == 1:  # 동쪽
        tmp[3] = dice[1]
        tmp[2] = dice[2]
        tmp[6] = dice[3]
        tmp[1] = dice[4]
        tmp[5] = dice[5]
        tmp[4] = dice[6]
    elif cmd == 2:  # 서쪽
        tmp[4] = dice[1]
        tmp[2] = dice[2]
        tmp[1] = dice[3]
        tmp[6] = dice[4]
        tmp[5] = dice[5]
        tmp[3] = dice[6]
    elif cmd == 3:  # 북쪽
        tmp[2] = dice[1]
        tmp[6] = dice[2]
        tmp[3] = dice[3]
        tmp[4] = dice[4]
        tmp[1] = dice[5]
        tmp[5] = dice[6]
    else:
        tmp[5] = dice[1]
        tmp[1] = dice[2]
        tmp[3] = dice[3]
        tmp[4] = dice[4]
        tmp[6] = dice[5]
        tmp[2] = dice[6]
    return tmp


q = deque(q)
while q:
    cmd = q.popleft()
    nx, ny = x + dx[cmd], y + dy[cmd]
    if 0 <= nx < n and 0 <= ny < m:
        x, y = nx, ny  # 이동
        dice = go(dice, cmd)
        if a[x][y] == 0:
            a[x][y] = dice[6]
        else:
            dice[6] = a[x][y]
            a[x][y] = 0
        print(dice[1])

