import java.util.Scanner;

public class Main {
    static int N, M, r, c, d;
    static int cnt = 0;
    static int[][] map;
    static Boolean[][] visit;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    static int[] rdx = {1, 0, -1, 0}, rdy = {0, -1, 0, 1};

    public static void clear(int dir) {
        int nx, ny;
        while (true) {
            int dircnt = 0;
            while (dircnt < 4) {
                dir--;
                if (dir < 0) dir = 3;
                nx = r + dx[dir];
                ny = c + dy[dir];
                if (nx >= 0 && ny >= 0 && map[nx][ny] == 0 && visit[nx][ny] == false) {
                    cnt++;
                    visit[nx][ny] = true;
                    r = nx;
                    c = ny;
                    break;
                }
                dircnt++;
            }

            if (dircnt != 4) { //빈 칸 있음
                d = dir;
            } else { //빈 칸 없음
                if (map[r + rdx[dir]][c + rdy[dir]] != 1) { //후진 가능
                    r += rdx[dir];
                    c += rdy[dir];
                } else break;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();
        d = sc.nextInt();
        map = new int[N][];
        visit = new Boolean[N][];
        for (int i = 0; i < N; i++) {
            map[i] = new int[M];
            visit[i] = new Boolean[M];
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
                if (i == r && j == c)
                    visit[i][j] = true;
                else
                    visit[i][j] = false;
            }
        }
        clear(d);
        System.out.println(cnt + 1);
    }
}
