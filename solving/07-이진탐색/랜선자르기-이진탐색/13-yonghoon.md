```python
K, N = map(int, input().split())
nums = []
for _ in range(K):
    nums.append(int(input()))
start = 1
end = 2**32

while (start <= end):
    temp_N = 0
    length = (start+end)//2
    for num in nums:
        temp_N += num//length
    if (temp_N < N):
        end = length-1
    elif (temp_N >= N):
        ans = length
        start = length + 1
print(ans)
```
