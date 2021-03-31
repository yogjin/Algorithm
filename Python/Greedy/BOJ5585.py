# 2021.03.31(수)
# Park_YeongJin
# 거스름돈

n = int(input())
n = 1000-n
coin_types = [500,100,50,10,5,1] #동전 종류

count = 0 #잔돈 개수
for coin in coin_types:
    count += n//coin
    n %= coin
print(count)

