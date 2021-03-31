# 2021.03.31(수)
# Park_YeongJin
# 모험가 길드
n = int(input())

data = list(map(int,input().split()))
data.sort()

groups, count = 0,0 # 그룹수,현재 그룹의 사람수
for i in data:
  count += 1  #사람수
  if count >= i: #사람수가 현재 사람의 공포지수보다 크거나 같으면
    groups += 1
    count = 0 #사람수 초기화
print(groups)