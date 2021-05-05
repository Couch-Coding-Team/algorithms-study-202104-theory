```java
static boolean[] visit;

    public int solution(int n, int[][] computers) {
        int answer = 0;
        visit = new boolean[n];

        for (int node = 0; node < n; node++) {
            if (!visit[node]) {
                dfs(computers, node);
                answer++;
            }
        }

        System.out.println(answer);
        return answer;
    }

    private void dfs(int[][] computers, int node) {
        visit[node] = true;

        for (int j = 0; j < computers.length; j++) {
            if (visit[j] == false && computers[node][j] == 1) {
                dfs(computers, j);
            }
        }
    }

```
