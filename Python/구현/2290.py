# LCD Test
s,n = map(int,input().split())
space = " "
dash = "-"
a = []
a.append(f'|{space*s}|')
a.append(f'{space*(s+1)}|')
a.append(f'|{space*(s+1)}')
a.append(f'{space}{dash*s}{space}')
a.append(f'{space*(s+2)}')

digit = [
    [3,0,4,0,3], # 0
    [4,1,4,1,4],
    [3,1,3,2,3],
    [3,1,3,1,3],
    [4,0,3,1,4],
    [3,2,3,1,3],
    [3,2,3,0,3],
    [3,1,4,1,4],
    [3,0,3,0,3],
    [3,0,3,1,3], # 9
]
def go(num):
    return a[num]
n = str(n)
for i in n:
    print(f'{go(digit[int(i)][0])}{space}', end= "")
print() # 줄 바꿈
for _ in range(1,(2*s+3)//2):
    for i in n:
        print(f'{go(digit[int(i)][1])}{space}', end= "")
    print()
for i in n:
    print(f'{go(digit[int(i)][2])}{space}', end="")
print()
for _ in range((2*s+3)//2+1,(2*s+3)-1):
    for i in n:
        print(f'{go(digit[int(i)][3])}{space}', end= "")
    print()
for i in n:
    print(f'{go(digit[int(i)][4])}{space}', end="")

