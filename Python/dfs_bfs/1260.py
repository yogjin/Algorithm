import sys
import copy
from collections import deque
from itertools import combinations
from math import gcd
input = sys.stdin.readline

n,m,v = map(int,input().split())

graph = [[] for _ in range(n+1)]
for _ in range(m):
    a,b = map(int,input().split())#양방향
    graph[a].append(b)
    graph[b].append(a)
#정점 번호가 작은 것을 먼저 방문->정점번호 오름차순으로 정렬
for i in graph:
    i.sort()
vis = [False]*(n+1)
def dfs(graph,v,vis):
    vis[v] = True
    print(v,end=' ')
    nodes = graph[v]
    for node in nodes:
        if not vis[node]:
            dfs(graph,node,vis)
def bfs(graph,v,vis):
    q = deque()
    q.append(v)
    vis[v] = True
    print(v,end=' ')
    while q:
        v = q.popleft()
        nodes = graph[v]
        for node in nodes:
            if not vis[node]:
                q.append(node)
                vis[node] = True
                print(node,end=' ')
dfs(graph,v,copy.deepcopy(vis))
print()
bfs(graph,v,vis)
        


    