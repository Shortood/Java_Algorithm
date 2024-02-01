import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K, result = 0;
    static int[] dx = { 1, -1, 0, 0 }, dy = { 0, 0, 1, -1 };
    static int[][] map;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int dfsResult;
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N + 1][M + 1];
        visit = new boolean[N + 1][M + 1];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (map[i][j] == 1 && visit[i][j] == false) {
                    visit[i][j] = true;
                    dfsResult = dfs(i, j);
                    if (result < dfsResult)
                        result = dfsResult;

                }
            }
        }
        System.out.println(result);
    }

    static int dfs(int x, int y) {
        System.out.println("dfs " + x + " " + y);
        int cnt = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            if (nx > 0 && ny > 0 && nx <= N && ny <= M && map[nx][ny] == 1 && visit[nx][ny] == false) {
                System.out.println("next");
                visit[nx][ny] = true;
                cnt += dfs(nx, ny);
            }
        }
        return cnt;
    }
}