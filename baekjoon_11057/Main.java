import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int N;
        int[][] dp;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp = new int[N + 1][10];
        for (int i = 0; i <= 9; i++)
            dp[1][i] = 1;

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k <= j; k++) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][k]) % 10007;
                }
            }
        }

        int result = 0;
        for (int i = 0; i <= 9; i++)
            result = (result + dp[N][i]) % 10007;

        System.out.println(result);

    }
}