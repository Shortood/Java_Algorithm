import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, result1 = 0, result2 = 0;
    static int[] dx = { 1, -1, 0, 0 }, dy = { 0, 0, 1, -1 };
    static char[][] map;
    static boolean[][] visit1, visit2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visit1 = new boolean[N][N];
        visit2 = new boolean[N][N];

        for (int i = 0; i < N; i++)
            map[i] = br.readLine().toCharArray();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visit1[i][j] == false) {
                    visit1[i][j] = true;
                    result1++;
                    dfsForNormal(i, j);
                }
                if (visit2[i][j] == false) {
                    visit2[i][j] = true;
                    result2++;
                    dfsForNotNormal(i, j);
                }
            }
        }
        System.out.println(result1 + " " + result2);

    }

    static void dfsForNormal(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < N && ny < N && map[nx][ny] == map[x][y] && visit1[nx][ny] == false) {
                visit1[nx][ny] = true;
                dfsForNormal(nx, ny);
            }
        }
    }

    static void dfsForNotNormal(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < N && ny < N && visit2[nx][ny] == false) {
                if ((map[x][y] == 'B' && map[x][y] == map[nx][ny]) || // 둘다 파랑
                        (map[x][y] != 'B' && map[nx][ny] != 'B')) { // 서로 적록
                    visit2[nx][ny] = true;
                    dfsForNotNormal(nx, ny);
                }
            }
        }
    }

}