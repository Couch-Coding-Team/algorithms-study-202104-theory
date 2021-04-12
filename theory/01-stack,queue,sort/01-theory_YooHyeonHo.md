# 큐, 스택, 정렬

## 큐

### FIFO (First In First Out)

    큐는 FIFO (First In First Out) 구조 형태를 가지고 있다.
    
    먼저 들어온 것이 먼저 나가게 된다.
    
    쉬운 예시로 선착순 접수를 할 때 먼저 접속한 사람 순서대로 처리가 되는 형태이다.

### 시간 복잡도

    원소를 삽입/삭제하는 경우 : O(1)

    조회하는 경우 : O(n)

### 장점

    데이터의 삽입/삭제가 빠르다.
    
    데이터가 입력된 순서대로 처리해야 할 때 유리하다.

### 단점

    중간에 위치한 데이터의 접근이 어렵다.

## 큐의 종류   

 #### 선형큐
  ![스크린샷 2021-04-12 오후 5 40 22](https://user-images.githubusercontent.com/58363663/114366852-cbc57280-9bb6-11eb-9c36-5221a9ea054b.png)
  - 선형큐는 일반적인 막대모양의 큐이다. 두 개의 인덱스를 가르키는 포인터를 (front, rear) 
    두어 데이터가 추가(inqueue)되면 rear값을 증가시키고 데이터가 삭제(dequeue)되면 
    front값을 증가시킨다.
    
  - 위와 같은 로직을 만들면 데이터가 추가될 때는 rear 인덱스에 데이터가 추가될 것이고 
    데이터를 삭제할 때는 front 인덱스에 있는 데이터가 삭제될 것이다.

  - front와 rear의 값이 계속 증가 하기 때문에 언젠가는 배열의 끝에 도달하게 되고 배열의 
    앞부분이 비어 있더라도 더이상 삽입하지 못한다는 단점이 있다. 
    더 이상 삽입할 공간이 없으면 배열의 크기를 추가하거나 데이터를 모두 왼쪽으로 옮겨야 한다.
    -> 원형큐로 문제점을 보완
    
    
  - 배열을 사용하여 큐 구현하기
```java
public interface Queue {
    void offer(int data);    // 데이터 추가
    void poll();             // 데이터 삭제
    int peek();              // 데이터 조회
}

public class QueueImpl implements Queue {
    private int front; // 저장된 원소 중 첫번쨰 원소
    private int rear; // 저장된 원소 중 마지막 원소
    private int[] queue;
  
    public QueueImpl() {
        this.front = 0;
        this.rear = -1;
        this.queue = new int[10]; 
    }

    @Override
    public void offer(int data) {
        rear += 1;
        if (rear == queue.length) {
            int[] tmpQueue = queue;
            queue = new int[rear + 10];
            for (int i = 0; i < tmpQueue.length; i++) {
                queue[i] = tmpQueue[i];
            }
        }
        queue[rear] = data;
    }

    @Override
    public int poll() {
        return queue[front++];
    }

    @Override
    public int peek() {
        return queue[front];
    }
}

```

  #### 원형큐
- 원형큐는 선형큐의 문제점을 보완하는 구조로 큐의 맨 끝과 맨 처음이 연결된 원형 모양의 큐이다.
      [잘 정리된 블로그](https://mailmail.tistory.com/41)

```java
  public interface Queue {
      void offer(int data);    // 데이터 추가
      void poll();             // 데이터 삭제
      int peek();              // 데이터 조회
  }

  class CircularQueue implements Queue {
      int rear = 0;
      int front = 0;
      int[] circularQueue;
  
      public CircularQueue(int maxsize) {
          this.maxsize = maxsize;
          this.circularQueue = new int[maxsize];
      }
    
      public boolean isEmpty() {
          return rear == front;
      }
    
      public boolean isFull() {
          return (rear + 1) % maxsize == front;
      }
  
      @Override
      public void offer(int data) {
          if (isFull()) {
              throw new IndexOutOfBoundsException();
          }
  
          if (!isFull()) {
              rear = (rear + 1) % maxsize;
              circularQueue[rear] = data;
          }
      }
  
      @Override
      public void poll() {
        if (isEmpty()) {
            throw new NullPointerException();
        }

        if (!isEmpty()) {
            System.out.println(circularQueue[front]);
            front = (front + 1) % maxsize;
        }
      }
  
      @Override
      public int peek() {
          return circularQueue[front + 1];
      }
  
  }
```
  #### 우선순위 큐
  - 큐는 먼저 들어간 데이터가 먼저 나오지만 우선순위 큐는 우선순위가 높은 데이터가
    먼저 나오게 된다. 1 ~ 10까지 차례대로 데이터를 넣었고 3의 배수인 수를 우선순위에 둔다면
    3, 6, 9가 먼저 나오고 나머지 1, 2, 4 ... 순서대로 데이터가 나온다.
    
  - 우선순위 큐를 구현하는 방법은 세 가지로 나뉘어 진다.
    1. 배열을 기반으로 구현하는 방법
    2. 연결리스트를 기반으로 구현하는 방법
    3. 힙(heap)을 이용하는 방법

  - 배열로 구현할 경우 데이터 삽입과 삭제 과정에서 데이터를 한 칸씩 당기거나 밀어야 하는 연산을 계속 하여야 한다.
    삽입의 위치를 찾기 위해 배열에 저장된 모든 데이터와 우선순위를 비교해야 한다.
    연결리스트의 경우, 삽입의 위치를 찾기 위해 첫번째 노드부터 시작해 마지막 노드에 저장된 데이터와 우선순위 
    비교를 진행해야 할 수도 있다. -> 성능 저하
  - 일반적으로 힙을 이용해 구현한다.
    [그림으로 설명된 예제](https://hannom.tistory.com/36)


## 스택

### LIFO (Last In First Out)

    스택은 LIFO (Last In First Out) 구조 형태를 가지고 있다. 
    
    나중에 들어온 것이 먼저 나가게 된다.
    
    쉬운 예시로는 프링글스가 있다. 프링글스를 먹을 때 가장 마지막에 담긴 조각부터 먹게 된다.

### 시간 복잡도

    원소를 삽입/삭제하는 경우 : O(1)
    조회하는 경우 : O(n)

### 장점

    데이터의 삽입/삭제가 빠르다.

### 단점

    중간에 위치한 데이터의 접근이 어렵다.

### 스택 구현하기

#### 배열을 이용한 스택

  - Array 기반 스택은 접근 속도가 빠르지만 변경이 용이하지 않다. 
    배열은 생성할 때, 메모리의 연속된 공간에 데이터를 저장한다. 
    그렇기 때문에 검색할 때는 데이터를 빠르게 찾을 수 있지만, 
    변경이 일어났을 때는 새로운 배열을 생성하고, 생성된 배열에 데이터를 복사해야하기 때문에 느려진다. 
    따라서 데이터가 많아질수록 성능에 문제가 생긴다.
    
  ```java
  public interface Stack {
      void push(int data);    // 데이터 추가
      int pop();              // 데이터 삭제
      void peek();            // 데이터 조회
  }
  
  public class StackImpl implements Stack {
      int[] stack;
      int dataCount;
  
      public StackImpl() {
          this.stack = new int[10];
          dataCount = 0;
      }
  
      @Override
      public void push(int data) {
          if (dataCount == stack.length) {
              int[] tmpStack = stack;
              stack = new int[dataCount + 10];
              for (int i = 0; i < tmpStack.length; i++) {
                  stack[i] = tmpStack[i];
              }
          }
  
          stack[dataCount] = data;
          dataCount++;
      }
  
      @Override
      public int pop() {
          return stack[--dataCount];
      }
  
      @Override
      public int peek() {
        return stack[dataCount];
      }
  }
  ```
#### Linked 기반 스택
  Linked List 기반 스택은 메모리 주소를 통해 노드가 연결되어 있어, 
  가르키는 메모리 주소만 변경하면 되므로, 등록, 수정과 같은 변경에는 빠르게 반응할 수 있다. 
  하지만, 메모리에 연속된 공간에 존재하지 않기 때문에 검색 데이터를 찾기 위해 노드를 순회해야하므로 
  검색 속도는 좋지 않다.

```java
class ListNode {
    int data;
    ListNode next;

    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }

    public int getData() {
        return data;
    }
}

class LinkedStack {
    ListNode head;
    ListNode currentNode;

    public void push(ListNode node) {
        if (head == null) {
            head = node;
            return;
        }
        currentNode = head;
        while (true) {
            if (currentNode.next == null) {
                currentNode.next = node;
                break;
            }
            currentNode = currentNode.next;
        }
    }

    public ListNode pop() {
        currentNode = head;
        while (true) {
            currentNode = currentNode.next;
            if (currentNode.next == null) {
                return currentNode;
            }
        }
    }
}

```


## 정렬

### 정렬 알고리즘
정렬은 데이터의 집합을 어떠한 기준으로 일정한 순서로 나열하는 것이다.
오름차순, 내림차순은 일상에서도 자주 사용하는 용어이다. 데이터를 정렬하는 이유는 탐색을 위해서다.
탐색할 테이터가 정렬되어 있지 않다면 순차 탐색 이외에 다른 알고리즘을 사용할 수 없지만 정렬되어 있다면 이진탐색
이라는 강력한 알고리즘을 사용할 수 있다. (속도가 굉장히 빠름)  
- 이진 탐색 알고리즘은 최악의 경우라도 logn의 성능을 보이는데 예를 들어 43억 개의 정렬된 자료가 들어있는 데이터에서 
  어떤 값을 찾아야 할 때 최악의 비교 횟수(찾는 값이 없는 경우)는 겨우 32회에 불과하다.

컴퓨터에서 정렬을 수행하는 이유 중 가장 큰 이유가 바로 이 이진 탐색이 가능한 데이터를 만들기 위해서이다.

정렬의 종류는 매우 다양하기 떄문에 대표적으로 사용되는 정렬에 대해 알아보자.

### 시간 복잡도
![스크린샷 2021-04-12 오후 10 07 09](https://user-images.githubusercontent.com/58363663/114399151-92532e00-9bdb-11eb-86a4-84ea60068562.png)


### 삽입 정렬
- 작은 수가 나올 때 까지 오른쪽으로 밀어 삽입하는 정렬
  
![스크린샷 2021-04-12 오후 10 23 43](https://user-images.githubusercontent.com/58363663/114401891-4b1a6c80-9bde-11eb-9df4-1493c8b4871b.png)
  
[사진 출처 : https://m.blog.naver.com/PostView.nhn?blogId=justant&logNo=20204025251&proxyReferer=https:%2F%2Fwww.google.com%2F](https://m.blog.naver.com/PostView.nhn?blogId=justant&logNo=20204025251&proxyReferer=https:%2F%2Fwww.google.com%2F)
- 자료가 이미 정렬되있을 경우 가장 빠른 속도를 내지만 최악일 경우(자료가 역순으로 되어있는 경우) 시간복잡도가 n2이기 때문에 속도가 빠른 정렬은 아니다.

```java

class InsertionSort {

    public int[] sort(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            int j = i;
            int t = numbers[i];
            while (j > 0 && numbers[j - 1] > t) {
                numbers[j] = numbers[j - 1];
                j--;
            }
            numbers[j] = t;
        }

        return numbers;
    }
}

```

### 선택 정렬
- 가장 작은 수를 선택하고 교환하는 정렬
  
![스크린샷 2021-04-12 오후 10 10 42](https://user-images.githubusercontent.com/58363663/114399513-f5dd5b80-9bdb-11eb-98f7-542959b89325.png)

[사진 출처 : http://blog.naver.com/PostView.nhn?blogId=jsky10503&logNo=221249976761](http://blog.naver.com/PostView.nhn?blogId=jsky10503&logNo=221249976761)
  
- 제자리 정렬 알고리즘의 하나

- 입력 데이터 이외에 다른 추가 메모리를 요구하지 않는다.

- 알고리즘이 단순하고 사용할 수 있는 메모리가 제한적인 경우에 사용시 성능 상의 이점이 있다.

- 시간 복잡도가 Best, Average, Worst 에서 모두  O(n^2)​​이다.

### 선택 정렬 코드

```java
class SelectSort {

    public int[] sort(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            int minIndex = i;
            int min = numbers[minIndex];

            for (int j = i; j < numbers.length; j++) {
                if (numbers[j] < min) {
                    min = numbers[j];
                    minIndex = j;
                }
            }

            int tmp = numbers[i];
            numbers[i] = numbers[minIndex];
            numbers[minIndex] = tmp;
        }
        return numbers;
    }
}

```
### 버블정렬
- 인접한 두개의 자료를 비교하여 크기가 정렬되어 있지 않으면 교환을 순차적으로 진행하고 한번의 과정이 끝나면
정렬이 되지 않은 왼쪽부터 다시 정렬을 반복한다.
  
![스크린샷 2021-04-12 오후 10 34 01](https://user-images.githubusercontent.com/58363663/114402849-34284a00-9bdf-11eb-9296-42142a954f28.png)

[사진 출처 : https://m.blog.naver.com/PostView.nhn?blogId=justant&logNo=20204028286&proxyReferer=https:%2F%2Fwww.google.com%2F](https://m.blog.naver.com/PostView.nhn?blogId=justant&logNo=20204028286&proxyReferer=https:%2F%2Fwww.google.com%2F)
  
```java
class BubbleSort {

    public int[] sort(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 1; j < numbers.length - i; j++) {
                if (numbers[j - 1] > numbers[j]) {

                    int tempValue = numbers[j - 1];
                    numbers[j - 1] = numbers[j];
                    numbers[j] = tempValue;
                }
            }
        }
        return numbers;
    }

}
```

### 셸정렬
삽입 정렬은 한칸씩 이동하면서 비교하기 때문에 만일 가장 멀리 떨어진 곳에서 비교가 이루어진다면 
이동 시 많은 오버헤드가 발생할 수 있다. 그 단점을 보완하기 위한 방식이다.

![스크린샷 2021-04-12 오후 11 40 14](https://user-images.githubusercontent.com/58363663/114412876-77d38180-9be8-11eb-98bf-24730d942726.png)

[사진 출처 : https://reference-m1.tistory.com/218](https://reference-m1.tistory.com/218)


```java
class ShellSort {

    public int[] sort(int[] numbers) {
        for (int gap = numbers.length / 2; gap > 0; gap /= 2) {
            for (int i = 0; i < gap; i++) {
                for (int j = i + gap; j < numbers.length; j += gap) {
                    int k = j;
                    int t = numbers[j];
                    while (k >= gap && numbers[k - gap] > t) {
                        numbers[k] = numbers[k - gap];
                        k -= gap;
                    }
                    numbers[k] = t;
                }
            }
        }
        return numbers;
    }
}
```

### 퀵정렬
- 최악의 경우 n^2의 성능을 내지만 최악의경우는 잘 나오지 않는다. 
  최악의 경우를 제외하곤 평균적으로 nlogn의 성능이다. 대부분의 상황에서 nlogn중 가장빠르고 잘 쓰인다.
  
![스크린샷 2021-04-12 오후 11 01 56](https://user-images.githubusercontent.com/58363663/114407233-2674c380-9be3-11eb-91c9-fa130af1c3b8.png)
![스크린샷 2021-04-12 오후 11 02 06](https://user-images.githubusercontent.com/58363663/114407250-2a084a80-9be3-11eb-902a-53834de43586.png)

[사진 출처 : https://coding-factory.tistory.com/137](https://coding-factory.tistory.com/137)

```java

class QuickSort {

    public int[] sort(int[] numbers) {
        quicksort(numbers, 0, numbers.length - 1);
        return numbers;
    }

    private void quicksort(int[] numbers, int left, int right) {
        if (left >= right) {
            return;
        }
        int tempLeft = left - 1;
        int tempRight = right + 1;
        int pivotValue = numbers[(left + right) / 2];
        while (true) {
            while (numbers[++tempLeft] < pivotValue);
            while (pivotValue < numbers[--tempRight]);

            if (tempLeft > tempRight) {
                break;
            }
            swap(numbers, tempLeft, tempRight);
        }
        quicksort(numbers, left, tempRight);
        quicksort(numbers, tempLeft, right);
    }

    private void swap(int array[], int tempLeft, int tempRight) {
        int tempValue = array[tempLeft];
        array[tempLeft] = array[tempRight];
        array[tempRight] = tempValue;
    }
}

```
### 힙정렬
- 힙 정렬(Heap sort)이란 최대 힙 트리나 최소 힙 트리를 구성해 정렬을 하는 방법으로서, 
  내림차순 정렬을 위해서는 최대 힙을 구성하고 오름차순 정렬을 위해서는 최소 힙을 구성하면 된다. (위키 백과)
  
#### 알고리즘 (위키 백과)
1. n개의 노드에 대한 완전 이진 트리를 구성한다. 이때 루트 노드부터 부모노드, 왼쪽 자식노드, 오른쪽 자식노드 순으로 구성한다.
2. 최대 힙을 구성한다. 최대 힙이란 부모노드가 자식노드보다 큰 트리를 말하는데, 단말 노드를 자식노드로 가진 부모노드부터 구성하며 아래부터 루트까지 올라오며 순차적으로 만들어 갈 수 있다.
3. 가장 큰 수(루트에 위치)를 가장 작은 수와 교환한다.
4. 2와 3을 반복한다.

![](https://upload.wikimedia.org/wikipedia/commons/4/4d/Heapsort-example.gif)

[출처 : 위키백과](https://ko.wikipedia.org/wiki/%ED%9E%99_%EC%A0%95%EB%A0%AC)

### 병합정렬

- 대표적인 nlogn 정렬 알고리즘 중 하나인 합병정렬은 항상 nlogn 의 성능을 내는 알고리즘으로
  힙정렬과 같고 최악상황의 퀵(n^2) 보다 안정적이다. 하지만 평균적으로 퀵정렬보다 느린 성능을 보이며
  알고리즘 구현에있어 힙정렬보다 메모리를 더 많이먹는다.

- 합병정렬은 분할 정복 알고리즘이다. 하나의 문제를 쪼개어 문제를 해결하는 방법이다.

![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=http%3A%2F%2Fcfile6.uf.tistory.com%2Fimage%2F2748243C58BBF920230735)

[출처 : https://zeddios.tistory.com/38](https://zeddios.tistory.com/38)

