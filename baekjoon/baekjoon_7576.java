import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int M, N, cnt = 0, result = 0;
        int[] dx = { 0, 0, -1, 1 }, dy = { 1, -1, 0, 0 };
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Pair> queue = new LinkedList<>();

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1)
                    queue.offer(new Pair(i, j));
                else if (map[i][j] == 0)
                    cnt++;
            }
        }

        Pair temp;
        int nx, ny;
        while (cnt > 0) {
            result++;
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                temp = queue.remove();
                for (int j = 0; j < 4; j++) {
                    nx = temp.x + dx[j];
                    ny = temp.y + dy[j];
                    if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                        if (map[nx][ny] == 0) {
                            queue.offer(new Pair(nx, ny));
                            map[nx][ny] = 1;
                            cnt--;
                        }
                    }
                }
            }
            if (queue.isEmpty()) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(result);

    }
}

class Pair {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}