import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N, M;
    static int[][] map;

    public static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void spread(int[][] map) {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        Queue<Pair> queue = new LinkedList<>();
        int x, y, nx, ny;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 2) queue.add(new Pair(i, j));
            }
        }

        while (queue.isEmpty()) {
            x = queue.peek().x;
            y = queue.peek().y;
            queue.remove();
            for (int i = 0; i < 4; i++) {
                nx = x + dx[i];
                ny = y + dy[i];
                if (nx > 0 && ny > 0 && nx < N && ny < M) {
                    if (map[nx][ny] == 0) queue.add(new Pair(nx, ny));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][];

        for (int i = 0; i < N; i++) {
            map[i] = new int[M];
            for (int j = 0; j < M; j++)
                map[i][j] = sc.nextInt();
        }
        spread(map);

    }

}
