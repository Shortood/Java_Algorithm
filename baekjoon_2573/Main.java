import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map, map2;
    static int[] dx = { 1, -1, 0, 0 }, dy = { 0, 0, 1, -1 };
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int result = 0;
        while (true) {
            map2 = new int[N][M];
            for (int i = 1; i < N - 1; i++) {
                for (int j = 1; j < M - 1; j++) {
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k], ny = j + dy[k];
                        if (map[nx][ny] == 0)
                            map2[i][j]++;
                    }

                }
            }
            // 빙산 녹이기
            int cnt = 0;
            for (int i = 1; i < N - 1; i++) {
                for (int j = 1; j < M - 1; j++) {
                    map[i][j] -= map2[i][j];
                    if (map[i][j] < 0)
                        map[i][j] = 0;
                    if (map[i][j] > 0)
                        cnt++;
                }
            }

            if (cnt == 0) {
                System.out.println(0);
                return;
            }

            result++;
            if (find()) {
                System.out.println(result);
                return;
            }
        }
    }

    static boolean find() {
        visit = new boolean[N][M];
        boolean isDivide = false;
        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < M - 1; j++) {
                if (map[i][j] > 0 && !visit[i][j]) {
                    if (!isDivide) {
                        dfs(i, j);
                        isDivide = true;
                    } else
                        return true;
                }
            }
        }
        return false;
    }

    static void dfs(int x, int y) {
        visit[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            if (map[nx][ny] > 0 && !visit[nx][ny])
                dfs(nx, ny);
        }
    }
}