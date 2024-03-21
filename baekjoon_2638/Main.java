import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Queue;

// 바깥 0들 dfs로 visit 처리
// 입력시 1들 list에 저장
// list 주변 보면서 주변에 visit 2이상이면 0으로 바꾸고 visit 처리
// or
// 0인 애들 dfs 돌림
// 주변에 0이고 !visit 면 dfs
// 1이고 !visit면 visit 처리
// 1이고 visit면 큐에 넣음
// 큐 pop 하면서 0으로 바꿈
// pop 주변에 !visit인 0있으면 dfs
public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = { 1, -1, 0, 0 }, dy = { 0, 0, 1, -1 };
    static Queue<Pair> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visit = new boolean[N][M];
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1)
                    cnt++;
            }
        }
        int day = 0;
        visit[0][0] = true;
        dfs(0, 0);

        while (!queue.isEmpty()) {
            System.out.println("size = " + queue.size());
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair now = queue.remove();
                if (map[now.x][now.y] == 1) {
                    map[now.x][now.y] = 0;
                    cnt--;
                    dfs(now.x, now.y);
                }
            }
            if (cnt == 0)
                break;
            day++;
        }

        System.out.println(day);
    }

    static void dfs(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                if (map[nx][ny] == 0 && !visit[nx][ny]) {
                    visit[nx][ny] = true;
                    dfs(nx, ny);
                } else if (map[nx][ny] == 1) {
                    if (!visit[nx][ny]) {
                        visit[nx][ny] = true;
                    } else { // 녹을 애들
                        queue.offer(new Pair(nx, ny));
                    }
                }
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