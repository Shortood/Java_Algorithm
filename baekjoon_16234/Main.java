import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] visit;
    static int[][] map;
    static int N, L, R, sum;
    static int[] dx = { 1, -1, 0, 0 }, dy = { 0, 0, 1, -1 };
    static Queue<Pair> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean isMove;
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        while (true) {
            isMove = false; // 인구 이동 여부
            visit = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visit[i][j]) {
                        sum = 0; // 인구 합
                        dfs(i, j);
                        if (queue.size() > 1) { // 인구 이동 해야함
                            isMove = true;
                            int newNum = sum / queue.size(); // 인구 이동 후 값
                            while (!queue.isEmpty()) {
                                Pair now = queue.remove();
                                map[now.x][now.y] = newNum;
                            }
                        }
                        queue.clear();
                    }
                }
            }
            if (!isMove)
                break;
            result++;
        }
        System.out.println(result);
    }

    static void dfs(int x, int y) {
        sum += map[x][y];
        visit[x][y] = true;
        queue.offer(new Pair(x, y));
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visit[nx][ny]
                    && Math.abs(map[x][y] - map[nx][ny]) >= L && Math.abs(map[x][y] - map[nx][ny]) <= R) {
                dfs(nx, ny);
            }
        }
    }

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}