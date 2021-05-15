```python
def solution(n, costs):
    costs.sort(key=lambda x: x[2])
    ans = []
    def traversal(path, costs):
        if (len(path) == n-1):
            # 모든 섬이 연결되어있는지 확인만 하면 된다
            temp = [0 for _ in range(n)]
            ans_temp = 0
            for arr in path:
                temp[arr[0]] = 1
                temp[arr[1]] = 1
                ans_temp += arr[2]
            if (sum(temp) == n):
                ans.append(ans_temp)
        for arr in costs:
            traversal(path+[arr], costs[costs.index(arr)+1:])
    traversal([], costs)
    ans.sort()
    # print(ans)
    return ans[0]
```
