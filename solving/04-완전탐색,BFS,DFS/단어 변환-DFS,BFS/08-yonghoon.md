```python
import collections
def solution(begin, target, words):
    parents = [begin]
    graph = collections.defaultdict(list)
    ans = []
    while (parents):
        childs = []
        for parent in parents:
            for child in words:
                if (child in graph): continue
                count = 0
                for i in range(len(parent)):
                    if (parent[i] != child[i]):
                        count += 1
                if (count == 1 and child not in parents):
                    graph[parent].append(child)
                    if (child not in childs): childs.append(child)
        parents = childs
    def dfs(key, depth):
        if (key not in graph): return
        else:
            depth += 1
            for child in graph[key]:
                if (child == target):
                    ans.append(depth)
                    return
                else: dfs(child, depth)
    dfs(begin, 0)
    if (ans): return ans[0]
    else: return 0
```
