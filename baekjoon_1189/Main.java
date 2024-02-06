import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R, C, K, result = 0;
    static int[] dx = { 1, -1, 0, 0 }, dy = { 0, 0, 1, -1 };
    static char[][] map;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visit = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }
        visit[R - 1][0] = true;
        dfs(R - 1, 0, 0);
        System.out.println(result);
    }

    static void dfs(int x, int y, int cnt) {
        if (x == 0 && y == C - 1) {
            if (cnt == K - 1)
                result++;
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < R && ny < C && visit[nx][ny] == false && map[nx][ny] != 'T') {
                visit[nx][ny] = true;
                dfs(nx, ny, cnt + 1);
                visit[nx][ny] = false;
            }
        }
    }
}