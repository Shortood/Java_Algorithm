import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_1904 {
    public static void main(String[] args) throws IOException {
        int N;
        int[][] dp;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[2][N + 1];

        dp[1][1] = 1;
        dp[1][0] = 1;

        for (int i = 2; i <= N; i++) {
            dp[0][i] = (dp[1][i - 2] + dp[0][i - 2]) % 15746;
            dp[1][i] = (dp[1][i - 1] + dp[0][i - 1]) % 15746;
        }

        System.out.println(((dp[0][N] % 15746) + (dp[1][N] % 15746)) % 15746);

    }
}