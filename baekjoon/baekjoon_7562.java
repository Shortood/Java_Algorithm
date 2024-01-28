import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int N, M, x, y;
        int[] dx = { -2, -1, 1, 2, 2, 1, -1, -2 }, dy = { -1, -2, -2, -1, 1, 2, 2, 1 };
        int[][] map;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Pair end;
        Queue<Pair> queue = new LinkedList<>();
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            boolean flag = false;
            M = Integer.parseInt(br.readLine());
            map = new int[M][M];

            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            queue.offer(new Pair(x, y));
            map[x][y] = 1;

            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            end = new Pair(x, y);

            Pair temp;
            int nx, ny;
            while (!queue.isEmpty() && flag == false) {
                temp = queue.remove();
                if (temp.x == end.x && temp.y == end.y)
                    break;

                for (int j = 0; j < 8; j++) {
                    nx = temp.x + dx[j];
                    ny = temp.y + dy[j];
                    if (nx >= 0 && ny >= 0 && nx < M && ny < M && map[nx][ny] == 0) {
                        queue.offer(new Pair(nx, ny));
                        map[nx][ny] = map[temp.x][temp.y] + 1;

                    }
                }
            }
            System.out.println(map[end.x][end.y] - 1);
            queue.clear();
        }
    }
}

class Pair {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}