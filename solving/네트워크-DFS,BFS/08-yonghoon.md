```python
def solution(n, computers):
    ans = 0
    def dfs(i, j):
        computers[i][j] = 0
        new_i = j
        for new_j in range(n):
            if (computers[new_i][new_j] == 1):
                dfs(new_i, new_j)
        return
    for i in range(n):
        for j in range(n):
            if (computers[i][j] == 1):
                ans += 1
                dfs(i, j)
    return ans
```
