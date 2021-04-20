# Hash(해시)

- 임의의 길이의 데이터를 고정된 길이의 데이터로 매핑하는 함수
- 장점 : 검색 속도 빠름 -> 해시코드를 통해 인덱스에 바로 접근
- 시간복잡도 : O(1) , O(n)

## 1. 순서

- 키 - 해시함수 - 해시코드 - 해시테이블 저장    

## 2.  Collison(충돌)

- 해시코드는 제한된 정수를 사용하기 때문에 같은 해시코드가 나온다던지 해시코드는 다르지만 같은 버킷(배열방)에 들어갈 수도 있음

## 3. 해결방법

1. Separate Chaining : 저장소(버킷)에서 충돌이 일어나면 기존 값과 새로운 값을 연결리스트를 이용해 연결시킨다.

   1.1 장점 : 한정된 저장소를 효율적으로 사용 -> 처음부터 많은 공간을 잡을 필요가 없다 = 테이블의 크기를 유연하게 만듬

   1.2 단점 : 한 해시에 많이 연결되면 검색 효율이 낮아짐 (쏠림 현상)

   

   ![](https://media.vlpt.us/images/adam2/post/ca25f031-e6a7-4ef0-8a82-6cf5a25a4153/image.png)

   

2. Open Addressing(개방주소법) : 비어있는 해시를 찾아 데이터를 저장하는 기법 -> 해시과 value의 1:1관계를 유지시킨다.
   해시테이블 크기는 고정시키되 저장해 둘 위치를 잘 찾는데 관심을 둔 구조

   ![](https://media.vlpt.us/images/adam2/post/a0880019-83ec-44b2-ae32-67ab4d536445/image.png)

   

## 4. 매핑

- 해시값을 고르게 만들어내기 위한 여러가지 방법

1. 나눗셈법 : 원소를 해시테이블의 크기로 나눈 나머지값을 테이블의 주소로 사용
   테이블의 크기보다 원소의 갯수가 많으면 충돌발생
2.  곱셈법 : (숫자 키 k, A는 0과 1 사이의 실수 일 때,
   `h(k)=(kA mod 1)×m`
   2진수 연산에 최적화된 컴퓨터구조를 고려한 해시함수라고 한다.
   나눗셈법보다는 다소느리다.) 무슨말인지 모르겠다..
3.  유니버스 해싱 : ...

## 5. 예제

```kotlin
internal class HashTable(size:Int) {
  var data:Array<LinkedList<Node>>
  init{
    this.data = arrayOfNulls<LinkedList>(size)
  }
  fun getHashCode(key:String):Int {
    val hashCode = 0
    for (c in key.toCharArray())
    {
      hashCode += c.toInt()
    }
    return hashCode
  }
  fun convertToIndex(hashCode:Int):Int {
    return hashCode % data.size
  }
  fun searchKey(list:LinkedList<Node>, key:String):Node {
    if (list == null) return null
    for (node in list)
    {
      if (node.key == key)
      {
        return node
      }
    }
    return null
  }
  fun put(key:String, value:String) {
    val hashCode = getHashCode(key)
    val index = convertToIndex(hashCode)
    val list = data[index]
    if (list == null)
    {
      list = LinkedList<Node>()
      data[index] = list
    }
    val node = searchKey(list, key)
    if (node == null)
    {
      list.addLast(Node(key, value))
    }
    else
    {
      node.value = value
    }
  }
  fun get(key:String):String {
    val hashCode = getHashCode(key)
    val index = convertToIndex(hashCode)
    val list = data[index]
    val node = searchKey(list, key)
    return if (node == null) "Not found" else node.value
  }
  internal inner class Node(key:String, value:String) {
    var key:String
    var value:String
    init{
      this.key = key
      this.value = value
    }
  }
}
object Test {
  @JvmStatic fun main(args:Array<String>) {
    val ht = HashTable(3)
    ht.put("sung", "She is pretty")
    ht.put("jin", "She is model")
    ht.put("hee", "She is angel")
    ht.put("min", "She is cute")
    println(ht.get("sung"))
    println(ht.get("jin"))
    println(ht.get("hee"))
    println(ht.get("min"))
    println(ht.get("jae"))
  }
}
//https://try.kotlinlang.org/#/Kotlin%20Koans/Introduction/Java%20to%20Kotlin%20conversion/Task.kt
```

## 6. 해시 테이블 사용 예

1. 해시 테이블 조회 : 전화번호부 검색
2. 중복 방지 : 투표
3. 해시 테이블을 캐시로 사용
