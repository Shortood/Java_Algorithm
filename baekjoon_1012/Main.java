import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = { 0, 0, -1, 1 }, dy = { -1, 1, 0, 0 };
    static int[][] map;
    static boolean[][] visit;
    static int T, M, N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int result = 0;
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            visit = new boolean[N][M];

            for (int j = 0; j < K; j++) {
                int x, y;
                st = new StringTokenizer(br.readLine());
                y = Integer.parseInt(st.nextToken());
                x = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (map[j][k] == 1 && visit[j][k] == false) {
                        visit[j][k] = true;
                        result++;
                        dfs(j, k);
                    }
                }
            }
            System.out.println(result);
        }
    }

    static void dfs(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < N && ny < M && visit[nx][ny] == false && map[nx][ny] == 1) {
                visit[nx][ny] = true;
                dfs(nx, ny);
            }
        }
    }
}