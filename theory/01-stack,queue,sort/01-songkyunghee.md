송경희 알고리즘 스터디 1주차 이론 - 스택, 큐, 정렬 
-------------------------------------------------
# 1. 스택(Stack)
### 1-1 스택이란?
박스 쌓기에 비유할 수 있다. 흔히 박스는 아래에서부터 위로 차곡차곡 쌓는다. 그리고 아래에 있는 박스를 치우기 위해서는 위에 있는 박스를 먼저 내려야 한다. 이러한 구조를 선입후출(First In Last Out)
구조 또는 후입선출(Last In First Out) 구조라고 한다. 
### 1-2 스택의 구현
파이썬에서 스택을 이용할 때에는 별도의 라이브러리를 사용할 필요가 없다. 기본 리스트에서 append()와 pop() 메서드를 이용하면 스택 자료구조와 동일하게 동작한다. append()메서드는 리스트의 가장
뒤쪽에 데이터를 삽입하고, pop() 메서드는 리스트의 가장 뒤쪽에서 데이터를 꺼내기 때문이다.
### 1-3 스택 예제
<pre>
<code>
stack = []

# 삽입(5) - 삽입(2) - 삽입(3) - 삽입(7) - 삭제() - 삽입(1) -삽입(4) - 삭제()
stack.append(5)
stack.append(2)
stack.append(3)
stack.append(7)
stack.pop()
stack.append(1)
stack.append(4)
stack.pop()

print(stack) # 최하단 원소부터 출력
print(stack[::-1]) # 최상단 원소부터 출력
</code>
</pre>

<pre>
<code>
[5, 2, 3, 1]
[1, 3, 2, 5]
</code>
</pre>
### 1-4 스택의 사용 사례
* 웹 브라우저 방문기록(뒤로가기)
* 실행 취소
* 역순 문자열 만들기
* 후위 표기법 계산

# 2. 큐(Queue)
### 2-1 큐?
대기줄에 비유할 수 있다. 우리가 흔히 놀이공원에 입장하기 위해 줄을 설 때, 먼저 온 사람이 먼저 들어가게 된다. 물론 새치기는 없다고 가정한다. 나중에 온 사람일수록 나중에
들어가기 때문에 흔히 '공정한' 자료구조라고 비유한다. 이러한 구조를 선입선출(First In First Out) 구조라고 한다. 
### 2-2 큐의 구현
파이썬으로 큐를 구현할 때는 collections 모듈에서 제공하는 deque 자료구조를 활용한다. deque는 스택과 큐의 장점을 모두 채택한 것인데 데이터를 넣고 빼는 속도가
리스트 자료형에 비해 효율적이며 queue 라이브러리를 이용하는 것보다 더 간단하다.
### 2-3 큐 예제
<pre>
<code>
from collections import deque

# 큐 구현을 위해 deque 라이브러리 사용
queue = deque()

# 삽입(5) - 삽입(2) - 삽입(3) - 삽입(7) - 삭제() - 삽입(1) - 삽입(4) - 삭제()
queue.append(5)
queue.append(2)
queue.append(3)
queue.append(7)
queue.popleft()
queue.append(1)
queue.append(4)
queue.popleft()

print(queue) # 먼저 들어온 순서대로 출력
queue.reverse() # 다음 출력을 위해 역순으로 바꾸기
print(queue) # 나중에 들어온 원소부터 출력
</code>
</pre>

<pre>
<code>
deque([3, 7, 1, 4])
deque([4, 1, 7, 3])
</code>
</pre>
### 2-4 큐의 사용 사례
* 은행 업무
* 콜센터 고객 대기시간
* 우선순위가 같은 작업 예약(프린터의 인쇄 대기열)
# 3. 정렬(Sorting)
### 3-1 정렬이란?
데이터를 특정한 기준에 따라서 순서대로 나열하는 것을 말한다. 정렬은 선택 정렬, 삽입 정렬, 퀵 정렬, 계수 정렬 등 종류가 다양하다. 
### 3-2 정렬 종류
#### (1)-1 선택 정렬
데이터가 무작위로 여러 개 있을 때, 이중에서 가장 작은 데이터를 선택해 맨 앞에 있는 데이터와 바꾸고, 그다음 작은 데이터를 선택해 앞에서 두
번째 데이터와 바꾸는 과정이다. 이 방법은 컴퓨터가 데이터를 정렬할 때 가장 원시적인 방법으로 매번 '가장 작은 것을 선택'한다는 의미에서 선택
정렬이라고 한다. 가장 작은 것을 선택해서 앞으로 보내는 과정을 반복해서 수행하다 보면, 전체 데이터의 정렬이 이루어진다. 
#### (1)-2 선택 정렬 소스코드
<pre>
<code>
array = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8]

for i in range(len(array)):
  min_index = i # 가장 작은 원소의 인덱스
  for j in range(i + 1, len(array)):
    if array[min_index] > array[j]:
      min_index = j
  array[i], array[min_index] = array[min_index], array[i]

print(array)
</code>
</pre>

<pre>
<code>
[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
</code>
</pre>
#### (1)-3 선택 정렬 시간복잡도
* O(N^2)
#### (2)-1 삽입 정렬
특정한 데이터를 적절한 위치에 '삽입'한다는 의미에서 삽입 정렬이라고 부른다. 더불어 삽입 정렬은 특적한 데이터가 적절한 위치에 들어가기 이전에, 그 앞까지의
데이터는 이미 정렬되어 있다고 가정한다. 정렬되어 있는 데이터 리스트에서 적절한 위치를 찾은 뒤에, 그 위치에 삽입된다는 점이 특징이다. 
#### (2)-2 삽입 정렬 소스코드
<pre>
<code>
array = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8]

