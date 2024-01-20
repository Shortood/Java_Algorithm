import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T, n;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            n = Integer.parseInt(br.readLine());
            dp = new int[2][n + 1];

            input = br.readLine();
            st = new StringTokenizer(input);
            for (int j = 1; j <= n; j++) {
                dp[0][j] = Integer.parseInt(st.nextToken());
            }

            input = br.readLine();
            st = new StringTokenizer(input);
            for (int j = 1; j <= n; j++) {
                dp[1][j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 2; j <= n; j++) {
                //두 가지 경우 비교
                dp[0][j] += Math.max(dp[1][j - 1], dp[1][j - 2]);
                dp[1][j] += Math.max(dp[0][j - 1], dp[0][j - 2]);
            }

            System.out.println(Math.max(dp[0][n], dp[1][n]));

        }

    }
}