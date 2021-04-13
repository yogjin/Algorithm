#기본코드
import sys
import copy
from collections import deque
from itertools import combinations
input = sys.stdin.readline

#2차원 배열을 90도 회전시킨다.
def rotated_90(array_2d):
    list_of_tuples = zip(*array_2d[::-1])
    return [list(elem) for elem in list_of_tuples]