import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int R, C, result = 0;
        char[][] map;
        boolean[][] visit;
        int[] dx = { 0, 0, 1, -1 }, dy = { 1, -1, 0, 0 };
        StringTokenizer st = new StringTokenizer(br.readLine());
        Pair end;
        Queue<Pair> Gqueue = new LinkedList<>(), Wqueue = new LinkedList<>();

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visit = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'S') {
                    Gqueue.offer(new Pair(i, j));
                    map[i][j] = '.';
                } else if (map[i][j] == 'D')
                    end = new Pair(i, j);
                else if (map[i][j] == '*')
                    Wqueue.offer(new Pair(i, j));
            }
        }

        while (!Gqueue.isEmpty()) {
            result++;
            // 물
            int qSize = Wqueue.size(), nx, ny;
            Pair tempQ;
            for (int i = 0; i < qSize; i++) {
                tempQ = Wqueue.remove();
                for (int j = 0; j < 4; j++) {
                    nx = tempQ.x + dx[j];
                    ny = tempQ.y + dy[j];
                    if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
                        if (map[nx][ny] == '.') {
                            map[nx][ny] = '*';
                            Wqueue.offer(new Pair(nx, ny));
                        }
                    }
                }
            }

            // 고슴도치
            qSize = Gqueue.size();
            for (int i = 0; i < qSize; i++) {
                tempQ = Gqueue.remove();
                for (int j = 0; j < 4; j++) {
                    nx = tempQ.x + dx[j];
                    ny = tempQ.y + dy[j];
                    if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
                        if (map[nx][ny] == 'D') {
                            System.out.println(result);
                            return;
                        } else if (map[nx][ny] == '.' && visit[nx][ny] == false) {
                            visit[nx][ny] = true;
                            Gqueue.offer(new Pair(nx, ny));
                        }
                    }
                }
            }
        }
        System.out.println("KAKTUS");
    }
}

class Pair {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}