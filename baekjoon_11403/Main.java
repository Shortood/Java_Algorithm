import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int N;
    static boolean[] visit;

    static int flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        visit = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                flag = 0;
                Arrays.fill(visit, false);
                dfs(i, j);
                System.out.print(flag + " ");
            }
            System.out.println();
        }

    }

    static void dfs(int x, int y) {
        for (int i = 1; i <= N; i++) {
            if (map[x][i] == 1 && visit[i] == false) {
                if (i == y) {
                    flag = 1;
                    return;
                }
                visit[i] = true;
                dfs(i, y);
            }
        }

    }
}