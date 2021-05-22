class Solution { final int DIV = 1000000007; 
                public int solution(int m, int n, int[][] puddles) {
                  
                  int[][] map = new int[n][m]; for (int[] v : puddles)
                    
                    map[v[1] - 1][v[0] - 1] = -1;
                  for (int i = 0; i < map.length; i++) {
                    
                    if (map[i][0] == -1) break; map[i][0] = 1; } 
                  for (int i = 0; i < map[0].length; i++) { 
                    if (map[0][i] == -1) break; map[0][i] = 1; }
                  for (int i = 1; i < n; i++) {
                    for (int j = 1; j < m; j++) { 
                      if (map[i][j] == -1) continue;
                      int left = map[i][j - 1] == -1 ? 0 : map[i][j - 1];
                      int up = map[i - 1][j] == -1 ? 0 : map[i - 1][j]; 
                      map[i][j] = (left + up) % DIV; } } return map[n - 1][m - 1]; } }
