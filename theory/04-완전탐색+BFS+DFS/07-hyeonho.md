## 1. 완전 탐색이란

### - '**모든 경우의 수를 전부 찾아서 답을 찾는 알고리즘**'
- 장점 : 알고리즘을 풀때 가장 강력하고 확실한 방법
- 단점 : 시간이 가장 오래 걸리는 탐색 기법.

## 완전 탐색 기법 종류

### 1.조건문과 반복문으로 탐색하는 과정

- for문과 if문을 이용하여 처음부터 끝까지 탐색하는 방법
1. **3중 반복문** 혹은 **2중 반복문**을 이용하면 원하는 모든 경우를 탐색할 수 있다.
2. 하지만, **이중 반복문(O(n^2)), 삼중 반복문(O(n^3))의 시간 복잡도**를 가지기 때문에 비효율적이다.

→ 난이도가 올라가는 문제일수록 시간복잡도에 걸려 사용하지 못 하는 케이스가 많았다.

### **2.순열 & 조합을 이용하여 탐색하는 방법**

- 서로 다른 n개의 원소에서 r개를 중복 허용하지 않고 선택하여 순서대로 늘여놓는 방법
- 순서가 있으면 순열! 순서가 없으면 조합!
1. 중첩 for문을 사용
2. 재귀 호출을 사용

순열에는 Swap을 이용한 순열과 visited 배열을 이용한 순열이 있다. swap을 이용한 순열은 순서가 보장되지 않기 때문에 순서를 보장해야한다면 visited 배열을 이용한 순열을 사용한다.

시간 복잡도가 O(n!) 이므로 주의한다.

- 조합

[https://github.com/algorithm-study-haeyo/algorithem-study-heayo/blob/main/1주차/2일차/5568번/yhh.md](https://github.com/algorithm-study-haeyo/algorithem-study-heayo/blob/main/1%EC%A3%BC%EC%B0%A8/2%EC%9D%BC%EC%B0%A8/5568%EB%B2%88/yhh.md)

- 순열

[https://github.com/algorithm-study-haeyo/algorithem-study-heayo/blob/main/1주차/2일차/9742번/yhh.md](https://github.com/algorithm-study-haeyo/algorithem-study-heayo/blob/main/1%EC%A3%BC%EC%B0%A8/2%EC%9D%BC%EC%B0%A8/9742%EB%B2%88/yhh.md)

### **3. DFS, BFS**

- **DFS(깊이 우선 탐색)**

    가장 최상위 노드부터 하위노드까지 제일 깊게 탐색하고, 다시 위로 올라가서 깊게 탐색하는 방법

    - 문제 접근 방법
    1. 함수를 탈출할 조건을 작성한다.
    2. 방문 여부를 확인 조건을 작성한다.
    3. 재귀함수를 이용해서 하위 노드를 탐색하도록 한다.

- **BFS(넓이 우선 탐색)**

    가장 최상위 노드부터 다음 차수(degree)를 모두 탐색하고, 하위 노드를 탐색하는 방법

    - 문제 접근 방법
    1.Queue를 생성한 후, node를 추가한다.
    2.반복문(while)을 돌면서 Queue 요소들이 모두 반환될 때까지 반복
    3.같은 차수에 있는 결과 값을 추가하고  그 후, 하위 노드를 추가 하록 로직 구현
- DFS와 BFS(1260)

### - DFS(**Depth First Search)**

![Untitled](https://user-images.githubusercontent.com/58363663/116887600-733d3e80-ac65-11eb-9224-a592a0a244d5.png)


- 그래프의 모든 정점을 발견하는 가장 단순하고 고전적인 방법
- 현재 정점과 인접한 간선들을 하나씩 검사하다가,  아직 방문하지 않은 정점을 발견하면 그 정점으로 이동
- 위 과정에서 더이상 갈 곳이 없는 막힌 정점에 도달하면, 마지막에 따라왔던 간선을 따라 뒤로 돌아가기**(Stack 사용, 재귀함수를 사용한다면 백트래킹으로 Stack 원리 구현)**

**DFS 과정 참고**

![Untitled1](https://user-images.githubusercontent.com/58363663/116887630-7b957980-ac65-11eb-94c4-41a3a48f6f94.png)


### - **BFS(Breadth First Search)**

![Untitled](https://user-images.githubusercontent.com/58363663/116887719-90720d00-ac65-11eb-91af-3852dca342e7.png)


- 시작점에서 가까운 정점부터 순서대로 방문하는 탐색 알고리즘
- 너비 우선 탐색은 각 정점을 방문할 때마다 모든 인접 정점들 검사
- 인접 정점들을 검사하는 중, 방문하지 않은 정점이 있다면 별도의 위치**(Queue)**에 방문 예정으로 저장
- 인접 정점을 모두 검사한 후에는 저장 목록(Queue)에서 다음 정점을 꺼내서 방문!

**BFS 과정 참고**

![Untitled1](https://user-images.githubusercontent.com/58363663/116887743-9962de80-ac65-11eb-823c-6a2d38f6ad25.png)

---
