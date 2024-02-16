import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int n, result = 0;
        int[][] dp;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1][n + 2];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; j++) {
                dp[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] += Math.max(dp[i - 1][j], dp[i - 1][j - 1]);
            }
        }

        for (int i = 1; i <= n; i++) {
            if (result < dp[n][i])
                result = dp[n][i];
        }

        System.out.println(result);
    }
}