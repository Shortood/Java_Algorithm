import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int N, K;
        int[][] dp;
        String input;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        input = br.readLine();

        StringTokenizer st = new StringTokenizer(input);

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dp = new int[N + 1][K + 1];
        // n k = n-1 k + n-1 k-1
        // n n = 1, n 0 = 1
        dp[0][0] = 1;
        dp[1][0] = 1;

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= K; j++) {
                if (j == 0)
                    dp[i][j] = 1;
                else if (i == j)
                    dp[i][j] = 1;
                else if (j == 1)
                    dp[i][j] = i;
                else
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % 10007;
            }
        }

        System.out.println(dp[N][K]);
    }
}