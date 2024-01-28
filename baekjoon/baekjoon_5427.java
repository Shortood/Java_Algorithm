import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static int N, h, w;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        int[] dx = { 1, -1, 0, 0 }, dy = { 0, 0, 1, -1 };
        int result = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] visit;
        Queue<Tuple> Pqueue = new LinkedList<>(), Fqueue = new LinkedList<>();
        Tuple start, temp;

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            boolean flag = false;
            StringTokenizer st = new StringTokenizer(br.readLine());

            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            map = new char[h][w];
            visit = new int[h][w];

            // 입력
            for (int j = 0; j < h; j++) {
                map[j] = br.readLine().toCharArray();
                for (int k = 0; k < w; k++) {
                    if (map[j][k] == '@') {
                        start = new Tuple(j, k);
                        Pqueue.offer(start);
                        map[j][k] = '.';
                    } else if (map[j][k] == '*')
                        Fqueue.offer(new Tuple(j, k));
                }
            }

            while (true) {
                int Fsize = Fqueue.size();
                // 불 이동
                for (int index = 0; index < Fsize; index++) {
                    temp = Fqueue.remove();
                    int nx, ny;
                    for (int p = 0; p < 4; p++) {
                        nx = temp.x + dx[p];
                        ny = temp.y + dy[p];
                        if (nx >= 0 && ny >= 0 && nx < h && ny < w) {
                            if (map[nx][ny] == '.') {
                                map[nx][ny] = '*';
                                Fqueue.offer(new Tuple(nx, ny));
                            }
                        }
                    }
                }

                // 사람 이동
                int PSize = Pqueue.size();
                for (int index = 0; index < PSize; index++) {
                    temp = Pqueue.remove();
                    int nx, ny;
                    for (int p = 0; p < 4; p++) {
                        nx = temp.x + dx[p];
                        ny = temp.y + dy[p];
                        if (nx >= 0 && ny >= 0 && nx < h && ny < w) {
                            if (map[nx][ny] == '.' && visit[nx][ny] == 0) {
                                visit[nx][ny] = visit[temp.x][temp.y] + 1;
                                Pqueue.offer(new Tuple(nx, ny));
                            }
                        } else { // 탈출
                            flag = true;
                            result = visit[temp.x][temp.y] + 1;
                        }
                    }
                }

                if (flag == true) {
                    System.out.println(result);
                    break;
                }

                if (Pqueue.isEmpty()) { // 불가능
                    System.out.println("IMPOSSIBLE");
                    break;
                }
            }
            Fqueue.clear();
            Pqueue.clear();
        }
    }
}

class Tuple {
    int x;
    int y;

    Tuple(int x, int y) {
        this.x = x;
        this.y = y;
    }
}