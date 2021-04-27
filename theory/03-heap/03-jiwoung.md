# Heap(힙)

## 우선순위 큐

-  우선순위의 개념을 큐에 도입한 자료 구조

## 우선순위 큐의 이용 사례

- 시뮬레이션 시스템
- 네트워크 트래픽 제어
- 운영 체제에서의 작업 스케쥴링
- 수치 해석적인 계산

우선순위 큐는 배열, 연결리스트, 힙 으로 구현이 가능하다. 이 중에서 힙(heap)으로 구현하는 것이 가장 효율적이다.



## 자료구조 ‘힙(heap)’이란?

- 완전 이진 트리의 일종으로 우선순위 큐를 위하여 만들어진 자료구조이다.
- 최댓값이나 최솟값을 빠르게 찾아내도록 만들어진 자료구조이다.
- 반정렬 상태(느슨한 정렬 상태) 를 유지한다.
- 힙 트리에서는 중복된 값을 허용한다.

## 힙(heap)의 종류

1. 최대 힙(max heap)

   - 부모 노드의 키 값이 자식 노드의 키 값보다 크거나 같은 완전 이진 트리
   - 부모 노드의 값 > 자식 노드의 값

   

2. 최소 힙(min heap)

   - 부모 노드의 키 값이 자식 노드의 키 값보다 작거나 같은 완전 이진 트리
   - 자식 노드의 값 > 부모 노드의 값

## 힙(heap)의 구현

- 보통 구현을 쉽게 하기 위하여 배열의 첫 번째 인덱스인 0은 사용되지 않는다.

- 완전 이진 트리를 기반으로 하기 때문에 노드들중 비어있는 노드가 없다.

  

## 부모 노드와 자식 노드의 관계

- 왼쪽 자식의 인덱스 = (부모의 인덱스) * 2
- 오른쪽 자식의 인덱스 = (부모의 인덱스) * 2 + 1
- 부모의 인덱스 = (자식의 인덱스) / 2

## 최소 힙 코드 구현

1. 힙 초기화 밑 삽입

```kotlin
internal class MinHeap {
  private val heap:ArrayList<Int>
  /*heap init*/
  init{
    heap = ArrayList()
    heap.add(0) 
  }
  // insertion
  private fun insert(data:Int) {
    heap.add(data)
    val position = heap.size() - 1
  
    while (position > 1 && heap.get(position / 2) < heap.get(position))
    {
    
      val temp = heap.get(position / 2)
      heap.set(position / 2, heap.get(position))
      heap.set(position, temp)
      position /= 2
    }
  }
}
```

2. 힙 삭제

```kotlin
fun delete():Int {
 
  if (heap.size() - 1 < 1)
  {
    return 0
  }
  val deleteData = heap.get(1)
  heap.set(1, heap.get(heap.size() - 1))
  heap.remove(heap.size() - 1) 
  val position = 1
  while ((position * 2) < heap.size())
  { // 힙의 크기보다 작을 떄 까지
    val min = heap.get(position * 2)
    val minPos = position * 2 
   
    if (((position * 2 + 1) < heap.size()) && min > heap.get(position * 2 + 1))
    {
      min = heap.get(position * 2 + 1)
      minPos = position * 2 + 1 
    }
    if (heap.get(position) < min) break 

    val temp = heap.get(position)
    heap.set(position, heap.get(minPos))
    heap.set(minPos, temp)
    position = minPos
  }
  return deleteData
}
```




