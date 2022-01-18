# BOJ 배열 돌리기 3
n,m,r = map(int,input().split())
a = []

for _ in range(n):
    a.append(list(map(int,input().split())))
def get1(a):
    b = [[0]*m for _ in range(n)]
    for i in range(n):
        for j in range(m):
            b[i][j] = a[n-1-i][j]
    return b
def get2(a):
    b = [[0] * m for _ in range(n)]
    for i in range(n):
        for j in range(m):
            b[i][j] = a[i][m-1-j]
    return b
def get3(a):
    b = [[0] * n for _ in range(m)]
    for i in range(n):
        for j in range(m):
            b[j][n-1-i] = a[i][j]
    return b
def get4(a):
    b = [[0]*n for _ in range(m)]
    for i in range(n):
        for j in range(m):
            b[m-1-j][i] = a[i][j]
    return b
def get5(a):
    b = [[0]*m for _ in range(n)]
    for i in range(n):
        for j in range(m):
            if 0 <= i < n//2 and 0 <= j < m//2: # 1번 -> 2번
                b[i][j+m//2] = a[i][j]
            elif 0 <= i < n//2 and m//2 <= j: # 2번 -> 3번
                b[i+n//2][j] = a[i][j]
            elif n//2 <= i and m//2 <= j: # 3번 -> 4번
                b[i][j-m//2] = a[i][j]
            else: # 4번 -> 1번
                b[i-n//2][j] = a[i][j]
    return b
def get6(a):
    b = [[0] * m for _ in range(n)]
    for i in range(n):
        for j in range(m):
            if 0 <= i < n // 2 and 0 <= j < m // 2:  # 1번 -> 4번
                b[i+n//2][j] = a[i][j]
            elif 0 <= i < n // 2 and m // 2 <= j:  # 2번 -> 1번
                b[i][j-m//2] = a[i][j]
            elif n // 2 <= i and m // 2 <= j:  # 3번 -> 2번
                b[i-n//2][j] = a[i][j]
            else: # 4번 -> 3번
                b[i][j+m//2] = a[i][j]
    return b
cmd = list(map(int,input().split()))
for i in cmd:
    n, m = len(a), len(a[0])
    if i == 1:
        a = get1(a)
    elif i == 2:
        a = get2(a)
    elif i == 3:
        a = get3(a)
    elif i == 4:
        a = get4(a)
    elif i == 5:
        a = get5(a)
    else:
        a = get6(a)
for i in a:
    print(" ".join(map(str,i)))