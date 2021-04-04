# 2021.04.04
# Park_YeongJin
# 시험 감독
# BOJ 13458
import sys
import math
input = sys.stdin.readline

n = int(input()) #시험장 수

#시험장
room = list(map(int,input().split()))
# b:총감독관 감시가능 학생수 c: 부감독관
b,c = map(int,input().split())

room = [i-b for i in room] #총감독관이 감시
result = n # 총감독관추가 
for students in room:
    #감시해야하는 학생이 남았으면 부감독관 추가
    if 0 < students:
        result += math.ceil(students/c)
print(result)
        