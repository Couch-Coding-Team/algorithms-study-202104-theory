# 해시

## 해시 (Hash)

해시란 데이터를 다루는 기법 중에 하나로 **검색과 저장이 빠르다.** 검색과 저장이 빠른 이유는 데이터를 검색할 때 사용할 key와 실제 데이터의 값이 한 쌍으로 존재하고, 해시 알고리즘을 통해 key값이 배열의 인덱스로 변환된다. 따라서 검색과 저장의 평균적인 시간 복잡도가 O(1)에 수렴하게 된다. 하지만 충돌(Collison)이 일어나는 경우 O(N)의 시간복잡도를 가지게 된다. 충돌은 따로 밑에서 설명하겠습니다.

<img width="770" alt="스크린샷 2021-04-19 오후 6 55 14" src="https://user-images.githubusercontent.com/58363663/115255130-ed9b9800-a168-11eb-82cf-9a0a46e1979c.png">

- 키(key) : 고유한 값이며, 해시 함수의 input이 된다. 다양한 길이의 값이 될 수 있다. 이 상태로 최종 저장소에 저장이 되면 다양한 길이 만큼의 저장소를 구성해 두어야 하기 때문에 해시 함수로 값을 바꾸어 저장이 되어야 공간의 효율성을 추구할 수 있다.
- 해시함수(Hash Function) : 키(key)를 해시(hash)로 바꿔주는 역할을 한다. 다양한 길이를 가지고 있는 키(key)를 일정한 길이를 가지는 해시(hash)로 변경하여 저장소를 효율적으로 운영할 수 있도록 도와준다. 다만, 서로 다른 키(key)가 같은 해시(hash)가 되는 경우를 해시 충돌(Hash Collision)이라고 하는데, 해시 충돌을 일으키는 확률을 최대한 줄이는 함수를 만드는 것이 중요하다.
- 해시(Hash) : 해시 함수(Hash Function)의 결과물이며, 저장소(bucket, slot)에서 값(value)과 매칭되어 저장된다.
- 값(Value) : 저장소(bucket, slot)에 최종적으로 저장되는 값으로 키와 매칭되어 저장, 삭제, 검색, 접근이 가능해야 한다.

