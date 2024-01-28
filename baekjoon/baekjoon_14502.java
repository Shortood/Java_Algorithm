import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {
    static int N, M, result = 0;
    static int[][] map;
    static Boolean[][] visit;

    public static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void initVisit() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visit[i][j] = false;
            }
        }
    }

    public static void spread(int[][] map) {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        Queue<Pair> queue = new LinkedList<>();
        int x, y, nx, ny;
        int cnt = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 2) {
                    queue.add(new Pair(i, j));
                    cnt++;
                }
            }
        }

        initVisit();

        do {
            x = queue.peek().x;
            y = queue.peek().y;
            queue.remove();

            for (int i = 0; i < 4; i++) {
                nx = x + dx[i];
                ny = y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (map[nx][ny] == 0 && visit[nx][ny] == false) {
                        queue.add(new Pair(nx, ny));
                        visit[nx][ny] = true;
                        cnt++;
                    }
                }
            }
        } while (!queue.isEmpty());

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++)
                if (map[i][j] == 1) cnt++;
        }

        if (result < (N * M - cnt)) result = (N * M - cnt);
    }

    static public void DFS(int x, int y, int[][] map, int index) {
        if (index < 3) {
            for (int i = x; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (i == x && j == 0) j = y;
                    if (map[i][j] == 0) {
                        map[i][j] = 1;
                        DFS(i, j, map, index + 1);
                        map[i][j] = 0;
                    }
                }
            }
        } else
            spread(map);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][];
        visit = new Boolean[N][];
        for (int i = 0; i < N; i++) {
            map[i] = new int[M];
            visit[i] = new Boolean[M];
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        DFS(0, 0, map, 0);
        System.out.println(result);
    }

}
