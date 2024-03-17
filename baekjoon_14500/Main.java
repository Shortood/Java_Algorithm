import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = { 1, -1, 0, 0 }, dy = { 0, 0, 1, -1 };

    static int N, M, result = 0;
    static int[][] map;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visit[i][j] = true;
                dfs(i, j, 1, map[i][j]);
                visit[i][j] = false;
            }
        }
        System.out.println(result);
    }

    static void dfs(int x, int y, int cnt, int sum) {
        if (cnt == 4) {
            if (result < sum)
                result = sum;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visit[nx][ny]) {
                visit[nx][ny] = true;
                if (cnt == 2) { // 5번쨰 경우
                    dfs(x, y, cnt + 1, sum + map[nx][ny]);
                }
                dfs(nx, ny, cnt + 1, sum + map[nx][ny]);
                visit[nx][ny] = false;
            }
        }
    }
}