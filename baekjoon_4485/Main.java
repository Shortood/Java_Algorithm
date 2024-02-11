import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] dx = { 1, -1, 0, 0 }, dy = { 0, 0, 1, -1 };
    static int[][] map, result;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 1;
        while (true) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            result = new int[N][N];
            visit = new boolean[N][N];
            if (N == 0)
                break;

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    result[i][j] = Integer.MAX_VALUE;
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
            pq.offer(new Node(0, 0, map[0][0]));
            result[0][0] = map[0][0];

            while (!pq.isEmpty()) {
                Node now = pq.remove();
                if (visit[now.x][now.y])
                    continue;

                visit[now.x][now.y] = true;

                for (int i = 0; i < 4; i++) {
                    int nx = now.x + dx[i], ny = now.y + dy[i];
                    if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                        // 현재까지의 합 + 다음꺼 가중치
                        if (result[nx][ny] > result[now.x][now.y] + map[nx][ny]) {
                            result[nx][ny] = result[now.x][now.y] + map[nx][ny];
                            pq.offer(new Node(nx, ny, result[nx][ny]));
                        }
                    }
                }
            }
            System.out.println("Problem " + cnt + ": " + result[N - 1][N - 1]);
            cnt++;
        }
    }
}

class Node {
    int x, y, weight;

    public Node(int x, int y, int weight) {
        this.x = x;
        this.y = y;
        this.weight = weight;
    }
}