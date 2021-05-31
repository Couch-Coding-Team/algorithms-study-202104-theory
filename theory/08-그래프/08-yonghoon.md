# 그래프
## 1. 그래프란??
- 그래프는 연결되어 있는 객체 간의 관계를 표현할 수 있는 자료구조이다
- 대표적인 예로 지도가 있다
- 그래프의 구성 : vertex, edge
- 그래프의 표현 : G=(V,E) graph는 vertex와 edge의 집합이다
- weighted graph : edge에 가중값이 있는 그래프
- undirected edge : (A,B)로 나타낸다
- directed edge : <A,B>로 나타낸다
- 그래프로 표현이 가능한 것 : 도로, 인접 관계, 선수과목(순서가 있는 것들) 등등
- adjacent vertex : edge에 의해 직접 연결되어있는 vertex를 의미한다
- degree : vertex에 연결된 edge의 갯수
- in-degree : vertex에 들어오는 방향으로 연결된 edge의 갯수
- out-degree : vertex에서 나가는 방향으로 연결된 edge의 갯수
- path length : path를 구성하는 데 사용된 vertex의 갯수
- simple path : 반복되는 vertex가 없는 path
- cycle : 시작 vertex와 종료 vertex가 같은 path
- 완전 그래프 : 그냥 간단히 말해서 edge가 꽉 찬 그래프이다!



## 2. 그래프의 표현 방법
### 행렬로 표현하기
- vertex 사이의 연결관계를 2X2 배열로 표현한다(0이면 비인접, 1이면 인접)
- 장점 : dense한 경우에 더 좋다, 구현이 쉽다, 접근 속도가 빠르다
- 단점 : 메모리 비유동적
- 행렬구현 에서 차수 구하는 방법 : 해당 vertex의 row의 값을 모두 더하면 된다.
- 전체 간선의 수를 구하는 데 걸리는 시간 복잡도 : O(n^2). nXn 모두 조사해야 한다

### 링크드 리스트로 표현하기
- 각 vertex 마다 노드를 만들어 놓은 뒤에 노드끼리 연결되면 해당 vertex들은 연결된 것으로 생각하여 표현한다 + 노드들을 저장하는 array 하나를 따로 구현해야만 한다
- 장점 : sparse한 경우에 더 좋다, 메모리 유동적
- 단점 : 구현이 어렵다, 접근 속도가 덜 빠르다!



## 3. 그래프의 탐색
### 깊이 우선 탐색(DFS)
- 미로 탐색 과정과 비슷한다
- 시작 vertex에서 시작해서 방문하지 않은 vertex를 방문한다. 방문하지 않은 vertex가 없는 상태라면(=더이상 진행이 안되면) 다시 돌아온다. 그런 뒤에 아직 방문되지 않은 vertex에 대하여 위의 과정을 거친다. 즉, recursive하게 구현이 가능하다
- 스택을 사용하는 방법도 있다
 <img width="841" alt="image" src="https://user-images.githubusercontent.com/56704377/120163082-13ba5a80-c234-11eb-809b-09aa044b4716.png">
```python
print('hello')
```

	
### 너비 우선 탐색(BFS)
- 가까운 vertex를 먼저 방문하고 멀리 떨어져 있는 vertex를 나중에 방문하는 방법이다
- 큐를 사용해야만 한다
- 큐가 empty일때 까지 탐색을 계속 진행한다
- 처음에는 시작 vertex의 값을 enqueue한다!
