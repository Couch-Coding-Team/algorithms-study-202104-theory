## 알고리즘 스터디 1주차 theory 과제(이용훈) - 2021.04.12

# 0. Overview

사실 자료구조를 처음 공부했을 때는 '도대체 이걸 왜 공부하지??' 라는 생각을 하였습니다. 선형 자료구조(stack, queue, linked list 등등) 이거 그냥 우리가 일상생활 속에서 충분히 경험하고 있는 개념이며, 이해하는데에 1시간도 안걸리는 것들인데 이걸 왜 굳이 두꺼운 책까지 봐가면서 공부를 해야하냐는 생각을 했습니다. 하지만 이런 생각은 최근에 들어서 문제풀이를 할 때 완전히 틀렸음을 알게 되었습니다. 그래서 이번 과제 역시 단순히 그 자료구조들의 개념을 이해하는 것에 더하여 해당 자료구조가 지닌 의의와 활용에 대하여 조사해 보았습니다. 저는 컴퓨터를 전공하지 않았고 개발 경험이 많지 않기에 잘못 알고있는 부분이 많다고 생각합니다. 그런 부분이 보인다면 곧바로 알려주세요!! 감사합니다:)

# 1. Queue에 관하여

## 1) queue의 직관적 이해

가장 직관적으로 이해하는 방법으로 줄 서기를 생각하면 될 것 같다. 먼저 온 사람이 가장 먼저 나가고, 늦게 온 사람이 가장 나중에 나가는 줄과 같다. 이러한 queue의 동작을 FIFO라 부르며 '뒤로 넣고 앞으로 뺀다' 라는 말로 queue를 표현하기도 한다

 

## 2) queue의 활용예시

•  FIFO data가 포함된 종류의 문제 해결

•  프린터 대기줄 처리

•  키보드 입력 버퍼 처리

•  simulation

•  encoding(or decoding) message(for example, ROT13 --> kind of caesar encryption)



## 3) queue ADT

