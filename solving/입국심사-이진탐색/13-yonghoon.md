```python
def solution(n, times):
    start = 1
    end = 1000000000*n
    ans = 0
    while (start <= end):
        target = (start + end)//2
        n_temp = 0
        for time in times:
            n_temp += target//time
        if (n_temp >= n):
            ans = target
            end = target-1
        if (n_temp < n):
            start = target+1
    return ans
```
