# 드래곤커브
n = int(input())
c = [[False] * 101 for _ in range(101)]  # 꼭짓점 방문여부
dx = [1,0,-1,0]
dy = [0,-1,0,1]
for _ in range(n):
    dragon = []  # 방향: 0:(1,0),1:(0,-1),2:(-1,0),3:(0,1)
    x, y, d, g = map(int, input().split())
    dragon.append(d)
    for _ in range(g):
        for i in dragon[::-1]:  # 거꾸로 순회
            i = (i + 1) % 4  # 반시계 90도 회전
            dragon.append(i)
    # 방향 다 구한다음 한번에 방문처리
    c[x][y] = True # 처음 꼭짓점
    for i in dragon:
        x,y = x+dx[i],y+dy[i]
        c[x][y] = True
ans = 0
for i in range(100):
    for j in range(100):
        if c[i][j] and c[i + 1][j] and c[i][j + 1] and c[i + 1][j + 1]:
            ans += 1
print(ans)