| **Operation** | **Description**                  | **Time Complexity** |
| ------------- | -------------------------------- | ------------------- |
| enqueue       | 맨 앞(front에 새로운 데이터 추가 | O(1)                |
| dequeue       | 맨 뒤(rear)의 데이터 제거        | O(1)                |
| first         | 맨 앞(front)의 데이터 보기       | O(1)                |
| isEmpty       | queue가 비어있는지 점검          | O(1)                |
| size          | queue의 elements 갯수 점검       | O(1)                |

  

## 4) queue의 구현

##### 4-1) array, linked list로 구현

→ python은 동적 배열인 list가 있으므로 해당 구현은 제외 하겠습니다



##### 4-2) list()로 구현

→ python의 list를 활용하여 구현

```python
class Queue:
    def __init__(self):
        self.data = list()

    def enqueue(self, new_data):
        self.data.append(new_data)

    def dequeue(self):
        if (self.isEmpty()):
            print('unable to dequeue : it is empty')
            return
        else: return self.data.pop(0)

    def isEmpty(self):
        return (len(self.data) == 0)

    def first(self):
        if (self.isEmpty()):
            print('unable to first : it is empty')
            return
        else: return self.data[0]

    def size(self):
        return (len(self.data))
```

issue : dequeue 내부에 pop(0) 연산의 시간복잡도가 O(n)이다.

 

##### 4-3) deque library로 구현

→ list의 dequeue 시간복잡도 개선을 위해 deque로 구현

```python
from collections import deque

class Queue:
    def __init__(self):
        self.data = deque()

    def enqueue(self, new_data):
        self.data.append(new_data)

    def dequeue(self):
        if (self.isEmpty()):
            print('unable to dequeue : it is empty')
            return
        else: return self.data.popleft()

    def isEmpty(self):
        return (len(self.data) == 0)

    def first(self):
        if (self.isEmpty()):
            print('unable to first : it is empty')
            return
        else: return self.data[0]

    def size(self):
        return (len(self.data))
```

# 2. Stack에 관하여

## 1) stack의 직관적 이해

stack은 말 그대로 쌓는 것을 의미한다. queue가 수평적인 개념으로 이해하기에 쉬운 개념이었다면, stack은 수직적인 개념으로 이해하면 더 와닿는다. 우리가 물건을 '쌓는다'고 하면 밑에서부터 차곡차곡 위로 올리면서 쌓기 때문이다. 그리고 어떠한 자료를 꺼낼 때는 위에서부터 다시 차례대로 꺼내며 내려와야만 한다

 

## 2) stack의 활용 예시

•  LIFO data가 포함된 종류의 문제 해결

•  backtracking 동작 처리

•  수식 계산

•  에디터에서의 문법오류 점검

 

## 3) stack ADT

| **Operation** | **Description**                 | **Time Complexity** |
| ------------- | ------------------------------- | ------------------- |
| push          | 맨 위(top)에 새로운 데이터 추가 | O(1)                |
| pop           | 맨 위(top)의 데이터 제거        | O(1)                |
| peek          | 맨 앞(top)의 데이터 보기        | O(1)                |
| isEmpty       | stack이 비어있는지 점검         | O(1)                |
| isFull        | stack이 전부 차있는지 점검      | O(1)                |

 

## 4) stack 구현

##### 4-1) array, linked list로 구현

→ python은 동적 배열인 list가 있으므로 해당 구현은 제외 하겠습니다



##### 4-2) list()로 구현

→ python의 list를 활용하여 구현

```python
class Stack:
   def __init__(self):
     self.data = list()

   def push(self, new_data):
     self.data.append(new_data)

   def pop(self):
     if (self.is_empty()):
       print('unable to pop : it is empty')
       return
     return self.data.pop()

   def peek(self):
     if (self.is_empty()):
       print('unable to peek : it is empty')
       return
     return self.data[-1]

   def is_empty(self):
     return (len(self.data) == 0) 
```

# 3. 정렬

## 1) O(n^2)의 시간 복잡도를 갖는 알고리즘들

#### 1-1) bubble sort

→ 물방울이 수면위로 떠오르듯이 키 값이 높은 데이터들이 먼저 정렬되는 방법이다. 매우 직관적으로 이해할 수 있기 때문에 구현 역시 간단하다. 이미 어느정도 정렬되어있는 데이터 셋을 대상으로 실행할 경우 빠르게 정렬된다는 특징이 있다

```python
nums = [5,2,3,4,1]
for i in range(len(nums)):
    num = nums[i]
    for j in range(i+1, len(nums)):
        if (num > nums[j]):
            num = nums[j]
            nums[i], nums[j] = nums[j], nums[i]
print(nums)
```



#### 1-2) seletion sort

→  현재 가리키는 위치해야할 데이터를 찾아내는 정렬 방법이다. (오름차순의 경우) 가장 작은 값을 찾아내기 위해 나머지 데이터 셋을 탐색해야만 한다

```python
nums = [5,2,3,4,1]
for i in range(len(nums)):
    min_idx = i
    for j in range(i+1, len(nums)):
        if (nums[j] < nums[min_idx]):
            min_idx = j
    nums[i], nums[min_idx] = nums[min_idx], nums[i]
print(nums)
```

코드는 bubble sort와 비슷해보이지만, 스왑이 한 번씩만 이뤄지는 부분에서 차이가 있다



#### 1-3) insertion sort

→ 이미 정렬이 되어있는 것 처럼 생각하여 데이터의 본래 위치에 삽입하는 것으로 정렬을 진행하는 방법이다. 삽입이 일어날 때마다 데이터를 밀어줘야하는 오버헤드가 발생하게 된다

```python
nums = [5,2,3,4,1]
for i in range(1, len(nums)):
    key = nums[i]
    j = i - 1
    while (j >= 0 and key < nums[j]):
        nums[j+1] = nums[j]
        j -= 1
    nums[j+1] = key
print(nums)
```

 

## 2) O(logn)의 시간 복잡도를 갖는 알고리즘들

#### 2-1) Heap sort

•  기본개념 : 힙의 특성을 이용한 정렬 방법이다. 데이터를 전부 힙에 넣었다가 빼는걸로 정렬이 된다. 그래서 매우 간편하다

•  시간복잡도 : 힙은 데이터 삽입, 삭제가 각각 log_2n이므로  2log_2n--> O(log_2n)이 된다. 이걸 n번 하게 되므로 최종적으로는 O(nlog_2n)이 된다

```python
import heapq
nums = [5,2,3,4,1]
heap = []

for nums in nums:
    heapq.heappush(heap, num)
    
for _ in range(len(nums)):
    print(heapq.heappop(heap))
```

--> 백준 2751번 문제가 안풀리네요ㅠㅠ 

#### 2-2) Merge sort

•  기본개념 : divide & conquer라는 방식으로 정렬을 한다

•  단계별로 나누어서 d&q 이해하기

1단계) 분할(Divide) : 해결이 쉬운 단계까지 문제를 분할해 나간다

