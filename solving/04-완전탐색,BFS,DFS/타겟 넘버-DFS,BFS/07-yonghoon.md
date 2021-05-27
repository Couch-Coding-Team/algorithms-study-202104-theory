```python
def solution(numbers, target):
    maps = []
    ans = [0]
    for number in numbers:
        maps.append([number,-number])
    
    def dfs(maps, path):
        if (len(path) == len(numbers)):
            if (sum(path) == target):
                ans[0] += 1
            return
        for num in maps[0]:
            dfs(maps[1:], path+[num])
    dfs(maps,[])
    return ans[0]
```
