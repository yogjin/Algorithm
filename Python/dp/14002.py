# 2022.1.5
# BOJ 14002 가장 긴 증가하는 부분 수열 4
n = int(input())
a = list(map(int, input().split()))
d = [1] * n
before = [-1] * n # before[i] = d[i] 전에 온 수의 인덱스 저장
idx = 0 # 가장 긴 수열의 맨 뒷자리 인덱스
for i in range(n):
    for j in range(i):
        if a[j] < a[i]:
            if d[i] < d[j] + 1:
                d[i] = d[j] + 1
                before[i] = j
                if d[idx] < d[i]:
                    idx = i
# 출력
def printSeq(idx):
    if idx == -1:
        return
    printSeq(before[idx])
    print(a[idx],end=" ")
    return
print(d[idx])
printSeq(idx)

