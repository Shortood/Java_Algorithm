import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static char[] num;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        num = new char[2 * M];
        visit = new boolean[N + 1];
        dfs(0);
        System.out.println(sb);
    }

    static void dfs(int cnt) {
        if (cnt == M) {
            num[2 * M - 1] = '\n';
            sb.append(num);
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (!visit[i]) {
                num[cnt * 2] = (char) (i + '0');
                num[cnt * 2 + 1] = ' ';
                visit[i] = true;
                dfs(cnt + 1);
                visit[i] = false;
            }

        }
    }
}