# 2021.04.06
# Park_YeongJin
# 럭키 스트레이트
# BOJ18406

n = input()

i = int(len(n)/2)
sum_left,sum_right = 0,0
for l in range(0,i):
    sum_left += int(n[l])
for r in range(i,len(n)):
    sum_right += int(n[r])
if sum_left == sum_right:
    print("LUCKY")
else:
    print("READY")