출처 : [https://velog.io/@cyranocoding/Hash-Hashing-Hash-Table해시-해싱-해시테이블-자료구조의-이해-6ijyonph6o](https://velog.io/@cyranocoding/Hash-Hashing-Hash-Table%ED%95%B4%EC%8B%9C-%ED%95%B4%EC%8B%B1-%ED%95%B4%EC%8B%9C%ED%85%8C%EC%9D%B4%EB%B8%94-%EC%9E%90%EB%A3%8C%EA%B5%AC%EC%A1%B0%EC%9D%98-%EC%9D%B4%ED%95%B4-6ijyonph6o)

### 용도

1. **정보의 무결성 확인**

   바이러스가 포함되어 있는 파일을 다운받거나 자신이 받은 암호화의 결과에 결손이 의심된다면 공개된 해시값과 검사합(Checksum)을 비교하여 검증할 수 있다.

    - 체크섬이란 해시 합계라고 하며 단일 파일에 데이터의 암호화 해시 함수라고 말하는 알고리즘을 실행한 결과이다. 파일 버전에서 생성한 체크섬과 파일 소스에서 제공한 체크섬을 비교하면 파일 사본에 오류가 발생하지 않도록 할 수 있다.
    - 체크섬을 원본 파일과 사본이 동일한지 비교하는 과정으로 이해했고 비트로 계산하는 과정은 아직 이해가  되지 않았다.

   해시 값을 데이터의 지문처럼 활용하는 경우다.

2. **암호 저장**

   회원이 비밀번호를 디비에 원문 그대로 저장하면 DB가 노출이 된다면 사용자의 정보가 모두 노출되게된다. 이때 해시함수를 이용하여 비밀번호를 해시 함수로 암호화하여 디비에 해시값을 저장하고 비교한다.

   서비스가 해킹이 되어 회원들의 DB가 유출이 되더라도 해커는 **역상저항성**으로 인해 회원들의 진짜 암호를 알아낼 수 없다.

    - 역상저항성이란 주어진 임의의 출력값 y에 대해 y = h(x)를 만족하는 입력값 x 을 찾는 것이 계산적으로 불가능하다.

3. **해시테이블에서의 활용**

   데이터 목록에서 특정 데이터를 조회할 때, 키 값으로 탐색 범위를 줄일 수 있음

<img width="770" alt="스크린샷 2021-04-19 오후 6 55 14" src="https://user-images.githubusercontent.com/58363663/115255130-ed9b9800-a168-11eb-82cf-9a0a46e1979c.png">

### 저장

해시 테이블에 자료를 저장하기 위해서 키를 해시함수를 통해 해시로 변경한다. 위의 예시를 보면 0 ~ 8까지의 배열은 미리 생성해둔다. 유현호라는 키 값이 들어왔을때 해시함수를 걸쳐 0이라는 해시값이 나오게된다. 미리 지정되이었는 해시값에 맞게 value를 저장한다.

해시 함수로 해시를 산출하는 과정에서 서로 다른 key가 같은 hash로 변경되는 문제가 발생할 수 있는데, 이는 key 와 value가 1:1로 매칭이 되어야 한다는 규칠을 위배한 것이되므로 이 문제를 해결하면서 저장되어야 한다. 이는 **해시 충돌(Hash Collision)** 이라고 한다.

**시간복잡도**

저장 단계의 시간복잡도는 O(1)이다. 키는 고유하며 해시함수의 결과로 나온 해시와 값을 저장소에 넣으면 되기 때문이다. 이 때, 해시함수의 시간복잡도는 함께 고려하지 않는다. 하지만, 최악의 경우 O(n)이 될 수 있다.

### 삭제

저장되어 있는 값을 삭제할 때는 저장소에서 해당 key와 매칭되는 값을 찾아서 삭제하면 된다. 저장소에는 hash와 value가 함께 저장되어 있으므로 함께 지운다.

**시간복잡도**

삭제 단계의 시간복잡도는 O(1)이다. 키는 고유하며 해시함수의 결과로 나온 해시에 매칭되는 값을 삭제하면 되기 때문이다. 이 때, 해시함수의 시간복잡도는 함께 고려하지 않는다. 하지만, 최악의 경우 O(n)이 될 수 있다.

### 검색

키(key)로 값(value)를 찾아내는 과정은 Deletion 과정과 비슷한다. 1) 키로 hash를 구한다. 2) hash로 값(value)를 찾는다.

**시간복잡도**

저장 단계의 시간복잡도는 O(1)이다. 키는 고유하며 해시함수의 결과로 나온 해시에 매칭되는 값을 찾으면 되기 때문이다. 이 때, 해시함수의 시간복잡도는 함께 고려하지 않는다. 하지만, 최악의 경우 O(n)이 될 수 있다.

## Hash Collision(해시 충돌)

해시테이블은 Insertion, Deletion, Search 과정에서 모두 평균적으로 O(1)의 시간복잡도를 가지고 있기 때문에 자료구조의 효율성 측면에서 매우 우수하다고 볼 수 있다. 하지만 이런 장점만 있는 것일까?

해시(hash)를 이용한 자료구조 방식에 필연적으로 나타날 수 있는 문제는, **무한한 값**(해시테이블에서는 KEY를 의미한다.)을 **유한한 값**(해시 테이블에서는 Hash를 의미한다.)으로 표현하면서 서로 다른 두 개 이상의 유한한 값이 동일한 출력 값을 가지게 된다는 것이다.

다음의 예시를 보자

<img width="777" alt="스크린샷 2021-04-19 오후 11 53 05" src="https://user-images.githubusercontent.com/58363663/115256691-6d763200-a16a-11eb-8dc7-181b63e2e38c.png">

다음과 같이 해쉬함수를 통해 동일한 해시값이 나온경우를 해시충돌이라고 한다.

당연히 이러한 문제를 해결하는 방법이 있다.

