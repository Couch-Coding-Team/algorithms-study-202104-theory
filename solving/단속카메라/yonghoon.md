```python
# 정확성 테스트 통과까지 걸린 시간 : 25분

def solution(routes):
    ans = 0
    min = sorted(routes, key=lambda x: x[0])[0][0]
    max = sorted(routes, key=lambda x: x[1], reverse = True)[0][1]
    while (routes):
        ans += 1
        meet_count = 0
        index_list = []
        for coord in range(min, max+1):
            meet_count_temp = 0
            index_list_temp = []
            for i in range(len(routes)):
                if (routes[i][0] <= coord <= routes[i][1]):
                    meet_count_temp += 1
                    index_list_temp.append(i)
                    if (meet_count_temp > meet_count):
                        meet_count = meet_count_temp
                        index_list = index_list_temp
        while (index_list):
            routes.pop(index_list.pop())
    return ans
```
