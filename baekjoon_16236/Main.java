import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//bfs 통해 이동할 좌표 구하기 dep가 걸리는 시간
//이동 후 값 바꾸고 상어 위치 변경, visit 초기화
//bfs 뽑을 때 map 값이 1이상 상어크기 이하면 이동
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        int[] dx = { -1, 0, 0, 1 }, dy = { 0, -1, 1, 0 };
        int result = 0;
        boolean[][] visit = new boolean[N][N];
        PriorityQueue<Pair> queue = new PriorityQueue<>(
                new Comparator<Pair>() {
                    @Override
                    public int compare(Pair o1, Pair o2) {
                        if (o1.dep == o2.dep && o1.x == o2.x) {
                            return o1.y - o2.y;
                        } else if (o1.dep == o2.dep) {
                            return o1.x - o2.x;
                        } else
                            return o1.dep - o2.dep;
                    }
                });

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    queue.offer(new Pair(i, j, 0));
                    map[i][j] = 0;
                    visit[i][j] = true;
                }
            }
        }

        int size = 2, stack = 0;
        while (!queue.isEmpty()) {
            Pair now = queue.remove();
            if (map[now.x][now.y] >= 1 && map[now.x][now.y] < size) { // 이동
                result += now.dep;
                visit = new boolean[N][N]; // 방문 초기화
                visit[now.x][now.y] = true;
                stack++;
                if (size == stack) { // 크기 증가
                    size++;
                    stack = 0;
                }
                map[now.x][now.y] = 0;
                queue.clear();
                queue.offer(new Pair(now.x, now.y, 0));
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i], ny = now.y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visit[nx][ny] && map[nx][ny] >= 0
                        && map[nx][ny] <= size) {
                    queue.offer(new Pair(nx, ny, now.dep + 1));
                    visit[nx][ny] = true;
                }
            }
        }
        System.out.println(result);
    }

    static class Pair {
        int x, y, dep;

        public Pair(int x, int y, int dep) {
            this.x = x;
            this.y = y;
            this.dep = dep;
        }
    }
}