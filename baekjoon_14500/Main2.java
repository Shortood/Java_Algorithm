import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    static int[][] dx = { { 0, 0, 0 }, { 1, 2, 3 },
            { 0, 1, 1 },
            { 1, 2, 2 }, { 0, 0, -1 }, { 0, 1, 2 }, { 0, 0, 1 },
            { 1, 1, 2 }, { 0, -1, -1 },
            { 0, 0, 1 }, { 1, 1, 2 }, { 0, 0, -1 }, { 1, 1, 2 } },
            dy = { { 1, 2, 3 }, { 0, 0, 0 },
                    { 1, 0, 1 },
                    { 0, 0, 1 }, { 1, 2, 2 }, { 1, 1, 1 }, { 1, 2, 0 },
                    { 0, 1, 1 }, { 1, 1, 2 },
                    { 1, 2, 1 }, { 0, 1, 0 }, { 1, 2, 1 }, { -1, 0, 0 } };

    static int N, M;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int result = 0;
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                result = Math.max(result, cal(i, j));
            }
        }

        System.out.println(result);
    }

    static int cal(int x, int y) {
        int temp = 0;
        for (int i = 0; i < 13; i++) {
            int sum = map[x][y];
            for (int j = 0; j < 3; j++) {
                int nx = x + dx[i][j], ny = y + dy[i][j];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M)
                    sum += map[nx][ny];
                else {
                    sum = 0;
                    break;
                }
            }
            temp = Math.max(temp, sum);
        }
        return temp;
    }
}