### 해결책

### 1. Separate Chaining

<img width="862" alt="스크린샷 2021-04-19 오후 9 54 19" src="https://user-images.githubusercontent.com/58363663/115255225-02782b80-a169-11eb-9027-799f5861f6fc.png">


위의 그림처럼 해시충돌이 일어날 경우 연결리스트를 통해 기존의 저장된 자료 다음에 위치시는 방법이다.

Chaining 장단점

장점 :

1) 한정된 저장소를 효율적으로 사용할 수 있다.

2) 해시 함수를 선택하는 중요성이 상대적으로 적다.(연결 리스트가 있기 때문에)

3) 상대적으로 적은 메모리를 사용한다. 미리 공간을 잡아 놓을 필요가 없다.

단점 :

1) 한 Hash에 자료들이 계속 연결된다면(쏠림 현상) 검색 효율이 낮아진다.

2) 외부 저장 공간을 사용한다.

3) 외부 저장 공간 작업을 추가로 해야 한다.

### 2. Open Addressing(개방주소법)

개방주소법은 데이터의 해시(hash)가 변경되지 않았던 chaining과는 달리 비어있는 해시(hash)를 찾아 데이터를 저장하는 기법이다. 따라서 개방주소법에서의 해시테이블은 1개의 해시와 1개의 값(value)가 매칭되어 있는 형태로 유지된다. 해시충돌이 일어날 경우 다음 비어있는 해시를 찾아 값을 저장하는 방식이다.

<img width="862" alt="스크린샷 2021-04-19 오후 10 32 24" src="https://user-images.githubusercontent.com/58363663/115255280-115ede00-a169-11eb-9e00-e696df87e959.png">

비어있는 해시(Hash)를 찾는 과정은 동일해야 한다.(일정한 규칙을 따라 찾아가야 한다.)

Open Addressing는 위에서 언급한 비어있는 해시를 찾는 규칙에 따라 다음과 같이 구분할 수 있다.

- 선형 탐색(Linear Probing): 다음 해시(+1)나 n개(+n)를 건너뛰어 비어있는 해시에 데이터를 저장한다.
- 제곱 탐색(Quadratic Probing): 충돌이 일어난 해시의 제곱을 한 해시에 데이터를 저장한다.
- 이중 해시(Double Hashing): 다른 해시함수를 한 번 더 적용한 해시에 데이터를 저장한다.

### Open Addressing의 장단점

장점 :

1) 다른 저장공간 없이 해시테이블 내에서 데이터 저장 및 처리가 가능하다.

2) 다른 저장공간에서의 추가적인 작업이 없다.

단점 :

1) 해시 함수(Hash Function)의 성능에 전체 해시테이블의 성능이 좌지우지된다.

2) 데이터의 길이가 늘어나면 그에 해당하는 저장소를 마련해 두어야 한다.

## 보안과 해시

1. MD5

   임의의 길이의 값을 입력 받아서 128비트 길이의 해시값을 출력하는 알고리즘이다.

   단방향 암호기때문에 입력값을 복원할 수 없다. 같은 입력값이라면 항상 같은 출력값이 나온다.

   현재는 보안과 관련된 용도로 사용하는것을 권장하지 않는다.

2. SHA

   **SHA**(Secure Hash Algorithm, 안전한 해시 알고리즘) 함수들은 서로 관련된 암호학적 해시 함수들의 모음이다. 이들 함수는 NSA이 1993년에 처음으로 설계했으며 미국 국가 표준으로 지정되었다. SHA 함수군에 속하는 최초의 함수는 공식적으로 **SHA**라고 불리지만, 나중에 설계된 함수들과 구별하기 위하여 **SHA-0**이라고도 불린다. 2년 만에 취약점이 발견되어 SHA-0의 변형인 **SHA-1**이 발표되었다.

   SHA-1 역시 해시 충돌을 이용한 위험성이 발견되어 차세대 버전이 나왔는데, 개선된 버전이 SHA-2 로 2001년에 발표되었다. 해시 길이에 따라서 224, 256, 384, 512 비트를 선택해서 사용할 수 있으며, 당연히 해시 길이가 길 수록 더 안전하다. 편의상 해시 길이에 따라 SHA-224, SHA-256, SHA-384, SHA-512 등으로 부른다. 일반적으로 SHA-256을 사용하고 그 이상을 권장한다.


