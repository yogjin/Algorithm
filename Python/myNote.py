#기본모듈
import sys
import copy
from collections import deque
from itertools import combinations
from itertools import permutations
input = sys.stdin.readline

def solve():
    #여기에 main코드 작성
if __name__ == '__main__':
    solve()
'''
Python시간 줄이기:
전체를 함수 안에 넣는다.(놀랍게도 전역변수 참조가 지역변수 참조보다 느려서 이게 큰 효과가 있는 코드가 많습니다.)
'''
#2차원 배열을 90도 회전시킨다.
def rotated_90(array_2d):
    list_of_tuples = zip(*array_2d[::-1])
    return [list(elem) for elem in list_of_tuples]
'''
a = [
[1,4,7],
[2,5,8],
[3,6,9]
]
> rotated_90(a)
[
[3,2,1],
[6,5,4],
[9,8,7]
]
'''
#입력값 2차원 리스트 한줄로 받기(리스트내포)
board = [list(map(int,input().split().rstrip())) for _ in range(n)] #n개의 행을 입력받을때 
'''
input:
    1 2 3
    4 5 6
    7 8 9
board:
    [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
'''