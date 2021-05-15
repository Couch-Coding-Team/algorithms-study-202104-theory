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


```python
# 정확성 테스트 통과까지 걸린 시간 : 25분
# 새로운 아이디어 생각 결정짓는데 까지 걸린 시간 : 25~53분
# 풀이 완료 : 2시간
import collections
def solution(routes):
    routes.sort()
    ans = 0
    dic = dict()
    dic[0] = [routes[0][0],routes[0][1]]
    for route in routes:
        x1 = route[0]
        y1 = route[1]
        is_nested = False
        for key in dic:
            x2 = dic[key][0]
            y2 = dic[key][1]
            if (y1 == x2):
                dic[key] = [y1,y1]
                is_nested = True
            elif (x1<=x2<=y1 and y1<=y2):
                dic[key] = [x2,y1]
                is_nested = True
            elif (x1<x2 and y2<y1):
                dic[key] = [x2,y2]
                is_nested = True
            elif (x2<=x1<=y2 and y2<=y1):
                dic[key] = [x1,y2]
                is_nested = True
            elif (x1 == y2):
                dic[key] = [y2,y2]
                is_nested = True
            elif (x1>x2 and y2>y1):
                dic[key] = [x1,y1]
                is_nested = True
        if (is_nested == False):
            dic[len(dic)] = [x1,y1]  
    return len(dic)
```
