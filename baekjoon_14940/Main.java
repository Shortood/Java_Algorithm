import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()),
                m = Integer.parseInt(st.nextToken());
        int[] dx = { 1, -1, 0, 0 }, dy = { 0, 0, 1, -1 };
        int[][] map = new int[n][m];
        boolean[][] visit = new boolean[n][m];
        Queue<Pair> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    queue.offer(new Pair(i, j));
                    map[i][j] = 0;
                    visit[i][j] = true;
                } else if (map[i][j] == 0)
                    visit[i][j] = true;

            }
        }

        while (!queue.isEmpty()) {
            Pair now = queue.remove();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i], ny = now.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visit[nx][ny]) {
                    map[nx][ny] = map[now.x][now.y] + 1;
                    visit[nx][ny] = true;
                    queue.offer(new Pair(nx, ny));
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visit[i][j])
                    System.out.print("-1 ");
                else
                    System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

    }
}

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}