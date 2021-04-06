# 2021.04.06
# Park_YeongJin
# 왕실의 나이트
# 이코테 p115

s = input()
x,y = s[0],int(s[1]) #열,행
x = ord(x)-ord('a')+1 #알파벳-> 숫자

dx = [-2,-2,-1,1,2,2,-1,1]
dy = [-1,1,-2,-2,-1,1,2,2]

cnt = 0
for i in range(8):
  nx = x + dx[i]
  ny = y + dy[i]
  if nx < 1 or 8 < nx or ny < 1 or 8 < ny:
    continue
  cnt += 1
print(cnt)