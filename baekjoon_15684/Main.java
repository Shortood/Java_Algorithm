import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, H, result = 4;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[N + 1][H + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[b][a] = 1;
        }
        dfs(0, 1);

        if (result == 4)
            System.out.println(-1);
        else
            System.out.println(result);
    }

    static void dfs(int depth, int x) {
        if (depth > 3 || depth >= result)
            return;
        if (check()) {
            if (result > depth)
                result = depth;
            return;
        }

        for (int i = x; i < N; i++) {
            for (int j = 1; j <= H; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(depth + 1, i);
                    map[i][j] = 0;
                }
            }
        }
    }

    static boolean check() {
        for (int i = 1; i <= N; i++) {
            int now = i;
            for (int j = 1; j <= H; j++) {
                if (map[now][j] == 1) {
                    now++;
                } else if (map[now - 1][j] == 1) {
                    now--;
                }
            }
            if (now != i)
                return false;
        }
        return true;
    }

}