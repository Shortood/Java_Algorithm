import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
    static int N, result1 = 0, result2 = 0;
    static int[] dx = { 1, -1, 0, 0 }, dy = { 0, 0, 1, -1 };
    static char[][] map1, map2;

    static char check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map1 = new char[N][N];
        map2 = new char[N][N];
        for (int i = 0; i < N; i++) {
            map1[i] = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                map2[i][j] = map1[i][j];
                if (map2[i][j] == 'R')
                    map2[i][j] = 'G';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map1[i][j] != 'D') {
                    check = map1[i][j];
                    map1[i][j] = 'D';
                    result1++;
                    dfs(i, j, map1);
                }
                if (map2[i][j] != 'D') {
                    check = map2[i][j];
                    map2[i][j] = 'D';
                    result2++;
                    dfs(i, j, map2);
                }
            }
        }
        System.out.println(result1 + " " + result2);

    }

    static void dfs(int x, int y, char[][] map) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < N && ny < N && map[nx][ny] == check) {
                map[nx][ny] = 'D';
                dfs(nx, ny, map);
            }
        }
    }

}