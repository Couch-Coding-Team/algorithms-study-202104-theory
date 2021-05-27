```python
# 시간복잡도 O(kn) --> 시간 초과 발생
from collections import deque

def solution(number, k):
    nums = deque()
    ans = ""
    for num in number:
        nums.append(int(num))
    start = 0
    for _ in range(k):
        for i in range(len(nums)-1):
            if (nums[i] < nums[i+1]):
                del nums[nums.index(nums[i])]
                break
            if (i == len(nums)-2):
                nums.pop()
    for num in nums:
        ans += str(num)
    return ans
```
