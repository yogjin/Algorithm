# 2021.04.01(수)
# Park_YeongJin
# 문자열 뒤집기
# BOJ 1439

s = list(input())
s = [int(i) for i in s]
group0,group1 = 0,0
zero_flag,one_flag = True,True
for i in s:
    if i==0 and zero_flag:
        group0 += 1
        zero_flag = False
        one_flag = True
    elif i==1 and one_flag:
        group1 += 1
        one_flag = False
        zero_flag = True
print(min(group0,group1))