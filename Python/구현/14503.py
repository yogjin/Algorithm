# BOJ 로봇청소기
n, m = map(int, input().split())
r, c, d = map(int, input().split())
li = []
for _ in range(n):
    li.append(list(map(int, input().split())))


def check(d, r, c, li):
    # 갈곳 없거나 벽이거나 청소이미 했으면 False
    if d == 0:
        if li[r - 1][c] > 0:
            return False
    if d == 1:
        if li[r][c + 1] > 0:
            return False
    if d == 2:
        if li[r + 1][c] > 0:
            return False
    if d == 3:
        if li[r][c - 1] > 0:
            return False
    return True


def move(d, r, c):
    if d == 0:
        return (r - 1, c)
    if d == 1:
        return (r, c + 1)
    if d == 2:
        return (r + 1, c)
    if d == 3:
        return (r, c - 1)


def back(d, r, c, li):
    if d == 0 and li[r+1][c] != 1:
        return (r + 1, c)
    if d == 1 and li[r][c-1] != 1:
        return (r, c - 1)
    if d == 2 and li[r-1][c] != 1:
        return (r - 1, c)
    if d == 3 and li[r][c+1] != 1:
        return (r, c + 1)
    return (-1, -1)


ans = 0
while True:
    # 1번
    if li[r][c] == 0:  # 청소 안했으면 청소
        li[r][c] = 2
        ans += 1
    # 2번
    cnt = 0
    while cnt < 4:
        d = (d + 3) % 4
        if check(d, r, c, li):
            r, c = move(d, r, c)  # 이동
            break
        cnt += 1
    if cnt == 4:
        r, c = back(d, r, c, li)
        if (r, c) == (-1, -1):
            break
print(ans)

