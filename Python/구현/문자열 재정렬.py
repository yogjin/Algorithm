# 2021.04.06
# Park_YeongJin
# 문자열 재정렬
# 이코테 p322

s = input()
alpha = []
sum = 0
for i in s:
  if i.isalpha(): #알파벳인지 판별
    alpha.append(i)
  else:
    sum += int(i)

alpha.sort()
if sum == 0:
  print(''.join(alpha))
else:
  print(''.join(alpha)+str(sum))


# input : K1KA5CB7
# output : ABCKK13