2단계) 정복(Conquer) : 앞서 분할된 문제를 해결한다

3단계) 결합(Combine) : 앞서 해결한 문제를 결합한다

  •  병합 정렬은 데이터가 1개만 남을 때까지 분할해나간다. 1개만 남게되면 그 비교조차 할 필요가 없는 가장 쉬운 단계가 되기 때문이다

  •  분할 비용보다는 병합 비용이 크다

  •  비교 횟수에 대한 시간 복잡도의 계산(최선, 최악) : 정렬의 대상인 데이터의 수가 n개일 때, 각 병합의 단계마다 최대 n번의 비교연산이 진행된다. 그러므로 시간 복잡도는 O(nlog_2n)이 된다

  •  이동 횟수에 대한 시간 복잡도의 계산 : 각 병합단계에서 임시로 할당하는 배열에서 원래의 배열로 옮기는 시간이 있다. 하지만 링크드 리스트로 구현한다면 노드들간의 링크만 변경해주면 되므로 무시할 수 있을 정도로 복잡도를 줄일 수 있다(제자리 정렬, in-place sorting이라 한다)

```python
def Merge_Two_Area(arr, left, mid, right):   # 2단계에 해당하는 해결
    sorted_arr = [0] * (right+1)  # 병합한 데이터를 담기 위한 배열. 크기는 right+1이면 충분하다

    findex = left   # 왼쪽 영역을 접근하기 위한 인덱스
    rindex = mid+1  # 오른쪽 영역을 접근하기 위한 인덱스
    sindex = left   # sorted_arr[]을 접근하기 위한 인덱스

    # 비교연산이 이루어지는 loop문
    while (findex <= mid and rindex <= right):  # 왼쪽, 오른쪽 영역중 하나라도 접근을 완료하면 while문을 빠져 나오도록 설계하였다
        if (arr[findex] <= arr[rindex]):
            sorted_arr[sindex] = arr[findex]
            findex += 1
        else:
            sorted_arr[sindex] = arr[rindex]
            rindex += 1
        sindex += 1

    # 왼쪽, 오른쪽 영역이 동시에 전부 접근된 경우는 없다(왜 그런지는 곰곰히 생각해 볼 것)
    if (findex > mid):  # 왼쪽 영역이 전부 접근된 경우
        for i in range(rindex, right+1):# 남은 데이터를 그대로 sorted_arr에 옮긴다
            sorted_arr[sindex] = arr[i]
            sindex += 1
    else:   # 오른쪽 영역이 전부 접근된 경우
        for i in range(findex, mid+1):  # 남은 데이터를 그대로 sorted_arr에 옮긴다
            sorted_arr[sindex] = arr[i]
            sindex += 1

    # 정렬된 영역 arr에 옮기기
    for i in range(left, right+1):
        arr[i] = sorted_arr[i]



def Merge_Sort(arr, left, right):   # left와 right는 단순히 인덱스를 의미한다. 복잡하게 생각X
    if (left == right): return
    else:
        mid = (left+right)//2

        # 1단계에 해당하는 분할
        Merge_Sort(arr, left, mid)
        Merge_Sort(arr, mid+1, right)

        # 3단계에 해당하는 병합
        Merge_Two_Area(arr, left, mid, right)   # arr의 left~mid, mid+1~right까지 정렬되어있으니 이것을 합쳐서 arr에 저장하라는 의미

if __name__ == "__main__":
    arr = list(map(int, input().split()))
    print(arr)

    Merge_Sort(arr, 0, len(arr)-1)
    print(arr)
```

 

