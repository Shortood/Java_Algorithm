import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = { 1, -1, 0, 0 }, dy = { 0, 0, 1, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int height = 1;
        int max = 1;
        while (true) {
            int result = 0;
            visit = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] > height && visit[i][j] == false) {
                        result++;
                        visit[i][j] = true;
                        dfs(i, j, height);
                    }
                }
            }

            if (result > max)
                max = result;
            if (result == 0 || height >= 100)
                break;
            height++;
        }

        System.out.println(max);
    }

    static void dfs(int x, int y, int height) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < N && ny < N && map[nx][ny] > height && visit[nx][ny] == false) {
                visit[nx][ny] = true;
                dfs(nx, ny, height);
            }
        }
    }
}