import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R, C, result = 0;
    static int[] dx = { 1, -1, 0, 0 }, dy = { 0, 0, 1, -1 };
    static int[][] map;
    static boolean[] visit = new boolean[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        for (int i = 0; i < R; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < C; j++)
                map[i][j] = input[j] - 'A';
        }
        visit[map[0][0]] = true;
        sol(0, 0, 1);
        System.out.println(result);
    }

    static void sol(int x, int y, int cnt) {
        if (cnt > result)
            result = cnt;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < R && ny < C && visit[map[nx][ny]] == false) {
                visit[map[nx][ny]] = true;
                sol(nx, ny, cnt + 1);
                visit[map[nx][ny]] = false;
            }
        }

    }
}