#### 2-3) Quic sort

•  평균적으로 제일 빠른 속도를 보여주는 정렬 방법이다

•  기본개념 : 제자리를 찾은 피벗값을 기준으로 분할하여 각각을 또다시 피벗으로 정렬한 뒤, 이를 병합정렬 하는 것이다

•  피벗을 중간 값에 해당하도록 잡는 것이 가장 좋다. 이를 위해서 여러 방법이 있지만, 가장 일반적인 방법으로는 랜덤하게 피벗을 잡는 것이다

•  비교 횟수에 대한 시간 복잡도의계산(최선, 평균) : 항상 중간값을 피벗으로 선택한 경우가 최선의 경우이다. 하지만 퀵 정렬은 평균적으로 최선의 경우와 비슷하게 선택을 하므로 평균적인 계산 또한 최선의 경우와 마찬가지로 O(nlog_2n)이다

•  비교 횟수에 대한 시간 복잡도의 계산(최악) : 항상 가장 작은값을 피벗으로 선택할 경우, 쪼개는 횟수 또한 n번이되기 때문에 시간복잡도는 O(n^2)이다

•  퀵 정렬은 다른 정렬 알고리즘에 비해 이동 연산이 매우 적게 일어나므로 평균적으로 가장 빠른 속도를 보이는 알고리즘이다

```python
def swap(arr, a, b):
    temp = arr[a]
    arr[a] = arr[b]
    arr[b] = temp

def partition(arr, left, right):   # left:정렬대상의 가장 왼쪽 인덱스, right: 정렬대상의 가장 오른쪽 인덱스
    pivot = arr[left]   # 피벗은 값이다. 인덱스가 아니다
    low = left+1    # 피벗을 제외한 가장 왼쪽에 위치한 인덱스
    high = right    # 피벗을 제외한 가장 오른쪽에 위치한 인덱스

    while (low<=high):
        while (low <= right and arr[low] <= pivot): # low는 pivot보다 큰 값을 만나면 멈춘다 and right를 넘어가면 멈춘다
            low += 1
        while (high >= left+1 and arr[high] >= pivot):  # high는 pivot보다 작은 값을 만나면 멈춘다 and left를 넘어가면 멈춘다
            high -= 1
        if (low <= high):
            swap(arr, low, high)
    swap(arr, left, high)
    return high

def quick_sort(arr, left, right):
    if (left <= right):
        pivot = partition(arr, left, right)
        quick_sort(arr, left, pivot-1)
        quick_sort(arr, pivot+1, right)

# arr = list(map(int, input().split()))
arr = [3, 2, 4, 1, 7, 6, 5]
quick_sort(arr, 0, len(arr)-1)
print(arr)
```

 

#### 2-4) Radix sort

•  기본개념 : 데이터를 구성하는 기본요소인 기수를 이용해서 정렬을 진행하는 방식. 비교연산을 하지않는 다는 것이 특징이다

•  이론상 한계로 알려진 시간복잡도를 넘어설 수 있는 정렬 방법이다!

•  LSD 정렬

​	•  가장 중요하지 않은 자릿수부터 시작하여 정렬을 하는 방법이다(숫자라면 일의자리 숫자부터 시작된다)

​	•  가장 영향력이 큰 자릿수를 마지막에 비교하니 마지막까지 결과를 알 수 없는 것이 이 방법의 최대 단점이다

​	•  하지만 이러한 단점이 프로그래밍에 있어서는 최대의 장점이 된다(일괄적 처리가 가능함)

•  MSD 정렬

​	•  가장 중요한 자릿수부터 시작하여 정렬을 하는 방법이다

​	•  중간에 결과를 알고 중단할 수 있다는 장점이 있다

​	•  하지만 일괄적으로 적용할 수 없고 일일이 중간점검을 해주어야하는 복잡함이 생긴다(구현의 난이도 증가 && 중간점검 코드 수행에 따른 비용부담)

결론 : 그래서 일반적으로 LSD를 더 많이 쓴다

구현 : 어렵네요ㅠㅠㅠ