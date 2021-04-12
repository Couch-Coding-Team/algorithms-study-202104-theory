# Queue(큐)

## <u>Queue란</u>?

- 첫번째 데이터가 첫번째로 나가는 선입선출(FIFO) 구조
- 데이터 인풋 (enqueue),
  데이터 아웃풋 (dequeue),
  데이터를 아웃풋하는 위치 (front),
  데이터를 인풋하는 위치(rear) 

![](https://t1.daumcdn.net/cfile/tistory/2541CF34588E84760C)

## <u>1. 선형 큐</u>



```java
public class Queue {

	private int front;
	private int rear;
	private int size;
	private Object[] queue;

    
	public Queue(int size){

		this.front = 0;

		this.rear = -1;

		this.size = size;

		this.queue = new Object[this.size];
	}



	public boolean isFull(){

		if(rear >= size-1) return true;

		else return false;

	}

	

	public boolean isEmpty(){

		if(rear < front) return true;

		else return false;

	}

	public void enQueue(Object item){

		if(isFull()) throw new ArrayIndexOutOfBoundsException();

		this.rear++;

		queue[rear] = item;

	}

	

	public Object peek(){

		return queue[front];

	}

	

	public Object deQueue(){

		if(isEmpty()) throw new ArrayIndexOutOfBoundsException();

		

		Object backUpItem = peek();

		this.front++;

		return backUpItem;

	}

}
```

```java
public class main {

	public static void main(String[] args) {

		Queue queue = new Queue(4);

		queue.enQueue("Hello");

		queue.enQueue(5);

		queue.enQueue("queue");

		while(!queue.isEmpty()){

			System.out.println(queue.deQueue());
		}
	}
}
```

## <u>2. 원형큐</u>

- 인덱스 단위로 큐의 연산을 진행할 경우 비어있는 인덱스를 꽉 찼다고 인식할 수 있음

```
queue
[0][1][2][3] // enqueue 4번 dequeue 3번 실행
 
[2] : front
[3] : rear

=> [0],[1],[2]는 비어있지만 큐는 꽉 찼다고 인식
```

- 이를 해결하기 위해 나온게 **원형큐**

```java
fun main() {

    val queue = Queue()
    queue.insert(1)
    queue.printFront()
    queue.insert(10)
    queue.printTail()
    queue.insert(11)
    queue.printAllElement()
    queue.pop()
}


class Queue {

    init {
        println("Queue start")
    }

    private val list = IntArray(QUEUE_SIZE)
    private var head = 0
    private var tail = -1
    private var queueSize = 0

    fun insert(value: Int) {
        list[(++tail % QUEUE_SIZE)] = value
        ++queueSize
    }

    fun pop(): Int {
        if(head >= 10) {
            println("queue'size is overflow")
            return -1
        }
        if(list[head] == -1) {
            println("position $head is empty")
            return -1
        }
        println("front pop ${list[head]}")
        val result = list[head]
        list[head] = -1
        head = (head + 1) %  QUEUE_SIZE
        return result
    }

    fun printFront() {
        println("Queue Front ${list[head % QUEUE_SIZE]}")
    }

    fun printTail() {
        println("Queue Tail ${list[tail % QUEUE_SIZE]}")
    }

    fun printAllElement() {
        for (index in 0..9) {
            println(list[index])
        }
    }

    companion object {
        const val QUEUE_SIZE = 10
    }

}
```





# Stack(스택)

- 마지막 데이터가 첫번째로 나가는 후입 선출(LIFO) 구조
- 삽입 작업(PUSH)
- 제거 작업(POP)



## 1. 구현

```kotlin
fun main() {
    // stack
    var mutableList = mutableListOf<Int>()

    // push = add()
    mutableList.add(1)
    mutableList.add(2)
    mutableList.add(3)

    // pop = removeAt(가장 마지막 인덱스)
    mutableList.removeAt(mutableList.size-1)

    // top = 배열의 가장 마지막 원소
    print(mutableList[mutableList.size-1])

    // isEmpty or isNotEmpty
    println(mutableList.isEmpty())
    println(mutableList.isNotEmpty())

    // stack 크기
    println(mutableList.size)
}
```



# Sort(정렬)

- 선택 정렬 
- 삽입 정렬
- 버블 정렬
- 합병 정렬
- 퀵 정렬



## 1. 선택 정렬

### 1-1 순서

1. 리스트 중에 최솟값을 찾는다.
2. 맨 앞에 위치한 값과 교체한다.
3. 처음 위치를 뺀 나머지 리스트를 반복 작업한다.

### 1-2 구현

```java
static public void selectionSort() {
        int i, j;
        for (i = 0; i < length; i++) {
            int tmp = i;
            for (j = i + 1; j < length; j++) {
                // 최소 값을 찾는다.
                if (array[tmp] > array[j]) {
                    tmp = j;
                }
            }
            // 맨 처음 tmp 값과 다를 경우 최소 값을 찾았기 때문에 교환 발생
            if (i != tmp) {
                int temp = array[tmp];
                array[tmp] = array[i];
                array[i] = temp;
            }

        }
```

### 1-3 시간복잡도

- O(n^2 )



## 2. 삽입 정렬

### 2-1 순서

1. 두 번째 요소부터 시작하여 첫 번째 요소와 비교 후 교체
2. 세 번째 요소를 가져와 첫 번째 및 두 번째 요소
3. 반복

### 2-2 구현

```kotlin
fun insertionsort(items:MutableList<Int>):List<Int>{
    if (items.isEmpty() || items.size<2){
        return items
    }
    for (count in 1..items.count() - 1){
       
        val item = items[count]
        var i = count
        while (i>0 && item < items[i - 1]){
            items[i] = items[i - 1]
            i -= 1
        }
        items[i] = item
    }
    return items
}
fun main(args: Array<String>) {
    val names = mutableListOf(8, 3, 2, 7, 4)
    println(names)
    var ordered = insertionsort(names)
    println(ordered)
}
```

### 2-3 시간복잡도

- O(n^2 )



## 3. 버블 정렬

### 3-1 순서

1. 첫 번째 요소와  두 번째 요소 비교 후 교환  
2. 두 번째 요소와 세번 째 요소 비교 후 교환
3. 마지막 전 요소와 마지막 요소 비교 후 교환
4. 1회전이 끝나면 제일 마지막 요소는 제외시키고 다시 반복

### 3-2 구현

```kotlin
fun bubbleSort(arr: IntArray): IntArray{ 
    var temp = 0 
    for(i in arr.indices){
        for(j in 1 until arr.size - i)
        if(arr[j] < arr[j-1]) { 
            temp = arr[j] 
            arr[j] = arr[j - 1] 
            arr[j - 1] = temp } 
    } 
    return arr 
}


```

### 3-3 시간복잡도

- O(n^2 )



## 4. 합병 정렬

### 4-1 순서

1. 가장 작은 단위까지 분할

2. 가장 작은 단위부터 정렬

3. 새로운 리스트 생성해서 정렬

4. 반복

   

### 4-2 구현

```kotlin
fun mergeSort(list: List<Int>): List<Int> {
    if (list.size <= 1) {
        return list
    }

    val middle = list.size / 2
    var left = list.subList(0,middle);
    var right = list.subList(middle,list.size);

    return merge(mergeSort(left), mergeSort(right))
}
fun merge(left: List<Int>, right: List<Int>): List<Int>  {
    var indexLeft = 0
    var indexRight = 0
    var newList : MutableList<Int> = mutableListOf()

    while (indexLeft < left.count() && indexRight < right.count()) {
        if (left[indexLeft] <= right[indexRight]) {
            newList.add(left[indexLeft])
            indexLeft++
        } else {
            newList.add(right[indexRight])
            indexRight++
        }
    }

    while (indexLeft < left.size) {
        newList.add(left[indexLeft])
        indexLeft++
    }

    while (indexRight < right.size) {
        newList.add(right[indexRight])
        indexRight++
    }
    return newList;
}

fun main(args: Array<String>) {
    val numbers = mutableListOf(38,27,43,3,9,82,10)
    val sortedList = mergeSort(numbers)
    println("Unsorted: $numbers")
    println("Sorted: $sortedList")
}
```

### 4-3 시간복잡도

- O(NlogN)



## 5. 퀵 정렬

### 5-1 순서

1. 피벗보다 큰 요소 작은 요소를 서로 교환 할  수 있을 때까지 찾는다.

2. left가 right보다 더 오른쪽에 위치 할 경우 종료

3. 처음 피벗을 중간 인덱스에 넣고 다시 반복

   

### 5-2 구현

```kotlin
fun quicksort(items:List<Int>):List<Int>{
    if (items.count() < 2){
        return items
    }
    val pivot = items[items.count()/2]

    val equal = items.filter { it == pivot }

    val less = items.filter { it < pivot }

    val greater = items.filter { it > pivot }

    return quicksort(less) + equal + quicksort(greater)
}
fun main(args: Array<String>) {
    println("
Original list:")
    val numbers = listOf<Int>(2, 4, 7, 3, 6, 9, 5, 1, 0)
    println(numbers)
    println("
Ordered list:")
    val ordered =  quicksort(numbers)
    println(ordered)
}
```

### 5-3 시간복잡도

- O(NlogN)