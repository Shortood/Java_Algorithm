import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int M, N;
    static StringBuilder sb = new StringBuilder();
    static char[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        num = new char[2 * M];
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
            num[2 * cnt] = (char) (i + '0');
            num[2 * cnt + 1] = ' ';
            dfs(cnt + 1);
        }
    }
}