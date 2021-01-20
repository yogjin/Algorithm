# 알고리즘 마스터리

```c
#include <stdio.h>

int main(void) {
  printf("Hello World!");
}
```
[간단한 md 편집법](https://ndb796.tistory.com/194)

## 구현

## Greedy

## BFS/DFS

### 1. 배열 초기화
```
int[][] dist = new int[4][4];
for(int i = 0; i < dist.length; i++){
  Arrays.fill(dist[i], -1);
}
```
위 방법으로 2차원 배열 초기화가 가능하다.
(거리계산하는 dist배열)
### 2. 루프탈출
```
loop:
while(true){
  ...
  ...
  for(true){
    if(true){
      break loop;
    }
  }
}
``` 
위와같이 원하는 루프를 탈출할 수 있다!

### 3. bfs의 정의
BFS를 하기 위해서는 **모든 간선의 가중치가 동일해야 한다**는 전제 조건이 필요하다!
예시로 [BOJ_13549 숨바꼭질3](https://www.acmicpc.net/board/view/38887) 문제는 
간선의 가중치가 달라 일반 BFS는 풀수없다.
> 다익스트라
벨만 포드
플로이드 와샬
0-1 BFS: 가중치가 0인 간선에 연결된 정점은 큐의 맨 뒤가 아닌 맨 앞에 넣는 방법

위 알고리즘은 간선의 가중치가 달라도 최단거리를 구할 수 있다.
## DP

## 정렬

## 이진 탐색
>'max,min,mid의 자료형을 long으로 두자.
## 최단 경로

## 그래프

