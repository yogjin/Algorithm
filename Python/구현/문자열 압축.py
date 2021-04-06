# 2021.04.06
# Park_YeongJin
# 문자열압축 : 2020 kakao 신입공채
# https://programmers.co.kr/learn/courses/30/lessons/60057?language=python3
# 이코테 p323

def solution(s):
    length = len(s)//2 #잘라낼 문자열 길이 : 문자열의 반 까지
    result = len(s)
    for i in range(1,length+1):
        string = s[0:i] #비교해 나갈 문자열
        cnt = 1 #반복된 문자열의 수
        now = [] #압축된 문자열 저장할 리스트
        for j in range(i,len(s)+i+1,i): #문자열 끝까지 i만큼 잘라낸다.  
            next_str = s[j:i+j] # i만큼 잘라낸 다음 문자열
            if string == next_str: #같으면 cnt++
                cnt += 1
            else: #앞 뒤 문자열이 다르면 압축불가능
                if cnt == 1: #압축된 문자열이 없는경우
                    now.append(string)
                    string = next_str
                else: #압축된 문자열인 경우
                    now.append(str(cnt)+string) #숫자+압축할문자열
                    string = next_str
                    cnt = 1
        result = min(result,len(''.join(now))) #압축된 문자열 비교후 작은것 저장
    return result