## 해시 구현해보기

해시충돌의 솔루션인 Separate Chaining의 LinkedList를 사용하여 충돌이 났을 경우 LinkedList에 추가하는 방법을
구현해보았다. 해시함수는 간단하게 문자열의 아스키코드 합을 구하여 미리 지정한 배열의 사이즈로 나눈 나머지의 인덱스를 해시값으로 사용하였다.
당연히 이런 해쉬함수는 충돌이 나기 쉽다.

```java

import java.util.LinkedList;

public class Test {

    public static void main(String[] args) {
        HashTable table = new HashTable(3);
        table.put("이용훈", "hello");
        table.put("유현호", "asdf");
        table.put("우연희", "andigh");
        table.put("최지웅", "dkssud");
        table.put("송경희", "hi");
    }
    
}
class Node {
    private String key;
    private String value;

    public Node(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

class HashTable {
    private final LinkedList<Node>[] data;

    public HashTable(int size) {
        this.data = new LinkedList[size];
    }
    
    // 해시값을 배열의 길이로 나누어 인덱스 값을 결정
    public int convertToIndex(int hashcode) {
        return hashcode % data.length;
    }

    public void put(String key, String value) {
        int index = convertToIndex(HashFunction.of(key));
        LinkedList<Node> list = data[index];

        if (list == null) {
            list = new LinkedList<>();
            data[index] = list;
        }

        Node node = searchKey(list, key);

        if (node == null) {
            list.add(new Node(key, value));
        } else {
            node.setValue(value);
        }
    }

    private Node searchKey(LinkedList<Node> list, String key) {
        if (list == null) {
            return null;
        }

        for (Node node : list) {
            if (node.getKey().equals(key)) {
                return node;
            }
        }
        return null;
    }

    public String get(String key) {
        int index = convertToIndex(HashFunction.of(key));
        LinkedList<Node> list = data[index];
        Node node = searchKey(list, key);
        return node == null ? "Not found" : node.getValue();
    }
}

class HashFunction {
    // 키 값으로 오는 문자열을 아스키코드의 합으로 변환
    public static int of(String key) {
        int hashcode = 0;

        for (char c : key.toCharArray()) {
            hashcode += c;
        }

        return hashcode;
    }
}
```


해쉬 충돌 후 LinkedList의 추가된 모습

<img width="351" alt="스크린샷 2021-04-19 오후 11 30 32" src="https://user-images.githubusercontent.com/58363663/115256144-ecb73600-a169-11eb-8759-ae00ed48f5a2.png">



참고 자료

[Hash, Hashing, Hash Table(해시, 해싱 해시테이블) 자료구조의 이해](https://velog.io/@cyranocoding/Hash-Hashing-Hash-Table%ED%95%B4%EC%8B%9C-%ED%95%B4%EC%8B%B1-%ED%95%B4%EC%8B%9C%ED%85%8C%EC%9D%B4%EB%B8%94-%EC%9E%90%EB%A3%8C%EA%B5%AC%EC%A1%B0%EC%9D%98-%EC%9D%B4%ED%95%B4-6ijyonph6o)

[[암호학] 해시 함수, 해시 알고리즘, 해시 충돌, 해시 자료구조](https://yjshin.tistory.com/entry/%EC%95%94%ED%98%B8%ED%95%99-%ED%95%B4%EC%8B%9C-%ED%95%A8%EC%88%98-%EC%9E%91%EC%84%B1-%EC%A4%91)

[나무위키 : 해시](https://namu.wiki/w/%ED%95%B4%EC%8B%9C)

[위키디피아 : 해시](https://ko.wikipedia.org/wiki/%ED%95%B4%EC%8B%9C_%ED%95%A8%EC%88%98)
