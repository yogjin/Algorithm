# BOJ 경사로
n, L = map(int, input().split())
li = []
for _ in range(n):
    li.append(list(map(int, input().split())))

def go(a):
    vis = [False]*n
    for i in range(1,n):
        if a[i-1] != a[i]:
            diff = abs(a[i]-a[i-1])
            if diff > 1:
                return False
            if a[i-1] < a[i]: ## 2,2,3
                for j in range(1,L+1):
                    if i-j < 0:
                        return False
                    if a[i-j] != a[i-1]:
                        return False
                    if vis[i-j]:
                        return False
                    vis[i-j] = True
            if a[i-1] > a[i]: # 3,2,2
                for j in range(L):
                    if i+j >= n:
                        return False
                    if a[i+j] != a[i]:
                        return False
                    if vis[i+j]:
                        return False
                    vis[i+j] = True
    return True

ans = 0
# 가로
for i in range(n):
    a = li[i]
    if go(a):
        ans += 1
# 세로
for i in range(n):
    a = []
    for j in range(n):
        a.append(li[j][i])
    if go(a):
        ans += 1
print(ans)