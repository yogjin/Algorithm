def rotated_90(array_2d):
    list_of_tuples = zip(*array_2d[::-1])
    return [list(elem) for elem in list_of_tuples]
def check(lock_new,N):
    for i in range(N,2*N):
        for j in range(N,2*N):
            if lock_new[i][j] != 1:
                return False
    return True
def solution(key, lock):
    #key : M x M, lock : N x N
    N = len(lock)
    M = len(key)
    lock_new =[[0]*3*N for _ in range(3*N)]
    for i in range(0,N):
        for j in range(0,N):
            lock_new[N+i][N+j] = lock[i][j]
    
    for _ in range(4):#key 돌리기
        for i in range(0,2*N):
            for j in range(0,2*N):
                #key 넣기
                for x in range(M):
                    for y in range(M):
                        lock_new[i+x][j+y] += key[x][y]
                #key가 맞는지 확인
                if check(lock_new,N):
                    return True
                #key 빼기
                for x in range(M):
                    for y in range(M):
                        lock_new[i+x][j+y] -= key[x][y]
        key = rotated_90(key)
                
    return False