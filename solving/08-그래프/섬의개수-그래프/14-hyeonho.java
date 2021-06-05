import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by yhh1056
 * Date: 2021/06/05 Time: 12:52 오후
 *
 * 섬의 개수
 *
 * BFS 풀이
 */
public class Main {

    static int[][] island;
    static boolean[][] visit;
    static Queue<int[]> queue;
    static int[] X = new int[]{1, -1, 0, 0, 1, 1, -1, -1};
    static int[] Y = new int[]{0, 0, 1, -1, -1, 1, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) {
                break;
            }

            island = new int[h][w];
            visit = new boolean[h][w];
            queue = new LinkedList<>();

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    island[i][j] = Integer.parseInt(st.nextToken());
                }
            }


            int count = 0;
            for (int i = 0; i < island.length; i++) {
                for (int j = 0; j < island[i].length; j++) {
                    count += bfs(i, j);
                }
            }

            System.out.println(count);
        }
    }

    private static int bfs(int x, int y) {
        if (island[x][y] == 0) {
            return 0;
        }

        queue.add(new int[]{x, y});
        visit[x][y] = true;
        island[x][y] = 0;
        while (!queue.isEmpty()) {

            int[] poll = queue.poll();
            x = poll[0];
            y = poll[1];

            for (int i = 0; i < 8; i++) {
                // 상하좌우 대각선 좌표 이동값
                int moveX = x + X[i];
                int moveY = y + Y[i];

                if (moveX >= 0 && moveY >= 0 && moveX < island.length && moveY < island[x].length) {
                    if (!visit[moveX][moveY] && island[moveX][moveY] == 1) {
                        visit[moveX][moveY] = true;
                        island[moveX][moveY] = 0;
                        queue.add(new int[]{moveX, moveY});
                    }
                }
            }
        }
        return 1;
    }

}
