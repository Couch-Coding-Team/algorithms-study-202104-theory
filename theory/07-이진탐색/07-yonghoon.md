# Binary Search

"정렬된" 데이터를 매우 빠르게 찾을 수 있는 탐색 방법

## 1) 직관적인 이해

예시를 들어서 이해하는게 가장 빠릅니다!

![123123](/Users/yonghoonlee/Desktop/123123.png)

가장 중간이 되는 값을 찾고 목표가 되는 값을 비교하여 어떤 부분만을 다시 탐색할 것이냐 만을 결정하면 됨

비교를 한 번 시행할 때마다 데이터셋의 크기가 절반이 되므로 log_2n만큼의 횟수를 반복하면 된다

if (중앙값 == 목표값): 탐색끝, 중앙값의 인덱스 return

else if (중앙값 < 목표값): 중앙값의 바로 왼쪽 부분만 다시 탐색 시작

else if (중앙값 > 목표값): 중앙값의 바로 오른쪽 부분만 다시 탐색 시작



## 2) 코드 단위의 이해

### 2-1) recursion으로 구현

이분 탐색 자체가 재귀적인 성격이 있기 때문에 recursion으로 충분히 구현 가능

python의 경우 max recursion depth가 1000이지만, 이 수준에 걸리려면 데이터셋의 길이가 2^1000 = 10715086071862673209484250490600018105614048117055336074437503883703510511249361224931983788156958581275946729175531468251871452856923140435984577574698574803934567774824230985421074605062371141877954182153046474983581941267398767559165543946077062914571196477686542167660429831652624386837205668069376 정도 되어야 함(현실적으로 불가능)

```python
#1. recursion
nums = [-3, -2, 0, 0, 1, 2, 10, 12, 30, 77, 77, 100, 632, 700, 788]
target = 632

def bin_search(start, end):
    mid = (start + end)//2
    if (end == start and nums[mid] != target): return None	# 예외처리 필요함
    if (nums[mid] == target):
        return mid
    elif (nums[mid] < target):
        return bin_search(mid+1, end)
    elif (nums[mid] > target):
        return bin_search(start, mid-1)
ans = bin_search(0, len(nums)-1)
print(ans)
```



### 2-2) iteration으로 구현

while 문을 통해 마지막 하나의 원소를 남길 때까지 탐색을 진행한다

recursion과는 다르게 예외처리가 별도로 필요하지 않음

```python
#2. iteration
nums = [-3, -2, 0, 0, 1, 2, 10, 12, 30, 77, 77, 100, 632, 700, 788]
target = 632

start = 0
end = len(nums)-1
ans = None
while(start <= end):
    mid = (start + end)//2
    if (nums[mid] == target):
        ans = mid
        break
    elif (nums[mid] < target):
        start = mid+1
    elif (nums[mid] > target):
        end = mid-1
print(ans)
```

