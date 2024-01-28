import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        int L, R, C;
        int[] dx = { 1, -1, 0, 0, 0, 0 }, dy = { 0, 0, 1, -1, 0, 0 }, dz = { 0, 0, 0, 0, 1, -1 };
        String input;
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][][] map;
        int[][][] visit;
        Tuple start = null, end = null;
        Queue<Tuple> queue = new LinkedList<>();

        while (true) {
            input = br.readLine();
            st = new StringTokenizer(input);
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if (L == 0 && R == 0 && C == 0)
                break;

            map = new char[L][R][C];
            visit = new int[L][R][C];

            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    map[i][j] = br.readLine().toCharArray();
                    for (int k = 0; k < C; k++) {
                        if (map[i][j][k] == 'S')
                            start = new Tuple(i, j, k);
                        else if (map[i][j][k] == 'E')
                            end = new Tuple(i, j, k);
                    }
                }
                br.readLine();
            }

            int nx, ny, nz;
            Tuple now;
            boolean flag = false;

            queue.offer(start);

            while (!queue.isEmpty()) {
                now = queue.remove();
                for (int i = 0; i < 6; i++) {
                    nz = now.z + dz[i];
                    nx = now.x + dx[i];
                    ny = now.y + dy[i];
                    if ((nz >= 0) && (nx >= 0) && (ny >= 0) && (nz < L) && (nx < R) && (ny < C)) {
                        if ((map[nz][nx][ny] == '.' || map[nz][nx][ny] == 'E') && visit[nz][nx][ny] == 0) {
                            visit[nz][nx][ny] = visit[now.z][now.x][now.y] + 1;
                            if (map[nz][nx][ny] == 'E')
                                flag = true;
                            queue.offer(new Tuple(nz, nx, ny));
                        }
                    }
                }
            }
            if (flag == true)
                System.out.println("Escaped in " + visit[end.z][end.x][end.y] + " minute(s).");
            else
                System.out.println("Trapped!");

        }
    }
}

class Tuple {
    int x;
    int y;
    int z;

    Tuple(int i, int j, int k) {
        this.x = j;
        this.y = k;
        this.z = i;
    }
}