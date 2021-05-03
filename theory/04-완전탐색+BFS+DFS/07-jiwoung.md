# 완전탐색

- 모든 경우의 수를 전부 찾아서 답을 찾는 알고리즘



## 종류

1. 브루트포스 : 단순하게 처음부터 끝까지 탐색
2. 비트 마스크 : 이진수 표현 (AND,OR,XOR,SHIFT,NOT)
3. 재귀 함수
4. 순열
5. BFS(너비우선탐색), DFS(깊이우선탐색)



## 1. 재귀 함수

- 만들고자 하는 부분집합을 S'라고 할 때, S' = { } 부터 시작해서 각 원소에 대해서 해당 원소가 포함이 되면 S'에 넣고 재귀 함수를 돌려주고, 포함이 되지 않으면 S'를 그대로 재귀 함수에 넣어주는 방식

- 펙토리얼

  ```java
  
  	public static int fact(int n) {
  
  		if (n <= 1)
  
  			return n;
  
  		else 
  
  			return fact(n-1) * n;
  
  	}
  
  ```

  

## 2. 순열

- 순서가 부여된 임의의 집합을 다른 순서로 뒤섞는 연산

### 2-1 예시

1에서 5까지 적힌 카드가 한 장씩 있다. 이 중 세장을 뽑아서 세 자리 숫자를 만드는 방법의 경우의 수

=> 5*4*3=60가지

### 

## 3. DFS(깊이우선탐색)

- 루트 노드(혹은 다른 임의의 노드)에서 시작해서 다음 분기(branch)로 넘어가기 전에

  **해당 분기를 완벽하게 탐색**하는 방식

- 검색 속도 자체는 BFS에 비해서 느림

- 스택,재귀로 구현. 재귀로 구현하는게 보편적이고 짧은 코드작성 가능



### 3-1 문제 유형

- 모든 노드를 방문하고자 하는 경우(BFS도 상관없음)

- **경로의 특징**을 저장해둬야 하는 문제

  예를 들면 각 정점에 숫자가 적혀있고 a부터 b까지 가는 경로를 구하는데 경로에 같은 숫자가 있으면 안 된다는 문제 등, 각각의 경로마다 특징을 저장해둬야 할 때는 DFS를 사용. (BFS는 경로의 특징을 가지지 못합니다)

  

  

### 3-2 구현 순서

1. 탐색하려는 노드가 이미 탐색한 노드인지 확인
2. 탐색하려는 노드의 자식노드들을 확인
3. 자식노드가 없으면 탐색 종료
4. 자식노드가 있으면 자식노드를 같은 방식으로 탐색



### 3-3 구현

```java
 public static void dfs(int node, boolean[] visited) {
        if(visited[node]) return;
        
        visited[node] = true;
 
        for(int nextNode:nodeList[node]) {
            dfs(nextNode, visited, sb);
        }
    }

```



## 4. BFS(너비우선탐색)

- 루트 노드(혹은 다른 임의의 노드)에서 시작해서 **인접한 노드를 먼저** **탐색**하는 방법
- 검색 속도 자체는 BFS에 비해서 느림
- 스택,재귀로 구현. 재귀로 구현하는게 보편적이고 짧은 코드작성 가능
- 큐(Queue) 사용



### 3-1 문제 유형

- 두 노드 사이의 최단 경로

- 미로 찾기 

  ```
  
  ```

  등 최단거리를 구해야 할 경우, BFS가 유리.

  DFS일 경우 처음으로 발견된 해답이 최단거리가 아닐수도 있지만,
  BFS는 현재 노드에서 가까운 곳부터 찾기 때문에 경로를 탐색 시 먼저 찾아지는 해답이 곧 최단거리기 때문입니다.

### 3-2 구현 순서

- 시작 정점으로부터 가까운 정점을 먼저 방문하고 멀리 떨어져 있는 정점을 나중에 방문하는 순회



### 3-3 구현



```java
  public static void bfs(int node, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<Integer>();
        
        queue.offer(node);
        
        while(!queue.isEmpty()) {
            node = queue.poll();
            
            if(visited[node]) continue;
            
            visited[node] = true;
            
            for(int nextNode:nodeList[node]) {
                queue.add(nextNode);
            }
        }
    }

```



![출처 https://namu.wiki/w/BFS](https://blog.kakaocdn.net/dn/cQYkI8/btqB8oDsMGe/EEYm0cKGYhxTR0kJhGiJPK/img.gif)

