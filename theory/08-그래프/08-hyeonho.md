## 그래프

 그래프는 정점과 간선으로 이루어진 자료구조다. 정점(Vertex)간의 관계를 표현하는 조직도라고 볼수도 있겠습니다. 그런면에서 트리는 그래프의 일종인 셈입니다. 다만 트리와는 달리 그래프는 정점마다 간선이 없을수도 있고 있을수도 있으며 루트 노드, 부모와 자식이라는 개념이 존재하지 않습니다. 또한 그래프는 네트워크 모델 즉, 객체와 이에 대한 관계를 나타내는 유연한 방식으로 이해할 수 있습니다. 실생활에서 다양한 예를 그래프로 표현할 수 있습니다. 대표적으로 지하철 노선도, 도심의 도로등이 있습니다. 이런식으로 활용할 수 있는 방법이 많기에 문제도 다양하게 출제를 할 수 있습니다. 그래프는 알고리즘에서 굉장히 많이 사용됩니다. 특히 그래프를 순회하는 방식인 DFS와 BFS를 잘 알아두어야 합니다.

출처 : [https://coding-factory.tistory.com/610](https://coding-factory.tistory.com/610)

### **그래프에서 사용하는 용어**

![https://blog.kakaocdn.net/dn/cjbjPd/btqKgF6OzSD/U0a7BKCpfJlhx1iJzwsEy1/img.png](https://blog.kakaocdn.net/dn/cjbjPd/btqKgF6OzSD/U0a7BKCpfJlhx1iJzwsEy1/img.png)

**정점(vertice) :** 노드라고도 하며 정점에는 데이터가 저장

**간선(edge):** 링크라고도 하며 정점들을 연결하는 선

**차수(degree):** 정점에 연결되어 있는 간선의 수, 방향 그래프에서 진입/진출 차수의 합

**단순 경로(simple-path):** 같은 정점을 두 번 이상 방문하지 않는 경로

**진출 차수(out-degree) :** 방향그래프에서 정점에서 나가는 간선

**진입차수(in-degree) :** 방향그래프에서 정점으로 들어오는 간선

**인접 정점(adjacent vertex) :** 간선에 의해 직접 연결된 정점

### 그래프의 종류

**무방향 그래프(Undirected Graph)**

<img width="224" alt="스크린샷 2021-05-31 오후 11 47 33" src="https://user-images.githubusercontent.com/58363663/120210286-94944900-c26a-11eb-92d7-6adb3fdc235b.png">

무방향 그래프는 두 정점을 연결하는 간선에 방향이 없는 그래프이다. 정점 v1와 v2를 연결하는 간선을 [v1, v2]라고 하면, 이때 [v1, v2]와 [v2, v1]은 같은 간선이다.

**방향 그래프(Directed Graph)**

<img width="224" alt="스크린샷 2021-05-31 오후 11 47 57" src="https://user-images.githubusercontent.com/58363663/120210341-a37afb80-c26a-11eb-8ac1-b91c88086717.png">


방향 그래프는 다이그래프(digraph)라고도 하는데, 간선에 방향이 있는 그래프이다. 정점 v1와 v2를 연결하는 간선을 [v1, v2]라고 하면, 이때 [v1, v2]와 [v2, v1]은 같을 수 없다, [v1, v2]는 정점 v1에서 v2로만 갈 수 있는 간선을 의미한다.

**완전 그래프(Complete Graph)**

<img width="224" alt="스크린샷 2021-05-31 오후 11 48 06" src="https://user-images.githubusercontent.com/58363663/120210361-a83faf80-c26a-11eb-99c3-741f54b8868c.png">


완전 그래프는 한 정점에서 모든 다른 정점과 연결되어 최대의 간선수를 가지는 그래프다.

무방향 그래프에서의 최대 간선 수 : n(n-1)/2

방향 그래프에서의 최대 간선 수 : n(n-1)/1

**부분 그래프(subgraph)**

<img width="241" alt="스크린샷 2021-05-31 오후 11 49 12" src="https://user-images.githubusercontent.com/58363663/120210501-d02f1300-c26a-11eb-80e8-36b483a9e778.png">
원래의 그래프에서 일부의 정점이나 간선을 제외하여 만든 그래프를 의미한다.

**가중 그래프(Weight Graph)**

<img width="224" alt="스크린샷 2021-05-31 오후 11 48 24" src="https://user-images.githubusercontent.com/58363663/120210399-b392db00-c26a-11eb-881b-18f1bc4000ed.png">

정점을 연결하는 간선에 가중치를 할당한 그래프를 의미한다.
