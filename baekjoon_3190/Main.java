import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int[] dx = { 0, 1, 0, -1 }, dy = { 1, 0, -1, 0 };
        StringTokenizer st;
        int[][] map = new int[N][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x - 1][y - 1] = 2;
        }
        int L = Integer.parseInt(br.readLine());
        int[] X = new int[L];
        String[] C = new String[L];

        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            X[i] = Integer.parseInt(st.nextToken());
            C[i] = st.nextToken();
        }
        Deque<Pair> deque = new ArrayDeque<>();
        // 이동 시작
        deque.add(new Pair(0, 0));
        map[0][0] = 1;

        int dir = 0, cnt = 0, dirCnt = 0; // 0 동 1 남 2 서 3 북
        while (true) {
            if (dirCnt < L && cnt == X[dirCnt]) { // 방향 전환해야함
                if (C[dirCnt].equals("D"))
                    dir = (dir + 1) % 4;
                else {
                    dir--;
                    if (dir == -1)
                        dir = 3;
                }
                dirCnt++;
            }

            int nx = deque.getFirst().x + dx[dir];
            int ny = deque.getFirst().y + dy[dir];
            if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] != 1) {// 안 멈춤
                deque.addFirst(new Pair(nx, ny));
                if (map[nx][ny] != 2) { // 사과가 없다면
                    Pair temp = deque.pollLast(); // 꼬리 줄임
                    map[temp.x][temp.y] = 0;
                }
                map[nx][ny] = 1;
            } else // 부딫힘
                break;
            cnt++;
        }
        System.out.println(cnt + 1);
    }

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}