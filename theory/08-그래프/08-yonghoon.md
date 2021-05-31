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
