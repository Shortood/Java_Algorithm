import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static StringBuilder sb = new StringBuilder();
    static char[] num;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        num = new char[2 * M];
        visit = new boolean[N + 1];
        dfs(0, 0);
        System.out.println(sb);
    }

    static void dfs(int cnt, int maxNum) {
        if (cnt == M) {
            num[2 * M - 1] = '\n';
            sb.append(num);
            return;
        }
        // 이전 수 보다 큰 수부터
        for (int i = maxNum + 1; i <= N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                num[cnt * 2] = (char) (i + '0');
                num[cnt * 2 + 1] = ' ';
                dfs(cnt + 1, i);
                visit[i] = false;
            }
        }
    }
}