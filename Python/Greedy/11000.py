# 2021.04.04
# Park_YeongJin
# 강의실 배정
# BOJ 11000
import sys
import heapq

input = sys.stdin.readline

n = int(input())

tables = [] #수업들 (시작시간,끝나는시간)
#수업 입력
for _ in range(n):
    s,t = map(int,input().split())
    tables.append((s,t))
tables.sort() #시작시간 기준 정렬

q = [tables[0][1]] #현재 하고있는 수업들의 끝나는 시간:우선순위 큐: 첫원소 삽입
cnt = 1 #강의실 개수
for i in range(1,n-1):
    nc = tables[i] #다음수업
    # 다음수업의 시작시간이 현재 하고있는 수업의 끝나는시간보다 빠르면 강의실 더 필요하다
    if nc[0] < q[0]:
        cnt += 1
        heapq.heappush(q,nc[1])
    else:
        heapq.heappop(q)
        heapq.heappush(q,nc[1])
print(cnt)
