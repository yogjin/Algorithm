# 2021.04.03
# Park_YeongJin
# 로프
# BOJ 2217
n = int(input())

ropes = []
for _ in range(n):
    ropes.append(int(input())) #각 로프
    
ropes.sort(reverse=True)
weight = 0

for i in range(n):
    weight = max(weight, ropes[i]*(i+1))
print(weight)