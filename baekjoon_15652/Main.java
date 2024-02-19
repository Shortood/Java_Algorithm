import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static char[] num;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num = new char[2 * M];
        dfs(0, 1);
        System.out.println(sb);
    }

    static void dfs(int cnt, int pre) {
        if (cnt == M) {
            sb.append(num).append('\n');
            return;
        }

        for (int i = pre; i <= N; i++) {
            num[2 * cnt] = (char) (i + '0');
            num[2 * cnt + 1] = ' ';
            dfs(cnt + 1, i);
        }
    }
}