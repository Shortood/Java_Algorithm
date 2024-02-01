import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] state;
    static boolean[] visit;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        state = new int[N + 1][N + 1];
        visit = new boolean[N + 1];

        int u, v;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            state[u][v] = 1;
            state[v][u] = 1;
        }

        for (int i = 1; i <= N; i++) {
            if (visit[i] == false) {
                visit[i] = true;
                dfs(i);
                result++;
            }
        }
        System.out.println(result);
    }

    static void dfs(int s) {
        for (int i = 1; i <= N; i++) {
            if (state[s][i] == 1 && visit[i] == false) {
                visit[i] = true;
                dfs(i);
            }
        }
    }
}