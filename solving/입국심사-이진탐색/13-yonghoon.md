```python
def solution(n, times):
    start = 1
    end = max(times)*n  # 여기 이해가 안감
    ans = 0
    while (start <= end):
        target = (start + end)//2
        n_temp = 0
        for time in times:
            n_temp += target // time
        if (n_temp >= n):
            ans = target
            end = target-1
        else:
            start = target+1
    return ans

```
