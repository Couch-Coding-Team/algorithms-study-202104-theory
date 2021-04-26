Heap(힙)
========
### 1. 힙이란?
* 데이터에서 최댓값과 최솟값을 빠르게 찾기 위해 고안된 완전 이진트리 형태의 자료구조

### 2. 기본 구조
* 힙은 2가지이 구조를 가질 수 있습니다.
* Max Heap(최대힙): 각 부모노드는 자식노드들 보다 항상 크거나 최소한 같다.
* Min Heap(최소힙): 각 부모노드는 자식노드들 보다 항상 작거나 최소한 같다.

![heap](https://user-images.githubusercontent.com/31922462/116085210-8c7c4300-a6d9-11eb-9966-e4c44af6014d.png)

### 3. 힙의 구현
* 힙을 저장하는 표준적인 자료구조는 배열이다.
* 구현을 쉽게 하기 위하여 배열의 첫 번째 인덱스인 0은 사용되지 않는다.
* 특정 위치의 노드 번호는 새로운 노드가 추가되어도 변하지 않는다.
  - 예를 들어 루트 노드의 오른쪽 노드의 번호는 항상 3이다.
* 힙에서의 부모 노드와 자식 노드의 관계
  - 왼쪽 자식의 인덱스 = (부모의 인덱스) * 2
  - 오른쪽 자식의 인덱스 = (부모의 인덱스) * 2 + 1
  - 부모의 인덱스 = (자식의 인덱스) / 2

![heap2](https://user-images.githubusercontent.com/31922462/116085840-31971b80-a6da-11eb-83b5-4c6f6596c636.png)

### 4. 힙을 사용하면 좋을 때
* 데이터가 지속적으로 정렬이 되어야 할 때
* 데이터의 삽입 / 삭제가 빈번히 일어날 때

### 5. 파이썬에서의 Heap
* Python에서의 Heap은 heapq 모듈과 Queue 모듈의 PriorityQueue 클래스를 통해 heapq를 제공한다. 단, MinHeap으로 구현되어 있어 가장 앞에 있는 원소가 가장 작은 원소가 된다.

#### 5-1 heapq - heapify
* heapq 모듈의 heapify 함수는 주어진 리스트를 힙 정렬할 때 사용한다. 이떄의 시간복잡도는 O(nlogn)이다.
```python
import heapq

my_list = [3, 2, 1, 5, 7]
heapq.heapify(my_list) #[1,2,3,5,7]
```
#### 5-2 heapq - heappop(heap)
* heapq 모듈에서의 heappop 함수는 힙 정렬된 리스트에서 아래와 같은 역할을 한다.
1. 가장 작은 원소를 빼낸다.
2. 나머지 언소가 힙을 유지하도록 정렬한다.
```python
import heapq
my_list = [13, 2, 1, 5, 10]
heapq.heapify(my_list)

# 가장 작은 원소인 1이 리턴됩니다. my_list의 길이가 하나 줄어듭니다.
ret_val = heapq.heappop(my_list)

print("리턴된 값:", ret_val) # 1
print("남은 원소:", my_list) # [2,5,13,10]
```
#### 5-3 heapq - heappush(heap, item)
* heap 모듈에서의 heappush 함수는 리스트의 힙 상태를 유지하며, 데이터를 삽입시켜 준다. 
```python
import heapq
my_list = [13, 2, 1, 5, 10]
heapq.heapify(my_list)

# 7 삽입
heapq.heappush(my_list, 7)

# 기존에 가장 작았던 원소가 계속 앞에 위치
print("남은 원소:", my_list)
# 남은 원소: [1, 2, 7, 5, 10, 13]
```
#### 5-4 heapq - 가장 작은 원소에 접근하는 방법
* heap 리스트에서 가장 작은 원소를 삭제하지 않고 단순히 읽기만 사용할 때 리스트와 같이 사용할 수 있다.
```python
import heapq
my_list = [13, 2, 1, 5, 10]
heapq.heapify(my_list)

# heappop을 하지만, 맨 앞 원소가 최솟값임은 변하지 않음
while my_list:
    print("리스트의 맨 앞 원소:", my_list[0])
    heapq.heappop(my_list)

'''
리스트의 맨 앞 원소: 1
리스트의 맨 앞 원소: 2
리스트의 맨 앞 원소: 5
리스트의 맨 앞 원소: 10
리스트의 맨 앞 원소: 13
'''
```

#### 5-5 heapq - 최대 힙(Max Heap) 구현하기
* heapq는 최소 힙이라는 것을 이용하여 모든 값에 -를 붙여 -최댓값이 쇠솟값이 되도록 구현할 수 있다.
```python
import heapq

nums = [5,1,10,13,2]
heap = []

for num in nums:
  heapq.heappush(heap, (-num, num))  # (우선 순위, 값)

while heap:
  print("리스트의 맨 앞 원소 :", heapq.heappop(heap)[1])  # index 1
  
'''
리스트의 맨 앞 원소: 13
리스트의 맨 앞 원소: 10
리스트의 맨 앞 원소: 5
리스트의 맨 앞 원소: 2
리스트의 맨 앞 원소: 1
'''
```
#### 5-6 k번째 최솟값 / 최댓값 구하기
* heap을 사용하여 k번째의 최솟값, 최댓값을 효율적으로 구할 수 있다.
```python
import heapq

def kth_smallest(nums, k):
  heap = []
  for num in nums:
    heapq.heappush(heap, num)

  kth_min = None
  for _ in range(k):
    kth_min = heapq.heappop(heap)
  return kth_min

print(kth_smallest([4, 1, 7, 3, 8, 5], 3)) # 4
```

