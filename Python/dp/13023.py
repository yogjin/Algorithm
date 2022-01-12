# BOJ ABCDE
n,m = map(int,input().split())
e = [[] for _ in range(n)]
for _ in range(m):
    a,b = map(int,input().split())
    e[a].append(b)
    e[b].append(a)

def dfs(i,vis,dist):
    global ans
    if dist == 4:
        ans = 1
        print(ans)
        exit()
    for nt in e[i]:
        if not vis[nt]:
            vis[i] = True
            dfs(nt,vis,dist+1)
            vis[i] = False
ans = 0
for i in range(n):
    vis = [False]*n
    dfs(i,vis,0)
print(ans)