```python
import collections

def solution(clothes):
    answer = 1
    dic = collections.defaultdict(int)
    for cloth in clothes:
        dic[cloth[1]] += 1  # cloth[1] == 의상의 종류
        # dic = {'headgear': 2, 'eyewear': 1}
    for key in dic:
        answer *= dic[key]+1
    return (answer-1)
```
