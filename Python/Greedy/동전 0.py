# 2021.04.02
# Park_YeongJin
# 동전 0
# BOJ 11047

n,k = map(int,input().split())

coins = []
for i in range(n):
    coin = int(input())
    coins.append(coin)
coins.sort(reverse=True)#내림차순 정렬

count = 0 #코인개수
for coin in coins:
    #k가 0이면 break
    if k == 0:
        break
    #현재코인 가격이 k원 보다 작으면 빼준다
    if coin <= k:
        count += int(k/coin)
        k -= coin*int(k/coin)

print(count)
        