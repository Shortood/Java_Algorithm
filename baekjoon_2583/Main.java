import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int M, N, K;
    static int[][] map;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int x = x1; x < x2; x++) {
                for (int y = y1; y < y2; y++) {
                    map[x][y] = 1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0 && visit[i][j] == false) {
                    visit[i][j] = true;
                    list.add(dfs(i, j));
                }
            }
        }
        System.out.println(list.size());
        list.sort(Comparator.naturalOrder());

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }

    }

    static int dfs(int x, int y) {
        int[] dx = { 1, -1, 0, 0 }, dy = { 0, 0, 1, -1 };
        int cnt = 1;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < N && ny < M && visit[nx][ny] == false && map[nx][ny] == 0) {
                visit[nx][ny] = true;
                cnt += dfs(nx, ny);
            }
        }
        return cnt;
    }
}