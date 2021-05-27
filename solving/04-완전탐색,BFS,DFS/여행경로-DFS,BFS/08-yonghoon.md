```python
import collections

def solution(tickets):
    graph = collections.defaultdict(list)
    ans = []
    for key, value in tickets:
        graph[key].append(value)
        graph[key].sort()
    def dfs(key):
        while(graph[key]):
            dfs(graph[key].pop(0))
        ans.append(key)
    dfs("ICN")
    return ans[::-1]
```
