import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//바깥쪽 빈칸 queue에 다넣기
//queue와 접촉된 치즈 녹이기
//녹이고 나서 방문 안한 빈 공간이 주변에 있는지 확인
//녹은 0과 접촉한 0도 새로운 queue에 넣기
public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visit;
    static Queue<Pair> queue = new LinkedList<>();
    static int[] dx = { 1, -1, 0, 0 }, dy = { 0, 0, 1, -1 };

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
                if ((i == 0 || j == 0 || i == N - 1 || j == M - 1) && !visit[i][j]) {
                    queue.offer(new Pair(i, j));
                    visit[i][j] = true;
                    dfs(i, j);
                }
            }
        }

        int hour = -1;
        int cnt = 0;
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            count = cnt;
            cnt = 0;
            for (int i = 0; i < size; i++) {
                Pair now = queue.remove();
                for (int j = 0; j < 4; j++) {
                    int nx = now.x + dx[j], ny = now.y + dy[j];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visit[nx][ny]) {
                        queue.offer(new Pair(nx, ny));
                        visit[nx][ny] = true;
                        if (map[nx][ny] == 1) { // 녹이기
                            map[nx][ny] = 0;
                            cnt++;
                        }
                        // 새로운 구멍
                        dfs(nx, ny);
                    }
                }
            }
            hour++;
        }
        System.out.println(hour + "\n" + count);
    }

    static void dfs(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visit[nx][ny] && map[nx][ny] == 0) {
                queue.offer(new Pair(nx, ny));
                visit[nx][ny] = true;
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