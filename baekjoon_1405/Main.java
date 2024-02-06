import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] dx = { 0, 0, 1, -1 }, dy = { 1, -1, 0, 0 };
    static double[] pos = new double[4];
    static double result = 0;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < 4; i++) {
            pos[i] = (double) Integer.parseInt(st.nextToken()) / 100;
        }

        visit = new boolean[2 * N + 1][2 * N + 1];
        visit[N][N] = true;
        dfs(N, N, 0, 1);
        System.out.println(result);
    }

    // 남,북,동,서
    static void dfs(int x, int y, int cnt, double totalPos) {
        if (cnt == N) {
            result += totalPos;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx <= 2 * N && ny <= 2 * N && !visit[nx][ny]) {
                visit[nx][ny] = true;
                dfs(nx, ny, cnt + 1, totalPos * pos[i]);
                visit[nx][ny] = false;
            }
        }
    }
}