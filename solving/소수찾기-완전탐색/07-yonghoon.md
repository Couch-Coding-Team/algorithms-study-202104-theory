```python
import itertools
import math

def solution(numbers):
    def is_prime(x):
        if x<2: return False
        for i in range(2,int(math.sqrt(x))+1):
            if x%i==0: return False
        return True
    answer = 0
    arrs = []
    nums = set()
    for i in range(1, len(numbers)+1):
        arrs += (list(map(list, itertools.permutations(numbers,i))))
    for arr in arrs:
        empty = ""
        for num in arr:
            empty += num
        nums.add(int(empty))
    for num in nums:
        if(is_prime(num)): answer += 1
    return answer
```
