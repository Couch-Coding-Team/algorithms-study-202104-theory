def solution(clothes):
    hash_key = set([i[1] for i in clothes])
    
    fac = 1
    answer = len(clothes)
    while fac < len(hash_key):
        answer += (len(clothes) - fac)
        fac += 1
    return answer