for i in range(1, len(array)):
  for j in range(i, 0, -1): # 인덱스 i부터 1까지 감소하며 반복하는문법
    if array[j] < array[j - 1]: # 한 칸씩 왼족으로 이동
      array[j], array[j - 1] = array[j - 1], array[j]
    else: # 자기보다 작은 데이터를 만나면 그 위치에서 멈춤
      break

print(array)
</code>
</pre>

<pre>
<code>
[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
</code>
</pre>
#### (2)-3 삽입 정렬 시간복잡도
* O(N^2), O(N)
#### (3)-1 퀵 정렬
기준을 설정한 다음 큰 수와 작은 수를 교환한 후, 리스트를 반으로 나누는 방식으로 동작한다. 퀵 정렬에서는 피벗이 사용된다. 큰 숫자와 작은 숫자를 
교환할 때, 교환하기 위한 기준을 바로 피벗이라고 표현한다. 퀵 정렬을 수행하기 전에는 피벗을 어떻게 설정할 것인지 미리 명시해야 한다. 피벗을 설정하고
리스트를 분할하는 방법에 따라서 여러 가지 방식으로 퀵 정렬을 구분하는데, 가장 대표적인 분할 방식은 호어 분할 방식이다. 호어 분할 방식은 
'리스트에서 첫 번째 데이터를 피벗으로 정한다' 규칙으로 피벗을 설정한다. 이와 같이 피벗을 설장한 뒤에는 왼쪽에서부터 피벗보다 큰 데이터를 찾고, 오른쪽에서부터
피벗보다 작은 데이터를 찾는다. 그다음 큰 데이터와 작은 데이터의 위치를 서로 교환해준다. 이러한 과정을 반복하면 정렬이 수행된다. 
#### (3)-2 퀵 정렬 소스코드
<pre>
<code>
array = [5, 7, 9, 0, 3, 1, 6, 2, 4, 8]

def quick_sort(array, start, end):
  if start >= end: # 원소가 1개인 경우 종료
    return
  pivot = start # 피벗은 첫 번째 원소
  left = start + 1
  right = end
  while left <= right:
    # 피벗보다 큰 데이터를 찾을 때까지 반복
    while left <= end and array[left] <= array[pivot]:
      left += 1
    # 피벗보다 작은 데이터를 찾을 때까지 반복
    while right > start and array[right] >= array[pivot]:
      right -=1
    if left > right: # 엇갈렸다면 작은 데이터와 피벗을 교체
      array[right], array[pivot] = array[pivot], array[right]
    else: #엇갈리지 않았다면 작은 데이터와 큰 데이터를 교체
      array[left], array[right] = array[right], array[left]
  # 분할 이후 왼쪽 부분과 오른쪽 부분에서 각각 정렬 수행
  quick_sort(array, start, right - 1)
  quick_sort(array, right + 1, end)

quick_sort(array, 0, len(array) - 1)
print(array)
</code>
</pre>

<pre>
<code>
[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
</code>
</pre>
#### (3)-3 퀵 정렬의 시간복잡도
* O(NlogN)
#### (4)-1 계수 정렬
특정한 조건이 부합할 때만 사용할 수 있지만 매우 빠른 정렬이다. 모든 데이터가 양의 정수인 상황을 가정해보면 데이터의 개수가 N, 데이터 중 최댓값이
K일 때, 계수 정렬은 최악의 경우에도 수행 시간 O(N + K)를 보장한다. 이처럼 매우 빠르게 동작한다. 다만, 계수 정렬은 '데이터의 크기 범위가 제한되어 정수 형태로
표현할 수 있을 때만 사용할 수 있다. 또한 일반적으로 별도의 리스트를 선언하고 그 안에 정렬에 대한 정보를 담는다는 특징이 있다. 계수 정렬은, 먼저 가장 큰
데이터와 가장 작은 데이터의 범위가 모두 담길 수 있도록 하나의 리스트를 생성한다. 그다음 데이터를 하나씩 확인하며 데이터의 값과 동일한 인덱스의 
데이터를 1씩 증가시키면 계수 정렬이 완료된다. 
#### (4)-2 계수 정렬 소스코드
<pre>
<code>
# 모든 원소의 값이 0보다 크거나 같다고 가정
array = [7, 5, 9, 0, 3, 1, 6, 2, 9, 1, 4, 8, 0, 5, 2]
# 모든 범위를 포함하는 리스트 선언(모든 값은 0으로 초기화)
count = [0] * (max(array) + 1)

for i in range(len(array)):
  count[array[i]] += 1 # 각 데이터에 해당하는 인덱스의 값 증가

for i in range(len(count)): # 리스트에 기록된 정렬 정보 확인
  for j in range(count[i]):
    print(i, end=' ') # 띄어쓰기를 구분으로 등장한 횟수만큼 인덱스 출력
</code>
</pre>

<pre>
<code>
0 0 1 1 2 2 3 4 5 5 6 7 8 9 9 
</code>
</pre>
#### (4)-3 계수 정렬의 시간 복잡도
O(N + K)
