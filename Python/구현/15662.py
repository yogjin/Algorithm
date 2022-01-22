# BOJ 톱니바퀴 (2)

from collections import deque
t = int(input())
a = [[0, 0, 0, 0, 0, 0, 0, 0]]  # 안쓰는 톱니하나 추가 톱니범위 1 <= n <= t
for _ in range(t):
    a.append(list(map(int, input())))  # 톱니

k = int(input())
for _ in range(k):
    i, d = map(int, input().split())  # 회전시킨 톱니번호, 방향
    q = deque()
    q.append((i, -1, d))  # -1: 맨처음 톱니
    while q:
        i, j, d = q.popleft()  # 움직인톱니, 영향준톱니, 방향
        if j == -1:  # 맨 처음
            if 1 <= i - 1 <= t and a[i][6] != a[i - 1][2]:  # 왼쪽톱니와 비교
                q.append((i - 1, i, -d))
            if 1 <= i + 1 <= t and a[i][2] != a[i + 1][6]:  # 오른쪽톱니와 비교
                q.append((i + 1, i, -d))
        else:
            if i < j:  # 오른쪽 톱니가 영향을 준 경우
                if 1 <= i - 1 <= t and a[i][6] != a[i - 1][2]:  # 왼쪽톱니와 비교
                    q.append((i - 1, i, -d))
            else:  # 왼쪽톱니가 영향 준 경우
                if 1 <= i + 1 <= t and a[i][2] != a[i + 1][6]:  # 오른쪽톱니와 비교
                    q.append((i + 1, i, -d))
        # 톱니 움직이기
        tmp = [0,0,0,0,0,0,0,0]
        if d == -1:  # 반시계 idx -> idx-1
            for idx in range(1,8):
                tmp[idx-1] = a[i][idx]
            tmp[7] = a[i][0]
        else:
            for idx in range(0,7):
                tmp[idx+1] = a[i][idx]
            tmp[0] = a[i][7]
        a[i] = tmp

ans = 0
for i in a:
    if i[0] == 1:
        ans += 1
print(ans)

