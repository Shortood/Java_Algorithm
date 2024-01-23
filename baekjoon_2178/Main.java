import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, M;
        String input;
        StringTokenizer st;
        Queue<Pair> queue = new LinkedList<>();
        int[] dx = { 0, 0, -1, 1 }, dy = { 1, -1, 0, 0 };

        input = br.readLine();
        st = new StringTokenizer(input);
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        int[][] visit = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] input2 = br.readLine().split("");
            for (int j = 0; j < M; j++)
                map[i][j] = Integer.parseInt(input2[j]);
        }

        queue.offer(new Pair(0, 0));
        Pair pair;
        while (!queue.isEmpty()) {
            int nextX, nextY;
            pair = queue.remove();
            for (int i = 0; i < 4; i++) {
                nextX = pair.x + dx[i];
                nextY = pair.y + dy[i];

                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {
                    if (nextX == N - 1 && nextY == M - 1) {
                        System.out.println((visit[pair.x][pair.y] + 1));
                        return;
                    }
                    if (map[nextX][nextY] == 1 && visit[nextX][nextY] == 0) {
                        visit[nextX][nextY] = visit[pair.x][pair.y] + 1;
                        queue.offer(new Pair(nextX, nextY));
                    }
                }
            }
        }
    }

}

class Pair {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}