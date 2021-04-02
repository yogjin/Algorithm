# 2021.04.02
# Park_YeongJin
# ATM
# BOJ 11399

n = int(input())
times = list(map(int,input().split()))
times.sort()
sum_min = 0
for i in range(n):
    for j in range(i+1):
        sum_min += times[j]
print(sum_min)
