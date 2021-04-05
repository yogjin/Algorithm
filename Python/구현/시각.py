# 2021.04.05
# Park_YeongJin
# 시각
# 이코테 p113
n = int(input())

cnt = 0

for h in range(n+1):
  for m in range(60):
    for s in range(60):
      if '3' in str(h)+str(m)+str(s):
        cnt += 1
print(cnt)