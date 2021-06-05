package beakjoon.b7562;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] chess;
    static boolean[][] visit;
    static int[] X = new int[]{1, 2, 2, 1, -2, -1, 1, 2};
    static int[] Y = new int[]{-2, -1, 1, 2, 1, 2, 2, 1};
    static Queue<int[]> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());

        for (int i = 0; i < total; i++) {
            int size = Integer.parseInt(br.readLine());

            chess = new int[size][size];
            visit = new boolean[size][size];
            queue = new LinkedList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] start = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

            st = new StringTokenizer(br.readLine());
            int[] end = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

            queue.offer(start);
            visit[start[0]][start[1]] = true;
            while (!queue.isEmpty()) {

                int[] poll = queue.poll();

                for (int j = 0; j < 8; j++) {
                    int x = poll[0];
                    int y = poll[1];

                    int moveX = x + X[j];
                    int moveY = y + Y[j];

                    if (moveX >= 0 && moveY >= 0 && moveX < chess.length && moveY < chess.length) {
                        if (!visit[moveX][moveY]) {
                            visit[moveX][moveY] = true;
                            chess[moveX][moveY] = chess[x][y] + 1;
                            queue.add(new int[]{moveX, moveY});
                        }
                    }
                }
            }

            System.out.println(chess[end[0]][end[1]]);
        }

    }
}
