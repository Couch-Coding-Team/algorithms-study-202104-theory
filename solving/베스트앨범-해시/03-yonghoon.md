```python
import collections

def solution(genres, plays):
    dic = collections.defaultdict(list)
    temp = []
    ans = []

    # 1. 장르별 재생 횟수 추가
    for i in range(len(genres)):
        dic[genres[i]].append([i, plays[i]])  # 각 key값에 [고유 번호, 재생 횟수] append하기
        dic[genres[i]].sort(key=lambda x: (x[1]), reverse=True)  # 재생 횟수 기준으로 정렬
    # {'classic': [[3, 800], [0, 500], [2, 150]],'pop': [[4, 2500], [1, 600]]}


    # 2. 장르별 총 재생 횟수 합산
    for key in dic:
        sum = 0
        for arr in dic[key]:
            sum += arr[1]
        dic[key].insert(0, sum)
        temp.append(dic[key])
    # {'classic': [1450, [3, 800], [0, 500], [2, 150]], 'pop': [3100, [4, 2500], [1, 600]]}


    # 3. 합산된 재생 횟수 기준으로 장르순서 정렬(내림차순)
    temp.sort(key=lambda x: x[0], reverse=True)
    # [[3100, [4, 2500], [1, 600]], [1450, [3, 800], [0, 500], [2, 150]]]


    # 4. 정렬된 순서대로 장르별 두 개씩 ans에 추가
    for arrs in temp:
        for arr in arrs[1:3]:
            ans.append(arr[0])
    # [4, 1, 3, 0]
    return ans

```

